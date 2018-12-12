import java.util.*;

class ValidMove {
	private int row;
	private int column;
	private String moveDirection;

	public ValidMove(int row, int column, String moveDirection) {
		this.row    = row;
		this.column = column;
		this.moveDirection = moveDirection;
	}

	public void setRow(int newRow) {
		this.row = newRow;
	}

	public void setColumn(int newColumn) {
		this.column = newColumn;
	}

	public void setMoveDirection(String newMoveDirection) {
		this.moveDirection = newMoveDirection;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public String getMoveDirection() {
		return moveDirection;
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

	public ArrayList<ValidMove> checkValidMoves(char currentPlayer, char opponent) {
		ArrayList<ValidMove> validMoveLocations = new ArrayList<>();
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
									validMoveLocations.add(new ValidMove(rowVerticalUp, y, "verticalUp"));
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
									validMoveLocations.add(new ValidMove(rowVerticalDown, y, "verticalDown"));
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

						while (colDiagonalRightUp <= 8 && rowDiagonalRightUp >= 0) {
							if (colDiagonalRightUp % 2 == 0) {
								rowDiagonalRightUp = rowDiagonalRightUp - 1;
								colDiagonalRightUp = colDiagonalRightUp + 1;
							} else {
								colDiagonalRightUp = colDiagonalRightUp + 1;
							}

							if (colDiagonalRightUp <= 8 && rowDiagonalRightUp >= 0) {
								if (this.board[rowDiagonalRightUp][colDiagonalRightUp] == currentPlayer) {
									break;
								}

								if (this.board[rowDiagonalRightUp][colDiagonalRightUp] != opponent) {
									if (diagonalRightUpOpponent > 0) {
										validMoveLocations.add(new ValidMove(rowDiagonalRightUp, colDiagonalRightUp, "diagonalRightUp"));
									}
									break;
								}

								if (this.board[rowDiagonalRightUp][colDiagonalRightUp] == opponent) {
									diagonalRightUpOpponent++;
								}
							} else {
								break;
							}
						}
					}

					// Check diagonal right down.
					if (x < 6 && y > 0) {
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

							if (rowDiagonalRightDown <= 6 && colDiagonalRightDown >= 0) {
								if (this.board[rowDiagonalRightDown][colDiagonalRightDown] == currentPlayer) {
									break;
								}

								if (this.board[rowDiagonalRightDown][colDiagonalRightDown] != opponent) {
									if (this.board[rowDiagonalRightDown][colDiagonalRightDown] == 'N') {
										break;
									}
									if (diagonalRightDownOpponent > 0) {
										validMoveLocations.add(new ValidMove(rowDiagonalRightDown, colDiagonalRightDown, "diagonalRightDown"));
									}
									break;
								}

								if (this.board[rowDiagonalRightDown][colDiagonalRightDown] == opponent) {
									diagonalRightDownOpponent++;
								}
							}
						}
					}					

					// Check diagonal left up.
					if (x > 0 && y > 0) {
						int rowDiagonalLeftUp = x;
						int colDiagonalLeftUp = y;
						int diagonalLeftUpOpponent = 0;

						while (rowDiagonalLeftUp >= 0 && colDiagonalLeftUp >= 0) {
							if (colDiagonalLeftUp % 2 == 0) {
								rowDiagonalLeftUp = rowDiagonalLeftUp - 1;
								colDiagonalLeftUp = colDiagonalLeftUp - 1;
							} else {
								colDiagonalLeftUp = colDiagonalLeftUp - 1;
							}

							if (rowDiagonalLeftUp >= 0 && colDiagonalLeftUp >= 0) {
								if (this.board[rowDiagonalLeftUp][colDiagonalLeftUp] == currentPlayer) {
									break;
								}

								if (this.board[rowDiagonalLeftUp][colDiagonalLeftUp] != opponent) {
									if (diagonalLeftUpOpponent > 0) {
										validMoveLocations.add(new ValidMove(rowDiagonalLeftUp, colDiagonalLeftUp, "diagonalLeftUp"));
									}
									break;
								}

								if (this.board[rowDiagonalLeftUp][colDiagonalLeftUp] == opponent) {
									diagonalLeftUpOpponent++;
								}
							}
						}
					}

					// Check diagonal left down.
					if (x < 6 && y < 8) {
						int rowDiagonalLeftDown = x;
						int colDiagonalLeftDown = y;
						int diagonalLeftDownOpponent = 0;

						while (rowDiagonalLeftDown <= 6 && colDiagonalLeftDown <= 8) {
							if (colDiagonalLeftDown % 2 == 0) {
								colDiagonalLeftDown = colDiagonalLeftDown + 1;
							} else {
								colDiagonalLeftDown = colDiagonalLeftDown + 1;
								rowDiagonalLeftDown = rowDiagonalLeftDown + 1;
							}

							if (rowDiagonalLeftDown <= 6 && colDiagonalLeftDown <= 8) {
								if (this.board[rowDiagonalLeftDown][colDiagonalLeftDown] == currentPlayer) {
									break;
								}

								if (this.board[rowDiagonalLeftDown][colDiagonalLeftDown] != opponent) {
									if (this.board[rowDiagonalLeftDown][colDiagonalLeftDown] == 'N') {
										break;
									}

									if (diagonalLeftDownOpponent > 0) {
										validMoveLocations.add(new ValidMove(rowDiagonalLeftDown, colDiagonalLeftDown, "diagonalLeftDown"));
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
		}

		return validMoveLocations;
	}

	public char[][] applyMove(char currentPlayer, ValidMove move) {
		char[][] newBoard = this.board;

		int x = move.getRow();
		int y = move.getColumn();

		switch (move.getMoveDirection()) {
			case "verticalUp":
				newBoard[x][y] = currentPlayer;
				x = x + 1;
				while (newBoard[x][y] != currentPlayer) {
					newBoard[x][y] = currentPlayer;
					x++;
				}
				break;
			case "verticalDown":
				newBoard[x][y] = currentPlayer;
				x = x - 1;
				while(newBoard[x][y] != currentPlayer) {
					newBoard[x][y] = currentPlayer;
					x--;
				}
				break;
			case "diagonalRightUp":
				newBoard[x][y] = currentPlayer;
				while (x <= 6 && y >= 0) {
					if (y % 2 == 0) {
						y = y - 1;
					} else {
						y = y - 1;
						x = x + 1;
					}

					if (newBoard[x][y] == currentPlayer) {
						break;
					}
					newBoard[x][y] = currentPlayer;
				}
				break;
			case "diagonalRightDown":
				newBoard[x][y] = currentPlayer;
				while (y <= 8 && x >= 0) {
					if (y % 2 == 0) {
						x = x - 1;
						y = y + 1;
					} else {
						y = y + 1;
					}

					if (newBoard[x][y] == currentPlayer) {
						break;
					}
					newBoard[x][y] = currentPlayer;
				}
				break;
			case "diagonalLeftUp":
				newBoard[x][y] = currentPlayer;
				while (x <= 6 && y <= 8) {
					if (y % 2 == 0) {
						y = y + 1;
					} else {
						y = y + 1;
						x = x + 1;
					}

					if (newBoard[x][y] == currentPlayer) {
						break;
					}
					newBoard[x][y] = currentPlayer;
				}
				break;
			case "diagonalLeftDown":
				newBoard[x][y] = currentPlayer;
				while (x >= 0 && y >= 0) {
					if (y % 2 == 0) {
						x = x - 1;
						y = y - 1;
					} else {
						y = y - 1;
					}

					if (newBoard[x][y] == currentPlayer) {
						break;
					}
					newBoard[x][y] = currentPlayer;
				}
				break;
		}

		return newBoard;
	}
}

public class Hexed {
	private static Scanner kbd = new Scanner(System.in);

	public static ValidMove randomizeMove(ArrayList<ValidMove> validMoves) {
		int index = (int) (Math.random() * (validMoves.size() - 1));
		return validMoves.get(index);
	}

	public static void printValidMoves(ArrayList<ValidMove> validMoves) {
		for (int i = 0; i < validMoves.size(); i++) {
			System.out.println(i + " -> (Row: " + (6 - validMoves.get(i).getRow()) + ", Column: " + validMoves.get(i).getColumn() + ")");
		}
	}

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

	public static ArrayList<ValidMove> checkMoveHaveDuplicate(ValidMove currentMove, ArrayList<ValidMove> validMoves) {
		ArrayList<ValidMove> moves = new ArrayList<>();

		for (int i = 0; i < validMoves.size(); i++)  {
			if (validMoves.get(i).getRow() == currentMove.getRow() && validMoves.get(i).getColumn() == currentMove.getColumn()) {
				moves.add(validMoves.get(i));
			}
		}

		return moves;
	}

	public static int countPlayerTiles(char player, char[][] board) {
		int counter = 0;

		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[x].length; y++) {
				if (board[x][y] == player) {
					counter++;
				}
			}
		}

		return counter;
	}

	public static void main(String[] args) {
		char[][] board = new char[][] {{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
																	 {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
																	 {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
																	 {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
																	 {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
																	 {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
																	 {' ', 'N', ' ', 'N', ' ', 'N', ' ', 'N', ' '}};

		State initialState = new State(board);

		// ArrayList<ValidMove> validMoves = initialState.checkValidMoves('G', 'R');
		// printBoard(initialState.getBoard());
		// printValidMoves(validMoves);

		// System.out.println("Valid moves count: " + checkMoveHaveDuplicate(validMoves.get(0), validMoves).size());

		// if (checkMoveHaveDuplicate(validMoves.get(0), validMoves).size() > 1) {
		// 	for (int z = 0; z < checkMoveHaveDuplicate(validMoves.get(0), validMoves).size(); z++) {
		// 		initialState.applyMove('G', checkMoveHaveDuplicate(validMoves.get(0), validMoves).get(z));
		// 	}
		// }

		// printBoard(initialState.getBoard());

		System.out.println("Enter initial state:");
		System.out.print("Row: ");
		int initialRow = kbd.nextInt();

		System.out.print("Column: ");
		int initialCol = kbd.nextInt(); 

		initializeBoard(initialRow, initialCol, board);
		System.out.println("--------- Misery  Hexed ---------");
		printBoard(initialState.getBoard());

		System.out.println("Do you want to make the first move?");
		System.out.println("1 -> Yes or 2 -> No");
		int ans = kbd.nextInt();

		int playerTurn = 0;

		if (ans == 1) {
			playerTurn = 1;
		} else {
			playerTurn = 0;
		}
		
		ArrayList<ValidMove> playerOne = new ArrayList<>();
		ArrayList<ValidMove> playerTwo = new ArrayList<>();

		do {
			playerOne = initialState.checkValidMoves('R', 'G');
			playerTwo = initialState.checkValidMoves('G', 'R');
			
			if (playerTurn % 2 == 0) {
				if (playerOne.size() > 0) {
					playerOne = initialState.checkValidMoves('R', 'G');
					printValidMoves(playerOne);
					ValidMove playerOneMove = randomizeMove(playerOne);
					System.out.println("Move Location: (Row: " + (6 - playerOneMove.getRow()) + ", Column: " + playerOneMove.getColumn() + ")");

					if (checkMoveHaveDuplicate(playerOneMove, playerOne).size() > 1) {
						for (int z = 0; z < checkMoveHaveDuplicate(playerOneMove, playerOne).size(); z++) {
							initialState.applyMove('R', checkMoveHaveDuplicate(playerOneMove, playerOne).get(z));
						}

						printBoard(initialState.getBoard());
					} else {
						printBoard(initialState.applyMove('R', playerOneMove));
					}
				} else {
					System.out.println("Player one Hexed!!!\n");
				}
			} else {
				if (playerTwo.size() > 0) {
					playerTwo = initialState.checkValidMoves('G', 'R');
					printValidMoves(playerTwo);

					int moveIndex = 0;
					boolean isValid = false;

					do {
						System.out.print("Enter move number: ");
						moveIndex = kbd.nextInt();

						if (moveIndex >= 0 && moveIndex <= (playerTwo.size() - 1)) {
							isValid = true;
						}

					} while (isValid == false);
					
					System.out.println("Move number: " + moveIndex);

					if (checkMoveHaveDuplicate(playerTwo.get(moveIndex), playerTwo).size() > 1) {
						for (int z = 0; z < checkMoveHaveDuplicate(playerTwo.get(moveIndex), playerTwo).size(); z++) {
							initialState.applyMove('G', checkMoveHaveDuplicate(playerTwo.get(moveIndex), playerTwo).get(z));
						}

						printBoard(initialState.getBoard());
					} else {
						printBoard(initialState.applyMove('G', playerTwo.get(moveIndex)));
					}
				} else {
					System.out.println("Player two Hexed!!!\n");
				}
			}

			playerOne = initialState.checkValidMoves('R', 'G');
			playerTwo = initialState.checkValidMoves('G', 'R');

			System.out.println("Player one available moves: " + playerOne.size());
			System.out.println("Player two available moves: " + playerTwo.size());

			System.out.println();

			System.out.println("Player one total tiles: " + countPlayerTiles('R', initialState.getBoard()));
			System.out.println("Player two total tiles: " + countPlayerTiles('G', initialState.getBoard()));
			playerTurn++;
		} while (playerOne.size() != 0 || playerTwo.size() != 0);

		int playerOneScore = countPlayerTiles('R', initialState.getBoard());
		int playerTwoScore = countPlayerTiles('G', initialState.getBoard());

		if (playerOneScore > playerTwoScore) {
			System.out.println("Player two win!!!");
		} else {
			System.out.println("Player one win!!!");
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