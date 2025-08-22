package br.edu.fatecpg.crudsimpes.controller;

import br.edu.fatecpg.crudsimpes.model.Banco;
import br.edu.fatecpg.crudsimpes.model.Consulta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ConsultaController {

    //metodo insert CREATE

    public String createConsulta(String nomePaciente, String data, String hora){

        //query para fazer insert
        String query = "INSERT INTO tb_consulta(nm_paciente, dt_consulta, hr_consulta)" +
                            "VALUES(?,?,?)";

        try(var conexao = Banco.conectar()){//usar o try garante que a conexao será fechada no fim do bloco

            //cria um objeto preparedStatement para garantir a segurança evitando sql injection
            PreparedStatement stmt = conexao.prepareStatement(query);

            stmt.setString(1, nomePaciente);
            stmt.setString(2, data);
            stmt.setString(3, hora);

            //executa
            stmt.execute();

            return "Gravado com sucesso!!";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    //metodo read

    public String readConsultas(){

        //querry select
        String query = "SELECT * FROM tb_consulta";

        //lista do tipo consulta
        List<Consulta> consultas = new ArrayList<>();


        try(var conexao = Banco.conectar()){

            //conexao. seria a mesma coisa se colocasse Banco.conectar
            PreparedStatement stmt = conexao.prepareStatement(query);

            //cria uma tabela temporaria na memoria
            ResultSet rs = stmt.executeQuery();


            while(rs.next()){
                //vou adicionar em consulta um novo objeto Consulta com as string capturadas
                consultas.add(new Consulta(rs.getString("nm_paciente"),
                        rs.getString("dt_consulta"),
                        rs.getString("hr_consulta")));
            }

            return consultas.toString();
        }catch (Exception e){
            return e.getMessage();
        }
    }

    //delete
    public String deleteConsulta(int idPaciente){

        String query = "DELETE FROM tb_consulta WHERE id_paciente = ?";

        try(var conexao = Banco.conectar()){
            PreparedStatement stmt = conexao. prepareStatement(query);

            stmt.setInt(1, idPaciente);
            stmt.execute();

            return "Apagado com Sucesso!!";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    //metodo update

    public String updateConsulta(int idPaciente, String novoNomePaciente){

        String query = "UPDATE tb_consulta SET nm_paciente = ? WHERE id_paciente = ?";

        try(var conexao = Banco.conectar()){

            PreparedStatement stmt = conexao.prepareStatement(query);

            stmt.setString(1, novoNomePaciente);
            stmt.setInt(2, idPaciente);
            stmt.execute();

            return "Atualizado Com Sucesso!!!";
        }catch (Exception e){
            return e.getMessage();
        }

    }
}
