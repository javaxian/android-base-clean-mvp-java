package com.javaxian.cleanarchitecture.mvpjava.presentation.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.javaxian.cleanarchitecture.mvpjava.R;
import com.javaxian.cleanarchitecture.mvpjava.domain.base.BaseHolder;
import com.javaxian.cleanarchitecture.mvpjava.domain.callback.OnItemRecyclerClickListener;
import com.javaxian.cleanarchitecture.mvpjava.domain.entity.EntityExample;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainRecycler extends RecyclerView.Adapter<BaseHolder> {

    private Context context;
    private ArrayList<EntityExample> data;
    private OnItemRecyclerClickListener listener;

    public MainRecycler(Context context, ArrayList<EntityExample> data, OnItemRecyclerClickListener listener) {

        this.context = context;
        this.data = data;
        this.listener = listener;
    }

    public void setOnItemRecyclerClickListener(
            OnItemRecyclerClickListener<EntityExample> listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public BaseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_main_item, parent, false);

        return new MainRecycler.ContentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseHolder holder, int position) {
        ContentHolder contentHolder = (ContentHolder) holder;

        contentHolder.itemTitle.setText(data.get(position).getParam1());
        contentHolder.itemDescription.setText(data.get(position).getParam2());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    protected class ContentHolder extends BaseHolder{

        @BindView(R.id.recycler_main_item_title)
        TextView itemTitle;
        @BindView(R.id.recycler_main_item_description)
        TextView itemDescription;

        public ContentHolder(View view) {

            super(view);

            ButterKnife.bind(this, view);
            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.entity_example_view_item:
                    if (listener != null) {
                        EntityExample entity = data.get(getAdapterPosition());
                        listener.onItemRecyclerClick(v, getAdapterPosition(), entity);
                    }
                default:
            }
        }
    }
}
