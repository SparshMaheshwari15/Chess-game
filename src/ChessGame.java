import javax.swing.JOptionPane;

public class ChessGame {
    protected ChessBoard board;
    private String currentPlayer;
    private boolean gameOver;  // Track if the game is over

    public ChessGame() {
        board = new ChessBoard();
        currentPlayer = "White";
        gameOver = false;
    }

    // Make a move if valid
    public boolean makeMove(int fromRow, int fromCol, int toRow, int toCol) {
        if (gameOver) {
            return false;  // No moves allowed after the game is over
        }
    
        // Check if it's the current player's turn
        Piece piece = board.getPieceAt(fromRow, fromCol);
        if (piece == null || !piece.getColor().equals(currentPlayer)) {
            // If the piece is null or doesn't match the current player's color
            System.out.println("It's " + currentPlayer + "'s turn. You cannot move the opponent's piece.");
            return false;  // Invalid move because it's not the current player's turn
        }
    
        // Proceed with the normal move if it's the correct player's turn
        if (piece != null && piece.getColor().equals(currentPlayer)
                && piece.isValidMove(fromRow, fromCol, toRow, toCol, board)) {
            if (movePiece(fromRow, fromCol, toRow, toCol)) {
                toggleTurn();  // Switch turn after a valid move
                return true;
            }
        }
        return false;  // Invalid move
    }
    
    // Handle piece movement and check for game-ending conditions
    public boolean movePiece(int startX, int startY, int endX, int endY) {
        Piece piece = board.getPieceAt(startX, startY);
        Piece targetPiece = board.getPieceAt(endX, endY);
    
        // Validate the move as per chess rules
        if (piece != null && piece.isValidMove(startX, startY, endX, endY, board)) {
            
            // Check if the target square is occupied by a piece of the same color
            if (targetPiece != null && targetPiece.getColor().equals(piece.getColor())) {
                // If the target piece is of the same color, return false (invalid move)
                System.out.println("Invalid move: You cannot move your piece to a square occupied by your own piece.");
                return false;
            }
    
            // Check if the target piece is a King (game-ending condition)
            if (targetPiece instanceof King) {
                // End the game when the King is captured
                gameOver = true;
                System.out.println("Game Over! " + piece.getColor() + " wins by capturing the King.");
                JOptionPane.showMessageDialog(null, piece.getColor() + " wins! Game Over.");
    
                // Show dialog to restart or close the game
                int choice = JOptionPane.showOptionDialog(null,
                        "Game Over! Do you want to restart or close the game?",
                        "Game Over",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new Object[] {"Restart", "Close"},
                        "Restart");
    
                if (choice == JOptionPane.YES_OPTION) {
                    restartGame(); // Restart the game
                } else {
                    System.exit(0); // Close the game
                }
    
                return true;  // Indicate the move was successful (end of the game)
            }
    
            // Execute the move
            board.setPieceAt(endX, endY, piece);
            board.setPieceAt(startX, startY, null);
            return true; // Move successful
        }
        return false; // Invalid move
    }
    
    // Method to restart the game
    public void restartGame() {
        board = new ChessBoard(); // Reset the board to initial state
        currentPlayer = "White";  // Reset to white player
        gameOver = false;  // Reset the game over flag
    }

    // Getter for the board
    public ChessBoard getBoard() {
        return board;
    }

    // Toggle between players (White and Black)
    private void toggleTurn() {
        currentPlayer = currentPlayer.equals("White") ? "Black" : "White";
    }
    

    // Check if the game is over (e.g., King is captured)
    public boolean isGameOver() {
        return gameOver;
    }
}
