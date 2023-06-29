package br.com.ifsudestemg.sistemapdvif.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DadosDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 4;
    public static final String DATABASE_NAME = "Dados.db";

    public DadosDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Método responsável por criar as tabelas da base de dados.
     * O parâmetro db é um referência para conexão ativa do banco
     * de dados.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String[] scripts = ScriptSQL.createTable().split(";");
        for (String sql : scripts) {
            db.execSQL(sql);
        }

    }

    /**
     * Método utilizado quando precisamos atualizar a estrutura do
     * banco de dados. Para atualizar a estrutura do banco devemos
     * alterar a sua versão.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ScriptSQL.dropTablePaciente());
        onCreate(db);
    }
}
