import arc.*;

public class Cartertools{

		
	public static int[][] DeckCards(){
	
	int intDeck[][] = new int[52][3];
	int intCards = 0;
	int intValue = 0;
	int intSuit = 0;
	
	for(intSuit = 0; intSuit <= 3; intSuit++){
		for(intValue = 0; intValue <= 12; intValue++){
			intDeck[intCards][0] = intValue;
			intDeck[intCards][1] = intSuit;
			intDeck[intCards][2] = (int)(Math.random() * 100 + 1);
			intCards++;
		}
	}
	
	int intTempValue;
	int intTempSuit;
	int intTempInteger;
	
	// Sorting
	for(int intCount2 = 0; intCount2 < intCards - 1; intCount2++){ 
		for(int intCount = 0; intCount < intCards - 1; intCount++){
			if(intDeck[intCount][2] > intDeck[intCount+1][2]){
				
				// Swapping card
				intTempValue = intDeck[intCount][0];
				intDeck[intCount][0] = intDeck[intCount+1][0];
				intDeck[intCount+1][0] = intTempValue;
				
				// Swapping suit
				intTempSuit = intDeck[intCount][1];
				intDeck[intCount][1] = intDeck[intCount+1][1];
				intDeck[intCount+1][1] = intTempSuit;
				
				// Swapping random integer value 
				intTempInteger = intDeck[intCount][2];
				intDeck[intCount][2] = intDeck[intCount+1][2];
				intDeck[intCount+1][2] = intTempInteger;
				}
			}
		}
		
	for(int intCount = 0; intCount < intCards; intCount++){
		System.out.println(intDeck[intCount][0] + " - " + intDeck[intCount][1] + " - " + intDeck[intCount][2]);
		}
		
	return intDeck;
	}
		
	public static String CardsName(int intValue, int intSuit){
		
	// replacing value with string
	String[] strValues = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
	String[] strSuits = {"Diamonds", "Clubs", "Hearts", "Spades"};
	return strValues[intValue] + " of " + strSuits[intSuit];
	}
		
	
}
