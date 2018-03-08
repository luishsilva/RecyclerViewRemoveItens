package com.luishsilva.recyclerviewremoveitens;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by luishsilva on 08/03/18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context mContext;

    private ArrayList<String> mArrayList;
    private LayoutInflater inflater;
    private MyAdapter myAdapter;

    public MyAdapter(Context pContext, ArrayList<String> pArrayList) {
        this.mArrayList = pArrayList;
        this.mContext = pContext;
        inflater = LayoutInflater.from(mContext);
        //LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false)
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.mListItem.setText(mArrayList.get(position));
        holder.mListItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int mPosition = holder.getAdapterPosition();
                mArrayList.remove(mPosition);
                myAdapter.notifyItemRemoved(mPosition);
                //myAdapter.notifyDataSetChanged();
                Toast.makeText(mContext, "Position: "+mPosition, Toast.LENGTH_SHORT).show();
            }
        });
        //holder.mListItem.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mListItem;
        public MyViewHolder(View itemView) {
            super(itemView);
            mListItem = itemView.findViewById(R.id.list_item);
        }
    }

    public MyAdapter setHolderAdapter(MyAdapter pAdapter){
        return myAdapter = pAdapter;
    }
}
