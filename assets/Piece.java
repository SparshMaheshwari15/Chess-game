// Piece.java
public abstract class Piece {
    protected String color;

    public Piece(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    // Each specific piece will implement its own move validation logic
    public abstract boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, ChessBoard board);
}
