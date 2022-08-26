package SERVICE.CONTROLLER;

import SERVICE.DAO.VendaDAO;
import SERVICE.Get;
import VIEW.Menu;

public class VendaController {
    public static void postVenda(){ VendaDAO.postVenda(); }

    public static void recebeVenda(){
//        VendaDAO.recebeVenda();
        while (0==0){
            System.out.println("(1)Vendas por ID");
            System.out.println("(2)Vendas por Dia");
            System.out.println("(3)Vendas por Nome");
            System.out.println("(0)Voltar");
            int selected = Get.integer();

            switch (selected){
                case 1:
                    VendaDAO.recebeVendasId();
                    break;
                case 2:
                    VendaDAO.recebeVendasDia();
                    break;
                case 3:
                    VendaDAO.recebeVendasNome();
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
