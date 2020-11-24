package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class BAAAAAAAAAAL extends AppCompatActivity {

    ListView listView;
    private FirebaseAuth firebaseAuth;
    FirebaseDatabase database;
    DatabaseReference myRef;
    FirebaseUser user;
    String userId;
    String number;
    androidx.appcompat.widget.SearchView searchView;
    private static int REQEST_CALL=1;
    ArrayList<naaaaaaall> arrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baaaaaaaaaal);

        listView = (ListView) findViewById(R.id.listViewId);
        searchView= (androidx.appcompat.widget.SearchView) findViewById(R.id.searchViewd);

        firebaseAuth = FirebaseAuth.getInstance();

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        //  user = firebaseAuth.getCurrentUser();

        myRef = database.getReference();
        //  user = firebaseAuth.getCurrentUser();


        // public void readDataFromFirebase()
        {
            //  Log.w("Himel", "User Id: " + userId );
            // Read from the database
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    //   UserProfile userProfile = dataSnapshot.getValue(UserProfile.class);


                    Toast.makeText(BAAAAAAAAAAL.this,"Enter to fireebase data! ",Toast.LENGTH_SHORT ).show();

                    for (DataSnapshot ds: dataSnapshot.getChildren())
                    {
                        String uName = ds.child("StudentNAME").getValue().toString();
                        String uPassword = ds.child("StudentINSTITUTION").getValue().toString();
                        String uPhone = ds.child("StudentPHONE").getValue().toString();
                        String uBlood = ds.child("StudentMEDIUM").getValue().toString();
                        String uAddress = ds.child("StudentCLASS").getValue().toString();
                        String uAge = ds.child("StudentAGE").getValue().toString();
                        naaaaaaall userProfile = new naaaaaaall(uAge,uAddress,uPassword,uBlood,uName,uPhone);
                        // userProfile.setUserName(ds.child(userId).getValue(UserProfile.class).getUserName());   //set the name
                        // userProfile.setUserPassword(ds.child(userId).getValue(UserProfile.class).getUserPassword());   //set the password
                        // userProfile.setUserPhone(ds.child(userId).getValue(UserProfile.class).getUserPhone());   //set the phone

/*
                        arrayList.add(userProfile.getUserName());
                        arrayList.add(userProfile.getUserPhone());
                        arrayList.add(userProfile.getUserPassword());
                        arrayList.add(userProfile.getUserBloodGroup());
                        arrayList.add(userProfile.getUserAddress());

 */
                        if(userProfile.StudentAGE.equals("Student")) {
                            arrayList.add(userProfile);
                        }

                        if(searchView!=null)
                        {
                            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                                @Override
                                public boolean onQueryTextSubmit(String query) {
                                    return false;
                                }

                                @Override
                                public boolean onQueryTextChange(String newText) {
                                    ArrayList<naaaaaaall>mylist=new ArrayList<>();

                                   for(naaaaaaall ob: arrayList)
                                   {
                                       if(ob.getStudentCLASS().toLowerCase().contains(newText.toLowerCase())||ob.getStudentINSTITUTION().toLowerCase().contains(newText.toLowerCase())||ob.getStudentMEDIUM().toLowerCase().contains(newText.toLowerCase()))
                                       {

                                           mylist.add(ob);

                                       }

                                   }
                                   PersonalListAdapter adapter = new PersonalListAdapter(BAAAAAAAAAAL.this,R.layout.recyview22222,mylist);
                                    listView.setAdapter(adapter);
                                    return true;
                                }
                            });
                        }





                    }
                    //ArrayAdapter adapter = new ArrayAdapter<UserProfile>(FirebaseDataActivity.this,R.layout.support_simple_spinner_dropdown_item,arrayList);
                    PersonalListAdapter adapter = new PersonalListAdapter(BAAAAAAAAAAL.this,R.layout.recyview22222,arrayList);
                    listView.setAdapter(adapter);




                    // Log.w("Himel", "UserName: " + userProfile.getUserName() );
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                   // Log.w("Himel", "Failed to read value.", error.toException());
                }
            });

           listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    naaaaaaall userProfile=arrayList.get(position);

                    number=userProfile.getStudentPHONE();


                    AlertDialog.Builder b1=new AlertDialog.Builder(BAAAAAAAAAAL.this);
                    b1.setTitle("phonecall");
                    b1.setMessage("do you want to call");
                    b1.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(ContextCompat.checkSelfPermission(BAAAAAAAAAAL.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                                ActivityCompat.requestPermissions(BAAAAAAAAAAL.this,new String[]{Manifest.permission.CALL_PHONE},REQEST_CALL);

                            }
                            else
                            {

                                String dial="tel:"+ number;
                                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));

                            }
                        }
                    });
                    b1.setNegativeButton("no",null);
                    b1.create();
                    b1.show();

                }
            });










        }
}

}








