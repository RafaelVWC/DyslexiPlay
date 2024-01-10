package com.example.tcc02;

import android.widget.ImageView;

public class Palavra {
    private int id;
   private String palavra;
   private String  dicatx;
   private int pontos;
   private int imagem;

    public Palavra(int id,String palavra, String dicatx, int pontos, int imagem) {
        this.palavra = palavra;
        this.dicatx = dicatx;
        this.id = id;
        this.pontos = pontos;
        this.imagem = imagem;
    }
    public Palavra(int id,String palavra, String dicatx, int pontos) {
        this.palavra = palavra;
        this.dicatx = dicatx;
        this.id = id;
        this.pontos = pontos;

    }

    public Palavra(String palavra) {
        this.palavra = palavra;
    }

    public String getPalavra() {
        return palavra;
    }



    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public String getDicatx() {
        return dicatx;
    }

    public void setDicatx(String dicatx) {
        this.dicatx = dicatx;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
