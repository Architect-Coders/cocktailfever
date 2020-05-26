package com.architect.g1.cocktailfever.ui.common

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlin.properties.Delegates
import com.architect.g1.cocktailfever.CoctelApp

val Context.app: CoctelApp
    get() = applicationContext as CoctelApp

fun ViewGroup.inflate(@LayoutRes resource: Int, attachToRoot: Boolean = true): View =
    LayoutInflater.from(context).inflate(resource, this, attachToRoot)

fun ImageView.loadUrl(url: String) {
    Glide.with(this).load(url).into(this)
}
inline fun <VH : RecyclerView.ViewHolder, T> RecyclerView.Adapter<VH>.basicDiffUtil(
    initialValue: List<T>,
    crossinline areItemsTheSame: (T, T) -> Boolean = { old, new -> old == new },
    crossinline areContentsTheSame: (T, T) -> Boolean = { old, new -> old == new }
) =
    Delegates.observable(initialValue) { _, old, new ->
        DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                areItemsTheSame(old[oldItemPosition], new[newItemPosition])

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                areContentsTheSame(old[oldItemPosition], new[newItemPosition])

            override fun getOldListSize(): Int = old.size

            override fun getNewListSize(): Int = new.size
        }).dispatchUpdatesTo(this@basicDiffUtil)
    }

inline fun <reified T : Activity> Context.startActivity() {
    val intent=Intent(this, T::class.java)
    startActivity(intent)
}

inline fun <reified T : Activity> Context.startActivity(body: Intent.() -> Unit) {
    val intent=Intent(this, T::class.java).apply(body)
    startActivity(intent)
}