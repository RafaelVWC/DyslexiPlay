package com.example.tcc02;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {


    public void IrForcaActivity(View view){

        Intent intent = new Intent(this, ForcaActivity.class);

        startActivity(intent);


    }




    public void IrRankingActivity(View view){

        Intent intent = new Intent(this, RankingActivity.class);

        startActivity(intent);


    }




    public void SairAPP(View view){


        this.finishAffinity();



    }


    public void IrInformationActivity(View view){

        Intent intent = new Intent(this,InformationActivity.class);

        startActivity(intent);
    }






















    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
}