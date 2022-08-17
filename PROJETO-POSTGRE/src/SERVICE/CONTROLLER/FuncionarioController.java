package SERVICE.CONTROLLER;

import SERVICE.DAO.FuncionarioDAO;
import SERVICE.Get;
import VIEW.Menu;

public class FuncionarioController {
    public static void insereFuncionarioController(){ FuncionarioDAO.insereFuncionario(); }
    public static void recebeFuncionarioController(){
        while (0==0){
            System.out.println("(1)Funcionarios");
            System.out.println("(2)Vendedores");
            System.out.println("(3)Entregadores");
            System.out.println("(0)Voltar");
            int selected = Get.integer();

            switch (selected){
                case 1:
                    FuncionarioDAO.recebeFuncionario();
                    break;
                case 2:
                    FuncionarioDAO.recebeVendedores();
                    break;
                case 3:
                    FuncionarioDAO.recebeEntregador();
                    break;
                case 0:
                    Menu.consultar();
                    break;
                default:
                    System.out.println("Escolha uma das opções acima!");
            }

        }
    }
}
