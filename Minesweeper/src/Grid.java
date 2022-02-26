import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Grid {
	private boolean [][] bombGrid;
	private int [][] countGrid;
	private int numRows;
	private int numColumns;
	private int numBombs;
	private Random random = new Random();
	public JButton [][] button;
	public boolean [][] revealed;
	
	public int nextTo = 0;
	
	public int mX = -100;
	public int mY = -100;
	
	public Grid() {//Default constructor
		numRows = 10;
		numColumns = 10;
		numBombs = 25;
		createBombGrid();
		createCountGrid();
	}
	
	public Grid(int rows, int columns) {//Overloaded constructor
		this.numRows = rows;
		this.numColumns = columns;
		numBombs = 25;
		createBombGrid();
		createCountGrid();
	}
	
	public Grid(int rows, int columns, int numBombs) {//Overloaded constructor
		this.numRows = rows;
		this.numColumns = columns;
		if(rows * columns > numBombs) {//Check that the area of the board is greater than the number of bombs
			this.numBombs = numBombs;
		}
		else {
			this.numBombs  = 1;
		}
		createBombGrid();
		createCountGrid();
	}
	
	public int getNumRows() {//numRows getter
		return numRows;
	}
	
	public int getNumColumns() {//numColumns getter
		return numColumns;
	}
	
	public int getNumBombs() {//numBombs getter
		return numBombs;
	}
	
	public boolean [][] getBombGrid() {//Not sure if the copying is correct!
		boolean [][] copyB = new boolean [numRows][numColumns];
		for(int i = 0; i < bombGrid.length; i++) {
			for(int j = 0; j < bombGrid[i].length; j++) {
				copyB[i][j] = bombGrid[i][j];
			}
		}
		return copyB;
	}
	
	public int [][] getCountGrid() {//Not sure if the copying is correct!
		int [][] copyC = new int [numRows][numColumns];
		for(int i = 0; i < countGrid.length; i++) {
			for(int j = 0; j < countGrid[i].length; j++) {
				copyC[i][j] = countGrid[i][j];
			}
		}
		return copyC;
	}
	
	public boolean isBombAtLocation(int row, int column) {
		if(bombGrid[row][column] == true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int getCountAtLocation(int row, int column) {
		nextTo = 0;
		for(int i = 0; i < getNumRows(); i++) {
			for(int j = 0; j < getNumColumns(); j++) {
				if(bombGrid[i][j]) {
					if(bombGrid[row][column] == true) {//Count itself
						nextTo++;
					}
					if(row > 0 && bombGrid[row - 1][column] == true) {//Check if there is a bomb to the left of the cell
							nextTo++;
					}
					
					if(row + 1 < getNumRows() && bombGrid[row + 1][column] == true) {//Check if there is a bomb to the right of the cell
							nextTo++;
					}
					
					if(column > 0 && bombGrid[row][column - 1] == true) {//Check if there is a bomb in top of the cell
							nextTo++;
					}
					
					if(column + 1 < getNumColumns() && bombGrid[row][column + 1] == true) {//Check if there is a bomb below the cell
							nextTo++;
					}
					
					//Diagonal 
					
					if(row > 0 && column > 0 && bombGrid[row - 1][column - 1] == true) {//Check if there is a bomb to the left and top of the cell
						nextTo++;
					}
					
					if(row > 0 && column + 1 < getNumColumns() && bombGrid[row - 1][column + 1] == true) {//Check if there is a bomb left and below the cell
						nextTo++;
					}
					
					if(row + 1 < getNumRows() && column > 0 && bombGrid[row + 1][column - 1]) {//Check if there is a bomb to the right and top of the cell
						nextTo++;
					}
					
					if(row + 1 < getNumRows() && column + 1 < getNumColumns() && bombGrid[row + 1][column + 1] == true) {//Check if there is a bomb to the right and below of the cell
						nextTo++;
					}
					
				}
			}
		}
		
		if(nextTo == getNumBombs()) {
			nextTo = 1;
		}
		else if(nextTo == getNumBombs() * 2) {
			nextTo = 2;
		}
		else if(nextTo == getNumBombs() * 3) {
			nextTo = 3;
		}
		else if(nextTo == getNumBombs() * 4) {
			nextTo = 4;
		}
		else if(nextTo == getNumBombs() * 5) {
			nextTo = 5;
		}
		else if(nextTo == getNumBombs() * 6) {
			nextTo = 6;
		}
		else if(nextTo == getNumBombs() * 7) {
			nextTo = 7;
		}
		else if(nextTo == getNumBombs() * 8) {
			nextTo = 8;
		}
		else if(nextTo == getNumBombs() * 9) {
			nextTo = 9;
		}
		
		
		
		return nextTo;
	}
	
	public void print() {
		for(int i = 0; i < getNumRows(); i++) {
			for(int j = 0; j < getNumColumns(); j++) {
				System.out.print(countGrid[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void printBombs() {
		for(int i = 0; i < getNumRows(); i++) {
			for(int j = 0; j < getNumColumns(); j++) {
				System.out.print(bombGrid[i][j] + " ");
			}
			System.out.println();
		}
	}
		
	
	
	private void createBombGrid() {//Creates the boolean 2D array and populates it with bombs 
		bombGrid = new boolean [numRows][numColumns];
		
		int counter = 0;
		
		while(counter < numBombs) {//Add bombs to the grid at random locations until counter is 25.
			int rowR = random.nextInt(numRows - 1);
			int colR = random.nextInt(numColumns - 1);
			
			if(bombGrid[rowR][colR] == false) {
				bombGrid[rowR][colR] = true;
				counter++;
			}
		}
	}
	
	private void createCountGrid() {
		
		countGrid = new int [getNumRows()][getNumColumns()];
		
		for(int i = 0; i < getNumRows(); i++) {
			for(int j = 0; j < getNumColumns(); j++) {
				countGrid[i][j] = getCountAtLocation(i, j);
				
				
			}
		}
	}
		
	private void reset() {
		createBombGrid();
		createCountGrid();
		//clear();
		new Board();
	}
	
	private void clear() {
		for(int i = 0; i < button.length; i++) {
			for(int j = 0; j < button[i].length; j++) {
				button[i][j].setBackground(Color.LIGHT_GRAY);
				button[i][j].setForeground(Color.LIGHT_GRAY);
			}
		}
	}
	
	private int revealedCounter() {
		int counter = 0;
		for(int i = 0; i < revealed.length; i++) {
			for(int j = 0; j < revealed[i].length; j++) {
				if(revealed[i][j] == true) {
					counter++;
				}
			}
		}
		return counter;
	}


	
	
	
	//-----------------------------------------------------------BOARD CLASS FOR GUI----------------------------------------------------------------------------------
	
	
	
	
	
	public class Board extends JFrame implements MouseListener {//GUI 
		public Board() {
			
			revealed = new boolean [getNumRows()][getNumColumns()];
			
			setLayout(new GridLayout(getNumRows(), getNumColumns()));//Set a gridLayout
			
			button = new JButton [getNumRows()][getNumColumns()];
			
			for(int i = 0; i < button.length; i++) {
				for(int j = 0; j < button[i].length; j++) {
					button[i][j] = new JButton();
					button[i][j].addMouseListener(this);
					
					button[i][j].setBackground(Color.LIGHT_GRAY);
					button[i][j].setForeground(Color.LIGHT_GRAY);
					
					button[i][j].setText("" + countGrid[i][j]);
					button[i][j].setFont(new Font("Serif", Font.BOLD, 20));
					button[i][j].setFocusable(false);
					
					this.add(button[i][j]);
				}
			}
			
			
			
			
			
			//JFrame info
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle("Minesweeper");
			setSize(750, 750);
			setLocationRelativeTo(null);
			setVisible(true);
			setResizable(false);
			
		}
		

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			
			for(int i = 0; i < button.length; i++) {
				for(int j = 0; j < button[i].length; j++) {
					if(e.getSource() == button[i][j]) {
						button[i][j].setBackground(Color.LIGHT_GRAY);
						//button[i][j].setForeground(Color.BLUE);
						System.out.println("Coordinates of cell: (" + i + "," + j + ")");
						System.out.println("Bombs next to cell : " + getCountAtLocation(i, j));
						
						if(isBombAtLocation(i, j) == false) {
							revealed[i][j] = true;
						}
						
						if(revealedCounter() >= (getNumRows() * getNumColumns()) - getNumBombs()) {
							int op = JOptionPane.showConfirmDialog(this, "You have won!", "VICTORY", JOptionPane.OK_CANCEL_OPTION);
							if(op == JOptionPane.OK_OPTION) {
								clear();
								reset();
							}
							if(op == JOptionPane.CANCEL_OPTION) {
								reset();
							}
						}
						
						if(countGrid[i][j] == 0) {
							button[i][j].setBackground(Color.GRAY);
							button[i][j].setForeground(Color.GRAY);
						}
						
						if(countGrid[i][j] == 1) {
							button[i][j].setForeground(Color.BLUE);
						}
						else if(countGrid[i][j] == 2) {
							button[i][j].setForeground(Color.GREEN);
						}
						else if(countGrid[i][j] == 3) {
							button[i][j].setForeground(Color.RED);
						}
						else if(countGrid[i][j] == 4) {
							button[i][j].setForeground(new Color(0, 0, 128));
						}
						else if(countGrid[i][j] == 5) {
							button[i][j].setForeground(new Color(178, 34, 34));
						}
						else if(countGrid[i][j] == 6) {
							button[i][j].setForeground(new Color(72, 209, 204));
						}
						else if(countGrid[i][j] == 7) {
							button[i][j].setForeground(Color.BLACK);
						}
						else if(countGrid[i][j] == 8) {
							button[i][j].setForeground(Color.DARK_GRAY);
						}
						else if(countGrid[i][j] == 9) {
							button[i][j].setForeground(Color.cyan);
						}
						
					}
					
					if(e.getSource() == button[i][j] && bombGrid[i][j] == true) {//Checks if the user clicked a cell with a bomb!
						button[i][j].setBackground(Color.RED);
						button[i][j].setForeground(Color.BLACK);
						button[i][j].setFont(new Font("Serif", Font.BOLD, 30));
						button[i][j].setText("X");
						int option = JOptionPane.showConfirmDialog(this, "You lost. Would you like to play again?", "DEFEAT", JOptionPane.YES_NO_OPTION);
							
						if(option == JOptionPane.YES_OPTION) {
							reset();
						}
						if(option == JOptionPane.NO_OPTION) {
							System.exit(0);
						}
						
						
						
					}	
					
					
				}
			}
		}
		
		if(e.getButton() == MouseEvent.BUTTON3) {
			for(int i = 0; i < getNumRows(); i++) {
				for(int j = 0; j < getNumColumns(); j++) {
					if(e.getSource() == button[i][j]) {
						button[i][j].setBackground(new Color(150, 66, 66));
						button[i][j].setForeground(new Color(150, 66, 66));
					}
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	}
	
	public int getBombX(boolean bomb) {//Get x coordinate for the bomb
		int x = 0;
		for(int i = 0; i < getNumRows(); i++) {
			for(int j = 0; j < getNumColumns(); j++) {
				if(bombGrid[i][j] == bomb) {
					x = i;
				}
			}
		}
		return x;
	}
	
	public int getBombY(boolean bomb) {//Get x coordinate for the bomb
		int y = 0;
		for(int i = 0; i < getNumRows(); i++) {
			for(int j = 0; j < getNumColumns(); j++) {
				if(bombGrid[i][j] == bomb) {
					y = j;
				}
			}
		}
		return y;
	}
	
	public int getUserX(JButton click) {//Get x coordinate for the bomb
		int x = 0;
		for(int i = 0; i < getNumRows(); i++) {
			for(int j = 0; j < getNumColumns(); j++) {
				if(button[i][j] == click) {
					x = i;
				}
			}
		}
		return x;
	}
	
	public int getUserY(JButton click) {//Get x coordinate for the bomb
		int y = 0;
		for(int i = 0; i < getNumRows(); i++) {
			for(int j = 0; j < getNumColumns(); j++) {
				if(button[i][j] == click) {
					y = j;
				}
			}
		}
		return y;
	}

}

