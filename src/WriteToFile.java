import java.io.FileWriter;
import java.io.IOException;

/**
 * Klasse zum Schreiben einer Datei
 */
public class WriteToFile {

    /**
     * Die Methode speichert die Objektattribute, von der liste musiksammlung aus der
     * Klasse Musiksammlung in die Textdatei musiksammlung.txt.
     */
    public static void writeToFile() {
        try {
            FileWriter writeDate = new FileWriter(Musiksammlung.path);
            for (Song song : Musiksammlung.musiksammlung) {
                writeDate.write(song.getTitel() + "," + song.getInterpret() + "\n");
            }
            writeDate.close();
            System.out.println("Die Datei wurde Erfolgreich erstellt");
        } catch (IOException e) {
            System.out.println(Musiksammlung.error);
            e.printStackTrace();
        }
    }
}
