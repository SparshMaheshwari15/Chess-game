// ChessBoard.java
public class ChessBoard {
    private Piece[][] board;

    public ChessBoard() {
        board = new Piece[8][8];
        initializeBoard();
    }

    private void initializeBoard() {
        // Set up white pieces
        board[0][0] = new Rook("White");
        board[0][7] = new Rook("White");
        board[0][1] = new Knight("White");
        board[0][6] = new Knight("White");
        board[0][2] = new Bishop("White");
        board[0][5] = new Bishop("White");
        board[0][3] = new Queen("White");
        board[0][4] = new King("White");

        // Set up black pieces
        board[7][0] = new Rook("Black");
        board[7][7] = new Rook("Black");
        board[7][1] = new Knight("Black");
        board[7][6] = new Knight("Black");
        board[7][2] = new Bishop("Black");
        board[7][5] = new Bishop("Black");
        board[7][3] = new Queen("Black");
        board[7][4] = new King("Black");

        // Set pawns
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn("White");
            board[6][i] = new Pawn("Black");
        }
    }

    public void setPieceAt(int row, int col, Piece piece) {
        board[row][col] = piece;
    }

    public Piece getPieceAt(int row, int col) {
        return board[row][col];
    }

    public void movePiece(int fromRow, int fromCol, int toRow, int toCol) {
        Piece piece = getPieceAt(fromRow, fromCol);
        board[toRow][toCol] = piece;
        board[fromRow][fromCol] = null;
    }

    public boolean isOccupied(int row, int col) {
        return board[row][col] != null;
    }
}
