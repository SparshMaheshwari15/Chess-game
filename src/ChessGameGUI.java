
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

    public void updateBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = game.board.getPieceAt(row, col);
                if (piece != null) {
                    String pieceColor = piece.getColor().toLowerCase(); // Get color of the piece
                    String pieceType = piece.getClass().getSimpleName().toLowerCase(); // Get piece type (e.g., "pawn",
                                                                                       // "knight")

                    String imagePath = "../assets/" + pieceColor + "_" + pieceType + ".png";

                    // Load the image directly from the file path
                    ImageIcon pieceImage = new ImageIcon(imagePath);

                    // Resize the image to fit the button size (80x80)
                    Image img = pieceImage.getImage(); // Get the image object
                    Image scaledImg = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH); // Scale it to fit the button
                                                                                         // size
                    pieceImage = new ImageIcon(scaledImg); // Convert back to ImageIcon

                    // Set the image icon on the button
                    buttons[row][col].setIcon(pieceImage);
                } else {
                    buttons[row][col].setIcon(null); // Empty cell
                }
            }
        }
    }

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

                    // Check if the game is over (win/lose condition, checkmate, etc.)
                    if (game.isGameOver()) {
                        // Show dialog to restart or close the game
                        int choice = JOptionPane.showOptionDialog(frame,
                                "Game Over! Do you want to restart or close the game?",
                                "Game Over",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                new Object[] { "Restart", "Close" },
                                "Restart");

                        if (choice == JOptionPane.YES_OPTION) {
                            restartGame(); // Restart the game
                        } else {
                            System.exit(0); // Close the game
                        }
                    }
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

    public void restartGame() {
        game = new ChessGame(); // Create a new game object to reset the game state
        updateBoard(); // Update the GUI to show the initial board state
    }

    public static void main(String[] args) {
        new ChessGameGUI();
    }
}
