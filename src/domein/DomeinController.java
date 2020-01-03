package domein;

import java.util.List;

public class DomeinController {
    private final SpelerRepository spelerRepositoryInstantie = new SpelerRepository();
    private Speler spelerInstantie;
    private Spel spelInstantie;
    private KlassementRepository klassementInstantie = new KlassementRepository();
    private UitdaagRepository uitdaagRepositoryInstantie = new UitdaagRepository();
    private String uitgedaagdeSpeler="";
    private boolean geaccepteerdeUitdaging=false;
    private int gekozenUitdaging;
    public void setGekozenUitdaging(int puitd){
        this.gekozenUitdaging=puitd;
    }
    public int getGekozenUitdaging(){
        return gekozenUitdaging;
    }
    
    public void aanvaardUitdaging(){
        geaccepteerdeUitdaging=true;
    }
    public void stopUitdaging(){
        geaccepteerdeUitdaging=false;
    }
    public boolean getUitdagingstatus(){
        return geaccepteerdeUitdaging;
    }
    public void setUitgedaagdeSpeler(String pnaam){
        uitgedaagdeSpeler=pnaam;
    }
    public String getUitgedaagdeSpeler(){
        return this.uitgedaagdeSpeler;
    }
    // Log in functie
    public Speler meldAan(String naam, String wachtwoord) { //void
        spelerInstantie = spelerRepositoryInstantie.meldAan(naam, wachtwoord);
        if(spelerInstantie==null){}else{
        spelerInstantie.setGewonnenSpelletjes(this.getGewonnenSpelletjes());
        spelerInstantie.wisWachtwoord();}
        return spelerInstantie;
    }
    
    public String getSpelbord(){
        return spelInstantie.getSpelbord();
    }

    public void startSpel(int moeilijkheidsgraad, int ln){
        spelInstantie = new Spel(moeilijkheidsgraad, ln);
    }
    public void startSpel(int moeilijkheidsgraad){
        spelInstantie = new Spel(moeilijkheidsgraad);
    }
    public int [] getJuistePogingen(){
        return spelInstantie.getJuistePogingen();
    }
    public int getMoeilijkheidsgraad(){
        return spelInstantie.getMoeilijkheidsgraad();
    }
    // Registreerfunctie
    public void registreer(String naam, String wachtwoord, String wachtwoordBevestiging) {
        //sp.registreer(naam, wachtwoord, wachtwoord2);
        spelerInstantie = new Speler(naam, wachtwoord , wachtwoordBevestiging);
        spelerInstantie.setGewonnenSpelletjes(this.getGewonnenSpelletjes());
        spelerRepositoryInstantie.voegToe(spelerInstantie);
        spelerInstantie.wisWachtwoord();
    }
    
    // Geeft de spelernaam
    public String getSpelersNaam(){
        return spelerInstantie.getNaam();
    }
    public int getSpelerId(String naam){
        return spelerInstantie.getSpelerId(naam);
    }
    
    // Geeft de gewonnen spelletjes voor een speler
    public List<Integer> getGewonnenSpelletjes(){
        return spelerRepositoryInstantie.getGewonnenSpelletjes(spelerInstantie.getNaam());
    }
    
    // Geeft het moeilijkheidsgraad menu
    public List<String> getMoeilijkheidsgraadMenu(List<Integer> wins){
        return spelerRepositoryInstantie.getMoeilijkheidsgraadMenu(wins);
    }
    
    //Deze methode dient om de moeilijkgheidsmenu te krijgen. Als het 2 retourneert zal er alleen makkelijk en normaal mogelijk zijn om te kiezen als moeilijkheidsgraad
    public Moeilijkheidsgraad getMoeilijkheidsGraadString()
    {
        return spelInstantie.moeilijkheidsgraad;
    }
    public String getMogelijkeKleuren(){
        return spelInstantie.getMogelijkeKleuren();
    }
    public void vergelijkCode(int[] gegevenCode){
        spelInstantie.vergelijkCode(gegevenCode);
    }
    public void vulSpelbordrij(int[] poging){
        spelInstantie.vulSpelbordrij(poging);
    }
    public String getJuisteCombinatie(){
        return spelInstantie.getJuisteCombinatie();
    }
    public void slaSpelOp(String naam){
        spelInstantie.slaSpelOp(naam, spelerInstantie.getNaam());
    }
    public List<String> getBewaardeSpellen(){
        return spelInstantie.getBewaardeSpellen(spelerInstantie.getNaam());
    }
    public void startSpel(){
        spelInstantie = new Spel();
    }
    public void laadSpelOp(int spelid){
        spelInstantie.laadSpelOp(spelid);
    }
    
    public void verwijderSpel(int spelid) {
        spelInstantie.verwijderSpel(spelid);
    } 
    public void gewonnenSpel(int moeilijkheidsgraad){
        spelerInstantie.gewonnenSpel(moeilijkheidsgraad);
    }
    public int getJuistePogingenAantal(){
        return spelInstantie.getJuistePogingenAantal();
    }
    public List<String> geefSpelers(String naam){
        return spelerInstantie.geefSpelers(naam);
    }
    public int getAantalPogingen(){
        return spelInstantie.getAantalPogingen();
    }
    public void gewonnenUitdaging(int id, int aantalPogingen,int moeilijkheidsgraad){
        uitdaagRepositoryInstantie.gewonnenUitdaging(spelerInstantie.getSpelerId(spelerInstantie.getNaam()), id, aantalPogingen, moeilijkheidsgraad);
    }
    public boolean bestaatSpelerById(int id){
        return spelerInstantie.bestaatSpelerById(id);
    }
    
    public int openstaandeUitdagingen(int id) {
        return uitdaagRepositoryInstantie.openstaandeUitdagingen(id);
    }
    
    public List<String> toonUitdagingen(int id) {
        return uitdaagRepositoryInstantie.toonUitdagingen(id);
    }
    public boolean bestaatUitdaging(int id){
        return uitdaagRepositoryInstantie.bestaatUitdaging(id, spelerInstantie.getSpelerId(spelerInstantie.getNaam()));
    }
    public int getUitdagingMoeilijkheid(int id){
        return uitdaagRepositoryInstantie.getUitdagingMoeilijkheid(id);
    }
    public void gewonnenGeaccepteerdeUitdaging(int id, int aantalPogingen){
        uitdaagRepositoryInstantie.gewonnenGeaccepteerdeUitdaging(id, aantalPogingen);
    }
    public int[][] toonKlassement(){
        return klassementInstantie.toonKlassement();
    }
    public String getSpelerNaamById(int id){
        return spelerRepositoryInstantie.getSpelerNaamById(id);
    }
    public void verhoogWins(int spelerid){
        klassementInstantie.verhoogWins(spelerid);
    }
    public void verhoogLosses(int spelerid){
        klassementInstantie.verhoogLosses(spelerid);
    }
    public void verlaagWins(int spelerid)
    {
        klassementInstantie.verlaagWins(spelerid);
    }

    public void verlaagLosses(int spelerid)
    {
        klassementInstantie.verlaagLosses(spelerid);
    }
    public int getTegenStanderIdByUitdagingId(int id) {
        return uitdaagRepositoryInstantie.getTegenStanderIdByUitdagingId(id);
    }
    public int getTegenstanderScore(int gekozenuitdagingid) {
        return uitdaagRepositoryInstantie.getTegenstanderScore(gekozenuitdagingid);
    }
}
