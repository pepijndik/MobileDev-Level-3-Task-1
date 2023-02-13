package nl.pdik.level3.madlevel3task1_gamerating.ui.screens

import android.widget.RatingBar
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.gowtham.ratingbar.RatingBarConfig
import com.gowtham.ratingbar.RatingBarStyle
import com.gowtham.ratingbar.StepSize
import nl.pdik.level3.madlevel3task1_gamerating.R
import nl.pdik.level3.madlevel3task1_gamerating.viewModel.GameViewModel
import com.gowtham.ratingbar.RatingBar
@Composable
fun GameRatingScreen(navController: NavHostController, viewModel: GameViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.app_name)) }
            )
        },
        content = {padding -> ScreenContent(Modifier.padding(padding),navController, viewModel)  }
    )

}
@Composable
private fun ScreenContent(modifier: Modifier,navController: NavHostController, viewModel: GameViewModel){
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

         Text(text = stringResource(id = R.string.rate_game), style = MaterialTheme.typography.subtitle1, fontWeight = FontWeight.Bold)
         Text(text = viewModel.randomlyChosenGame.value, style = MaterialTheme.typography.subtitle2)
         RatingBar(
             value = viewModel.gameRatingAccordingToUser.value,
             config = RatingBarConfig()
                 .stepSize(StepSize.HALF)
                 .style(RatingBarStyle.HighLighted),
             onValueChange = { viewModel.gameRatingAccordingToUser.value = it },
             onRatingChanged = { viewModel.gameRatingAccordingToUser.value = it }
         )
         Button(onClick = {
             navController.navigate(GameRatingScreens.SummaryScreen.name)
         }) {
             Text(text = stringResource(id = R.string.to_summary))
         }
    }
}

