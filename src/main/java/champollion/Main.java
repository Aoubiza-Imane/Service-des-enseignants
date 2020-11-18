package champollion;

public class Main {
    public static void main(String[] args) {
        Enseignant bastide = new Enseignant("Rémi Bastide", "Remi.Bastide@irit.fr");
        Enseignant lamine  = new Enseignant("Elyes Lamine", "Elyes.Lamine@univ-jfc.fr");
        
        UE uml = new UE("Conception par objets avec UML");
        UE bd  = new UE("Bases de données");
        UE web = new UE("Technologies web");
        
        bastide.ajouteEnseignement(uml, 12, 20, 20);
        bastide.ajouteEnseignement(web,  8, 20, 30);
        lamine.ajouteEnseignement(bd,   10, 20, 15);
        lamine.ajouteEnseignement(web,  15, 15, 25);

        System.out.printf("Mr. %s a un total de %.2f heures prévues\n", bastide.getNom(), bastide.heuresPrevues());
        System.out.printf("Mr. %s a un total de %.2f heures prévues\n",  lamine.getNom(),  lamine.heuresPrevues());
        System.out.printf("Mr. %s a un total de %.2f heures prévues dans l'UE %s\n", 
                bastide.getNom(), 
                bastide.heuresPrevuesPourUE(uml),
                uml.getIntitule()
        );
        
        
    }
    
}
