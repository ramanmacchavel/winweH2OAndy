package com.example.h20;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    LayoutInflater inflater;
    List<Hero> hero;
    private Context context;

    public HomeAdapter(Context ctx, List<Hero> hero) {
        this.inflater = LayoutInflater.from(ctx);
        this.hero = hero;
        this.context = ctx;
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
       // holder.product_id.setText(hero.get(position).getBio());
        holder.order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openCanList = new Intent(context, CanList.class);
                context.startActivity(openCanList);
            }
        });

    }

    @Override
    public int getItemCount() {
        return hero != null ? hero.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView movieName, heroName;
        Button order;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            movieName = itemView.findViewById(R.id.movieTitle);
            heroName = itemView.findViewById(R.id.movieArtist);
           // product_id = itemView.findViewById(R.id.product_id);
            order =  itemView.findViewById(R.id.btn_order);
        }
    }
}
