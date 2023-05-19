import java.util.Stack;

public class AnalyseSyntax{

    //      l'idée est de créer une pile qu'on empile avec chaque caractère du mot à vérifier, et qu'on ne 
    //      commencera à dépiler que si le caractère 'c' est présent, tel que :
    //          pour chaque "aa" trouvé après 'c', on dépile un seul 'a'
    //          pour chaque "b" trouvé après 'c', on dépile "bb"
    //      la fonction analyseSyntaxique renvoie une valeure booléenne qui représente si la pile 
    //      est vide ou non
    //          si elle l'est, alors le dépilement pour chaque occurences de 'a's et de 'b's a été éffectué avec succès
    //          et le mot appartient au language.
    //          sinon, ce dépilement n'a pas été effectué avec succès, et le mot n'appartient pas au language

    public static boolean analyseSyntaxique(String mot) { 
        
        if (mot.equals("") || mot.equals("e")) {
            return true; 
            
            //      Si le mot est une chaîne vide ou égale à "e" (epsilon), 
            //      cela signifie qu'il est valide pour le langage Lk. La méthode retourne true dans ces cas.
        
        } else { 

            int i = 0;
            int length = mot.length();
            
            Stack<Character> pile = new Stack<>();
            
            //      La variable "length" est initialisée avec la longueur du mot.
            //      Une pile (Stack) est utilisée pour effectuer une analyse syntaxique.
            
            while (i < mot.length() && mot.charAt(i) != 'c') {
                pile.push(mot.charAt(i));
                i++;
            }
            //      parcourt le mot jusqu'à trouver la première occurrence de la lettre 'c' et tout les caractere avant sont empiles dans la pile. 
            //      L'index est incrémenté après chaque caractère ajouté à la pile.
            
            i++;
            
            //      Une fois que la lettre 'c' est trouvée, l'index est incrémenté pour ignorer cette lettre
            
            while (i < length) {

                if(pile.isEmpty()) return false;
                
                if (mot.charAt(i) == 'a' && i+1 < length) {
                    if(mot.charAt(i + 1) == 'a') { 
                        if (!pile.isEmpty() && pile.peek() == 'a') {
                            pile.pop();
                            i++; 

//                  si le caractère courant est 'a' et le caractère suivant est également 'a',
//                  (cette vérification est faire dans deux if séparés pour éviter les problèmes où i + 1 dépasse la taille de 
//                  la chaîne de caractères), cela signifie que "aa" est présent.
//                  on vérifie alors si la pile n'est pas vide et que le sommet de la pile est 'a'. 
//                  Dans ce cas, on dépile le "a" et l'index est incrémenté pour ignorer le prochain caractère (étant le deuxieme "a"),
//                  sinon, le mot n'appartient pas au language.

                        } else {
                            return false;
                        }
                    }
                } else if (mot.charAt(i) == 'b') {
                    if (!pile.isEmpty() && pile.peek() == 'b') {
                        pile.pop();
                        if (!pile.isEmpty() && pile.peek() == 'b') {
                            pile.pop();
                        } else {
                            return false;
                        }
//                  Si le caractère courant est 'b', on vérifie si la pile n'est pas vide et que le sommet de la pile est 
//                  également 'b'. Si c'est le cas, ce 'b' dépilé. Ensuite, on vérifie à nouveau si la pile n'est pas vide
//                  et que le nouveau sommet est 'b'. Si oui, le sommet est supprimé de nouveau.
//                  Si à tout moment l'une de ces conditions n'est pas satisfaite, on retourne false car le mot 
//                  n'appartient pas au language.
                        
                    } else {
                        return false;
                    }
                }
                i++;

            }
            return pile.isEmpty();
        }
//                  Si la pile est vide, cela signifie que tous les caractères ont été correctement appariés et que le mot appartient au langage Lk.
//                  Sinon le mot n'appartiens pas au langage lk.
    }
    
   
}