/* Musiksammlung
*  Author: Rene Hütter
*  Datum: 20.04.2022
*  Version: 01.0
* */

import java.util.*;
import java.io.*;

public class Musiksammlung {

    ArrayList<Song> musiksammlung = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public static void main (String [] args) {

        while (true) {
            System.out.println();

        }

    }

    public void removeSong() {
        int index = scanner.nextInt(-1);
        musiksammlung.remove(index);
    }

    public void getMusiksammlung() {
        for (int i = 0; i < musiksammlung.size(); i++) {
            System.out.println("Titel: " + musiksammlung.get(i).getTitel() + "Interpret: " + musiksammlung.get(i).getInterpret());
        }
    }

    public void addSong () {
        System.out.println("Gib den Interpret ein: ");
        String interpret = scanner.nextLine();
        System.out.println("Gib den Musik Titel ein: ");
        String titel = scanner.nextLine();

        Song song = new Song(interpret, titel);

        musiksammlung.add(song);
    }

    private void writeToFile () {
        String path = "C:\\Users\\BBRZ\\IdeaProjects\\SongArrayList\\src";
        try {
            FileWriter writeDate = new FileWriter(path);
            for (int i = 0; i < musiksammlung.size(); i++) {
                writeDate.write(musiksammlung.get(i).getTitel() + "," + musiksammlung.get(i).getInterpret() + "\n");
            }
            writeDate.close();
            System.out.println("Die Datei wurde Erfolgreich erstellt");
        } catch (IOException e) {
            System.out.println("Es ist ein Fehler aufgetreten.");
            e.printStackTrace();
        }
    }

    private void searchInterpret () {
        System.out.println("Geben sie für die Suche den Interpreten ein: ");
        String interpret = scanner.nextLine();
        for (int i = 0; i < musiksammlung.size(); i++) {
            if (musiksammlung.get(i).getInterpret().equals(interpret)) {
                System.out.println("Interpret: " + musiksammlung.get(i).getInterpret());
            }
        }
    }

    private void searchTitel () {
        System.out.println("Geben sie für die Suche den Titel ein: ");
        String titel = scanner.nextLine();
        for (int i = 0; i < musiksammlung.size(); i++) {
            if (musiksammlung.get(i).getTitel().equals(titel)) {
                System.out.println("Titel: " + musiksammlung.get(i).getTitel());
            }
        }
    }
}
