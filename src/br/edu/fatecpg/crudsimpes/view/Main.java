package br.edu.fatecpg.crudsimpes.view;

import br.edu.fatecpg.crudsimpes.controller.ConsultaController;

public class Main {
    public static void main(String[] args){

    ConsultaController cc = new ConsultaController();

    //System.out.println(cc.createConsulta("Teste da silva", "22/02/2008", "10:00"));

    //System.out.println(cc.deleteConsulta(1));

       // System.out.println(cc.readConsultas());

        System.out.println(cc.updateConsulta(2, "Teste da silva madeira atualizado"));

    }
}
