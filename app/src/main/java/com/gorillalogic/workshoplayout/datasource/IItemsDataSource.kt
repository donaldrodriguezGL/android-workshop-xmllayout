package com.gorillalogic.workshoplayout.datasource

import com.gorillalogic.workshoplayout.model.ItemModel

interface IItemsDataSource {
    suspend fun fetchItems(): List<ItemModel>
}