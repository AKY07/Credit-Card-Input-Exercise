package com.example.creditcardinputexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5;
    Button b1;

    boolean match(String mm){
        if(mm.matches("([0-9]{2})/([0-9]{2})"))
        {
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.editText1);
        e2=(EditText)findViewById(R.id.editText2);
        e3=(EditText)findViewById(R.id.editText3);
        e4=(EditText)findViewById(R.id.editText4);
        e5=(EditText)findViewById(R.id.editText5);
        b1=(Button)findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();
                String s4=e4.getText().toString();
                String s5=e5.getText().toString();
                if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")||s5.equals("")){
                    Toast.makeText(MainActivity.this, "Please fill all the details", Toast.LENGTH_SHORT).show();
                }
               if(s1.length()!=16){
                   Toast.makeText(MainActivity.this, "Invalid Card Number", Toast.LENGTH_SHORT).show();
               }
               if(!match(s2)){
                   Toast.makeText(MainActivity.this, "Invalid Format(MM/YY)", Toast.LENGTH_SHORT).show();
               }
               if(s3.length()!=3){
                   Toast.makeText(MainActivity.this, "Invalid Security Code", Toast.LENGTH_SHORT).show();
               }
               if(s1.length() == 16 && match(s2) && s3.length() == 3 ){
                   Toast.makeText(MainActivity.this, "Payment Successful", Toast.LENGTH_SHORT).show();
               }
            }
        });

    }
}