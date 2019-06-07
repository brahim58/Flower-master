package com.mohitinfo.mohit.flower;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.FlowerViewHolder> {

    private List<Flower> flowers;

    public FlowerAdapter(List<Flower> flowers) {
        this.flowers = flowers;
    }

    @NonNull
    @Override
    public FlowerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.flower_row,viewGroup,false);
        FlowerViewHolder holder = new FlowerViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FlowerViewHolder flowerViewHolder, int i) {
        String imageUrl = "http://services.hanselandpetal.com/photos/"+flowers.get(i).getPhoto();
        Picasso.get().load(imageUrl).into(flowerViewHolder.flowerImageIV);
        flowerViewHolder.flowerNameTV.setText(flowers.get(i).getName());
        flowerViewHolder.flowerCategoryTV.setText(flowers.get(i).getCategory());
        flowerViewHolder.flowerPriceTV.setText(flowers.get(i).getPrice().toString());

    }

    @Override
    public int getItemCount() {
        return  flowers == null ? 0 : flowers.size();
    }

    public class FlowerViewHolder extends RecyclerView.ViewHolder{

        ImageView flowerImageIV;
        TextView flowerNameTV, flowerCategoryTV, flowerPriceTV;

        public FlowerViewHolder(@NonNull final View itemView) {
            super(itemView);
            flowerImageIV = itemView.findViewById(R.id.iv_flower);
            flowerNameTV = itemView.findViewById(R.id.tv_flower_name);
            flowerCategoryTV = itemView.findViewById(R.id.tv_flower_category);
            flowerPriceTV = itemView.findViewById(R.id.tv_flower_price);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Context context = itemView.getContext();
                    context.startActivity(new Intent(context,FlowerDetails.class).putExtra("FlowerObj",flowers.get(position)));
                }
            });
        }

    }

}
