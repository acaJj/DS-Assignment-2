package sheridan.jaca.assignment2.ui.roller

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import sheridan.jaca.assignment2.R
import sheridan.jaca.assignment2.database.GameScore
import sheridan.jaca.assignment2.databinding.FragmentRollerBinding
import kotlin.random.Random

class RollerFragment : Fragment() {

    private val viewModel: RollerViewModel by viewModels()
    private lateinit var binding : FragmentRollerBinding

    private val DIE_1 : String = "DIE_1"
    private val DIE_2 : String = "DIE_2"
    private val DIE_3 : String = "DIE_3"

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

        if(savedInstanceState != null){
            binding.txtDie1.text = savedInstanceState.getString(DIE_1)
            binding.txtDie2.text = savedInstanceState.getString(DIE_2)
            binding.txtDie3.text = savedInstanceState.getString(DIE_3)
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
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

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("DIE_1",binding.txtDie1.text.toString())
        outState.putString("DIE_2",binding.txtDie2.text.toString())
        outState.putString("DIE_3",binding.txtDie3.text.toString())
        super.onSaveInstanceState(outState)
    }

    private fun rollDice(){
        val die1Value = Random.nextInt(1,6)
        val die2Value = Random.nextInt(1,6)
        val die3Value = Random.nextInt(1,6)
        binding.txtDie1.text = die1Value.toString()
        binding.txtDie2.text = die2Value.toString()
        binding.txtDie3.text = die3Value.toString()

        //upload results to db
        viewModel.send(GameScore(0,die1Value,die2Value,die3Value))
    }
}