// ChessGame.java

import javax.swing.JOptionPane;

public class ChessGame {
    protected ChessBoard board;
    private String currentPlayer;

    public ChessGame() {
        board = new ChessBoard();
        currentPlayer = "White";
    }

    public boolean makeMove(int fromRow, int fromCol, int toRow, int toCol) {
        Piece piece = board.getPieceAt(fromRow, fromCol);
        if (piece != null && piece.getColor().equals(currentPlayer)
                && piece.isValidMove(fromRow, fromCol, toRow, toCol, board)) {
            board.movePiece(fromRow, fromCol, toRow, toCol);
            toggleTurn();
            return true;
        }
        return false;
    }

    // In ChessGame.java (or where you handle moves and game state)
public boolean movePiece(int startX, int startY, int endX, int endY) {
    Piece piece = board.getPieceAt(startX, startY);
    Piece targetPiece = board.getPieceAt(endX, endY);

    // Validate the move as per chess rules
    if (piece != null && piece.isValidMove(startX, startY, endX, endY, board)) {
        
        // Check if the target piece is a King
        if (targetPiece instanceof King) {
            // End the game
            System.out.println("Game Over! " + piece.getColor() + " wins by capturing the king.");
            JOptionPane.showMessageDialog(null, piece.getColor() + " wins! Game Over.");
            return true;  // Or set a flag to indicate the game is over
        }

        // Execute the move
        board.setPieceAt(endX, endY, piece);
        board.setPieceAt(startX, startY, null);

        return true; // Move successful
    }
    return false; // Invalid move
}


    // ChessGame.java
    public ChessBoard getBoard() {
        return board;
    }

    private void toggleTurn() {
        currentPlayer = currentPlayer.equals("White") ? "Black" : "White";
    }
}
