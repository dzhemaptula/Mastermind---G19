package domein;

import static cui.Applicatie.stelTaalIn;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;
import java.util.Random;
import taal.Taal;

public class SpelBord
{
private static final Locale[] LOCALES =
    {
        new Locale("nl"), new Locale("en"), new Locale("fr")
    };

    public static void stelTaalIn(Locale locale)
    {
        Taal.setBundle(ResourceBundle.getBundle("taal/LabelsBundle", locale));
    }
    // Create SpelBord
    SpelRepository sr = new SpelRepository();
    private int[][] spelBordArray;
    private int[][] juistePogingen;
    private int[] mogelijkeKleuren;
    private int[] teKrakenCode;
    private int aantalPogingen = 0;
    private int moeilijkheidsgraad;
    private int juistePlaats;
    
    // Getter voor SpelBord
    public String getSpelbord()
    {
        
        String output = "";
        int x = 4;
        if (moeilijkheidsgraad == 3)
        {
            x = 5;
        }
        for (int column = 0; column < 12; column++)
        {
            for (int row = 0; row < x; row++)
            {
                output += Taal.geefString(""+Kleuren.getKleur(spelBordArray[column][row])) + ", ";

            }

            output += Taal.geefString("validatie");
            for (int row = 0; row < x; row++)
            {
                output += Taal.geefString(""+Kleuren.getKleur(juistePogingen[column][row])) + ", ";

            }
            output+="\n";
        }

        return output;
    }

    public SpelBord()
    {
    }

    public void genereerCode(int moeilijkheidsgraad)
    {
        boolean mogelijkeDubbels = false;
        if (moeilijkheidsgraad > 1)
        {
            mogelijkeDubbels = true;
        }
        int mogelijkeLegeVakken;
        int lengte = 4;
        if (moeilijkheidsgraad < 3)
        {
            mogelijkeLegeVakken = 1;
            teKrakenCode = new int[]
            {
                10, 10, 10, 10
            };
        } else
        {
            teKrakenCode = new int[]
            {
                10, 10, 10, 10, 10
            };
            lengte = 5;
            mogelijkeLegeVakken = 2;
        }
        int random;
        Random rand = new Random();
        boolean getalVeranderd = false;
        for (int x = 0; x < lengte; x++)
        {
            getalVeranderd = false;
            while (!getalVeranderd)
            {
                random = rand.nextInt(9) + 0;
                if (!mogelijkeDubbels)
                {
                    if (contains(teKrakenCode, random) == 0)
                    {
                        teKrakenCode[x] = random;
                        getalVeranderd = true;
                    } else if (random == 0 && contains(teKrakenCode, random) < mogelijkeLegeVakken)
                    {
                        teKrakenCode[x] = random;
                        getalVeranderd = true;
                    }
                }
                else{
                    if (random!=0)
                    {
                        teKrakenCode[x] = random;
                        getalVeranderd = true;
                    } else if (random == 0 && contains(teKrakenCode, random) < mogelijkeLegeVakken)
                    {
                        teKrakenCode[x] = random;
                        getalVeranderd = true;
                    }
                }

            }
        }
    }

    public int getAantalPogingen(){
        return aantalPogingen;
    }
    // Constructor voor een spelbordje te maken
    public SpelBord(int moeilijkheidsgraad,int ln)
    {
        this.moeilijkheidsgraad = moeilijkheidsgraad;
        // Als het moeilijk is, 5 horizontale pinnen. Als het makkelijk of normaal is 4.
        genereerCode(moeilijkheidsgraad);
        if (moeilijkheidsgraad == 3)
        {
            // Het is moeilijk
            spelBordArray = new int[12][5];
            juistePogingen = new int[12][5];
            mogelijkeKleuren = new int[]
            {
                1, 2, 3, 4, 5, 6, 7, 8
            };

        } else
        {
            aantalPogingen = 0;
            // Het is makkelijk of normaal
            spelBordArray = new int[12][4];
            juistePogingen = new int[12][4];
            mogelijkeKleuren = new int[]
            {
                1, 2, 3, 4, 5, 6, 7, 8
            };
            //throw new IllegalArgumentException("De code te kraken is: " + teKrakenCode[0] + teKrakenCode[1] + teKrakenCode[2] + teKrakenCode[3]);
        }

        for (int column = 0; column < spelBordArray.length; column++)
        {
            for (int row = 0; row < spelBordArray[1].length; row++)
            {
                spelBordArray[column][row] = 0;

            }
        }
        stelTaalIn(LOCALES[ln - 1]);
    }
    public SpelBord(int moeilijkheidsgraad)
    {
        this.moeilijkheidsgraad = moeilijkheidsgraad;
        // Als het moeilijk is, 5 horizontale pinnen. Als het makkelijk of normaal is 4.
        genereerCode(moeilijkheidsgraad);
        if (moeilijkheidsgraad == 3)
        {
            // Het is moeilijk
            spelBordArray = new int[12][5];
            juistePogingen = new int[12][5];
            mogelijkeKleuren = new int[]
            {
                1, 2, 3, 4, 5, 6, 7, 8
            };

        } else
        {
            aantalPogingen = 0;
            // Het is makkelijk of normaal
            spelBordArray = new int[12][4];
            juistePogingen = new int[12][4];
            mogelijkeKleuren = new int[]
            {
                1, 2, 3, 4, 5, 6, 7, 8
            };
            //throw new IllegalArgumentException("De code te kraken is: " + teKrakenCode[0] + teKrakenCode[1] + teKrakenCode[2] + teKrakenCode[3]);
        }

        for (int column = 0; column < spelBordArray.length; column++)
        {
            for (int row = 0; row < spelBordArray[1].length; row++)
            {
                spelBordArray[column][row] = 0;

            }
        }
    }

