package sheridan.jaca.assignment2.ui.history

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sheridan.jaca.assignment2.database.GameScore
import sheridan.jaca.assignment2.database.GameScoreDao
import sheridan.jaca.assignment2.database.GameScoreDatabase

class HistoryViewModel(application: Application): AndroidViewModel(application){
    private val gameScoreDao: GameScoreDao =
        GameScoreDatabase.getInstance(application).gameScoreDao

    val gameHistory: LiveData<List<GameScore>> = gameScoreDao.getAll()

    fun clear(){
        viewModelScope.launch {
            gameScoreDao.deleteAll()
        }
    }
}