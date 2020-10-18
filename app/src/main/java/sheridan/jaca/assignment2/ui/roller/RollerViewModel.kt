package sheridan.jaca.assignment2.ui.roller

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class RollerViewModel(application:Application) : AndroidViewModel(application) {
    // TODO: Implement the ViewModel
    private val _scoreId = MutableLiveData<Long?>().apply { value = null }

    val scoreId: LiveData<Long?> = _scoreId

    private val gameScoreDao:
}