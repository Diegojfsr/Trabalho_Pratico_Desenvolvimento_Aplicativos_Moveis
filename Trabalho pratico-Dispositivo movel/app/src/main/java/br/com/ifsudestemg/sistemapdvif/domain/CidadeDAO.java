package br.com.ifsudestemg.sistemapdvif.domain;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.com.ifsudestemg.sistemapdvif.domain.entities.Cidade;

@Dao
public interface CidadeDAO extends BaseDAO<Cidade>{

    @Query("SELECT * FROM cidade")
    public List<Cidade> buscarTodos();

}
