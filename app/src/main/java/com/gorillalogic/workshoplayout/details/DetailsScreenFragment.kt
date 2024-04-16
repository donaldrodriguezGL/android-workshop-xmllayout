package com.gorillalogic.workshoplayout.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.gorillalogic.workshoplayout.databinding.FragmentDetailsScreenBinding
import com.gorillalogic.workshoplayout.view_model.ItemsViewModel

class DetailsScreenFragment : Fragment() {

    //region - Properties
    private val itemsViewModel: ItemsViewModel by activityViewModels()
    //endregion

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val frameBinding = FragmentDetailsScreenBinding.inflate(
            inflater,
            container,
            false
        )
        frameBinding.apply {
            // Allows Data Binding to Observe LiveData
            // with the lifecycle of this Fragment
            lifecycleOwner = viewLifecycleOwner
            // Giving the binding access to the ViewModel
            selectedItem = itemsViewModel.selectedItem.value
        }
        return frameBinding.root
    }
}