package com.example.mrfbmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    String weight,height,age,gender,result,bmitype;
    ConstraintLayout layout;

    TextView weighttv,heighttv,agetv,gendertv,resulttv,bmiType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
       weight = getIntent().getStringExtra("weight");
       age = getIntent().getStringExtra("age");
       height = getIntent().getStringExtra("height");
       gender = getIntent().getStringExtra("gender");
       result=getIntent().getStringExtra("result");


       weighttv = findViewById(R.id.weight);
       agetv = findViewById(R.id.age);
       heighttv = findViewById(R.id.height);
       gendertv = findViewById(R.id.gender);
       resulttv=findViewById(R.id.resulttv);
       bmiType = findViewById(R.id.BMIType);
       layout = findViewById(R.id.layoutresult);

       weighttv.setText(weight+" KG");
       heighttv.setText(height+" m");
       agetv.setText(age);
       gendertv.setText(gender);
       resulttv.setText(result);
       resulttv.setTextColor(getResources().getColor(R.color.green));

        double resultvalue = Double.parseDouble(result);
        if(resultvalue>24.9&&resultvalue<30.0)
        {
            bmiType.setText("Over Weight!");
            bmiType.setTextColor(getResources().getColor(R.color.orange));
           // layout.setBackgroundResource(R.drawable.overweightback);
        }
        else if (resultvalue<25.0&&resultvalue>18.4) {
            bmiType.setText("Normal!");
            bmiType.setTextColor(getResources().getColor(R.color.green));
            //layout.setBackgroundResource(R.drawable.normaltypeback);

        } else if (resultvalue<18.5) {
            bmiType.setText("Under Weight!");
            bmiType.setTextColor(getResources().getColor(R.color.yellow));


           // layout.setBackgroundResource(R.drawable.underweightback);

        }

        else if (resultvalue>29.9) {
            bmiType.setText("Obese!");
            bmiType.setTextColor(getResources().getColor(R.color.red));


            // layout.setBackgroundResource(R.drawable.underweightback);

        }

    }
}