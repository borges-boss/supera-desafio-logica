package desafio3;
import java.util.Scanner;
import java.util.Random;

public class DesafioTres {
    public void acharPares() {

        try {
            int paresCount = 0;
            int k = 0;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite o valor alvo: ");
            k = scanner.nextInt();

            int n = 0;
            System.out.println("Digite o tamanho de n: ");
            n = scanner.nextInt();
            int[] arr = new int[n];

            Random rand = new Random();
            for(int i = 0; i < arr.length;i++) {
               arr[i] = rand.nextInt((10 - 1) + 1) + 1;
            }

            for(int j = 0; j < arr.length;j++) {
                for(int x = j + 1; x < arr.length;x++) {
                    if(arr[j] - arr[x] == k) {
                        paresCount++;
                    }

                    if(arr[x] - arr[j] == k) {
                        paresCount++;
                    }
                }
            }

            System.out.println(paresCount);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
