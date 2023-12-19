package com.example.optative3ame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText priceEditText;
    private Spinner totalSpinner;
    private Button calculateButton;
    private TextView resultTextView;

    private String vat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        priceEditText = findViewById(R.id.editTextNumberPrice);
        totalSpinner = findViewById(R.id.spinnerVAT);
        calculateButton = findViewById(R.id.buttonCalculate);
        resultTextView = findViewById(R.id.textViewResult);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.vat, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        totalSpinner.setAdapter(adapter);
        totalSpinner.setOnItemSelectedListener(this);
    }

        public void calculate(View v){
            float price=Float.parseFloat(priceEditText.getText().toString());
            float realVat= Float.parseFloat(vat.replaceAll("\\D+",""));

            float total=price+(price*(realVat/100));

            resultTextView.setText(String.valueOf(total));
        }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String text= parent.getItemAtPosition(position).toString();
        vat=text;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}