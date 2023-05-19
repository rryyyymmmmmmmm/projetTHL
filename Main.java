                                        /* ------------------------------------------------------------*
                                         *
                                         *      PROJET DU TEST TP THEORIE DES LANGUAGES 
                                         *      
                                         *      FAIT PAR:
                                         * 
                                         *          - BOUMGHAR Lina Ghizelene A2
                                         *          - LEMMOUCHI Rym A2
                                         *          - SAFAR-REMALI Zineb Farah A3
                                         * 
                                         *      LES CLASSES INCLUSES DANS LE PROJET
                                         *      SONT :
                                         *          - Main          (le programme principal)
                                         *          - LanguageK     (pour générer le language k)
                                         *          - LanguageKR    (pour générer le language kr)
                                         *          - LanguageKN    (pour générer le language kn)
                                         *          - AnalyseSyntax (pour l'analyse syntaxique)
                                         *      
                                         *      TOUT A ETE PRE-COMPILE, IL VOUS SUFFIT 
                                         *      SEULEMENT D'EXECTUER LA COMMANDE :
                                         * 
                                         *                  java -jar projetTHL.jar
                                         *      
                                         *      POUR EXECUTER LE PROGRAMME
                                         *    
                                         * 
                                         *  
                                         *------------------------------------------------------------*/

import java.util.List;
import java.util.Scanner;
/*  |
    |
    ∟==> importation des deux librairies pour manipuler des listes et pouvoir lire l'input de l'utilisateur
*/
    
                                                                                    public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
/*  |
    |
    ∟==> codes ANSI pour changer la couleur des caractères affichés sur la console
*/

    public static boolean inputEstUnEntier(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
                
            } 
        }
        return true;
    }
