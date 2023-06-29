package br.com.ifsudestemg.sistemapdvif.domain.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Cliente implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    public int id;

    @ColumnInfo(name = "CODESTADO")
    public int codEstado;

    @ColumnInfo(name = "CODCIDADE")
    public int codCidade;

    @ColumnInfo(name = "NOME")
    public String nome;

    @NonNull
    @Override
    public String toString() {
        return nome;
    }

}
