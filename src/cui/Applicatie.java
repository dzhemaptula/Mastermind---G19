package cui;

import java.util.Scanner;
import taal.Taal;
import domein.DomeinController;
import domein.Moeilijkheidsgraad;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Arrays;
import java.util.Collections;

public class Applicatie
{
    private static final Locale[] LOCALES
            =
            {
                    new Locale("nl"), new Locale("en"), new Locale("fr")
            };

    public static void stelTaalIn(Locale locale)
    {
        Taal.setBundle(ResourceBundle.getBundle("taal/LabelsBundle", locale));
    }

    public static void main(String[] args)//test comment
    {
        Taal taal; //taal klasse maken (moet nog veranderd worden voor de correcte taal-gebruik manier
        DomeinController dc = new DomeinController(); //dc voor ons domein-laag communicatie met de persistentielaag
        Scanner sc = new Scanner(System.in);
        int ln = 0, regres = 0, mn = 0, gekozenUitdaging = 0;
        String gebnm = "", ww = "", ww2 = "";
        do
        {
            try
            {
                System.out.println("Kies een taal/Choose a language/Choisissez une langue:");
                System.out.println("1: NL");
                System.out.println("2: EN");
                System.out.println("3: FR");

                ln = sc.nextInt();
                if (ln < 1 || ln > 3)
                {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e)
            {
                System.out.println("Kies een geldig nummer.\nChoisissez un nombre valide.\nChoose a valid language.\n");
            }
        } while (ln < 1 || ln > 3);
        stelTaalIn(LOCALES[ln - 1]);
        do
        {
            try
            {
                System.out.println(Taal.geefString("getWelkomBericht"));
                System.out.println(Taal.geefString("getLogin"));
                System.out.println(Taal.geefString("getRegistreer"));
                mn = sc.nextInt();

                if (mn > 2 || mn < 1)
                {
                    throw new IllegalStateException();
                }
            } catch (IllegalStateException e)
            {
                System.out.println(Taal.geefString("getOngeldigeKeuze"));
            }
        } while (mn > 2 || mn < 1);
        if (mn == 1)//login menu
        {
            do
            {
                try
                {
                    System.out.println(Taal.geefString("getGebruikerTekst"));
                    gebnm = sc.next();
                    System.out.println(Taal.geefString("getWachtwoordTekst"));
                    ww = sc.next();
                    if (dc.meldAan(gebnm, ww) == null)
                    {
                        throw new IllegalArgumentException();
                    }
                } catch (IllegalArgumentException e)
                {
                    System.out.println(Taal.geefString("getNietCorrecteLogin"));
                }
            } while (dc.meldAan(gebnm, ww) == null);
            System.out.println(Taal.geefString("getIngelogd"));

        }
        if (mn == 2)//registratie menu
        {
            boolean ingelogd = false;
            do
            {
                try
                {
                    System.out.println(Taal.geefString("getGebruikerTekst"));
                    gebnm = sc.next();
                    System.out.println(Taal.geefString("getWachtwoordVoorwaarden"));
                    System.out.println(Taal.geefString("getWachtwoordTekst"));
                    ww = sc.next();
                    System.out.println(Taal.geefString("getBevestigingsWachtwoord"));
                    ww2 = sc.next();
                    dc.registreer(gebnm, ww, ww2);
                    ingelogd = true;
                } catch (IllegalArgumentException e)
                {
                    if (e.getMessage().equals("wwOngelijk"))
                    {
                        System.out.println(Taal.geefString("getWachtwoordenMoetenGelijkZijn"));
                    } else if (e.getMessage().equals("wwVoorwaarden"))
                    {
                        System.out.println(Taal.geefString("getWachtwoordenMoetenVoldoenAanVoorwaarden"));
                    } else if (e.getMessage().equals("naamBestaat"))
                    {
                        System.out.println(Taal.geefString("getNaamBestaat"));
                    } else if (e.getMessage().equals("naamLeeg"))
                    {
                        System.out.println(Taal.geefString("getNaamLeeg"));
                    }
                }
            } while (!ingelogd);
        }
        //einde UC1
        int keuzeBewaarspel = 0;
        int gekozenSpeler = 0;
        // Maximumkeuze int
        int maximumKeuze = 3;
        System.out.println(Taal.geefString("getWelkom") + ", " + dc.getSpelersNaam());
        System.out.println(Taal.geefString("getAantalUitdagingen") + dc.openstaandeUitdagingen(dc.getSpelerId(dc.getSpelersNaam())));
        do
        {
            try
            {
                System.out.println(Taal.geefString("getWiltU"));
                System.out.println(Taal.geefString("getKlassementMenu"));
                System.out.println(Taal.geefString("getNieuwSpel"));
                System.out.println(Taal.geefString("getLaadSpel"));
                System.out.println(Taal.geefString("getDaagUitSpel"));
                // Kijk of de speler openstaande uitdagingen heeft en als dat zo is geef het menu item ook weer
                if (dc.openstaandeUitdagingen(dc.getSpelerId(dc.getSpelersNaam())) > 0)
                {
                    System.out.println(Taal.geefString("getUitdagingenMenu"));
                    // Maak de maximuKeuze
                    maximumKeuze = 4;
                } else
                {
                    // Maak de maximumKeuze
                    maximumKeuze = 3;
                }
                // De keuze die de gebruiker ingeeft
                keuzeBewaarspel = sc.nextInt();
                // Als het niet tussen 1 of de eerder bepaalde maximumkeuze ligt geef je een error terug
                if (keuzeBewaarspel < 0 || keuzeBewaarspel > maximumKeuze)
                {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e)
            {
                System.out.println(Taal.geefString("getOngeldigeKeuze"));
            }
        } while (keuzeBewaarspel < 0 || keuzeBewaarspel > maximumKeuze);
        if (keuzeBewaarspel == 0)
        {
            int ranking = 1;
            int score = 0;
            for (int[] i : dc.toonKlassement())
            {
                score = (i[1] * 3) - (i[2]);
                System.out.println(ranking + ": " + dc.getSpelerNaamById(i[0]) + ", Score: " + score);
                ranking++;
            }
        } else
        {
            //begin UC2
            int bewaarkeus = 9;
            int[] vergelijkingsResultaat;
            int aantalPinnen;
            int[] gegevenCode;
            int moeilijk = 0;
            if (keuzeBewaarspel == 1)
            {

                System.out.println(Taal.geefString("getKiesMoeilijkheidsgraad"));
                do
                {
                    try
                    {
                        for (String i : dc.getMoeilijkheidsgraadMenu(dc.getGewonnenSpelletjes()))
                        {
                            System.out.println(Taal.geefString(i));
                        }
                        moeilijk = sc.nextInt();
                        if (moeilijk < 1 || moeilijk > dc.getMoeilijkheidsgraadMenu(dc.getGewonnenSpelletjes()).size())
                        {
                            throw new IllegalArgumentException();
                        }
                    } catch (IllegalArgumentException e)
                    {
                        System.out.println(Taal.geefString("getOngeldigeKeuze"));
                    }
                } while (moeilijk < 1 || moeilijk > dc.getMoeilijkheidsgraadMenu(dc.getGewonnenSpelletjes()).size());
                dc.startSpel(moeilijk, ln);
                if (moeilijk == 3)
                {
                    aantalPinnen = 5;
                    gegevenCode = new int[]
                            {
                                    0, 0, 0, 0, 0
                            };
                } else
                {
                    aantalPinnen = 4;
                    gegevenCode = new int[]
                            {
                                    0, 0, 0, 0
                            };
                }
                System.out.println(Taal.geefString("getMoeilijkGezetOp") + dc.getMoeilijkheidsGraadString());
            } else if (keuzeBewaarspel == 2)
            {

                boolean spelOpgeladen = false;
                int gekozenSpel = 0;
                dc.startSpel();
                do
                {
                    try
                    {
                        System.out.println(Taal.geefString("maakUwKeuze"));
                        for (String spel : dc.getBewaardeSpellen())
                        {
                            System.out.println(spel);
                        }
                        gekozenSpel = sc.nextInt();
                        dc.laadSpelOp(gekozenSpel);
                        dc.verwijderSpel(gekozenSpel);
                        spelOpgeladen = true;
                    } catch (Exception exc)
                    {
                        System.out.println(Taal.geefString("getOngeldigeKeuze"));
                    }
                } while (!spelOpgeladen);
                System.out.println(Taal.geefString("gekozenSpelIs") + Taal.geefString("" + dc.getMoeilijkheidsGraadString()));

                if (dc.getMoeilijkheidsGraadString() == Moeilijkheidsgraad.getMoelijkheidsgraad(3))
                {
                    aantalPinnen = 5;
                    gegevenCode = new int[]
                            {
                                    0, 0, 0, 0, 0
                            };
                } else
                {
                    aantalPinnen = 4;
                    gegevenCode = new int[]
                            {
                                    0, 0, 0, 0
                            };
                }
            } else if (keuzeBewaarspel == 4)
            {
                boolean spelgekozen = false;

                // Als de speler voor een uitdaging accepteren kiest
                System.out.println(Taal.geefString("getKiesUitdaging"));
                do
                {
                    try
                    {
                        for (String i : dc.toonUitdagingen(dc.getSpelerId(dc.getSpelersNaam())))
                        {
                            System.out.println(i);
                        }
                        gekozenUitdaging = sc.nextInt();
                        if (!dc.bestaatUitdaging(gekozenUitdaging))
                        {
                            throw new IllegalArgumentException();
                        }
                        spelgekozen = true;
                    } catch (IllegalArgumentException e)
                    {
                        System.out.println(Taal.geefString("getOngeldigeKeuze"));
                    }
                } while (spelgekozen == false);
                moeilijk = dc.getUitdagingMoeilijkheid(gekozenUitdaging);
                dc.verhoogLosses(dc.getSpelerId(dc.getSpelersNaam()));
                dc.verhoogWins(dc.getTegenStanderIdByUitdagingId(gekozenUitdaging));
                dc.startSpel(moeilijk, ln);
                if (moeilijk == 3)
                {
                    aantalPinnen = 5;
                    gegevenCode = new int[]
                            {
                                    0, 0, 0, 0, 0
                            };
                } else
                {
                    aantalPinnen = 4;
                    gegevenCode = new int[]
                            {
                                    0, 0, 0, 0
                            };
                }
                System.out.println(Taal.geefString("getMoeilijkGezetOp") + dc.getMoeilijkheidsGraadString());
            } else
            {
                do
                {
                    try
                    {
                        System.out.println(Taal.geefString("getKiesSpeler"));
                        for (String i : dc.geefSpelers(dc.getSpelersNaam()))
                        {
                            System.out.println(i);
                        }
                        gekozenSpeler = sc.nextInt();
                        if (gekozenSpeler < 0 || !dc.bestaatSpelerById(gekozenSpeler) || gekozenSpeler == dc.getSpelerId(dc.getSpelersNaam()))
                        {
                            throw new IllegalArgumentException();
                        }
                    } catch (IllegalArgumentException e)
                    {
                        System.out.println(Taal.geefString("getOngeldigeKeuze"));
                    }
                } while (gekozenSpeler < 0 || !dc.bestaatSpelerById(gekozenSpeler) || gekozenSpeler == dc.getSpelerId(dc.getSpelersNaam()));
                System.out.println(Taal.geefString("getKiesMoeilijkheidsgraad"));
                do
                {
                    try
                    {

                        for (String i : dc.getMoeilijkheidsgraadMenu(dc.getGewonnenSpelletjes()))
                        {
                            System.out.println(Taal.geefString(i));
                        }
                        moeilijk = sc.nextInt();
                        if (moeilijk < 1 || moeilijk > dc.getMoeilijkheidsgraadMenu(dc.getGewonnenSpelletjes()).size())
                        {
                            throw new IllegalArgumentException();
                        }
                    } catch (IllegalArgumentException e)
                    {
                        System.out.println(Taal.geefString("getOngeldigeKeuze"));
                    }
                } while (moeilijk < 1 || moeilijk > dc.getMoeilijkheidsgraadMenu(dc.getGewonnenSpelletjes()).size());
                dc.startSpel(moeilijk, ln);
                if (moeilijk == 3)
                {
                    aantalPinnen = 5;
                    gegevenCode = new int[]
                            {
                                    0, 0, 0, 0, 0
                            };
                } else
                {
                    aantalPinnen = 4;
                    gegevenCode = new int[]
                            {
                                    0, 0, 0, 0
                            };
                }
                System.out.println(Taal.geefString("getMoeilijkGezetOp") + dc.getMoeilijkheidsGraadString());
            }

            do
            {
                System.out.println(dc.getSpelbord());
                //System.out.println(dc.getJuisteCombinatie());
                int maxmogelijk = 2;
                if (keuzeBewaarspel == 3 || keuzeBewaarspel == 4)
                {
                    maxmogelijk = 1;
                }
                do
                {
                    try
                    {
                        System.out.println("De juiste combinatie is: " + dc.getJuisteCombinatie());
                        System.out.println(Taal.geefString("getSpelenOfBewaren"));
                        System.out.println(Taal.geefString("getSpelen"));
                        if (keuzeBewaarspel < 3)
                        {
                            System.out.println(Taal.geefString("getBewaren"));
                        }
                        bewaarkeus = sc.nextInt();
                        if (bewaarkeus < 1 || bewaarkeus > maxmogelijk)
                        {
                            throw new IllegalArgumentException();
                        }
                    } catch (IllegalArgumentException e)
                    {
                        System.out.println(Taal.geefString("getOngeldigeKeuze"));
                    }
                } while (bewaarkeus < 1 || bewaarkeus > maxmogelijk);
                if (bewaarkeus == 1)
                {
                    System.out.println(Taal.geefString("geefCombMogKleuren") + "\n" + dc.getMogelijkeKleuren());
                    for (int x = 0; x < aantalPinnen; x++)
                    {
                        System.out.println(Taal.geefString("geefKeuze") + (x + 1) + ":");
                        gegevenCode[x] = sc.nextInt();
                    }
                    dc.vergelijkCode(gegevenCode);

                    dc.vulSpelbordrij(gegevenCode);
                    if (aantalPinnen == 5 && dc.getJuistePogingenAantal() == 5)
                    {
                        bewaarkeus = 0;
                        dc.gewonnenSpel(3);
                        System.out.println(Taal.geefString("getUHebtGewonnen"));
                        if (keuzeBewaarspel == 3)
                        {
                            dc.gewonnenUitdaging(gekozenSpeler, dc.getAantalPogingen(), moeilijk);
                        }
                        if (keuzeBewaarspel == 4)
                        {dc.gewonnenGeaccepteerdeUitdaging(gekozenUitdaging, dc.getAantalPogingen());
                            if (dc.getAantalPogingen() < dc.getTegenstanderScore(gekozenUitdaging))
                            {
                                dc.verhoogWins(dc.getSpelerId(dc.getSpelersNaam()));
                                dc.verlaagLosses(dc.getSpelerId(dc.getSpelersNaam()));
                                dc.verhoogLosses(dc.getTegenStanderIdByUitdagingId(gekozenUitdaging));
                                dc.verlaagWins(dc.getTegenStanderIdByUitdagingId(gekozenUitdaging));
                            }
                        }
                    } else if (dc.getJuistePogingenAantal() == 4)
                    {
                        bewaarkeus = 0;
                        if (dc.getMoeilijkheidsGraadString() == Moeilijkheidsgraad.getMoelijkheidsgraad(2))
                        {
                            dc.gewonnenSpel(2);
                            if (keuzeBewaarspel == 3)
                            {
                                dc.gewonnenUitdaging(gekozenSpeler, dc.getAantalPogingen(), moeilijk);
                            }
                            if (keuzeBewaarspel == 4)
                            {
                                dc.gewonnenGeaccepteerdeUitdaging(gekozenUitdaging, dc.getAantalPogingen());
                                if (dc.getAantalPogingen() < dc.getTegenstanderScore(gekozenUitdaging))
                                {
                                    dc.verhoogWins(dc.getSpelerId(dc.getSpelersNaam()));
                                    dc.verlaagLosses(dc.getSpelerId(dc.getSpelersNaam()));
                                    dc.verhoogLosses(dc.getTegenStanderIdByUitdagingId(gekozenUitdaging));
                                    dc.verlaagWins(dc.getTegenStanderIdByUitdagingId(gekozenUitdaging));
                                }
                            }
                        } else
                        {
                            dc.gewonnenSpel(1);
                            if (keuzeBewaarspel == 3)
                            {
                                dc.gewonnenUitdaging(gekozenSpeler, dc.getAantalPogingen(), moeilijk);
                            }
                            if (keuzeBewaarspel == 4)
                            {
                                dc.gewonnenGeaccepteerdeUitdaging(gekozenUitdaging, dc.getAantalPogingen());
                                if (dc.getAantalPogingen() < dc.getTegenstanderScore(gekozenUitdaging))
                                {
                                    dc.verhoogWins(dc.getSpelerId(dc.getSpelersNaam()));
                                    dc.verlaagLosses(dc.getSpelerId(dc.getSpelersNaam()));
                                    dc.verhoogLosses(dc.getTegenStanderIdByUitdagingId(gekozenUitdaging));
                                    dc.verlaagWins(dc.getTegenStanderIdByUitdagingId(gekozenUitdaging));
                                }
                            }
                        }
                        System.out.println(Taal.geefString("getUHebtGewonnen"));
                    }

                }
            } while (bewaarkeus == 1 && dc.getAantalPogingen() < 13);
            if (bewaarkeus == 2)
            {
                boolean spelOpgeslaan = false;
                String naam = "";
                do
                {
                    try
                    {
                        System.out.println(Taal.geefString("geefNaamBewaardeSpel"));
                        naam += sc.next();
                        naam += sc.nextLine();
                        dc.slaSpelOp(naam);
                        spelOpgeslaan = true;
                    } catch (IllegalArgumentException e)
                    {
                        System.out.println(Taal.geefString("naamBestaatAl"));
                    }
                } while (!spelOpgeslaan);

            }
            if (dc.getAantalPogingen() == 13)
            {
                System.out.println(Taal.geefString("getVerloren"));
            }
        }
    }
}
