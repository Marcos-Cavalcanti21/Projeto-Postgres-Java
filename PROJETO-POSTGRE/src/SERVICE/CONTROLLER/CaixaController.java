package SERVICE.CONTROLLER;

import SERVICE.DAO.CaixaDAO;
import SERVICE.Get;
import VIEW.Menu;

public class CaixaController {
    public static void Caixa(){
        while (0==0){
            System.out.println("\n\n" +
                               "==========================");
            System.out.println("    Funções de Caixa");
            System.out.println("==========================\n");
            System.out.println("(1)Abrir Caixa");
            System.out.println("(2)Fechar Caixa");
            System.out.println("(3)Consultar Vendas");
            System.out.println("(0)Voltar");
            int selected = Get.integer();

            switch (selected){
                case 1:
                    CaixaDAO.abreCaixa();
                    Menu.PDV();
                    break;
                case 2:
                    CaixaDAO.fechaCaixa();
                    break;
                case 0:
                    Menu.inicio();
                    break;
                default:
                    System.out.println("Escolha uma das opções acima!");
            }
        }
    }

    public static void CaixaConsulta(){
        while (0==0){
            System.out.println("\n\n" +
                               "==========================");
            System.out.println("    Consulta de Caixa");
            System.out.println("==========================\n");
            System.out.println("(1)Caixa por Dia");
            System.out.println("(2)Caixa por Periodo");
            System.out.println("(0)Voltar");
            int selected = Get.integer();

            switch (selected){
                case 1:
                    CaixaDAO.recebeCaixaDia();
                    Menu.PDV();
                    break;
                case 2:
                    CaixaDAO.recebeCaixaPeriodo();
                    break;
                case 0:
                    Menu.consultar();
                    break;
                default:
                    System.out.println("Escolha uma das opções acima!");
            }
        }
}

