package VueControleur;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import modele.SimulateurPotager;
import modele.environnement.*;
import modele.environnement.varietes.Legume;


/** Cette classe a deux fonctions :
 *  (1) Vue : proposer une représentation graphique de l'application (cases graphiques, etc.)
 *  (2) Controleur : écouter les évènements clavier et déclencher le traitement adapté sur le modèle
 *
 */
public class VueControleurPotager extends JFrame implements Observer {
    private SimulateurPotager simulateurPotager; // référence sur une classe de modèle : permet d'accéder aux données du modèle pour le rafraichissement, permet de communiquer les actions clavier (ou souris)

    private int sizeX; // taille de la grille affichée
    private int sizeY;

    // icones affichées dans la grille
    private ImageIcon icoSalade;
    private ImageIcon icoCarotte;
    private ImageIcon icoTomate;
    private ImageIcon icoRadis;
    private ImageIcon icoTerre;
    private ImageIcon icoVide;
    private ImageIcon icoMur;



    private JLabel[][] tabJLabel; // cases graphique (au moment du rafraichissement, chaque case va être associée à une icône, suivant ce qui est présent dans le modèle)


    public VueControleurPotager(SimulateurPotager _simulateurPotager) {
        sizeX = simulateurPotager.SIZE_X;
        sizeY = _simulateurPotager.SIZE_Y;
        simulateurPotager = _simulateurPotager;

        chargerLesIcones();
        placerLesComposantsGraphiques();
        //ajouterEcouteurClavier(); // si besoin
    }
/*
    private void ajouterEcouteurClavier() {
        addKeyListener(new KeyAdapter() { // new KeyAdapter() { ... } est une instance de classe anonyme, il s'agit d'un objet qui correspond au controleur dans MVC
            @Override
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyCode()) {  // on regarde quelle touche a été pressée
                    case KeyEvent.VK_LEFT : Controle4Directions.getInstance().setDirectionCourante(Direction.gauche); break;
                    case KeyEvent.VK_RIGHT : Controle4Directions.getInstance().setDirectionCourante(Direction.droite); break;
                    case KeyEvent.VK_DOWN : Controle4Directions.getInstance().setDirectionCourante(Direction.bas); break;
                    case KeyEvent.VK_UP : Controle4Directions.getInstance().setDirectionCourante(Direction.haut); break;
                }
            }
        });
    }
*/

    /* écouteur clic bouton choix de légume à planter*/
    public JComboBox <String> listeLegumeAChoisir() {
        String[] optionsToChoose = {"radis", "tomate", "carotte", "salade"};

        JComboBox<String> jComboBox = new JComboBox<>(optionsToChoose);
        jComboBox.setBounds(6, 45, 100, 20); //(position x, position y, taille x, taille y)

        add(jComboBox);

        return jComboBox;
    }



    public String legumeChoisiUtilisateur(JComboBox <String> jComboBox) {
        System.out.println("Légume sélectionné: " + jComboBox.getSelectedItem()); //pour item préselectionné (ici salade)
        jComboBox.addActionListener(e -> { //ajout d'un listener pour détecter s'il y a une action sur la liste
            System.out.println("Légume sélectionné: " + jComboBox.getSelectedItem());
        });
        assert jComboBox.getSelectedItem().toString()!= null; //pour éviter d'avoir une valeur nulle
        return jComboBox.getSelectedItem().toString();
    }
   /* //récupère le nom du légume à planter selectionné dans la liste déroulante par l'utilisateur
    public String legumeChoisiUtilisateur(JComboBox jComboBox) {
        jComboBox.getActionListeners();
        jComboBox.actionPerformed();
        return jComboBox.getAction().NAME;
        //prochaine fois: récupérer le nom du choix de la liste avec les listeners et vérifier qu'il y a bien eu une action sur la liste avant d'appeler la fonction dans casecultivable
    }*/
    private void chargerLesIcones() {
        // image libre de droits utilisée pour les légumes : https://www.vecteezy.com/vector-art/2559196-bundle-of-fruits-and-vegetables-icons

        //pour détecter les icones de légumes, 120*la ligne/colonne de l'icone
        icoSalade = chargerIcone("Images/data.png", 0, 0, 120, 120);//chargerIcone("Images/Pacman.png");
        icoVide = chargerIcone("Images/Vide.png");
        icoMur = chargerIcone("Images/Mur.png");
        icoTerre = chargerIcone("Images/Terre.png");
        icoCarotte = chargerIcone("Images/data.png", 360, 360, 120, 120);
        icoTomate = chargerIcone("Images/data.png", 1040, 360, 120, 120);
        icoRadis = chargerIcone("Images/data.png", 800, 800, 120, 120);


    }

