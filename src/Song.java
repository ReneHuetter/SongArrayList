/**
 * Die Klasse Song ist die Bauanleitung
 * für das Objekt Song
 */
public class Song {
    private String titel;
    private String interpret;

    /**
     * Konstruktor Song
     * erstellt das Objekt Song
     * @param interpret für interpret
     * @param titel für titel
     */
    public Song(String interpret, String titel) {
        this.interpret = interpret;
        this.titel = titel;
    }

    /**
     * Getter Methode getTitel
     * gibt den titel zurück zum Konstruktor
     * @return titel
     */
    public String getTitel() {
        return titel;
    }

    /**
     * Getter Methode getInterpret
     * gibt den interpret zurück zum Konstruktor
     * @return interpret
     */
    public String getInterpret() {
        return interpret;
    }

}