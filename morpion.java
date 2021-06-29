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

            System.out.println(joueur + ", c'est à vous ! \n"+"Veuillez entrer un numéro de case compris entre 1 et 9.");
            int casePlayed = player.nextInt();

            if (casePlayed >= 10 || casePlayed <= 0)
            //Verification de la validité de la case
            {
                System.out.println("Veuillez jouer une case valide");
            }

            switch (casePlayed) {
                case 1:
                    case1 = resultValue;
                    break;
                case 2:
                    case2 = resultValue;
                    break;
                case 3:
                    case3 = resultValue;
                    break;
                case 4:
                    case4 = resultValue;
                    break;
                case 5:
                    case5 = resultValue;
                    break;
                case 6:
                    case6 = resultValue;
                    break;
                case 7:
                    case7 = resultValue;
                    break;
                case 8:
                    case8 = resultValue;
                    break;
                case 9:
                    case9 = resultValue;
                    break;
            }
            System.out.println("Vous avez choisi la case : " + casePlayed);
            afficherGrille();

            //Verification de la victoire, 6 façon de gagner (Ligne ou Diagonales)
            if(case1 == resultValue && case2 == resultValue && case3 == resultValue)
            {
                win = true;
                System.out.println(joueur +", vous avez gagné !! :)");
            }
            else  if (case4 == resultValue && case5 == resultValue && case6 == resultValue)
            {
                win = true;
                System.out.println(joueur +", vous avez gagné !! :)");
            }
            else if (case7 == resultValue && case8 == resultValue && case9 == resultValue)
            {
                win = true;
                System.out.println(joueur +", vous avez gagné !! :)");
            }
            else if (case1 == resultValue && case5 == resultValue && case9 == resultValue)
            {
                win = true;
                System.out.println(joueur +", vous avez gagné !! :)");
            }
            else if (case3 == resultValue && case5 == resultValue && case7 == resultValue)
            {
                win = true;
                System.out.println(joueur +", vous avez gagné !! :)");
            }

            else
            {
                //player.close(); //On ferme le scanner
                turnCount += 1;
            }
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