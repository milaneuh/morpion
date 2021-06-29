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
    static char case9 = '9';
    static String separation = " | ";


    public static void  afficherGrille()
    {
        System.out.println(case1 + separation + case2 + separation + case3);
        System.out.println(case4 + separation + case5 + separation + case6);
        System.out.println(case7 + separation + case8 + separation + case9);
    }

    public static void main(String[] args)
    {
        System.out.println("Bienvenue au morpion de la mort !");
        System.out.println("Voici la grille de jeu");
        afficherGrille();
    }
}