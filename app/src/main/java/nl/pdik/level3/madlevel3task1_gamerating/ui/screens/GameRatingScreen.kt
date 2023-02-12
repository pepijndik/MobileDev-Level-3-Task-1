package nl.pdik.level3.madlevel3task1_gamerating.ui.screens

import android.widget.RatingBar
import androidx.compose.runtime.Composable
import com.gowtham.ratingbar.RatingBarConfig
import com.gowtham.ratingbar.RatingBarStyle
import nl.pdik.level3.madlevel3task1_gamerating.viewModel.GameViewModel

@Composable
fun GameRatingScreen(viewModel: GameViewModel){

    RatingBar(
        value = viewModel.gameRatingAccordingToUser,
        config = RatingBarConfig()
            .style(RatingBarStyle.HighLighted),
        onValueChange = {
            viewModel.gameRatingAccordingToUser.value = it;
        },
        onRatingChanged = {
            viewModel.gameRatingAccordingToUser = it;
        }
    )
}