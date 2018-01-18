package br.com.box1993.aluracursolayout.ui.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by khalleb on 17/01/18.
 */

public class MoedaUtil {

    public static final String FORMATO_PADRAO = "R$";
    public static final String FORMATO_COM_ESPACO = "R$ ";
    public static final String BRASIL = "br";
    public static final String PORTUGUES = "pt";

    public static String formataParaBrasil(BigDecimal valor) {
        NumberFormat formatoBrasileiro = DecimalFormat.getCurrencyInstance(new Locale(PORTUGUES, BRASIL));
        return formatoBrasileiro.format(valor).replace(FORMATO_PADRAO, FORMATO_COM_ESPACO);
    }
}
