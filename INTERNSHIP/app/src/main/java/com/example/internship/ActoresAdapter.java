package com.example.internship;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

class ActorsAdapter extends RecyclerView.Adapter<ActorsAdapter.ViewHolder> {
    private List<ActoresList>actorsLists;
    private Context context;

    public ActorsAdapter(List<ActoresList> actorsLists, Context context) {
        this.actorsLists = actorsLists;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.actores_list,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ActoresList actorsList=actorsLists.get(position);
        holder.atitle.setText(actorsList.getPost_title());
        holder.adesc.setText(actorsList.getPost_desc());
        holder.aposted.setText(actorsList.getPosted_by());
    }

    @Override
    public int getItemCount() {
        return actorsLists.size();
    }
    public void setfilter(List<ActoresList>actorsList){
        actorsLists=new ArrayList<>();
        actorsLists.addAll(actorsList);
        notifyDataSetChanged();

    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView atitle,adesc,aposted;
        public ViewHolder(View itemView) {
            super(itemView);

            atitle=(TextView)itemView.findViewById(R.id.post_title);
            adesc=(TextView)itemView.findViewById(R.id.post_desc);
            aposted=(TextView)itemView.findViewById(R.id.posted_by);
        }
    }
}
