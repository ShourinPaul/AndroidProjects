package com.example.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PersonalListAdapter extends ArrayAdapter<naaaaaaall> {
    private  static final String TAG = "PersonalListAdapter";
    private Context mContext;
    int mResource;
    public PersonalListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<naaaaaaall> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        String Name = getItem(position).getStudentNAME();
        String BloodGroup = getItem(position).getStudentINSTITUTION();
        String Phone = getItem(position).getStudentPHONE();
        String Address = getItem(position).getStudentCLASS();
        String Password = getItem(position).getStudentMEDIUM();
        String age = getItem(position).getStudentAGE();

        naaaaaaall userProfile = new naaaaaaall(age,Address,BloodGroup,Password,Name,Phone);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource,parent,false);

        TextView tvName = (TextView) convertView.findViewById(R.id.text_view_StudentNAME);
        TextView tvBlood = (TextView) convertView.findViewById(R.id.text_view_StudentINSTITUTION);
        TextView tvPhone = (TextView) convertView.findViewById(R.id.text_view_StudentPHONE);
        TextView tvMedium = (TextView) convertView.findViewById(R.id.text_view_StudentMEDIUM);
        TextView tvClass = (TextView) convertView.findViewById(R.id.text_view_StudentCLASS);
        TextView tvAge = (TextView) convertView.findViewById(R.id.text_view_StudentAGE);



        tvName.setText("Name: "+Name);
        tvBlood.setText("Institution: "+BloodGroup);
        tvPhone.setText("Contact Number:"+Phone);
        tvClass.setText("Class: "+Address);
        tvMedium.setText("Medium: "+Password);
        tvAge.setText("Profile: "+age);

        return convertView;
    }

}


