package VIEW;

import SERVICE.CONTROLLER.*;
import SERVICE.DAO.CategoriaDAO;
import SERVICE.DAO.EstoqueDAO;
import SERVICE.DAO.ProdutoDAO;
import SERVICE.Get;
import org.w3c.dom.ls.LSOutput;

public class Menu {
    public static void inicio(){
        while (0==0){
            System.out.println("\n\n" +
                               "===============================");
            System.out.println("   Para iniciar Abra o caixa");
            System.out.println("===============================\n");
            System.out.println("(1)Caixa");
            System.out.println("(2)Cadastrar");
            System.out.println("(3)Consultar");
            int selected = Get.integer();

            switch (selected){
                case 1:
                    CaixaController.Caixa();
                    break;
                case 2:
                   cadastrar();
                   break;
                case 3:
                    consultar();
                    break;
                case 4:
                    PDV();
            }
        }
    }

    public static void PDV(){
        while (0==0){
            System.out.println("\n\n" +
                               "===============================");
            System.out.println("        Menu de vendas");
            System.out.println("===============================\n");
            System.out.println("(1)Realizar venda");
            System.out.println("(2)Fechar Caixa");
            System.out.println("(3)Voltar");

            int selected = Get.integer();

            switch (selected){
                case 1:
                    VendaController.postVendaController();
                    break;

            }
        }
    }

    public static void cadastrar(){
        while (0==0){
            System.out.println("\n\n" +
                               "============================");
            System.out.println("     Menu de Cadastros");
            System.out.println("============================\n");
            System.out.println("(1)Cargo");
            System.out.println("(2)Categoria");
            System.out.println("(3)Cliente");
            System.out.println("(4)Estoque");
            System.out.println("(5)Funcionario");
            System.out.println("(6)Produto");
            System.out.println("(0)Voltar");

            int selected = Get.integer();

            switch (selected){
                case 1:
                    CargoController.InsereCargoController();
                    break;
                case 2:
                    CategoriaController.insereCategoriaController();
                    break;
                case 3:
                    ClienteController.insereClienteController();
                    break;
                case 4:
                    EstoqueController.insereEstoqueController();
                    break;
                case 5:
                    FuncionarioController.insereFuncionarioController();
                    break;
                case 6:
                    ProdutoController.insereProdutoController();
                    break;
            }

        }
    }
    public static void consultar(){

    }

	public static void venda(){

	}
}
