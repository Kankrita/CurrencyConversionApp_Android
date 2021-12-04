package com.example.finalandroid_2015233;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_Activity extends AppCompatActivity implements View.OnClickListener {

    EditText editEmail, editPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initialize();

    }

    private void initialize() {
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);

        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);
    }


    public void onClick(View view)
    {

        if (editEmail.getText().toString().equalsIgnoreCase("alex@gmail.com"))
        {
            if (editPassword.getText().toString().equals("1234"))
            {
                Intent intentCurrency = new Intent(this, CurrencyConverter_Activity.class);
                startActivity(intentCurrency);
            }
            else
            {
                Toast.makeText(this, "Wrong password. Please verify your information.", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this, "Wrong user. Please verify your information.", Toast.LENGTH_SHORT).show();
        }
    }

}