
import java.util.Comparator;

public class SortTitel implements Comparator<Song> {
    public int compare(Song o1, Song o2){
        return o1.getTitel().compareTo(o2.getTitel());
    }
}
