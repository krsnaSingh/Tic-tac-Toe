# Tic-Tac-Toe (GWT Version)

This is a simple web-based **Tic-Tac-Toe** game built using **Google Web Toolkit (GWT)**. The game allows two players to play Tic-Tac-Toe on a 3x3 grid, and the game will announce a winner or a draw when the game ends. The game provides a "Restart Game" button to start over after a game concludes.

## Features
- 3x3 Tic-Tac-Toe grid
- Players alternate turns between "X" and "O"
- Game detects and announces when a player wins or if there is a draw
- Popup window for announcing the game result
- Restart button for a new game
- Responsive and simple user interface

## Tech Stack
- **Java** for logic implementation
- **Google Web Toolkit (GWT)** to compile the Java code into JavaScript
- **HTML5 & CSS** for the frontend layout and styles

## Prerequisites

To run this project, you need:

- Java Development Kit (JDK) installed on your machine.
- Apache Maven or another build tool (to build the GWT application).
- Basic knowledge of GWT.

## How to Run

### 1. Clone the Repository

Clone this repository to your local machine.

```bash
git clone https://github.com/yourusername/tictactoe-gwt.git
cd tictactoe-gwt
```

### 2. Build the GWT Project

If you are using Maven, navigate to the project directory and run the following command:

```bash
mvn clean install
```

### 3. Run the Application

To run the GWT application, use the following command (or use an IDE like Eclipse/IntelliJ that supports GWT):

```bash
mvn gwt:devmode
```

This will open a development server. You can now access the game on your local machine by navigating to:

```
http://127.0.0.1:8888/Tic_tac_toe.html
```

### 4. Play the Game

Once the game loads, you can start playing by clicking on the buttons in the grid. The game will automatically handle turns, check for a winner, and show a popup announcing the result. Click "Restart Game" to play again.

