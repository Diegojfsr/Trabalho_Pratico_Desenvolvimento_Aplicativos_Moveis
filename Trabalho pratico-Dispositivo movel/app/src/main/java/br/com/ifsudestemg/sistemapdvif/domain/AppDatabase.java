package br.com.ifsudestemg.sistemapdvif.domain;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import br.com.ifsudestemg.sistemapdvif.domain.entities.Cidade;
import br.com.ifsudestemg.sistemapdvif.domain.entities.Paciente;

@Database(entities = {Paciente.class, Cidade.class}, version = 1)
public abstract class AppDatabase
                    extends RoomDatabase {

    private static AppDatabase db = null;

    public abstract PacienteDAO pacienteDAO();

    public abstract CidadeDAO cidadeDAO();

    public static AppDatabase getDatabase(Context context){
        if (db == null){
            db = Room.databaseBuilder(context,
                    AppDatabase.class, "DadosRoom.db").
                    allowMainThreadQueries().build();
        }

        return db;
    }


}
