
import java.util.Comparator;

public class SortInterpret implements Comparator<Song> {
    public int compare(Song o1, Song o2){
        return o1.getInterpret().compareTo(o2.getInterpret());
    }
}
