
package rmiClient;

import metier.Compte;
import rmiService.IBanque;

import java.rmi.Naming;

public class BanqueClient {

    public static void main(String[] args) {

        try {
            // Rechercher le service distant
            IBanque banque = (IBanque)
                    Naming.lookup("rmi://localhost:1099/Banque");

            // Créer un compte bancaire
            Compte c = new Compte(1, 5000);

            // Appeler la méthode distante
            String resultat = banque.creerCompte(c);
            System.out.println(resultat);

            // Rechercher les informations du compte
            String info = banque.getInfoCompte(1);
            System.out.println(info);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
