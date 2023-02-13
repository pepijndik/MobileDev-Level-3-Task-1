package nl.pdik.level3.madlevel3task1_gamerating.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import nl.pdik.level3.madlevel3task1_gamerating.R
import nl.pdik.level3.madlevel3task1_gamerating.viewModel.GameViewModel

@Composable
fun StartScreen(navController: NavHostController, viewModel: GameViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.app_name)) }
            )
        },
        content = { padding ->
            StartScreenContent(
                Modifier.padding(padding),
                navController,
                viewModel
            )
        }
    )
}

@Composable
fun StartScreenContent(
    modifier: Modifier,
    navController: NavHostController,
    viewModel: GameViewModel
) {

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.welcome),
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold
        )
        Text(text = stringResource(id = R.string.click_start))
        Button(onClick = {
            viewModel.randomAssessableGame()
            navController.navigate("${GameRatingScreens.RatingScreen.name}")
        }) {
            Text(text = stringResource(id = R.string.start))
        }

    }


}