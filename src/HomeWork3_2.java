import java.util.Random;
import java.util.Scanner;

/**
 * Создать массив из слов
 * String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
 * "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
 * "pear", "pepper", "pineapple", "pumpkin", "potato"}.
 * При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с загаданным
 * словом и сообщает, правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
 * apple – загаданное
 * apricot - ответ игрока
 * ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
 * Для сравнения двух слов посимвольно можно пользоваться:
 * String str = "apple";
 * char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
 * Играем до тех пор, пока игрок не отгадает слово.
 * Используем только маленькие буквы.
 */

public class HomeWork3_2 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] words = new String[]{"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        String word = choiseAWord(words);
        System.out.println("Ваша задача угадать слово");
        do {
            System.out.println("Угадайте слово");
            if (!guessTheWord(word)) {
                System.out.println("Поздравляем! Вы угадали загаданное слово: " + word);
                break;
            }
        } while (true);
    }

    /**
     * Метод случайным образом выбирает строку из массива
     * @param words массив строк
     * @return элемент масива words
     */
    private static String choiseAWord(String[] words) {
        int elementOfArray = new Random().nextInt(words.length - 1);

        System.out.println(words[elementOfArray]);
        return words[elementOfArray];
    }

    /**
     * Метод определяет угадано ли слово пользователем
     * @param word загараднное слово
     * @return true если слово не угадано
     */
    private static boolean guessTheWord(String word) {

        String inputWord = (scanner.nextLine()).toLowerCase();
        if (inputWord.equals(word)) {
            return false;
        } else {
            String guessedLetters = "";
            for (int i = 0; i < Math.min(word.length(), inputWord.length()); i++) {
                //переменная для посимвольного сравнения загадонного слова
                char a = word.charAt(i);
                //переменная для посимвольного сравнения слова, который ввел пользователь
                char b = inputWord.charAt(i);
                if (a == b) {
                    guessedLetters = guessedLetters + a;
                } else {
                    guessedLetters = guessedLetters + "#";
                }
            }
            //переменная для хранения текущей длины слова
            int lengthOfWord = guessedLetters.length();
            for (int j = 0; j <= (15 - lengthOfWord); j++) {
                guessedLetters = guessedLetters + "#";
            }
            System.out.println(guessedLetters + "!");
            return true;
        }
    }
}
