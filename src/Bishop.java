// Bishop.java
public class Bishop extends Piece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, ChessBoard board) {
        // Bishop moves diagonally, so the difference in x and y must be equal
        return Math.abs(startX - endX) == Math.abs(startY - endY);
    }
}
