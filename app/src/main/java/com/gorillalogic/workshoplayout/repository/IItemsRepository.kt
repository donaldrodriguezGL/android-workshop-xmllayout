package com.gorillalogic.workshoplayout.repository

import com.gorillalogic.workshoplayout.model.ItemModel

interface IItemsRepository {
    suspend fun allItems(): List<ItemModel>
}