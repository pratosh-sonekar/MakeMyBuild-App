package com.example.makemybuild;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.makemybuild.utils.PrefManager;

import static android.view.View.GONE;

public class SemiFinalActivity extends AppCompatActivity {

    private TextView coolertag,coolermodel,coolerpricee,coolerdesc,hddtag,mbmodel,mbpricee,mbdesc,hddmodel,hddpricee,hdddesc,gpumodel,gpupricee,gpudesc,rammodel,ramprice,ramdesc,cpumodel,cpupricee,cpudesc,ssdmodel,ssdprice,ssddesc,cabinetmodel,cabinetprice,cabinetdesc,psumodel,psuprice,psudesc;
    private TextView psutag,ssdtag,monitortag,keyboardtag,mousetag,monitorprice,keyboardprice,mouseprice,monitordesc,keyboarddesc,mousedesc,monitormodel,keyboardmodel,mousemodel;
    PrefManager prefManager;
    private LinearLayout checkoutTotalBtn;
    private TextView checkoutTotal;
    private Button confirmorder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semi_final);

        confirmorder=findViewById(R.id.confirm_order);
        prefManager=new PrefManager(this);
        checkoutTotal=findViewById(R.id.checkoutTotal);
        checkoutTotalBtn=findViewById(R.id.checkoutTotalbtn);

        coolertag=findViewById(R.id.coolertag1);
        coolermodel=findViewById(R.id.coolermodel1);
        coolerpricee=findViewById(R.id.coolerprice1);
        coolerdesc=findViewById(R.id.coolerdesc1);

        mbmodel=findViewById(R.id.mbmodel1);
        mbdesc=findViewById(R.id.mbdesc1);
        mbpricee=findViewById(R.id.mbprice1);

        hddtag=findViewById(R.id.hddtag1);
        hddmodel=findViewById(R.id.hddmodel1);
        hdddesc=findViewById(R.id.hdddesc1);
        hddpricee=findViewById(R.id.hddprice1);

        rammodel=findViewById(R.id.rammodel1);
        ramprice=findViewById(R.id.ramprice1);
        ramdesc=findViewById(R.id.ramdesc1);

        cpumodel=findViewById(R.id.cpumodel1);
        cpudesc=findViewById(R.id.cpudesc1);
        cpupricee=findViewById(R.id.cpuprice1);

        ssdtag=findViewById(R.id.ssdtag1);
        ssdmodel=findViewById(R.id.ssdmodel1);
        ssddesc=findViewById(R.id.ssddesc1);
        ssdprice=findViewById(R.id.ssdprice1);

        cabinetmodel=findViewById(R.id.cabinetmodel1);
        cabinetdesc=findViewById(R.id.cabinetdesc1);
        cabinetprice=findViewById(R.id.cabinetprice1);

        psumodel=findViewById(R.id.psumodel1);
        psudesc=findViewById(R.id.psudesc1);
        psuprice=findViewById(R.id.psuprice1);
        psutag=findViewById(R.id.psutag1);

        gpumodel=findViewById(R.id.gpumodel1);
        gpudesc=findViewById(R.id.gpudesc1);
        gpupricee=findViewById(R.id.gpuprice1);

        monitorprice=findViewById(R.id.monitorprice1);
        monitordesc=findViewById(R.id.monitordesc1);
        monitormodel=findViewById(R.id.monitormodel1);
        monitortag=findViewById(R.id.monitortag1);

        keyboardprice=findViewById(R.id.keyboardprice1);
        keyboarddesc=findViewById(R.id.keyboarddesc1);
        keyboardmodel=findViewById(R.id.keyboardmodel1);
        keyboardtag=findViewById(R.id.keyboardtag1);

        mousetag=findViewById(R.id.mousetag1);
        mouseprice=findViewById(R.id.mouseprice1);
        mousedesc=findViewById(R.id.mousedesc1);
        mousemodel=findViewById(R.id.mousemodel1);

        cpumodel.setText(prefManager.getCPUModel());
        cpudesc.setText(prefManager.getCPUDesc());
        cpupricee.setText(prefManager.getCPUPrice());

        gpumodel.setText(prefManager.getGpuModel());
        gpudesc.setText(prefManager.getGPUDesc());
        gpupricee.setText(prefManager.getGPUPrice());

        rammodel.setText(prefManager.getRAMModel());
        ramdesc.setText(prefManager.getRAMDesc());
        ramprice.setText(prefManager.getRAMPrice());

        mbmodel.setText(prefManager.getMotherboardModel());
        mbdesc.setText(prefManager.getMotherboardDesc());
        mbpricee.setText(prefManager.getMotherboardPrice());

        cabinetmodel.setText(prefManager.getCabinetModel());
        cabinetdesc.setText(prefManager.getCabinetDesc());
        cabinetprice.setText(prefManager.getCabinetPrice());

        if (prefManager.getPSUModel().equals("")){
            psumodel.setVisibility(GONE);
            psudesc.setVisibility(GONE);
            psuprice.setVisibility(GONE);
            psutag.setVisibility(GONE);
        }
        else{
            psumodel.setVisibility(View.VISIBLE);
            psudesc.setVisibility(View.VISIBLE);
            psuprice.setVisibility(View.VISIBLE);
            psutag.setVisibility(View.VISIBLE);

            psumodel.setText(prefManager.getPSUModel());
            psudesc.setText(prefManager.getPSUDesc());
            psuprice.setText(prefManager.getPSUPrice());
        }
        if (prefManager.getSSDModel().equals("")){
            ssdmodel.setVisibility(GONE);
            ssddesc.setVisibility(GONE);
            ssdprice.setVisibility(GONE);
            ssdtag.setVisibility(GONE);
        }
        else{
            ssdmodel.setVisibility(View.VISIBLE);
            ssddesc.setVisibility(View.VISIBLE);
            ssdprice.setVisibility(View.VISIBLE);
            ssdtag.setVisibility(View.VISIBLE);

            ssdmodel.setText(prefManager.getSSDModel());
            ssddesc.setText(prefManager.getSSDDesc());
            ssdprice.setText(prefManager.getSSDPrice());
        }
        if (prefManager.getHDDModel().equals("")){
            hddmodel.setVisibility(GONE);
            hdddesc.setVisibility(GONE);
            hddpricee.setVisibility(GONE);
            hddtag.setVisibility(GONE);
        }
        else{
            hddmodel.setVisibility(View.VISIBLE);
            hdddesc.setVisibility(View.VISIBLE);
            hddpricee.setVisibility(View.VISIBLE);
            hddtag.setVisibility(View.VISIBLE);

            hddmodel.setText(prefManager.getHDDModel());
            hdddesc.setText(prefManager.getHDDDesc());
            hddpricee.setText(prefManager.getHDDPrice());
        }

        if (prefManager.getCoolerModel().equals("")){
            coolermodel.setVisibility(GONE);
            coolerdesc.setVisibility(GONE);
            coolerpricee.setVisibility(GONE);
            coolertag.setVisibility(GONE);
        }
        else{
            coolermodel.setVisibility(View.VISIBLE);
            coolerdesc.setVisibility(View.VISIBLE);
            coolerpricee.setVisibility(View.VISIBLE);
            coolertag.setVisibility(View.VISIBLE);

            coolermodel.setText(prefManager.getCoolerModel());
            coolerdesc.setText(prefManager.getCoolerDesc());
            coolerpricee.setText(prefManager.getCoolerPrice());

        }

        if (prefManager.getMonitorModel().equals("")|| prefManager.getMonitorModel().equals("Select the component")){
            monitormodel.setVisibility(GONE);
            monitordesc.setVisibility(GONE);
            monitorprice.setVisibility(GONE);
            monitortag.setVisibility(GONE);

        }
        else{
            monitormodel.setVisibility(View.VISIBLE);
            monitordesc.setVisibility(View.VISIBLE);
            monitorprice.setVisibility(View.VISIBLE);
            monitortag.setVisibility(View.VISIBLE);

            monitormodel.setText(prefManager.getMonitorModel());
            monitordesc.setText(prefManager.getMonitorDesc());
            monitorprice.setText(prefManager.getMonitorPrice());

        }

        if (prefManager.getKeyboardModel().equals("")|| prefManager.getKeyboardModel().equals("Select the component")){
            keyboardmodel.setVisibility(GONE);
            keyboarddesc.setVisibility(GONE);
            keyboardprice.setVisibility(GONE);
            keyboardtag.setVisibility(GONE);
        }
        else{
            keyboardmodel.setVisibility(View.VISIBLE);
            keyboarddesc.setVisibility(View.VISIBLE);
            keyboardprice.setVisibility(View.VISIBLE);
            keyboardtag.setVisibility(View.VISIBLE);

            keyboardmodel.setText(prefManager.getKeyboardModel());
            keyboardprice.setText(prefManager.getKeyboardPrice());
            keyboarddesc.setText(prefManager.getKeyboardDesc());

        }

        if (prefManager.getMouseModel().equals("")|| prefManager.getMouseModel().equals("Select the component")){
            mousemodel.setVisibility(GONE);
            mousedesc.setVisibility(GONE);
            mouseprice.setVisibility(GONE);
            mousetag.setVisibility(GONE);

        }
        else{
            mousemodel.setVisibility(View.VISIBLE);
            monitordesc.setVisibility(View.VISIBLE);
            mouseprice.setVisibility(View.VISIBLE);
            mousetag.setVisibility(View.VISIBLE);

            mousemodel.setText(prefManager.getMouseModel());
            mouseprice.setText(prefManager.getMousePrice());
            mousedesc.setText(prefManager.getMouseDesc());

        }
        checkoutTotalBtn.setOnClickListener(new View.OnClickListener() {
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
                int cooler_pricee=Integer.valueOf(coolerpricee.getText().toString());

                int our_budget1=cpu_pricee1+gpu_pricee1+ram_pricee1+mb_pricee1+cabinet_pricee1+ssd_pricee1+hdd_pricee1+psu_pricee1+cooler_pricee+monitor_price1+keyboarc_price1+mouse_price1;
                String our_budgett1=Integer.toString(our_budget1);
                checkoutTotal.setText(our_budgett1);
                prefManager.saveFinalAmount(our_budgett1);
            }
        });
        confirmorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SemiFinalActivity.this, PaymentScreen.class);
                String messageNew=prefManager.getMessage()+""+prefManager.getCPUModel()+""+prefManager.getGpuModel()+""+prefManager.getRAMModel()+""+prefManager.getMotherboardModel()+""+prefManager.getCabinetModel()+""+prefManager.getSSDModel()+""+prefManager.getHDDModel()+""+prefManager.getPSUModel()+""+prefManager.getCoolerModel()+""+prefManager.getMonitorModel()+""+prefManager.getKeyboardModel()+""+prefManager.getMouseModel();
                prefManager.saveMessage(messageNew);
                startActivity(intent);
            }
        });

    }
}