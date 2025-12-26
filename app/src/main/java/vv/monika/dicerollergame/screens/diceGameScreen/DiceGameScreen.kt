package vv.monika.dicerollergame.screens.diceGameScreen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import vv.monika.dicerollergame.navigation.Routes

@Composable
fun DiceGameScreen(
    player01: String,
    player02: String,
    totalScore: Int,
    navController: NavHostController
) {

    Scaffold(
        topBar = {
            DiceGameTopBar( navController)
        }
    ) { innerPadding ->
//for scores of players
        var player01Score by remember { mutableStateOf(0) }
        var player02Score by remember { mutableStateOf(0) }
// for dice rolling
        var diceValue by remember { mutableStateOf(1) }
        var isPlayer1Turn by remember { mutableStateOf(true) }
        var isRolling by remember { mutableStateOf(false) }

//        for coroutines
        val scope = rememberCoroutineScope()
//        for animation
        val rotation = remember { Animatable(0f) }


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {

            Text(
                "Let's Play",
                fontSize = 30.sp,
                fontWeight = FontWeight.Black,
                fontFamily = FontFamily.Monospace
            )
            Spacer(modifier = Modifier.height(20.dp))
//            to display scores
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.Black,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .height(55.dp),
                contentAlignment = Alignment.Center,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        "$player01's Score: ${player01Score}",
                        color = Color.White,
                        fontSize = 16.sp

                    )
                    Text(
                        "$player02's Score: ${player02Score}",
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }
            }

//            to Display dice
            Spacer(modifier = Modifier.height(200.dp))
            Card(
//                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp),

                    horizontalArrangement = Arrangement.Center
                ) {
//                    Image(
//                        painter = painterResource(R.drawable.dice_05),
//                        contentDescription = "06 points",
//                    )

                    when(diceValue){
                        1 -> ScoreImage1()
                        2 -> ScoreImage2()
                        3 -> ScoreImage3()
                        4 -> ScoreImage4()
                        5 -> ScoreImage5()
                        else -> ScoreImage6()
                    }

                }

            }

            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
//                player 1 button
                Button(
                    onClick = {


                        if(!isRolling){
                            isRolling = true
                            scope.launch {
//                                animation
                                repeat(5){
                                    diceValue = (1..6).random()
                                    rotation.snapTo(0f)
                                    rotation.animateTo(180f, tween(50))
                                    delay(40)
                                }
                                diceValue = (1..6).random()
                                player01Score += diceValue

                                isPlayer1Turn = false
                                isRolling = false

                                if(diceValue == 6) isPlayer1Turn = true

                                if (player01Score >= totalScore ){
                                    navController.navigate(Routes.Winner(winnerName = player01 ))
                                    return@launch
                                }

                            }
                        }

                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black
                    ),
                    modifier = Modifier.weight(1f),
                    enabled = isPlayer1Turn,

                ) {
                    Text("P1: Roll Dice")
                }
                Spacer(modifier = Modifier.width(16.dp))
//                player 2
                Button(
                    onClick = {
                        if(!isRolling){
                            isRolling = true
                            scope.launch {
//                                animation
                                repeat(5){
                                    diceValue = (1..6).random()
                                    rotation.snapTo(0f)
                                    rotation.animateTo(180f, tween(50))
                                    delay(40)
                                }
                                diceValue = (1..6).random()
                                player02Score += diceValue

                                isPlayer1Turn = true
                                isRolling = false

                                if(diceValue == 6) isPlayer1Turn = false

                                if (player02Score >= totalScore ){
                                    navController.navigate(Routes.Winner(winnerName = player02))
                                    return@launch
                                }
                            }
                        }

                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black
                    ),
                    modifier = Modifier.weight(1f),
                    enabled = !isPlayer1Turn

                ) {
                    Text("P2: Roll Dice")
                }
            }

        }

    }

}