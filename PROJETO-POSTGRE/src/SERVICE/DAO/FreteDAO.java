package SERVICE.DAO;

import MODEL.Frete;
import SERVICE.ConnectDB.ConexaoPostSQL;
import SERVICE.Get;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FreteDAO {
    public static void insereFrete(){
            float distancia;
            String preco;

            System.out.println("Categoria: ");
            distancia = Get.Float();

            System.out.println("Preço: ");
            preco = String.valueOf(Get.money());

            Frete f = new Frete (distancia, preco);
            Connection conexao = ConexaoPostSQL.getConecta_DB();

            try {
                String sql = "CALL INSERT_PRODUTO(?,'" + f.getValor() + "');";
                PreparedStatement statement = conexao.prepareStatement(sql);
                statement.setFloat(1, f.getDistancia());

                int rows = statement.executeUpdate();

                if (rows == 0) {
                    System.out.println("\n---Frete Cadastrado---");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ConexaoPostSQL.fecharConexao();
    }
}
