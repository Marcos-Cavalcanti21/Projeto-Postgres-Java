package SERVICE.DAO;

import MODEL.Caixa;
import MODEL.Venda;
import SERVICE.ConnectDB.ConexaoPostSQL;
import SERVICE.Get;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class CaixaDAO {
    public static void abreCaixa(){

        Connection conexao = ConexaoPostSQL.getConecta_DB();
        try{
            String sql = "SELECT ABRE_CAIXA('0,00')";
            Statement statement = conexao.createStatement();
            ResultSet results = statement.executeQuery(sql);

            System.out.println("\n\nCaixa aberto com Sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConexaoPostSQL.fecharConexao();
    }

//    public static void atualizaCaixa(){
//
//        Connection conexao = ConexaoPostSQL.getConecta_DB();
//        try{
//            String sql = "SELECT ATUALIZA_CAIXA()";
//            Statement statement = conexao.createStatement();
//            ResultSet resultSet = statement.executeQuery(sql);
//
//            System.out.println("\n\nVenda Efetuada!");
//
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//        ConexaoPostSQL.fecharConexao();
//    }

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

    public static ArrayList<Caixa> recebeCaixaDia(){
        String data;

        ArrayList<Caixa> lista = new ArrayList<>();

        System.out.println("=== Pesquisar Caixa ===");
        System.out.println("Pesquisa por Dia:");
        data = Get.data();

        Connection conexao = ConexaoPostSQL.getConecta_DB();

        try {
            String sql = "SELECT * FROM GET_CAIXA_DIA('" + data + "')";

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

            imprimirCaixa(lista);
            System.out.println("\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConexaoPostSQL.fecharConexao();
        return lista;
    }

    public static void imprimirCaixa(ArrayList<Caixa> l) {
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
                System.out.println("Total s/ Frete: " + v.getTotal());

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
