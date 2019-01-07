package com.ammaryasser.inspiredemo.binding_adapters;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import androidx.databinding.BindingAdapter;

public class PicassoBindingAdapter {

    @BindingAdapter(value = {"url", "picasso"}, requireAll = true)
    public static void loadImage(ImageView view, String url, Picasso picasso) {
        picasso.load(url).into(view);
    }
}
