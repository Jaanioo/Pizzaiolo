package com.example.pizzaiolo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class StartActivity extends AppCompatActivity {

    private Button login, register;
    private EditText password, email;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        login = findViewById(R.id.loginButton);
        register = findViewById(R.id.registerButton);
        email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);

        auth = FirebaseAuth.getInstance();


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(StartActivity.this, "Let's register!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(StartActivity.this, RegisterActivity.class));
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtEmail = email.getText().toString();
                String txtPassword = password.getText().toString();

                if (TextUtils.isEmpty(txtEmail) || TextUtils.isEmpty(txtPassword)){
                    Toast.makeText(StartActivity.this, "Empty credentials!", Toast.LENGTH_LONG).show();
                } else {
                    loginUser(txtEmail, txtPassword);
                }
            }
        });
    }

    private void loginUser(String email, String password){

        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Toast.makeText(StartActivity.this, "Login successfull!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(StartActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}