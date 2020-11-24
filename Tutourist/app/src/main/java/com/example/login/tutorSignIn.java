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

public class tutorSignIn extends AppCompatActivity {

    private EditText Email,Password;
    private TextView Info;
    private Button Login;
    private  TextView forgotpassword;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_sign_in);


        firebaseAuth=FirebaseAuth.getInstance();
        Email=(EditText)findViewById(R.id.etUserEmawww);
        Password=(EditText)findViewById(R.id.etUserPasswowww);
        Info=(TextView)findViewById(R.id.tvinwww);
        Login=(Button)findViewById(R.id.btnregistwww);
        forgotpassword= (TextView)findViewById(R.id.tvforgotid);

        FirebaseUser user = firebaseAuth.getCurrentUser();
        if(user!=null)
        {
            Toast.makeText(tutorSignIn.this,"Yess, you have loged in",Toast.LENGTH_SHORT).show();
            finish();
            Intent intent=new Intent(tutorSignIn.this,afterSignIn.class);
            startActivity(intent);

        }
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Email.getText().toString(),Password.getText().toString());

            }
        });

        Info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(tutorSignIn.this,tutorSignUp.class);
                startActivity(intent);
            }
        });

        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(tutorSignIn.this,PasswordActivity.class);
                startActivity(intent);
            }
        });


    }

    private void validate(String userEmail,String userPassword)
    {
        if(userEmail.isEmpty()||userPassword.isEmpty())
        {
            Toast.makeText(tutorSignIn.this, "Please enter email or password", Toast.LENGTH_SHORT).show();
        }
        else{
        firebaseAuth.signInWithEmailAndPassword(userEmail,userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(tutorSignIn.this,"successfullu registered,a verification mail has been sent!",Toast.LENGTH_SHORT).show();

                    finish();
                    Intent intent=new Intent(tutorSignIn.this,afterSignIn.class);
                    startActivity(intent);

                }
                else
                {
                    Toast.makeText(tutorSignIn.this,"login is not successful",Toast.LENGTH_SHORT).show();

                }
            }
        });}
    }

    private  void chechEmailVerification()
    {
        FirebaseUser firebaseUser=firebaseAuth.getInstance().getCurrentUser();
        Boolean emailflag = firebaseUser.isEmailVerified();
        if(emailflag)
        {
            finish();
            Intent intent=new Intent(tutorSignIn.this,afterSignIn.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(tutorSignIn.this,"Verify your Email",Toast.LENGTH_SHORT).show();
            firebaseAuth.signOut();

        }
    }
}
