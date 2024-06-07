import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while(option != 9){
            System.out.println("""
                    \n*******************************************
                    Selecione a opção que deseja converter:
                    \n1 -> Converter Reais em Pesos Argentinos.
                    2 -> Converter Pesos Argentinos em Reais.
                    3 -> Converter Reais em Dólar Americano
                    4 -> Converter Dólar Americano em Reais
                    5 -> Converter Reais em Rupia Indiana
                    6 -> Converter Reais em Dólar Canadense
                    7 -> Converter Reais em Libra Esterlina
                    8 -> Converter Euros em Reais
                    9 -> Sair do programa.               \s
                    \n*******************************************""");
            option = scanner.nextInt();
            if (option == 9){
                break;
            }
            System.out.println("Digite o valor a ser convertido: ");
            double amount = scanner.nextDouble();

            try {
                String iso1 = "";
                String iso2 = "";
                PairConvertion pairConvertion = new PairConvertion();
                switch (option){
                    case 1:
                        iso1 = "BRL";
                        iso2 = "ARS";
                        break;

                    case 2:
                        iso1 = "ARS";
                        iso2 = "BRL";
                        break;

                    case 3:
                        iso1 = "BRL";
                        iso2 = "US";
                        break;

                    case 4:
                    iso1 = "USD";
                    iso2 = "BRL";
                    break;

                    case 5:
                        iso1 = "BRL";
                        iso2 = "INR";
                        break;

                    case 6:
                        iso1 = "BRL";
                        iso2 = "CAD";
                        break;

                    case 7:
                        iso1 = "BRL";
                        iso2 = "GBP";
                        break;

                    case 8:
                        iso1 = "EUR";
                        iso2 = "BRL";
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        continue;
                }
                pairConvertion.convertePair(iso1, iso2, amount);
            } catch (IOException | InterruptedException e){
                e.printStackTrace();
            }
        }
        scanner.close();
    }
}
