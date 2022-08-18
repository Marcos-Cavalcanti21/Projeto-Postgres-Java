package SERVICE.CONTROLLER;

import SERVICE.DAO.ProdutoDAO;
import SERVICE.Get;
import VIEW.Menu;

public class ProdutoController {
    public static void insereProduto(){ ProdutoDAO.insereProduto(); }

    public static void recebeProduto(){
        while (0==0){
            System.out.println("===== Consultar Produto =====");
            System.out.println("(1)Produto");
            System.out.println("(2)Categoria");
            System.out.println("(3)Estoque");
            System.out.println("(0)Voltar");
            int selected = Get.integer();

            switch (0==0){
                case 1:
                    ProdutoDAO.recebeProduto();
                    break;
                case 2:
                    ProdutoDAO.recebeCategoria();
                    break;
                case 3:
                    ProdutoDAO.recebeEstoque();
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
