package com.example.felipe.projetoaeronave_arqdesis15.controller;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.felipe.projetoaeronave_arqdesis15.R;
import com.example.felipe.projetoaeronave_arqdesis15.model.Voo;
import com.example.felipe.projetoaeronave_arqdesis15.util.Util;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

public class detalhes_voo extends ActionBarActivity {
    TextView vooHorario;
    ImageView cervejaImageView;
    TextView vooPreco;
    TextView vooOrigem;
    TextView vooDestino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_voo);

        Intent intent = getIntent();
        Serializable obj = intent.getSerializableExtra(ListaVooCompleto.VOO);
        Voo voo = (Voo)obj;
        setupViews(voo);

    }

    private void setupViews(Voo voo) {
       // vooNome = (TextView) findViewById(R.id.txt_voo_nome);
       // vooNome.setText(voo.getNome());
        cervejaImageView = (ImageView) findViewById(R.id.voo_image_view);
        Drawable drawable = Util.getDrawable(this, voo.getImagem());
        cervejaImageView.setImageDrawable(drawable);
        vooPreco = (TextView) findViewById(R.id.txt_voo_preco);
        Locale locale = new Locale("pt", "BR");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        vooPreco.setText(""+formatter.format(voo.getPreco()));
        vooDestino = (TextView) findViewById(R.id.txt_voo_destino);
        vooDestino.setText(voo.getDestino());
        vooHorario = (TextView) findViewById(R.id.txt_voo_horario);
        vooHorario.setText(voo.getHorario());

    }

}
