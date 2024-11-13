public class Pawn extends Piece {
    private boolean firstMove;  // Track if it's the pawn's first move

    public Pawn(String color) {
        super(color);
        this.firstMove = true;  // Set to true initially, as it hasn’t moved yet
    }

    @Override
    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, ChessBoard board) {
        int direction = color.equals("White") ? 1 : -1;  // White moves up (positive), Black moves down (negative)

        // Regular one-square forward move
        if (toRow == fromRow + direction && fromCol == toCol && !board.isOccupied(toRow, toCol)) {
            firstMove = false;  // Mark that the pawn has moved
            return true;
        }

        // Two-square forward move on the pawn's first move
        if (firstMove && toRow == fromRow + 2 * direction && fromCol == toCol 
            && !board.isOccupied(toRow, toCol) && !board.isOccupied(fromRow + direction, fromCol)) {
            firstMove = false;  // Mark that the pawn has moved
            return true;
        }

        // Diagonal capture move
        if (toRow == fromRow + direction && Math.abs(toCol - fromCol) == 1 
            && board.isOccupied(toRow, toCol) && !board.getPieceAt(toRow, toCol).getColor().equals(color)) {
            firstMove = false;  // Mark that the pawn has moved
            return true;
        }

        return false;  // Not a valid move for the pawn
    }
}
