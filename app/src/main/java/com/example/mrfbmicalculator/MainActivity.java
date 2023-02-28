package com.example.mrfbmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import soup.neumorphism.NeumorphButton;

public class MainActivity extends AppCompatActivity {
    NeumorphButton btn;
    RadioGroup radioGroup;
    NeumorphButton calculate;
    EditText ageEt,HeightEt,weightEt;
    ImageView genderPic;
    RadioButton checkedbtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        radioGroup = findViewById(R.id.groupradio);
        calculate = (NeumorphButton)findViewById(R.id.calculation);
        ageEt=findViewById(R.id.age);
        weightEt=findViewById(R.id.weight);
        HeightEt=findViewById(R.id.height);
        genderPic = findViewById(R.id.genderimg);


             checkedbtn =(RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                checkedbtn = (RadioButton) findViewById(i);
             if(checkedbtn.getText().equals("Male"))
             {
                 genderPic.setImageResource(R.drawable.boy);
             }
             else if(checkedbtn.getText().equals("Female"))
                {
                    genderPic.setImageResource(R.drawable.girl);
                }
             else if(checkedbtn.getText().equals("None"))
             {
                 genderPic.setImageResource(R.drawable.android);
             }



            }
        });


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 if(HeightEt.getText().toString().trim().equalsIgnoreCase(""))
                {
                    HeightEt.setError("Enter Height!");


                }

               else if(weightEt.getText().toString().trim().equalsIgnoreCase(""))
                {
                    weightEt.setError("Enter Weight!");

                }

                else {
                    double weight = Double.parseDouble(weightEt.getText().toString());
                    double height = Double.parseDouble(HeightEt.getText().toString());
                    height = height/100;
                    double BMI =(weight)/(height*height);

                    Toast.makeText(MainActivity.this, "BMI :"+String.format("%.2f",BMI), Toast.LENGTH_SHORT).show();
                     Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                     intent.putExtra("weight",String.valueOf(weight));
                     intent.putExtra("height",String.valueOf(height));
                     intent.putExtra("age",ageEt.getText().toString());
                     intent.putExtra("gender",checkedbtn.getText().toString());
                     intent.putExtra("result",String.format("%.2f",BMI));
                     startActivity(intent);

                }



            }
        });

    }
}