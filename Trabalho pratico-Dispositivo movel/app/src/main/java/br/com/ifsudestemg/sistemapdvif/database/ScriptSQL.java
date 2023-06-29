package br.com.ifsudestemg.sistemapdvif.database;

/**
 * Classe responsável por conter todo o código de script
 * DDL
 */
public class ScriptSQL {

    public static String createTable(){

        String sql = "CREATE TABLE PACIENTE(\n" +
                "       _ID INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "       NOME TEXT NOT NULL DEFAULT '', \n" +
                "       CPF VARCHAR(2) NOT NULL DEFAULT ''\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE CIDADE(\n" +
                "       _ID INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "       CODESTADO INTEGER NOT NULL,\n" +
                "       NOME TEXT NOT NULL DEFAULT '',\n" +
                "       IBGE VARCHAR(7) NOT NULL DEFAULT '',\n" +
                "       CONSTRAINT FK_ESTADO_CIDADE \n" +
                "        FOREIGN KEY(CODESTADO) REFERENCES \n" +
                "                           ESTADO(_ID)\n" +
                ");";

        return sql;
    }

    public static String dropTablePaciente(){
        String sql = "DROP TABLE IF EXISTS PACIENTE";
        return sql;
    }

}
