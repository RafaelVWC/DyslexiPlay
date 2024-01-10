package com.example.tcc02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class InformationPlus extends AppCompatActivity {

    ImageView imagem;
    TextView title, description , link ;

    String data1, data2, data3;

    int images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_plus);

        imagem = findViewById(R.id.imageDesign);
        title = findViewById(R.id.txTitulo);
        description = findViewById(R.id.txtDescricao);
        link = findViewById(R.id.txtLink);

        getData();
        setData();



    }

    private void getData(){

           if(getIntent().hasExtra("images") && getIntent().hasExtra("data1") && getIntent().hasExtra("data2") && getIntent().hasExtra("data3") ){

               data1=getIntent().getStringExtra("data1");
               data2=getIntent().getStringExtra("data2");
               data3=getIntent().getStringExtra("data3");
               images=getIntent().getIntExtra("images",1);

           }else{

               Toast.makeText(this,"No data",Toast.LENGTH_SHORT).show();


           }




    }


    private void setData(){

        title.setText(data1);
        description.setText(data2);
        link.setText(data3);
        imagem.setImageResource(images);

    }




}