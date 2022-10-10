package com.example.moneyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ImageView curr1,curr2;
    private Spinner sp1,sp2;
    private EditText changeFrom;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp1 = findViewById(R.id.spnrCurrency1Main);
        sp2 = findViewById(R.id.spnrCurrency2Main);
        ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(this,R.array.Currencies,android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(this,R.array.Currencies,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter1);
        sp2.setAdapter(adapter2);
        sp1.setOnItemSelectedListener(this);
        sp2.setOnItemSelectedListener(this);
        changeFrom = findViewById(R.id.etChangeFromMain);
        result = findViewById(R.id.txtResultMain);
        curr1=findViewById(R.id.imgCurr1Main);
        curr2=findViewById(R.id.imgCurr2Main);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent,View view, int position,long id){
        String selected1=sp1.getItemAtPosition(sp1.getSelectedItemPosition()).toString();
        String selected2=sp2.getItemAtPosition(sp2.getSelectedItemPosition()).toString();

            if (selected1.equals("Shekels")) {
                curr1.setImageResource(R.drawable.shekel);
                if (selected2.equals("Shekels")) {
                    curr2.setImageResource(R.drawable.shekel);
                    result.setText(changeFrom.getText().toString());
                }
                if (selected2.equals("Dollars")) {
                    curr2.setImageResource(R.drawable.dollar);
                    result.setText("" + Double.parseDouble(changeFrom.getText().toString()) * 0.2852);
                }
                if (selected2.equals("Euros")) {
                    curr2.setImageResource(R.drawable.euro);
                    result.setText("" + Double.parseDouble(changeFrom.getText().toString()) * 0.287);
                }
            }
            if(selected1.equals("Dollars")){
                curr1.setImageResource(R.drawable.dollar);
                if (selected2.equals("Shekels")) {
                    curr2.setImageResource(R.drawable.shekel);
                    result.setText("" + Double.parseDouble(changeFrom.getText().toString()) * 3.5058);
                }
                if (selected2.equals("Dollars")) {
                    curr2.setImageResource(R.drawable.dollar);
                    result.setText(changeFrom.getText().toString());
                }
                if (selected2.equals("Euros")) {
                    curr2.setImageResource(R.drawable.euro);
                    result.setText("" + Double.parseDouble(changeFrom.getText().toString()) * 1.01);
                }
            }
            if(selected1.equals("Euros")){
                curr1.setImageResource(R.drawable.euro);
                if (selected2.equals("Shekels")) {
                    curr2.setImageResource(R.drawable.shekel);
                    result.setText("" + Double.parseDouble(changeFrom.getText().toString()) * 3.485);
                }
                if (selected2.equals("Dollars")) {
                    curr2.setImageResource(R.drawable.dollar);
                    result.setText("" + Double.parseDouble(changeFrom.getText().toString()) * 0.99);
                }
                if (selected2.equals("Euros")) {
                    curr2.setImageResource(R.drawable.euro);
                    result.setText(changeFrom.getText().toString());
                }
            }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}