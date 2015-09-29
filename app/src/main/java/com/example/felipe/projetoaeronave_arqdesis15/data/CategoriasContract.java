package com.example.felipe.projetoaeronave_arqdesis15.data;

import android.provider.BaseColumns;

/**
 * Created by Felipe on 28/09/2015.
 */
public class CategoriasContract {

    public static abstract class OrigemEntry implements BaseColumns{
        public static final String TABLE_NAME = "origem";
        public static final String COLUMN_NAME_ORIGEM_VOO = "origemVoo";
    }


    public static abstract class DestinoEntry implements BaseColumns{
        public static final String TABLE_NAME = "destino";
        public static final String COLUMN_NAME_DESTINO_VOO = "destinoVoo";
    }

}
