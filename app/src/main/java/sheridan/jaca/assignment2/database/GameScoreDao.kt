package sheridan.jaca.assignment2.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GameScoreDao {
    @Insert
    suspend fun insert(score: GameScore):Long

    @Query("SELECT * FROM scores WHERE id=:key")
    fun get(key:Long) : LiveData<GameScore>

    @Query("SELECT * FROM scores ORDER BY id")
    fun getAll(): LiveData<List<GameScore>>

    @Query("DELETE FROM scores")
    suspend fun deleteAll()
}