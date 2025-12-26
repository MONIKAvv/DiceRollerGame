package vv.monika.dicerollergame.screens.PlayerNameScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import vv.monika.dicerollergame.R
import vv.monika.dicerollergame.navigation.Routes


@Composable
fun PlayerNameScreen(navController: NavHostController) {

    var player01Name by remember { mutableStateOf("") }
    var player02Name by remember { mutableStateOf("") }
    var selectedScore by remember { mutableStateOf(50) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(R.drawable.dice_logo),
            contentDescription = "Game Logo"
        )

        Spacer(modifier = Modifier.height(50.dp))
        OutlinedTextField(
            value = player01Name,
            onValueChange = { if (it.length <= 8) player01Name = it },
            label = { Text("Player 01 Name") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black,
                focusedLabelColor = Color.Gray,
                unfocusedLabelColor = Color.Gray,
                cursorColor = Color.Black,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black
            )
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = player02Name,
            onValueChange = { if (it.length <= 8) player02Name = it },
            label = { Text("Player 02 Name") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black,
                focusedLabelColor = Color.Gray,
                unfocusedLabelColor = Color.Gray,
                cursorColor = Color.Black,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black
            )
        )
        Spacer(modifier = Modifier.height(30.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 30.dp)
            ) {
                Text(
                    "Select Score",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(40.dp)
                            .background(
                                color = if (selectedScore == 50) Color.Black else Color.LightGray,
                                shape = RoundedCornerShape(30.dp)
                            )
                            .clickable { selectedScore = 50 },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "50",
                            color = if (selectedScore == 50) Color.White else Color.Gray,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(40.dp)
                            .background(
                                color = if (selectedScore == 100) Color.Black else Color.LightGray,
                                shape = RoundedCornerShape(30.dp)
                            )
                            .clickable { selectedScore = 100 },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "100",
                            color = if (selectedScore == 100) Color.White else Color.Gray,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = { navController.navigate(Routes.DiceGame(player01Name, player02Name, totalScore = selectedScore)) },
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(55.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            ),
            shape = RoundedCornerShape(8.dp),
            enabled = player01Name.isNotBlank() && player02Name.isNotBlank() && player01Name != player02Name
        ) {
            Text(
                "START GAME",
                fontSize = 16.sp
            )
        }
    }

}




