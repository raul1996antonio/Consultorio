package com.emergentes.modelo;

public class Receta {
    private int id;
    private int id_consulta;
    private String medicamento;
    private String dosis;
    private String indicaciones;
    private String doctor;
    private String paciente;

    public Receta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(int id_consulta) {
        this.id_consulta = id_consulta;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "Receta{" + "id=" + id + ", id_consulta=" + id_consulta + ", medicamento=" + medicamento + ", dosis=" + dosis + ", indicaciones=" + indicaciones + ", doctor=" + doctor + ", paciente=" + paciente + '}';
    }
}
