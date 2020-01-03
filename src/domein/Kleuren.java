package domein;

public enum Kleuren
{
    wit("Wit"), cyaan("Cyaan"), leeg("Leeg"), rood("Rood"), blauw("Blauw"), geel("Geel"), paars("Paars"), groen("Groen"), zwart("Zwart"), bruin("Bruin"), oranje("Oranje");

    private final String kleurS;

    private Kleuren(String kleur)
    {
        this.kleurS = kleur;
    }

    @Override
    public String toString()
    {
        return kleurS;
    }

    public static Kleuren getKleur(int kleur)
    {
        switch (kleur)
        {
            case 0:
                return Kleuren.leeg;
            case 1:
                return Kleuren.rood;
            case 2:
                return Kleuren.blauw;
            case 3:
                return Kleuren.geel;
            case 4:
                return Kleuren.paars;
            case 5:
                return Kleuren.groen;
            case 6:
                return Kleuren.cyaan;
            case 7:
                return Kleuren.bruin;
            case 8:
                return Kleuren.oranje;
            case 9: 
                return Kleuren.wit;
            case 10: 
                return Kleuren.zwart;
            default:
                throw new IllegalArgumentException("Ongeldig kleur "+ kleur);
        }
    }
}
