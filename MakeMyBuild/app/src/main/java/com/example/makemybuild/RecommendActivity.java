package com.example.makemybuild;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.makemybuild.utils.PrefManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class RecommendActivity extends AppCompatActivity {
    int cpu_pricee,gpu_pricee, ram_pricee,mb_pricee,cabinet_pricee,ssd_pricee;
    private TextView as_250GB,as_1TB,ah_500GB,ah_2TB,ar_8GB,ar_32GB,asprice250GB,asprice1TB,ahprice500GB,ahprice2TB,arprice8GB,arprice32GB;
    private LinearLayout productivity, gaming, editing,customise;
    boolean play=true,play2=true,play3=true,play4=true,play5=true,play6=true,play7=true,play8=true,play9=true,play10=true;
    private TextView productivityTv,editingTv,gamingTv;
    PrefManager prefManager;
    private Button lets_roll;
    private int totalBudget;
    private int budget2;
    private TextView totalTag;
    private int priceFixedComp;
    private int flag;
    int hdd_pricee,cooler_pricee;
    private TextView entered_budget,estimated_budget,finalTotal;
    private TextView coolertag,coolermodel,coolerpricee,coolerdesc,hddtag,mbmodel,mbpricee,mbdesc,hddmodel,hddpricee,hdddesc,gpumodel,gputag,gpupricee,gpudesc,rammodel,ramprice,ramdesc,cpumodel,cpupricee,cpudesc,ssdmodel,ssdprice,ssddesc,cabinetmodel,cabinetprice,cabinetdesc,psumodel,psuprice,psudesc;
    private TextView monitorprice,keyboardprice,mouseprice,monitordesc,keyboarddesc,mousedesc;
    private Spinner sp_mouse,sp_keyboard,sp_monitor;
    String[] sMonitor = {"Select the component","AOC 23.6' Curved Monitor (144Hz)", "AOC 23.8' Borderless", "AOC 24.5' Gaming 1ms  144Hz","Acer Nitro 21.5' Gaming 1ms 75Hz","BenQ 24' 1080p 60Hz"};
    String[] sKeyboard = {"Select the component", "Dell Wired Keyboard", "Logitech Compact Wireless Keyboard", "Logitech Wired Keyboard","CosmicByte CB GK -16 Mechanical Gaming Keyboard","Logitech G213 Poridigy Lightsync Gaming Keyboard"};
    String[] sMouse = {"Select the component", "Logitech/Dell/HP Wired (Basic)", "Logitech Wireless (Basic)", "Logitech G102 Gaming Mouse","Logitech G402 Hyperion Fury","Logitech G502 High Performance"};
    private LinearLayout SSD_250GB,SSD_1TB,HDD_500GB,HDD_2TB,NO_HDD,RAM_8GB,RAM_32GB;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);
        customise=findViewById(R.id.customise);
        lets_roll=findViewById(R.id.lets_roll);
        customise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RecommendActivity.this, CustomiseActivity.class);
                startActivity(intent);
            }
        });
        gputag=findViewById(R.id.gputag);
        finalTotal=findViewById(R.id.finalTotal);
        SSD_250GB=findViewById(R.id.SSD_250GB);
        SSD_1TB=findViewById(R.id.SSD_1TB);
        HDD_500GB=findViewById(R.id.HDD_500GB);
        HDD_2TB=findViewById(R.id.HDD_2TB);
        NO_HDD=findViewById(R.id.NO_HDD);
        RAM_8GB=findViewById(R.id.RAM_8GB);
        RAM_32GB=findViewById(R.id.RAM_32GB);

        monitorprice=findViewById(R.id.monitor_price);
        keyboardprice=findViewById(R.id.keyboard_price);
        mouseprice=findViewById(R.id.mouse_price);
        monitordesc=findViewById(R.id.monitor_desc);
        keyboarddesc=findViewById(R.id.keyboard_desc);
        mousedesc=findViewById(R.id.mouse_desc);

        sp_mouse=findViewById(R.id.spmouse);
        sp_keyboard=findViewById(R.id.spkeyboard);
        sp_monitor=findViewById(R.id.spmonitor);



        entered_budget=findViewById(R.id.entered_budget);
        estimated_budget=findViewById(R.id.estimated_budget);
        coolertag=findViewById(R.id.coolertag);
        coolermodel=findViewById(R.id.coolermodel);
        coolerpricee=findViewById(R.id.coolerprice);
        coolerdesc=findViewById(R.id.coolerdesc);
        hddtag=findViewById(R.id.hddtag);
        mbmodel=findViewById(R.id.mbmodel);
        mbdesc=findViewById(R.id.mbdesc);
        mbpricee=findViewById(R.id.mbprice);
        hddmodel=findViewById(R.id.hddmodel);
        hdddesc=findViewById(R.id.hdddesc);
        hddpricee=findViewById(R.id.hddprice);
        productivity=findViewById(R.id.productivity);
        gaming=findViewById(R.id.gaming);
        editing=findViewById(R.id.editing);
        prefManager=new PrefManager(this);
        productivityTv=findViewById(R.id.productivityTv);
        gamingTv=findViewById(R.id.gamingTv);
        editingTv=findViewById(R.id.editingTv);
        rammodel=findViewById(R.id.rammodel);
        ramprice=findViewById(R.id.ramprice);
        ramdesc=findViewById(R.id.ramdesc);
        cpumodel=findViewById(R.id.cpumodel);
        cpudesc=findViewById(R.id.cpudesc);
        cpupricee=findViewById(R.id.cpuprice);
        ssdmodel=findViewById(R.id.ssdmodel);
        ssddesc=findViewById(R.id.ssddesc);
        ssdprice=findViewById(R.id.ssdprice);
        cabinetmodel=findViewById(R.id.cabinetmodel);
        cabinetdesc=findViewById(R.id.cabinetdesc);
        cabinetprice=findViewById(R.id.cabinetprice);
        psumodel=findViewById(R.id.psumodel);
        psudesc=findViewById(R.id.psudesc);
        psuprice=findViewById(R.id.psuprice);
        gpumodel=findViewById(R.id.gpumodel);
        gpudesc=findViewById(R.id.gpudesc);
        gpupricee=findViewById(R.id.gpuprice);

        lets_roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RecommendActivity.this, BonusActivity.class);
                startActivity(intent);
            }
        });
        /*productivity.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                if (play)
                {productivity.setBackgroundResource(R.drawable.rounded_corners);
                    editing.setBackgroundResource(R.drawable.google_button);
                    gaming.setBackgroundResource(R.drawable.google_button);
                }
                else{
                    productivity.setBackgroundResource(R.drawable.google_button);

                }
                play=!play;
            }
        });
        gaming.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                if (play2)
                {
                    gaming.setBackgroundResource(R.drawable.rounded_corners);
                    editing.setBackgroundResource(R.drawable.google_button);
                    productivity.setBackgroundResource(R.drawable.google_button);
                }
                else{
                    gaming.setBackgroundResource(R.drawable.google_button);
                }
                play2=!play2;
            }
        });
        editing.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                if (play3)
                {
                    editing.setBackgroundResource(R.drawable.rounded_corners);
                    productivity.setBackgroundResource(R.drawable.google_button);
                    gaming.setBackgroundResource(R.drawable.google_button);
                }
                else{
                    editing.setBackgroundResource(R.drawable.google_button);
                }
                play3=!play3;
            }
        });*/
        if (prefManager.getBreed().equals("Gaming")){
            gaming.setBackgroundResource(R.drawable.rounded_corners);
            Toast.makeText(this, "xx"+prefManager.getBudget(), Toast.LENGTH_SHORT).show();
        }
        else if (prefManager.getBreed().equals("Productivity")){
            productivity.setBackgroundResource(R.drawable.rounded_corners);
        }
        else {
            editing.setBackgroundResource(R.drawable.rounded_corners);
        }
        totalBudget=prefManager.getBudget();
        if (prefManager.getBreed().equals("Gaming")){
        if (totalBudget>=50000 && totalBudget<=70000){
            try {
                flag=1;
                coolerpricee.setVisibility(View.GONE);
                coolerdesc.setVisibility(View.GONE);
                coolermodel.setVisibility(View.GONE);
                coolertag.setVisibility(View.GONE);

                hddpricee.setVisibility(View.GONE);
                hdddesc.setVisibility(View.GONE);
                hddmodel.setVisibility(View.GONE);
                hddtag.setVisibility(View.GONE);

                parseRam(flag);
                parseSSD(flag);
                parseCabinet(flag);
                parsePSU(flag);
                budget2=totalBudget-priceFixedComp;
                int gpuprice= (int) (0.5*budget2);
                int cpuprice=(int) (0.35*budget2);
                int mbprice=(int) (0.15*budget2);
                parseGPU(gpuprice,flag);
                parseCPU(cpuprice,flag);
                parseMb(mbprice,flag);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        else if(totalBudget>70000 && totalBudget<=100000){
            try {
                coolerpricee.setVisibility(View.GONE);
                coolerdesc.setVisibility(View.GONE);
                coolermodel.setVisibility(View.GONE);
                coolertag.setVisibility(View.GONE);

                hddpricee.setVisibility(View.VISIBLE);
                hdddesc.setVisibility(View.VISIBLE);
                hddmodel.setVisibility(View.VISIBLE);
                hddtag.setVisibility(View.VISIBLE);
                flag=2;
                parseRam(flag);
                parseSSD(flag);
                parseHDD(flag);
                parseCabinet(flag);
                parsePSU(flag);
                budget2=totalBudget-priceFixedComp;
                int gpuprice= (int) (0.5*budget2);
                int cpuprice=(int) (0.3*budget2);
                int mbprice=(int) (0.2*budget2);
                parseGPU(gpuprice,flag);
                parseCPU(cpuprice,flag);
                parseMb(mbprice,flag);
            }catch (JSONException e){

            }
        }
        else if(totalBudget>100000 && totalBudget<=150000){
            try {
                coolerpricee.setVisibility(View.VISIBLE);
                coolerdesc.setVisibility(View.VISIBLE);
                coolermodel.setVisibility(View.VISIBLE);
                coolertag.setVisibility(View.VISIBLE);

                hddpricee.setVisibility(View.VISIBLE);
                hdddesc.setVisibility(View.VISIBLE);
                hddmodel.setVisibility(View.VISIBLE);
                hddtag.setVisibility(View.VISIBLE);
                flag=3;
                parseRam(flag);
                parseSSD(flag);
                parseHDD(flag);
                parseCabinet(flag);
                parsePSU(flag);
                budget2=totalBudget-priceFixedComp;
                int gpuprice= (int) (0.5*budget2);
                int cpuprice=(int) (0.25*budget2);
                int mbprice=(int) (0.17*budget2);
                int coolerprice=(int) (0.03*budget2);
                parseGPU(gpuprice,flag);
                parseCPU(cpuprice,flag);
                parseMb(mbprice,flag);
                parseCooler(coolerprice,flag);
            }catch (JSONException e){

            }
        }
        else if (totalBudget>150000 && totalBudget<=250000){
            try {
                coolerpricee.setVisibility(View.VISIBLE);
                coolerdesc.setVisibility(View.VISIBLE);
                coolermodel.setVisibility(View.VISIBLE);
                coolertag.setVisibility(View.VISIBLE);

                hddpricee.setVisibility(View.VISIBLE);
                hdddesc.setVisibility(View.VISIBLE);
                hddmodel.setVisibility(View.VISIBLE);
                hddtag.setVisibility(View.VISIBLE);
                flag=4;
                parseRam(flag);
                parseSSD(flag);
                parseHDD(flag);
                parseCabinet(flag);
                parsePSU(flag);
                budget2=totalBudget-priceFixedComp;
                int gpuprice= (int) (0.6*budget2);
                int cpuprice=(int) (0.2*budget2);
                int mbprice=(int) (0.15*budget2);
                int coolerprice=(int) (0.05*budget2);
                parseGPU(gpuprice,flag);
                parseCPU(cpuprice,flag);
                parseMb(mbprice,flag);
                parseCooler(coolerprice,flag);
            }catch (JSONException e){

            }
        }
        else{
            try {
                coolerpricee.setVisibility(View.VISIBLE);
                coolerdesc.setVisibility(View.VISIBLE);
                coolermodel.setVisibility(View.VISIBLE);
                coolertag.setVisibility(View.VISIBLE);

                hddpricee.setVisibility(View.VISIBLE);
                hdddesc.setVisibility(View.VISIBLE);
                hddmodel.setVisibility(View.VISIBLE);
                hddtag.setVisibility(View.VISIBLE);
                flag=5;

                parseRam(flag);
                parseSSD(flag);
                parseHDD(flag);
                parseCabinet(flag);
                parsePSU(flag);
                budget2=totalBudget-priceFixedComp;

                int gpuprice= (int) (0.6*budget2);
                int cpuprice=(int) (0.2*budget2);
                int mbprice=(int) (0.15*budget2);
                int coolerprice=(int) (0.05*budget2);
                parseGPU(gpuprice,flag);
                parseCPU(cpuprice,flag);
                parseMb(mbprice,flag);
                parseCooler(coolerprice,flag);
            }catch (JSONException e){

            }
        }
        }
        else if (prefManager.getBreed().equals("Productivity")){
            if (totalBudget>=30000 && totalBudget<=50000){
             try {
                flag=6;
                coolerpricee.setVisibility(View.GONE);
                coolerdesc.setVisibility(View.GONE);
                coolermodel.setVisibility(View.GONE);
                coolertag.setVisibility(View.GONE);

                hddpricee.setVisibility(View.GONE);
                hdddesc.setVisibility(View.GONE);
                hddmodel.setVisibility(View.GONE);
                hddtag.setVisibility(View.GONE);

                 gpupricee.setVisibility(View.GONE);
                 gpudesc.setVisibility(View.GONE);
                 gpumodel.setVisibility(View.GONE);
                 gputag.setVisibility(View.GONE);

                parseRam(flag);
                parseSSD(flag);
                parseCabinet(flag);
                parsePSU(flag);
                budget2=totalBudget-priceFixedComp;
                int cpuprice=(int) (0.7*budget2);
                int mbprice=(int) (0.3*budget2);
                parseAPU(cpuprice,flag);
                parseMb(mbprice,flag);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            }
            else if (totalBudget>50000 && totalBudget<=80000){
                try {
                    flag=7;
                    coolerpricee.setVisibility(View.GONE);
                    coolerdesc.setVisibility(View.GONE);
                    coolermodel.setVisibility(View.GONE);
                    coolertag.setVisibility(View.GONE);

                    hddpricee.setVisibility(View.VISIBLE);
                    hdddesc.setVisibility(View.VISIBLE);
                    hddmodel.setVisibility(View.VISIBLE);
                    hddtag.setVisibility(View.VISIBLE);

                    parseRam(flag);
                    parseSSD(flag);
                    parseCabinet(flag);
                    parsePSU(flag);
                    parseHDD(flag);
                    budget2=totalBudget-priceFixedComp;
                    int gpuprice= (int) (0.25*budget2);
                    int cpuprice=(int) (0.25*budget2);
                    int mbprice=(int) (0.5*budget2);
                    parseGPU(gpuprice,flag);
                    parseAPU(cpuprice,flag);
                    parseMb(mbprice,flag);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        else if (prefManager.getBreed().equals("Editing")){
            if (totalBudget>=40000 && totalBudget<=70000){
                try {
                    flag=8;
                    coolerpricee.setVisibility(View.GONE);
                    coolerdesc.setVisibility(View.GONE);
                    coolermodel.setVisibility(View.GONE);
                    coolertag.setVisibility(View.GONE);

                    hddpricee.setVisibility(View.GONE);
                    hdddesc.setVisibility(View.GONE);
                    hddmodel.setVisibility(View.GONE);
                    hddtag.setVisibility(View.GONE);

                    parseRam(flag);
                    parseSSD(flag);
                    parseCabinet(flag);
                    parsePSU(flag);
                    budget2=totalBudget-priceFixedComp;
                    int gpuprice= (int) (0.20*budget2);
                    int cpuprice=(int) (0.55*budget2);
                    int mbprice=(int) (0.25*budget2);
                    parseGPU(gpuprice,flag);
                    parseCPU(cpuprice,flag);
                    parseMb(mbprice,flag);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            else if (totalBudget>70000 && totalBudget<=100000){
                try {
                    flag=9;
                    coolerpricee.setVisibility(View.GONE);
                    coolerdesc.setVisibility(View.GONE);
                    coolermodel.setVisibility(View.GONE);
                    coolertag.setVisibility(View.GONE);

                    hddpricee.setVisibility(View.VISIBLE);
                    hdddesc.setVisibility(View.VISIBLE);
                    hddmodel.setVisibility(View.VISIBLE);
                    hddtag.setVisibility(View.VISIBLE);

                    parseRam(flag);
                    parseSSD(flag);
                    parseCabinet(flag);
                    parsePSU(flag);
                    parseHDD(flag);
                    budget2=totalBudget-priceFixedComp;
                    int gpuprice= (int) (0.2*budget2);
                    int cpuprice=(int) (0.55*budget2);
                    int mbprice=(int) (0.25*budget2);
                    parseGPU(gpuprice,flag);
                    parseCPU(cpuprice,flag);
                    parseMb(mbprice,flag);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            else if (totalBudget>100000 && totalBudget<=150000){
                try {
                    flag=10;
                    coolerpricee.setVisibility(View.GONE);
                    coolerdesc.setVisibility(View.GONE);
                    coolermodel.setVisibility(View.GONE);
                    coolertag.setVisibility(View.GONE);

                    hddpricee.setVisibility(View.VISIBLE);
                    hdddesc.setVisibility(View.VISIBLE);
                    hddmodel.setVisibility(View.VISIBLE);
                    hddtag.setVisibility(View.VISIBLE);

                    parseRam(flag);
                    parseSSD(flag);
                    parseCabinet(flag);
                    parsePSU(flag);
                    parseHDD(flag);
                    budget2=totalBudget-priceFixedComp;
                    int gpuprice= (int) (0.29*budget2);
                    int cpuprice=(int) (0.5*budget2);
                    int mbprice=(int) (0.15*budget2);
                    int coolerprice=(int) (0.06*budget2);
                    parseGPU(gpuprice,flag);
                    parseCPU(cpuprice,flag);
                    parseMb(mbprice,flag);
                    parseCooler(coolerprice,flag);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            else if(totalBudget>150000 && totalBudget<=250000){
                try {
                    flag=11;
                    coolerpricee.setVisibility(View.GONE);
                    coolerdesc.setVisibility(View.GONE);
                    coolermodel.setVisibility(View.GONE);
                    coolertag.setVisibility(View.GONE);

                    hddpricee.setVisibility(View.VISIBLE);
                    hdddesc.setVisibility(View.VISIBLE);
                    hddmodel.setVisibility(View.VISIBLE);
                    hddtag.setVisibility(View.VISIBLE);

                    parseRam(flag);
                    parseSSD(flag);
                    parseCabinet(flag);
                    parsePSU(flag);
                    parseHDD(flag);
                    budget2=totalBudget-priceFixedComp;
                    int gpuprice= (int) (0.4*budget2);
                    int cpuprice=(int) (0.37*budget2);
                    int mbprice=(int) (0.15*budget2);
                    int coolerprice=(int) (0.08*budget2);
                    parseGPU(gpuprice,flag);
                    parseCPU(cpuprice,flag);
                    parseMb(mbprice,flag);
                    parseCooler(coolerprice,flag);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        String budget=Integer.toString(prefManager.getBudget());
        entered_budget.setText(budget);

        try {
            cpu_pricee=Integer.valueOf(cpupricee.getText().toString());
            gpu_pricee=Integer.valueOf(gpupricee.getText().toString());
            ram_pricee=Integer.valueOf(ramprice.getText().toString());
            mb_pricee=Integer.valueOf(mbpricee.getText().toString());
            cabinet_pricee=Integer.valueOf(cabinetprice.getText().toString());
            ssd_pricee=Integer.valueOf(ssdprice.getText().toString());
        }catch (NumberFormatException ex){

        }

        if (hddpricee.getVisibility()==View.VISIBLE){
            hdd_pricee=Integer.valueOf(hddpricee.getText().toString());
        }
        int psu_pricee=Integer.valueOf(psuprice.getText().toString());
        if (coolerpricee.getVisibility()==View.VISIBLE) {
            cooler_pricee = Integer.valueOf(coolerpricee.getText().toString());
        }
        int our_budget=cpu_pricee+gpu_pricee+ram_pricee+mb_pricee+cabinet_pricee+ssd_pricee+hdd_pricee+psu_pricee+cooler_pricee;
        String our_budgett=Integer.toString(our_budget);
        estimated_budget.setText(our_budgett);

        ArrayAdapter venType = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, sMonitor);
        venType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_monitor.setAdapter(venType);

        ArrayAdapter venType1 = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, sKeyboard);
        venType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_keyboard.setAdapter(venType1);

        ArrayAdapter venType2 = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, sMouse);
        venType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_mouse.setAdapter(venType2);

        sp_monitor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String text = (String) adapterView.getAdapter().getItem(i);

                if (text.equals("Select the component")){
                    monitorprice.setText("0");
                }
                else if (text.equals("AOC 23.6' Curved Monitor (144Hz)")){
                    monitorprice.setText("15549");
                }
                else if (text.equals("AOC 23.8' Borderless")){
                    monitorprice.setText("11449");
                }
                else if (text.equals("AOC 24.5' Gaming 1ms  144Hz")){
                    monitorprice.setText("15749");
                }
                else if (text.equals("Acer Nitro 21.5' Gaming 1ms 75Hz")){
                    monitorprice.setText("10499");
                }
                else if (text.equals("BenQ 24' 1080p 60Hz")){
                    monitorprice.setText("13499");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        sp_keyboard.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String text = (String) adapterView.getAdapter().getItem(i);

                if (text.equals("Select the component")){
                    keyboardprice.setText("0");
                }
                else if (text.equals("Dell Wired Keyboard")){
                    keyboardprice.setText("599");
                }
                else if (text.equals("Logitech Compact Wireless Keyboard")){
                    keyboardprice.setText("799");
                }
                else if (text.equals("Logitech Wired Keyboard")){
                    keyboardprice.setText("699");
                }
                else if (text.equals("CosmicByte CB GK -16 Mechanical Gaming Keyboard")){
                    keyboardprice.setText("2299");
                }
                else if (text.equals("Logitech G213 Poridigy Lightsync Gaming Keyboard")){
                    keyboardprice.setText("3799");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        sp_mouse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String text = (String) adapterView.getAdapter().getItem(i);

                if (text.equals("Select the component")){
                    mouseprice.setText("0");
                }
                else if (text.equals("Logitech/Dell/HP Wired (Basic)")){
                    mouseprice.setText("249");
                }
                else if (text.equals("Logitech Wireless (Basic)")){
                    mouseprice.setText("549");
                }
                else if (text.equals("Logitech G102 Gaming Mouse")){
                    mouseprice.setText("1349");
                }
                else if (text.equals("Logitech G402 Hyperion Fury")){
                    mouseprice.setText("1999");
                }
                else if (text.equals("Logitech G502 High Performance")){
                    mouseprice.setText("3499");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        as_250GB=findViewById(R.id.as_250GB);
        as_1TB=findViewById(R.id.as_1TB);
        ah_500GB=findViewById(R.id.ah_500);
        ah_2TB=findViewById(R.id.ah_2TB);
        ar_8GB=findViewById(R.id.ar_8GB);
        ar_32GB=findViewById(R.id.ar_32GB);

        asprice250GB=findViewById(R.id.asprice250GB);
        asprice1TB=findViewById(R.id.asprice1TB);
        ahprice500GB=findViewById(R.id.ahprice500GB);
        ahprice2TB=findViewById(R.id.ahprice2TB);
        arprice8GB=findViewById(R.id.arprice8GB);
        arprice32GB=findViewById(R.id.arprice32GB);

        if (prefManager.getSSDCategory().equals("500 GB")){
            as_250GB.setText("250 GB");
            asprice250GB.setText("3500");

            as_1TB.setText("1 TB");
            asprice1TB.setText("12000");
        }
        else if (prefManager.getSSDCategory().equals("1TB")){
            as_250GB.setText("250 GB");
            asprice250GB.setText("3500");

            as_1TB.setText("500 GB");
            asprice1TB.setText("5000");
        }

        if (prefManager.getCategory().equals("1 TB")){
            ah_500GB.setText("500 GB");
            ahprice500GB.setText("3000");

            ah_2TB.setText("2 TB");
            ahprice2TB.setText("9000");
        }
        else if (prefManager.getCategory().equals("500 GB")){
            ah_500GB.setText("1 TB");
            ahprice500GB.setText("4500");

            ah_2TB.setText("2 TB");
            ahprice2TB.setText("9000");
        }
        else if (prefManager.getCategory().equals("2 TB")){
            ah_500GB.setText("500 GB");
            ahprice500GB.setText("3000");

            ah_2TB.setText("1 TB");
            ahprice2TB.setText("4500");
        }

        if (prefManager.getRAMCategory().equals("8 GB")){
            ar_8GB.setText("16 GB");
            arprice8GB.setText("7000");

            ar_32GB.setText("32 GB");
            arprice32GB.setText("19500");
        }
        else if (prefManager.getRAMCategory().equals("16 GB")){
            ar_8GB.setText("8 GB");
            arprice8GB.setText("3500");

            ar_32GB.setText("32 GB");
            arprice32GB.setText("19500");
        }
        else if (prefManager.getRAMCategory().equals("32 GB")){
            ar_8GB.setText("8 GB");
            arprice8GB.setText("3500");

            ar_8GB.setText("16 GB");
            arprice8GB.setText("7000");
        }
        SSD_250GB.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                if (play4)
                {SSD_250GB.setBackgroundResource(R.drawable.rounded_corners);
                    SSD_1TB.setBackgroundResource(R.drawable.google_button);
                    if (as_250GB.getText().toString().equals("250 GB")){
                        ssdmodel.setText("250 GB Nvme m.2");
                        ssdprice.setText(asprice250GB.getText().toString());

                    }
                    else if (as_250GB.getText().toString().equals("500 GB")){
                        ssdmodel.setText("500 GB Nvme m.2");
                        ssdprice.setText(asprice250GB.getText().toString());
                    }
                    else if (as_250GB.getText().toString().equals("1 TB")){
                        ssdmodel.setText("1 TB Nvme m.2");
                        ssdprice.setText(asprice250GB.getText().toString());
                    }
                }
                else{
                    SSD_250GB.setBackgroundResource(R.drawable.google_button);

                }
                play4=!play4;
            }
        });
        SSD_1TB.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                if (play5)
                {SSD_1TB.setBackgroundResource(R.drawable.rounded_corners);
                    SSD_250GB.setBackgroundResource(R.drawable.google_button);
                    if (as_1TB.getText().toString().equals("250 GB")){
                        ssdmodel.setText("250 GB Nvme m.2");
                        ssdprice.setText(asprice1TB.getText().toString());
                    }
                    else if (as_1TB.getText().toString().equals("500 GB")){
                        ssdmodel.setText("500 GB Nvme m.2");
                        ssdprice.setText(asprice1TB.getText().toString());
                    }
                    else if (as_1TB.getText().toString().equals("1 TB")){
                        ssdmodel.setText("1 TB Nvme m.2");
                        ssdprice.setText(asprice1TB.getText().toString());
                    }
                }
                else{
                    SSD_1TB.setBackgroundResource(R.drawable.google_button);

                }
                play5=!play5;
            }
        });
        HDD_500GB.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                if (play6)
                {HDD_500GB.setBackgroundResource(R.drawable.rounded_corners);
                    HDD_2TB.setBackgroundResource(R.drawable.google_button);
                    NO_HDD.setBackgroundResource(R.drawable.google_button);
                    hddpricee.setVisibility(View.VISIBLE);
                    hdddesc.setVisibility(View.VISIBLE);
                    hddmodel.setVisibility(View.VISIBLE);
                    hddtag.setVisibility(View.VISIBLE);
                    if (ah_500GB.getText().toString().equals("500 GB")){
                        hddmodel.setText("500 GB Standard");
                        hddpricee.setText(ahprice500GB.getText().toString());
                    }
                    else if (ah_500GB.getText().toString().equals("1 TB")){
                        hddmodel.setText("1 TB Standard");
                        hddpricee.setText(ahprice500GB.getText().toString());
                    }
                    else if (ah_500GB.getText().toString().equals("2 TB")){
                        hddmodel.setText("2 TB Standard");
                        hddpricee.setText(ahprice500GB.getText().toString());
                    }
                }
                else{
                    HDD_500GB.setBackgroundResource(R.drawable.google_button);

                }
                play6=!play6;
            }
        });
        HDD_2TB.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                if (play7)
                {HDD_2TB.setBackgroundResource(R.drawable.rounded_corners);
                    HDD_500GB.setBackgroundResource(R.drawable.google_button);
                    NO_HDD.setBackgroundResource(R.drawable.google_button);
                    hddpricee.setVisibility(View.VISIBLE);
                    hdddesc.setVisibility(View.VISIBLE);
                    hddmodel.setVisibility(View.VISIBLE);
                    hddtag.setVisibility(View.VISIBLE);

                    if (ah_2TB.getText().toString().equals("500 GB")){
                        hddmodel.setText("500 GB Standard");
                        hddpricee.setText(ahprice2TB.getText().toString());
                    }
                    else if (ah_2TB.getText().toString().equals("1 TB")){
                        hddmodel.setText("1 TB Standard");
                        hddpricee.setText(ahprice2TB.getText().toString());
                    }
                    else if (ah_2TB.getText().toString().equals("2 TB")){
                        hddmodel.setText("2 TB Standard");
                        hddpricee.setText(ahprice2TB.getText().toString());
                    }
                }
                else{
                    HDD_2TB.setBackgroundResource(R.drawable.google_button);

                }
                play7=!play7;
            }
        });
        NO_HDD.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                if (play8)
                {NO_HDD.setBackgroundResource(R.drawable.rounded_corners);
                    HDD_500GB.setBackgroundResource(R.drawable.google_button);
                    HDD_2TB.setBackgroundResource(R.drawable.google_button);
                    hddpricee.setVisibility(View.GONE);
                    hdddesc.setVisibility(View.GONE);
                    hddmodel.setVisibility(View.GONE);
                    hddtag.setVisibility(View.GONE);
                }
                else{
                    NO_HDD.setBackgroundResource(R.drawable.google_button);

                }
                play8=!play8;
            }
        });
        RAM_8GB.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                if (play9)
                {RAM_8GB.setBackgroundResource(R.drawable.rounded_corners);
                    RAM_32GB.setBackgroundResource(R.drawable.google_button);
                    if (ar_8GB.getText().toString().equals("8 GB")){
                        rammodel.setText("Ripjaws 8GB");
                        ramprice.setText(arprice8GB.getText().toString());
                    }
                    else if (ar_8GB.getText().toString().equals("16 GB")){
                        rammodel.setText("Ripjaws 16GB");
                        ramprice.setText(arprice8GB.getText().toString());
                    }
                    else if (ar_8GB.getText().toString().equals("32 GB")){
                        rammodel.setText("Trident 2 32GB");
                        ramprice.setText(arprice8GB.getText().toString());
                    }
                }
                else{
                    RAM_8GB.setBackgroundResource(R.drawable.google_button);

                }
                play9=!play9;
            }
        });
        RAM_32GB.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                if (play10)
                {RAM_32GB.setBackgroundResource(R.drawable.rounded_corners);
                    RAM_8GB.setBackgroundResource(R.drawable.google_button);
                    if (ar_32GB.getText().toString().equals("8 GB")){
                        rammodel.setText("Ripjaws 8GB");
                        ramprice.setText(arprice32GB.getText().toString());
                    }
                    else if (ar_32GB.getText().toString().equals("16 GB")){
                        rammodel.setText("Ripjaws 16GB");
                        ramprice.setText(arprice32GB.getText().toString());
                    }
                    else if (ar_32GB.getText().toString().equals("32 GB")){
                        rammodel.setText("Trident 2 32GB");
                        ramprice.setText(arprice32GB.getText().toString());
                    }
                }
                else{
                    RAM_32GB.setBackgroundResource(R.drawable.google_button);

                }
                play10=!play10;
            }
        });
        totalTag=findViewById(R.id.totaltag);
        totalTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cpu_pricee1=Integer.valueOf(cpupricee.getText().toString());
                int gpu_pricee1=Integer.valueOf(gpupricee.getText().toString());
                int ram_pricee1=Integer.valueOf(ramprice.getText().toString());
                int mb_pricee1=Integer.valueOf(mbpricee.getText().toString());
                int cabinet_pricee1=Integer.valueOf(cabinetprice.getText().toString());
                int ssd_pricee1=Integer.valueOf(ssdprice.getText().toString());
                int monitor_price1=Integer.valueOf(monitorprice.getText().toString());
                int keyboarc_price1=Integer.valueOf(keyboardprice.getText().toString());
                int mouse_price1=Integer.valueOf(mouseprice.getText().toString());
                int psu_pricee1=Integer.valueOf(psuprice.getText().toString());

                int hdd_pricee1=Integer.valueOf(hddpricee.getText().toString());
                prefManager.saveCPUModel(cpumodel.getText().toString());
                prefManager.saveGPUModel(gpumodel.getText().toString());
                prefManager.saveRAMModel(rammodel.getText().toString());
                prefManager.saveMotherboardModel(mbmodel.getText().toString());
                prefManager.saveCabinetModel(cabinetmodel.getText().toString());
                prefManager.saveSSDModel(ssdmodel.getText().toString());
                prefManager.saveHDDModel(hddmodel.getText().toString());
                prefManager.savePSUModel(psumodel.getText().toString());
                prefManager.saveCoolerModel(coolermodel.getText().toString());
                prefManager.saveMonitorModel(sp_monitor.getSelectedItem().toString());
                prefManager.saveMouseModel(sp_mouse.getSelectedItem().toString());
                prefManager.saveKeyboardModel(sp_keyboard.getSelectedItem().toString());

                prefManager.saveCPUPrice(cpupricee.getText().toString());
                prefManager.saveGPUPrice(gpupricee.getText().toString());
                prefManager.saveRAMPrice(ramprice.getText().toString());
                prefManager.saveMotherboardPrice(mbpricee.getText().toString());
                prefManager.saveCabinetPrice(cabinetprice.getText().toString());
                prefManager.saveSSDPrice(ssdprice.getText().toString());
                prefManager.saveHDDPrice(hddpricee.getText().toString());
                prefManager.savePSUPrice(psuprice.getText().toString());
                prefManager.saveCoolerPrice(coolerpricee.getText().toString());
                prefManager.saveMonitorPrice(monitorprice.getText().toString());
                prefManager.saveMousePrice(mouseprice.getText().toString());
                prefManager.saveKeyboardPrice(keyboardprice.getText().toString());

                prefManager.saveCPUDesc(cpudesc.getText().toString());
                prefManager.saveGPUDesc(gpudesc.getText().toString());
                prefManager.saveRAMDesc(ramdesc.getText().toString());
                prefManager.saveMotherboardDesc(mbdesc.getText().toString());
                prefManager.saveCabinetDesc(cabinetdesc.getText().toString());
                prefManager.saveSSDDesc(ssddesc.getText().toString());
                prefManager.saveHDDDesc(hdddesc.getText().toString());
                prefManager.savePSUDesc(psudesc.getText().toString());
                prefManager.saveCoolerDesc(coolerdesc.getText().toString());
                prefManager.saveMonitorDesc(monitordesc.getText().toString());
                prefManager.saveMouseDesc(mousedesc.getText().toString());
                prefManager.saveKeyboardDesc(keyboarddesc.getText().toString());

                int our_budget1=cpu_pricee1+gpu_pricee1+ram_pricee1+mb_pricee1+cabinet_pricee1+ssd_pricee1+hdd_pricee1+psu_pricee1+cooler_pricee+monitor_price1+keyboarc_price1+mouse_price1;
                String our_budgett1=Integer.toString(our_budget1);
                finalTotal.setText(our_budgett1);
            }
        });

    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void parseCooler(int coolerprice, int flag) throws JSONException {
        JSONObject jsonObject=new JSONObject(JsonDataFromAssetCooler(getApplicationContext()));
        JSONArray jsonArray=jsonObject.getJSONArray("cooler");
        for (int i=0;i<jsonArray.length();i++){
            JSONObject object=jsonArray.getJSONObject(i);
            int price=object.getInt("price");

            if (price<=coolerprice){
                String pricee=object.getString("price");
                String name=object.getString("cooler_name");
                String desc=object.getString("category");
                coolermodel.setText(name);
                coolerpricee.setText(pricee);
                coolerdesc.setText(desc);
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void parseHDD(int flag) throws JSONException {
        JSONObject jsonObject=new JSONObject(JsonDataFromAssetHDD(getApplicationContext()));
        JSONArray jsonArray=jsonObject.getJSONArray("hdd");
        for (int i=0;i<jsonArray.length();i++){
            JSONObject object=jsonArray.getJSONObject(i);
            String hdd_name=object.getString("hdd_name");
            if (flag==2) {
                if (hdd_name.equals("1 TB Standard")) {
                    String hdd_price = object.getString("price");
                    int price = object.getInt("price");
                    String category=object.getString("category");
                    prefManager.saveCategory(category);
                    priceFixedComp = priceFixedComp + price;
                    String hdd_desc = object.getString("desc");
                    hddmodel.setText(hdd_name);
                    hddpricee.setText(hdd_price);
                    hdddesc.setText(hdd_desc);
                }
            }
            else if (flag==3) {
                if (hdd_name.equals("1 TB Standard")) {
                    String hdd_price = object.getString("price");
                    int price = object.getInt("price");
                    String category=object.getString("category");
                    prefManager.saveCategory(category);
                    priceFixedComp = priceFixedComp + price;
                    String hdd_desc = object.getString("desc");
                    hddmodel.setText(hdd_name);
                    hddpricee.setText(hdd_price);
                    hdddesc.setText(hdd_desc);
                }
            }
            else if (flag==4) {
                if (hdd_name.equals("1 TB Standard")) {
                    String hdd_price = object.getString("price");
                    int price = object.getInt("price");
                    String category=object.getString("category");
                    prefManager.saveCategory(category);
                    priceFixedComp = priceFixedComp + price;
                    String hdd_desc = object.getString("desc");
                    hddmodel.setText(hdd_name);
                    hddpricee.setText(hdd_price);
                    hdddesc.setText(hdd_desc);
                }
            }
            else if (flag==5) {
                if (hdd_name.equals("1 TB Standard")) {
                    String hdd_price = object.getString("price");
                    int price = object.getInt("price");
                    String category=object.getString("category");
                    prefManager.saveCategory(category);
                    priceFixedComp = priceFixedComp + price;
                    String hdd_desc = object.getString("desc");
                    hddmodel.setText(hdd_name);
                    hddpricee.setText(hdd_price);
                    hdddesc.setText(hdd_desc);
                }
            }
            else if (flag==7) {
                if (hdd_name.equals("1 TB Standard")) {
                    String hdd_price = object.getString("price");
                    int price = object.getInt("price");
                    String category=object.getString("category");
                    prefManager.saveCategory(category);
                    priceFixedComp = priceFixedComp + price;
                    String hdd_desc = object.getString("desc");
                    hddmodel.setText(hdd_name);
                    hddpricee.setText(hdd_price);
                    hdddesc.setText(hdd_desc);
                }
            }
            else if (flag==9) {
                if (hdd_name.equals("1 TB Standard")) {
                    String hdd_price = object.getString("price");
                    int price = object.getInt("price");
                    String category=object.getString("category");
                    prefManager.saveCategory(category);
                    priceFixedComp = priceFixedComp + price;
                    String hdd_desc = object.getString("desc");
                    hddmodel.setText(hdd_name);
                    hddpricee.setText(hdd_price);
                    hdddesc.setText(hdd_desc);
                }
            }
            else if (flag==10) {
                if (hdd_name.equals("1 TB Standard")) {
                    String hdd_price = object.getString("price");
                    int price = object.getInt("price");
                    String category=object.getString("category");
                    prefManager.saveCategory(category);
                    priceFixedComp = priceFixedComp + price;
                    String hdd_desc = object.getString("desc");
                    hddmodel.setText(hdd_name);
                    hddpricee.setText(hdd_price);
                    hdddesc.setText(hdd_desc);
                }
            }
            else if (flag==11) {
                if (hdd_name.equals("1 TB Standard")) {
                    String hdd_price = object.getString("price");
                    int price = object.getInt("price");
                    String category=object.getString("category");
                    prefManager.saveCategory(category);
                    priceFixedComp = priceFixedComp + price;
                    String hdd_desc = object.getString("desc");
                    hddmodel.setText(hdd_name);
                    hddpricee.setText(hdd_price);
                    hdddesc.setText(hdd_desc);
                }
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void parseMb(int mbprice,int flag) throws JSONException {
        JSONObject jsonObject=new JSONObject(JsonDataFromAssetMB(getApplicationContext()));
        JSONArray jsonArray=jsonObject.getJSONArray("motherboard");
        for (int i=0;i<jsonArray.length();i++){
            JSONObject object=jsonArray.getJSONObject(i);
            int price=object.getInt("price");

            if (price<=mbprice){
                String pricee=object.getString("price");
                String name=object.getString("mother_name");
                String desc=object.getString("desc");
                mbmodel.setText(name);
                mbpricee.setText(pricee);
                mbdesc.setText(desc);
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void parseCPU(int cpuprice,int flag) throws JSONException{
        JSONObject jsonObject=new JSONObject(JsonDataFromAssetCPU(getApplicationContext()));
        JSONArray jsonArray=jsonObject.getJSONArray("cpu");
        for (int i=0;i<jsonArray.length();i++){
            JSONObject object=jsonArray.getJSONObject(i);
            int price=object.getInt("price");

            if (price<=cpuprice){
                String pricee=object.getString("price");
                String name=object.getString("cpu_name");
                String desc=object.getString("desc");
                cpumodel.setText(name);
                cpupricee.setText(pricee);
                cpudesc.setText(desc);
            }
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void parseAPU(int cpuprice,int flag) throws JSONException{
        JSONObject jsonObject=new JSONObject(JsonDataFromAssetAPU(getApplicationContext()));
        JSONArray jsonArray=jsonObject.getJSONArray("apu");
        for (int i=0;i<jsonArray.length();i++){
            JSONObject object=jsonArray.getJSONObject(i);
            int price=object.getInt("price");

            if (price<=cpuprice){
                String pricee=object.getString("price");
                String name=object.getString("apu_name");
                String desc=object.getString("desc");
                cpumodel.setText(name);
                cpupricee.setText(pricee);
                cpudesc.setText(desc);
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void parseGPU(int gpuprice, int flag) throws JSONException{
        JSONObject jsonObject=new JSONObject(JsonDataFromAssetGPU(getApplicationContext()));
        JSONArray jsonArray=jsonObject.getJSONArray("gpu");
        for (int i=0;i<jsonArray.length();i++){
            JSONObject object=jsonArray.getJSONObject(i);
            int price=object.getInt("price");

            if (price<=gpuprice){
                String pricee=object.getString("price");
                String name=object.getString("gpu_name");
                String desc=object.getString("desc");
                gpumodel.setText(name);
                gpupricee.setText(pricee);
                gpudesc.setText(desc);
            }
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void parsePSU(int flag) throws JSONException{
        JSONObject jsonObject=new JSONObject(JsonDataFromAssetPSU(getApplicationContext()));
        JSONArray jsonArray=jsonObject.getJSONArray("powersupply");
        for (int i=0;i<jsonArray.length();i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            String powersupply_name = object.getString("powersupply_name");
            if (flag == 1) {
                if (powersupply_name.equals("450W Coolermaster")) {
                    String powersupply_price = object.getString("price");
                    int price = object.getInt("price");
                    priceFixedComp = priceFixedComp + price;
                    String powersupply_desc = object.getString("desc");
                    psumodel.setText(powersupply_name);
                    psuprice.setText(powersupply_price);
                    psudesc.setText(powersupply_desc);
                }
            }
            else if (flag==2){
                if (powersupply_name.equals("550W Coolermaster")) {
                    String powersupply_price = object.getString("price");
                    int price = object.getInt("price");
                    priceFixedComp = priceFixedComp + price;
                    String powersupply_desc = object.getString("desc");
                    psumodel.setText(powersupply_name);
                    psuprice.setText(powersupply_price);
                    psudesc.setText(powersupply_desc);
                }
            }
            else if (flag==3){
                if (powersupply_name.equals("650W Coolermaster")) {
                    String powersupply_price = object.getString("price");
                    int price = object.getInt("price");
                    priceFixedComp = priceFixedComp + price;
                    String powersupply_desc = object.getString("desc");
                    psumodel.setText(powersupply_name);
                    psuprice.setText(powersupply_price);
                    psudesc.setText(powersupply_desc);
                }
            }
            else if (flag==4){
                if (powersupply_name.equals("750W Gigabyte")) {
                    String powersupply_price = object.getString("price");
                    int price = object.getInt("price");
                    priceFixedComp = priceFixedComp + price;
                    String powersupply_desc = object.getString("desc");
                    psumodel.setText(powersupply_name);
                    psuprice.setText(powersupply_price);
                    psudesc.setText(powersupply_desc);
                }
            }
            else if (flag==5){
                if (powersupply_name.equals("750W Gigabyte")) {
                    String powersupply_price = object.getString("price");
                    int price = object.getInt("price");
                    priceFixedComp = priceFixedComp + price;
                    String powersupply_desc = object.getString("desc");
                    psumodel.setText(powersupply_name);
                    psuprice.setText(powersupply_price);
                    psudesc.setText(powersupply_desc);
                }
            }
            else if (flag==6){
                if (powersupply_name.equals("450W Coolermaster")) {
                    String powersupply_price = object.getString("price");
                    int price = object.getInt("price");
                    priceFixedComp = priceFixedComp + price;
                    String powersupply_desc = object.getString("desc");
                    psumodel.setText(powersupply_name);
                    psuprice.setText(powersupply_price);
                    psudesc.setText(powersupply_desc);
                }
            }
            else if (flag==7){
                if (powersupply_name.equals("550W Gigabyte")) {
                    String powersupply_price = object.getString("price");
                    int price = object.getInt("price");
                    priceFixedComp = priceFixedComp + price;
                    String powersupply_desc = object.getString("desc");
                    psumodel.setText(powersupply_name);
                    psuprice.setText(powersupply_price);
                    psudesc.setText(powersupply_desc);
                }
            }
            else if (flag==8){
                if (powersupply_name.equals("450W Coolermaster")) {
                    String powersupply_price = object.getString("price");
                    int price = object.getInt("price");
                    priceFixedComp = priceFixedComp + price;
                    String powersupply_desc = object.getString("desc");
                    psumodel.setText(powersupply_name);
                    psuprice.setText(powersupply_price);
                    psudesc.setText(powersupply_desc);
                }
            }
            else if (flag==9){
                if (powersupply_name.equals("550W Gigabyte")) {
                    String powersupply_price = object.getString("price");
                    int price = object.getInt("price");
                    priceFixedComp = priceFixedComp + price;
                    String powersupply_desc = object.getString("desc");
                    psumodel.setText(powersupply_name);
                    psuprice.setText(powersupply_price);
                    psudesc.setText(powersupply_desc);
                }
            }
            else if (flag==10){
                if (powersupply_name.equals("650W Coolermaster")) {
                    String powersupply_price = object.getString("price");
                    int price = object.getInt("price");
                    priceFixedComp = priceFixedComp + price;
                    String powersupply_desc = object.getString("desc");
                    psumodel.setText(powersupply_name);
                    psuprice.setText(powersupply_price);
                    psudesc.setText(powersupply_desc);
                }
            }
            else if (flag==11){
                if (powersupply_name.equals("750W Gigabyte")) {
                    String powersupply_price = object.getString("price");
                    int price = object.getInt("price");
                    priceFixedComp = priceFixedComp + price;
                    String powersupply_desc = object.getString("desc");
                    psumodel.setText(powersupply_name);
                    psuprice.setText(powersupply_price);
                    psudesc.setText(powersupply_desc);
                }
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void parseCabinet(int flag) throws JSONException {
        JSONObject jsonObject=new JSONObject(JsonDataFromAssetCabinet(getApplicationContext()));
        JSONArray jsonArray=jsonObject.getJSONArray("cabinet");
        for (int i=0;i<jsonArray.length();i++){
            JSONObject object=jsonArray.getJSONObject(i);
            String cabinet_name=object.getString("cabinet_name");
            if (flag==1){
                if (cabinet_name.equals("ANT ESPORTS 320TG")){
                    String cabinet_price=object.getString("price");
                    int price=object.getInt("price");
                    priceFixedComp=priceFixedComp+price;
                    String cabinet_desc=object.getString("desc");
                    cabinetmodel.setText(cabinet_name);
                    cabinetprice.setText(cabinet_price);
                    cabinetdesc.setText(cabinet_desc);
                }
            }
            else if (flag==2){
                if (cabinet_name.equals("COOLER MASTER K 501")){
                    String cabinet_price=object.getString("price");
                    int price=object.getInt("price");
                    priceFixedComp=priceFixedComp+price;
                    String cabinet_desc=object.getString("desc");
                    cabinetmodel.setText(cabinet_name);
                    cabinetprice.setText(cabinet_price);
                    cabinetdesc.setText(cabinet_desc);
                }
            }
            else if (flag==3){
                if (cabinet_name.equals("ANTEC NX 800 (BLACK)")){
                    String cabinet_price=object.getString("price");
                    int price=object.getInt("price");
                    priceFixedComp=priceFixedComp+price;
                    String cabinet_desc=object.getString("desc");
                    cabinetmodel.setText(cabinet_name);
                    cabinetprice.setText(cabinet_price);
                    cabinetdesc.setText(cabinet_desc);
                }
            }
            else if (flag==4){
                if (cabinet_name.equals("ANTEC NX 800 (WHITE)")){
                    String cabinet_price=object.getString("price");
                    int price=object.getInt("price");
                    priceFixedComp=priceFixedComp+price;
                    String cabinet_desc=object.getString("desc");
                    cabinetmodel.setText(cabinet_name);
                    cabinetprice.setText(cabinet_price);
                    cabinetdesc.setText(cabinet_desc);
                }
            }
            else if (flag==5){
                if (cabinet_name.equals("ANTEC NX 800 (WHITE)")){
                    String cabinet_price=object.getString("price");
                    int price=object.getInt("price");
                    priceFixedComp=priceFixedComp+price;
                    String cabinet_desc=object.getString("desc");
                    cabinetmodel.setText(cabinet_name);
                    cabinetprice.setText(cabinet_price);
                    cabinetdesc.setText(cabinet_desc);
                }
            }
            else if (flag==6){
                if (cabinet_name.equals("ANT ESPORTS 320TG")){
                    String cabinet_price=object.getString("price");
                    int price=object.getInt("price");
                    priceFixedComp=priceFixedComp+price;
                    String cabinet_desc=object.getString("desc");
                    cabinetmodel.setText(cabinet_name);
                    cabinetprice.setText(cabinet_price);
                    cabinetdesc.setText(cabinet_desc);
                }
            }
            else if (flag==7){
                if (cabinet_name.equals("ANT ESPORTS 320TG")){
                    String cabinet_price=object.getString("price");
                    int price=object.getInt("price");
                    priceFixedComp=priceFixedComp+price;
                    String cabinet_desc=object.getString("desc");
                    cabinetmodel.setText(cabinet_name);
                    cabinetprice.setText(cabinet_price);
                    cabinetdesc.setText(cabinet_desc);
                }
            }
            else if (flag==8){
                if (cabinet_name.equals("ANT ESPORTS 320TG")){
                    String cabinet_price=object.getString("price");
                    int price=object.getInt("price");
                    priceFixedComp=priceFixedComp+price;
                    String cabinet_desc=object.getString("desc");
                    cabinetmodel.setText(cabinet_name);
                    cabinetprice.setText(cabinet_price);
                    cabinetdesc.setText(cabinet_desc);
                }
            }
            else if (flag==9){
                if (cabinet_name.equals("COOLER MASTER K 501")){
                    String cabinet_price=object.getString("price");
                    int price=object.getInt("price");
                    priceFixedComp=priceFixedComp+price;
                    String cabinet_desc=object.getString("desc");
                    cabinetmodel.setText(cabinet_name);
                    cabinetprice.setText(cabinet_price);
                    cabinetdesc.setText(cabinet_desc);
                }
            }
            else if (flag==10){
                if (cabinet_name.equals("ANTEC NX 800 (BLACK)")){
                    String cabinet_price=object.getString("price");
                    int price=object.getInt("price");
                    priceFixedComp=priceFixedComp+price;
                    String cabinet_desc=object.getString("desc");
                    cabinetmodel.setText(cabinet_name);
                    cabinetprice.setText(cabinet_price);
                    cabinetdesc.setText(cabinet_desc);
                }
            }
            else if (flag==11){
                if (cabinet_name.equals("ANTEC NX 800 (WHITE)")){
                    String cabinet_price=object.getString("price");
                    int price=object.getInt("price");
                    priceFixedComp=priceFixedComp+price;
                    String cabinet_desc=object.getString("desc");
                    cabinetmodel.setText(cabinet_name);
                    cabinetprice.setText(cabinet_price);
                    cabinetdesc.setText(cabinet_desc);
                }
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void parseSSD(int flag) throws JSONException {
        JSONObject jsonObject=new JSONObject(JsonDataFromAssetSSD(getApplicationContext()));
        JSONArray jsonArray=jsonObject.getJSONArray("ssd");
        for (int i=0;i<jsonArray.length();i++){
            JSONObject object=jsonArray.getJSONObject(i);
            String ssd_name=object.getString("ssd_name");
            if (flag==1 || flag==2) {
                if (ssd_name.equals("WD Blue 500GB")) {
                    String ssd_price = object.getString("price");
                    int price = object.getInt("price");
                    String category=object.getString("category");
                    prefManager.saveSSDCategory(category);
                    priceFixedComp = priceFixedComp + price;
                    String ssd_desc = object.getString("desc");
                    ssdmodel.setText(ssd_name);
                    ssdprice.setText(ssd_price);
                    ssddesc.setText(ssd_desc);
                }
            }
            else if (flag==3){
                if (ssd_name.equals("WD Blue 500GB")) {
                    String ssd_price = object.getString("price");
                    int price = object.getInt("price");
                    String category=object.getString("category");
                    prefManager.saveSSDCategory(category);
                    priceFixedComp = priceFixedComp + price;
                    String ssd_desc = object.getString("desc");
                    ssdmodel.setText(ssd_name);
                    ssdprice.setText(ssd_price);
                    ssddesc.setText(ssd_desc);
                }
            }
            else if (flag==4){
                if (ssd_name.equals("WD Blue 500GB")) {
                    String ssd_price = object.getString("price");
                    int price = object.getInt("price");
                    String category=object.getString("category");
                    prefManager.saveSSDCategory(category);
                    priceFixedComp = priceFixedComp + price;
                    String ssd_desc = object.getString("desc");
                    ssdmodel.setText(ssd_name);
                    ssdprice.setText(ssd_price);
                    ssddesc.setText(ssd_desc);
                }
            }
            else if (flag==5){
                if (ssd_name.equals("Crucial 1TB")) {
                    String ssd_price = object.getString("price");
                    int price = object.getInt("price");
                    String category=object.getString("category");
                    prefManager.saveSSDCategory(category);
                    priceFixedComp = priceFixedComp + price;
                    String ssd_desc = object.getString("desc");
                    ssdmodel.setText(ssd_name);
                    ssdprice.setText(ssd_price);
                    ssddesc.setText(ssd_desc);
                }
            }
            else if (flag==6){
                if (ssd_name.equals("WD Blue 500GB")) {
                    String ssd_price = object.getString("price");
                    int price = object.getInt("price");
                    String category=object.getString("category");
                    prefManager.saveSSDCategory(category);
                    priceFixedComp = priceFixedComp + price;
                    String ssd_desc = object.getString("desc");
                    ssdmodel.setText(ssd_name);
                    ssdprice.setText(ssd_price);
                    ssddesc.setText(ssd_desc);
                }
            }
            else if (flag==7){
                if (ssd_name.equals("WD Blue 500GB")) {
                    String ssd_price = object.getString("price");
                    int price = object.getInt("price");
                    String category=object.getString("category");
                    prefManager.saveSSDCategory(category);
                    priceFixedComp = priceFixedComp + price;
                    String ssd_desc = object.getString("desc");
                    ssdmodel.setText(ssd_name);
                    ssdprice.setText(ssd_price);
                    ssddesc.setText(ssd_desc);
                }
            }
            else if (flag==8){
                if (ssd_name.equals("WD Blue 500GB")) {
                    String ssd_price = object.getString("price");
                    int price = object.getInt("price");
                    String category=object.getString("category");
                    prefManager.saveSSDCategory(category);
                    priceFixedComp = priceFixedComp + price;
                    String ssd_desc = object.getString("desc");
                    ssdmodel.setText(ssd_name);
                    ssdprice.setText(ssd_price);
                    ssddesc.setText(ssd_desc);
                }
            }
            else if (flag==9){
                if (ssd_name.equals("WD Blue 500GB")) {
                    String ssd_price = object.getString("price");
                    int price = object.getInt("price");
                    String category=object.getString("category");
                    prefManager.saveSSDCategory(category);
                    priceFixedComp = priceFixedComp + price;
                    String ssd_desc = object.getString("desc");
                    ssdmodel.setText(ssd_name);
                    ssdprice.setText(ssd_price);
                    ssddesc.setText(ssd_desc);
                }
            }
            else if (flag==10){
                if (ssd_name.equals("WD Blue 500GB")) {
                    String ssd_price = object.getString("price");
                    int price = object.getInt("price");
                    String category=object.getString("category");
                    prefManager.saveSSDCategory(category);
                    priceFixedComp = priceFixedComp + price;
                    String ssd_desc = object.getString("desc");
                    ssdmodel.setText(ssd_name);
                    ssdprice.setText(ssd_price);
                    ssddesc.setText(ssd_desc);
                }
            }
            else if (flag==11){
                if (ssd_name.equals("Crucial 1TB")) {
                    String ssd_price = object.getString("price");
                    int price = object.getInt("price");
                    String category=object.getString("category");
                    prefManager.saveSSDCategory(category);
                    priceFixedComp = priceFixedComp + price;
                    String ssd_desc = object.getString("desc");
                    ssdmodel.setText(ssd_name);
                    ssdprice.setText(ssd_price);
                    ssddesc.setText(ssd_desc);
                }
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void parseRam(int flag) throws JSONException {
        JSONObject jsonObject=new JSONObject(JsonDataFromAsset(getApplicationContext()));
        JSONArray jsonArray=jsonObject.getJSONArray("ram");
        for (int i=0;i<jsonArray.length();i++){
            JSONObject object=jsonArray.getJSONObject(i);
            String ram_name=object.getString("ram_name");
            if (flag==1){
            if (ram_name.equals("GSkill Ripjaws 8 GB RAM")){
                String ram_price=object.getString("price");
                int price=object.getInt("price");
                String category=object.getString("category");
                prefManager.saveRAMCategory(category);
                priceFixedComp=priceFixedComp+price;
                String ram_desc=object.getString("desc");
                rammodel.setText(ram_name);
                ramprice.setText(ram_price);
                ramdesc.setText(ram_desc);
            }
        }
            else if (flag==2){
                if (ram_name.equals("GSkill Ripjaws 16 GB RAM")){
                    String ram_price=object.getString("price");
                    int price=object.getInt("price");
                    String category=object.getString("category");
                    prefManager.saveRAMCategory(category);
                    priceFixedComp=priceFixedComp+price;
                    String ram_desc=object.getString("desc");
                    rammodel.setText(ram_name);
                    ramprice.setText(ram_price);
                    ramdesc.setText(ram_desc);
                }
            }
            else if(flag==3){
                if (ram_name.equals("GSkill Ripjaws 16 GB RAM")){
                    String ram_price=object.getString("price");
                    int price=object.getInt("price");
                    String category=object.getString("category");
                    prefManager.saveRAMCategory(category);
                    priceFixedComp=priceFixedComp+price;
                    String ram_desc=object.getString("desc");
                    rammodel.setText(ram_name);
                    ramprice.setText(ram_price);
                    ramdesc.setText(ram_desc);
                }
            }
            else if(flag==4){
                if (ram_name.equals("GSkill Ripjaws 16 GB RAM")){
                    String ram_price=object.getString("price");
                    int price=object.getInt("price");
                    String category=object.getString("category");
                    prefManager.saveRAMCategory(category);
                    priceFixedComp=priceFixedComp+price;
                    String ram_desc=object.getString("desc");
                    rammodel.setText(ram_name);
                    ramprice.setText(ram_price);
                    ramdesc.setText(ram_desc);
                }
            }
            else if(flag==5){
                if (ram_name.equals("GSkill Ripjaws 16 GB RAM")){
                    String ram_price=object.getString("price");
                    int price=object.getInt("price");
                    String category=object.getString("category");
                    prefManager.saveRAMCategory(category);
                    priceFixedComp=priceFixedComp+price;
                    String ram_desc=object.getString("desc");
                    rammodel.setText(ram_name);
                    ramprice.setText(ram_price);
                    ramdesc.setText(ram_desc);
                }
            }
            else if (flag==6){
                if (ram_name.equals("GSkill Ripjaws 8 GB RAM")){
                    String ram_price=object.getString("price");
                    int price=object.getInt("price");
                    String category=object.getString("category");
                    prefManager.saveRAMCategory(category);
                    priceFixedComp=priceFixedComp+price;
                    String ram_desc=object.getString("desc");
                    rammodel.setText(ram_name);
                    ramprice.setText(ram_price);
                    ramdesc.setText(ram_desc);
                }
            }
            else if (flag==7){
                if (ram_name.equals("GSkill Ripjaws 8 GB RAM")){
                    String ram_price=object.getString("price");
                    int price=object.getInt("price");
                    String category=object.getString("category");
                    prefManager.saveRAMCategory(category);
                    priceFixedComp=priceFixedComp+price;
                    String ram_desc=object.getString("desc");
                    rammodel.setText(ram_name);
                    ramprice.setText(ram_price);
                    ramdesc.setText(ram_desc);
                }
            }
            else if (flag==8){
                if (ram_name.equals("GSkill Ripjaws 8 GB RAM")){
                    String ram_price=object.getString("price");
                    int price=object.getInt("price");
                    String category=object.getString("category");
                    prefManager.saveRAMCategory(category);
                    priceFixedComp=priceFixedComp+price;
                    String ram_desc=object.getString("desc");
                    rammodel.setText(ram_name);
                    ramprice.setText(ram_price);
                    ramdesc.setText(ram_desc);
                }
            }
            else if (flag==9){
                if (ram_name.equals("GSkill Ripjaws 16 GB RAM")){
                    String ram_price=object.getString("price");
                    int price=object.getInt("price");
                    String category=object.getString("category");
                    prefManager.saveRAMCategory(category);
                    priceFixedComp=priceFixedComp+price;
                    String ram_desc=object.getString("desc");
                    rammodel.setText(ram_name);
                    ramprice.setText(ram_price);
                    ramdesc.setText(ram_desc);
                }
            }
            else if (flag==10){
                if (ram_name.equals("GSkill Ripjaws 16 GB RAM")){
                    String ram_price=object.getString("price");
                    int price=object.getInt("price");
                    String category=object.getString("category");
                    prefManager.saveRAMCategory(category);
                    priceFixedComp=priceFixedComp+price;
                    String ram_desc=object.getString("desc");
                    rammodel.setText(ram_name);
                    ramprice.setText(ram_price);
                    ramdesc.setText(ram_desc);
                }
            }
            else if (flag==11){
                if (ram_name.equals("GSkill Ripjaws 16 GB RAM")){
                    String ram_price=object.getString("price");
                    int price=object.getInt("price");
                    String category=object.getString("category");
                    prefManager.saveRAMCategory(category);
                    priceFixedComp=priceFixedComp+price;
                    String ram_desc=object.getString("desc");
                    rammodel.setText(ram_name);
                    ramprice.setText(ram_price);
                    ramdesc.setText(ram_desc);
                }
            }
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private static String JsonDataFromAssetPSU(Context context){
        String json;
        try {
            InputStream inputStream=context.getAssets().open("powersupply.json");
            int sizeOfFile=inputStream.available();
            byte[] bufferData=new byte[sizeOfFile];
            inputStream.read(bufferData);
            inputStream.close();
            json=new String(bufferData, StandardCharsets.UTF_8);

        }
        catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return json;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private static String JsonDataFromAsset(Context context){
        String json;
        try {
            InputStream inputStream=context.getAssets().open("ram.json");
            int sizeOfFile=inputStream.available();
            byte[] bufferData=new byte[sizeOfFile];
            inputStream.read(bufferData);
            inputStream.close();
            json=new String(bufferData, StandardCharsets.UTF_8);

        }
        catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return json;
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private static String JsonDataFromAssetSSD(Context context){
        String json;
        try {
            InputStream inputStream=context.getAssets().open("ssd.json");
            int sizeOfFile=inputStream.available();
            byte[] bufferData=new byte[sizeOfFile];
            inputStream.read(bufferData);
            inputStream.close();
            json=new String(bufferData, StandardCharsets.UTF_8);

        }
        catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return json;
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private static String JsonDataFromAssetCabinet(Context context){
        String json;
        try {
            InputStream inputStream=context.getAssets().open("cabinet.json");
            int sizeOfFile=inputStream.available();
            byte[] bufferData=new byte[sizeOfFile];
            inputStream.read(bufferData);
            inputStream.close();
            json=new String(bufferData, StandardCharsets.UTF_8);

        }
        catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return json;
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private static String JsonDataFromAssetGPU(Context context){
        String json;
        try {
            InputStream inputStream=context.getAssets().open("gpu.json");
            int sizeOfFile=inputStream.available();
            byte[] bufferData=new byte[sizeOfFile];
            inputStream.read(bufferData);
            inputStream.close();
            json=new String(bufferData, StandardCharsets.UTF_8);

        }
        catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return json;
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private static String JsonDataFromAssetCPU(Context context){
        String json;
        try {
            InputStream inputStream=context.getAssets().open("cpu.json");
            int sizeOfFile=inputStream.available();
            byte[] bufferData=new byte[sizeOfFile];
            inputStream.read(bufferData);
            inputStream.close();
            json=new String(bufferData, StandardCharsets.UTF_8);

        }
        catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return json;
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private static String JsonDataFromAssetAPU(Context context){
        String json;
        try {
            InputStream inputStream=context.getAssets().open("apu.json");
            int sizeOfFile=inputStream.available();
            byte[] bufferData=new byte[sizeOfFile];
            inputStream.read(bufferData);
            inputStream.close();
            json=new String(bufferData, StandardCharsets.UTF_8);

        }
        catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return json;
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private static String JsonDataFromAssetMB(Context context){
        String json;
        try {
            InputStream inputStream=context.getAssets().open("motherboard.json");
            int sizeOfFile=inputStream.available();
            byte[] bufferData=new byte[sizeOfFile];
            inputStream.read(bufferData);
            inputStream.close();
            json=new String(bufferData, StandardCharsets.UTF_8);

        }
        catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return json;
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private static String JsonDataFromAssetCooler(Context context){
        String json;
        try {
            InputStream inputStream=context.getAssets().open("cooler.json");
            int sizeOfFile=inputStream.available();
            byte[] bufferData=new byte[sizeOfFile];
            inputStream.read(bufferData);
            inputStream.close();
            json=new String(bufferData, StandardCharsets.UTF_8);

        }
        catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return json;
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private static String JsonDataFromAssetHDD(Context context){
        String json;
        try {
            InputStream inputStream=context.getAssets().open("hdd.json");
            int sizeOfFile=inputStream.available();
            byte[] bufferData=new byte[sizeOfFile];
            inputStream.read(bufferData);
            inputStream.close();
            json=new String(bufferData, StandardCharsets.UTF_8);

        }
        catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return json;
    }
}