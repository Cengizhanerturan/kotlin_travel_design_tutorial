package com.gcyazilim.traveldesigntutorial.base.models

import java.io.Serializable

data class ItemModel(
    var title: String,
    var location: String,
    var description: String,
    var bed: Int,
    var guide: Boolean,
    var score: Double,
    var pic: String,
    var wifi: Boolean,
    var price: Int
) : Serializable