    public String getMogelijkeKleuren()
    {
        String res = "";
        for (int i : mogelijkeKleuren)
        {
            res += i + ": " + Taal.geefString(""+Kleuren.getKleur(i));
            if (i != mogelijkeKleuren[mogelijkeKleuren.length - 1])
            {
                res += ", ";
            }
        }

        return res;
    }

    public void vergelijkCode(int[] gegevenCode)
    {
        int[] backupKraken = new int[4];
        int[] backupggvCode = new int[4];
        if(moeilijkheidsgraad==3){
            backupKraken=new int[5];
            backupggvCode=new int[5];
        }
        int tellerxx=0;
        for(int i : teKrakenCode){
            backupKraken[tellerxx]=i;
            tellerxx++;
        }
        tellerxx=0;
        for(int i : gegevenCode){
            backupggvCode[tellerxx]=i;
            tellerxx++;
        }
        //throw new IllegalArgumentException("De te kraken code backup is: " + backupKraken[0]+backupKraken[1]+backupKraken[2]+backupKraken[3]);
        int juisteKleur = 0, juistePlaats = 0;
        if (moeilijkheidsgraad == 1)
        {
            for (int x = 0; x < backupggvCode.length; x++)
            {
                if (backupggvCode[x] == backupKraken[x])
                {
                    juistePogingen[aantalPogingen][x] = 10;
                    backupKraken[x] = 50;
                    backupggvCode[x]=40;
                    juistePlaats++;
                }
            }
            for (int x = 0; x < backupggvCode.length; x++)
            {
                int xtel = 0;
                for (int i : backupKraken)
                {
                    if (backupggvCode[x] == i)
                    {
                        juistePogingen[aantalPogingen][x] = 9;
                        backupKraken[xtel]=50;
                        break;
                    }
                    xtel++;
                }
            }
        } else
        {
            if (moeilijkheidsgraad == 3)
            {
                juistePogingen = new int[12][5];
            }
            for (int x = 0; x < backupggvCode.length; x++)
            {
                if (backupggvCode[x] == backupKraken[x])
                {
                    juistePlaats++;
                    backupggvCode[x]=40;
                    backupKraken[x]=50;
                }  
            }
            for (int x = 0; x < backupggvCode.length; x++)
                {
                    int xtel=0;
                    for (int i : backupKraken)
                    {
                        if (backupggvCode[x] == i)
                        {
                            juisteKleur++;
                            backupKraken[xtel]=50;
                            break;
                        }
                        xtel++;
                    }
                }
            for (int x = 0; x < juistePlaats; x++)
            {
                juistePogingen[aantalPogingen][x] = 10;
            }
            for (int y = juistePlaats; y < juisteKleur + juistePlaats; y++)
            {
                juistePogingen[aantalPogingen][y] = 9;
            }

        }
        this.juistePlaats = juistePlaats;
    }

    //testcommit
    private int contains(int[] array, int v)
    {
        int voorkomt = 0;
        for (int i : array)
        {
            if (i == v)
            {
                voorkomt++;
            }
        }
        return voorkomt;
    }

    public void vulSpelbordRij(int[] poging)
    {
        for (int x = 0; x < spelBordArray[0].length; x++)
        {
            spelBordArray[aantalPogingen][x] = poging[x];
        }
        this.aantalPogingen++;
    }

