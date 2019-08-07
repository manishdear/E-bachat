package com.wordpress.uniquecoder.hackathon;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class userActivity extends AppCompatActivity {

    EditText username;
    EditText userEmail;
    EditText userGstin;
   // EditText mGstin;

    public userProfile uProfile;
    public FirebaseDatabase firebaseDatabase;
    public DatabaseReference databaseReference;

    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        firebaseDatabase =  FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("user");

        username = findViewById(R.id.editTextName);
        userEmail = findViewById(R.id.editTextEmail);
        //mGstin = findViewById(R.id.etloginId);
        userGstin = findViewById(R.id.editTextGstin);

        //String enteredGstin = uProfile.loginId;
//        Intent intent = getIntent();
//        String str = intent.getStringExtra("id");

        str = PreferenceManager.getDefaultSharedPreferences(userActivity.this).getString("gstid", null);

        databaseReference.child(str).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    uProfile = dataSnapshot.getValue(userProfile.class);
                    String s = uProfile.userName;
                    userEmail.setText(uProfile.userEmailid);
                    username.setText(uProfile.userName);
                    userGstin.setText(uProfile.userId);
                    Toast.makeText(userActivity.this, "data is fetched", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
