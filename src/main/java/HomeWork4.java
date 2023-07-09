import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class HomeWork4 {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        ArrayList<Integer> id = new ArrayList<>();
        ArrayList<String> f = new ArrayList<>();
        ArrayList<String> n = new ArrayList<>();
        ArrayList<String> fn = new ArrayList<>();
        ArrayList<Integer> v = new ArrayList<>();
        ArrayList<Boolean> p = new ArrayList<>();
        while (true) {
            System.out.println("Напишите фамилию ");
            f.add(scanner.nextLine());
            System.out.println("Напишите имя ");
            n.add(scanner.nextLine());
            System.out.println("Напишите отчество ");
            fn.add(scanner.nextLine());
            System.out.println("Напишите возраст ");
            v.add(Integer.valueOf(scanner.nextLine()));
            System.out.println("Напишите пол ");
            p.add(scanner.nextLine().toLowerCase().contains("м"));
            id.add(p.size() - 1);
            System.out.println("продолжить добавление Да / Нет ");
            String tmp = scanner.nextLine();
            if (tmp.toLowerCase().contains("н")) break;

        }
        for (int i = 0; i < f.size(); i++) {
            System.out.println(f.get(i) + " " + n.get(i).toUpperCase().charAt(0) + ". " + fn.get(i).toUpperCase().charAt(0) + ". " + v.get(i) + " " + (p.get(i)?"М":"Ж"));
        }
        System.out.println("-".repeat(50));
        while (true) {
            System.out.println("Сортировать по возрасту да/ нет ");
            String temp = scanner.nextLine();
            if (temp.toLowerCase().contains("да")) {
                id.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return v.get(o1) - v.get(o2);
                    }
                });
                for (int i = 0; i < id.size(); i++) {
                    System.out.println(f.get(id.get(i)) + " " + n.get(id.get(i)) + " " + fn.get(id.get(i)) + " " + v.get(id.get(i)) + " " + (p.get(id.get(i))?"М":"Ж"));
                }
            }
            else break;
            }

        while (true) {
            System.out.println("-".repeat(50));
            System.out.println("Сортировать по возрасту и полу да/ нет ");
            String tmp = scanner.nextLine();
            if (tmp.toLowerCase().contains("да")) {
                id.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        if (p.get(o1) == true) return 1;
                        else return -1;
                    }
                });
                id.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        if (p.get(o1) == p.get(o2)) return v.get(o1) - v.get(o2);
                        return 0;
                    }
                });

                for (int i = 0; i < id.size(); i++) {
                    System.out.println(f.get(id.get(i)) + " " + n.get(id.get(i)).toUpperCase().charAt(0) + ". " + fn.get(id.get(i)).toUpperCase().charAt(0) + ". " + v.get(id.get(i)) + " " + (p.get(id.get(i)) ? "М" : "Ж"));
                }
            }
            if (tmp.toLowerCase().contains("н")) break;
        }

    }
}


