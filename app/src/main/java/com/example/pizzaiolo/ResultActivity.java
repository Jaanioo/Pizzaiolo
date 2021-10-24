package com.example.pizzaiolo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends CalculateActivity{

    private Button recalculate;

    private TextView txtServingsFinal, txtWeightFinal, txtHydrationFinal, txtFinalFlour, txtFinalWater,
            txtFinalOlive, txtFinalYeast, txtFinalSalt;
    private int serv, weigh, sal, oliv;
    private Double hyd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        serv = intent.getIntExtra(CalculateActivity.EXTRA_NUMBER, CalculateActivity.serv);
        weigh = intent.getIntExtra(CalculateActivity.EXTRA_NUMBER, CalculateActivity.weigh);
        hyd = intent.getDoubleExtra(CalculateActivity.EXTRA_NUMBER, CalculateActivity.hyd);
        sal = intent.getIntExtra(CalculateActivity.EXTRA_NUMBER, CalculateActivity.sal);
        oliv = intent.getIntExtra(CalculateActivity.EXTRA_NUMBER, CalculateActivity.oliv);

        txtServingsFinal = (TextView) findViewById(R.id.textViewIlosc);
        txtWeightFinal = (TextView) findViewById(R.id.textViewWaga);
        txtHydrationFinal = (TextView) findViewById(R.id.textViewHydratacja);
        txtFinalFlour = (TextView) findViewById(R.id.textViewFlourWeight);
        txtFinalWater = (TextView) findViewById(R.id.textViewWaterWeight);
        txtFinalOlive = (TextView) findViewById(R.id.textViewOliveWeight);
        txtFinalYeast = (TextView) findViewById(R.id.textViewYeastWeight);
        txtFinalSalt = (TextView) findViewById(R.id.textViewSaltWeight);

        CalculateFinal();

        recalculate = findViewById(R.id.recalculateButton);

        recalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this, CalculateActivity.class));
                finish();
            }
        });

    }

    public void CalculateFinal() {


        Double decHyd = hyd / 100;

        int weightFinal;
        Double flourFinal, waterFinal, oliveFinal, yeastFinal, saltFinal;
        Double waterFlourWeight, finalWeight;

        weightFinal = serv * weigh;
        saltFinal = serv * (sal * 0.1);
        oliveFinal = serv * (oliv * 0.1);
        waterFlourWeight = weightFinal - saltFinal - oliveFinal;
        flourFinal = serv * (waterFlourWeight / (1 + decHyd));
        waterFinal = serv * (flourFinal * decHyd);
        yeastFinal = 0.08 * serv;

        txtServingsFinal.setText("" + serv);
        txtWeightFinal.setText("" + weigh);
        txtHydrationFinal.setText("" + hyd + "%");

        txtFinalFlour.setText(flourFinal + " g");
        txtFinalWater.setText(waterFinal + " g");
        txtFinalOlive.setText(oliveFinal + " g");
        txtFinalYeast.setText(yeastFinal + " g");
        txtFinalSalt.setText(saltFinal + " g");
    }
}