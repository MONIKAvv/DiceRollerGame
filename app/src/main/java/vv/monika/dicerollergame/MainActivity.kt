package vv.monika.dicerollergame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import vv.monika.dicerollergame.navigation.Routes
import vv.monika.dicerollergame.screens.PlayerNameScreen.PlayerNameScreen
import vv.monika.dicerollergame.screens.diceGameScreen.DiceGameScreen
import vv.monika.dicerollergame.screens.winnerScreen.WinnerScreen
import vv.monika.dicerollergame.ui.theme.DiceRollerGameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceRollerGameTheme {

//                we can also create here navController and navHost
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Routes.PlayersName
                ) {

                    composable<Routes.PlayersName> {
                        PlayerNameScreen(navController)
                    }

                    composable<Routes.DiceGame> { backStackEntry ->

                        val args = backStackEntry.toRoute<Routes.DiceGame>()
                        DiceGameScreen(args.player01, args.player02, args.totalScore, navController)
                    }

                    composable <Routes.Winner>{ backStackEntry ->
                        val args = backStackEntry.toRoute<Routes.Winner>()
                        WinnerScreen(args.winnerName,

                            navController)
                    }

                }

            }
        }
    }
}
