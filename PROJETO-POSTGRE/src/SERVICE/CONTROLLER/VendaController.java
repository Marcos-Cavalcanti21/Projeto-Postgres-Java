package SERVICE.CONTROLLER;

import SERVICE.DAO.VendaDAO;
import SERVICE.Get;
import VIEW.Menu;

public class VendaController {
    public static void postVendaController(){ VendaDAO.postVenda(); }

    public static void recebeVendaController(){
//        VendaDAO.recebeVenda();
        while (0==0){
            System.out.println("(1)Vendas");
            System.out.println("(2)Caixa por Dia");
            System.out.println("(3)Caixa Até");
            System.out.println("(0)Voltar");
            int selected = Get.integer();

            switch (selected){
                case 1:
                    VendaDAO.recebeVendas();
                    break;
                case 2:
                    VendaDAO.recebeCaixaDia();
                    break;
                case 3:
                    VendaDAO.recebeCaixaAte();
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
