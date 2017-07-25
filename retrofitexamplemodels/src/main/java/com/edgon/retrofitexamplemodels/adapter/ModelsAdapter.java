package com.edgon.retrofitexamplemodels.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.edgon.retrofitexamplemodels.R;
import com.edgon.retrofitexamplemodels.models.Models;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by gonza on 7/21/2017.
 */

public class ModelsAdapter extends RecyclerView.Adapter<ModelsAdapter.ModelsViewHolder>{
    List<Models> listModels;


    public ModelsAdapter(List<Models> listModels) {
        this.listModels = listModels;

    }

    @Override
    public ModelsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list,parent,false);

        return new ModelsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ModelsViewHolder holder, int position) {
        Models model = listModels.get(position);
        holder.txtTitle.setText(model.getTitle());
        holder.txtPublished.setText(model.getPublishedAt());
        holder.txtComent.setText(model.getComment());

        Picasso.with(holder.context)
                .load(model.getPicture())
                .into(holder.imgPicture);
    }

    @Override
    public int getItemCount() {
        return listModels.size();
    }

    public class ModelsViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgPicture;
        private TextView txtTitle;
        private TextView txtPublished;
        private TextView txtComent;
        Context context;

        public ModelsViewHolder(View itemView) {
            super(itemView);

            imgPicture = (ImageView) itemView.findViewById(R.id.img_picture);
            txtTitle = (TextView) itemView.findViewById(R.id.txt_title);
            txtPublished = (TextView) itemView.findViewById(R.id.txt_published);
            txtComent = (TextView) itemView.findViewById(R.id.txt_comment);
            context = itemView.getContext();

        }
    }

}
