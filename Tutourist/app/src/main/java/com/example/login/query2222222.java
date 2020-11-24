package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class query2222222 extends AppCompatActivity {

    private RecyclerView arecyclerView;
    private arrayadapter222222 adapter;
    private List<object2222> artistList;

    DatabaseReference dbArtists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query2222222);

        arecyclerView = findViewById(R.id.recyclerView);
        arecyclerView.setHasFixedSize(true);
        arecyclerView.setLayoutManager(new LinearLayoutManager(this));
        artistList = new ArrayList<>();
        adapter = new arrayadapter222222(this, artistList);
        arecyclerView.setAdapter(adapter);

        //1. SELECT * FROM Artists
        dbArtists = FirebaseDatabase.getInstance().getReference("login-f259d");
        dbArtists.addListenerForSingleValueEvent(valueEventListener);

        /*//2. SELECT * FROM Artists WHERE id = "-LAJ7xKNj4UdBjaYr8Ju"
        Query query = FirebaseDatabase.getInstance().getReference("login-f259d")
                .orderByChild("StudentNAME")
                .equalTo("pranto");

        //3. SELECT * FROM Artists WHERE country = "India"
        Query query3 = FirebaseDatabase.getInstance().getReference("login-f259d")
                .orderByChild("StudentCLASS")
                .equalTo("5");

        //4. SELECT * FROM Artists LIMIT 2
        Query query4 = FirebaseDatabase.getInstance().getReference("login-f259d").limitToFirst(2);


        //5. SELECT * FROM Artists WHERE age < 30
        Query query5 = FirebaseDatabase.getInstance().getReference("login-f259d")
                .orderByChild("age")
                .endAt(29);


        //6. SELECT * FROM Artists WHERE name = "A%"
        Query query6 = FirebaseDatabase.getInstance().getReference("login-f259d")
                .orderByChild("StudentNAME")
                .startAt("p")
                .endAt("o\uf8ff");

        ;
        /*
         * You just need to attach the value event listener to read the values
         * for example
         * query6.addListenerForSingleValueEvent(valueEventListener)
         * */


    }

    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            artistList.clear();
            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    object2222 artist = snapshot.getValue(object2222.class);
                    artistList.add(artist);
                }
                adapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };
}
