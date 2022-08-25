package SERVICE.DAO;

import MODEL.Produto;
import MODEL.Venda;
import SERVICE.ConnectDB.ConexaoPostSQL;
import SERVICE.Get;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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

    public static void recebeVendas(){
        int idVenda;
        SimpleDateFormat dataInicio, dataFim;
        String cliente, funcionario;

        ArrayList<Venda> lista = new ArrayList<>();

        System.out.println("=== Pesquisar Venda ===");
        System.out.println("Pesquisa por ID:");
        idVenda = Get.integer();

        System.out.println("Pesquisa por Data Inicial");
        dataInicio = Get.string();

        System.out.println("Pesquisar Venda: ");
        nome = Get.string();

        Connection conexao = ConexaoPostSQL.getConecta_DB();
        try {
            String sql = "SELECT * FROM GET_VENDA('" + nome + "')";
            Statement statement = conexao.createStatement();
            ResultSet results = statement.executeQuery(sql);

            while (results.next()) {
                lista.add(new Produto(
                        results.getInt("id"),
                        results.getString("nome"),
                        results.getString("categoriaid"),
                        results.getInt("vendas"),
                        results.getInt("estoque"),
                        results.getString("preco")

                ));
            }

            imprimirProduto(lista);
            System.out.println("\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConexaoPostSQL.fecharConexao();
        return lista;
    }

    public static void recebeCaixaDia(){

    }

    public static void recebeCaixaAte(){

    }
}
