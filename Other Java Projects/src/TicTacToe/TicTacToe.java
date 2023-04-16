package TicTacToe;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	private ArrayList<Integer> occupied = new ArrayList<Integer>();
	private char [][] grid = {
			{' ', '|', ' ', '|', ' '},
			{'-', '+', '-', '+', '-'},
			{' ', '|', ' ', '|', ' '},
			{'-', '+', '-', '+', '-'},
			{' ', '|', ' ', '|', ' '}
		};

	public static void main(String[] args) {
		TicTacToe ttt = new TicTacToe();
		Random r = new Random();
		Scanner sc = new Scanner(System.in);

		ttt.print();		
		while(true) {
			System.out.println("Enter a position btw 1-9");
			int userPos = sc.nextInt();
			while(ttt.getOccupied().contains(userPos)) {
				System.out.println("Position is occupied. Please try again.");
				userPos = sc.nextInt();
			}
			ttt.insert(userPos, "user");
			if(ttt.checkCondition("user")==true) {
				break;
			}
					
			ttt.print();
			
			int cpuPos = r.nextInt(9)+1;
			System.out.println("Cpu turn: "+cpuPos);
			while(ttt.getOccupied().contains(cpuPos)) {
				cpuPos = r.nextInt(9)+1;
				System.out.println("Cpu turn: "+cpuPos);
			}
			ttt.insert(cpuPos,"cpu");
			if(ttt.checkCondition("cpu")==true) {
				break;
			}
			ttt.print();
		}

	}
	
	private ArrayList<Integer> getOccupied() {
		return occupied;
	}

	private void print() {
		for(char[]x:grid) {
			for(char ch:x) {
				System.out.print(ch);
			}
			System.out.println();
		}
	}
	
	private void insert(int pos, String player) {
			char sym;
			if(player.equals("user")){
				sym = 'X';
			}else {
				sym = 'O';
			}
			switch(pos) {
			case 1:
				grid[0][0]=sym;
				occupied.add(1);
				break;
			case 2:
				grid[0][2]=sym;
				occupied.add(2);
				break;
			case 3:
				grid[0][4]=sym;
				occupied.add(3);
				break;
			case 4:
				grid[2][0]=sym;
				occupied.add(4);
				break;
			case 5:
				grid[2][2]=sym;
				occupied.add(5);
				break;
			case 6:
				grid[2][4]=sym;
				occupied.add(6);
				break;
			case 7:
				grid[4][0]=sym;
				occupied.add(7);
				break;
			case 8:
				grid[4][2]=sym;
				occupied.add(8);
				break;
			case 9:
				grid[4][4]=sym;
				occupied.add(9);
				break;
			default:
				System.out.println("Invalid number");
			}
	}
	private boolean checkCondition(String player) {
		String winner;
		if(player.equals("user")){
			winner = "User";
		}else {
			winner = "CPU";
		}
		if(grid[0][0]==grid[0][2]&&grid[0][2]==grid[0][4]&&grid[0][4]!=' ') {
			System.out.println("Winner is "+winner);
			return true;
		}else if(grid[2][0]==grid[2][2]&&grid[2][2]==grid[2][4]&&grid[2][4]!=' ') {
			System.out.println("Winner is "+winner);
			return true;
		}else if(grid[4][0]==grid[4][2]&&grid[4][2]==grid[4][4]&&grid[4][4]!=' ') {
			System.out.println("Winner is "+winner);
			return true;
		}else if(grid[0][0]==grid[2][0]&&grid[2][0]==grid[4][0]&&grid[4][0]!=' ') {
			System.out.println("Winner is "+winner);
			return true;
		}else if(grid[0][2]==grid[2][2]&&grid[2][2]==grid[4][2]&&grid[4][2]!=' ') {
			System.out.println("Winner is "+winner);
			return true;
		}else if(grid[0][4]==grid[2][4]&&grid[2][4]==grid[4][4]&&grid[4][4]!=' ') {
			System.out.println("Winner is "+winner);
			return true;
		}else if(grid[0][0]==grid[2][2]&&grid[2][2]==grid[4][4]&&grid[4][4]!=' ') {
			System.out.println("Winner is "+winner);
			return true;
		}else if(grid[0][4]==grid[2][2]&&grid[2][2]==grid[4][0]&&grid[4][0]!=' ') {
			System.out.println("Winner is "+winner);
			return true;
		}else {
			return false;
		}
	}
}