    public String getJuisteCombinatie()
    {
        return "Te kraken code: " + teKrakenCode[0] + teKrakenCode[1] + teKrakenCode[2] + teKrakenCode[3];
    }

    public void slaSpelOp(String naam, String spelernaam)
    {
        if (sr.bestaatNaam(naam))
        {
            throw new IllegalArgumentException("Naam bestaat al");
        }
        String spelbordstring = "";
        for (int[] x : spelBordArray)
        {
            for (int y : x)
            {
                spelbordstring += y;
            }
            spelbordstring += " ";
        }
        String teKrakenString = "";
        for (int x : teKrakenCode)
        {
            teKrakenString += x;
        }
        String juistePogingenString = "";
        for (int[] x : juistePogingen)
        {
            for (int y : x)
            {
                juistePogingenString += y;
                juistePogingenString += ".";
            }
            juistePogingenString += " ";
        }
        sr.slaSpelOp(spelernaam, naam, spelbordstring, juistePogingenString, teKrakenString, moeilijkheidsgraad, aantalPogingen);
    }

    public List<String> getBewaardeSpellen(String spelernaam)
    {
        return sr.getBewaardeSpellen(spelernaam);
    }

    public int getJuistePogingenAantal()
    {
        return juistePlaats;
    }

    public int [] getJuistePogingen(){
        return juistePogingen[aantalPogingen];
    }
    public void laadSpel(int spelId)
    {
        int juistePlaats = 0, juisteKleur = 0;
        List<String> opgeladenSpel = sr.laadSpelOp(spelId);
        String spelBord = opgeladenSpel.get(0);
        String juistePogingenString = opgeladenSpel.get(4);
        int opvullenRij = 0;
        int opvullenPlaats = 0;
        juistePogingen = new int[12][5];
        String getal="";
        for (int x = 0; x < juistePogingenString.length() - 1; x++)
        {
            if (juistePogingenString.substring(x, x + 1).equals(" "))
            {
                opvullenRij++;
                opvullenPlaats = 0;
            } else
            {
                //throw new IllegalArgumentException("De geparste int is: " + juistePogingenString);
                if(!juistePogingenString.substring(x,x+1).equals(".")){
                    getal += juistePogingenString.substring(x,x+1);
                } else{
                    juistePogingen[opvullenRij][opvullenPlaats]=Integer.parseInt(getal);
                    getal="";
                    opvullenPlaats++;
                }
            }
        }
        int moeilijkheidsgraad = Integer.parseInt(opgeladenSpel.get(1));
        this.moeilijkheidsgraad = moeilijkheidsgraad;
        this.aantalPogingen = Integer.parseInt(opgeladenSpel.get(2));
        if (moeilijkheidsgraad == 3)
        {
            // Het is moeilijk
            spelBordArray = new int[12][5];
            teKrakenCode = new int[]
            {
                0, 0, 0, 0, 0
            };
            for (int x = 0; x < opgeladenSpel.get(3).length(); x++)
            {
                teKrakenCode[x] = Integer.parseInt(opgeladenSpel.get(3).substring(x, x + 1));
            }
            mogelijkeKleuren = new int[]
            {
                1, 2, 3, 4, 5, 6, 7, 8
            };

        } else
        {
            // Het is makkelijk of normaal
            spelBordArray = new int[12][4];
            teKrakenCode = new int[]
            {
                0, 0, 0, 0
            };
            for (int x = 0; x < opgeladenSpel.get(3).length(); x++)
            {
                teKrakenCode[x] = Integer.parseInt(opgeladenSpel.get(3).substring(x, x + 1));
            }
            mogelijkeKleuren = new int[]
            {
                1, 2, 3, 4, 5, 6, 7, 8
            };
        }
        opvullenRij = 0;
        opvullenPlaats = 0;
        for (int x = 0; x < spelBord.length() - 1; x++)
        {
            if (spelBord.substring(x, x + 1).equals(" "))
            {
                opvullenRij++;
                opvullenPlaats = 0;
            } else
            {
                //throw new IllegalArgumentException("De geparste int is: " + spelBord.substring(x,1));
                spelBordArray[opvullenRij][opvullenPlaats] = Integer.parseInt(spelBord.substring(x, x + 1));
                opvullenPlaats++;
            }
        }

    }

    public int getMoeilijkheidsgraad()
    {
        return this.moeilijkheidsgraad;
    }

    public void verwijderSpel(int spelid)
    {
        sr.verwijderSpel(spelid);
    }

}
