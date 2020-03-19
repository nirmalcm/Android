package com.digiapt.java.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.digiapt.java.R;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter
{
    private List<RecyclerViewModel> recylerViewModels;
    private Context context;

    public RecyclerViewAdapter(Context context, List<RecyclerViewModel> recylerViewModels)
    {
        this.recylerViewModels = recylerViewModels;
        this.context = context;
    }

    public OnItemClickListener onItemClickListener;
    public interface OnItemClickListener {
        void onItemClick(View view, int pos);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_adapter, parent, false);
        return new ViewHolderSub(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position)
    {
        final ViewHolderSub viewHolderSub = (ViewHolderSub) holder;


        viewHolderSub.id.setTag(viewHolderSub.id.getId(), recylerViewModels.get(position));
        viewHolderSub.id.setText(recylerViewModels.get(position).getId());

        viewHolderSub.itemView.setTag(viewHolderSub.itemView.getId(), recylerViewModels.get(position));
        viewHolderSub.itemView.setOnClickListener(v -> {
            onItemClickListener.onItemClick(v,position);
        });
    }

    @Override
    public int getItemCount()
    {
        return recylerViewModels.size();
    }

    public class ViewHolderSub extends RecyclerView.ViewHolder
    {
        TextView id;

        public ViewHolderSub(View itemView)
        {
            super(itemView);
            id = itemView.findViewById(R.id.id_name);
        }
    }
}