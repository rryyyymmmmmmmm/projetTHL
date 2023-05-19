import java.util.ArrayList;
import java.util.List;

public class LanguageK {

//          Le mot vide est ajouté à la liste de mots motsLanguageK ensuite on appele la méthode récursive "genererRecursifLanguageK":
//          genererRecursifLanguageK est appelée avec les paramètres "c" (motGen), k et motsLanguageK. 
//          Elle generera récursivement d'autres mots pour la liste motsLanguageK.

    public static List<String> genererLanguageK(int k) {

        List<String> motsLanguageK = new ArrayList<>();
        
        motsLanguageK.add("e");
        genererRecursifLanguageK("c", k, motsLanguageK);
        
        return motsLanguageK;
        
    }
    
//          on prend en entrée le mot généré actuel (motGen), la valeur k et la liste de mots (mots) à remplir.
//          cas d'arret : la longueur du mot généré dépasse k.
//          Si la longueur de motGen est inférieure ou égale à k, le motGen est ajouté à la liste mots.
//          Si la longueur de motGen plus 3 est inférieure ou égale à k (le cas ou on peut généréer le mot),
//          la méthode genererRecursifLanguageKR est appelée récursivement deux fois
//          pour généréer toutes les variations possibles : "a" + motGen + "aa" et "bb" + motGen + "b".
    
    private static void genererRecursifLanguageK(String motGen, int k, List<String> mots) {

        if (motGen.length() > k) {
            return;
        }

        if (motGen.length() <= k) {     
            mots.add(motGen);
        }

        if (motGen.length() + 3 <= k) {
            genererRecursifLanguageK("a" + motGen + "aa", k, mots);
            genererRecursifLanguageK("bb"+ motGen + "b", k, mots);
        }

    }
}
