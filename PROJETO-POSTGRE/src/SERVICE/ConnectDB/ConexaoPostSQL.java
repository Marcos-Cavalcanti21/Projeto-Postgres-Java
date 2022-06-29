package SERVICE.ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoPostSQL {

    public static String status = "Não iniciado.";

    public ConexaoPostSQL(){}

    public static Connection getConecta_DB(){
        Connection connection = null;

        try{
            //Carregar o Driver de conexão
            String driverName = "org.postgresql.Driver";
            Class.forName(driverName);

            //DADOS DA CONEXÃO
            //String serverName = "localhost:5432";
            //String myDataBase = "nova_moda_db";
            //String url = "jdbc:postgresql://"+serverName+"/"+myDataBase;

            String serverName = "ec2-44-206-89-185.compute-1.amazonaws.com";
            String myDataBase = "dcaddc7075upvm";
            String url = "jdbc:postgresql://"+serverName+"/"+myDataBase;

        /*
        Pode acontecer que a conexão ao servidor exija porta
        porta padrão do Postgre 5432
        serverName = "localhost:5432";
         */

            //String username = "postgres";
            //String password = "1234";

            String username = "scemlhlhefnlnb";
            String password = "58f67f2977b6368edf56c3ddcdd5de17c020591bd7c6497d8cc925de0abb1a64";

            connection = DriverManager.getConnection(url,username,password);

        } catch (ClassNotFoundException e) {
            System.err.println("\n\nFalha ao carregar DRIVER PostgreSQL!\n\n");
        } catch (SQLException e) {
            System.err.println("\n\nNão foi possível conectar ao banco!");
            System.out.println(e + "\n\n");
        }
        return connection;
    }

    public static String StatusConnection(){
        return status;
    }

    public static boolean fecharConexao(){
        try{
            ConexaoPostSQL.getConecta_DB().close();
            return true;
        } catch (SQLException e) {
            System.err.println("Falha ao fechar a conexão!");
            System.out.println(e);
        }
        return false;
    }

    public static Connection ReiniciarConexao(){
        fecharConexao();

        return getConecta_DB();
    }
}

