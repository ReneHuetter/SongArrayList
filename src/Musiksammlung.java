/* Musiksammlung
*  Author: Rene Hütter
*  Datum: 20.04.2022
*  Version: 01.0
* */

import java.util.ArrayList;
import java.util.Scanner;

public class Musiksammlung {

   //Die ArrayList musiksammlung beinhaltet das objekt Song.
    static ArrayList<Song> musiksammlung = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    // Variable für den Datenpfad wo die Datei gespeichert wird.
    static String path = "C:\\Users\\BBRZ\\IdeaProjects\\SongArrayList\\src\\musiksammlung.txt";
    static String error = "Es ist ein Fehler aufgetreten.";

    public static void main (String [] args) {

        ReadFile.readFile();
        // state machine für den Programmablauf
        while (true) {
            System.out.println("""
                    Willkommen bei Musiksammlung.
                    Für einen Song hier er Sammlung hinzuzufügen "add" eingeben.
                    Für einen Song aus hier Sammlung zu entfernen "remove" eingeben.
                    Für das  anzeigen hier Sammlung "show" eingeben.
                    Für speicher der Sammlung "save" eingeben.
                    Für die Suche nach Interpret "artist" eingeben.
                    Für die Suche nach Titel "titel" eingeben.
                    Zum Beenden "quit" eingeben.
                    """);
            String zustand = scanner.nextLine();
            switch (zustand) {
                case "add" -> addSong();
                case "remove" -> removeSong();
                case "show" -> printMusiksammlung();
                case "save" -> WriteToFile.writeToFile();
                case "artist" -> searchInterpret();
                case "titel" -> searchTitel();
                case "quit" -> System.exit(0);
                default -> System.out.println("FALSCHE EINGABE");
            }
        }
    }

    public static void removeSong() {
        Scanner scanner1 = new Scanner(System.in);
        printMusiksammlung();
        System.out.println("Was für ein Song soll entfernt werden nur Zahl eingeben");
        int index = scanner1.nextInt();
        musiksammlung.remove(index -1);
        System.out.println("Die neue Sammlung:");
        printMusiksammlung();
    }

    public static void printMusiksammlung() {
        for (int i = 0; i < musiksammlung.size(); i++) {
            System.out.println(i+1 + " " +"Titel: " + musiksammlung.get(i).getTitel() + " " +"Interpret: " + musiksammlung.get(i).getInterpret());
        }
    }

    public static void addSong() {
        System.out.println("Gib den Interpret ein: ");
        String interpret = scanner.nextLine();
        System.out.println("Gib den Musik Titel ein: ");
        String titel = scanner.nextLine();

        Song song = new Song(interpret, titel);

        musiksammlung.add(song);
    }

    private static void searchInterpret () {
        System.out.println("Geben sie für die Suche den Interpreten ein: ");
        String interpret = scanner.nextLine();
        for (Song song : musiksammlung) {
            if (song.getInterpret().equals(interpret)) {
                System.out.println("Titel: " + song.getTitel() + "Interpret: " + interpret);
            }
        }
    }

    private static void searchTitel () {
        System.out.println("Geben sie für die Suche den Titel ein: ");
        String titel = scanner.nextLine();
        for (Song song : musiksammlung) {
            if (song.getTitel().equals(titel)) {
                System.out.println("Titel: " + titel + "Interpret: " + song.getInterpret());
            }
        }
    }
}