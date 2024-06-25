package com.emergentes.dao;

import com.emergentes.modelo.Estado;
import java.util.List;

public interface EstadoDAO {
    public void insert(Estado estado) throws Exception;
    public void update(Estado estado) throws Exception;
    public void delete(int id) throws Exception;
    public Estado getById(int id) throws Exception;
    public List<Estado> getAll() throws Exception;
}
