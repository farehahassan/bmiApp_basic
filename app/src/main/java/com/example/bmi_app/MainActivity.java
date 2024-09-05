package com.example.bmi_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // yahan sb krna hai issy pehly kuch nh krna

        TextView textResult;
        EditText editWeight, editHeightFt, editHeightIn;
        Button btn_calc;
        editWeight = findViewById(R.id.editWeight);
        editHeightIn = findViewById(R.id.editHeightIn);
        editHeightFt = findViewById(R.id.editHeightFT);
        btn_calc = findViewById(R.id.btn_calc);
        textResult = findViewById(R.id.textResult);


        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(editWeight.getText().toString());
                int ft = Integer.parseInt(editHeightFt.getText().toString());
                int in = Integer.parseInt(editHeightIn.getText().toString());

                int totalIn = ft*12 + in;
                double totalCm = totalIn*2.53;
                double totalM = totalCm/100;

                double totalBMI = wt/(totalM*totalM);
                if (totalBMI>25){
                    textResult.setText(R.string.you_re_overweight);
                } else if (totalBMI <18) {
                    textResult.setText(R.string.you_re_underweight);
                } else {
                    textResult.setText(R.string.you_re_healthy);
                }

            }
        });
    }
}