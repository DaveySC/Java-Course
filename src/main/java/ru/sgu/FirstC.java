package main.java.ru.sgu;

import java.io.*;
import java.util.concurrent.ExecutionException;

public class FirstC {
    private static final String ANSWER_TO_WRONG_INPUT = "...есть разные варианты...\n";
    public static void solve(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {

            br = new BufferedReader(new FileReader("src/main/java/ru/sgu/resources/input.txt"));
            bw = new BufferedWriter(new FileWriter("src/main/java/ru/sgu/resources/output.txt"));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                bw.write(getShortName(words));
            }
        } catch (Exception e) {
            System.out.println("WRONG DATA FORMAT!");
        } finally {
            try {
                br.close();
                bw.close();
            } catch (NullPointerException e){
                System.exit(1);
            } catch (IOException e) {
                System.out.println("ERROR WHILE CLOSING FILES");
            }
        }
    }

    static String getShortName(String[] words) {
        if (words.length < 3) return ANSWER_TO_WRONG_INPUT;
        if (isCorrectWord(words[0])
                && isCorrectWord(words[1])
                && isCorrectWord(words[2])) {
            return new StringBuilder()
                    .append(words[1])
                    .append(" ")
                    .append(words[0].charAt(0))
                    .append(". ")
                    .append(words[2].charAt(0))
                    .append(". \n").toString();
        }
        return ANSWER_TO_WRONG_INPUT;
    }

    public static boolean isCorrectWord(String word) {
        return word.matches("[a-яA-Я]+");
    }
}
