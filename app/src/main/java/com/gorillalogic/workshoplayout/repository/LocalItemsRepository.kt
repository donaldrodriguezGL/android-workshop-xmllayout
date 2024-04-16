package com.gorillalogic.workshoplayout.repository

import com.gorillalogic.workshoplayout.datasource.IItemsDataSource
import com.gorillalogic.workshoplayout.model.ItemModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalItemsRepository(
    private val dataSource: IItemsDataSource
): IItemsRepository {

    //region - IItemsRepository implementation
    override suspend fun allItems(): List<ItemModel> =
        withContext(Dispatchers.IO) {
            return@withContext dataSource.fetchItems()
        }
    //endregion
}