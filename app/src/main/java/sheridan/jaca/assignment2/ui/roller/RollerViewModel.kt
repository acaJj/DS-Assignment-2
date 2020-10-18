package sheridan.jaca.assignment2.ui.roller

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sheridan.jaca.assignment2.database.GameScore
import sheridan.jaca.assignment2.database.GameScoreDao
import sheridan.jaca.assignment2.database.GameScoreDatabase


class RollerViewModel(application:Application) : AndroidViewModel(application) {
    // TODO: Implement the ViewModel

    private val gameScoreDao: GameScoreDao =
        GameScoreDatabase.getInstance(application).gameScoreDao

    fun send(gameScore: GameScore){
        viewModelScope.launch {
            gameScoreDao.insert(gameScore)
        }
    }
}