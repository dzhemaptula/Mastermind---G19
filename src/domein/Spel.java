package domein;

import java.util.List;

public class Spel
{

    private SpelBord sb;
    
    public Moeilijkheidsgraad moeilijkheidsgraad;
    private int score;

    public String getSpelbord() {
        return sb.getSpelbord();
    }

    
    
    public Spel(int moeilijkheidsGraad, int ln)
    {
        this.moeilijkheidsgraad = Moeilijkheidsgraad.getMoelijkheidsgraad(moeilijkheidsGraad);
        sb = new SpelBord(moeilijkheidsGraad, ln);
    }
    public Spel(int moeilijkheidsGraad)
    {
        this.moeilijkheidsgraad = Moeilijkheidsgraad.getMoelijkheidsgraad(moeilijkheidsGraad);
        sb = new SpelBord(moeilijkheidsGraad);
    }
    public int [] getJuistePogingen(){
        return sb.getJuistePogingen();
    }
    public Spel(){
        sb = new SpelBord();
    }
    
    public int getScore()
    {
        return this.score;
    }
    public String getMogelijkeKleuren(){
        return sb.getMogelijkeKleuren();
    }
    public void vergelijkCode(int[] gegevenCode){
        sb.vergelijkCode(gegevenCode);
    }
    public void vulSpelbordrij( int[] poging){
        sb.vulSpelbordRij(poging);
    }
    public String getJuisteCombinatie(){
        return sb.getJuisteCombinatie();
    }
    public void slaSpelOp(String naam, String spelernaam){
        sb.slaSpelOp(naam, spelernaam);
    }
    public List<String> getBewaardeSpellen(String spelernaam){
        return sb.getBewaardeSpellen(spelernaam);
    }
    public void laadSpelOp(int spelid){
        sb.laadSpel(spelid);
        this.moeilijkheidsgraad = Moeilijkheidsgraad.getMoelijkheidsgraad(sb.getMoeilijkheidsgraad());
    }
    public int getMoeilijkheidsgraad(){
        return sb.getMoeilijkheidsgraad();
    }
    public void verwijderSpel(int spelid) {
        sb.verwijderSpel(spelid);
    }
    public int getJuistePogingenAantal(){
        return sb.getJuistePogingenAantal();
    }
    public int getAantalPogingen(){
        return sb.getAantalPogingen();
    }
}
