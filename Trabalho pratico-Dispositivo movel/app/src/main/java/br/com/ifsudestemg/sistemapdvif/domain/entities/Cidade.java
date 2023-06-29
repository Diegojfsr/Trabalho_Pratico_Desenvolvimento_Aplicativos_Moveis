package br.com.ifsudestemg.sistemapdvif.domain.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Cidade implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    public int id;

    @ColumnInfo(name = "CODESTADO")
    public int codEstado;

    @ColumnInfo(name = "NOME", defaultValue = "")
    public String nome;

    @ColumnInfo(name = "CODIBGE", defaultValue = "")
    public String codIBGE;

    @NonNull
    @Override
    public String toString() {
        return nome;
    }
}
