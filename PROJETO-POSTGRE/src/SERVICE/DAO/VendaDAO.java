package SERVICE.DAO;

import MODEL.Venda;
import SERVICE.ConnectDB.ConexaoPostSQL;
import SERVICE.Get;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class VendaDAO {
    public static void postVenda(){
        String cliente, funcionario, produto, entregador = "vázio";
        float frete = 0;
        boolean entrega = false;
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
                    frete = Get.Float();

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
        Venda v = new Venda(cliente, funcionario, produto, qtd, entrega, entregador, frete);
        Connection conexao = ConexaoPostSQL.getConecta_DB();

        try {
            String sql = "CALL POST_VENDA(?,?,?,?,?,?,?);";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, v.getCliente());
            statement.setString(2, v.getFuncionario());
            statement.setString(3, v.getProduto());
            statement.setInt(4, v.getQtd());
            statement.setBoolean(5, v.isEntrega());
            statement.setFloat(6, v.getFrete());
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

    public static ArrayList<Venda> recebeVendasId(){
        int idVenda;


        ArrayList<Venda> lista = new ArrayList<>();

        System.out.println("=== Pesquisar Venda ID ===");
        System.out.println("Pesquisa por ID:");
        idVenda = Get.integer();

        Connection conexao = ConexaoPostSQL.getConecta_DB();

        try {
            String sql = "SELECT * FROM GET_VENDA_ID('" + idVenda + "')";

            Statement statement = conexao.createStatement();
            ResultSet results = statement.executeQuery(sql);

            while (results.next()) {
                lista.add(new Venda(
                     results.getInt("id"),
                     results.getDate("dataHora"),
                     results.getString("cliente"),
                     results.getString("funcionario"),
                     results.getInt("idProduto"),
                     results.getString("produto"),
                     results.getInt("qtd"),
                     results.getString("total"),
                     results.getBoolean("entrega"),
                     results.getString("entregador"),
                     results.getFloat("frete")

                ));
            }

            imprimirVenda(lista);
            System.out.println("\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConexaoPostSQL.fecharConexao();
        return lista;
    }

    public static ArrayList<Venda> recebeVendasDia(){

        String dataInicio, dataFim;

        ArrayList<Venda> lista = new ArrayList<>();

        System.out.println("=== Pesquisar Venda Data ===");

        System.out.println("Pesquisa por Data Inicial: ");
        dataInicio = Get.data();

        System.out.println("Pesquisar por Data Final: ");
        dataFim = Get.data();

        Connection conexao = ConexaoPostSQL.getConecta_DB();

        try {
            String sql = "SELECT * FROM GET_VENDA_DATA('"
                    + dataInicio + "','"
                    + dataFim + "')";

            Statement statement = conexao.createStatement();
            ResultSet results = statement.executeQuery(sql);

            while (results.next()) {
                lista.add(new Venda(
                        results.getInt("id"),
                        results.getDate("dataHora"),
                        results.getString("cliente"),
                        results.getString("funcionario"),
                        results.getInt("idProduto"),
                        results.getString("produto"),
                        results.getInt("qtd"),
                        results.getString("total"),
                        results.getBoolean("entrega"),
                        results.getString("entregador"),
                        results.getFloat("frete")
                    ));
            }

            imprimirVenda(lista);
            System.out.println("\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConexaoPostSQL.fecharConexao();
        return lista;
    }

    public static ArrayList<Venda> recebeVendasNome(){

        String cliente, funcionario;

        ArrayList<Venda> lista = new ArrayList<>();

        System.out.println("=== Pesquisar Venda Nome ===");

        System.out.println("Pesquisar por Cliente: ");
        cliente = Get.string();

        System.out.println("Pesquisar por Funcionario: ");
        funcionario = Get.string();

        Connection conexao = ConexaoPostSQL.getConecta_DB();

        try {
            String sql = "SELECT * FROM GET_VENDA_NOME('"
                    + cliente + "','"
                    + funcionario + "')";

            Statement statement = conexao.createStatement();
            ResultSet results = statement.executeQuery(sql);

            while (results.next()) {
                lista.add(new Venda(
                        results.getInt("id"),
                        results.getDate("dataHora"),
                        results.getString("cliente"),
                        results.getString("funcionario"),
                        results.getInt("idProduto"),
                        results.getString("produto"),
                        results.getInt("qtd"),
                        results.getString("total"),
                        results.getBoolean("entrega"),
                        results.getString("entregador"),
                        results.getFloat("frete")
                ));
            }

            imprimirVenda(lista);
            System.out.println("\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConexaoPostSQL.fecharConexao();
        return lista;
    }

    public static void imprimirVenda(ArrayList<Venda> l) {
        System.out.println("\n\n=======RELATÓRIO GERAL DE PRODUTOS========");

        if (l.isEmpty()) {
            System.out.println("\n----------------------------------------");
            System.out.println("------- Não há vendas no Sistema -------");
            System.out.println("----------------------------------------");
        } else {
            for (Venda v : l) {
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("ID: " + v.getId());
                System.out.println("Data&Hora: " + v.getDataHora());
                System.out.println("Cliente: " + v.getCliente());
                System.out.println("Funcionario: " + v.getFuncionario());
                System.out.println("Id do Produto: " + v.getIdProduto());
                System.out.println("Produto: " + v.getProduto());
                System.out.println("Qtd: " + v.getQtd());
                System.out.println("Total c/ Frete: " + v.getTotal());

                if (v.isEntrega() == true){ System.out.println("Entrega: Sim");}
                else {System.out.println("Entrega: Não");}

                System.out.println("Frete: " + v.getFrete());
                System.out.println("Entregador: " + v.getEntregador());
            }
            LocalDate data = LocalDate.now();
            System.out.println("---Relatorio gerado em: " + data.getDayOfMonth() + "/" + (data.getMonthValue()) + "/" + data.getYear() + "-------");
        }
    }
}
