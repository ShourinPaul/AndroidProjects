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

public class tutorLISTadapter extends ArrayAdapter<tutornaaaaa> {

    private  static final String TAG = "tutorLISTadapter";
    private Context xmContext;
    int xmResource;
    public tutorLISTadapter(@NonNull Context context, int resource, @NonNull ArrayList<tutornaaaaa> xobjects) {
        super(context, resource, xobjects);
        xmContext = context;
        xmResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        String Name = getItem(position).getStudentNAME();
        String BloodGroup = getItem(position).getStudentINSTITUTION();
        String Phone = getItem(position).getStudentPHONE();
        String Address = getItem(position).getStudentAGE();
        String Password = getItem(position).getStudentMEDIUM();
        String age = getItem(position).getStudentCLASS();

        tutorPROFILE userProfile = new tutorPROFILE(Name,BloodGroup,age,Password,Address,Phone);

        LayoutInflater inflater = LayoutInflater.from(xmContext);
        convertView = inflater.inflate(xmResource,parent,false);

        TextView tvName = (TextView) convertView.findViewById(R.id.text_view_tutorNAME);
        TextView tvBlood = (TextView) convertView.findViewById(R.id.text_view_tutorINSTITUTION);
        TextView tvPhone = (TextView) convertView.findViewById(R.id.text_view_tutorPHONE);
        TextView tvMedium = (TextView) convertView.findViewById(R.id.text_view_tutorMEDIUM);
        TextView tvClass = (TextView) convertView.findViewById(R.id.text_view_tutorCLASS);
        TextView tvAge = (TextView) convertView.findViewById(R.id.text_view_tutorAGE);



        tvName.setText("Teacher Name:"+Name);
        tvBlood.setText("Institution: "+BloodGroup);
        tvPhone.setText("Contact Number: "+Phone);
        tvClass.setText("Profile: "+Address);
        tvMedium.setText("Profession: "+Password);
        tvAge.setText("Subject: "+age);

        return convertView;
    }

}
