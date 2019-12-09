package com.example.project.MedicalStore;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.project.R;

import java.util.ArrayList;

public class MainAdapterMedicalStore extends RecyclerView.Adapter<MainAdapterMedicalStore.ViewHolder>{
    ArrayList<String> dispAll;
    ArrayList<String> contAll;
    ArrayList<String> locAll;


    public MainAdapterMedicalStore(ArrayList<String> disp,ArrayList<String> cont,ArrayList<String>loc) {
        dispAll=disp;
        contAll=cont;
        locAll=loc;
    }

    @NonNull
    @Override
    public MainAdapterMedicalStore.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Name.setText(dispAll.get(position));
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
                int m=0;
                while(m<index) {
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW);
                    mapIntent.setData(Uri.parse("geo:0,0?q="+loc[1]));
                    mapIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mapIntent.setPackage("com.google.android.apps.maps");
                    view.getContext().startActivity(mapIntent);
                    m++;
                }
            }
        });

        holder.callView.setText(contAll.get(position));
        holder.callView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String contact[]=new String[50];
                int ind=0;
                for (String a:contAll) {
                    contact[ind]=a;
                    ind++;
                }
                int g=0;
                while(g<ind) {
                    Intent i = new Intent(Intent.ACTION_DIAL);
                    i.setData(Uri.parse("tel:" + contact[g]));
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    view.getContext().startActivity(i);
                    g++;
                }
            }
        });

    }
    @Override
    public int getItemCount() {
        return dispAll.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView Name;
        public TextView callView;
        public TextView mapView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Name=itemView.findViewById(R.id.DataTextview);
            callView=itemView.findViewById(R.id.callView);
            mapView=itemView.findViewById(R.id.mapView);
        }

    }
}
