// Pawn.java
public class Pawn extends Piece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, ChessBoard board) {
        int direction = color.equals("White") ? 1 : -1;
        return (toRow == fromRow + direction && fromCol == toCol && !board.isOccupied(toRow, toCol))
            || (toRow == fromRow + direction && Math.abs(toCol - fromCol) == 1 && board.isOccupied(toRow, toCol) && !board.getPieceAt(toRow, toCol).getColor().equals(color));
    }
}