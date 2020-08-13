/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farm.view.generic;

import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import farm.controller.generic.CharactersLimit;

/**
 *
 * @author MConstantin
 */
public class TextFieldPanel extends JPanel {
    
    private JTextField textField;
    
    public TextFieldPanel(int xLocation, int yLocation, int width, int height, String title) {
        
        this.setTextFieldPanel(xLocation, yLocation, width, height, title);
        this.setTextField();
        this.add(textField);
        
    }
    
    private void setTextFieldPanel(int xLocation, int yLocation, int width, int height, String title) {
        
        this.setLayout(null);
        this.setBorder(BorderFactory.createTitledBorder(null, title, 0, 0, new Font("PLAIN", Font.BOLD, MainFrame.xCoordinate(12))));
        this.setBounds(MainFrame.xCoordinate(xLocation), MainFrame.yCoordinate(yLocation), MainFrame.xCoordinate(width), MainFrame.yCoordinate(height));
        this.setEnabled(false);
        
    }
    
    private void setTextField() {
        this.textField = new JTextField(15);
//        this.textField.setFont(new Font("PLAIN", Font.PLAIN, MainFrame.xCoordinate(12)))
        this.textField.setBounds(MainFrame.xCoordinate(15), MainFrame.yCoordinate(25), MainFrame.xCoordinate(160), MainFrame.yCoordinate(20));
        this.textField.setEnabled(false);
    }

    public JTextField getTextField() {
        return textField;
    }
    
    public void enablePanelAndTextField() {
        this.setEnabled(true);
        this.textField.setEnabled(true);
    }
    
    public void disablePanelAndTextField() {
        this.setEnabled(false);
        this.textField.setEnabled(false);
    }
        
}
