package SERVICE.DAO;

import MODEL.Produto;
import SERVICE.ConnectDB.ConexaoPostSQL;
import SERVICE.Get;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProdutoDAO {
    public static void insereProduto() {
        String nome, categoria, preco;

        System.out.println("Nome: ");
        nome = Get.string();

        System.out.println("Categoria: ");
        categoria = Get.string();

        System.out.println("Preço: ");
        preco = String.valueOf(Get.money());

        Produto p = new Produto(nome, categoria, preco);
        Connection conexao = ConexaoPostSQL.getConecta_DB();

        try {
            String sql = "CALL INSERT_PRODUTO(?,?,'" + p.getPreco() + "');";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, p.getNome());
            statement.setString(2, p.getCategoria());
            //statement.setString(3, "'"+ p.getPreco() +"'");

            int rows = statement.executeUpdate();

            if (rows == 0) {
                System.out.println("---Produto Cadastrado---");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConexaoPostSQL.fecharConexao();
    }

    public static ArrayList<Produto> recebeProduto() {
        String nome;
        ArrayList<Produto> lista = new ArrayList<>();

        System.out.println("Pesquisar Produto: ");
        nome = Get.string();

        Connection conexao = ConexaoPostSQL.getConecta_DB();
        try {
            String sql = "SELECT * FROM GET_PRODUTO('" + nome + "')";
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

    public static void recebeCategoria() {

        Connection conexao = ConexaoPostSQL.getConecta_DB();
        try {
            String sql = "";
            Statement statement = conexao.createStatement();
            ResultSet results = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConexaoPostSQL.fecharConexao();
    }

    public static void recebeEstoque() {

        Connection conexao = ConexaoPostSQL.getConecta_DB();
        try {
            String sql = "";
            Statement statement = conexao.createStatement();
            ResultSet results = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConexaoPostSQL.fecharConexao();
    }


    public static void imprimirProduto(ArrayList<Produto> l) {
        System.out.println("\n\n=======RELATÓRIO GERAL DE PRODUTOS========");

        if (l.isEmpty()) {
            System.out.println("\n----------------------------------------");
            System.out.println("----- Não há Produtos cadastrados ------");
            System.out.println("----------------------------------------");
        } else {
            for (Produto p : l) {
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("ID: " + p.getId());
                System.out.println("Nome: " + p.getNome());
                System.out.println("Categoria: " + p.getCategoria());
                System.out.println("Vendas: " + p.getVendas());
                System.out.println("Estoque: " + p.getEstoque());
                System.out.println("Preço: " + p.getPreco());
            }
            LocalDate data = LocalDate.now();
            System.out.println("---Relatorio gerado em: " + data.getDayOfMonth() + "/" + (data.getMonthValue()) + "/" + data.getYear() + "-------");
        }
    }
}
