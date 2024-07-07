package com.example.makemybuild;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.makemybuild.utils.PrefManager;
import com.google.android.material.slider.Slider;

public class BudgetActivity extends AppCompatActivity {
    String text;
    private Slider slider;
    PrefManager prefManager;
    private Spinner spType,spSide;
    private TextView currentValue,maxValue;
    private Button roll,confused;
    String[] sType = {"Select the breed","Gaming", "Editing", "Productivity"};
    String[] sSide = {"Choose your side", "Intel", "AMD"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);
        spType=findViewById(R.id.spType);
        spSide=findViewById(R.id.spSide);
        slider=findViewById(R.id.budget_slider);
        currentValue=findViewById(R.id.currentValue);
        maxValue=findViewById(R.id.maxValue);
        roll=findViewById(R.id.roll);
        prefManager=new PrefManager(this);
        confused=findViewById(R.id.confused);

        ArrayAdapter venType = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, sType);
        venType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spType.setAdapter(venType);

        ArrayAdapter venType1 = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, sSide);
        venType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSide.setAdapter(venType1);

        slider.addOnSliderTouchListener(new Slider.OnSliderTouchListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onStartTrackingTouch(@NonNull @org.jetbrains.annotations.NotNull Slider slider) {

            }

            @SuppressLint("RestrictedApi")
            @Override
            public void onStopTrackingTouch(@NonNull @org.jetbrains.annotations.NotNull Slider slider) {
                int val=(int) slider.getValue();
                prefManager.saveBudget(val);
                String value= Integer.toString(val);
                currentValue.setText(value);
            }
        });
        spType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                text = (String) adapterView.getAdapter().getItem(i);
                prefManager.saveBreed(text);

                if (text.equals("Gaming")){
                    slider.setValue(50000);
                    slider.setValueTo(350000);
                    prefManager.saveBudget(50000);
                    currentValue.setText("50000");
                    maxValue.setText("350000");
                }
                else if (text.equals("Editing")){
                    slider.setValue(40000);
                    slider.setValueTo(250000);
                    prefManager.saveBudget(40000);
                    currentValue.setText("40000");
                    maxValue.setText("250000");
                }
                else if (text.equals("Productivity")){
                    slider.setValue(35000);
                    slider.setValueTo(50000);
                    prefManager.saveBudget(35000);
                    currentValue.setText("35000");
                    maxValue.setText("50000");
                }
                else if(text.equals("Select the breed")){
                    slider.setValue(0);
                    slider.setValueTo(350000);
                    currentValue.setText("0");
                    maxValue.setText("350000");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text.equals("Select the breed")){
                    Toast.makeText(BudgetActivity.this, "Please Choose the required items", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent=new Intent(BudgetActivity.this,RecommendActivity.class);
                    startActivity(intent);
                }
            }
        });
        confused.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BudgetActivity.this, ConfusedActivity.class);
                startActivity(intent);
            }
        });
    }
}