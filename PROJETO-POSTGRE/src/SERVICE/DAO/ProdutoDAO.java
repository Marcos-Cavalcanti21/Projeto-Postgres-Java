package SERVICE.DAO;

import MODEL.Produto;
import SERVICE.ConnectDB.ConexaoPostSQL;
import SERVICE.Get;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO {
    public static void insereProduto() {
        String nome, categoria;
        double preco;

        System.out.println("Nome: ");
        nome = Get.string();

        System.out.println("Categoria: ");
        categoria = Get.string();

        System.out.println("Preço: ");
        preco = Get.decimal();

        Produto p = new Produto(nome, categoria, preco);
        Connection conexao = ConexaoPostSQL.getConecta_DB();

        try {
            String sql = "CALL INSERT_PRODUTO(?,?,?);";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, p.getNome());
            statement.setString(2, p.getCategoria());
            statement.setDouble(3, p.getPreco());

            int rows = statement.executeUpdate();

            if(rows == 0){
                System.out.println("---Produto Cadastrado---");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        ConexaoPostSQL.fecharConexao();
    }
}
