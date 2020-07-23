package farm;


import javax.swing.SwingUtilities;

/**
 * 
 * This class is used to start the project
 * @author MConstantin
 *
 */
public class Farm {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                
                new FarmSys();

            }
        });

    }

}
