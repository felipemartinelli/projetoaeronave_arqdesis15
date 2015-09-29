package com.example.felipe.projetoaeronave_arqdesis15.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.felipe.projetoaeronave_arqdesis15.R;
import com.example.felipe.projetoaeronave_arqdesis15.adapter.VooAdapter;
import com.example.felipe.projetoaeronave_arqdesis15.model.Voo;

import java.util.ArrayList;

public class ListaVooCompleto extends ActionBarActivity {
    ListView listView;
    Activity atividade;
    public final static String VOO = "br.usjt.CERVEJA";
    Voo[] voos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_voo_completo);
        atividade = this;

        //pega a mensagem do intent
        Intent intent = getIntent();
        voos = ((ArrayList<Voo>)intent.getSerializableExtra(MainActivity.VOOS)).toArray(new Voo[0]);

        //cria o listview de cervejas
        listView = (ListView) findViewById(R.id.view_lista_voo);

        VooAdapter adapter = new VooAdapter(this, voos);

        listView.setAdapter(adapter);

        // listener de click em um item do listview

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // manda para a tela de detalhe
                Intent intent = new Intent(atividade, detalhes_voo.class);
                intent.putExtra(VOO, voos[position]);

                startActivity(intent);

            }

        });
    }

}