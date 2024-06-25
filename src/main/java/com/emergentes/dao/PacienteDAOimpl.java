package com.emergentes.dao;

import com.emergentes.modelo.Paciente;
import com.emergentes.utiles.ConexionDB;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAOimpl extends ConexionDB implements PacienteDAO{

    @Override
    public void insert(Paciente paciente) throws Exception {
        String sql = "INSERT INTO PACIENTES (ci, nombre, ap_paterno, ap_materno, fecha_nacimiento, sexo, telefono, direccion, ciudad, correo, id_recepcionista) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            this.Conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, paciente.getCi());
            ps.setString(2, paciente.getNombre());
            ps.setString(3, paciente.getPaterno());
            ps.setString(4, paciente.getMaterno());
            ps.setDate(5, (Date) paciente.getFecha_nacimiento());
            ps.setString(6, paciente.getSexo());
            ps.setInt(7, paciente.getTelefono());
            ps.setString(8, paciente.getDireccion());
            ps.setString(9, paciente.getCiudad());
            ps.setString(10, paciente.getCorreo());
            ps.setInt(11, paciente.getId_recepcionista());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconectar();
        }
    }

    @Override
    public void update(Paciente paciente) throws Exception {
        String sql = "UPDATE PACIENTES SET ci=?, nombre=?, ap_paterno=?, ap_materno=?, fecha_nacimiento=?, sexo=?, telefono=?, direccion=?, ciudad=?, correo=?, id_recepcionista=? WHERE id=?";
        try {
            this.Conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, paciente.getCi());
            ps.setString(2, paciente.getNombre());
            ps.setString(3, paciente.getPaterno());
            ps.setString(4, paciente.getMaterno());
            ps.setDate(5, (Date) paciente.getFecha_nacimiento());
            ps.setString(6, paciente.getSexo());
            ps.setInt(7, paciente.getTelefono());
            ps.setString(8, paciente.getDireccion());
            ps.setString(9, paciente.getCiudad());
            ps.setString(10, paciente.getCorreo());
            ps.setInt(11, paciente.getId_recepcionista());
            ps.setInt(12, paciente.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM PACIENTES WHERE id=?";
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
    public Paciente getById(int id) throws Exception {
        Paciente pac = new Paciente();
        try {
            String sql = "SELECT * FROM PACIENTES WHERE id=?";
            this.Conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pac.setId(rs.getInt("id"));
                pac.setCi(rs.getInt("ci"));
                pac.setNombre(rs.getString("nombre"));
                pac.setPaterno(rs.getString("ap_paterno"));
                pac.setMaterno(rs.getString("ap_materno"));
                pac.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                pac.setSexo(rs.getString("sexo"));
                pac.setTelefono(rs.getInt("telefono"));
                pac.setDireccion(rs.getString("direccion"));
                pac.setCiudad(rs.getString("ciudad"));
                pac.setCorreo(rs.getString("correo"));
                pac.setId_recepcionista(rs.getInt("id_recepcionista"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconectar();
        }

        return pac;
    }

    @Override
    public List<Paciente> getAll() throws Exception {
        List<Paciente> lista = null;
        try {
            String sql = "SELECT P.*, CONCAT_WS(' ', R.nombre, R.ap_paterno, R.ap_materno) AS recepcionista ";
            sql += "FROM PACIENTES P LEFT JOIN RECEPCIONISTAS R ON P.id_recepcionista = R.id";
            this.Conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Paciente>();
            while (rs.next()) {
                Paciente pac = new Paciente();
                pac.setId(rs.getInt("id"));
                pac.setCi(rs.getInt("ci"));
                pac.setNombre(rs.getString("nombre"));
                pac.setPaterno(rs.getString("ap_paterno"));
                pac.setMaterno(rs.getString("ap_materno"));
                pac.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                pac.setSexo(rs.getString("sexo"));
                pac.setTelefono(rs.getInt("telefono"));
                pac.setDireccion(rs.getString("direccion"));
                pac.setCiudad(rs.getString("ciudad"));
                pac.setCorreo(rs.getString("correo"));
                pac.setId_recepcionista(rs.getInt("id_recepcionista"));
                pac.setRecepcionista(rs.getString("recepcionista"));
                lista.add(pac);
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
