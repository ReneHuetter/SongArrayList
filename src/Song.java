public class Song {
    private String titel;
    private String interpret;

    public Song(String interpret, String titel) {
        this.interpret = interpret;
        this.titel = titel;
    }

    public String getTitel() {
        return titel;
    }

    public String getInterpret() {
        return interpret;
    }
}