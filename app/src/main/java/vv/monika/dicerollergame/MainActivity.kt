package vv.monika.dicerollergame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import vv.monika.dicerollergame.screens.PlayerNameScreen.PlayerName
import vv.monika.dicerollergame.ui.theme.DiceRollerGameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceRollerGameTheme {

                PlayerName()

            }
        }
    }
}
