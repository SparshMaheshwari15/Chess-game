// ChessGameGUI.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChessGameGUI {
    private JFrame frame;
    private JButton[][] buttons;
    private ChessGame game;
    private int startX = -1, startY = -1; // to store selected piece coordinates

    public ChessGameGUI() {
        game = new ChessGame();
        frame = new JFrame("Chess Game");
        frame.setLayout(new GridLayout(8, 8));
        buttons = new JButton[8][8];

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                buttons[row][col] = new JButton();
                buttons[row][col].setPreferredSize(new Dimension(80, 80));
                buttons[row][col].setBackground((row + col) % 2 == 0 ? Color.WHITE : Color.GRAY);
                buttons[row][col].addActionListener(new ButtonClickListener(row, col));
                frame.add(buttons[row][col]);
            }
        }
        
        updateBoard();
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void updateBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = game.getBoard().getPieceAt(row, col);
                // buttons[row][col].setText(piece == null ? "" : piece.getClass().getSimpleName().substring(0, 1));
                if (piece != null) {
                    String pieceColor = piece.getColor(); // Get color of the piece
                    String pieceSymbol = piece.getClass().getSimpleName().substring(0, 1); // Get the piece's symbol (e.g., P for Pawn)
                    String displayText = pieceColor.equals("White") ? pieceSymbol.toUpperCase() : pieceSymbol.toLowerCase();
                    buttons[row][col].setText(displayText); // Display the piece with correct color
                } else {
                    buttons[row][col].setText(""); // Empty cell
                }
            }
        }
    }

    // Action listener for button clicks
    private class ButtonClickListener implements ActionListener {
        private int row, col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (startX == -1 && startY == -1) {
                // First click: select piece
                if (game.getBoard().getPieceAt(row, col) != null) { // Select only if there's a piece
                    startX = row;
                    startY = col;
                }
            } else {
                // Second click: move piece
                if (game.movePiece(startX, startY, row, col)) {
                    updateBoard(); // Update the GUI after a valid move
                }
                // Reset selection
                startX = -1;
                startY = -1;
            }
        }
    }

    public static void main(String[] args) {
        new ChessGameGUI();
    }
}
