import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DiversesMethodesSurDesTableauxTest {


    @Test
    public final void testNbOccurrences() {

        assertEquals (0, DiversesMethodesSurDesTableaux.nbOccurrences(new int[0], 12), "cas tableau longueur 0");

        int[] tab12PasPrésent = {2,3,-7,13,22,0};
        assertEquals (0, DiversesMethodesSurDesTableaux.nbOccurrences(tab12PasPrésent, 12), "cas tableau longueur > 0, val pas présente");

        // On prend bien garde de tester la prise en compte de la première case et de la dernière case du tableau.
        int[] tab12Présent = {12,3,12,13,0,22,12};
        assertEquals (3, DiversesMethodesSurDesTableaux.nbOccurrences(tab12Présent, 12), "cas tableau longueur > 0, val présente");

    }

    @Test
    public final void testNbStrictementNégatifs() {

        assertEquals (0, DiversesMethodesSurDesTableaux.nbStrictementNégatifs(new int[0]), "cas tableau longueur 0");

        int[] pasDeNégatifs = {2,3,7,13,22,0};
        assertEquals (0, DiversesMethodesSurDesTableaux.nbStrictementNégatifs(pasDeNégatifs), "cas tableau longueur > 0, pas de négatifs");

        // On prend bien garde de tester la prise en compte de la première case et de la dernière case du tableau.
        int[] desNégatifst = {-12,3,12,-13,0,22,-12};
        assertEquals (3, DiversesMethodesSurDesTableaux.nbStrictementNégatifs(desNégatifst), "cas tableau longueur > 0, plusieurs négatifs");

    }

    @Test
    public final void testSommeValeurs() {

        assertEquals (0, DiversesMethodesSurDesTableaux.sommeValeurs(new int[0]), "cas tableau longueur 0");

        int[] tabMoyen = {12,3,12,-13,0,22};
        assertEquals (36, DiversesMethodesSurDesTableaux.sommeValeurs(tabMoyen), "cas moyen");

    }

    @Test
    public final void testEstPrésent() {

        assertFalse (DiversesMethodesSurDesTableaux.estPrésent(new int[0], 12), "cas tableau longueur 0");

        int[] tab12PasPrésent = {2,3,-7,13,22,0};
        assertFalse (DiversesMethodesSurDesTableaux.estPrésent(tab12PasPrésent, 12), "cas tableau longueur > 0, val pas présente");

        int[] tab12En1èrePosition = {12,3,-7,13,0,22};
        assertTrue (DiversesMethodesSurDesTableaux.estPrésent(tab12En1èrePosition, 12), "cas tableau longueur > 0, val en indice 0");

        int[] tab12EnDernièrePosition = {22,3,-7,13,0,12};
        assertTrue (DiversesMethodesSurDesTableaux.estPrésent(tab12EnDernièrePosition, 12), "cas tableau longueur > 0, val en dernier indice");

        int[] tab12EnPositionMoyenne = {22,3,-7,12,0,-12};
        assertTrue (DiversesMethodesSurDesTableaux.estPrésent(tab12EnPositionMoyenne, 12), "cas tableau longueur > 0, val en position moyenne");

    }

    @Test
    public final void testTousPositifs() {

        assertTrue (DiversesMethodesSurDesTableaux.tousPositifs(new int[0]), "cas tableau longueur 0");

        int[] tabMoyenFaux = {2,0,-7,13,22,0};
        assertFalse (DiversesMethodesSurDesTableaux.tousPositifs(tabMoyenFaux), "cas tableau longueur > 0, faux");

        int[] tabMoyenVrai = {2,0,7,13,22,0};
        assertTrue (DiversesMethodesSurDesTableaux.tousPositifs(tabMoyenVrai), "cas tableau longueur > 0, vrai");

        int[] tabNegEn1èrePosition = {-12,3,7,13,0,22};
        assertFalse (DiversesMethodesSurDesTableaux.tousPositifs(tabNegEn1èrePosition), "cas tableau longueur > 0, négatif en indice 0");

        int[] tabNegEnDernièrePosition = {22,3,7,13,0,-12};
        assertFalse (DiversesMethodesSurDesTableaux.tousPositifs(tabNegEnDernièrePosition), "cas tableau longueur > 0, val en dernier indice");

    }

    @Test
    public final void testIndicePremOccurrence() {

        assertEquals(-1, DiversesMethodesSurDesTableaux.indicePremOccurrence(new int[0], 12), "cas tableau longueur 0");

        int[] tab12PasPrésent = {2,3,-7,13,22,0};
        assertEquals (-1, DiversesMethodesSurDesTableaux.indicePremOccurrence(tab12PasPrésent, 12), "cas tableau longueur > 0, val pas présente");

        int[] tab12En1èrePosition = {12,3,-7,12,0,22};
        assertEquals (0, DiversesMethodesSurDesTableaux.indicePremOccurrence(tab12En1èrePosition, 12), "cas tableau longueur > 0, val en indice 0");

        int[] tab12EnDernièrePosition = {22,3,-7,13,0,12};
        assertEquals (5, DiversesMethodesSurDesTableaux.indicePremOccurrence(tab12EnDernièrePosition, 12), "cas tableau longueur > 0, val en dernier indice");

        int[] tab12EnPositionMoyenne = {22,3,-7,12,0,12, 12};
        assertEquals (3, DiversesMethodesSurDesTableaux.indicePremOccurrence(tab12EnPositionMoyenne, 12), "cas tableau longueur > 0, val en position moyenne");

    }


    @Test
    public final void testPlusGrandPositif() {

        assertEquals (-1.0, DiversesMethodesSurDesTableaux.plusGrandPositif(new double[0]), 0.0, "cas tableau longueur 0");

        double[] queNégatifs = {-2,-3,-7.7,-13,-22.3,-7};
        assertEquals (-1.0, DiversesMethodesSurDesTableaux.plusGrandPositif(queNégatifs),0.0, "cas tableau longueur > 0, que des négatifs");

        double[] maxEnPremier = {22.4,-3.9,-7,13,-22,18.6};
        assertEquals (22.4, DiversesMethodesSurDesTableaux.plusGrandPositif(maxEnPremier),0.0, "cas tableau longueur > 0, maximum en premier");

        double[] maxEnDernier = {12.4,-3.9,-7,13,-22,18.6};
        assertEquals (18.6, DiversesMethodesSurDesTableaux.plusGrandPositif(maxEnDernier),0.0, "cas tableau longueur > 0, maximum en dernier");

        double[] maxAuMilieuEtMax0 = {-22.4,-3.9,-7,0.0,-22,-18.6};
        assertEquals (0.0, DiversesMethodesSurDesTableaux.plusGrandPositif(maxAuMilieuEtMax0),0.0, "cas tableau longueur > 0, position moyenne, maximum = zéro");

    }

}
