package com.example.pizzaiolo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.bumptech.glide.Glide;
import com.google.firebase.storage.FirebaseStorage;


import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class FlourActivity extends AppCompatActivity {

    FirebaseStorage firebaseStorage;
    FirebaseUser firebaseUser;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;

    public ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flour);

        img = findViewById(R.id.img);
      ListView flour_listview = findViewById(R.id.listview);

        firebaseAuth = FirebaseAuth.getInstance();//FireBase connecting try
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        firebaseStorage = FirebaseStorage.getInstance();


       final ArrayList<Flour> floursList = new ArrayList<>();


      //  floursList.add(new Flour(R.drawable.caputopizzeria, "Caputo Pizzeria"));
        //floursList.add(new Flour(R.drawable.caputoclassica, "Caputo Classica"));

        CustomArrayAdapter arrayAdapter = new CustomArrayAdapter(this, R.layout.custom_list, floursList);

        flour_listview.setAdapter(arrayAdapter);

        final TextView flour_name = (TextView) findViewById(R.id.flour_name);

        /*DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Maka");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

         */

      /*  databaseReference.child(FirebaseAuth.getInstance().getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    Flour flour = dataSnapshot.getValue(Flour.class);
                   // floursList.add(snapshot.getValue().);
                    Glide.with(getApplicationContext()).load(flour.getmImgRedId()).into(img);

                    if (flour_name != null) {
                        String flourName = flour.getmFlourName();
                        flour_name.setText(flourName);

                    } else {
                        flour_name.setText("Problem z ładowaniem");
                    }
                }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
                arrayAdapter.notifyDataSetChanged();

            }

        });


       */



    }
}
