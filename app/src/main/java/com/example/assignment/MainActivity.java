package com.example.assignment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.assignment.databinding.ActivityMainBinding;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Adapter adapter;
    int[] sampleImages = {R.drawable.carou1, R.drawable.carou2, R.drawable.carou3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        setSupportActionBar(activityMainBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        setData();
        activityMainBinding.recyclerView.setAdapter(adapter);

        activityMainBinding.carousel.setPageCount(sampleImages.length);
        activityMainBinding.carousel.setImageListener(imageListener);
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

    private void setData() {
        List<Event> events = new ArrayList<>();
        events.add(new Event("The NCPA National Jazz Festival- The Latination and Kevin Davy Quintet",
                "Tata Theatre: The NCPA",
                269,R.drawable.pic1,"NOV 10"));
        events.add(new Event("Sanjeeta Bhattacharya Live at the Finch",
                "Tata Theatre: The NCPA",
                389,R.drawable.pic2,"NOV 17"));
        events.add(new Event("The NCPA International Jazz Festival- Greg Banaszak Quintet and Jam Session",
                "Tata Theatre: The NCPA",
                269,R.drawable.pic3,"NOV 21"));
        events.add(new Event("Freddie Quicksliver Live at the Finch",
                "Tata Theatre: The NCPA",
                900,R.drawable.pic4,"NOV 23"));
        events.add(new Event("The NCPA National Jazz Festival- The Latination and Kevin Davy Quintet",
                "Tata Theatre: The NCPA",
                269,R.drawable.pic5,"NOV 24"));
        adapter = new Adapter(events);
    }

}