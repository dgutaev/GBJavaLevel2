/*
1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных слов,
 из которых состоит массив (дубликаты не считаем). Посчитать сколько раз встречается каждое слово.
2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров. В этот
телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать номер телефона по
фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при
запросе такой фамилии должны выводиться все телефоны.
 */

package Lesson3;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Задание 1
        List<String> names = Arrays.asList(
                "Иванов", "Петров", "Сидоров", "Григорьев", "Петров",
                "Зюзькин", "Иванов", "Ильин", "Сидоров", "Зюзькин",
                "Ильюшкин", "Мальков", "Сидоров", "Сидоров", "Котиков",
                "Котеночкин", "Котиков", "Зюзяков", "Васькин", "Котиков"
        );

        Set<String> uniqueWords = new HashSet<>(names);

        System.out.println("Список уникальных слов:");
        System.out.println(uniqueWords);
        for (String key : uniqueWords) {
            System.out.println(key + ": " + Collections.frequency(names, key));
        }

        //Задание 2
        PhoneBook phoneBook = new PhoneBook();
        System.out.println();
        phoneBook.add("Иванов", "51-62-26");
        phoneBook.add("Иванов", "55-12-46");
        phoneBook.add("Петров", "77-12-48");
        phoneBook.add("Сидоров", "62-22-18");
        phoneBook.add("Иванов", "18-55-15");
        System.out.println();
        System.out.println(phoneBook.get("Иванов"));
        System.out.println(phoneBook.get("Петров"));
        System.out.println(phoneBook.get("Сидоров"));
        System.out.println(phoneBook.get("Кузнецов"));

        //Добавление номера для существующей фамилии
        phoneBook.add("Иванов", "51-64-25");
        //Вывод номера для фамилии "Иванов"
        System.out.println(phoneBook.get("Иванов"));
    }
}