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

    /**
     * alls erstes wird die Methode readFile aus der Klasse ReadFile angesprochen.
     * state machine für den Programmablauf.
     * Der Begrüssungstext ist als Textblock formatiert.
     * was auch das Menü ist, wo der User aus suchen kann.
     * durch die eingabe springt man im Switch in jeweilige Case.
     * Wo die jeweilige Methode aufgerufen wird.
     */
    public static void main (String [] args) {

        ReadFile.readFile();

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

    /**
     * Methode removeSong löscht ein Objekt aus der Arraylist musiksammlung.
     * Das zu löschente Objekt wird mittels User eingabe ausgewählt und mit dem Schlüsselwort
     * remove gelöscht.
     * Vor den löschen wird den User die Musiksammlung angezeigt und nach den löschen wird die
     * aktuelle Musiksammlung angezeigt.
     */
    public static void removeSong() {
        Scanner scanner1 = new Scanner(System.in);
        printMusiksammlung();
        System.out.println("Was für ein Song soll entfernt werden nur Zahl eingeben");
        int index = scanner1.nextInt();
        musiksammlung.remove(index -1);
        System.out.println("Die neue Sammlung:");
        printMusiksammlung();
    }

    /**
     * Einfache Ausgabe der Musiksammlung über der Konsole.
     * es wird mittels einer For Schleife durch die ArrayList durchgelaufen.
     * der index(i) darf nicht größer sein als die Arraylist ist.
     * da Objekte in der Arraylist(musiksammlung) sind,
     * müssen wir mit get(i) das Objekt mit getTitel() und getInterpret() ansprechen.
     */
    public static void printMusiksammlung() {
        musiksammlung.sort(new SortInterpret());
        for (int i = 0; i < musiksammlung.size(); i++) {
            System.out.println(i+1 + ": " + "Titel: " + musiksammlung.get(i).getTitel() + "\n\t\t" +"Interpret: " + musiksammlung.get(i).getInterpret() + "\n");
        }
    }

    /**
     * Ihr werden die Parameter für den Konstruktor eingeben.
     * Parameter interpret und titel.
     * Damit das neue Objekt (song) erste stellt werden kann.
     * Das Objekt (song) wird dan zur ArrayList (musiksammlung) hinzugefügt(add).
     */
    public static void addSong() {
        System.out.println("Gib den Interpret ein: ");
        String interpret = scanner.nextLine();
        System.out.println("Gib den Musik Titel ein: ");
        String titel = scanner.nextLine();

        Song song = new Song(interpret, titel);

        musiksammlung.add(song);
    }

    /**
     * Methoden searchInterpret und searchTitel.
     * User gibt den Interpreten/ Titel ein, wenn Interpret/Titel übereinstimmen (equals)
     * werden es Ausgeben.
     * Da es sich um ein Objekt liste, handelt und wir das Objekt mit den passenten
     * Interpreten oder Titel suchen werden mittels einer For-each Schleife durchgelaufen.
     */
    private static void searchInterpret () {
        int count = 0;
        System.out.println("Geben sie für die Suche den Interpreten ein: ");
        String interpret = scanner.nextLine();
        for (Song song : musiksammlung) {
            if (song.getInterpret().equals(interpret)) {
                System.out.println("Titel: " + song.getTitel() + "\n\t\tInterpret: " + interpret);
                count++;
            }
        }
        System.out.println("\nEs wurden " + count + " treffer gefunden");
    }

    private static void searchTitel () {
        int count = 0;
        System.out.println("Geben sie für die Suche den Titel ein: ");
        String titel = scanner.nextLine();
        for (Song song : musiksammlung) {
            if (song.getTitel().equals(titel)) {
                System.out.println("Titel: " + titel + "\n\t\tInterpret: " + song.getInterpret());
                count++;
            }
        }
        System.out.println("\nEs wurden " + count + " treffer gefunden");
    }
}