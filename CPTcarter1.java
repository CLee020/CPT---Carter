import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;
import java.util.Arrays;

public class CPTcarter1{
	public static void main(String[] args){
		Console con = new Console("BlackJack", 1280, 720);
		// Fonts and images
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
			// Setting Varialbes
			boolean blnPlay = true;
			String strName = "";
			int intMoney = 1000;
			
			// Cleaning the console
			con.setBackgroundColor(new Color(255, 255, 255));
			con.repaint();
			
			// Entering Username
			con.setTextColor(new Color(0, 0, 0));
			con.println("Enter your username");
			strName = con.readLine();
			
			// Cheating is fun
			if(strName.equalsIgnoreCase("statitan")){
			intMoney = 10000000;
			
				while(blnPlay = true && intMoney > 0){
					con.clear();
					int intBet;
					
					// Bet amount
					con.println("you have $"+intMoney+". Place your Bet:");
					intBet = con.readInt();
					con.clear();
					
					intMoney = intMoney - intBet;
					
					if(intMoney < intBet){
					con.println("Not enough money to bet.");
					con.sleep(1000);
					con.closeConsole();
					
					}else if(intBet <= 0){
					con.println("Invalid bet.");
					con.sleep(1000);
					}
					
					int intDeck[][] = Cartertools.DeckCards();
					
					int[][] intPlayer = new int[5][2];
					int[][] intDealer = new int[5][2];
						
					int intcount;	
						
					for(intcount = 0; intcount < 5; intcount++){
						intPlayer[intcount][0] = intDeck[intcount][0];
						intPlayer[intcount][1] = intDeck[intcount][1];
		
						intDealer[intcount][0] = intDeck[intcount + 5][0];
						intDealer[intcount][1] = intDeck[intcount + 5][1];
					}
					
						
					
				}
			}
			
			
		}else if(chrInput == 'L' || chrInput == 'l'){ // Leaderboard
			con.clear();
			
		}else if(chrInput == 'H' || chrInput == 'h'){ // Help
			con.clear();
			con.setBackgroundColor(new Color(255, 255, 255));
			
			con.drawImage(imgPoker, 512, 30);
			
			con.setDrawColor(new Color(0, 0, 0));
			con.setDrawFont(fntTNR);
			
			con.drawString("Help Menu", 560, 300);
			con.drawString("Basic Rules [ R ]", 560, 340);
			con.drawString("Special Rules [ S ]", 560, 380);
			con.drawString("Credits [ C ]", 550, 420);
			con.repaint();	
			
			char chrHelpInput = con.getChar();
			System.out.println("entered letter: "+chrHelpInput);
			
			if(chrHelpInput == 'R' || chrHelpInput == 'r'){ // Basic Rules
				con.clear();
				con.setBackgroundColor(new Color(255, 255, 255));
				con.setDrawColor(new Color(0, 0, 0));
				con.setDrawFont(fntTNRsmall);
				con.drawString("The goal is to get as close to 21 as possible without going over", 400, 200);
				con.drawString("Beat the dealer's hands to win 2x your bet",480,240);
				con.drawString("Each player is dealt 2 hands ",530,280);
				con.drawString("Face cards ( J, Q, K ) are worth 10",510,320);
				con.drawString("Aces are worth 11 or 1 when you push over 21",470,360);
				con.drawString("Player can choose to hit ( draw another card ) or stand ( End turn )",400,400);
				con.drawString("Dealer hits until 17 is reached",530,440);
				con.drawString("Exit [ X ]",610,480);
				con.repaint();
				
				char chrHelpExit = con.getChar();
				System.out.println("entered letter: "+chrHelpExit);
				
				if(chrHelpExit == 'X' || chrHelpExit == 'x'){ // Exit
					con.closeConsole();
				}
				
			}else if(chrHelpInput == 'S' || chrHelpInput == 's'){ // Special Rules
				con.clear();
				con.setBackgroundColor(new Color(255, 255, 255));
				con.setDrawColor(new Color(0, 0, 0));
				con.setDrawFont(fntTNRsmall);
				con.drawString("Here are some of the special features that make the game called BlackJack", 300, 300);
				con.drawString("Double Down - If your first 2 cards add up to 9, 10 or 11, you will double your bet and draw one more card.", 200, 340);
				con.drawString("Five Cards - If you reach 5 cards, you automatically get 3x your bet but same applies to dealers.", 230, 380);
				con.drawString("Black Jack - If your first two cards equals to 21, you multiply 3x your original bet", 290, 420);
				con.drawString("Exit [ X ]",590, 460);
				con.repaint();
				
				char chrHelpExit = con.getChar();
				System.out.println("entered letter: "+chrHelpExit);
				
				if(chrHelpExit == 'X' || chrHelpExit == 'x'){ // Exit
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
				
				if(chrHelpExit == 'X' || chrHelpExit == 'x'){ // Exit
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
			
		
		
		
		
	
		
	}
}
