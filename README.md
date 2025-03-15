# Tic Tac Toe Game

Welcome to the Tic Tac Toe Game! This is a simple console-based Tic Tac Toe game implemented in Java. You can play either in single-player mode against the computer or in multiplayer mode with a friend.

## Table of Contents

- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Gameplay](#gameplay)
- [Contributing](#contributing)

## Features

- **Game Modes**: Enjoy two game modes - Single Player and Multiplayer.
- **Randomized Toss**: A randomized toss decides who goes first.
- **User-Friendly Interface**: Simple and intuitive console-based interface.
- **Move Validation**: Automatic validation of moves to prevent overwriting.

## Installation

To get started with the Tic Tac Toe game, you need to have Java installed on your system. You can download and install Java from the [official website](https://www.oracle.com/java/technologies/javase-downloads.html).

1. Clone the repository:
    ```bash
    git clone https://github.com/a-muizz28/Tic_Tac_Toe_Java.git
    ```

2. Navigate to the project directory:
    ```bash
    cd Tic_Tac_Toe_Java
    ```

3. Compile the Java code:
    ```bash
    javac TicTacToe.java
    ```

4. Run the game:
    ```bash
    java TicTacToe
    ```

## Usage

When you run the game, you will be presented with a main menu where you can choose between Single Player and Multiplayer modes.

1. **Single Player**: Play against the computer. You will be prompted to choose your sign (X or O).
2. **Multiplayer**: Play against a friend. Each player will choose either Heads or Tails for a toss to decide who goes first. The winner of the toss will choose their sign.

## Gameplay

- The game board is a 3x3 grid.
- Players take turns to place their sign (X or O) in an empty cell by entering a number between 1 and 9.
- The first player to get three of their signs in a row (horizontally, vertically, or diagonally) wins the game.
- If all cells are filled and no player has three in a row, the game is declared a draw.

## Contributing

Contributions are welcome! If you have any suggestions or improvements, please feel free to open an issue or create a pull request.

1. Fork the repository.
2. Create a new branch for your feature or bugfix.
    ```bash
    git checkout -b feature-name
    ```
3. Commit your changes.
    ```bash
    git commit -m "Add feature"
    ```
4. Push to the branch.
    ```bash
    git push origin feature-name
    ```
5. Create a pull request.

Thank you for contributing!

