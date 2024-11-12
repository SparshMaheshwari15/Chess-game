// ChessGame.java
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

    public boolean movePiece(int startX, int startY, int endX, int endY) {
        Piece piece = board.getPieceAt(startX, startY);

        // Check if the move is valid for the piece
        if (piece != null && piece.isValidMove(startX, startY, endX, endY, board)) {
            board.setPieceAt(endX, endY, piece); // Move piece to new location
            board.setPieceAt(startX, startY, null); // Clear old location
            return true;
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
