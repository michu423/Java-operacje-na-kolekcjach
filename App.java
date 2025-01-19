import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            // Zad1
            System.out.println("Wprowadź liczby dla pierwszego zadania (oddzielone spacjami):");
            List<Integer> liczby1 = Stream.of(scanner.nextLine().split(" "))
                    .map(Integer::valueOf)
                    .toList();
            obliczSrednia(liczby1);

            // Zad2
            System.out.println("Wprowadź liczby dla drugiego zadania (oddzielone spacjami):");
            List<Integer> liczby2 = Stream.of(scanner.nextLine().split(" "))
                    .map(Integer::valueOf)
                    .toList();
            kwadratyBez9(liczby2);

            // Zad3
            System.out.println("Wprowadź teksty dla trzeciego zadania (oddzielone spacjami):");
            List<String> teksty = List.of(scanner.nextLine().split(" "));
            dodajY(teksty);
        }
    }

    private static void obliczSrednia(List<Integer> liczby) {
        var srednia = liczby.stream()
                .filter(x -> x % 10 != 7 && x % 10 != 9)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
        System.out.printf("Średnia z wybranych liczb: %.2f%n", srednia);
    }

    private static void kwadratyBez9(List<Integer> liczby) {
        var wynik = liczby.stream()
                .map(x -> x * x + 9)
                .filter(x -> !x.toString().contains("9"))
                .toList();
        System.out.println("Przefiltrowane wyniki: " + wynik);
    }

    private static void dodajY(List<String> teksty) {
        var wynik = teksty.stream()
                .map(str -> str.concat("y"))
                .filter(str -> !str.contains("yy"))
                .toList();
        System.out.println("Przekształcone teksty: " + wynik);
    }
}