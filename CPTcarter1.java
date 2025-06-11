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
			}
			
			while(blnPlay = true && intMoney > 0){
				con.clear();
				
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
				con.closeConsole();
				
				}
					
				int intDeck[][] = Cartertools.DeckCards();
				
				int[][] intPlayer = new int[5][2];
				int[][] intDealer = new int[5][2];
					
				int intcount;	
				// Printing Starting cards
				String strDealerTemp;
				String strDealerTemp2;
				String strPlayerTemp;
				String strPlayerTemp2;
				// Player hand values
				int intPlayerCards = 2;
				int intPlayerHand = 0;
				int intPSum = 0;
				// order of shuffled deck
				int intDeckNum = 0;
				// player turn end when double down
				boolean blnDD = true;
				// Hit or stand
				char chrHS;
				// Dealer hand values
				int intDealerCards = 2;
				int intDSum = 0;
				
				// setting up the player and dealer hand 
				for(intcount = 0; intcount < 5; intcount++){
					intPlayer[intcount][0] = intDeck[intcount][0];
					intPlayer[intcount][1] = intDeck[intcount][1];
		
					intDealer[intcount][0] = intDeck[intcount + 5][0];
					intDealer[intcount][1] = intDeck[intcount + 5][1];
				}
					
				// Dealers hand
				con.clear();
				strDealerTemp = Cartertools.CardsName(intDealer[0][0], intDealer[0][1]);
				strDealerTemp2 = Cartertools.CardsName(intDealer[1][0], intDealer[1][1]);
				con.println("The dealer's cards are: ");
				con.println("Dealer card 1: "+strDealerTemp);
				con.println("Hidden card");
				con.println();
				System.out.println("dealer card 1: "+strDealerTemp);
				System.out.println("Hidden card: "+strDealerTemp2);
				
				// Players hand
				con.println("Your hand: ");
				
				// Players first card
				strPlayerTemp = Cartertools.CardsName(intPlayer[0][0], intPlayer[0][1]);
				con.println(strPlayerTemp);
				System.out.println("Player card 1: "+strPlayerTemp);
				// Players second card
				strPlayerTemp2 = Cartertools.CardsName(intPlayer[1][0], intPlayer[1][1]);
				con.println(strPlayerTemp2);
				System.out.println("Player card 2: "+strPlayerTemp2);
					
				con.println();
				
				intPSum = Cartertools.handValue(intPlayer, intPlayerCards);
				
				con.println("Current hand Value: "+ intPSum);
				System.out.println("Sum: "+intPSum);
					
				if(intPSum == 21 && intPlayerCards == 2){ // BlackJack 
					intMoney = intMoney + intBet * 3;
					con.println("BlackJack!!! You get 3x your bet!");
					System.out.println("Money = "+intMoney);
					
				}else if(intPSum == 9 || intPSum == 10 || intPSum == 11){ // Double Down
					con.println("Do you want to double down? [ Y ]/[ N ]");
					char chrDoubleDown;
					chrDoubleDown = con.getChar();
					if(chrDoubleDown == 'Y' || chrDoubleDown == 'y' && intMoney >= intBet * 2){ // If they want to Double down
						intBet = intBet * 2;
							
						// Third card
						intPlayer[intPlayerCards][0] = intDeck[intDeckNum][0];
						intPlayer[intPlayerCards][1] = intDeck[intDeckNum][1];
							
						String strDD;
						strDD = Cartertools.CardsName(intPlayer[intPlayerCards][0], intPlayer[intPlayerCards][1]);
							
						intDeckNum++;
						intPlayerCards++;
							
						con.println("Your new card is "+strDD);
						con.sleep(10000);
						// new sum
						intPSum = Cartertools.handValue(intPlayer, intPlayerCards);
						System.out.println("New sum: "+intPSum);
							
						// make it so that double down ends your turn
						blnDD = false;
						// if player doesn't have enough money
					}else if(intMoney < intBet * 2){
						con.println();
						con.println("You do not have enough to Double down");
					}
				}
					
				// hit or stay
				con.println();
				if(blnDD == true && intPSum < 21){
					
					boolean blnhit = true;
					
					while(blnDD == true && intPSum < 21 && blnhit == true){
					
						con.println("Do you want to hit or stand? [ H ]/[ S ]");
						chrHS = con.getChar();
						
						if(chrHS == 'H' || chrHS == 'h'){
							// Third card
							intPlayer[intPlayerCards][0] = intDeck[intDeckNum][0];
							intPlayer[intPlayerCards][1] = intDeck[intDeckNum][1];
							
							strPlayerTemp = Cartertools.CardsName(intPlayer[intPlayerCards][0], intPlayer[intPlayerCards][1]);
							con.println();
							con.println("Your new card is "+strPlayerTemp);
							con.println();
							
							intDeckNum++;
							intPlayerCards++;
							
							intPSum = Cartertools.handValue(intPlayer, intPlayerCards);
							
							System.out.println("New sum "+intPSum);
							con.sleep(100);
							
						}else if(chrHS == 'S' || chrHS == 's'){
							blnhit = false;
						}else{
							blnhit = false;
						}
						
						// 5 card win scenario
						if(intPlayerCards == 5 && intPSum <= 21){
							con.println("You got 5 cards! You automatically win 3x your bet!");
							intMoney = intMoney + intBet * 3;
							con.println("Press any key to continue.");
							con.getChar();
							System.out.println("money: "+intMoney);
							continue;
						}else if(intPSum > 21){
							// Player Busted
							con.println("You Busted!");
						}else{
							// Calculating Sum of dealers hand
							intDSum = Cartertools.handValue(intDealer, intDealerCards);
							// Draw until 17
							while(intDSum < 17){
								// Third Card
								intDealer[intDealerCards][0] = intDeck[intDeckNum][0];
								intDealer[intDealerCards][1] = intDeck[intDeckNum][1];
								intDeckNum++;
								intDealerCards++;
								intDSum = Cartertools.handValue(intDealer, intDealerCards);
							}
							while(blnhit == false){
								// revealing dealers hand
								con.println();
								con.println("Dealer's Hand is: ");
								for(int intCount = 0; intCount < intDealerCards; intCount++){
									strDealerTemp = Cartertools.CardsName(intDealer[intCount][0], intDealer[intCount][1]);
									con.println(strDealerTemp);
								}
							
								con.println();
								con.println("The dealer's sum is: "+intDSum);
								con.sleep(500);
							
								if(intDSum > 21 || intPSum > intDSum){
									// player wins
									con.println("You win!");
									intMoney = intMoney + intBet * 2;
								}else if(intPSum == intDSum){
									// player draws
									con.println("Push");
									intMoney = intMoney + intBet;
								}else{
									// player loses
									con.println("You lost");
								}
								System.out.println("money: "+intMoney);
								blnhit = true;
							}
						}
						
						// See if user wants to play again
						con.println();
						con.println("Play Again? [ Y ]/[ N ]");
						char chrPlayAgain = con.getChar();
						if(chrPlayAgain == 'Y' || chrPlayAgain == 'y'){
							blnPlay = true;
							if(intMoney <= 0){
								// Player is out of money
								con.println("Not enough money left to play again.");
								con.println("Press any key to return to menu.");
								con.sleep(10000);
								con.println("GG welll played");
								con.sleep(2000);
								con.closeConsole();
							}
							return;
						}else if(chrPlayAgain == 'N' || chrPlayAgain == 'n'){
							blnPlay = false;
						}
						
					}
					
					TextOutputFile leaderboard = new TextOutputFile("leaderboard.txt", true);
					leaderboard.println(strName);
					leaderboard.println(intMoney);
					leaderboard.close();
					
				}
					
		}
			
		}else if(chrInput == 'L' || chrInput == 'l'){ // Leaderboard
			con.clear();
			
			con.setBackgroundColor(new Color(0, 0, 0));
			con.setDrawColor(new Color(0, 0, 0));
			con.setDrawFont(fntTNR);
			
			TextInputFile leaderboard = new TextInputFile("leaderboard.txt");
		
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
