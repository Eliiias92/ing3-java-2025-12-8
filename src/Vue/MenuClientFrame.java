package Vue;

import Modele.Client;

import javax.swing.*;
import java.awt.*;

public class MenuClientFrame extends JFrame {

    private Client client;  // pour garder l'ID et les infos du client

    public MenuClientFrame(Client client) {
        this.client = client;
        setTitle("Espace Client - Bienvenue " + client.getNom());
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 1, 15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel labelBienvenue = new JLabel("Bienvenue dans votre espace client, " + client.getNom(), JLabel.CENTER);
        panel.add(labelBienvenue);

        JButton btnCatalogue = new JButton("🛍️ Voir le catalogue");
        btnCatalogue.addActionListener(e -> {
            // ici plus tard tu ouvriras la fenêtre Catalogue Client
            JOptionPane.showMessageDialog(this, "Catalogue à venir !");
        });
        panel.add(btnCatalogue);

        JButton btnPanier = new JButton("🛒 Mon panier");
        btnPanier.addActionListener(e -> {
            // ici plus tard tu ouvriras la fenêtre du panier
            JOptionPane.showMessageDialog(this, "Panier à venir !");
        });
        panel.add(btnPanier);

        JButton btnHistorique = new JButton("📦 Mes commandes");
        btnHistorique.addActionListener(e -> {
            // ici plus tard tu ouvriras l'historique
            JOptionPane.showMessageDialog(this, "Historique à venir !");
        });
        panel.add(btnHistorique);

        JButton btnDeconnexion = new JButton("Déconnexion");
        btnDeconnexion.addActionListener(e -> {
            dispose();
            new ConnexionClientFrame().setVisible(true);
        });
        panel.add(btnDeconnexion);

        add(panel);
    }
}
