- [Introduction](#Chess-Game)
- [Features](#Features)
- [Technologies Used](#Technologies-Used)
- [Installation](#Installation)
- [How to Play](#How-to-Play)
- [Classes](#Classes)
- [Sample Gameplay](#Sample-Gameplay)
- [Example of Game Flow](#Example-of-Game-Flow)
- [Contact](#Contact)
# Chess Game

This is a simple 2-player Chess Game built using Java and Swing. It provides a graphical user interface (GUI) where two players can play chess, make valid moves, capture pieces, and check for game-ending conditions like capturing the opponent's King.

### Features:
- **Graphical User Interface**: The game uses `JFrame` and `GridLayout` to create a simple 8x8 chessboard.
- **Move Validation**: The game validates moves based on chess rules for each piece.
- **Game Over**: The game ends when a King is captured, and the winning player is announced.
- **Restart/Close**: After a game over, players have the option to restart the game or close it.

### Technologies Used:
- **Java**: For game logic and GUI.
- **Swing**: For creating the user interface.
- **JOptionPane**: To display messages for invalid moves and game over.

---

### Installation

To run this chess game on your local machine, follow these steps:

1. Clone the repository or download the source code files.

    ```bash
    git clone https://github.com/SparshMaheshwari15/Chess-game
    ```

2. Move to the src directory

    ```bash
    cd src
    ```

3. Compile the Java files.

    ```bash
    javac *.java
    ```

3. Run the application.

    ```bash
    java ChessGameGUI
    ```

---

### How to Play:
1. **Starting the Game**: Upon launching the game, you will see an 8x8 chessboard.
2. **Making Moves**: Click on a piece to select it, then click on a destination square to move it. The game will check if the move is valid according to chess rules.
3. **Winning the Game**: The game ends when a player's King is captured. A dialog will appear showing the winner and options to restart or close the game.
4. **Restarting the Game**: After a game over, players can restart the game by selecting the "Restart" option from the dialog box or close the game with the "Close" option.

---

### Classes:
- **ChessGame**: Contains the game logic, move validation, and game over condition. It also handles player turns and switching between white and black players.
- **ChessGameGUI**: Provides the graphical user interface for the chessboard, handling user input and displaying the game state.
- **ChessBoard**: Represents the chessboard and holds the pieces. It also provides methods to retrieve and set pieces on the board.
- **Piece**: A generic class for chess pieces, such as pawns, knights, etc., containing the logic for valid movement.
- **King**: A subclass of `Piece`, representing the King and containing the logic for its movement.

---

### Sample Gameplay:

1. **Move a Piece**: Select a piece and click on a valid square to move it. Invalid moves will display an error message.
2. **Capture the King**: The game ends when a player's King is captured. The dialog will announce the winner and offer the option to restart or close the game.

---

### Example of Game Flow:

- Player 1 (White) moves a piece.
- Player 2 (Black) moves a piece.
- The game continues until one player's King is captured.
- Once the King is captured, the game displays "Game Over!" and prompts the winner, along with options to restart or close the game.

---

### Contact:

For issues or questions, please open an issue on the [GitHub Repository]([<repository-url>](https://github.com/SparshMaheshwari15/Chess-game)).
