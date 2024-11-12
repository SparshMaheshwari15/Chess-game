
// ChessGameGUI.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

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

    public void updateBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = game.board.getPieceAt(row, col);
                if (piece != null) {
                    String pieceColor = piece.getColor().toLowerCase(); // Get color of the piece
                    String pieceType = piece.getClass().getSimpleName().toLowerCase(); // Get piece type (e.g., "pawn",
                                                                                       // "knight")

                    // Construct the direct path to the image in the assets folder
                    String imagePath = "Y:/ChessGameProject/assets/" + pieceColor + "_" + pieceType + ".png";

                    // Load the image directly from the file path
                    ImageIcon pieceImage = new ImageIcon(imagePath);

                    // Set the image icon on the button
                    buttons[row][col].setIcon(pieceImage);
                } else {
                    buttons[row][col].setIcon(null); // Empty cell
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
                } else {
                    // Display an error message if the move is invalid
                    JOptionPane.showMessageDialog(frame, "Invalid move! Please try again.", "Error",
                            JOptionPane.ERROR_MESSAGE);
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
