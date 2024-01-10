package com.example.tcc02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class RankingActivity extends AppCompatActivity {

    TextView ponto;

    private int pontuacao = 0;

    String ARQUIVO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        ponto = findViewById(R.id.txtPontos);


        SharedPreferences preferences = getSharedPreferences(ARQUIVO,0);
        preferences.getInt("pontosjogo",pontuacao);


        ponto.setText(String.valueOf(pontuacao));









    }


    @Override

    protected void onStart(){

        super.onStart();

        ponto = findViewById(R.id.txtPontos);



        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());


        ponto.setText( preferences.getString("pontosjogo","0"));










    }








}