package desafio2;
import java.util.Scanner;

public class DesafioDois {

    public void decompor() {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o valor monetário: ");
        double valor = input.nextDouble();

        int[] notas = { 100, 50, 20, 10, 5, 2 };
        double[] moedas = { 1, 0.5, 0.25, 0.1, 0.05, 0.01 };

        System.out.println("Notas:");

        for (int i = 0; i < notas.length; i++) {
            int quantidadeNotas = (int) (valor / notas[i]);
            valor %= notas[i];
            System.out.println(quantidadeNotas + " nota(s) de " + notas[i]);
        }

        System.out.println("Moedas:");

        for (int i = 0; i < moedas.length; i++) {
            int quantidadeMoedas = (int) (valor / moedas[i]);
            valor %= moedas[i];
            System.out.println(quantidadeMoedas + " moeda(s) de " + moedas[i]);
        }

        input.close();
    }

}
