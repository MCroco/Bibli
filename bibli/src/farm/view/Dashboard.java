package farm.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import farm.view.generic.MainFrame;

/**
 * Cette classe contient la totalité du code nécessaire pour créer la premiére fenêtre
 * de l'application.
 * @author MConstantin
 */
public class Dashboard extends MainFrame {

    private JPanel animalPanel;
    private JButton addAnimalButton;
    private JButton updateAnimalButton;
    private JButton searchAnimalButton;
    private JButton viewAnimalButton;
    private JPanel header;
    private JButton logoutButton;
    private JLabel welcomeLabel;
    private JLabel welcomeImage;
    private TheView view;


    /**
     * @param view
     * @param title
     * @param width
     * @param height
     * @param image
     */
    public Dashboard(TheView view, String title, int width, int height, String image) {
        
        super(title, width, height, image);
        
        this.view = view;
        
        /**
         * Header: Creates the header for the Admin DashBoard
         */
        
        this.setDashboardHeader();
        this.add(header);
        
        this.setWelcomeLabel();
        header.add(welcomeLabel);
        
        this.setWelcomeImage();
        header.add(welcomeImage);
        
        this.setLogOutButton();
        header.add(logoutButton);
        
     
        /**
         * Animal
         */
        
        this.setAnimalPanel();
        this.add(animalPanel);
        
        // Add Animal button:
        
        this.setAddAnimalButton();
        animalPanel.add(addAnimalButton);
        

        // View animal button:
        
        this.setViewAnimalButton();
        animalPanel.add(viewAnimalButton);
        
        this.setVisible(true);
        this.validate();
        this.repaint();
        
    }
    
    
    /**
     * 
     */
    private void setDashboardHeader() {
        header = new JPanel();
        header.setLayout(null);
        header.setBackground(Color.LIGHT_GRAY);
        header.setBounds(MainFrame.xCoordinate(0), MainFrame.yCoordinate(0), MainFrame.xCoordinate(350), MainFrame.yCoordinate(60));
    }
    
    /**
     * 
     */
    private void setWelcomeLabel() {
        welcomeLabel = new JLabel("Bienvenue M. Dessy!");
        welcomeLabel.setFont(new Font("Jazz LET", Font.PLAIN, MainFrame.xCoordinate(20)));
        welcomeLabel.setBounds(MainFrame.xCoordinate(100), MainFrame.yCoordinate(15), MainFrame.xCoordinate(300), MainFrame.yCoordinate(30));
    }
    
