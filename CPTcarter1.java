import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class CPTcarter1{
	public static void main(String[] args){
		Console con = new Console("BlackJack", 1280, 720);
		// Main Menu
		// Background
		con.setBackgroundColor(new Color(255, 255, 255));
		
		// Words
		con.setDrawColor(new Color(0, 0, 0));
		Font fntTNRjoke = con.loadFont("times.ttf", 10);
		con.setDrawFont(fntTNRjoke);
		con.drawString("super secret joke :) [ J ]", 0, 0);
		
		Font fntTNR = con.loadFont("times.ttf", 35);
		con.setDrawFont(fntTNR);
	
		con.drawString("Main Menu", 560, 300);
		con.drawString("Play [ P ]", 570, 340);
		con.drawString("Leaderboard [ L ]", 530, 380);
		con.drawString("Help [ H ]", 570, 420);
		con.drawString("Quit [ Q ]", 570, 460);
		
		
		BufferedImage imgPoker = con.loadImage("Blackjack.png");
		con.drawImage(imgPoker, 512, 30);
		con.repaint();	
			
		// Inputs
		char chrInput = con.getChar();
		
		if(chrInput == 'P' || chrInput == 'p'){ 
			con.clear();
			con.setBackgroundColor(new Color(0, 0, 0));
			
		}else if(chrInput == 'L' || chrInput == 'l'){
			con.clear();
			
		}
			
			
			
		// Card array
		
		int[][] intCards = new int[14][5];
		
		intCards[1][1] = 1;
		intCards[2][1] = 2;
		intCards[3][1] = 3;
		intCards[4][1] = 4;
		intCards[5][1] = 5;
		intCards[6][1] = 6;
		intCards[7][1] = 7;
		intCards[8][1] = 8;
		intCards[9][1] = 9;
		intCards[10][1] = 10;
		intCards[11][1] = 11;
		intCards[12][1] = 12;
		intCards[13][1] = 13;
		intCards[1][2] = 14;
		intCards[2][2] = 15;
		intCards[3][2] = 16;
		intCards[4][2] = 17;
		intCards[5][2] = 18;
		intCards[6][2] = 19;
		intCards[7][2] = 20;
		intCards[8][2] = 21;
		intCards[9][2] = 22;
		intCards[10][2] = 23;
		intCards[11][2] = 24;
		intCards[12][2] = 25;
		intCards[13][2] = 26;
		
	
		
	}
}
