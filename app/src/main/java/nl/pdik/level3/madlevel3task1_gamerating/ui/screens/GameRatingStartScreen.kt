package nl.pdik.level3.madlevel3task1_gamerating.ui.screens

import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import nl.pdik.level3.madlevel3task1_gamerating.R
import nl.pdik.level3.madlevel3task1_gamerating.viewModel.GameViewModel

@Composable
fun StartScreen(navController: NavHostController, viewModel: GameViewModel) {

    Text(
        text = stringResource(id = R.string.welcome),
        style = MaterialTheme.typography.h2
    )
    Text(text = stringResource(id = R.string.click_start))
    Button(onClick = {
        viewModel.randomAssessableGame()
        navController.navigate("${GameRatingScreens.RatingScreen.name}")
    }) {
        Text(text = stringResource(id = R.string.start))
    }
}