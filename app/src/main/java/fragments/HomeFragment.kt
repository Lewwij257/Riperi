package fragments

import Adapters.MainMenuRecycler.MainMenuRecyclerViewAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.locaspes.riperi.R
import data.additional.HomeRecyclerData
import viewmodel.HomeFragmentViewModel


class HomeFragment : Fragment() {

    private lateinit var mainMenuRecyclerView: RecyclerView
    private lateinit var mainMenuRecyclerAdapter: MainMenuRecyclerViewAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val rvMainArrayList = HomeRecyclerData().getArrayList(this.requireContext())
        val homeFragmentViewModel = ViewModelProvider(this)[HomeFragmentViewModel::class.java]


        // Find the RecyclerView by ID in the inflated layout
        mainMenuRecyclerView = view.findViewById(R.id.rvMainMenu)

        // Set up the RecyclerView
        mainMenuRecyclerView.setHasFixedSize(true)
        mainMenuRecyclerAdapter = MainMenuRecyclerViewAdapter(rvMainArrayList) // Pass your actual data here
        mainMenuRecyclerView.adapter = mainMenuRecyclerAdapter
        mainMenuRecyclerView.layoutManager = LinearLayoutManager(context)

        return view
    }
}