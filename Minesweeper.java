import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Minesweeper {
    private class MineTile extends JButton{
        int baris;
        int kolom;

        public MineTile(int baris,int kolom){
            this.baris=baris;
            this.kolom=kolom;
        }
    }
}

int tileSize = 75;
int numBaris = 8;
int numKolom = 8;
int panjangBoard = 600;
int lebarBoard = 600;

JFrame frame = new JFrame("Minesweeper");
JLabel textLabel = new JLabel();
JPanel textPanel = new JPanel();
JPanel boardPanel = new JPanel();


