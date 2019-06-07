package com.mohitinfo.mohit.flower;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class FlowerDetails extends AppCompatActivity {

    ImageView flowerImageIV;
    TextView flowerNameTV, flowerPriceTV, flowerCategoryTV, flowerInstructionTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flower_details);

        flowerImageIV = findViewById(R.id.iv_flower_details);
        flowerNameTV = findViewById(R.id.tv_flower_name_details);
        flowerPriceTV = findViewById(R.id.tv_flower_price_details);
        flowerCategoryTV = findViewById(R.id.tv_flower_category_details);
        flowerInstructionTV = findViewById(R.id.tv_flower_instruction_details);

        Intent intent = getIntent();
        Flower flower = (Flower) intent.getSerializableExtra("FlowerObj");


        String imageUrl = "http://services.hanselandpetal.com/photos/"+flower.getPhoto();
        Picasso.get().load(imageUrl).into(flowerImageIV);

        flowerNameTV.setText("Name: "+flower.getName());
        flowerPriceTV.setText("Price: "+flower.getPrice().toString());
        flowerCategoryTV.setText("Category: "+flower.getCategory());
        flowerInstructionTV.setText("Instruction:\n "+flower.getInstructions());
    }
}
