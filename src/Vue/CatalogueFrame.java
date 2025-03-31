package Vue;

import DAO.ArticleDAO;
import Modele.Article;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class CatalogueFrame extends JFrame {

    private JTable tableArticles;
    private ArticleDAO articleDAO;

    public CatalogueFrame() {
        articleDAO = new ArticleDAO();
        setTitle("🛒 Catalogue des Articles");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // PANEL PRINCIPAL
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(new EmptyBorder(15, 15, 15, 15));
        panelPrincipal.setBackground(Color.WHITE);
        setContentPane(panelPrincipal);

        // TITRE
        JLabel titre = new JLabel("Catalogue des Articles");
        titre.setFont(new Font("Arial", Font.BOLD, 24));
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        titre.setBorder(new EmptyBorder(10, 0, 20, 0));
        panelPrincipal.add(titre, BorderLayout.NORTH);

        // TABLE
        String[] colonnes = {"ID", "Nom", "Marque", "Prix Unitaire (€)", "Prix Gros (€)", "Quantité Gros", "ID Marque"};
        DefaultTableModel model = new DefaultTableModel(colonnes, 0);

        List<Article> articles = articleDAO.getAllArticles();
        for (Article article : articles) {
            Object[] ligne = {
                    article.getId(),
                    article.getNom(),
                    article.getMarque(),
                    article.getPrixUnitaire(),
                    article.getPrixGros() != null ? article.getPrixGros() : "-",
                    article.getQuantiteGros() != null ? article.getQuantiteGros() : "-",
                    article.getIdMarque()
            };
            model.addRow(ligne);
        }

        tableArticles = new JTable(model);
        tableArticles.setRowHeight(25);
        tableArticles.setFont(new Font("Arial", Font.PLAIN, 14));
        tableArticles.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        JScrollPane scrollPane = new JScrollPane(tableArticles);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        panelPrincipal.add(scrollPane, BorderLayout.CENTER);

        // BOUTON FERMER
        JButton btnFermer = new JButton("Fermer");
        btnFermer.setFont(new Font("Arial", Font.PLAIN, 14));
        btnFermer.addActionListener(e -> dispose());

        JPanel panelBas = new JPanel();
        panelBas.setBackground(Color.WHITE);
        panelBas.add(btnFermer);

        panelPrincipal.add(panelBas, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CatalogueFrame().setVisible(true));
    }
}
