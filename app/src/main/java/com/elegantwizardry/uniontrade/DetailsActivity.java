package com.elegantwizardry.uniontrade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ImageView reportImageView = findViewById(R.id.image2);
        TextView reportTitle = findViewById(R.id.title2);
        TextView reportPrice = findViewById(R.id.price2);

        if (getIntent() != null) {
            HomePage.Report report = (HomePage.Report) getIntent().getSerializableExtra("key_data");

            if (report != null) {
                reportTitle.setText(report.getTitle());
                reportPrice.setText(report.getPrice());

                if (report.getImage() != null) {
                    String ImageUrl = "http://unionint.net/" + report.getImage();
                    Glide.with(this)
                            .load(ImageUrl)
                            .centerCrop()
                            .into(reportImageView);
                }
            }
        }
    }
}
