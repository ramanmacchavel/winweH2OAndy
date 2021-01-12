package com.example.h20;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    LayoutInflater inflater;
    List<Hero> hero;

    public Adapter(Context ctx, List<Hero> hero) {
        this.inflater = LayoutInflater.from(ctx);
        this.hero = hero;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.align_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.heroName.setText(hero.get(position).getRealname());
        holder.movieName.setText(hero.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return hero != null ? hero.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView movieName, heroName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            movieName = itemView.findViewById(R.id.movieTitle);
            heroName = itemView.findViewById(R.id.movieArtist);
        }
    }
}
