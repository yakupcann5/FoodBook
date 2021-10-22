package com.example.besinlerkitabi.util

import com.example.besinlerkitabi.R

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.gorselIndir(url: String?, placeholder: CircularProgressDrawable){
    val option = RequestOptions().placeholder(placeholder).error(R.mipmap.ic_launcher_round)
    Glide.with(context).setDefaultRequestOptions(option).load(url).into(this)
}
fun placeholderYap(context : Context):CircularProgressDrawable{
    return  CircularProgressDrawable(context).apply {
        strokeWidth = 8f
        centerRadius= 40f
        start()
    }

}