package com.example.tcc02;



import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class InformationActivity extends AppCompatActivity {

    int i [] = {R.drawable.dislexia,R.drawable.abd,R.drawable.ida,R.drawable.opendyslexic,R.drawable.leonardo,R.drawable.albert,R.drawable.charles,};

    String s1[],s2[],s3[];


    RecyclerView recview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);




        s1 = getResources().getStringArray(R.array.Titulo);
        s2 = getResources().getStringArray(R.array.Descricão);
        s3 = getResources().getStringArray(R.array.Links);

        recview =findViewById(R.id.RV);






        MyAdapter myadapter = new MyAdapter(this,s1,s2,s3,i);


        recview.setAdapter(myadapter);
        recview.setLayoutManager(new LinearLayoutManager(this) );
        recview.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));



    }






}