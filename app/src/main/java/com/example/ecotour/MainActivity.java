package com.example.ecotour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void irPaginaPrincipal(View view){
        Intent mainpage = new Intent(getApplicationContext(),MainPage.class);
        startActivity(mainpage);
    }
}