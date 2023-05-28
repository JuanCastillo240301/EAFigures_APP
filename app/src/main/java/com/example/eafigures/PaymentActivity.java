package com.example.eafigures;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PaymentActivity extends AppCompatActivity {
    TextView mTotal;
    Button payBtn;
    double amount=0.0;
    String name="";
    String img_url="";
    FirebaseFirestore mStore;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        amount=getIntent().getDoubleExtra("amount",0.0);
        img_url=getIntent().getStringExtra("img_url");
        name=getIntent().getStringExtra("name");
        mStore= FirebaseFirestore.getInstance();
        mAuth=FirebaseAuth.getInstance();
        mTotal=findViewById(R.id.sub_total);
        payBtn=findViewById(R.id.pay_btn);
        mTotal.setText("$ "+amount+"");


        payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPaymentSuccess();
            }
        });
    }
    public void startPayment() {

        //Checkout checkout = new Checkout();


        final Activity activity = PaymentActivity.this;

           // checkout.open(activity, options);

    }


    public void onPaymentSuccess() {
        Toast.makeText(this, "Payment Successful", Toast.LENGTH_SHORT).show();
        Map<String,Object> mMap = new HashMap<>();
        mMap.put("name",name);
        mMap.put("img_url",img_url);
        //mMap.put("payment_id",s);

        mStore.collection("User").document(mAuth.getCurrentUser().getUid())
                .collection("Orders").add(mMap).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        Intent intent=new Intent(PaymentActivity.this,HomeActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
    }



    public void payWithStripe(View view) {
        Intent intent = new Intent(PaymentActivity.this,MainActivity.class);
        intent.putExtra("amount",amount);
        intent.putExtra("name",name);
        intent.putExtra("img_url",img_url);
        startActivity(intent);
    }
}
