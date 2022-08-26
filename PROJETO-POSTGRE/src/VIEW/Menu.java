package VIEW;

import SERVICE.CONTROLLER.*;
import SERVICE.DAO.CaixaDAO;
import SERVICE.Get;

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
                    break;
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
            System.out.println("(0)Voltar");

            int selected = Get.integer();

            switch (selected){
                case 1:
                    VendaController.postVenda();
                    break;
                case 2:
                    CaixaDAO.fechaCaixa();
                    break;
                case 0:
                    CaixaController.Caixa();
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
                    CargoController.InsereCargo();
                    break;
                case 2:
                    CategoriaController.insereCategoria();
                    break;
                case 3:
                    ClienteController.insereCliente();
                    break;
                case 4:
                    EstoqueController.insereEstoque();
                    break;
                case 5:
                    FuncionarioController.insereFuncionario();
                    break;
                case 6:
                    ProdutoController.insereProduto();
                    break;
                case 0:
                    inicio();
                    break;
            }

        }
    }
    public static void consultar(){
        while (0==0){
            System.out.println("======== Consultas =========");
            System.out.println("(1)Estoque");
            System.out.println("(2)Categoria");
            System.out.println("(3)Funcionarios");
            System.out.println("(4)Cargo");
            System.out.println("(5)Produto");
            System.out.println("(6)Cliente");
            System.out.println("(7)Vendas");
            System.out.println("(0)Voltar");
            int selected = Get.integer();

            switch (selected){
                case 1:
                    //EstoqueController.recebeEstoque();
                    break;
                case 2:
                    //CategoriaController.recebeEstoque();
                    break;
                case 3:
                    FuncionarioController.recebeFuncionario();
                    break;
                case 4:
                    //CargoController.recebeCargo();
                    break;
                case 5:
                    ProdutoController.recebeProduto();
                    break;
                case 6:
                    //ClienteController.recebeCliente();
                    break;
                case 7:
                    VendaController.recebeVenda();
                    break;
                case 0:
                    inicio();
                    break;
                default:
                    System.out.println("Escolha uma das opções acima!");
            }
        }

    }

	public static void venda(){

	}
}
