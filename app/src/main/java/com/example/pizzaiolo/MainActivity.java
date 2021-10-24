package com.example.pizzaiolo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private Button logout, calculate, flour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logout = findViewById(R.id.logoutButton);
        calculate = findViewById(R.id.kalkulatorButton);
        flour = findViewById(R.id.makiButton);

        flour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Check your flour ;)", Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this, FlourActivity.class));
                finish();
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Let's calculate!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this, CalculateActivity.class));
                finish();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(MainActivity.this, "Successfully logged out!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this, StartActivity.class));
                finish();
            }
        });
    }
}