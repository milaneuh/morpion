import java.util.Scanner;

public class morpion
{
    static char case1 = '1';
    static char case2 = '2';
    static char case3 = '3';
    static char case4 = '4';
    static char case5 = '5';
    static char case6 = '6';
    static char case7 = '7';
    static char case8 = '8';
    static char  case9 = '9';
    static String separation = " | ";


    public static void  afficherGrille()
    {
        System.out.println(case1 + separation + case2 + separation + case3);
        System.out.println(case4 + separation + case5 + separation + case6);
        System.out.println(case7 + separation + case8 + separation + case9);
    }

    public static int choseGame(){
        Scanner choser = new Scanner(System.in);
        System.out.println("Comment voulez-vous jouer ? J vs J ( 0 ) ? J vs Ia ( 1 ) ? Ia vs Ia  ( 2 )?");
        int chosenGame = choser.nextInt();
        return  chosenGame;
    }

    public static void play() //Fonction permettant de récupérer la case d'un joueur
    {
        Scanner player = new Scanner(System.in); //Création du Scanner
        int turnCount = 0;
        boolean win = false;
        String joueur = "";
        char resultValue = 'r';
        int gameMode = choseGame();
        System.out.println("Vous avez choisi :" + gameMode);
        while (!win) //On joue tant que on a pas de gagnant
        {
            boolean rejouer = false;
            if (turnCount % 2 == 0) //Systeme de joueur 1 et 2
            {
                if (gameMode == 0 || gameMode == 1) {
                    joueur = "Joueur 2";
                } else {
                    joueur = "IA Joueur 1";
                }
                resultValue = 'O';
            } else {
                if (gameMode == 0) {
                    joueur = "Joueur 2";
                } else {
                    joueur = "IA Joueur 2";
                }
                resultValue = 'X';
            }

            int casePlayed = 0;
            if (gameMode == 0 || gameMode == 1 && turnCount % 2 == 0) {
                System.out.println(joueur + ", c'est à vous ! \n" + "Veuillez entrer un numéro de case compris entre 1 et 9. \n\n");
                casePlayed = player.nextInt();
                if (casePlayed >= 10 || casePlayed <= 0)
                //Verification de la validité de la case
                {
                    System.out.println("Veuillez jouer une case valide");
                }
            } else {
                //Trouver une valeur de casePlayed en aléatoire
                System.out.println("C'est au tour de l'"+joueur+". \n");
                casePlayed = (int) (Math.random() * 8.5) + 1;
            }

            switch (casePlayed) {
                case 1:
                    if (verifierCase(case1)) {
                        case1 = resultValue;
                    }
                    else
                    {
                        rejouer = true;
                    }
                    break;
                case 2:
                    if (verifierCase(case2)) {
                        case2 = resultValue;
                    }
                    else
                    {
                        rejouer = true;
                    }
                    break;
                case 3:
                    if (verifierCase(case3)) {
                        case3 = resultValue;
                    }
                    else
                    {
                        rejouer = true;
                    }
                    break;
                case 4:
                    if (verifierCase(case4)) {
                        case4 = resultValue;
                    }
                    else
                    {
                        rejouer = true;
                    }
                    break;
                case 5:
                    if (verifierCase(case5)) {
                        case5 = resultValue;
                    }
                    else
                    {
                        rejouer = true;
                    }
                    break;
                case 6:
                    if (verifierCase(case6)) {
                        case6 = resultValue;
                    }
                    else
                    {
                        rejouer = true;
                    }
                    break;
                case 7:
                    if (verifierCase(case7)) {
                        case7 = resultValue;
                    }
                    else
                    {
                        rejouer = true;
                    }
                    break;
                case 8:
                    if (verifierCase(case8)) {
                        case8 = resultValue;
                    }
                    else
                    {
                        rejouer = true;
                    }
                    break;
                case 9:
                    if (verifierCase(case9)) {
                        case9 = resultValue;
                    }
                    else
                    {
                        rejouer = true;
                    }
                    break;
            }


            afficherGrille();

            //Verification de la victoire, 6 façon de gagner (Ligne ou Diagonales)
            if (case1 == resultValue && case2 == resultValue && case3 == resultValue ||
                    case4 == resultValue && case5 == resultValue && case6 == resultValue ||
                    case7 == resultValue && case8 == resultValue && case9 == resultValue ||
                    case1 == resultValue && case5 == resultValue && case9 == resultValue ||
                    case3 == resultValue && case5 == resultValue && case7 == resultValue ||
                    case1 == resultValue && case4 == resultValue && case7 == resultValue ||
                    case2 == resultValue && case5 == resultValue && case8 == resultValue ||
                    case3 == resultValue && case6 == resultValue && case9 == resultValue) {
                win = true;
                Scanner newGame = new Scanner(System.in); //Création du Scanner
                System.out.println(joueur + ", vous avez gagné !! :) \n Voulez-vous rejouer? [o/n]");
                String yesNo = newGame.nextLine();
                if (yesNo == "y") {
                    play();
                } else if (yesNo == "n") {
                    System.out.println("Désolé de vous voir partir :(");
                }


            } else if (!rejouer) {
                //player.close(); //On ferme le scanner
                turnCount += 1;
            }
        }
        }



    public static boolean verifierCase(char caseAVerifier) //fonction vérifiant si les cases sont déjà remplis
    {
        if (caseAVerifier == 'X' || caseAVerifier == 'O')
        {
            System.out.println("Cette case est déjà remplis");
            return false;
        }
        else
        {
            return true;
        }
    }

    public static void main(String[] args)
    {
        System.out.println("Bienvenue au morpion de la mort !");
        System.out.println("Voici la grille de jeu");
        afficherGrille();
        play();
    }
}