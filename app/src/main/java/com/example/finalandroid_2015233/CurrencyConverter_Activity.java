package com.example.finalandroid_2015233;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalandroid_2015233.Model.Converter;

public class CurrencyConverter_Activity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener
{

    EditText editEuro;
    Spinner spinnerCurrency;
    Button btnConvert;
  //  TextView txtCurrency;

    private static String [] currencies_array = {"Brazilian Real", "US Dollar"};
    double euroAmount;
//    double EuroToReal, EuroToUSD;
    int convertTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.currency_converter_activity);

        initialize();

        spinnerCurrency = findViewById(R.id.spinnerChoice);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, currencies_array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCurrency.setAdapter(adapter);
        spinnerCurrency.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
    {
        switch (position)
        {
            case 0:
                convertTo = 0;
                break;
            case 1:
                convertTo = 1;
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {
        Toast.makeText(this, "No currency selected.", Toast.LENGTH_SHORT).show();
    }

    private void initialize()
    {
        editEuro = findViewById(R.id.editEuro);

      //  txtCurrency = findViewById(R.id.txtCurrencyTotal);

        btnConvert = findViewById(R.id.btnConvertCurrency);
        btnConvert.setOnClickListener(this);

    }

    public void onClick(View view)
    {
        String euro = editEuro.getText().toString();
        euroAmount = Double.parseDouble(euro);
        Converter converter = new Converter();

        switch (convertTo)
        {
            case 0:
                double EuroToReal = converter.EuroToBrazilian(euroAmount);
                Toast.makeText(this,"Converted Currency: " + EuroToReal + "$R",Toast.LENGTH_SHORT).show();
                break;

            case 1:
                double EuroToUSD = converter.EuroToUSD(euroAmount);
                Toast.makeText(this,"Converted Currency: " + EuroToUSD + "$USD",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
