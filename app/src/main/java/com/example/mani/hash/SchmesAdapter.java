package com.example.mani.hash;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import java.util.List;

/**
 * Created by mani on 3/9/18.
 */

public class SchmesAdapter  extends RecyclerView.Adapter<SchmesAdapter.SchmesViewHolder> {

    private Context mCtx;
    private List<Sehmes> schmestList;

    //getting the context and product list with constructor
    public SchmesAdapter (Context mCtx, List<Sehmes> schmesList) {
        this.mCtx = mCtx;
        this.schmestList = schmesList;
    }

    @Override
    public SchmesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.scheme_recyclerview_layout, null);
        return new SchmesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SchmesViewHolder holder, int position) {

        Sehmes sehmes = schmestList.get(position);


        holder.textViewName.setText(sehmes.getName());


    }


    @Override
    public int getItemCount() {
        return schmestList.size();
    }


    class SchmesViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;


        public SchmesViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.textview_name);

        }
    }
}
