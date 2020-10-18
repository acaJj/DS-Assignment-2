package sheridan.jaca.assignment2.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GameScoreDao {
    @Insert
    suspend fun insert(score: GameScore)

    @Query("SELECT * FROM scores ORDER BY id")
    fun getAll(): LiveData<List<GameScore>>

    @Query("DELETE FROM scores")
    suspend fun deleteAll()
}