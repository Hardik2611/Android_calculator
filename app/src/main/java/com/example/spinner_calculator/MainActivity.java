package com.example.spinner_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String s1[]={"","Add","Subtract","Multiply","Division"};
    TextView text;
    Button b1;
    EditText e1,e2;
    String operationSel = "";
    String s="";
    double c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.textView2);
        b1 = findViewById(R.id.button);
        e1 = findViewById(R.id.editTextNumberDecimal);
        e2 = findViewById(R.id.editTextNumberDecimal2);
        Spinner sp = findViewById(R.id.spinner);
        ArrayAdapter ar = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, s1);
        sp.setAdapter(ar);
        sp.setOnItemSelectedListener(this);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    double a = Double.parseDouble(e1.getText().toString());
                    double b = Double.parseDouble(e2.getText().toString());


                    s = sp.getSelectedItem().toString();
                    if(s==""){
                        text.setText("Select any operation");
                    }
                    if(s=="Subtract")
                    {
                        c = a-b;
                        text.setText("Result of subtraction is "+c);
                    }
                    if(s=="Add")
                    {
                        c = a+b;
                        text.setText("Result of addition is "+c);
                    }
                    if(s=="Multiply")
                    {
                        c = a*b;
                        text.setText("Result of multiplication is "+c);
                    }
                    if(s=="Division")
                    {
                        c = a/b;
                        text.setText("Result of division is "+c);
                    }


            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}