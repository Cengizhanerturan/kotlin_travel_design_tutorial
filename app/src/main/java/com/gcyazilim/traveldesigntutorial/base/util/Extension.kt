package com.gcyazilim.traveldesigntutorial.base.util

import android.graphics.Bitmap
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.Transformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners
import java.text.DecimalFormat

@BindingAdapter(value = ["imageResource", "isCenterCrop", "isRounded"], requireAll = false)
fun ImageView.bindImageFromDrawable(
    drawableName: String?,
    isCenterCrop: Boolean = false,
    isRounded: Boolean = false
) {
    drawableName?.let {
        val context = this.context
        val resId = context.resources.getIdentifier(drawableName, "drawable", context.packageName)
        var glideRequest = Glide.with(context).load(resId)

        val transformations = mutableListOf<Transformation<Bitmap>>()

        if (isCenterCrop) {
            transformations.add(CenterCrop())
        }

        if (isRounded) {
            transformations.add(GranularRoundedCorners(40F, 40F, 40F, 40F))
        }

        if (transformations.isNotEmpty()) {
            glideRequest = glideRequest.transform(MultiTransformation(transformations))
        }

        glideRequest.into(this)
    }
}

@BindingAdapter("formattedMoneyText")
fun TextView.setFormattedMoneyText(value: Double) {
    val decimalFormat = DecimalFormat("#,###.##")
    val formattedNumber = decimalFormat.format(value)
    "$$formattedNumber".also { this.text = it }
}

