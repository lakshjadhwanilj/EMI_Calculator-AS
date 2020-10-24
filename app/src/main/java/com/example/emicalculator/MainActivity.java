package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText principal, tenure, roi;
    Button calculate;
    TextView emi, interest;
    Float a, b, e, n, p, r, I;
    Float pow, rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        principal = findViewById(R.id.principal);
        tenure = findViewById(R.id.tenure);
        roi = findViewById(R.id.roi);

        calculate = findViewById(R.id.calculate);

        emi = findViewById(R.id.emi);
        interest = findViewById(R.id.interest);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    p = Float.parseFloat(principal.getText().toString());
                    r = Float.parseFloat(roi.getText().toString());
                    n = Float.parseFloat(tenure.getText().toString());

                    // emi: E = (P*r*(1 + r)^n)/((1 + r)^n - 1)

                    rate = r / 12 / 100;
                    pow = (float) Math.pow((1 + rate), n * 12);
                    a = p * rate * pow;
                    b = pow - 1;
                    e = a / b;

                    emi.setText("₹ " + String.format("%.2f", e));

                    // total interest: I = e * n * 12 - p
                    I = e * n * 12 - p;
                    interest.setText("₹ " + String.format("%.2f", I));

                } catch (Exception e) {
                    System.out.println(e);
                }

            }
        });
    }
}