package SERVICE.DAO;

import MODEL.Categoria;
import SERVICE.ConnectDB.ConexaoPostSQL;
import SERVICE.Get;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoriaDAO {
    public static void insereCategoria(){
        String nome;

        System.out.println("Nova Categoria: ");
        nome = Get.string();

        Categoria c = new Categoria(0, nome);

        Connection conexao = ConexaoPostSQL.getConecta_DB();

        try{
            String sql = "CALL INSERT_CATEGORIA(?)";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, nome);

            statement.executeUpdate();

            System.out.println("---Categoria Cadastrada com Sucesso!!---");

        }catch (SQLException e){
            e.printStackTrace();
        }
        ConexaoPostSQL.fecharConexao();
    }
}
