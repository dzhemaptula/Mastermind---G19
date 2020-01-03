package domein;

public enum Moeilijkheidsgraad {

    Makkelijk("Makkelijk"), Normaal("Normaal"), Moeilijk("Moeilijk");

    private final String moeilijkheidsgraadS;

    private Moeilijkheidsgraad(String moeilijkheidsgraad) {
        this.moeilijkheidsgraadS = moeilijkheidsgraad;
    }

    @Override
    public String toString()
    {
        return moeilijkheidsgraadS;
    }
    
    public static Moeilijkheidsgraad getMoelijkheidsgraad(int moeilijkheidsgraadNr) {
        switch (moeilijkheidsgraadNr) {
            case 1:
                return Moeilijkheidsgraad.Makkelijk;
            case 2:
                return Moeilijkheidsgraad.Normaal;
            case 3:
                return Moeilijkheidsgraad.Moeilijk;
            default:
                return Moeilijkheidsgraad.Makkelijk;
        }
    }
}