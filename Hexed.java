import java.util.*;

class Location {
	private int row;
	private int column;

	public Location(int row, int column) {
		this.row    = row;
		this.column = column;
	}

	public void setRow(int newRow) {
		this.row = newRow;
	}

	public void setColumn(int newColumn) {
		this.column = newColumn;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}
}

class State {
	private char[][] board;

	public State(char[][] board) {
		this.board = board;
	}

	public void setBoard(char[][] newBoard) {
		this.board = newBoard;
	}

	public char[][] getBoard() {
		return board;
	}

	public ArrayList<Location> checkValidMoves(char currentPlayer, char opponent) {
		ArrayList<Location> validMoveLocations = new ArrayList<>();
		for (int x = 0; x < this.board.length; x++) {
			for (int y = 0; y < this.board[x].length; y++) {
				if (this.board[x][y] == currentPlayer) {

					// Check vertiacal up.
					if (x > 0) {
						int rowVerticalUp = x - 1;
						int verticalUpOpponent = 0;

						while (rowVerticalUp >= 0) {
							if (this.board[rowVerticalUp][y] == currentPlayer) {
								break;
							}

							if (this.board[rowVerticalUp][y] != opponent) {
								if (verticalUpOpponent > 0) {
									validMoveLocations.add(new Location(rowVerticalUp, y));
								}
								break;
							}

							if (this.board[rowVerticalUp][y] == opponent) {
								verticalUpOpponent++;
							} 

							rowVerticalUp--;
						}
					}


					// Check vertical down.
					if (x < 6) {
						int rowVerticalDown = x + 1;
						int verticalDownOpponent = 0;

						while (rowVerticalDown <= 6) {
							if (this.board[rowVerticalDown][y] == currentPlayer) {
								break;
							}

							if (this.board[rowVerticalDown][y] != opponent) {
								if (this.board[rowVerticalDown][y] == 'N') {
									break;
								}
								
								if (verticalDownOpponent > 0) {
									validMoveLocations.add(new Location(rowVerticalDown, y));
								}
								break;
							}

							if (this.board[rowVerticalDown][y] == opponent) {
								verticalDownOpponent++;
							}

							rowVerticalDown++;
						}
					}					


					// Check diagonal right up.
					if (x > 0 && y < 8) {
						int rowDiagonalRightUp = x;
						int colDiagonalRightUp = y;
						int diagonalRightUpOpponent = 0;

						while (colDiagonalRightUp <= 7 && rowDiagonalRightUp >= 0) {
							if (colDiagonalRightUp % 2 == 0) {
								rowDiagonalRightUp = rowDiagonalRightUp - 1;
								colDiagonalRightUp = colDiagonalRightUp + 1;
							} else {
								colDiagonalRightUp = colDiagonalRightUp + 1;
							}

							if (this.board[rowDiagonalRightUp][colDiagonalRightUp] == currentPlayer) {
								break;
							}

							if (this.board[rowDiagonalRightUp][colDiagonalRightUp] != opponent) {
								if (diagonalRightUpOpponent > 0) {
									validMoveLocations.add(new Location(rowDiagonalRightUp, colDiagonalRightUp));
								}
								break;
							}

							if (this.board[rowDiagonalRightUp][colDiagonalRightUp] == opponent) {
								diagonalRightUpOpponent++;
							}
						}
					}

					// Check diagonal right down.
					if (x < 6 && y <= 8) {
						int rowDiagonalRightDown = x;
						int colDiagonalRightDown = y;
						int diagonalRightDownOpponent = 0;

						while (rowDiagonalRightDown <= 6 && colDiagonalRightDown >= 0) {
							if (colDiagonalRightDown % 2 == 0) {
								colDiagonalRightDown = colDiagonalRightDown - 1;
							} else {
								colDiagonalRightDown = colDiagonalRightDown - 1;
								rowDiagonalRightDown = rowDiagonalRightDown + 1;
							}

							if (this.board[rowDiagonalRightDown][colDiagonalRightDown] == currentPlayer) {
								break;
							}

							if (this.board[rowDiagonalRightDown][colDiagonalRightDown] != opponent) {
								if (this.board[rowDiagonalRightDown][colDiagonalRightDown] == 'N') {
									break;
								}
								if (diagonalRightDownOpponent > 0) {
									validMoveLocations.add(new Location(rowDiagonalRightDown, colDiagonalRightDown));
								}
								break;
							}

							if (this.board[rowDiagonalRightDown][colDiagonalRightDown] == opponent) {
								diagonalRightDownOpponent++;
							}
						}
					}					

					// Check diagonal left up.
					if (x > 0 && y > 0) {
						int rowDiagonalLeftUp = x;
						int colDiagonalLeftUp = y;
						int diagonalLeftUpOpponent = 0;

						while (rowDiagonalLeftUp >= 0 && colDiagonalLeftUp >= 1) {
							if (colDiagonalLeftUp % 2 == 0) {
								rowDiagonalLeftUp = rowDiagonalLeftUp - 1;
								colDiagonalLeftUp = colDiagonalLeftUp - 1;
							} else {
								colDiagonalLeftUp = colDiagonalLeftUp - 1;
							}

							if (this.board[rowDiagonalLeftUp][colDiagonalLeftUp] == currentPlayer) {
								break;
							}

							if (this.board[rowDiagonalLeftUp][colDiagonalLeftUp] != opponent) {
								if (diagonalLeftUpOpponent > 0) {
									validMoveLocations.add(new Location(rowDiagonalLeftUp, colDiagonalLeftUp));
								}
								break;
							}

							if (this.board[rowDiagonalLeftUp][colDiagonalLeftUp] == opponent) {
								diagonalLeftUpOpponent++;
							}
						}
					}

					// Check diagonal left down.
					if (x < 6 && y < 8) {
						int rowDiagonalLeftDown = x;
						int colDiagonalLeftDown = y;
						int diagonalLeftDownOpponent = 0;

						while (rowDiagonalLeftDown <= 6 && colDiagonalLeftDown <= 7) {
							if (colDiagonalLeftDown % 2 == 0) {
								colDiagonalLeftDown = colDiagonalLeftDown + 1;
							} else {
								colDiagonalLeftDown = colDiagonalLeftDown + 1;
								rowDiagonalLeftDown = rowDiagonalLeftDown + 1;
							}

							if (this.board[rowDiagonalLeftDown][colDiagonalLeftDown] == currentPlayer) {
								break;
							}

							if (this.board[rowDiagonalLeftDown][colDiagonalLeftDown] != opponent) {
								if (this.board[rowDiagonalLeftDown][colDiagonalLeftDown] == 'N') {
									break;
								}

								if (diagonalLeftDownOpponent > 0) {
									validMoveLocations.add(new Location(rowDiagonalLeftDown, colDiagonalLeftDown));
								}
								break;
							}

							if (this.board[rowDiagonalLeftDown][colDiagonalLeftDown] == opponent) {
								diagonalLeftDownOpponent++;
							}
						}	
					}
				}
			}
		}

		return validMoveLocations;
	}
}

