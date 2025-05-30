import arc.*;
import java.awt.Color;

public class CPTcarter1{
	public static void main(String[] args){
		Console con = new Console("BlackJack", 1280, 720);
		// Main Menu
		// Background
		con.setDrawColor(new Color(255, 255, 255));
		con.fillRect(0, 0, 1280, 720);
		
		// Words
		con.setDrawColor(new Color(0, 0, 0));
		con.drawString("Main Menu", 600, 50);
		con.drawString("Play [ P ]", 600, 200);
		con.drawString("Leaderboard [ L ]", 600, 230);
		con.drawString("Play [ P ]", 600, 200);
		
		
		// Variables
		
		// Card array
		
		int intCards;
		
		//intCards = new int[13][4];
		
		
	}
}
