package com.gorillalogic.workshoplayout.datasource

import com.gorillalogic.workshoplayout.R
import com.gorillalogic.workshoplayout.model.ItemModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalItemsDataSource : IItemsDataSource {

    //region - IItemsDataSource implementation
    override suspend fun fetchItems(): List<ItemModel> =
        withContext(Dispatchers.IO) {
            // Return local data
            return@withContext listOf<ItemModel>(
                ItemModel(
                    R.drawable.annual_education_bonus,
                    R.string.title_annual_education_bonus,
                    R.string.desc_annual_education_bonus
                ),
                ItemModel(
                    R.drawable.private_healthcare,
                    R.string.title_private_healthcare,
                    R.string.desc_private_healthcare
                ),
                ItemModel(
                    R.drawable.gorilla_log_culture,
                    R.string.title_gorilla_logic_culture,
                    R.string.desc_gorilla_logic_culture
                ),
                ItemModel(
                    R.drawable.learn,
                    R.string.title_learn,
                    R.string.desc_learn
                ),
                ItemModel(
                    R.drawable.professional_development,
                    R.string.title_professional_development,
                    R.string.desc_professional_development
                ),
                ItemModel(
                    R.drawable.work_from_anywhere,
                    R.string.title_work_anywhere,
                    R.string.desc_work_anywhere
                )
            )
        }
    //endregion
}