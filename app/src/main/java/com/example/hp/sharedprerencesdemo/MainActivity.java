package com.example.hp.sharedprerencesdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView tvResult;
EditText etName,etPass;
Button buAdd,buDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult=(TextView) findViewById(R.id.tvResult);
        etName=(EditText) findViewById(R.id.etUsername);
        etPass=(EditText) findViewById(R.id.etPassword);
        buAdd=(Button) findViewById(R.id.btnAdd);
        buDisplay=(Button) findViewById(R.id.btnDisplay);
    }




    public void SaveData(View view)
    {

        SharedPreferences sharedPreferences=getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString("username",etName.getText().toString());
        editor.putString("userpass",etPass.getText().toString());

        editor.apply();

        Toast.makeText(this, "Data Saved in SharedPrerences", Toast.LENGTH_LONG).show();
    }

    public void DisplayData(View view)
    {
        SharedPreferences sharedPreferences=getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        String name=sharedPreferences.getString("username","");
        String pass=sharedPreferences.getString("userpass","");

        tvResult.setText(name + " " + pass);
    }
}
