package VIEW;

import SERVICE.CONTROLLER.CaixaController;
import SERVICE.Get;

public class Menu {
    public static void inicio(){
        while (0==0){
            System.out.println("\n\n===============================");
            System.out.println("Para iniciar Abra o caixa");
            System.out.println("===============================\n");
            System.out.println("(1)Abrir caixa");
            int selected = Get.integer();

            switch (selected){
                case 1:
                    CaixaController.abreCaixa();
                    break;
            }
        }
    }

    public static void pdv(){
        while (0==0){
            System.out.println("\n\n===============================");
            System.out.println("Menu de vendas");
            System.out.println("===============================\n");
            System.out.println("(1)Realizar venda");
            int selected = Get.integer();

            switch (selected){
                case 1:
                    venda();
                    break;
            }
        }
    }

	public static void venda(){

	}
}
