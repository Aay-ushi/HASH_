package com.example.mani.hash;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mani on 3/9/18.
 */

public class SchemesAdapter extends RecyclerView.Adapter<SchemesAdapter.SchmesViewHolder> {

    private Context mCtx;
    private List<Schemes> schmestList;


    public SchemesAdapter(Context mCtx, List<Schemes> schmesList) {
        this.mCtx = mCtx;
        this.schmestList = schmesList;
    }

    @Override
    public SchmesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.scheme_recyclerview_layout, null);
        return new SchmesViewHolder(view,mCtx,schmestList);
    }

    @Override
    public void onBindViewHolder(SchmesViewHolder holder, int position) {

        Schemes sehmes = schmestList.get(position);

        holder.textViewName.setText(sehmes.getName());
    }


    @Override
    public int getItemCount() {
        return schmestList.size();
    }


    class SchmesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewName;
        List<Schemes> schmesList = new ArrayList<>();
        Context ctx;

        public SchmesViewHolder(View itemView, Context ctx, List<Schemes> schmesList) {
            super(itemView);
            this.schmesList = schmesList;
            this.ctx = ctx;

            itemView.setOnClickListener(this);

            textViewName = itemView.findViewById(R.id.textview_name);

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Schemes aSchme = this.schmesList.get(position);

            Intent i = new Intent(this.ctx,DetailAboutAParticularScheme.class);

            i.putExtra("name",aSchme.getName());

            i.putExtra("description",aSchme.getDescription());
            i.putExtra("eligiblity",aSchme.getEligiblity());
            i.putExtra("benefits",aSchme.getBenefits());
            i.putExtra("howToApply",aSchme.getHow_to_apply());
            i.putExtra("websites",aSchme.getWebsites());
            i.putExtra("additionalResources",aSchme.getAdditional_information());



            this.ctx.startActivity(i);
        }
    }
}
