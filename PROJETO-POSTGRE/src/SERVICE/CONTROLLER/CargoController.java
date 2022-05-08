package SERVICE.CONTROLLER;

import MODEL.Cargo;
import SERVICE.ConexaoPostSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CargoController {
    public static void atualizaCaixa(){

        //Cargo cargo = new Cargo;
        Connection conexao = ConexaoPostSQL.getConecta_DB();
        try{
            String sql = "SELECT INSERT_CATEGORIA()";
            Statement statement = conexao.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            System.out.println("\n\nVenda Efetuada!");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
