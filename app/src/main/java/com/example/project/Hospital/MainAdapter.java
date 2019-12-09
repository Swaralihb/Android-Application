package com.example.project.Hospital;

import android.content.Intent;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    ArrayList<String> dispAll;              //declaration of arraylists
    ArrayList<String> contAll;
   ArrayList<String> locAll;

   //constructor
    public MainAdapter(ArrayList<String> disp,ArrayList<String> cont,ArrayList<String>loc) {
        dispAll=disp;
        contAll=cont;
        locAll=loc;
    }

    //will create a view to be showed
    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view,parent,false);
        return new ViewHolder(view);
    }

    //will hold the view
    @Override
    public void onBindViewHolder(@NonNull final MainAdapter.ViewHolder holder, int position) {
       holder.Name.setText(dispAll.get(position));

       //to connect caller app with our app
       holder.callView.setText(contAll.get(position));
        holder.callView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String contact[]=new String[50];
                int index=0;
                for (String a:contAll) {
                    contact[index]=a;
                    index++;
                }
                int c=0;
                while(c<index) {
                    Intent i = new Intent(Intent.ACTION_DIAL);
                    i.setData(Uri.parse("tel:" + contact[c]));
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    view.getContext().startActivity(i);
                    c++;
                }
            }
        });

        //for connecting maps with the app
       holder.mapView.setText(locAll.get(position));
       holder.mapView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String loc[]=new String[50];
               int index=0;
               for (String a:locAll) {
                   loc[index]=a;
                   index++;
               }
                int g=0;
                while(g<index) {
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW);
                    mapIntent.setData(Uri.parse("geo:0,0?q="+loc[1]));
                    mapIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mapIntent.setPackage("com.google.android.apps.maps");
                    view.getContext().startActivity(mapIntent);
                    g++;
                }
           }
       });
    }

    @Override
    public int getItemCount() {
        return dispAll.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView Name;
        public TextView callView;
        public TextView mapView;
        public TextView alertView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Name=itemView.findViewById(R.id.DataTextview);
            callView=itemView.findViewById(R.id.callView);
            mapView=itemView.findViewById(R.id.mapView);
            alertView=itemView.findViewById(R.id.alertView);
        }
    }
    public void filterList(ArrayList<String> filterdNames) {
        this.dispAll = filterdNames;
        notifyDataSetChanged();
    }
}
