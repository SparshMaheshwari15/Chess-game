// Queen.java
public class Queen extends Piece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, ChessBoard board) {
        // Queen moves like a rook or a bishop
        return (startX == endX || startY == endY) || (Math.abs(startX - endX) == Math.abs(startY - endY));
    }
}
