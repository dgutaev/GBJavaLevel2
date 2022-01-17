package Lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneBook {
    private final HashMap<String, List<String>> phoneBook;
    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void add(String name, String phone) {
        if (phoneBook.containsKey(name)) {
            List<String> numbers = phoneBook.get(name);
            if (!numbers.contains(phone)) {
                numbers.add(phone);
            } else {
                System.out.printf("Номер %s уже существует для фамилии %s%n", phone, name);
            }
        } else {
            phoneBook.put(name, new ArrayList<>(List.of(phone)));
        }
    }

    public List<String> get(String name) {
        if (phoneBook.containsKey(name)) {
            return phoneBook.get(name);
        } else {
            System.out.printf("Нет записи для фамилии %s%n", name);
            return new ArrayList<>();
        }
    }
}

