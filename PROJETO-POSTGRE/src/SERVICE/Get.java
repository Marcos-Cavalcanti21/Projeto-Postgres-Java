package SERVICE;

import org.postgresql.util.PGmoney;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Get {
    public static PGmoney money() {
        String valor = "";

        Scanner get = new Scanner(System.in);

        while (true) {
            try {
                valor = "$" + get.nextDouble();
                break;
            } catch (InputMismatchException e){
                System.out.println("\n\nApenas números");
                System.out.println("Não use ponto, apenas 'virgula' para casas decimais.");
                System.out.println("Ex: 99999,35");
                System.out.println("Tente Novamente: ");
                get.nextLine();
            }
        }
        try {
            return new PGmoney(valor);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static int integer() {
        int valor = 0;
        Scanner get = new Scanner(System.in);

        while (true) {
            try {
                valor = get.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.err.println("\n\nApenas números inteiros");
                System.out.println("Não use pontos ou vírgulas.");
                System.out.println("Tente novamente: ");
                get.nextLine();
            }
        }
        return valor;
    }

    public static double decimal(){
        double valor = 0;
        Scanner get = new Scanner(System.in);

        while (true){
            try{
                valor = get.nextDouble();
                break;
            }catch (InputMismatchException e){
                System.out.println("\n\nApenas números");
                System.out.println("Não use ponto, apenas 'virgula' para casas decimais.");
                System.out.println("Ex: 99999,35");
                System.out.println("Tente Novamente: ");
                get.nextLine();
            }
        }
        return valor;
    }

    public static float Float(){
        float valor = 0;
        Scanner get = new Scanner(System.in);

        while (true){
            try{
                valor = get.nextFloat();
                break;
            }catch (InputMismatchException e){
                System.out.println("\n\nApenas números");
                System.out.println("Não use ponto, apenas 'virgula' para casas decimais.");
                System.out.println("Ex: 99999,35");
                System.out.println("Tente Novamente: ");
                get.nextLine();
            }
        }
        return valor;
    }

    public static String string(){
        Scanner get = new Scanner(System.in);

        return get.nextLine().toLowerCase();

    }

    public static String data(){

        String date;
        Date data;

        Scanner get = new Scanner(System.in);

        while (true){
            try{
                date = get.nextLine();
                String pattern = "MM-dd-yyyy";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                data = simpleDateFormat.parse(date);
                System.out.println(data);
                break;
            }catch (InputMismatchException e){
                System.out.println("\n\nApenas números e traços");
                System.out.println("Não use barra, apenas 'hiffen' para separar datas.");
                System.out.println("Ex: 01-12-2018");
                System.out.println("Tente Novamente: ");
                //get.nextLine();
            } catch (ParseException e) {

                System.out.println("\n\nApenas números e traços");
                System.out.println("Não use barra, apenas 'hiffen' para separar datas.");
                System.out.println("Ex: 01-12-2018");
                System.out.println("Tente Novamente: ");
                //get.nextLine();

            } catch (RuntimeException e){

                System.out.println("\n\nApenas números e traços");
                System.out.println("Não use barra, apenas 'hiffen' para separar datas.");
                System.out.println("Ex: 01-12-2018");
                System.out.println("Tente Novamente: ");
                //get.nextLine();

            }
        }
        return date;
    }

//    public static Date data(){
//
//        String date;
//        Date data;
//
//        Scanner get = new Scanner(System.in);
//
//        while (true){
//            try{
//                date = get.nextLine();
//                String pattern = "MM-dd-yyyy";
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//                data = simpleDateFormat.parse(date);
//                System.out.println(data);
//                break;
//            }catch (InputMismatchException e){
//                System.out.println("\n\nApenas números e traços");
//                System.out.println("Não use barra, apenas 'hiffen' para separar datas.");
//                System.out.println("Ex: 01-12-2018");
//                System.out.println("Tente Novamente: ");
//                get.nextLine();
//            }
//        }
//        return data;
//    }
}
