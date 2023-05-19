import java.util.ArrayList;
import java.util.List;

public class LanguageKR {
    
    // la fonction pour générer le mirroir d'un mot (qu'on va utiliser pour générer le language mirroir).
    // on utilise une boucle pour parcourir le mot de la fin au début et concatène chaque caractère à la chaîne miroir.    
    
    public static String mirroirMot(String mot) {
        String mirroir = "";
        for(int i=mot.length()-1; i>=0; i--) {
            mirroir = mirroir.concat(Character.toString(mot.charAt(i)));
        }
        return mirroir;   

    }
    // La longueur maximale des mots générés est définie par la valeur k fournie à la méthode genererLanguageKR. 

    // le language inclut le mot vide, on l'ajoute donc en premier, et on utilisera 'c' pour générer tous les autres mots du language.
    // la fonction de génération prend un entier k en entrée et elle renvoie une liste de mots (motsLanguageKR) correspondant au language
    // en utilisant la fonction recursive genererRecursifLanguageKR().
    
    public static List<String> genererLanguageKR(int k) {

        List<String> motsLanguageKR = new ArrayList<>();
        motsLanguageKR.add("e");
        genererRecursifLanguageKR("c", k, motsLanguageKR);
        return motsLanguageKR;

    //on prend en entrée le mot généré actuel (motGen), la valeur k et la liste de mots (mots) à remplir.
    // cas d'arret : la longueur du mot généré dépasse k.
    // Si la longueur de motGen est inférieure ou égale à k, le mot mirroir de motGen est ajouté à la liste mots.
    // Si la longueur de motGen plus 3 est inférieure ou égale à k (le cas ou on peut généréer le mot),
    // la méthode genererRecursifLanguageKR est appelée récursivement deux fois
    // pour généréer toutes les variations possibles : "a" + motGen + "aa" et "bb" + motGen + "b".
    }
    private static void genererRecursifLanguageKR(String motGen, int k, List<String> mots) {

        if (motGen.length() > k) {
            return;
        }

        if (motGen.length() <= k) { 
            mots.add(mirroirMot(motGen));
        }

        if (motGen.length() + 3 <= k) {
            genererRecursifLanguageKR("a" + motGen + "aa", k, mots);
            genererRecursifLanguageKR("bb"+ motGen + "b", k, mots);
        }

    }
}