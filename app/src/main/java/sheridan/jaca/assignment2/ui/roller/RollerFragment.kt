package sheridan.jaca.assignment2.ui.roller

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import sheridan.jaca.assignment2.R
import sheridan.jaca.assignment2.databinding.FragmentRollerBinding

class RollerFragment : Fragment() {

    private lateinit var viewModel: RollerViewModel
    private lateinit var binding : FragmentRollerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRollerBinding.inflate(inflater,container,false)
        binding.btnRoll.setOnClickListener{rollDice()}

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RollerViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_roller,menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.menu_action_history -> {
                findNavController().navigate(R.id.action_global_to_history)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun rollDice(){

    }
}