package com.example.login;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class arrayadapter222222 extends RecyclerView.Adapter<arrayadapter222222.ArtistViewHolder>{

    private Context mCtx;
    private List<object2222> artistList;

    public arrayadapter222222(Context mCtx, List<object2222> artistList) {
        this.mCtx = mCtx;
        this.artistList = artistList;
    }

    @NonNull
    @Override
    public ArtistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyview22222, parent, false);
        return new arrayadapter222222.ArtistViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull arrayadapter222222.ArtistViewHolder holder, int position) {
        object2222 artist = artistList.get(position);
        holder.textViewName.setText(artist.StudentNAME);
        holder.textViewInstituition.setText("Genre: " + artist.StudentINSTITUTION);
        holder.textViewAge.setText("Age: " + artist.StudentAGE);
        holder.textViewClass.setText("Country: " + artist.StudentCLASS);
        holder.textViewMedium.setText("Country: " + artist.StudentMEDIUM);
        holder.textViewPhone.setText("Country: " + artist.StudentPHONE);
    }

    @Override
    public int getItemCount() {
        return artistList.size();
    }

    class ArtistViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName, textViewClass, textViewAge, textViewInstituition,textViewMedium,textViewPhone;

        public ArtistViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.text_view_StudentNAME);
            textViewClass = itemView.findViewById(R.id.text_view_StudentCLASS);
            textViewInstituition = itemView.findViewById(R.id.text_view_StudentINSTITUTION);
            textViewMedium = itemView.findViewById(R.id.text_view_StudentMEDIUM);
            textViewPhone = itemView.findViewById(R.id.text_view_StudentPHONE);
            textViewAge = itemView.findViewById(R.id.text_view_StudentAGE);

        }
    }


}










