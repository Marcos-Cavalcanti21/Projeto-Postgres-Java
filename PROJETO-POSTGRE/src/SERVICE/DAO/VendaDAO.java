package SERVICE.DAO;

import SERVICE.Get;

public class VendaDAO {
    public static void postVenda(){
        String cliente, funcionario, produto, entregador;
        boolean entrega;
        double frete;
        int qtd, O = 0;


        System.out.println("Cliente(Opicional): ");
        cliente = Get.string();

        System.out.println("Funcionario(Opcional): ");
        funcionario = Get.string();

        System.out.println("Produto: ");
        produto = Get.string();

        System.out.println("Quantidade: ");
        qtd = Get.integer();

        while (0==O){
        System.out.println("Entregar? " +
                "\n(1)Sim (2)Não");
        int op = Get.integer();

        switch (op) {
            case 1:
                entrega = true;
                System.out.println("Distancia: ");
                frete = Get.decimal();

                System.out.println("Entregador: ");
                entregador = Get.string();
                O = 1;
                break;
            case 2:
                entrega = false;
                O = 1;
                break;
            default:
                System.out.println("Opção invalida");
                break;
        }
        }
    }
}
