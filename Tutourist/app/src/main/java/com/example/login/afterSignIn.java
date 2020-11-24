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

public class afterSignIn extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    private FirebaseAuth firebaseAuth;
    private EditText tutorNAME,tutorINSTITUTION,tutorAGE,tutorSUBJECT,tutorPROFESSION,tutorPHONE;
    private Button register;
    private TextView text;
    private String BloodGroup,ha;
    private Spinner userBloodgroupx;
    public String ff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_sign_in);

        firebaseAuth=FirebaseAuth.getInstance();

        userBloodgroupx = (Spinner) findViewById(R.id.etStudentAG);
        BloodGroup = userBloodgroupx.getSelectedItem().toString();
        text=(TextView)findViewById(R.id.tvCLICK);
        tutorNAME=(EditText) findViewById(R.id.etTutorNAME);
        tutorINSTITUTION=(EditText) findViewById(R.id.etTutorINSTITUTION);
        //tutorAGE=(EditText) findViewById(R.id.etTutorAGE);
        userBloodgroupx.setOnItemSelectedListener(this);

        tutorSUBJECT=(EditText) findViewById(R.id.etTutorSUbject);
        tutorPROFESSION=(EditText) findViewById(R.id.etTutorPROFESSION);
        tutorPHONE=(EditText) findViewById(R.id.etTutorPHONE);
        register=(Button)findViewById(R.id.btnTutorREGISTER);
        /*logout=findViewById(R.id.btnlogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(afterSignIn.this,tutorSignIn.class));
            }
        });*/

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendUserdata();
            }
        });
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(afterSignIn.this,BAAAAAAAAAAL.class);
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
            startActivity(new Intent(afterSignIn.this,MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    private void sendUserdata()
    {


        FirebaseDatabase firebaseDatabase =FirebaseDatabase.getInstance();
        DatabaseReference myref =firebaseDatabase.getReference(firebaseAuth.getUid());
        String ftutorNAME,ftutorINSTITUTION,ftutorAGE,ftutorSUBJECT,ftutorPROFESSION,ftutorPHONE;
        ftutorNAME=tutorNAME.getText().toString();
        ftutorAGE=ff;
        ftutorPHONE=tutorPHONE.getText().toString();
        ftutorPROFESSION=tutorPROFESSION.getText().toString();
        ftutorSUBJECT=tutorSUBJECT.getText().toString();
        ftutorINSTITUTION=tutorINSTITUTION.getText().toString();

        if(ftutorNAME.isEmpty()||ftutorINSTITUTION.isEmpty()||ftutorAGE.isEmpty()||ftutorSUBJECT.isEmpty()||ftutorPROFESSION.isEmpty()||ftutorPHONE.isEmpty()) {
            Toast.makeText(afterSignIn.this, "Please Enter all informations", Toast.LENGTH_SHORT).show();

        }
        else
        {
            tutorPROFILE tutorprofile = new tutorPROFILE(ftutorNAME, ftutorINSTITUTION, ftutorAGE, ftutorSUBJECT, ftutorPROFESSION, ftutorPHONE);
            myref.setValue(tutorprofile);
            Intent intent =new Intent(afterSignIn.this,BAAAAAAAAAAL.class);
            startActivity(intent);
            Toast.makeText(afterSignIn.this, "Registered Successful", Toast.LENGTH_SHORT).show();
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
