/*Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов. */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class zadacha1 {
    public static void main(String[] args) {
        Map<String, List<String>> book = new HashMap<>();
        book.put("Маша", List.of("8 902 221 23 24", "8 905 888 99 00"));
        book.put("Петя", List.of("8 909 321 20 10", "8 915 874 75 76"));
        book.put("ВАня", List.of("8 996 505 81 45"));

        menu(book);
    }
    public static Map<String, List<String>> menu(Map<String, List<String>> book) {
        while (true) {
            System.out.println("    --------------\n   Телефонная Книга\n    --------------\n" +
                    "        Меню: \n1. Найти контакт \n2. Добавить контакт" +
                    " \n3. Печать телефонной книги \n4. Выход");
            System.out.print("\nвыберите пункт меню-> ");
            String comands = scan();
            if (comands.equals("4")) {
                break;
            } else {
                switch (comands) {
                    case "1":
                        find(book);
                        break;
                    case "2":
                        add(book);
                        break;
                    case "3":
                        allBook(book);
                        break;
                    default:
                        break;
                }
            }
        }
        return book;
    }

    public static String scan() {
        try (Scanner scanner = new Scanner(System.in)) {
            String scan = scanner.nextLine();
            return scan;
        }
    }

    public static void find(Map<String, List<String>> phoneBook){
        System.out.print("Введите имя для поиска: ");
        String name = scan();
        System.out.println("Имя: " + name + "\nТелефон(ы) абонента: " + phoneBook.get(name));
    }

    public static void allBook(Map<String, List<String>> AllBook){
        for (var item : AllBook.entrySet()) {
            System.out.println("Имя: " + item.getKey() + "\nНомер" + item.getValue());
        }
    }

    public static Map<String, List<String>> add(Map<String, List<String>> book){
        System.out.print("Имя абонента: ");
        String name = scan();
        List<String> data = new ArrayList<>();
        while (true) {
            System.out.println("Если номеров больше нет, введите '0'");
            System.out.print("Введите номер: ");
            String nomer = scan();
            if (nomer.equals("0")) {
                break;
            } else {
                data.add(nomer);
            }
        }
        book.put(name, data);

        return book;
    }
}

