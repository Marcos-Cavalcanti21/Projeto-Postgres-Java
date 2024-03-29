package SERVICE.DAO;

import MODEL.Cargo;
import SERVICE.ConnectDB.ConexaoPostSQL;
import SERVICE.Get;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CargoDAO {
    public static void InsereCargo(){

        String titulo;

        System.out.println("Novo Cargo: ");
        titulo = Get.string();

        Cargo c = new Cargo(0, titulo);
        Connection conexao = ConexaoPostSQL.getConecta_DB();
        try{
            String sql = "CALL INSERT_CARGO(?);";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, c.getTitulo());

            statement.executeUpdate();

            System.out.println("---Cargo Cadastrado com Sucesso!!---");

            // System.out.println("\n\nVenda Efetuada!");

        }catch (SQLException e){
            e.printStackTrace();
        }
        ConexaoPostSQL.fecharConexao();
    }
}
