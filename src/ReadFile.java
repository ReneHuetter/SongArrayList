/**
 *  Klasse zum Einlesen der Textdatei "musiksammlung.txt"
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    /**
     * Die Methode liest die Textdatei zeilen weise ein.
     * Der pfad wo die Textdatei gespeichert ist, wird über
     * die klasse Musiksammlung und die Variable path aufgerufen.
     * In die Variable "zeile" von type String wird die eingelesene Zeile gespeichert.
     * Der String "zeile" wird das "\n" entfernt und dann aufgeteilt beim ",".
     * Der geteilte String wird in den String Array temp gespeichert und über den
     * index zu gewiesen für das Objekt Song (interpret, titel).
     * Das Objekt song wird dann der Musiksammlung hinzugefügt.
     */
    public static void readFile() {

        try (BufferedReader fileRead = new BufferedReader(new FileReader(Musiksammlung.path))) {
            String zeile;
            while ((zeile = fileRead.readLine()) != null) {
                zeile = zeile.replace("\n" , "");
                String[] temp = zeile.split(",");
                String interpret = temp[0];
                String titel = temp[1];
                Song song = new Song(interpret, titel);
                Musiksammlung.musiksammlung.add(song);
            }
        }
        catch (IOException e) {
            System.out.println(Musiksammlung.error);
            e.printStackTrace();
        }
    }
}
