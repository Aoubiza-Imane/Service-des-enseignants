package champollion;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {

    Enseignant untel;
    UE uml, java;
    Salle b101;
    Intervention cours;
    Date d;

    @BeforeEach
    public void setUp() {
        untel = new Enseignant("untel", "untel@gmail.com");
        uml = new UE("UML");
        java = new UE("Programmation en java");
        b101 = new Salle("B101", 45);
        d = new Date(2019,06,02);
        cours = new Intervention(b101, uml, untel,d , 4, TypeIntervention.CM);
    }

    @Test
    public void testNouvelEnseignantSansService() {
        assertEquals(0, untel.heuresPrevues(),
                "Un nouvel enseignant doit avoir 0 heures prévues");
    }

    @Test
    public void testAjouteHeures() {
        // 10h TD pour UML
        untel.ajouteEnseignement(uml, 0, 10, 0);

        assertEquals(10, untel.heuresPrevuesPourUE(uml),
                "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

        // 20h TD pour UML
        untel.ajouteEnseignement(uml, 0, 20, 0);

        assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");

    }

    @Test
    public void testAjouteIntervention() {
        untel.ajouteIntervention(cours);
        //Je ne sais pas comment tester l'ajout dans une liste.
    }

    @Test
    public void testHeuresPlanifiees() {
        untel.ajouteIntervention(cours);
        assertEquals(cours.getDuree(), untel.heuresPlanifiees(), "L'intervention n'a pas été ajoutée");
    }

    @Test
    public void testEnSousService() {
        untel.ajouteIntervention(cours);
        untel.ajouteEnseignement(uml, 8, 4, 6);
        assertTrue(untel.enSousService());
    }

}
