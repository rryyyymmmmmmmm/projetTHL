import java.util.List;
import java.util.ArrayList;

public class LanguageKN {

//          ici deux listes de mots sont crées: puissance (la liste de mots qui resulte) et interm vidée (une liste intermédiaire pour nos calculs).
//          on verifie si n == 0 pour générer le language qui contient le mot vide.
//          la boucle for parcourt chaque mot dans motsLanguage et l'ajoute à la liste puissance.
//          Une autre boucle for pour l'itération de 2 à n. (si le n == 1, la boucle ne s'execute pas
//          et le language puissance ne sera que le language lui même).
//          Une autre boucle for parcourt chaque mot dans la liste puissance.
//          Une boucle for parcourt chaque mot dans motsLanguage.
//          Un nouveau mot concaténé est crée en ajoutant motPuiss et mot ensemble.
//          La chaîne "e" (mot vide) est supprimée du mot concaténé à l'aide de la méthode replace (pour faciliter la lecture).
//          Le mot concaténé est ajouté à la liste interm et on vide la liste puissance.
//          Une boucle for parcourt chaque mot dans la liste interm et l'ajoute à la liste puissance.
//          Après avoir terminé la derniere boucle, la liste puissance contiendera les mots résultants de la puissance du langage initial.


    public static List<String> puissanceLanguage(List<String> motsLanguage, int n) {
        List<String> puissance = new ArrayList<>(); 
        List<String> interm = new ArrayList<>(); 
        
        if(n == 0) {
            puissance.add("");
            return puissance;
        }

        for(String mot : motsLanguage) {
            puissance.add(mot);
        }

        for(int i = 2; i <= n; i++) {
            interm.clear();
            for(String motPuiss : puissance) {
                for(String mot : motsLanguage) {
                    String concatMot = new String();
                    concatMot = concatMot.concat(motPuiss + mot);
                    concatMot = concatMot.replace("e", "");
                    interm.add(concatMot);
                }
            }
            puissance.clear();
            for(String mot : interm) {
                puissance.add(mot);
            }
        }
        return puissance;
    }

//          Une liste de mots, motsDuLanguageK, est générée en appelant la méthode genererLanguageK de la classe LanguageK
//          puissanceLanguage est ensuite appelée avec les paramètres motsDuLanguageK et n pour obtenir la puissance du langage initial.
//          La liste de mots résultante est renvoyée.

    public static List<String> genererLanguageKN(int k, int n) {

        List<String> motsDuLanguageK = LanguageK.genererLanguageK(k);
        return puissanceLanguage(motsDuLanguageK, n);        


    }

}
