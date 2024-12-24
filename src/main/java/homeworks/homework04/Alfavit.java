package homeworks.homework04;

import java.util.Scanner;

    public class Alfavit {
        public static void main(String[] args) {
            String alphabet = "qwertyuiopasdfghjklzxcvbnm";
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите маленькую букву английского алфавита: ");
            char inputChar = scanner.next().charAt(0);

            // маленькая буква
            if (alphabet.indexOf(inputChar) == -1) {
                System.out.println("введите маленькую букву английского алфавита.");
            } else {
                int index = alphabet.indexOf(inputChar);
                // замкнутость
                int leftIndex = (index - 1 + alphabet.length()) % alphabet.length();
                // Получаем букву слева
                char leftChar = alphabet.charAt(leftIndex);
                System.out.println("Буква слева: " + leftChar);
            }
        }
    }
    
