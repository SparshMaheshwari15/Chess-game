// Rook.java
public class Rook extends Piece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, ChessBoard board) {
        return fromRow == toRow || fromCol == toCol; // Simplified movement check for the rook
    }
}
