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
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
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

public class tutordataaa extends AppCompatActivity {


    ListView xlistView;
    private FirebaseAuth xfirebaseAuth;
    FirebaseDatabase xdatabase;
    DatabaseReference xmyRef;
    FirebaseUser xuser;
    String xuserId;
    String xnumber;
    androidx.appcompat.widget.SearchView xsearchView;
    private static int REQEST_CALL=1;
    ArrayList<tutornaaaaa> xarrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutordataaa);


        xlistView = (ListView) findViewById(R.id.listViewIdxxx);
        xsearchView= (androidx.appcompat.widget.SearchView) findViewById(R.id.searchViewdxxx);

        xfirebaseAuth = FirebaseAuth.getInstance();

        xdatabase = FirebaseDatabase.getInstance();
        xmyRef = xdatabase.getReference();
        //  user = firebaseAuth.getCurrentUser();

        xmyRef = xdatabase.getReference();
        //  user = firebaseAuth.getCurrentUser();


        // public void readDataFromFirebase()
        {
            //  Log.w("Himel", "User Id: " + userId );
            // Read from the database
            xmyRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    //   UserProfile userProfile = dataSnapshot.getValue(UserProfile.class);


                    Toast.makeText(tutordataaa.this,"Enter to fireebase data! ",Toast.LENGTH_SHORT ).show();

                    for (DataSnapshot ds: dataSnapshot.getChildren())
                    {
                        String uName = ds.child("StudentNAME").getValue().toString();
                        String uPassword = ds.child("StudentINSTITUTION").getValue().toString();
                        String uPhone = ds.child("StudentPHONE").getValue().toString();
                        String uBlood = ds.child("StudentMEDIUM").getValue().toString();
                        String uAddress = ds.child("StudentCLASS").getValue().toString();
                        String uAge = ds.child("StudentAGE").getValue().toString();
                        tutornaaaaa xuserProfile = new tutornaaaaa(uAge,uAddress,uPassword,uBlood,uName,uPhone);
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
                        if(xuserProfile.StudentAGE.equals("Tutor")) {
                            xarrayList.add(xuserProfile);
                        }


                        if(xsearchView!=null)
                        {
                            xsearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                                @Override
                                public boolean onQueryTextSubmit(String query) {
                                    return false;
                                }

                                @Override
                                public boolean onQueryTextChange(String newText) {
                                    ArrayList<tutornaaaaa>xmylist=new ArrayList<>();

                                    for(tutornaaaaa ob: xarrayList)
                                    {
                                        if(ob.getStudentINSTITUTION().toLowerCase().contains(newText.toLowerCase())||ob.getStudentCLASS().toLowerCase().contains(newText.toLowerCase()))
                                        {

                                            xmylist.add(ob);

                                        }

                                    }
                                    tutorLISTadapter xadapter = new tutorLISTadapter(tutordataaa.this,R.layout.tutorrecyview,xmylist);
                                    xlistView.setAdapter(xadapter);
                                    return true;
                                }
                            });
                        }





                    }
                    //ArrayAdapter adapter = new ArrayAdapter<UserProfile>(FirebaseDataActivity.this,R.layout.support_simple_spinner_dropdown_item,arrayList);
                    tutorLISTadapter xadapter = new tutorLISTadapter(tutordataaa.this,R.layout.tutorrecyview,xarrayList);
                    xlistView.setAdapter(xadapter);




                    // Log.w("Himel", "UserName: " + userProfile.getUserName() );
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    // Log.w("Himel", "Failed to read value.", error.toException());
                }
            });

            xlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    tutornaaaaa xuserProfile=xarrayList.get(position);

                    xnumber=xuserProfile.getStudentPHONE();


                    AlertDialog.Builder b1=new AlertDialog.Builder(tutordataaa.this);
                    b1.setTitle("phonecall");
                    b1.setMessage("do you want to call");
                    b1.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(ContextCompat.checkSelfPermission(tutordataaa.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                                ActivityCompat.requestPermissions(tutordataaa.this,new String[]{Manifest.permission.CALL_PHONE},REQEST_CALL);

                            }
                            else
                            {

                                String dial="tel:"+ xnumber;
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
