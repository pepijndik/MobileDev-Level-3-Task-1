package nl.pdik.level3.madlevel3task1_gamerating

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import nl.pdik.level3.madlevel3task1_gamerating.ui.screens.GameRatingScreens
import nl.pdik.level3.madlevel3task1_gamerating.ui.screens.StartScreen
import nl.pdik.level3.madlevel3task1_gamerating.ui.theme.MadLevel3Task1GameRatingTheme
import nl.pdik.level3.madlevel3task1_gamerating.viewModel.GameViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MadLevel3Task1GameRatingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    GameRatingNavHost(navController,modifier = Modifier)
                }
            }
        }
    }
}


@Composable
private fun GameRatingNavHost(
    navController: NavHostController, modifier: Modifier
) {
    val viewModel: GameViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = GameRatingScreens.StartScreen.name,
        modifier = modifier
    ){
        composable(route = GameRatingScreens.RatingScreen.name)
        {

        }
        composable(GameRatingScreens.SummaryScreen.name) {

        }
        composable(GameRatingScreens.StartScreen.name) {
            StartScreen(navController)
        }
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MadLevel3Task1GameRatingTheme {

    }
}