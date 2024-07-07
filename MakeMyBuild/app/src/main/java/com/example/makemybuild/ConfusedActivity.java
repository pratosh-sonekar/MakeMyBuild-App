package com.example.makemybuild;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConfusedActivity extends AppCompatActivity {
    private Button ahead;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confused);
        ahead=findViewById(R.id.ahead);
        ahead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ConfusedActivity.this, BudgetActivity.class);
                startActivity(intent);
            }
        });
    }
}