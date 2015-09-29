package com.example.felipe.projetoaeronave_arqdesis15.util;

import android.app.Activity;
import android.graphics.drawable.Drawable;

import com.example.felipe.projetoaeronave_arqdesis15.R;

import java.lang.reflect.Field;

/**
 * Created by Felipe on 13/09/2015.
 */
public class Util {
    public static Drawable getDrawable(Activity context, String drawableName){
        //procurar a imagem por meio de reflection
        Class<?> c = R.drawable.class;
        try {
            Field idField = c.getDeclaredField(drawableName);
            int id = idField.getInt(idField);
            return context.getResources().getDrawable(id);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
