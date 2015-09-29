package com.example.felipe.projetoaeronave_arqdesis15.util;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Felipe on 13/09/2015.
 */
public class ViewHolder {
    private ImageView fotinhoVoo;
    private TextView horarioVoo, detalhesVoo;

    public ViewHolder(ImageView fotinhoVoo, TextView horarioVoo, TextView detalhesVoo) {
        this.fotinhoVoo = fotinhoVoo;
        this.horarioVoo = horarioVoo;
        this.detalhesVoo = detalhesVoo;
    }

    public ImageView getFotinhoVoo() {
        return fotinhoVoo;
    }

    public void setFotinhoVoo(ImageView fotinhoVoo) {
        this.fotinhoVoo = fotinhoVoo;
    }

    public TextView getHorarioVoo() {
        return horarioVoo;
    }

    public void setHorarioVoo(TextView horarioVoo) {
        this.horarioVoo = horarioVoo;
    }

    public TextView getDetalhesVoo() {
        return detalhesVoo;
    }

    public void setDetalhesVoo(TextView detalhesVoo) {
        this.detalhesVoo = detalhesVoo;
    }
}
