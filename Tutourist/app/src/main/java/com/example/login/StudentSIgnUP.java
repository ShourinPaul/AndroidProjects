package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StudentSIgnUP extends AppCompatActivity {

    private EditText Email,Password;
    private TextView Info;
    private Button Login;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_sign_up);

        firebaseAuth=FirebaseAuth.getInstance();
        Email=(EditText)findViewById(R.id.etUserstuUP);
        Password=(EditText)findViewById(R.id.etUserPassstuUP);
        Info=(TextView)findViewById(R.id.tvstuUP);
        Login=(Button)findViewById(R.id.btnregiststuUP);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate())
                {
                    String emaa =Email.getText().toString().trim();
                    String passwa=Password.getText().toString().trim();
                    firebaseAuth.createUserWithEmailAndPassword(emaa,passwa).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(StudentSIgnUP.this,"successfullu registered!",Toast.LENGTH_SHORT).show();

                                finish();
                                Intent intent=new Intent(StudentSIgnUP.this,afterSTUDENTlogin.class);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(StudentSIgnUP.this,"reg not successful",Toast.LENGTH_SHORT).show();

                            }
                        }
                    });

                };

            }
        });
    }


    private Boolean validate() {
        String ema =Email.getText().toString();
        String passw=Password.getText().toString();
        Boolean result=true;
        if(ema.isEmpty())
        {
            Email.setError("Enter an email address");
            Email.requestFocus();
            result= false;
            return result;


        }
        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(ema).matches())
        {
            Email.setError("Enter a valid email address");
            Email.requestFocus();
            result= false;
            return result;


        }
        if(passw.isEmpty())
        {
            Password.setError("Enter a password");
            Password.requestFocus();
            result= false;
            return result;


        }
        if(passw.length()<6)
        {
            Password.setError("Password is too short");
            Password.requestFocus();
            result= false;
            return result;


        }
        return result;
    }

    private void sendemailverification()
    {
        final FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if(firebaseUser!=null)
        {
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(StudentSIgnUP.this,"successfullu registered,a verification mail has been sent!",Toast.LENGTH_SHORT).show();
                        firebaseAuth.signOut();
                        finish();
                        Intent intent=new Intent(StudentSIgnUP.this,afterSTUDENTlogin.class);
                        startActivity(intent);

                    }
                    else
                    {
                        Toast.makeText(StudentSIgnUP.this," verification mail hasn't sent!",Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
    }
}
