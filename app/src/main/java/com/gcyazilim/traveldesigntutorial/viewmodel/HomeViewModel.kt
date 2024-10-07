package com.gcyazilim.traveldesigntutorial.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gcyazilim.traveldesigntutorial.base.models.CategoryModel
import com.gcyazilim.traveldesigntutorial.base.models.ItemModel

class HomeViewModel : ViewModel() {
    val popularList = MutableLiveData<List<ItemModel>>()
    val categoryList = MutableLiveData<List<CategoryModel>>()

    init {
        setCategoryList()
        setPopularList()
    }

    private fun setCategoryList() {
        val tempList = arrayListOf<CategoryModel>()
        tempList.add(CategoryModel("Beaches", "cat1"))
        tempList.add(CategoryModel("Camps", "cat2"))
        tempList.add(CategoryModel("Forest", "cat3"))
        tempList.add(CategoryModel("Desert", "cat4"))
        tempList.add(CategoryModel("Mountain", "cat5"))
        categoryList.value = tempList
    }

    private fun setPopularList() {
        val tempList = arrayListOf<ItemModel>()
        tempList.add(
            ItemModel(
                "Mar caible, avendia lago",
                "Miami Beach",
                "This 2 bed /1 bath home boasts an enormous, open-living plan, accented by striking architectural featured and high-end finished. Feel inspired by open sight lines that embrace the outdoors, crowned by stunning coffered ceilings. This 2 bed /1 bath home boasts an enormous, open-living plan, accented by striking architectural featured and high-end finished. Feel inspired by open sight lines that embrace the outdoors, crowned by stunning coffered ceilings. This 2 bed /1 bath home boasts an enormous, open-living plan, accented by striking architectural featured and high-end finished. Feel inspired by open sight lines that embrace the outdoors, crowned by stunning coffered ceilings. This 2 bed /1 bath home boasts an enormous, open-living plan, accented by striking architectural featured and high-end finished. Feel inspired by open sight lines that embrace the outdoors, crowned by stunning coffered ceilings. This 2 bed /1 bath home boasts an enormous, open-living plan, accented by striking architectural featured and high-end finished. Feel inspired by open sight lines that embrace the outdoors, crowned by stunning coffered ceilings. This 2 bed /1 bath home boasts an enormous, open-living plan, accented by striking architectural featured and high-end finished. Feel inspired by open sight lines that embrace the outdoors, crowned by stunning coffered ceilings.",
                2,
                true,
                4.8,
                "pic1",
                true,
                1450
            )
        )
        tempList.add(
            ItemModel(
                "Passo Rolle",
                "Hawaii Beach",
                "This 2 bed /1 bath home boasts an enormous, open-living plan, accented by striking architectural featured and high-end finished. Feel inspired by open sight lines that embrace the outdoors, crowned by stunning coffered ceilings.",
                2,
                false,
                4.8,
                "pic2",
                true,
                1350
            )
        )
        tempList.add(
            ItemModel(
                "Mar caible, avendia lago",
                "Miami Beach",
                "This 2 bed /1 bath home boasts an enormous, open-living plan, accented by striking architectural featured and high-end finished. Feel inspired by open sight lines that embrace the outdoors, crowned by stunning coffered ceilings.",
                1,
                false,
                4.8,
                "pic3",
                false,
                1100
            )
        )
        popularList.value = tempList
    }

}