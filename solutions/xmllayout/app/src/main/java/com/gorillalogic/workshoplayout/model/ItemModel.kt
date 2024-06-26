package com.gorillalogic.workshoplayout.model

import com.gorillalogic.workshoplayout.R

data class ItemModel(
    val imageResourceId: Int,
    val titleId: Int,
    val descriptionId: Int
) {
    //region - Companion object
    companion object {
        /**
         * Make a list of ItemModel instances generated at random
         * @param count list size
         * @return list of random ItemsModel instances
         */
        fun randomItems(count: Int = 10): List<ItemModel> {
            val list = mutableListOf<ItemModel>()
            for (i in 1..count) {
                list.add(randomItem)
            }
            return list
        }

        /**
         * Generate a random ItemModel instance
         */
        private val randomItem: ItemModel
            get() {
                val images = listOf(
                    R.drawable.annual_education_bonus,
                    R.drawable.work_from_anywhere,
                    R.drawable.gorilla_log_culture,
                    R.drawable.professional_development,
                    R.drawable.learn,
                    R.drawable.annual_education_bonus
                )
                val titles = listOf(
                    R.string.title_private_healthcare,
                    R.string.title_work_anywhere,
                    R.string.title_gorilla_logic_culture,
                    R.string.title_professional_development,
                    R.string.title_learn,
                    R.string.title_annual_education_bonus
                )
                val descriptions = listOf(
                    R.string.desc_private_healthcare,
                    R.string.desc_work_anywhere,
                    R.string.desc_gorilla_logic_culture,
                    R.string.desc_professional_development,
                    R.string.desc_learn,
                    R.string.desc_annual_education_bonus
                )
                return ItemModel(
                    images.random(),
                    titles.random(),
                    descriptions.random()
                )
            }
        //endregion
    }
}
