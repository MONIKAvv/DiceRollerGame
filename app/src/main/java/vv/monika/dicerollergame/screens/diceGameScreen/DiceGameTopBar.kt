package vv.monika.dicerollergame.screens.diceGameScreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import vv.monika.dicerollergame.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiceGameTopBar(navController: NavHostController) {

    TopAppBar(
        title = {
            Text(
                "Dice Rolling Game",
                fontWeight = FontWeight.Bold
            )
        },
        actions = {
            Button(
                onClick = { navController.navigate(Routes.PlayersName) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ),
                modifier = Modifier.padding(end = 16.dp)
            ) {
                Text("New Game")
            }
        }
    )
}