import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;
import java.util.Arrays;

public class CPTcarter1{
	public static void main(String[] args){
		Console con = new Console("BlackJack", 1280, 720);
		// Variables
		Font fntTNRjoke = con.loadFont("times.ttf", 10);
		Font fntTNR = con.loadFont("times.ttf", 35);
		Font fntTNRsmall = con.loadFont("times.ttf", 20);
		BufferedImage imgPoker = con.loadImage("Blackjack.png");
		
		
		// Main Menu
		// Background
		con.setBackgroundColor(new Color(255, 255, 255));
		
		// Menu Drawings / Words
		con.setDrawColor(new Color(211, 211, 211));
		con.setDrawFont(fntTNRjoke);
		con.drawString("super secret joke :) [ J ]", 0, 0);
		
		con.setDrawColor(new Color(0, 0, 0));
		con.setDrawFont(fntTNR);
	
		con.drawString("Main Menu", 560, 300);
		con.drawString("Play [ P ]", 570, 340);
		con.drawString("Leaderboard [ L ]", 530, 380);
		con.drawString("Help [ H ]", 570, 420);
		con.drawString("Exit [ X ]", 570, 460);
		
		con.drawImage(imgPoker, 512, 30);
		con.repaint();	
			
		// Inputs
		char chrInput = con.getChar();
		System.out.println("entered letter: "+chrInput);
		
		if(chrInput == 'P' || chrInput == 'p'){ // Playing game
			con.clear();
			con.setBackgroundColor(new Color(0, 0, 0));
			
		}else if(chrInput == 'L' || chrInput == 'l'){ // Leaderboard
			con.clear();
			
		}else if(chrInput == 'H' || chrInput == 'h'){ // Help
			con.clear();
			con.setBackgroundColor(new Color(255, 255, 255));
			
			con.drawImage(imgPoker, 512, 30);
			
			con.setDrawColor(new Color(0, 0, 0));
			con.setDrawFont(fntTNR);
			
			con.drawString("Help Menu", 560, 300);
			con.drawString("Basic Rules [ R ]", 560, 300);
			con.drawString("Special Rules [ S ]", 560, 340);
			con.drawString("Credits [ C ]", 550, 380);
			con.repaint();	
			
			char chrHelpInput = con.getChar();
			System.out.println("entered letter: "+chrHelpInput);
			
			if(chrHelpInput == 'R' || chrHelpInput == 'r'){ // Basic Rules
				con.clear();
				con.setBackgroundColor(new Color(255, 255, 255));
				con.setDrawColor(new Color(0, 0, 0));
				con.setDrawFont(fntTNRsmall);
				
				
				
			}else if(chrHelpInput == 'S' || chrHelpInput == 's'){ // Special Rules
				con.clear();
				con.setBackgroundColor(new Color(255, 255, 255));
				con.setDrawColor(new Color(0, 0, 0));
				con.setDrawFont(fntTNRsmall);
				con.drawString("Here are some of the special features that make the game called BlackJack", 300, 300);
				con.drawString("Double Down - If your first 2 cards add up to 9, 10 or 11, you will double your bet and draw one more card.", 200, 340);
				con.drawString("Five Cards - If you reach 5 cards, you automatically get 3x your bet but same applies to dealers.", 230, 380);
				con.drawString("Black Jack - If your first two cards equals to 21, you multiply 3x your original bet", 290, 420);
				con.drawString("Exit [ X ]",570, 460);
				con.repaint();
				
				char chrHelpExit = con.getChar();
				System.out.println("entered letter: "+chrHelpExit);
				
				if(chrHelpExit == 'X' || chrHelpExit == 'x'){
					con.closeConsole();
				}
			}else if(chrHelpInput == 'C' || chrHelpInput == 'c'){ // Credits
				con.clear();
				con.setBackgroundColor(new Color(255, 255, 255));
				con.setDrawColor(new Color(0, 0, 0));
				con.setDrawFont(fntTNR);
				con.drawString("Made By Carter :)", 520, 300);
				con.drawString("Exit [ X ]",570, 340);
				con.repaint();
				
				char chrHelpExit = con.getChar();
				System.out.println("entered letter: "+chrHelpExit);
				if(chrHelpExit == 'X' || chrHelpExit == 'x'){
					con.closeConsole();
				}
				
			}
		}else if(chrInput == 'X' || chrInput == 'x'){ // Exit
			con.closeConsole();
		}else if(chrInput == 'J' || chrInput == 'j'){ // Joke
			con.clear();
			con.setBackgroundColor(new Color(255, 255, 255));
			con.setDrawColor(new Color(0, 0, 0));
			con.setDrawFont(fntTNR);
			con.drawString("Why wasn't the Cactus invited to hangout with the Mushrooms?", 200, 300);
			con.drawString("He wasn't a FUNGI!", 520, 340);
			con.repaint();
		}
			
		// Gameplay
		
		
		
	
		
	}
}
