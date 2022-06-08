package SERVICE.DAO;

import MODEL.Cliente;
import SERVICE.ConnectDB.ConexaoPostSQL;
import SERVICE.Get;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {
    public static void insereCliente(){
        String nome, telefone, endereco, email, cpf;

        System.out.println("Nome: ");
        nome = Get.string();

        System.out.println("Telefone: ");
        telefone = Get.string();

        System.out.println("Endereço: ");
        endereco = Get.string();

        System.out.println("E-Mail: ");
        email = Get.string();

        System.out.println("CPF: ");
        cpf = Get.string();

        Cliente c = new Cliente(0, nome, telefone, endereco, email, cpf);
        Connection conexao = ConexaoPostSQL.getConecta_DB();

        try {
            String sql = "CALL INSERT_CLIENTE(?,?,?,?,?);";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, c.getNome());
            statement.setString(2, c.getTelefone());
            statement.setString(3, c.getEndereco());
            statement.setString(4, c.getEmail());
            statement.setString(5, c.getCpf());

            int rows = statement.executeUpdate();

            if(rows == 0){
                System.out.println("---Cliente Cadastrado---");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        ConexaoPostSQL.fecharConexao();
    }

}
