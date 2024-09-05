package com.example.bmi_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // yahan sb krna hai issy pehly kuch nh krna

        //sabsy pehly jitni bhi ids hoti hen jis bhi file mai unko variables mai initialize krwa lety hen taky use krne mai problem na ho
        TextView textResult;
        EditText editWeight, editHeightFt, editHeightIn;
        LinearLayout mainLayout;
        Button btn_calc;
        editWeight = findViewById(R.id.editWeight); // yahan findviewbyid use kiya hai taky humne jo ids di hen apni activity file mai unko yahan get krlen or jo uper variables declare keye thy unmai add krden
        editHeightIn = findViewById(R.id.editHeightIn);
        editHeightFt = findViewById(R.id.editHeightFT);
        btn_calc = findViewById(R.id.btn_calc);
        textResult = findViewById(R.id.textResult);
        mainLayout = findViewById(R.id.mainLayout);

//onlick ky liyn jesy flitter mai inkwell ya gesture use krty thy esy hi yahan setonclicklistener use krna prhta hai, jiska mtlb onclick hi hota hai , bs yahan pai abstract function bnta hai jesy mne btn_clc mai apni id ccall krwai thi ab phr mne usky andr phr btn_calc.setonclicklistner krky on click call krwayay jo apne andr ek object leta hai phr usky andr new likha object ky liyn ohrr uska instance bnaya jo viewonclick tha mtlb click rkne pai kya dekhyga usky bad abstract class bna ky kam start kiya
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
                    mainLayout.setBackgroundColor(getResources().getColor(R.color.red));
                } else if (totalBMI <18) {
                    textResult.setText(R.string.you_re_underweight);
                    mainLayout.setBackgroundColor(getResources().getColor(R.color.blue));

                } else {
                    textResult.setText(R.string.you_re_healthy);
                    mainLayout.setBackgroundColor(getResources().getColor(R.color.green));

                }

            }
        });
    }
}
