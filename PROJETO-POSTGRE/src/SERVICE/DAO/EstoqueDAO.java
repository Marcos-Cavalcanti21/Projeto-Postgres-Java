package SERVICE.DAO;

import MODEL.Estoque;
import SERVICE.ConnectDB.ConexaoPostSQL;
import SERVICE.Get;
import jdk.jshell.spi.SPIResolutionException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EstoqueDAO {
    public static void insereEstoque(){

        String produto;
        int qtd;

        System.out.println("Produto: ");
        produto = Get.string();

        System.out.println("Entrada de Estoque: ");
        qtd = Get.integer();

        Estoque e = new Estoque(produto, qtd);
        Connection conexao = ConexaoPostSQL.getConecta_DB();

        try{
            String sql = "CALL INSERT_ESTOQUE(?,?);";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, e.getProduto());
            statement.setInt(2, e.getQtd());

            int rows = statement.executeUpdate();

            if(rows == 0){
                System.out.println("--- Estoque adicionado com Sucesso!! ---");
            }

        }catch (SQLException trows){
            trows.printStackTrace();
        }
        ConexaoPostSQL.fecharConexao();

    }
}
