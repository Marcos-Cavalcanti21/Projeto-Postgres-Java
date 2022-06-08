package SERVICE.DAO;

import MODEL.Venda;
import SERVICE.ConnectDB.ConexaoPostSQL;
import SERVICE.Get;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VendaDAO {
    public static void postVenda(){
        String cliente, funcionario, produto, entregador = "vázio";
        boolean entrega = false;
        double frete = 0;
        int qtd, O = 0;


        System.out.println("Cliente(Opicional): ");
        cliente = Get.string();

        System.out.println("Funcionario(Opcional): ");
        funcionario = Get.string();

        System.out.println("Produto: ");
        produto = Get.string();

        System.out.println("Quantidade: ");
        qtd = Get.integer();

        while (0==O){
        System.out.println("Entregar? " +
                "\n(1)Sim (2)Não");
        int op = Get.integer();

            switch (op) {
                case 1:
                    entrega = true;
                    System.out.println("Distancia: ");
                    frete = Get.decimal();

                    System.out.println("Entregador: ");
                    entregador = Get.string();
                    O = 1;
                    break;
                case 2:
                    entrega = false;
                    O = 1;
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;
            }
        }
        Venda v = new Venda(cliente, funcionario,produto,qtd, entrega, frete, entregador);
        Connection conexao = ConexaoPostSQL.getConecta_DB();

        try {
            String sql = "CALL POST_VENDA(?,?,?,?,?,?,?);";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, v.getCliente());
            statement.setString(2, v.getFuncionario());
            statement.setString(3, v.getProduto());
            statement.setInt(4, v.getQtd());
            statement.setBoolean(5, v.isEntrega());
            statement.setDouble(6, v.getFrete());
            statement.setString(7, v.getEntregador());

            int rows = statement.executeUpdate();

            if(rows == 0){
                System.out.println("---Venda Finalizada---");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        ConexaoPostSQL.fecharConexao();
    }
}
