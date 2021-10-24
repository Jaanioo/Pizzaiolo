package com.example.pizzaiolo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class CalculateActivity extends AppCompatActivity {

    public static int serv;
    public static int weigh;
    public static double hyd;
    public static int sal;
    public static int oliv;

    public static final String EXTRA_NUMBER = "com.example.pizzaiolo.EXTRA_NUMBER";
    public static final String EXTRA_TEXT = "com.example.pizzaiolo.EXTRA_TEXT";

    private String [] elements = {"Pizza neapolitańska", "Pizza tradycyjna"};
    public Button calculateButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);


        //  PRZYPISANIE KOMPONENTÓW
        //servings = findViewById(R.id.editTextServings);
       // weight = findViewById(R.id.editTextWeight);
       // hydration = findViewById(R.id.editTextHydration);
       // salt = findViewById(R.id.editTextSalt);
       // oliveOil = findViewById(R.id.editTextOlive);
        backButton = findViewById(R.id.backButton);
        calculateButton = findViewById(R.id.calculateButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CalculateActivity.this, MainActivity.class));
                finish();
            }
        });

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                policz();
            }
        });



        //  ROZWIJANA LISTA TYPU PIZZY
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, elements);
        final Spinner spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setAdapter(adapter);

       /* spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch ((int)position){
                    case 0:
                        hydration.setText("60");
                        oliveOil.setText("0");

                        break;

                    case 1:

                        hydration.setText("55");
                        oliveOil.setText("45");

                        break;
                }
            }



            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        */

    }

    public void policz(){
        EditText servings = (EditText) findViewById(R.id.editTextServings);
         serv = Integer.parseInt(servings.getText().toString());

        EditText weight = (EditText) findViewById(R.id.editTextWeight);
        weigh = Integer.parseInt(weight.getText().toString());

        EditText hydration = (EditText) findViewById(R.id.editTextHydration);
        hyd = Double.parseDouble(hydration.getText().toString());

        EditText salt = (EditText) findViewById(R.id.editTextSalt);
        sal = Integer.parseInt(salt.getText().toString());

        EditText olive = (EditText) findViewById(R.id.editTextOlive);
        oliv = Integer.parseInt(olive.getText().toString());

        Intent intent = new Intent(this, ResultActivity.class);
        getIntent().putExtra(EXTRA_NUMBER, serv);
        getIntent().putExtra(EXTRA_NUMBER, weigh);
        getIntent().putExtra(EXTRA_NUMBER, hyd);
        getIntent().putExtra(EXTRA_NUMBER, sal);
        getIntent().putExtra(EXTRA_NUMBER, oliv);
        startActivity(intent);

    }

}

