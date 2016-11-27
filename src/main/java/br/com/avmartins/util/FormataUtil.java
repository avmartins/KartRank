package br.com.avmartins.util;

public class FormataUtil {
	
	/**
     * Formato milissegundos baseado em cadeia representando o tempo da volta
     *
     * @param milissegundos tempo de volta em milissegundos
     * @return Retornar o tempo de volta formatado
     */
    public static String formata(long millisegundos) {
        long minutos = millisegundos / 60000;
        millisegundos = millisegundos % 60000;
        long segundos = millisegundos / 1000;
        millisegundos = millisegundos % 1000;

        return minutos + ":" + String.format("%02d", segundos) + "." + millisegundos;
    }

}
