import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

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

int mineCount = 10;
//jumlah mine
MineTile[][] board = new MineTile[numBaris][numKolom];
ArrayList<MineTile> mineList;
Random random = new Random();

int tilesClicked = 0;
boolean gameOver = false;

MineSweeper(){
    frame.setSize(panjangBoard,lebarBoard);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());

    textLabel.setFont(new Font ("Arial",Font.BOLD,25 ));
    textLabel.setHorizontalAlignment(JLabel.CENTER);
    textLabel.setText("Minesweeper: " + Integer.toString(mineCount));
    textLabel.setOpaque(true);

    textPanel.setLayout(new BorderLayout());
    textPanel.add(textLabel);
    frame.add(textPanel, BorderLayout.NORTH);

    boardPanel.setLayout(new GridLayout(8,8));
    frame.add(boardPanel);

    for (int baris=0; baris<numBaris; baris++ ){
        for (int kolom=0; kolom<numKolom; kolom++ ){
            MineTile tile = new MineTile(baris, kolom);
            board[baris][kolom] = tile;

            tile.setFocusable(false);
            tile.setMargin(new Insets(0, 0, 0, 0));
            tile.setFont(new Font("Arial Unicode MS", Font.PLAIN, 45));
            tile.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e){
                    if (gameOver){
                        return;
                    }
                    MineTile tile = (MineTile) e.getSource();

                    if(e.getButton()== MouseEvent.BUTTON1){
                        if (tile.getText()==""){
                            if(mineList.contains(tile)){
                                revealMines();
                            }
                            else{
                                checkMine(tile.baris,tile.kolom);
                            }
                        }
                    }
                    else if (e.getButton()==MouseEvent.BUTTON3){
                        if(tile.getText()==""&& tile.isEnabled()){
                            tile.setText("🚩");
                        }
                        else if (tile.getText()=="🚩"){
                            tile.setText("null");
                        }
                    }
                }
            });

            boardPanel.add(tile);
        }
    }
    frame.setVisible(true);
   
}
