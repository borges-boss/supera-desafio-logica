package desafio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Consumer;

public class DesafioUm {

    private List<Integer> numeros;

    public DesafioUm() {
        numeros = new ArrayList<>();
    }

    public void exec() {
        lerEntrada();
        ordenarNumeros();
    }

    private void lerEntrada() {
        try {
            //Ler o nome do arquivo de entrada
            String nomeArquivo;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o caminho para o arquivo de entrada (ex: C:\\test.txt):");
            nomeArquivo = scanner.nextLine();
            //Ler arquivo de entrada
            File file = new File(nomeArquivo);
            Scanner fileReader = new Scanner(file);

            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                numeros.add(Integer.valueOf(data.trim()));
            }

            fileReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado");
            e.printStackTrace();
        }
        catch (NumberFormatException ne) {
            System.out.println("O arquivo de entrada deve conter apenas numeros");
            ne.printStackTrace();
        }
    }

    private void ordenarNumeros() {
        try {
            List<Integer> pares = new ArrayList<>();
            List<Integer> impares = new ArrayList<>();
            int numIntIndex = numeros.get(0);
            numeros.remove(0);
            numeros = numeros.subList(0,numIntIndex);

            pares = numeros.stream().filter(integer -> (integer % 2 == 0)).toList();
            impares = numeros.stream().filter(integer -> (integer % 2 != 0)).toList();

            pares = pares.stream().sorted().toList();
            impares = impares.stream().sorted(Collections.reverseOrder()).toList();

            numeros.clear();
            pares.forEach(System.out::println);
            impares.forEach(System.out::println);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
