package br.com.box1993.aluracursolayout.ui.util;

import android.support.annotation.NonNull;

/**
 * Created by khalleb on 17/01/18.
 */

public class DiasUtil {

    public static final String PLURAL = " Dias";
    public static final String SINGULAR = " Dia";

    @NonNull
    public static String formataEmTexto(int qtdeDias) {

        if (qtdeDias > 1) {
            return qtdeDias + PLURAL;
        } else {
            return qtdeDias + SINGULAR;
        }
    }
}
