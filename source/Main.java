/**
 * Example of usage of DirectoryPath
 * 
 * @author Alejandro Rodríguez
 */

public class Main {
    public static void main(String[] args) {
        new Main().start();
    }
    
    public void start() {
        new javax.swing.JOptionPane().showMessageDialog(null, new DirectoryPath().getPath());
    }
}
