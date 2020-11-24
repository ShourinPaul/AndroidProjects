package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

import java.sql.BatchUpdateException;

public class MainActivity extends AppCompatActivity  {

    private Button mtutor,mstudent;
    private FirebaseAuth firebaseAuth;
    //private Spinner userBloodgroup;
    private String BloodGroup;
    private Button about;
   private int i;
    private String ha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //userBloodgroup = (Spinner) findViewById(R.id.spinner);
        firebaseAuth=FirebaseAuth.getInstance();
        about=findViewById(R.id.aboutt);
        mtutor=findViewById(R.id.btnTUTORID);
      //  BloodGroup = userBloodgroup.getSelectedItem().toString();
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item);

        //userBloodgroup.setAdapter(arrayAdapter);
       // userBloodgroup.setOnItemSelectedListener(this);




        mstudent=findViewById(R.id.btnSTUDENTID);
        mtutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /*if(validate())
               {
                   String emaa =Email.getText().toString().trim();
                   String passwa=Password.getText().toString().trim();
                   firebaseAuth.createUserWithEmailAndPassword(emaa,passwa).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                           if(task.isSuccessful()){
                           Toast.makeText(MainActivity.this,"reg successful",Toast.LENGTH_SHORT).show();
                            }
                           else
                           {
                               Toast.makeText(MainActivity.this,"reg not successful",Toast.LENGTH_SHORT).show();

                           }
                       }
                   });


               };*/
                Intent intent=new Intent(MainActivity.this,tutorSignIn.class);
                startActivity(intent);
            }
        });
        mstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,StudentSignIN.class);
                startActivity(intent);
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,JsonActivity.class);
                startActivity(intent);
            }
        });


    }

    /*@Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ha=parent.getItemAtPosition(position).toString();
        //String ga="Student";
        if(ha.equals("Student"))
        {
            Intent intent=new Intent(MainActivity.this,StudentSignIN.class);
            startActivity(intent);
        }
        else if(ha.equals("Tutor"))
        {
            Intent intent=new Intent(MainActivity.this,tutorSignIn.class);
            startActivity(intent);
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }*/

    /*@Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }*/

    /*private Boolean validate() {
        String ema =Email.getText().toString();
        String passw=Password.getText().toString();
        Boolean result=false;
        if(passw.isEmpty()|| ema.isEmpty())
        {
            Toast.makeText(this,"please enter",Toast.LENGTH_SHORT).show();
        }
        else
        {
            result= true;
        }
        return result;
    }*/
}
