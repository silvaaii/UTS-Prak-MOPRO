package com.silvaailina.laguku.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.silvaailina.laguku.R;
import com.silvaailina.laguku.model.LaguModel;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class LaguAdapter extends
        RecyclerView.Adapter<LaguAdapter.MyViewHolder> {
    List<LaguModel> listItem;
    TextView tvJudul,tvPenyanyi,tvGenre;
    View view;
    private Context ctx;
    private OnItemClickListener mOnItemClickListener;
    public interface OnItemClickListener {
        void onClick(int position);
    }
    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }
    public LaguAdapter(Context ctx) {
        this.ctx = ctx;
        listItem = new ArrayList<>();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View v) {
            super(v);
        }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_lagu, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        LaguModel item = listItem.get(position);
        tvJudul = holder.itemView.findViewById(R.id.txt_name_judul);
        tvPenyanyi = holder.itemView.findViewById(R.id.txt_penyanyi);
        tvGenre = holder.itemView.findViewById(R.id.txt_genre);
        tvJudul.setText(item.getJudul());
        tvPenyanyi.setText(item.getPenyanyi());
        tvGenre.setText(item.getGenre());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onClick(position);
            }
        });
    }
    @Override
    public int getItemCount() {
        return listItem.size();
    }
    public void add(LaguModel item) {
        listItem.add(item);
        notifyItemInserted(listItem.size() + 1);
    }
    public void addAll(List<LaguModel> listItem) {
        for (LaguModel item : listItem) {
            add(item);
        }
    }
    public void removeAll() {
        listItem.clear();
        notifyDataSetChanged();
    }
    public void remove(int pos) {
        listItem.remove(pos);
        notifyDataSetChanged();
    }
    public void swap(List<LaguModel> datas) {
        if (datas == null || datas.size() == 0) listItem.clear();
        if (listItem != null && listItem.size() > 0)
            listItem.clear();
        listItem.addAll(datas);
        notifyDataSetChanged();
    }
    public LaguModel getItem(int pos) {
        return listItem.get(pos);
    }
    public void setFilter(List<LaguModel> list) {
        listItem = new ArrayList<>();
        listItem.addAll(list);
        notifyDataSetChanged();
    }
    public List<LaguModel> getListItem() {
        return listItem;     } }
