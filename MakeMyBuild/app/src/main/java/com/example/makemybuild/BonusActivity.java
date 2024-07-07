package com.example.makemybuild;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.makemybuild.utils.PrefManager;

public class BonusActivity extends AppCompatActivity {
    private CheckBox office, utilities, creator, pro, dev, bombs;
    private Spinner spAntivirus;
    String[] sAntivirus = {"Select the breed","Norton", "McAfee", "Avast"};
    private Button rolling,goBack;
    String message;
    PrefManager prefManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonus);

        message="";
        spAntivirus=findViewById(R.id.spAntivirus);

        office=findViewById(R.id.office);
        utilities=findViewById(R.id.utilities);
        creator=findViewById(R.id.creator);
        pro=findViewById(R.id.pro);
        dev=findViewById(R.id.dev);
        bombs=findViewById(R.id.bombs);

        prefManager=new PrefManager(this);

        ArrayAdapter venType = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, sAntivirus);
        venType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spAntivirus.setAdapter(venType);

        rolling=findViewById(R.id.rolling);
        goBack=findViewById(R.id.goback);

        rolling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BonusActivity.this, SemiFinalActivity.class);
                finish();
                startActivity(intent);


                if (office.isChecked()){
                    message=message+""+office.getText().toString();
                    prefManager.saveMessage(message);
                }
                if (utilities.isChecked()){
                    message=message+""+utilities.getText().toString();
                    prefManager.saveMessage(message);
                }
                if (creator.isChecked()){
                    message=message+""+creator.getText().toString();
                    prefManager.saveMessage(message);
                }
                if (pro.isChecked()){
                    message=message+""+pro.getText().toString();
                    prefManager.saveMessage(message);
                }
                if (dev.isChecked()){
                    message=message+""+dev.getText().toString();
                    prefManager.saveMessage(message);
                }
                if (bombs.isChecked()){
                    message=message+""+bombs.getText().toString();
                    prefManager.saveMessage(message);
                }
            }
        });
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BonusActivity.this, RecommendActivity.class);
                startActivity(intent);
            }
        });


    }
}