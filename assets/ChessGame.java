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

    // ChessGame.java
    public ChessBoard getBoard() {
        return board;
    }

    private void toggleTurn() {
        currentPlayer = currentPlayer.equals("White") ? "Black" : "White";
    }
}
