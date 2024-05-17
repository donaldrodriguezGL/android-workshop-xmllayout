package com.gorillalogic.workshoplayout.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.gorillalogic.workshoplayout.R
import com.gorillalogic.workshoplayout.databinding.FragmentHomeScreenBinding
import com.gorillalogic.workshoplayout.view_model.ItemsViewModel

class HomeScreenFragment : Fragment() {

    //region - Properties
    private val itemsViewModel: ItemsViewModel by activityViewModels()
    //endregion

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val frameBinding = FragmentHomeScreenBinding.inflate(inflater, container, false)
        frameBinding.apply {
            // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
            lifecycleOwner = viewLifecycleOwner
            // Giving the binding access to the ViewModel
            viewModel = itemsViewModel
        }
        frameBinding.clientsRecyclerView.adapter = HomeAdapter {
            Log.d("HomeScreenFragment", "Item Selected ${getString(it.titleId)}")
            // Update selected item in the view model
            itemsViewModel.updateSelectedItem(it)
            // Navigate to details screen
            findNavController().navigate(R.id.action_homeScreenFragment_to_detailsScreenFragment)
        }
        return frameBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Fetch items
        itemsViewModel.fetchItems()
    }
}