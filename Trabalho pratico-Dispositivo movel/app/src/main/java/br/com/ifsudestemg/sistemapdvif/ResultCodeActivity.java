package br.com.ifsudestemg.sistemapdvif;

/**
 * Classe que armazena os códigos de retorno entre
 * os Activities quando eles são finalizados. Esses
 * códigos devem ser utilizados no método finishResult
 */
public class ResultCodeActivity {

    /**
     * Código utilizado quando o Activity é finalizado
     * após um dado ser salvo na base de dados.
     */
    public static final int OK     = 200;

    /**
     * Código utilizado quando o Activity é apenas
     * finalizado sem enviar dados para a base de dados.
     */
    public static final int CANCEL = 0;

}
