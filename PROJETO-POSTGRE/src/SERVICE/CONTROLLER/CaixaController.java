package SERVICE.CONTROLLER;

import SERVICE.ConexaoPostSQL;

import java.sql.*;

public class CaixaController {
    public static void abreCaixa(){

        Connection conexao = ConexaoPostSQL.getConecta_DB();
        try{
            String sql = "SELECT ABRE_CAIXA('0,00')";
            Statement statement = conexao.createStatement();
            ResultSet results = statement.executeQuery(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        ConexaoPostSQL.fecharConexao();

    }

    public static void atualizaCaixa(){


        Connection conexao = ConexaoPostSQL.getConecta_DB();
        try{
            String sql = "SELECT ATUALIZA_CAIXA()";
        }
    }

}

