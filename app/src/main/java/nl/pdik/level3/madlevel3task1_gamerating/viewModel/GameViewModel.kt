package nl.pdik.level3.madlevel3task1_gamerating.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    // Randomly chosen game from a list of games.
    val randomlyChosenGame = mutableStateOf(String())

    // Rating provided by the user.
    // Initial value is 5 star rating (5 floating)
    var gameRatingAccordingToUser: MutableState<Float> = mutableStateOf(5f)

    fun randomAssessableGame() {
        randomlyChosenGame.value = listOf(
            "Red Dead Redemption 2", "Rocket League", "Shadow of the Tombraider","The days","GTA IV"
        ).random()
    }

    fun reset() {
        randomlyChosenGame.value = String()
        gameRatingAccordingToUser.value = 5f
    }
}