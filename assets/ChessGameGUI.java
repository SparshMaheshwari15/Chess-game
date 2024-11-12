// ChessGameGUI.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChessGameGUI extends JFrame {
    private ChessGame game;
    private JButton[][] buttons;
    private int selectedRow = -1, selectedCol = -1;

    public ChessGameGUI() {
        game = new ChessGame();
        buttons = new JButton[8][8];

        setTitle("Multiplayer Chess Game");
        setSize(600, 600);
        setLayout(new GridLayout(8, 8));

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                buttons[row][col] = new JButton();
                buttons[row][col].setBackground((row + col) % 2 == 0 ? Color.WHITE : Color.GRAY);
                buttons[row][col].addActionListener(new ButtonClickListener(row, col));
                add(buttons[row][col]);
            }
        }
        updateBoard();
    }

    private class ButtonClickListener implements ActionListener {
        int row, col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (selectedRow == -1) {
                if (game.board.getPieceAt(row, col) != null) {
                    selectedRow = row;
                    selectedCol = col;
                }
            } else {
                if (game.makeMove(selectedRow, selectedCol, row, col)) {
                    updateBoard();
                }
                selectedRow = -1;
                selectedCol = -1;
            }
        }
    }

    private void updateBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = game.getBoard().getPieceAt(row, col);
                buttons[row][col].setText(piece == null ? "" : piece.getClass().getSimpleName().substring(0, 1));
            }
        }
    }

    public static void main(String[] args) {
        ChessGameGUI gui = new ChessGameGUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
    }
}