    /**
     * 
     */
    private void setWelcomeImage() {
        welcomeImage = new JLabel();
        ImageIcon imgL = new ImageIcon(this.getClass().getResource("/images/header.png"));
        Image img = imgL.getImage();
        Image newImg = img.getScaledInstance(MainFrame.xCoordinate(40), MainFrame.yCoordinate(42), Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newImg);
        welcomeImage.setIcon(newIcon);
        welcomeImage.setPreferredSize(new Dimension(MainFrame.xCoordinate(40), MainFrame.yCoordinate(40)));
        welcomeImage.setBounds(MainFrame.xCoordinate(40), MainFrame.yCoordinate(15), MainFrame.xCoordinate(200), MainFrame.yCoordinate(40));
    }
    

    
      
    
    
   
    /**
     * 
     */
    private void setAnimalPanel() {
        animalPanel = new JPanel(null);
        animalPanel.setLayout(null);
        animalPanel.setBorder(BorderFactory.createTitledBorder(null, "Animaux: ", 0, 0, new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12))));
        animalPanel.setBounds(MainFrame.xCoordinate(60), MainFrame.yCoordinate(70), MainFrame.xCoordinate(220), MainFrame.yCoordinate(185));
        
        JLabel animalImage = new JLabel();
        ImageIcon imgA = new ImageIcon("src/farm/view/images/animals.png");

        
        
        Image aImg = imgA.getImage();
        Image newImgA = aImg.getScaledInstance(MainFrame.xCoordinate(90), MainFrame.yCoordinate(90), Image.SCALE_SMOOTH);
        ImageIcon newIconA = new ImageIcon(newImgA);
        animalImage.setIcon(newIconA);
        animalImage.setPreferredSize(new Dimension(MainFrame.xCoordinate(90), MainFrame.yCoordinate(90)));
        animalImage.setBounds(MainFrame.xCoordinate(0), MainFrame.yCoordinate(30), MainFrame.xCoordinate(100), MainFrame.yCoordinate(100));
        animalPanel.add(animalImage);
    }
    
    /**
     * 
     */
    private void setAddAnimalButton() {
        ImageIcon addAnimalIcon = new ImageIcon(this.getClass().getResource("/images/addanimal.png"));
        Image imgAddAnimal = addAnimalIcon.getImage();
        Image newImgAddAnimal = imgAddAnimal.getScaledInstance(MainFrame.xCoordinate(24), MainFrame.yCoordinate(24), Image.SCALE_SMOOTH);
        ImageIcon newAddAnimalIcon = new ImageIcon(newImgAddAnimal);
        
        addAnimalButton = new JButton("Ajouter animal", newAddAnimalIcon);
        addAnimalButton.setFont(new Font("BOLD", Font.BOLD, MainFrame.xCoordinate(12)));
        addAnimalButton.setToolTipText("Ajouter un nouveau animal");
        addAnimalButton.setMargin(new Insets(0,0,0,0));
        addAnimalButton.setBounds(MainFrame.xCoordinate(90), MainFrame.yCoordinate(20), MainFrame.xCoordinate(90), MainFrame.yCoordinate(30));
    }

    /**
     * 
     */
    private void setLogOutButton() {
        logoutButton = new JButton("Deconnexion");
        logoutButton.setFont(new Font("PLAIN", Font.PLAIN, MainFrame.xCoordinate(18)));
        logoutButton.setActionCommand("exitButton");
        logoutButton.setToolTipText("Arreter l'application!");
        logoutButton.setMargin(new Insets(0,0,0,0));
        logoutButton.setBounds(MainFrame.xCoordinate(335), MainFrame.yCoordinate(15), MainFrame.xCoordinate(85), MainFrame.yCoordinate(30));
    }
    /**
     * 
     */
    private void setViewAnimalButton() {
        ImageIcon viewAnimalIcon = new ImageIcon(this.getClass().getResource("/images/viewanimals.png"));
        Image imgViewAnimal = viewAnimalIcon.getImage();
        Image newImgViewAnimal = imgViewAnimal.getScaledInstance(MainFrame.xCoordinate(24), MainFrame.yCoordinate(24), Image.SCALE_SMOOTH);
        ImageIcon newViewAnimalIcon = new ImageIcon(newImgViewAnimal);
        viewAnimalButton = new JButton("Voir animaux", newViewAnimalIcon);
        viewAnimalButton.setFont(new Font("BOLD", Font.BOLD, MainFrame.xCoordinate(12)));
        viewAnimalButton.setToolTipText("Voir tous les animaux");
        viewAnimalButton.setMargin(new Insets(0,0,0,0));
        viewAnimalButton.setBounds(MainFrame.xCoordinate(90), MainFrame.yCoordinate(140), MainFrame.xCoordinate(90), MainFrame.yCoordinate(30));
    }

  
    /**
     * @return
     */
    public JButton getAddAnimalButton() {
        return addAnimalButton;
    }

    /**
     * @return
     */
    public JButton getUpdateAnimalButton() {
        return updateAnimalButton;
    }

    /**
     * @return
     */
    public JButton getSearchAnimalButton() {
        return searchAnimalButton;
    }

    /**
     * @return
     */
    public JButton getViewAnimalButton() {
        return viewAnimalButton;
    }

    /**
     * @return
     */
    public JButton getLogoutButton() {
        return logoutButton;
    }

    /**
     * @return
     */
    public TheView getView() {
        return view;
    }

}
