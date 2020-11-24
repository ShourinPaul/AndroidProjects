package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class afterSTUDENTlogin extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private FirebaseAuth firebaseAuth;
    private EditText StudentNAME,StudentINSTITUTION,StudentAGE,StudentMEDIUM,StudentCLASS,StudentPHONE;
    private Button register;
    private TextView text;
    private String BloodGroup,ha;
    private Spinner userBloodgroupx;
    public String ff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_studentlogin);

        firebaseAuth=FirebaseAuth.getInstance();
        userBloodgroupx = (Spinner) findViewById(R.id.etStudentAGE);


        StudentNAME=(EditText) findViewById(R.id.etStudentNAME);
        StudentINSTITUTION=(EditText) findViewById(R.id.etStudentINSTITUTION);
        BloodGroup = userBloodgroupx.getSelectedItem().toString();
        //StudentAGE=(EditText) findViewById(R.id.etStudentAGE);
        StudentCLASS=(EditText) findViewById(R.id.etStudentCLASS);
        StudentMEDIUM=(EditText) findViewById(R.id.etStudentMEDIUM);
        StudentPHONE=(EditText) findViewById(R.id.etStudentPHONE);
        register=(Button)findViewById(R.id.btnStudentREGISTER);
        text=(TextView)findViewById(R.id.tvCLICKHERE);

        userBloodgroupx.setOnItemSelectedListener(this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendUserdata();
            }
        });

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(afterSTUDENTlogin.this,tutordataaa.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.logoutmenu)
        {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(afterSTUDENTlogin.this,MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    private void sendUserdata()
    {


        FirebaseDatabase firebaseDatabase =FirebaseDatabase.getInstance();
        DatabaseReference myref =firebaseDatabase.getReference(firebaseAuth.getUid());
        String fStudentNAME,fStudentINSTITUTION,fStudentAGE,fStudentCLASS,fStudentMEDIUM,fStudentPHONE;
        fStudentNAME=StudentNAME.getText().toString();
        fStudentAGE=ff;
        fStudentPHONE=StudentPHONE.getText().toString();
        fStudentMEDIUM=StudentMEDIUM.getText().toString();
        fStudentCLASS=StudentCLASS.getText().toString();
        fStudentINSTITUTION=StudentINSTITUTION.getText().toString();

        if(fStudentNAME.isEmpty()||fStudentINSTITUTION.isEmpty()||fStudentAGE.isEmpty()||fStudentCLASS.isEmpty()||fStudentMEDIUM.isEmpty()||fStudentPHONE.isEmpty()) {
            Toast.makeText(afterSTUDENTlogin.this, "Please Enter all informations", Toast.LENGTH_SHORT).show();

        }
        else
        {

            StudentPROFILE studentPROFILE = new StudentPROFILE(fStudentNAME,fStudentINSTITUTION, fStudentAGE, fStudentCLASS,fStudentMEDIUM,fStudentPHONE);
            myref.setValue(studentPROFILE);

            Intent intent =new Intent(afterSTUDENTlogin.this,tutordataaa.class);
            startActivity(intent);
            Toast.makeText(afterSTUDENTlogin.this, "Registered Successful", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ha=parent.getItemAtPosition(position).toString();
        ff=ha;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
