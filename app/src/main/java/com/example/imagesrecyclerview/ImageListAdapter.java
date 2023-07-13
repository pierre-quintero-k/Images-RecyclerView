package com.example.imagesrecyclerview;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.imagesrecyclerview.databinding.ItemListBinding;

import java.util.List;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ImageListViewHolder> {
    private List<ClipData.Item> list;

    public ImageListAdapter(Context context, List<ClipData.Item> returnItemList) {
        this.list=returnItemList;
    }

    @NonNull
    @Override
    public ImageListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListBinding binding = ItemListBinding.inflate(LayoutInflater.from(parent.getContext()), parent,false);
        return new ImageListViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageListViewHolder holder, int position) {
        ClipData.Item item = list.get(position);
        holder.text_view.setText(item.getText().toString());
        Glide.with(holder.image_view).load(item.getHtmlText()).into(holder.image_view);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ImageListViewHolder extends RecyclerView.ViewHolder{
        public TextView text_view;
        public ImageView image_view;
        public ImageListViewHolder(ItemListBinding binding ) {
            super(binding.getRoot());
            text_view = binding.textView;
            image_view= binding.imageView;

        }
    }
}
