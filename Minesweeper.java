import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Minesweeper {


	BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	Scanner sc = new Scanner(System.in);
	
	public int acceptRows()	//function to accept Rows
	{
		int n =sc.nextInt();
		return n;
	}
	
	public int acceptColumns() //function to accept Columns
	{
		int m = sc.nextInt();
		return m;
	}
	
	public char[][] acceptMinefeild(int n, int m) { //Function to accept minefeild

		char[][] Minefeild = new char[n][m];
		try {
			for (int i = 0; i < n; ++i)
				Minefeild[i] = r.readLine().toCharArray();

			return Minefeild;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Minefeild;
	}

	public void displayMinefeild(int n, int m, char[][] Minefeild) { //function to display Minefeild
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				System.out.print(Minefeild[i][j]);
			}
			System.out.println();
		}

	}

	public char[][] computeMinesweeper(int n,int m,char[][] Minefeild){
		int n1[] = new int[2]; //the neighborhood of every cell in consideration
		int n2[] = new int[2];
		int n3[] = new int[2];
		int n4[] = new int[2];
		int n5[] = new int[2];
		int n6[] = new int[2];
		int n7[] = new int[2];
		int n8[] = new int[2];
		char[][] output = new char[n][m];
		for (int i = 0; i < n; ++i) {
			
			for (int j = 0; j < m; ++j) {
				int value = 0;
				n1[0] = i - 1; // north-west
				n1[1] = j - 1;
				n2[0] = i - 1; // north
				n2[1] = j;
				n3[0] = i - 1; // north-east
				n3[1] = j + 1;
				n4[0] = i; // west
				n4[1] = j - 1;
				n5[0] = i; // east
				n5[1] = j + 1;
				n6[0] = i + 1; // south-west
				n6[1] = j - 1;
				n7[0] = i + 1; // south
				n7[1] = j;
				n8[0] = i + 1; // south-east
				n8[1] = j + 1;

				if (i == 0 && j == 0) // top left corner of grid
				{
					if (Minefeild[n5[0]][n5[1]] == '*')
						value = value + 1;
					if (Minefeild[n7[0]][n7[1]] == '*')
						value = value + 1;
					if (Minefeild[n8[0]][n8[1]] == '*')
						value = value + 1;
				} else if (i == 0 && j == m - 1) // top right corner of grid
				{
					if (Minefeild[n4[0]][n4[1]] == '*')
						value = value + 1;
					if (Minefeild[n6[0]][n6[1]] == '*')
						value = value + 1;
					if (Minefeild[n7[0]][n7[1]] == '*')
						value = value + 1;

				} else if (i == n - 1 && j == 0) // bottom left corner of
													// grid
				{
					if (Minefeild[n2[0]][n2[1]] == '*')
						value = value + 1;
					if (Minefeild[n3[0]][n3[1]] == '*')
						value = value + 1;
					if (Minefeild[n5[0]][n5[1]] == '*')
						value = value + 1;

				} else if (i == n - 1 && j == m - 1) // bottom right corner
														// of grid
				{
					if (Minefeild[n1[0]][n1[1]] == '*')
						value = value + 1;
					if (Minefeild[n2[0]][n2[1]] == '*')
						value = value + 1;
					if (Minefeild[n4[0]][n4[1]] == '*')
						value = value + 1;

				} else if (i == 0 && j < m && j > 0) // top row
				{
					if (Minefeild[n4[0]][n4[1]] == '*')
						value = value + 1;
					if (Minefeild[n6[0]][n6[1]] == '*')
						value = value + 1;
					if (Minefeild[n7[0]][n7[1]] == '*')
						value = value + 1;
					if (Minefeild[n8[0]][n8[1]] == '*')
						value = value + 1;
					if (Minefeild[n5[0]][n5[1]] == '*')
						value = value + 1;

				} else if (i == n - 1 && j < m && j > 0) // bottom row
				{
					if (Minefeild[n1[0]][n1[1]] == '*')
						value = value + 1;
					if (Minefeild[n2[0]][n2[1]] == '*')
						value = value + 1;
					if (Minefeild[n3[0]][n3[1]] == '*')
						value = value + 1;
					if (Minefeild[n4[0]][n4[1]] == '*')
						value = value + 1;
					if (Minefeild[n5[0]][n5[1]] == '*')
						value = value + 1;

				} else if (i < n && i > 0 && j == 0) // extreme left column
				{
					if (Minefeild[n2[0]][n2[1]] == '*')
						value = value + 1;
					if (Minefeild[n3[0]][n3[1]] == '*')
						value = value + 1;
					if (Minefeild[n5[0]][n5[1]] == '*')
						value = value + 1;
					if (Minefeild[n7[0]][n7[1]] == '*')
						value = value + 1;
					if (Minefeild[n8[0]][n8[1]] == '*')
						value = value + 1;

				} else if (i < n && i > 0 && j == m - 1) // extreme right
															// corner of
															// grid
				{
					if (Minefeild[n1[0]][n1[1]] == '*')
						value = value + 1;
					if (Minefeild[n2[0]][n2[1]] == '*')
						value = value + 1;
					if (Minefeild[n4[0]][n4[1]] == '*')
						value = value + 1;
					if (Minefeild[n6[0]][n6[1]] == '*')
						value = value + 1;
					if (Minefeild[n7[0]][n7[1]] == '*')
						value = value + 1;

				} else // somewhere inside the grid

				{
					if (Minefeild[n1[0]][n1[1]] == '*')
						value = value + 1;
					if (Minefeild[n2[0]][n2[1]] == '*')
						value = value + 1;
					if (Minefeild[n3[0]][n3[1]] == '*')
						value = value + 1;
					if (Minefeild[n4[0]][n4[1]] == '*')
						value = value + 1;
					if (Minefeild[n5[0]][n5[1]] == '*')
						value = value + 1;
					if (Minefeild[n6[0]][n6[1]] == '*')
						value = value + 1;
					if (Minefeild[n7[0]][n7[1]] == '*')
						value = value + 1;
					if (Minefeild[n8[0]][n8[1]] == '*')
						value = value + 1;
					
				}
				if(Minefeild[i][j] == '*')
					output[i][j] = '*';
				else
				output[i][j] = Integer.toString(value).charAt(0);

			}
		}
		return output;

	}
	public void checkContraints(int n,int m){ //function to check n>0 and m<100
		if (n<0 || m>100)
		{System.exit(0);}
	}
	public static void main(String args[]) {
	
	Minesweeper M = new Minesweeper();
	int n,m;
	n = M.acceptRows(); //function call to accept rows
	m = M.acceptColumns(); //function call to accept columns
	M.checkContraints(n, m);
	char[][] grid = new char[n][m];
	grid = M.acceptMinefeild(n, m); //taking input for minefeild grid
	grid = M.computeMinesweeper(n, m, grid);	//computing Minesweeper	
	M.displayMinefeild(n, m, grid);	//displaying output
	}

}