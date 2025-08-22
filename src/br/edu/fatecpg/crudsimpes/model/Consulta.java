package br.edu.fatecpg.crudsimpes.model;

public class Consulta {

    private String nomePaciente;
    private String dataConsulta;
    private String horaConsulta;

    public Consulta(String nomePaciente, String dataConsulta, String horaConsulta) {
        this.nomePaciente = nomePaciente;
        this.dataConsulta = dataConsulta;
        this.horaConsulta = horaConsulta;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(String horaConsulta) {
        this.horaConsulta = horaConsulta;
    }

    @Override
    public String toString() {
        return "Consulta: Nome do paciente=" + nomePaciente +
                " | Data da consulta = " + dataConsulta +
                " | Hora da consulta=" + horaConsulta + "\n";
    }
}
