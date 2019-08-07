package com.wordpress.uniquecoder.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText gst;
    EditText pd;
    private ProgressBar progressBar;
    private FirebaseAuth  mAuth;

    userProfile user = new userProfile();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        findViewById(R.id.tvsignuplink).setOnClickListener(this);
        findViewById(R.id.btnlogin).setOnClickListener(this);

        gst = (EditText)findViewById(R.id.etloginId);
        pd = (EditText)findViewById(R.id.etPassword);

        mAuth = FirebaseAuth.getInstance();
    }

    private void userLogin() {
        String password = pd.getText().toString().trim();
        final String _gst = gst.getText().toString().trim();
        String loginId = _gst+"@gmail.com";

        if (_gst.isEmpty()) {
            gst.setError("Email is required");
            gst.requestFocus();
            return;
        }

//        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//            mailid.setError("Please enter a valid email");
//            mailid.requestFocus();
//            return;
//        }

        if (password.isEmpty()) {
            pd.setError("Password is required");
            pd.requestFocus();
            return;
        }

        if (password.length() < 6) {
            pd.setError("Minimum lenght of password should be 6");
            pd.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        PreferenceManager.getDefaultSharedPreferences(LoginActivity.this).edit().putString("gstid", _gst).apply();

        mAuth.signInWithEmailAndPassword(loginId, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    finish();
                    Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (mAuth.getCurrentUser() != null) {
            finish();
            startActivity(new Intent(this, ProfileActivity.class));
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnlogin:
                userLogin();
                break;

            case R.id.tvsignuplink:
                finish();
                startActivity(new Intent(this,SignupActivity.class));
                break;
        }
    }
}
