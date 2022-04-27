import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

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
            throw new RuntimeException(e);
        }

    }
}
