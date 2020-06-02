package com.elegantwizardry.uniontrade;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class HomePageAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<HomePage.Report> reportList;
    private MyClickListener myClickListener;

    public HomePageAdapter(Context context, List<HomePage.Report> reportList, MyClickListener myClickListener) {
        this.context = context;
        this.reportList = reportList;
        this.myClickListener = myClickListener;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);

        return new VirticleCellViewHolder(inflater.inflate(R.layout.homepage, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Drawable defaultImage = context.getResources().getDrawable(R.drawable.ic_avatar);
        String ImageUrl = reportList.get(position).getImage();

        VirticleCellViewHolder holder1 = (VirticleCellViewHolder) holder;
        holder1.reportTitle.setText(reportList.get(position).getTitle());
        holder1.reportPrice.setText(reportList.get(position).getPrice());

        if (ImageUrl != null) {
            ImageUrl = "http://unionint.net/" + ImageUrl;
            Glide.with(context)
                    .load(ImageUrl)
                    .centerCrop()
                    .placeholder(defaultImage)
                    .error(defaultImage)
                    .into(holder1.reportImageView);
        } else {
            Glide.with(context)
                    .load(defaultImage)
                    .centerCrop()
                    .error(defaultImage)
                    .into(holder1.reportImageView);
        }
    }

    @Override
    public int getItemCount() {
        return reportList.size();
    }

    class VirticleCellViewHolder extends RecyclerView.ViewHolder {
        private ImageView reportImageView;
        private TextView reportTitle;
        private TextView reportPrice;

        VirticleCellViewHolder(@NonNull View itemView) {
            super(itemView);

            reportImageView = itemView.findViewById(R.id.image);
            reportTitle = itemView.findViewById(R.id.title);
            reportPrice = itemView.findViewById(R.id.price);

            itemView.setOnClickListener(v -> {
                if (reportList != null && reportList.size() > 0) {
                    myClickListener.myOnClick(reportList.get(getAdapterPosition()));
                }
            });
        }
    }
}
