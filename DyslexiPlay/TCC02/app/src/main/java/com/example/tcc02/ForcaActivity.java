package com.example.tcc02;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ForcaActivity extends AppCompatActivity {

    private TextView txtpalavra;
    private String palavra;
    private String palavraMostrada;
    private ArrayList<String> ListaDePalavras;
    private EditText letraTentativa;
    private char[] palavraCA;
    private TextView txtletrasUsadas;
    private String letrasUsadas;
    private String Dica;
    private final String Mensagem_Letras_Usadas = "Letras Usadas:";
    private TextView txtRestantes;
    private String restantes;
    private final String Mensagem_Vitoria = "Você Acertou!";
    private final String Mensagem_Derrota = "Você Errou!";
    private TextToSpeech PalavraAudio;
    private ImageView Forca;
    private Button TTS ;
    private Button reset;
    private Button verificar;
    private Button dica;
    private Button sair;
    private int ntentativas;
    private TextView pontuacao;
    private ImageView img;
    private int pontos = 0;
    private ArrayList<Palavra> ListaDeObjetos = new ArrayList<Palavra>();
    public static final String ARQUIVO = "com.example.ranking";



    public void LoadPalavras(){

        Palavra p1 = new Palavra(1,"amarelo","uma cor",200,R.drawable.amarelo);
        Palavra p2 = new Palavra(2,"vermelho","uma cor",200,R.drawable.vermelho);
        Palavra p3 = new Palavra(3,"azul","uma cor",200,R.drawable.azul);
        Palavra p4 = new Palavra(4,"verde","uma cor",200,R.drawable.verde);
        Palavra p5 = new Palavra(5,"pato","Um animal de penas",200,R.drawable.pato);
        Palavra p6 = new Palavra(6,"girafa","Um animal de grande pescoço",300,R.drawable.girafa);
        Palavra p7 = new Palavra(7,"cachorro","Melhor amigo do homem",200,R.drawable.cachorro);
        Palavra p8 = new Palavra(8,"gato","Sempre cai de pé",200,R.drawable.gato);
        Palavra p9 = new Palavra(9,"brasil","País verde e amarelo",200,R.drawable.brasil);
        Palavra p10 = new Palavra(10,"inglaterra","País da realeza",300,R.drawable.inglaterra);
        Palavra p11= new Palavra(11,"espanha","País da tourada",300,R.drawable.espanha);
        Palavra p12= new Palavra(12,"alemanha","País do pretzel",300,R.drawable.alemanha);
        Palavra p13= new Palavra(13,"dinamarca","País dos vikings",400,R.drawable.dinamarca);
        Palavra p14 = new Palavra(14,"irlanda","País do pote de ouro",400,R.drawable.irlanda);
        Palavra p15= new Palavra(15,"argentina","País do Lionel Messi",400,R.drawable.argentina);
        Palavra p16= new Palavra(16,"dislexia","Distúrbio de aprendizagem",500,R.drawable.dislexia);
        Palavra p17 = new Palavra(17,"aleatorio","Varia",600,R.drawable.aleatorio);
        Palavra p18 = new Palavra(18,"quadro","Obra de Arte",600,R.drawable.monalisa);
        Palavra p19 = new Palavra(19,"carro","Veículo de quatro rodas",200,R.drawable.carro);
        Palavra p20 = new Palavra(20,"computador","Máquina inteligente",500,R.drawable.computador);


        ListaDeObjetos.add(p1);
        ListaDeObjetos.add(p2);
        ListaDeObjetos.add(p3);
        ListaDeObjetos.add(p4);
        ListaDeObjetos.add(p5);
        ListaDeObjetos.add(p6);
        ListaDeObjetos.add(p7);
        ListaDeObjetos.add(p8);
        ListaDeObjetos.add(p9);
        ListaDeObjetos.add(p10);
        ListaDeObjetos.add(p11);
        ListaDeObjetos.add(p12);
        ListaDeObjetos.add(p13);
        ListaDeObjetos.add(p14);
        ListaDeObjetos.add(p15);
        ListaDeObjetos.add(p16);
        ListaDeObjetos.add(p17);
        ListaDeObjetos.add(p18);
        ListaDeObjetos.add(p19);
        ListaDeObjetos.add(p20);
    }

    //modificar tela
    public void SairMenuActivity(View view){



        Intent intent = new Intent(this, MenuActivity.class);


        salvarData();

        startActivity(intent);


    }







    //verificacão da letra
    public void VerificaSeLetraPalavra(char letra){

        if(palavra.indexOf(letra) >= 0){


            if(palavraMostrada.indexOf(letra) < 0 ){

                revelarLetraPalavra(letra);

                mostrarPalavraTela();

                if(!palavraMostrada.contains("_")) {

                    //coloca a palavra na tela e a lê

                    txtpalavra.setText(palavra);

                    TTS.performClick();

                    //contagem de pontos + retirando o botão verificar e dica

                    pontos += ListaDeObjetos.get(0).getPontos();


                    txtRestantes.setText(Mensagem_Vitoria);

                    verificar.setClickable(false);
                    verificar.setVisibility(View.INVISIBLE);
                    dica.setVisibility(View.INVISIBLE);
                    dica.setClickable(false);


                    if (img.getVisibility() == View.VISIBLE) {

                        pontos = pontos - 100;

                    }

                    //Mostrando resultados

                    Toast.makeText(getApplicationContext(), "Pontos ganhos no total:" + pontos, Toast.LENGTH_LONG).show();



                    if(img.getVisibility() == View.VISIBLE){

                        int aux;
                        aux = ListaDeObjetos.get(0).getPontos() - 100 ;

                        pontuacao.setText("Pontos ganhos : " + aux);


                    }else {

                        pontuacao.setText("Pontos ganhos : " + ListaDeObjetos.get(0).getPontos());

                    }
                    //Fornecendo a opção de continuar ou sair

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle(Mensagem_Vitoria);
                    builder.setMessage("Continuar Jogando?")
                            .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    IniciarJogo();
                                }
                            })
                            .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                }
                            });

                    builder.show();
                }

            }

        }

        else{

            //Contabilizando erro e mudando imagem da forca adequadamente

            removerEMostrarRestantes();

            ntentativas = ntentativas -1;

            switch (ntentativas) {


                case 5:
                    Forca.setImageResource(R.drawable.f1);

                    break;


                case 4:
                    Forca.setImageResource(R.drawable.f2);

                    break;

                case 3:
                    Forca.setImageResource(R.drawable.f3);

                    break;


                case 2:
                    Forca.setImageResource(R.drawable.f4);

                    break;


                case 1:
                    Forca.setImageResource(R.drawable.f5);

                    break;

                case 0:
                    Forca.setImageResource(R.drawable.f6);
            }



            if(ntentativas <= 0){

                //Formalizando a derrota + retirando botões de verificar e dica + revelando a palavra e a lendo

                txtRestantes.setText(Mensagem_Derrota);
                txtpalavra.setText(palavra);
                verificar.setClickable(false);
                verificar.setVisibility(View.INVISIBLE);
                dica.setVisibility(View.INVISIBLE);
                dica.setClickable(false);
                TTS.performClick();

                //Fornecendo a opção de recomeçar ou sair

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(Mensagem_Derrota);
                builder.setMessage("Continuar Jogando?")
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                IniciarJogo();
                            }
                        })
                        .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });

                builder.show();



            }

            //Mostrando letras usadas

            if(letrasUsadas.indexOf(letra)<0){
                letrasUsadas += letra + "," ;
                String mensagemParaMostrar = Mensagem_Letras_Usadas + letrasUsadas;
                txtletrasUsadas.setText(mensagemParaMostrar);

            }



        }


    }


    //Remover tentativas

    public void removerEMostrarRestantes(){

        if(!restantes.isEmpty()){

            int tentativas = ntentativas-1;

            txtRestantes.setText("Tentativas restantes:" + tentativas );

        }

    }




    public void revelarLetraPalavra(char letra){

        int indexDaLetra = palavra.indexOf(letra);

        while(indexDaLetra >= 0){

            palavraCA[indexDaLetra] = palavra.charAt(indexDaLetra);
            indexDaLetra = palavra.indexOf(letra,indexDaLetra+1);

        }

        palavraMostrada = String.valueOf(palavraCA);

    }


    //Revelar letra
    public void mostrarPalavraTela(){

        String palavraFormatada ="";
        for(char character : palavraCA){

            palavraFormatada += character + " ";

        }

        txtpalavra.setText(palavraFormatada);



    }

    //salvar data

    public void salvarData() {

        try {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            SharedPreferences.Editor editor = preferences.edit();

            editor.putString("pontosjogo",String.valueOf(pontos));
            editor.commit();

        } catch (Exception e) {

            e.printStackTrace();


        }

    }


    // iniciar game
    void IniciarJogo(){

        Collections.shuffle(ListaDeObjetos);
        palavra =ListaDeObjetos.get(0).getPalavra();
        Dica = ListaDeObjetos.get(0).getDicatx();

        Forca.setImageResource(R.drawable.f0);

        img.setVisibility(View.INVISIBLE);

        verificar.setVisibility(View.VISIBLE);

        verificar.setClickable(true);

        dica.setVisibility(View.VISIBLE);

        dica.setClickable(true);

        ntentativas = 6;

        palavraCA = palavra.toCharArray();

        for(int i=1; i<palavraCA.length-1;i++ ){

            palavraCA[i] = '_';


        }

        revelarLetraPalavra(palavraCA[0]);

        revelarLetraPalavra(palavraCA[palavraCA.length-1]);

        palavraMostrada = String.valueOf(palavraCA);

        mostrarPalavraTela();

        letraTentativa.setText("");

        letrasUsadas = " ";

        txtletrasUsadas.setText(Mensagem_Letras_Usadas);

        restantes = " X X X X X X";

        txtRestantes.setText("");



    }

    // Reprodução de Aúdio

    void Falar(){

        String fala = txtpalavra.getText().toString();

        String palavrasemtraco = "";

        for(int i  = 0 ; i<fala.length() ; i++ ){

            if (fala.charAt(i) != '_'){

                palavrasemtraco += fala.charAt(i);

            }
        }

        PalavraAudio.setPitch(1);
        PalavraAudio.setSpeechRate((float) 0.8);



        PalavraAudio.speak(palavrasemtraco,TextToSpeech.QUEUE_FLUSH,null);

    } @Override
    protected void onDestroy() {
        if(PalavraAudio != null) {

            PalavraAudio.stop();
            PalavraAudio.shutdown();
        }


        super.onDestroy();


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forca);


        //iniciando variaveis
        ListaDePalavras = new ArrayList<String>();
        Forca = findViewById(R.id.IVForca);
        txtpalavra = findViewById(R.id.TxtViewPalavra);
        letraTentativa = findViewById(R.id.EditTxtTentativa);
        txtletrasUsadas = findViewById(R.id.TxtViewLetras);
        txtRestantes = findViewById(R.id.TxtViewLetrasUsadas);
        reset = findViewById(R.id.BtnReset);
        TTS = findViewById(R.id.BtnTTS);
        verificar = findViewById(R.id.btnVerificar);
        dica = findViewById(R.id.BtnDica);
        pontuacao = findViewById(R.id.textViewPontos);
        img = findViewById(R.id.imgDica);
        sair = findViewById(R.id.BtnSair);

        LoadPalavras();



        PalavraAudio = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    int result = PalavraAudio.setLanguage(Locale.getDefault());

                    if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED ){

                        Log.e("TTS","Language not supported");

                    }else {


                        TTS.setEnabled(true);

                    }

                }else{


                    Log.e("TTS","Initialization Failed");

                }

            }
        });


        //Iniciar Jogo

        IniciarJogo();


        //Botões

        //Text to Speech
        TTS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Falar();

            }
        });


        //Reset
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IniciarJogo();
            }
        });


        //Verificar
        verificar.setOnClickListener(new View.OnClickListener(){

            @Override

            public void onClick(View v){

                if(letraTentativa.getText().toString().equals("")||letraTentativa.getText().toString().equals("1")||letraTentativa.getText().toString().equals("2")||letraTentativa.getText().toString().equals("3")||letraTentativa.getText().toString().equals("4")||letraTentativa.getText().toString().equals("5")||letraTentativa.getText().toString().equals("6")||letraTentativa.getText().toString().equals("7")||letraTentativa.getText().toString().equals("8")||letraTentativa.getText().toString().equals("9")||letraTentativa.getText().toString().equals("0")){

                    Toast.makeText(getApplicationContext(),"Digite uma Letra",Toast.LENGTH_LONG).show();

                }else{
                VerificaSeLetraPalavra(letraTentativa.getText().toString().charAt(0));
                letraTentativa.setText("");
                }
            }

        });



        dica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.setImageResource(ListaDeObjetos.get(0).getImagem());
                Toast.makeText(getApplicationContext(),ListaDeObjetos.get(0).getDicatx(),Toast.LENGTH_LONG).show();
                img.setVisibility(View.VISIBLE);

            }
        });

        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SairMenuActivity(v);
            }
        });




    }



}
