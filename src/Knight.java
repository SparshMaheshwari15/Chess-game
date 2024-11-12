// Knight.java
public class Knight extends Piece {
    public Knight(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, ChessBoard board) {
        return (Math.abs(fromRow - toRow) == 2 && Math.abs(fromCol - toCol) == 1) ||
               (Math.abs(fromRow - toRow) == 1 && Math.abs(fromCol - toCol) == 2);
    }
}
