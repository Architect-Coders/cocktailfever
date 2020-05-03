package com.architect.g1.cocktailfever.ui.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import com.bumptech.glide.Glide

fun ViewGroup.inflate(@LayoutRes resource: Int, attachToRoot: Boolean = true): View =
    LayoutInflater.from(context).inflate(resource, this, attachToRoot)

fun ImageView.loadUrl(url: String) {
    Glide.with(this).load(url).into(this)
}