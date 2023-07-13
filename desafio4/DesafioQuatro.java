package desafio4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class DesafioQuatro {

    List<String> words;

    public DesafioQuatro() {
        words = new ArrayList<>();
    }


    public void exec(){
        lerEntrada();
        if(words.size() > 0)
            decifrar();
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
                words.add(data);
            }

            fileReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado");
            e.printStackTrace();
        }
    }

    public void decifrar() {
        String firstHalf;
        String secondHalf;
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder(new String());

        try {
            int numIntIndex = Integer.parseInt(words.get(0));
            words.remove(0);
            words = words.subList(0,numIntIndex);

            for(int i = 0; i < words.size();i++) {
                firstHalf = words.get(i).substring(0,Math.round((float) words.get(i).length() / 2));
                sb.append(firstHalf);
                result.append(sb.reverse());
                sb.delete(0,firstHalf.length());

                secondHalf = words.get(i).substring(Math.round((float) words.get(i).length() / 2),words.get(i).length());
                sb.append(secondHalf);
                result.append(sb.reverse());
                sb.delete(0,secondHalf.length());

                words.set(i,result.toString());
                result.delete(0,result.length());
            }

            words.forEach(System.out::println);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
