package com.gorillalogic.workshoplayout.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gorillalogic.workshoplayout.datasource.LocalItemsDataSource
import com.gorillalogic.workshoplayout.model.ItemModel
import com.gorillalogic.workshoplayout.repository.LocalItemsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ItemsViewModel : ViewModel() {

    //region - Properties
    private val localItemsRepository by lazy {
        LocalItemsRepository(LocalItemsDataSource())
    }

    // Store the items data
    private val _items = MutableLiveData<List<ItemModel>>()
    val items: LiveData<List<ItemModel>> = _items

    // Store the selected item data
    private val _selectedItem = MutableLiveData<ItemModel>()
    val selectedItem: LiveData<ItemModel> = _selectedItem
    //endregion

    //region - Public methods
    fun fetchItems() {
        // Make request in background thread
        viewModelScope.launch {
            val itemsData = localItemsRepository.allItems()
            // Come back to main thread
            withContext(Dispatchers.Main) {
                _items.value = itemsData
            }
        }
    }

    fun updateSelectedItem(item: ItemModel) {
        _selectedItem.value = item
    }
    //endregion
}