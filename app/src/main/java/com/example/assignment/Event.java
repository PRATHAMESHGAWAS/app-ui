package com.example.assignment;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import static android.graphics.Typeface.BOLD;

public class Event {
    private String title;
    private String location;
    private int price;
    private int imgUrl;
    private String date;

    public Event(String title, String location, int price, int imgUrl, String date) {
        this.title = title;
        this.location = location;
        this.price = price;
        this.imgUrl = imgUrl;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public String getPrice() {
        return "Rs " + price;
    }

    public int getImgUrl() {
        return imgUrl;
    }

    public SpannableString getDate() {
        date = date.replace(" ","\n");
        SpannableString resultString = new SpannableString(date);
        resultString.setSpan(new StyleSpan(BOLD),4,6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        resultString.setSpan(new RelativeSizeSpan(1.5f),4,6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return resultString;
    }

    @BindingAdapter("android:src")
    public static void getImgUrl(ImageView imageView,int imgId) {
        imageView.setImageResource(imgId);
        imageView.setClipToOutline(true);
    }
}