/*  |
    |
    ∟==> une fonction permettant de vérifier si une chaine de caractères est un entier ou non 
        (on l'utilisera pour pouvoir convertir l'input d'une chaine de caractères à un entier)
*/

    public static void main(String[] args) {
        
        Scanner input_k = new Scanner(System.in);
        String kString;
        Scanner input_n = new Scanner(System.in);
        String nString;
        Scanner input_choix = new Scanner(System.in);
        String choix;
        String motVerif;
        int k;
        int n;

        System.out.print("\033[H\033[2J");
/*      |
        |
        ∟==> une chaine de caractères spéciale pour effacer le contenu de la console
*/
        System.out.println("Ce programme permet de générer les languages Lk, Lkr et Lkn tel que : ");
        System.out.println("");
        System.out.println("Lk : language généré par la grammaire G<T,N,P,S> tel que :  ");
        System.out.println("");
        System.out.println("T={a,b,c}, N={S,A}, P: S -> A/e, A -> aAaa/bbAb/c");
        System.out.println("");
        System.out.println("Lkr : le language mirroir de Lk");
        System.out.println("");
        System.out.println("Lkn : le language puissance n de Lk");
        System.out.println(ANSI_YELLOW + "\nNB : le mot vide 'epsilon' est représenté par un 'e' dans les 3 opérations");
        System.out.println("à part l'operation 'puissance du language', et cela pour une meilleure lecture du language généré" + ANSI_RESET);
        System.out.println("----------------------------------------------");

// la boucle principale du programme pour pouvoir executer plusieurs fonctions sans quitter le programme

        while(true) {
            System.out.println(ANSI_CYAN + "(entrez \"x\" pour quitter le programme)" + ANSI_RESET);
            System.out.println("Pour générer le language L(G) : 1");
            System.out.println("Pour générer le language miroir de L(G) : 2");
            System.out.println("Pour générer le language L^n(G) : 3");
            System.out.println("Pour voir si un mot appartient au language L(G) : 4");
            System.out.println("Quelle operation voulez vous effectuer? : ");

// on utilise une instruction switch-case pour exécuter différentes parties du code en fonction du choix de l'utilisateur.

            choix = input_choix.nextLine();
                  
            switch (choix) {

//premier cas : Génération du langage Lk :
//l'utilisteur choisit la valeur k pour générer le langage Lk.
//la fonction statique genererLanguageK de la classe LanguageK 
//est utilisée pour générer les mots du langage Lk en fonction de la valeur k
// en prenant en compte la condition :  k >= 0 

                case "1":

                    System.out.print("\033[H\033[2J");
                    System.out.println(ANSI_PURPLE + "\tGENERATION DU LANGUAGE LK" + ANSI_RESET);
                    while(true) {

                        System.out.println(ANSI_GREEN + "(entrez \"x\" pour quitter)" + ANSI_RESET + " Veuillez entrer k " + ANSI_YELLOW + "-la taille maximum d'un mot de Lk-" + ANSI_RESET + " tel que k >= 0 : ");
                        kString = input_k.nextLine();
                        if(inputEstUnEntier(kString)) {

                            k = Integer.parseInt(kString);

                            if(k >= 0) {
                                List<String> motsLanguageK = LanguageK.genererLanguageK(k);
                                for (String mot : motsLanguageK) {
                                    System.out.print(mot + " - ");
                                } 
                                System.out.println("");
                        
                            } 
                        }  else if (kString.equals("x")) {
                            System.out.print("\033[H\033[2J");
                            break;                    
                        } 

                }

                break;

//deuxieme cas : Génération du langage miroir Lkr :
//L'utilisateur choisit la valeur k pour générer le langage miroir Lkr.
//la fonction statique genererLanguageKR de la classe LanguageKR est 
//utilisée pour générer les mots du langage miroir Lkr en fonction de la valeur k
// en prenant en compte la condition :  k >= 0 

                case "2":
                    
                    System.out.print("\033[H\033[2J");
                    System.out.println(ANSI_PURPLE + "\tGENERATION DU LANGUAGE MIRROIR LKR" + ANSI_RESET);

                    while(true) {

                        System.out.println(ANSI_CYAN + "(entrez \"x\" pour quitter)"+ANSI_RESET+"\nVeuillez entrer k " + ANSI_YELLOW + "-la taille maximum d'un mot de Lkr-" + ANSI_RESET + " tel que k >= 0 : ");
                        kString = input_k.nextLine();
                        
                        if(inputEstUnEntier(kString)) {

                            k = Integer.parseInt(kString);

                            if(k >= 0) {
                                List<String> motsLanguageKR = LanguageKR.genererLanguageKR(k);
                                for (String mot : motsLanguageKR) {
                                    System.out.print(mot + " - ");
                                }
                                System.out.println("");

                            } 
                        }  else if (kString.equals("x")) {
                            System.out.print("\033[H\033[2J");
                            break;                    
                        } 

                }

                    

                break;


//troisieme cas: Génération du langage puissance Lkn :
//L'utilisateur choisit les valeurs k et n pour générer le langage puissance Lkn.
//la fonction statique genererLanguageKN de la classe LanguageKN est utilisée pour 
//générer les mots du langage puissance Lkn en fonction des valeurs k et n
// en prenant en compte les conditions :  k >= 0 et n >= 0 

                case "3":

                System.out.print("\033[H\033[2J");

                System.out.println(ANSI_PURPLE + "\tGENERATION DU LANGUAGE PUISSANCE LKN" + ANSI_RESET);

                while(true) {
                    System.out.println(ANSI_CYAN + "(entrez \"x\" pour quitter)"+ ANSI_RESET+"\nVeuillez entrer k " + ANSI_YELLOW + "-la taille maximum d'un mot de Lk-" + ANSI_RESET + " tel que k >= 0 : ");
                    kString = input_k.nextLine();

                    if(kString.equals("x")) {
                        System.out.print("\033[H\033[2J");
                        break;
                    } 

                    if(inputEstUnEntier(kString)) {

                        k = Integer.parseInt(kString);

                        if(k >= 0) {

                            System.out.println("Veuillez entrer n" + ANSI_YELLOW + " -la puissance de Lk- " + ANSI_RESET + "tel que n >= 0 : ");
                            nString = input_n.nextLine(); 

                            if(nString.equals("x")) {
                                System.out.print("\033[H\033[2J");
                                break;
                            } 
                            if(inputEstUnEntier(nString)) {

                                n = Integer.parseInt(nString);

                                if(n >= 0 && k >= 0) {
                                    List<String> motsLanguageKN = LanguageKN.genererLanguageKN(k, n);
                                    System.out.println("Les mots du language Lkn: ");
                                    for (String mot : motsLanguageKN) {
                                        System.out.print(mot + " - ");
                                    }
                                } 
                                else {
                                    System.out.print("\033[H\033[2J");
                                }               
                            }

                        }
                    }
                }
                break;

//quatrieme cas : Vérification si un mot appartient au langage Lk :
//L'utilisateur entre un mot pour vérifier s'il appartient au langage Lk. 
//la fonction statique analyseSyntaxique de la classe AnalyseSyntax est 
//utilisée pour analyser syntaxiquement le mot et déterminer s'il appartient 
//au langage Lk ensuite un message est affiché pour indiquer si le mot appartient ou non au langage.

                case "4":

                System.out.print("\033[H\033[2J");

                    do {            
                        System.out.println(ANSI_CYAN + "(entrez \"x\" pour quitter)"+ANSI_RESET+"\nVeuillez entrer le mot à vérifier : ");
                        motVerif = input_choix.nextLine();
                        if(AnalyseSyntax.analyseSyntaxique(motVerif)) {
                            System.out.println("Ce mot" + ANSI_GREEN + " appartient" + ANSI_RESET + " au language L(G).");
                        } else {
                            System.out.println("Ce mot" + ANSI_RED + " n'appartient pas " + ANSI_RESET +"au language L(G).");
                        }
                    } while (!motVerif.contentEquals("x"));
                    System.out.print("\033[H\033[2J");
                            
                break;

// cas spécial pour si l'utilisateur rentre x, on quitte le programme

                case "x":
                    input_choix.close();
                    input_k.close();
                    input_n.close();
                return;

// cas où la valeur entrée par l'utilisateur n'est pas une option du programme, ce dernier affiche se message et se réexecute

                default:
                    System.out.println(ANSI_RED + "l'option entrée n'est pas valide" + ANSI_RESET);
                break;
            }
        }
        
  
    }

}
