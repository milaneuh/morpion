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

    public static void play() //Fonction permettant de récupérer la case d'un joueur
    {
        Scanner player = new Scanner(System.in); //Création du Scanner
        int turnCount = 0;
        boolean win = false;
        String joueur = "";
        char resultValue = 'r';

        while (win == false) //On joue tant que on a pas de gagnant
        {
            if(turnCount %2 == 0 || turnCount == 0) //Systeme de joueur 1 et 2
            {
                joueur = "Joueur 1";
                resultValue = 'O';
            }
            else
            {
                joueur = "Joueur 2";
                resultValue = 'X';
            }

            System.out.println(joueur + ", c'est à vous ! \n"+"Veuillez entrer un numéro de case compris entre 1 et 9. \n\n");
            int casePlayed = player.nextInt();

            if (casePlayed >= 10 || casePlayed <= 0)
            //Verification de la validité de la case
            {
                System.out.println("Veuillez jouer une case valide");
            }

            switch (casePlayed) {
                case 1:
                    if (verifierCase(case1))
                    {
                        case1 = resultValue;
                    }
                    break;
                case 2:
                    if (verifierCase(case2))
                    {
                        case2 = resultValue;
                    }
                    break;
                case 3:
                    if (verifierCase(case3))
                    {
                        case3 = resultValue;
                    }
                    break;
                case 4:
                    if (verifierCase(case4))
                    {
                        case4 = resultValue;
                    }
                    break;
                case 5:
                    if (verifierCase(case5))
                    {
                        case5 = resultValue;
                    }
                    break;
                case 6:
                    if (verifierCase(case6))
                    {
                        case6 = resultValue;
                    }
                    break;
                case 7:
                    if (verifierCase(case7))
                    {
                        case7 = resultValue;
                    }
                    break;
                case 8:
                    if (verifierCase(case8))
                    {
                        case8 = resultValue;
                    }
                    break;
                case 9:
                    if (verifierCase(case9))
                    {
                        case9 = resultValue;
                    }
                    break;
            }
            afficherGrille();

            //Verification de la victoire, 6 façon de gagner (Ligne ou Diagonales)
            if(case1 == resultValue && case2 == resultValue && case3 == resultValue ||
                    case4 == resultValue && case5 == resultValue && case6 == resultValue ||
                    case7 == resultValue && case8 == resultValue && case9 == resultValue ||
                    case1 == resultValue && case5 == resultValue && case9 == resultValue ||
                    case3 == resultValue && case5 == resultValue && case7 == resultValue ||
                    case1 == resultValue && case4 == resultValue && case7 == resultValue ||
                    case2 == resultValue && case5 == resultValue && case8 == resultValue ||
                    case3 == resultValue && case6 == resultValue && case9 == resultValue)
            {
                win = true;
                Scanner rejouer = new Scanner(System.in); //Création du Scanner
                System.out.println(joueur +", vous avez gagné !! :) \n Voulez-vous rejouer? [o/n]");
                String yesNo = player.nextLine();
                if(yesNo == "y")
                {
                    play();
                }
                else if (yesNo == "n")
                {
                    System.out.println("Désolé de vous voir partir :(");
                }


            }
            else
            {
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