public class Hexed {

	public static void printChar2DArray(char[][] b) {
		for (int x = 0; x < b.length; x++) {
			System.out.printf("%c %c %c %c %c %c %c %c %c\n", b[x][0], b[x][1], b[x][2], b[x][3], b[x][4], b[x][5], b[x][6], b[x][7], b[x][8]);
		}
	}

	public static void printBoard(char[][] b) {
		System.out.println("---------------------------------");
		System.out.println("|                               |");
		for (int x = 0; x < b.length; x++) {
			System.out.printf("|  [%c]   [%c]   [%c]   [%c]   [%c]  |\n", b[x][0], b[x][2], b[x][4], b[x][6], b[x][8]);

			if (x != 6) {
				System.out.printf("|     [%c]   [%c]   [%c]   [%c]     |\n", b[x][1], b[x][3], b[x][5], b[x][7]);
			}
		}
		System.out.println("|                               |");
		System.out.println("---------------------------------");
	}

	public static char[][] initializeBoard(int x, int y, char[][] board) {
		if ((y + 1) % 2 == 0) {
			x = x + 1;
		}

		board[6 - x][y] = 'G';
		board[(6 - x) + 2][y] = 'R';

		if ((y + 1) % 2 == 0) {
			x = x - 1;
			board[6 - x][y + 1] = 'R';
			board[(6 - x) + 1][y + 1] = 'G';
		} else {
			board[6 - x][y + 1] = 'R';
			board[(6 - x) + 1][y + 1] = 'G';
		}

		board[6 - x][y - 1] = 'R';
		board[(6 - x) + 1][y - 1] = 'G';

		return board;
	}

	public static void main(String[] args) {
		char[][] board = new char[][] {{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
																	 {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
																	 {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
																	 {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
																	 {' ', ' ', ' ', 'R', ' ', ' ', ' ', ' ', ' '},
																	 {' ', ' ', ' ', ' ', 'G', 'G', ' ', ' ', ' '},
																	 {' ', 'N', ' ', 'N', ' ', 'N', 'G', 'N', ' '}};

		State initialState = new State(board);

		// initializeBoard(row, column, char[][]);
		// initializeBoard(4, 4, initialState.getBoard());
		printBoard(initialState.getBoard());
		// printChar2DArray(initialState.getBoard());
		
		ArrayList<Location> validMoves = initialState.checkValidMoves('R', 'G');

		System.out.println("");
		for (int x = 0; x < validMoves.size(); x++) {
			System.out.println(validMoves.get(x).getRow() + ", " + validMoves.get(x).getColumn());
		}
	} 
}

//      0 1 2 3 4 5 6 7 8
//      | | | | | | | | |
// 6 -- 6 5 6 5 6 5 6 5 6
// 5 -- 5 4 5 4 5 4 5 4 5
// 4 -- 4 3 4 R G R 4 3 4
// 3 -- 3 2 3 G C G 3 2 3
// 2 -- 2 1 2 1 R 1 2 1 2
// 1 -- 1 0 1 0 1 0 1 0 1
// 0 -- 0 N 0 N 0 N 0 N 0

// |6|   |6|   |6|   |6|   |6|
//    |5|   |5|   |5|   |5|
// |5|   |5|   |5|   |5|   |5|
//    |4|   |4|   |4|   |4|
// |4|   |4|   |4|   |4|   |4|
//    |3|   |3|   |3|   |3|
// |3|   |3|   |3|   |3|   |3|
//    |2|   |2|   |2|   |2|
// |2|   |2|   |2|   |2|   |2|
//    |1|   |1|   |1|   |1|
// |1|   |1|   |1|   |1|   |1|
//    |0|   |0|   |0|   |0|
// |0|   |0|   |0|   |0|   |0|