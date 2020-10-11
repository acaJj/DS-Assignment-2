package sheridan.jaca.assignment2.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Scores")
data class GameScore (
    @PrimaryKey(autoGenerate = true)
    var id: Long,

    @ColumnInfo(name="die1")
    val die1Score: Int,

    @ColumnInfo(name="die2")
    val die2Score: Int,

    @ColumnInfo(name="die3")
    val die3Score: Int
)