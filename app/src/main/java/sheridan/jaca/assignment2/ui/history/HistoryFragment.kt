package sheridan.jaca.assignment2.ui.history

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import sheridan.jaca.assignment2.R
import sheridan.jaca.assignment2.databinding.FragmentHistoryBinding
import sheridan.jaca.assignment2.ui.history.dummy.DummyContent

/**
 * A fragment representing a list of Items.
 */
class HistoryFragment : Fragment() {
    private lateinit var binding : FragmentHistoryBinding
    private val viewModel: HistoryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(inflater,container,false)
        val view = inflater.inflate(R.layout.fragment_history, container, false)

        with(binding){
            // Set the adapter
            val recyclerView = binding.historyRecyclerView
            val adapter = HistoryRecyclerViewAdapter(view.context)
            recyclerView.adapter = adapter
            //observe gameHistory list in view model and calculate the current total based on all game results
            viewModel.gameHistory.observe(viewLifecycleOwner){
                adapter.gameHistory = it
                var historyTotal = 0
                for (score in it){
                    val gameTotal = score.die3Score + score.die1Score + score.die2Score
                    historyTotal += gameTotal
                }
                binding.historyTotal.text = "Total: ${historyTotal}"
            }
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_history,menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.menu_action_clear -> {
                viewModel.clear()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    //used for factory
    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            HistoryFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}