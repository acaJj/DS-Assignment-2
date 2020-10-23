package sheridan.jaca.assignment2.ui.history

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import sheridan.jaca.assignment2.R
import sheridan.jaca.assignment2.database.GameScore

import sheridan.jaca.assignment2.ui.history.dummy.DummyContent.DummyItem

/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class HistoryRecyclerViewAdapter(
    private val context: Context
) : RecyclerView.Adapter<HistoryRecyclerViewAdapter.ViewHolder>() {

    var gameHistory: List<GameScore>? = null
    set(value){
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_history_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = gameHistory!![position]
        val gameTotal = item.die1Score + item.die2Score + item.die3Score
        holder.idView.text = (position + 1).toString()
        holder.contentView.text =
            "${item.die1Score} " + "+ ${item.die2Score} " + "+ ${item.die3Score}" +
        " = ${gameTotal}"
    }

    override fun getItemCount(): Int = gameHistory?.size ?: 0

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idView: TextView = view.findViewById(R.id.item_number)
        val contentView: TextView = view.findViewById(R.id.content)

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }
}