package com.example.felipe.projetoaeronave_arqdesis15.controller;

/**
 * Created by Felipe on 13/09/2015.
 */

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.felipe.projetoaeronave_arqdesis15.R;
import com.example.felipe.projetoaeronave_arqdesis15.data.CategoriasDb;
import com.example.felipe.projetoaeronave_arqdesis15.model.Voo;
import com.example.felipe.projetoaeronave_arqdesis15.network.VooRequester;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    Spinner spinnerOrigem;
    Spinner spinnerDestino;
    Button btnConsultar;
    String origem, destino;
    ArrayList<Voo> vooss;
    final String servidor = "jbossews-cerveja.rhcloud.com";
    //final String servidor = "10.0.2.2:8080/arqdesis_json";
    VooRequester requester;
    ProgressBar mProgress;
    Intent intent;
    Context contexto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        this.contexto = this;
        setupViews();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        spinnerOrigem.setSelection(0);
        spinnerDestino.setSelection(0);
    }

    private void setupViews() {
        destino = "";
        origem = "";
        btnConsultar = (Button) findViewById(R.id.botao_enviar);



        spinnerDestino = (Spinner) findViewById(R.id.dropdown_destino);
        new CarregaSpinnerDestino().execute(CategoriasDb.DESTINO);
        spinnerDestino.setOnItemSelectedListener(new DestinoSelecionado());

        spinnerOrigem = (Spinner) findViewById(R.id.dropdown_origem);
        new CarregaSpinnerOrigem().execute(CategoriasDb.ORIGEM);
        spinnerOrigem.setOnItemSelectedListener(new OrigemSelecionado());


        mProgress.setVisibility(View.INVISIBLE);

    }

    private class DestinoSelecionado implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            destino = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private class OrigemSelecionado implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            origem = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    // constante static para identificar o parametro
    public final static String VOOS = "com.example.felipe.VOOS";

    //será chamado quando o usuário clicar em enviar
    public void consultarVoos(View view) {
        final String pOrigem = this.origem.equals("Escolha a origem") ? "" : origem;
        final String pDestino = this.destino.equals("Escolha o destino") ? "" : destino;


        requester = new VooRequester();
        if (requester.isConnected(this)) {
            intent = new Intent(this, ListaVooCompleto.class);

            mProgress.setVisibility(View.VISIBLE);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        vooss = requester.get("http://" + servidor + "/selecao.json", pOrigem, pDestino);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                intent.putExtra(VOOS, vooss);
                                mProgress.setVisibility(View.INVISIBLE);
                                startActivity(intent);
                            }
                        });

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } else {
            Toast toast = Toast.makeText(this, "Rede indisponível!", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    private class CarregaSpinnerOrigem extends AsyncTask<String, Void, ArrayList<String>> {

        @Override
        protected ArrayList<String> doInBackground(String... params) {
            CategoriasDb db = new CategoriasDb(contexto);
            ArrayList<String> lista = db.selecionaOrigens();
            if (lista.size() == 1)
                db.insereOrigem();
            lista = db.selecionaOrigens();
            return lista;
        }

        @Override
        protected void onPostExecute(ArrayList<String> result) {
            ArrayAdapter<String> origemAdapter = new ArrayAdapter<String>(contexto,
                    android.R.layout.simple_spinner_item, result);
            spinnerOrigem.setAdapter(origemAdapter);
        }
    }


    private class CarregaSpinnerDestino extends AsyncTask<String, Void, ArrayList<String>> {

        @Override
        protected ArrayList<String> doInBackground(String... params) {
            CategoriasDb db = new CategoriasDb(contexto);
            ArrayList<String> lista = db.selecionaDestinos();
            if (lista.size() == 1)
                db.insereDestino();
            lista = db.selecionaDestinos();
            return lista;
        }

        @Override
        protected void onPostExecute(ArrayList<String> result) {
            ArrayAdapter<String> destinoAdapter = new ArrayAdapter<String>(contexto,
                    android.R.layout.simple_spinner_item, result);
            spinnerDestino.setAdapter(destinoAdapter);
        }
    }
}