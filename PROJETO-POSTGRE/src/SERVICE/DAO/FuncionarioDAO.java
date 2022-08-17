package SERVICE.DAO;

import MODEL.Funcionario;
import SERVICE.ConnectDB.ConexaoPostSQL;
import SERVICE.Get;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FuncionarioDAO {
    public static void insereFuncionario(){
        String nome, telefone, cpf, endereco, email, cargo;

        System.out.println("Nome: ");
        nome = Get.string();

        System.out.println("Telefone: ");
        telefone = Get.string();

        System.out.println("CPF: ");
        cpf = Get.string();

        System.out.println("Endereço: ");
        endereco = Get.string();

        System.out.println("E-Mail: ");
        email = Get.string();

        System.out.println("Cargo");
        cargo = Get.string();

        Funcionario f = new Funcionario(nome, telefone, cpf, endereco, email, cargo);
        Connection conexao = ConexaoPostSQL.getConecta_DB();

        try {
            String sql = "CALL INSERT_FUNCIONARIO(?,?,?,?,?,?);";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, f.getNome());
            statement.setString(2, f.getTelefone());
            statement.setString(3, f.getCpf());
            statement.setString(4, f.getEndereco());
            statement.setString(5, f.getEmail());
            statement.setString(6, f.getCargo());

            int rows = statement.executeUpdate();

            if(rows == 0){
                System.out.println("---Funcionario Cadastrado---");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        ConexaoPostSQL.fecharConexao();
    }

    public static void recebeFuncionario(){

    }

    public static void recebeVendedores(){

    }

    public static void recebeEntregador(){

    }
}
