package vv.monika.dicerollergame.screens.diceGameScreen

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import vv.monika.dicerollergame.R

@Composable
fun ScoreImage1(modifier: Modifier = Modifier) {
    Image(painter = painterResource(R.drawable.dice_01),
        contentDescription = "1 Point")

    
}
@Composable
fun ScoreImage2(modifier: Modifier = Modifier) {
    Image(painter = painterResource(R.drawable.dice_02),
        contentDescription = "2 Point")


}
@Composable
fun ScoreImage3(modifier: Modifier = Modifier) {
    Image(painter = painterResource(R.drawable.dice_03),
        contentDescription = "3 Point")


}
@Composable
fun ScoreImage4(modifier: Modifier = Modifier) {
    Image(painter = painterResource(R.drawable.dice_04),
        contentDescription = "4 Point")


}
@Composable
fun ScoreImage5(modifier: Modifier = Modifier) {
    Image(painter = painterResource(R.drawable.dice_05),
        contentDescription = "5 Point")


}
@Composable
fun ScoreImage6(modifier: Modifier = Modifier) {
    Image(painter = painterResource(R.drawable.dice_06),
        contentDescription = "6 Point")


}