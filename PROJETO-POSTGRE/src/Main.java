import VIEW.Menu;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu.inicio();
    }
}
/*LOJA DE ROUPAS========================================
    -Cadastro
        -Produtos
        -Categorias (calças, saias, cropped, etc)
        -Vendedores
        -Entregadores
        -Orçamento (uma venda não confirmada, como o carrinho do site, inclusive com frete se necessário)**OPCIONAL
        -Venda ( um vendedor vende para um cliente que pode buscar na loja ou ser entregue em casa)
    -Relatórios
        -Estoque (lembro que quando chega produtos precisamos dar entrada no estoque, cada venda diminui o estoque do produto);
            *por Produto ou Categorias
        -Vendedores
        -Entregadores(total ($) de fretes do mês, número de fretes do mês)
        -Venda (por cliente, por vendedor, por entregador, por dia)
        -cliente (total $ de vendas por mês, números de compras no mês, aniversariante do mês)

================================================================================================================
 */



//        Scanner get = new Scanner(System.in);
//
//        int[] valor = { 0, 0, 0, 0};
//
//        System.out.println("N1º");
//        valor[0] = get.nextInt();
//
//        System.out.println("N2º");
//        valor[1] = get.nextInt();
//
//        System.out.println("N3º");
//        valor[2] = get.nextInt();
//
//        System.out.println("N4º");
//        valor[3] = get.nextInt();
//
//        System.out.println(Arrays.stream(valor).min());

//    }

//    public static void menu() {
//        while(0==0) {
//            System.out.println("Escolha a opção desejada");
//            System.out.println("1 - Cadastrar Aluno");
//            System.out.println("2 - Cadastrar Professor");
//            System.out.println("3 - Exibir dados do Aluno");
//            System.out.println("4 - Exibir dados do Professor");
//            System.out.println("S - SAIR");
//            op = read.nextLine();
//            switch (op) {
//                case "1": {
//                    a = new Aluno();
//                    System.out.println("Digite o nome do aluno:");
//                    String nome = read.nextLine();
//                    a.setNome(nome);
//
//                    System.out.println("Digite a idade do aluno:");
//                    String idade = read.nextLine();
//                    a.setIdade(idade);
//
//                    System.out.println("Digite o CPF do aluno:");
//                    String cpf = read.nextLine();
//                    a.setCpf(cpf);
//
//                    System.out.println("Digite a matrícula do aluno:");
//                    String matricula = read.nextLine();
//                    a.setMatricula(matricula);
//
//                    break;
//
//                }
//                case "2": {
//                    p = new Professor();
//                    System.out.println("Digite o nome do professor:");
//                    String nome = read.nextLine();
//                    p.setNome(nome);
//
//                    System.out.println("Digite a idade do professor:");
//                    String idade = read.nextLine();
//                    p.setIdade(idade);
//
//                    System.out.println("Digite o CPF do professor:");
//                    String cpf = read.nextLine();
//                    p.setCpf(cpf);
//
//                    System.out.println("Digite  a turma do professor:");
//                    String turma = read.nextLine();
//                    p.setTurma(turma);
//
//                    break;
//
//                }
//                case "3": {
//                    System.out.println("DADOS DO ALUNO");
//                    a.exibirDadosAluno();
//
//                    break;
//                }
//                case "4": {
//                    System.out.println("DADOS DO PROFESSOR");
//                    p.exibirDadosProfessor();
//
//                    break;
//                }
//                default:
//                    System.out.println("Informação incorreta");
//            }
//
//        }
//
//    }

//    public static void main(String[] args) {
//
//        Aluno a = null;
//        Professor p = null;
//
//        do {
//            menu();
//
//
//        } while (op != "S");
//    }
//}

