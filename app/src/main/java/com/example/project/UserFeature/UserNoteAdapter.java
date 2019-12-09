package com.example.project.UserFeature;

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

public class UserNoteAdapter extends RecyclerView.Adapter<UserNoteAdapter.ViewHolder> {

    ArrayList<String> noteAll;
    public UserNoteAdapter(ArrayList<String> disp) {
        noteAll=disp;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.note_recycler_view,parent,false);
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.noteView.setText(noteAll.get(position));


    }

    @Override
    public int getItemCount() {
        return noteAll.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView noteView;
        public TextView editView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            noteView=(itemView).findViewById(R.id.noteView);
            editView=(itemView).findViewById(R.id.editView);
        }
    }
}
