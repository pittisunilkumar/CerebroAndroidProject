package com.example.cerebro;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.lang.Float.valueOf;

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder> implements Filterable {

    private List<Regional> datalist;
    private Context mcontext;
    private List<Regional>regionalListall;

    public Adapter(List<Regional> datalist, Context mcontext) {
        this.datalist = datalist;
        this.mcontext = mcontext;
        this.regionalListall = new ArrayList<>(datalist);
    }

    @Override
    public Viewholder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.design,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder( Viewholder holder, int position) {

        holder.tittle.setText(datalist.get(position).getLoc());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext,Resultstate.class);
                intent.putExtra("loc",datalist.get(position).getLoc());
                intent.putExtra("deaths",datalist.get(position).getDeaths());
                intent.putExtra("ConfirmedCasesForeign",datalist.get(position).getConfirmedCasesForeign());
                intent.putExtra("ConfirmedCasesIndian",datalist.get(position).getConfirmedCasesIndian());
                intent.putExtra("Discharged",datalist.get(position).getDischarged());
                intent.putExtra("TotalConfirmed",datalist.get(position).getTotalConfirmed());
                mcontext.startActivity(intent);
                Toast.makeText(mcontext, datalist.get(position).getLoc(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        //run on background thread
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Regional> filteredList = new ArrayList<>();
            if(constraint.toString().isEmpty()){
                filteredList.addAll(regionalListall);
            }else{
                for(Regional movie: regionalListall){
                        if(movie.getLoc().toLowerCase().contains(constraint.toString().toLowerCase())){
                            filteredList.add(movie);
                        }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;

            return filterResults;
        }
        //runs on a ui thread
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            datalist.clear();
            datalist.addAll((Collection<? extends Regional>) results.values);
            notifyDataSetChanged();
        }
    };


    public class Viewholder extends RecyclerView.ViewHolder {
        TextView tittle;
        LinearLayout linearLayout;
        public Viewholder( View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.lla);
            tittle = itemView.findViewById(R.id.tit);

        }
    }
}
