package SERVICE.DAO;

import MODEL.Caixa;
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
            String sql = "SELECT FECHA_CAIXA('0,00')";
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
                lista.add(new Caixa(
                        results.getString("inicio"),
                        results.getString("entradas"),
                        results.getString("saidas"),
                        results.getString("saldo")
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

    public static ArrayList<Caixa> recebeCaixaPeriodo(){
        String dataInicio;
        String dataFim;

        ArrayList<Caixa> lista = new ArrayList<>();

        System.out.println("=== Pesquisar Caixa ===");
        System.out.println("Data Inicial: ");
        dataInicio = Get.data();

        System.out.println("Data Final: ");
        dataFim = Get.data();

        Connection conexao = ConexaoPostSQL.getConecta_DB();

        try {
            String sql = "SELECT * FROM GET_CAIXA_PERIODO('" + dataInicio + "','" + dataFim + "')";

            Statement statement = conexao.createStatement();
            ResultSet results = statement.executeQuery(sql);

            while (results.next()) {
                lista.add(new Caixa(
                        results.getString("inicio"),
                        results.getString("entradas"),
                        results.getString("saidas"),
                        results.getString("saldo")
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
        System.out.println("\n\n=======RELATÓRIO GERAL DE CAIXA========");

        if (l.isEmpty()) {
            System.out.println("\n----------------------------------------");
            System.out.println("------- Não há Vendas no Periodo -------");
            System.out.println("----------------------------------------");
        } else {
            for (Caixa c : l) {
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("ID: " + c.getInicio());
                System.out.println("Data&Hora: " + c.getEntradas());
                System.out.println("Cliente: " + c.getSaidas());
                System.out.println("Funcionario: " + c.getSaidas());
            }
            LocalDate data = LocalDate.now();
            System.out.println("---Relatorio gerado em: " + data.getDayOfMonth() + "/" + (data.getMonthValue()) + "/" + data.getYear() + "-------");
        }
    }
}
