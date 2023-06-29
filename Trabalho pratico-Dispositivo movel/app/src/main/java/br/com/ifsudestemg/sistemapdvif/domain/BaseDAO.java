package br.com.ifsudestemg.sistemapdvif.domain;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.com.ifsudestemg.sistemapdvif.domain.entities.Cidade;

public interface BaseDAO<T> {

    @Insert
    public void inserir(T entity);

    @Delete
    public void excluir(T entity);

    @Update
    public void atualizar(T entity);

}
