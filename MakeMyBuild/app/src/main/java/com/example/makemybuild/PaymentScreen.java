package com.example.makemybuild;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.makemybuild.utils.PrefManager;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class
PaymentScreen extends AppCompatActivity implements PaymentResultListener{
    private Button contact,paynow;
    private EditText etname,etphone,etaltphone,etaddress,etsuggest;
    PrefManager prefManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_screen);

        prefManager=new PrefManager(this);
        contact=findViewById(R.id.contact);
        paynow=findViewById(R.id.paynow);
        etname=findViewById(R.id.etname);
        etphone=findViewById(R.id.etphone);
        etaltphone=findViewById(R.id.etaltphone);
        etaddress=findViewById(R.id.etaddress);
        etsuggest=findViewById(R.id.etsugest);

        paynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etname.getText().toString().trim();
                String phone= etphone.getText().toString().trim();
                String altphone=etaltphone.getText().toString().trim();
                String address=etaddress.getText().toString().trim();
                String suggest=etsuggest.getText().toString().trim();

                if (TextUtils.isEmpty(name)||TextUtils.isEmpty(phone)||TextUtils.isEmpty(altphone)||TextUtils.isEmpty(address)) {
                    etname.setError("Field is empty!");
                    etphone.setError("Field is empty!");
                    etaltphone.setError("Field is empty!");
                    etaddress.setError("Field is empty!");
                    Toast.makeText(getApplicationContext(), "Enter the required fields.", Toast.LENGTH_SHORT).show();
                    return;
                }
                String sAmount=prefManager.getFinalAmount();

                float a=0;
                // Toast.makeText(CoinsActivity.this, "xyz" +a, Toast.LENGTH_LONG).show();
                try {
                    a=Math.round(Float.parseFloat(sAmount) *100);

                }catch (NumberFormatException ignored){

                }
                final float amount=  a;
                // Toast.makeText(CoinsActivity.this, "xyz" +amount, Toast.LENGTH_LONG).show();
                Checkout checkout=new Checkout();
                checkout.setKeyID("rzp_test_uqBr3bK3mjxK6r");

                JSONObject object=new JSONObject();

                try {
                    object.put("name",name);
                    object.put("description","Final Payment");
                    object.put("theme.color","#528FF0");
                    object.put("currency","INR");
                    object.put("amount", 0.4*amount);
                    object.put("currency","INR");
                    object.put("prefill.contact",phone);
                    object.put("prefill.email",prefManager.getEmail());

                    checkout.open(PaymentScreen.this,object);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PaymentScreen.this,ContactActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onPaymentSuccess(String s) {
        finish();
        Intent intent=new Intent(PaymentScreen.this,ConfirmActivity.class);
        startActivity(intent);
        AlertDialog.Builder builder=new AlertDialog.Builder(PaymentScreen.this);
        builder.setTitle("Payment ID");
        builder.setMessage(s);
        builder.show();

        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{"pratoshsonekar666666@gmail.com"});
        email.putExtra(Intent.EXTRA_SUBJECT, "New Order");
        email.putExtra(Intent.EXTRA_TEXT, prefManager.getMessage());

//need this to prompts email client only
        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "Choose an Email client :"));
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}