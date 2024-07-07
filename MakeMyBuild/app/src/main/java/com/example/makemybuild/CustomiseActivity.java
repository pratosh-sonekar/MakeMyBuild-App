package com.example.makemybuild;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.makemybuild.utils.PrefManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class CustomiseActivity extends AppCompatActivity {

    private Spinner spprocessor,spgpu,spram,spmotherboard,spcabinet,spssd,sphdd,spkeyboard,spmouse,spmonitor;
    private TextView processorprice,gpuprice,ramprice,motherboardprice,cabinetprice,ssdprice,hddprice,keyboardprice,mouseprice,monitorprice;
    private TextView processordesc,gpudesc,ramdesc,motherboarddesc,cabinetdesc,ssddesc,hdddesc,keyboarddesc,mousedesc,monitordesc;
    ArrayList s_processor,s_gpu,s_ram,s_motherboard,s_cabinet,s_ssd,s_hdd,s_keyboard,s_mouse,s_monitor;
    private TextView finalManualTotal;
    private LinearLayout totalBtn,manual_mistake;
    private Button rollie;
    private PrefManager prefManager;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customise);

        finalManualTotal=findViewById(R.id.finalManualTotal);
        totalBtn=findViewById(R.id.totalBtn);

        manual_mistake=findViewById(R.id.manual_mistake);
        rollie=findViewById(R.id.rollie);

        prefManager=new PrefManager(this);

        rollie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CustomiseActivity.this,BonusActivity.class);
                startActivity(intent);
            }
        });
        manual_mistake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CustomiseActivity.this,RecommendActivity.class);
                startActivity(intent);
            }
        });
        spprocessor=findViewById(R.id.spprocessor);
        spgpu=findViewById(R.id.spgpu);
        spram=findViewById(R.id.spram);
        spmotherboard=findViewById(R.id.spmotherboard);
        spcabinet=findViewById(R.id.spcabinet);
        spssd=findViewById(R.id.spssd);
        sphdd=findViewById(R.id.sphdd);
        spkeyboard=findViewById(R.id.spkey);
        spmouse=findViewById(R.id.spmou);
        spmonitor=findViewById(R.id.spmon);

        processorprice=findViewById(R.id.processor_price);
        gpuprice=findViewById(R.id.gpu_price);
        ramprice=findViewById(R.id.ram_price);
        motherboardprice=findViewById(R.id.motherboard_price);
        cabinetprice=findViewById(R.id.cabinet_price);
        ssdprice=findViewById(R.id.ssd_price);
        hddprice=findViewById(R.id.hdd_price);
        keyboardprice=findViewById(R.id.key_price);
        mouseprice=findViewById(R.id.mou_price);
        monitorprice=findViewById(R.id.mon_price);

        processordesc=findViewById(R.id.processor_desc);
        gpudesc=findViewById(R.id.gpu_desc);
        ramdesc=findViewById(R.id.ram_desc);
        motherboarddesc=findViewById(R.id.motherboard_desc);
        cabinetdesc=findViewById(R.id.cabinet_desc);
        ssddesc=findViewById(R.id.ssd_desc);
        hdddesc=findViewById(R.id.hdd_desc);
        keyboarddesc=findViewById(R.id.key_desc);
        mousedesc=findViewById(R.id.mou_desc);
        monitordesc=findViewById(R.id.mon_desc);

        s_processor=new ArrayList();
        s_gpu=new ArrayList();
        s_ram=new ArrayList();
        s_motherboard=new ArrayList();
        s_cabinet=new ArrayList();
        s_ssd=new ArrayList();
        s_hdd=new ArrayList();
        s_keyboard=new ArrayList();
        s_mouse=new ArrayList();
        s_monitor=new ArrayList();

        try {
            parseCPU();
            parseGPU();
            parseRAM();
            parseMb();
            parseCabinet();
            parseSSD();
            parseHDD();
            parseMonitor();
            parseKeyboard();
            parseMouse();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ArrayAdapter venType = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, s_processor);
        venType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spprocessor.setAdapter(venType);

        ArrayAdapter venType1 = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, s_gpu);
        venType1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spgpu.setAdapter(venType1);

        ArrayAdapter venType2 = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, s_ram);
        venType2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spram.setAdapter(venType2);

        ArrayAdapter venType3 = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, s_motherboard);
        venType3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spram.setAdapter(venType3);

        ArrayAdapter venType4 = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, s_motherboard);
        venType4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spmotherboard.setAdapter(venType4);

        ArrayAdapter venType5 = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, s_cabinet);
        venType5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spcabinet.setAdapter(venType5);

        ArrayAdapter venType6 = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, s_ssd);
        venType6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spssd.setAdapter(venType6);

        ArrayAdapter venType7 = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, s_hdd);
        venType7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sphdd.setAdapter(venType7);

        ArrayAdapter venType8 = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, s_monitor);
        venType7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spmonitor.setAdapter(venType8);

        ArrayAdapter venType9 = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, s_keyboard);
        venType7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spkeyboard.setAdapter(venType9);

        ArrayAdapter venType10 = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, s_mouse);
        venType7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spmouse.setAdapter(venType10);

        spprocessor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                JSONObject jsonObject= null;
                try {
                    jsonObject = new JSONObject(JsonDataFromAssetCPU(getApplicationContext()));
                    JSONArray jsonArray=jsonObject.getJSONArray("cpu");
                    for (int i=0;i<jsonArray.length();i++){
                        JSONObject object=jsonArray.getJSONObject(i);
                        int price=object.getInt("price");

                        String strprice=Integer.toString(price);
                        if (position==i){
                            processorprice.setText(strprice);
                            String desc=object.getString("desc");
                            processordesc.setText(desc);
                        }


                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spgpu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                JSONObject jsonObject= null;
                try {
                    jsonObject = new JSONObject(JsonDataFromAssetGPU(getApplicationContext()));
                    JSONArray jsonArray=jsonObject.getJSONArray("gpu");
                    for (int i=0;i<jsonArray.length();i++){
                        JSONObject object=jsonArray.getJSONObject(i);
                        int price=object.getInt("price");
                        String strprice=Integer.toString(price);
                        if (position==i){
                            gpuprice.setText(strprice);
                            String desc=object.getString("desc");
                            gpudesc.setText(desc);
                        }


                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spram.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                JSONObject jsonObject= null;
                try {
                    jsonObject = new JSONObject(JsonDataFromAssetRAM(getApplicationContext()));
                    JSONArray jsonArray=jsonObject.getJSONArray("ram");
                    for (int i=0;i<jsonArray.length();i++){
                        JSONObject object=jsonArray.getJSONObject(i);
                        int price=object.getInt("price");
                        String strprice=Integer.toString(price);
                        if (position==i){
                            ramprice.setText(strprice);
                            String desc=object.getString("desc");
                            ramdesc.setText(desc);
                        }

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spmotherboard.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                JSONObject jsonObject= null;
                try {
                    jsonObject = new JSONObject(JsonDataFromAssetMB(getApplicationContext()));
                    JSONArray jsonArray=jsonObject.getJSONArray("motherboard");
                    for (int i=0;i<jsonArray.length();i++){
                        JSONObject object=jsonArray.getJSONObject(i);
                        int price=object.getInt("price");
                        String strprice=Integer.toString(price);
                        if (position==i){
                            motherboardprice.setText(strprice);
                            String desc=object.getString("desc");
                            motherboarddesc.setText(desc);
                        }

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spcabinet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                JSONObject jsonObject= null;
                try {
                    jsonObject = new JSONObject(JsonDataFromAssetCabinet(getApplicationContext()));
                    JSONArray jsonArray=jsonObject.getJSONArray("cabinet");
                    for (int i=0;i<jsonArray.length();i++){
                        JSONObject object=jsonArray.getJSONObject(i);
                        int price=object.getInt("price");
                        String strprice=Integer.toString(price);
                        if (position==i){
                            cabinetprice.setText(strprice);
                            String desc=object.getString("desc");
                            cabinetdesc.setText(desc);
                        }

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spssd.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                JSONObject jsonObject= null;
                try {
                    jsonObject = new JSONObject(JsonDataFromAssetSSD(getApplicationContext()));
                    JSONArray jsonArray=jsonObject.getJSONArray("ssd");
                    for (int i=0;i<jsonArray.length();i++){
                        JSONObject object=jsonArray.getJSONObject(i);
                        int price=object.getInt("price");
                        String strprice=Integer.toString(price);
                        if (position==i){
                            ssdprice.setText(strprice);
                            String desc=object.getString("desc");
                            ssddesc.setText(desc);
                        }

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sphdd.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                JSONObject jsonObject= null;
                try {
                    jsonObject = new JSONObject(JsonDataFromAssetHDD(getApplicationContext()));
                    JSONArray jsonArray=jsonObject.getJSONArray("hdd");
                    for (int i=0;i<jsonArray.length();i++){
                        JSONObject object=jsonArray.getJSONObject(i);
                        int price=object.getInt("price");
                        String strprice=Integer.toString(price);
                        if (position==i){
                            hddprice.setText(strprice);
                            String desc=object.getString("desc");
                            hdddesc.setText(desc);
                        }

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spmonitor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                JSONObject jsonObject= null;
                try {
                    jsonObject = new JSONObject(JsonDataFromAssetMonitor(getApplicationContext()));
                    JSONArray jsonArray=jsonObject.getJSONArray("monitor");
                    for (int i=0;i<jsonArray.length();i++){
                        JSONObject object=jsonArray.getJSONObject(i);
                        int price=object.getInt("price");
                        String strprice=Integer.toString(price);
                        if (position==i){
                            monitorprice.setText(strprice);
                            String desc=object.getString("desc");
                            monitordesc.setText(desc);
                        }

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spmouse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                JSONObject jsonObject= null;
                try {
                    jsonObject = new JSONObject(JsonDataFromAssetMouse(getApplicationContext()));
                    JSONArray jsonArray=jsonObject.getJSONArray("mouse");
                    for (int i=0;i<jsonArray.length();i++){
                        JSONObject object=jsonArray.getJSONObject(i);
                        int price=object.getInt("price");
                        String strprice=Integer.toString(price);
                        if (position==i){
                            mouseprice.setText(strprice);
                            String desc=object.getString("desc");
                            mousedesc.setText(desc);
                        }

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spkeyboard.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                JSONObject jsonObject= null;
                try {
                    jsonObject = new JSONObject(JsonDataFromAssetKeyboard(getApplicationContext()));
                    JSONArray jsonArray=jsonObject.getJSONArray("keyboard");
                    for (int i=0;i<jsonArray.length();i++){
                        JSONObject object=jsonArray.getJSONObject(i);
                        int price=object.getInt("price");
                        String strprice=Integer.toString(price);
                        if (position==i){
                            keyboardprice.setText(strprice);
                            String desc=object.getString("desc");
                            keyboarddesc.setText(desc);
                        }

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        totalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cpu_pricee1=Integer.valueOf(processorprice.getText().toString());
                int gpu_pricee1=Integer.valueOf(gpuprice.getText().toString());
                int ram_pricee1=Integer.valueOf(ramprice.getText().toString());
                int mb_pricee1=Integer.valueOf(motherboardprice.getText().toString());
                int cabinet_pricee1=Integer.valueOf(cabinetprice.getText().toString());
                int ssd_pricee1=Integer.valueOf(ssdprice.getText().toString());
                int monitor_price1=Integer.valueOf(monitorprice.getText().toString());
                int keyboarc_price1=Integer.valueOf(keyboardprice.getText().toString());
                int mouse_price1=Integer.valueOf(mouseprice.getText().toString());





                int hdd_pricee1=Integer.valueOf(hddprice.getText().toString());
                prefManager.saveCPUModel(spprocessor.getSelectedItem().toString());
                prefManager.saveGPUModel(spgpu.getSelectedItem().toString());
                prefManager.saveRAMModel(spram.getSelectedItem().toString());
                prefManager.saveMotherboardModel(spmotherboard.getSelectedItem().toString());
                prefManager.saveCabinetModel(spcabinet.getSelectedItem().toString());
                prefManager.saveSSDModel(spssd.getSelectedItem().toString());
                prefManager.saveHDDModel(sphdd.getSelectedItem().toString());
                prefManager.saveMonitorModel(spmonitor.getSelectedItem().toString());
                prefManager.saveMouseModel(spmouse.getSelectedItem().toString());
                prefManager.saveKeyboardModel(spkeyboard.getSelectedItem().toString());

                prefManager.saveCPUPrice(processorprice.getText().toString());
                prefManager.saveGPUPrice(gpuprice.getText().toString());
                prefManager.saveRAMPrice(ramprice.getText().toString());
                prefManager.saveMotherboardPrice(motherboardprice.getText().toString());
                prefManager.saveCabinetPrice(cabinetprice.getText().toString());
                prefManager.saveSSDPrice(ssdprice.getText().toString());
                prefManager.saveHDDPrice(hddprice.getText().toString());
                prefManager.saveMonitorPrice(monitorprice.getText().toString());
                prefManager.saveMousePrice(mouseprice.getText().toString());
                prefManager.saveKeyboardPrice(keyboardprice.getText().toString());

                prefManager.saveCPUDesc(processordesc.getText().toString());
                prefManager.saveGPUDesc(gpudesc.getText().toString());
                prefManager.saveRAMDesc(ramdesc.getText().toString());
                prefManager.saveMotherboardDesc(motherboarddesc.getText().toString());
                prefManager.saveCabinetDesc(cabinetdesc.getText().toString());
                prefManager.saveSSDDesc(ssddesc.getText().toString());
                prefManager.saveHDDDesc(hdddesc.getText().toString());
                prefManager.saveMonitorDesc(monitordesc.getText().toString());
                prefManager.saveMouseDesc(mousedesc.getText().toString());
                prefManager.saveKeyboardDesc(keyboarddesc.getText().toString());

                int our_budget1=cpu_pricee1+gpu_pricee1+ram_pricee1+mb_pricee1+cabinet_pricee1+ssd_pricee1+hdd_pricee1+monitor_price1+keyboarc_price1+mouse_price1;
                String our_budgett1=Integer.toString(our_budget1);
                finalManualTotal.setText(our_budgett1);
            }
        });

    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void parseCPU() throws JSONException {
        JSONObject jsonObject=new JSONObject(JsonDataFromAssetCPU(getApplicationContext()));
        JSONArray jsonArray=jsonObject.getJSONArray("cpu");
        for (int i=0;i<jsonArray.length();i++){
            JSONObject object=jsonArray.getJSONObject(i);
            int price=object.getInt("price");
            String cpu_name=object.getString("cpu_name");
            s_processor.add(cpu_name);
            String strprice=Integer.toString(price);


        }
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void parseMonitor() throws JSONException {
        JSONObject jsonObject=new JSONObject(JsonDataFromAssetMonitor(getApplicationContext()));
        JSONArray jsonArray=jsonObject.getJSONArray("monitor");
        for (int i=0;i<jsonArray.length();i++){
            JSONObject object=jsonArray.getJSONObject(i);
            int price=object.getInt("price");
            String cpu_name=object.getString("monitor_name");
            s_monitor.add(cpu_name);
            String strprice=Integer.toString(price);


        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void parseMouse() throws JSONException {
        JSONObject jsonObject=new JSONObject(JsonDataFromAssetMouse(getApplicationContext()));
        JSONArray jsonArray=jsonObject.getJSONArray("mouse");
        for (int i=0;i<jsonArray.length();i++){
            JSONObject object=jsonArray.getJSONObject(i);
            int price=object.getInt("price");
            String cpu_name=object.getString("mouse_name");
            s_mouse.add(cpu_name);
            String strprice=Integer.toString(price);


        }
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void parseKeyboard() throws JSONException {
        JSONObject jsonObject=new JSONObject(JsonDataFromAssetKeyboard(getApplicationContext()));
        JSONArray jsonArray=jsonObject.getJSONArray("keyboard");
        for (int i=0;i<jsonArray.length();i++){
            JSONObject object=jsonArray.getJSONObject(i);
            int price=object.getInt("price");
            String cpu_name=object.getString("keyboard_name");
            s_keyboard.add(cpu_name);
            String strprice=Integer.toString(price);


        }
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void parseGPU() throws JSONException {
        JSONObject jsonObject=new JSONObject(JsonDataFromAssetGPU(getApplicationContext()));
        JSONArray jsonArray=jsonObject.getJSONArray("gpu");
        for (int i=0;i<jsonArray.length();i++){
            JSONObject object=jsonArray.getJSONObject(i);
            int price=object.getInt("price");
            String name=object.getString("gpu_name");
            s_gpu.add(name);


        }
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void parseRAM() throws JSONException {
        JSONObject jsonObject=new JSONObject(JsonDataFromAssetRAM(getApplicationContext()));
        JSONArray jsonArray=jsonObject.getJSONArray("ram");
        for (int i=0;i<jsonArray.length();i++){
            JSONObject object=jsonArray.getJSONObject(i);
            String name=object.getString("ram_name");
            s_ram.add(name);
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void parseMb() throws JSONException {
        JSONObject jsonObject=new JSONObject(JsonDataFromAssetMB(getApplicationContext()));
        JSONArray jsonArray=jsonObject.getJSONArray("motherboard");
        for (int i=0;i<jsonArray.length();i++){
            JSONObject object=jsonArray.getJSONObject(i);
            String name=object.getString("mother_name");
            s_motherboard.add(name);
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void parseCabinet() throws JSONException {
        JSONObject jsonObject=new JSONObject(JsonDataFromAssetCabinet(getApplicationContext()));
        JSONArray jsonArray=jsonObject.getJSONArray("cabinet");
        for (int i=0;i<jsonArray.length();i++){
            JSONObject object=jsonArray.getJSONObject(i);
            String name=object.getString("cabinet_name");
            s_cabinet.add(name);
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void parseSSD() throws JSONException {
        JSONObject jsonObject=new JSONObject(JsonDataFromAssetSSD(getApplicationContext()));
        JSONArray jsonArray=jsonObject.getJSONArray("ssd");
        for (int i=0;i<jsonArray.length();i++){
            JSONObject object=jsonArray.getJSONObject(i);
            String name=object.getString("ssd_name");
            s_ssd.add(name);
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void parseHDD() throws JSONException {
        JSONObject jsonObject=new JSONObject(JsonDataFromAssetHDD(getApplicationContext()));
        JSONArray jsonArray=jsonObject.getJSONArray("hdd");
        for (int i=0;i<jsonArray.length();i++){
            JSONObject object=jsonArray.getJSONObject(i);
            String name=object.getString("hdd_name");
            s_hdd.add(name);
        }
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
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private static String JsonDataFromAssetRAM(Context context){
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
    private static String JsonDataFromAssetMonitor(Context context){
        String json;
        try {
            InputStream inputStream=context.getAssets().open("monitor.json");
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
    private static String JsonDataFromAssetKeyboard(Context context){
        String json;
        try {
            InputStream inputStream=context.getAssets().open("keyboard.json");
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
    private static String JsonDataFromAssetMouse(Context context){
        String json;
        try {
            InputStream inputStream=context.getAssets().open("mouse.json");
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