package sheridan.jaca.assignment2.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [GameScore::class], version = 1, exportSchema = false)
abstract class GameScoreDatabase: RoomDatabase() {
}