package android.example.custombindingadapters.util

import android.content.Context
import android.content.res.ColorStateList
import android.example.custombindingadapters.Medal
import android.example.custombindingadapters.R
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.databinding.BindingAdapter

@BindingAdapter("app:Cheer")
fun getCheer(view: TextView, medal: Medal){
    val cheer = setCheer(medal, view.context)
    view.text = cheer
}

/**
 * called whenever attribute app:IconTint is called
 * receives a Medal level and sets the icon tint
 * according to that level
 */
@BindingAdapter("app:IconTint")
fun tintMedal(view: ImageView, medal: Medal){
    val color = getIconColor(medal, view.context)
    ImageViewCompat.setImageTintList(view, ColorStateList.valueOf(color))
}


private fun getIconColor(medal: Medal, context: Context): Int{
    return when (medal) {
        Medal.BADGE -> {
            ContextCompat.getColor(context, R.color.badge)
        }
        Medal.BRONZE -> {
            ContextCompat.getColor(context, R.color.bronze)
        }
        Medal.SILVER -> {
            ContextCompat.getColor(context, R.color.silver)
        }
        Medal.GOLD -> {
            ContextCompat.getColor(context, R.color.gold)
        }
        Medal.START -> {
            ContextCompat.getColor(context, R.color.purple_200)
        }
    }
}

private fun setCheer(medal: Medal, context: Context): String {

    return when (medal) {
        Medal.BADGE -> {
            context.getString(R.string.badge)
        }
        Medal.BRONZE -> {
            context.getString(R.string.bronze)
        }
        Medal.SILVER -> {
            context.getString(R.string.silver)
        }
        Medal.GOLD -> {
            context.getString(R.string.gold)
        }
        Medal.START -> {
            context.getString(R.string.start)
        }

    }
}