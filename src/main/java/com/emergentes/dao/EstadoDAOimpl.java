package com.emergentes.dao;

import com.emergentes.modelo.Estado;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstadoDAOimpl extends ConexionDB implements EstadoDAO{

    @Override
    public void insert(Estado estado) throws Exception {
        String sql = "INSERT INTO ESTADOS (estado, descripcion) VALUES (?, ?)";
        try {
            this.Conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, estado.getEstado());
            ps.setString(2, estado.getDescripcion());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconectar();
        }
    }

    @Override
    public void update(Estado estado) throws Exception {
        String sql = "UPDATE ESTADOS SET estado=?, descripcion=? WHERE id=?";
        try {
            this.Conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, estado.getEstado());
            ps.setString(2, estado.getDescripcion());
            ps.setInt(3, estado.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM ESTADOS WHERE id=?";
        try {
            this.Conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconectar();
        }
    }

    @Override
    public Estado getById(int id) throws Exception {
        Estado est = new Estado();
        try {
            String sql = "SELECT * FROM ESTADOS WHERE id=?";
            this.Conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                est.setId(rs.getInt("id"));
                est.setEstado(rs.getString("estado"));
                est.setDescripcion(rs.getString("descripcion"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconectar();
        }

        return est;
    }

    @Override
    public List<Estado> getAll() throws Exception {
        List<Estado> lista = null;
        try {
            String sql = "SELECT * FROM ESTADOS";
            this.Conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Estado>();
            while (rs.next()) {
                Estado est = new Estado();
                est.setId(rs.getInt("id"));
                est.setEstado(rs.getString("estado"));
                est.setDescripcion(rs.getString("descripcion"));
                
                lista.add(est);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconectar();
        }

        return lista;
    }
}
