package DAO;

import Modele.Article;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArticleDAO articleDAO = new ArticleDAO();

        System.out.println("🆕 Ajouter un article");

        System.out.print("➡️ ID de l'article : ");
        int id = scanner.nextInt();
        scanner.nextLine(); // pour consommer le retour à la ligne

        System.out.print("➡️ Nom de l'article : ");
        String nom = scanner.nextLine();

        System.out.print("➡️ Nom de la marque (affichage seulement) : ");
        String nomMarque = scanner.nextLine();

        System.out.print("➡️ Prix unitaire : ");
        float prixUnitaire = scanner.nextFloat();

        System.out.print("➡️ Prix gros (0 si aucun) : ");
        float prixGrosInput = scanner.nextFloat();
        Float prixGros = (prixGrosInput > 0) ? prixGrosInput : null;

        System.out.print("➡️ Quantité pour le prix gros (0 si aucun) : ");
        int qteGrosInput = scanner.nextInt();
        Integer quantiteGros = (qteGrosInput > 0) ? qteGrosInput : null;

        System.out.print("➡️ ID de la marque (clé étrangère) : ");
        int idMarque = scanner.nextInt();

        Article article = new Article(id, nom, nomMarque, prixUnitaire, prixGros, quantiteGros, idMarque);
        articleDAO.insertArticle(article);

        scanner.close();
    }
}
