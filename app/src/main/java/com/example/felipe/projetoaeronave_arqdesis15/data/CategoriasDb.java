package com.example.felipe.projetoaeronave_arqdesis15.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Felipe on 28/09/2015.
 */
public class CategoriasDb {
    CategoriasDbHelper dbHelper;
    public static final String ORIGEM = "origem";
    public static final String DESTINO = "destino";

    public CategoriasDb(Context context){
        dbHelper = new CategoriasDbHelper(context);
    }

    public void insereOrigem(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CategoriasContract.OrigemEntry.COLUMN_NAME_ORIGEM_VOO, "Congonhas");
        db.insert(CategoriasContract.OrigemEntry.TABLE_NAME, null, values);
        values.put(CategoriasContract.OrigemEntry.COLUMN_NAME_ORIGEM_VOO, "Rio de Janeiro");
        db.insert(CategoriasContract.OrigemEntry.TABLE_NAME, null, values);
        values.put(CategoriasContract.OrigemEntry.COLUMN_NAME_ORIGEM_VOO, "Minas Gerais");
        db.insert(CategoriasContract.OrigemEntry.TABLE_NAME, null, values);
        values.put(CategoriasContract.OrigemEntry.COLUMN_NAME_ORIGEM_VOO, "Bahia");
        db.insert(CategoriasContract.OrigemEntry.TABLE_NAME, null, values);
        values.put(CategoriasContract.OrigemEntry.COLUMN_NAME_ORIGEM_VOO, "Pernambuco");
        db.insert(CategoriasContract.OrigemEntry.TABLE_NAME, null, values);
        values.put(CategoriasContract.OrigemEntry.COLUMN_NAME_ORIGEM_VOO, "Espirito Santo");
        db.insert(CategoriasContract.OrigemEntry.TABLE_NAME, null, values);
        values.put(CategoriasContract.OrigemEntry.COLUMN_NAME_ORIGEM_VOO, "Brasilia");
        db.insert(CategoriasContract.OrigemEntry.TABLE_NAME, null, values);

    }

    public void insereDestino(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(CategoriasContract.DestinoEntry.COLUMN_NAME_DESTINO_VOO, "Congonhas");
        db.insert(CategoriasContract.DestinoEntry.TABLE_NAME, null, values);
        values.put(CategoriasContract.DestinoEntry.COLUMN_NAME_DESTINO_VOO, "Rio de Janeiro");
        db.insert(CategoriasContract.DestinoEntry.TABLE_NAME, null, values);
        values.put(CategoriasContract.DestinoEntry.COLUMN_NAME_DESTINO_VOO, "Minas Gerais");
        db.insert(CategoriasContract.DestinoEntry.TABLE_NAME, null, values);
        values.put(CategoriasContract.DestinoEntry.COLUMN_NAME_DESTINO_VOO, "Bahia");
        db.insert(CategoriasContract.DestinoEntry.TABLE_NAME, null, values);
        values.put(CategoriasContract.DestinoEntry.COLUMN_NAME_DESTINO_VOO, "Pernambuco");
        db.insert(CategoriasContract.DestinoEntry.TABLE_NAME, null, values);
        values.put(CategoriasContract.DestinoEntry.COLUMN_NAME_DESTINO_VOO, "Espirito Santo");
        db.insert(CategoriasContract.DestinoEntry.TABLE_NAME, null, values);
        values.put(CategoriasContract.DestinoEntry.COLUMN_NAME_DESTINO_VOO, "Brasilia");
        db.insert(CategoriasContract.DestinoEntry.TABLE_NAME, null, values);


    }


    public ArrayList<String> selecionaOrigens(){
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Escolha o destino");

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] colunas = {CategoriasContract.OrigemEntry._ID,
                CategoriasContract.OrigemEntry.COLUMN_NAME_ORIGEM_VOO};

        String ordem = CategoriasContract.OrigemEntry.COLUMN_NAME_ORIGEM_VOO;

        Cursor c = db.query(CategoriasContract.OrigemEntry.TABLE_NAME, colunas, null, null, ordem, null, null );

        while(c.moveToNext()){
            lista.add(c.getString(c.getColumnIndex(CategoriasContract.OrigemEntry.COLUMN_NAME_ORIGEM_VOO)));
        }

        c.close();

        return lista;
    }


    public ArrayList<String> selecionaDestinos(){
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Escolha o estilo");

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] colunas = {CategoriasContract.DestinoEntry.COLUMN_NAME_DESTINO_VOO};

        String ordem = CategoriasContract.DestinoEntry.COLUMN_NAME_DESTINO_VOO;

        Cursor c = db.query(CategoriasContract.DestinoEntry.TABLE_NAME, colunas, null, null, null, null, ordem);

        while(c.moveToNext()){
            lista.add(c.getString(c.getColumnIndex(CategoriasContract.DestinoEntry.COLUMN_NAME_DESTINO_VOO)));
        }

        c.close();

        return lista;
    }



}