    private void placerLesComposantsGraphiques(){
        setTitle("A vegetable garden");
        setSize(540, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // permet de terminer l'application à la fermeture de la fenêtre

        JPanel infos = new JPanel();
        JPanel choixLegumeTitre = new JPanel();

        JTextField jtf_infos = new JTextField("infos diverses"); // TODO inclure dans mettreAJourAffichage ...
        jtf_infos.setEditable(false);
        infos.add(jtf_infos);

        JTextField jtf_choixL = new JTextField("Légume à planter"); // TODO inclure dans mettreAJourAffichage ...
        jtf_choixL.setEditable(false);
        choixLegumeTitre.add(jtf_choixL);
/*
        String[] optionsToChoose = {"Salade", "Tomate", "Carotte", "Radis"};

        JComboBox<String> jComboBox = new JComboBox<>(optionsToChoose);
        jComboBox.setBounds(6, 45, 100, 20);

        add(jComboBox);*/

        JComboBox <String> legumesProposes = listeLegumeAChoisir(); //affiche la liste des légumes que l'on peut planter

        String legumeAplanter = legumeChoisiUtilisateur(legumesProposes); //recupere le nom du légume à planter

       // Legume.setVariete(legumeAplanter); //on donne la valeur du légume à planter à la variable de classe variété de la classe Legume
        //System.out.println("Valeur:" + legumeAplanter); //test: ça le fait qu'une fois

        //ajout infos diverses
        add(infos, BorderLayout.EAST);

        //ajout choix légumes
        add(choixLegumeTitre, BorderLayout.WEST);

        //utilisation de la variable avec le nom du légume à planter





        JComponent grilleJLabels = new JPanel(new GridLayout(sizeY, sizeX)); // grilleJLabels va contenir les cases graphiques et les positionner sous la forme d'une grille

        tabJLabel = new JLabel[sizeX][sizeY];

        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                JLabel jlab = new JLabel();

                tabJLabel[x][y] = jlab; // on conserve les cases graphiques dans tabJLabel pour avoir un accès pratique à celles-ci (voir mettreAJourAffichage() )
                grilleJLabels.add(jlab);
            }
        }
        add(grilleJLabels, BorderLayout.CENTER);

        // écouter les évènements

        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                final int xx = x; // constantes utiles au fonctionnement de la classe anonyme
                final int yy = y;
                tabJLabel[x][y].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        String legumeAplanter = legumeChoisiUtilisateur(legumesProposes); //permet de mettre à jour la valeur de la variable legumeAplanter quand il ya une nouvelle selection
                        simulateurPotager.actionUtilisateur(xx, yy, legumeAplanter);
                    }
                });
            }
        }
    }

    
    /**
     * Il y a une grille du côté du modèle ( jeu.getGrille() ) et une grille du côté de la vue (tabJLabel)
     */
    private void mettreAJourAffichage() {

        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                if (simulateurPotager.getPlateau()[x][y] instanceof CaseCultivable) { // si la grille du modèle contient une case cultivable, on associe l'icône du légume du côté de la vue

                    Legume legume = ((CaseCultivable) simulateurPotager.getPlateau()[x][y]).getLegume();

                    if (legume != null) {

                        switch (legume.getVariete()) {//affichage des icones des legumes
                            case salade: tabJLabel[x][y].setIcon(icoSalade); break;
                            case carotte: tabJLabel[x][y].setIcon(icoCarotte); break;
                            case tomate: tabJLabel[x][y].setIcon(icoTomate); break;
                            case radis: tabJLabel[x][y].setIcon(icoRadis); break;

                        }

                    } else {
                        tabJLabel[x][y].setIcon(icoTerre);
                    }

                    // si transparence : images avec canal alpha + dessins manuels (voir ci-dessous + créer composant qui redéfinie paint(Graphics g)), se documenter
                    //BufferedImage bi = getImage("Images/smick.png", 0, 0, 20, 20);
                    //tabJLabel[x][y].getGraphics().drawImage(bi, 0, 0, null);
                } else if (simulateurPotager.getPlateau()[x][y] instanceof CaseNonCultivable) {
                    tabJLabel[x][y].setIcon(icoMur);
                } else {

                    tabJLabel[x][y].setIcon(icoVide);
                }
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        mettreAJourAffichage();




        SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        mettreAJourAffichage();
                    }
                }); 


    }


    // chargement de l'image entière comme icone
    private ImageIcon chargerIcone(String urlIcone) {
        BufferedImage image = null;

        try {
            image = ImageIO.read(new File(urlIcone));
        } catch (IOException ex) {
            Logger.getLogger(VueControleurPotager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }


        return new ImageIcon(image);
    }

    // chargement d'une sous partie de l'image
    private ImageIcon chargerIcone(String urlIcone, int x, int y, int w, int h) {
        // charger une sous partie de l'image à partir de ses coordonnées dans urlIcone
        BufferedImage bi = getSubImage(urlIcone, x, y, w, h);
        // adapter la taille de l'image a la taille du composant (ici : 20x20)
        return new ImageIcon(bi.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
    }

    private BufferedImage getSubImage(String urlIcone, int x, int y, int w, int h) {
        BufferedImage image = null;

        try {
            File f = new File(urlIcone);
            image = ImageIO.read(new File(urlIcone));
        } catch (IOException ex) {
            Logger.getLogger(VueControleurPotager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        BufferedImage bi = image.getSubimage(x, y, w, h);
        return bi;
    }

}
