public abstract class Piece {
    protected String color; // "White" or "Black"
    protected int x, y; // Position of the piece on the board

    // Constructor to set color
    public Piece(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    // Abstract method for valid moves, to be implemented by subclasses
    public abstract boolean isValidMove(int startX, int startY, int endX, int endY, ChessBoard board);
}
