package com.anindya.aplikasiku.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anindya.aplikasiku.Model.Stuff;
import com.anindya.aplikasiku.R;

import java.util.List;

public class StuffAdapter extends RecyclerView.Adapter<StuffAdapter.ViewHolder> {

    public interface onItemStuffListener{
        void onStuffClicked(int index, Stuff item);
    }

    private List<Stuff> items;
    private onItemStuffListener listener;

    public StuffAdapter(List<Stuff> items, onItemStuffListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public StuffAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_stuff, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StuffAdapter.ViewHolder holder, int position) {
        Stuff item = items.get(position);
        holder.bind(position, item);

    }

    @Override
    public int getItemCount() {
        return (items != null) ? items.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameStuff;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameStuff = itemView.findViewById(R.id.text_stuff);
        }

        public void bind(final int index, final Stuff item){
            nameStuff.setText(item.getNameStuff());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onStuffClicked(index, item);
                }
            });
        }
    }
}
