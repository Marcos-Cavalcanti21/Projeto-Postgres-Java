package SERVICE.DAO;

import SERVICE.ConnectDB.ConexaoPostSQL;
import VIEW.Menu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CaixaDAO {
    public static void abreCaixa(){

        Connection conexao = ConexaoPostSQL.getConecta_DB();
        try{
            String sql = "SELECT ABRE_CAIXA('0,00')";
            Statement statement = conexao.createStatement();
            ResultSet results = statement.executeQuery(sql);

            System.out.println("\n\nCaixa aberto com Sucesso!");

            Menu.pdv();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConexaoPostSQL.fecharConexao();
    }

    public static void atualizaCaixa(){

        Connection conexao = ConexaoPostSQL.getConecta_DB();
        try{
            String sql = "SELECT ATUALIZA_CAIXA()";
            Statement statement = conexao.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            System.out.println("\n\nVenda Efetuada!");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void fechaCaixa(){

        Connection conexao = ConexaoPostSQL.getConecta_DB();
        try{
            String sql = "SELECT FECHA_CAIXA()";
            Statement statement = conexao.createStatement();
            ResultSet results = statement.executeQuery(sql);

            System.out.println("\n\nCaixa fechado com Sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConexaoPostSQL.fecharConexao();
    }
}
