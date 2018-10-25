import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Set main vars
		int str, dex, cons, intl, wis, chari;
		str = dex = cons = intl = wis = chari = 0;
		int[] rolls = new int[6];
		String[] statTitles = {"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma"};
		int[] used = new int[6];
		
		// Get results of the rolls using getRandInt and getRoll
		System.out.println("ROLL RESULTS: ");
		for (int i = 0; i < 6; i++) {
			rolls[i] = getRoll();
		}
		for (int i = 0; i < 6; i++) {
			int rollcount = i+1;
			System.out.println(rollcount+": "+rolls[i]);
		}
		
		// Assignment code
		System.out.println("\nAssign the rolls to stats (NOTE: enter roll number, not value) ");
		System.out.print("Available stats: ");
		for (int i = 0; i < 6; i++) {
			System.out.print(statTitles[i]+" ");
		}
		System.out.println(" ");
		Scanner s = new Scanner(System.in);
		int ans;
		for (int i = 0; i < 6; i++) {
			System.out.print(statTitles[i]+": ");
			ans = s.nextInt();
			boolean checkUsed = false;
			for (int c = 0; c < used.length; c++) {
				if (used[c] == ans) {
					checkUsed = true;
				}
			}
			if (checkUsed) {
				System.out.println("Value already used! Try again");
				i--;
			} else if (ans > 6) {
				System.out.println("Value out of range! Try again");
				i--;
			} else {
				switch (i) {
				case 0: str = rolls[ans-1];
				case 1: dex = rolls[ans-1];
				case 2: cons = rolls[ans-1];
				case 3: intl = rolls[ans-1];
				case 4: wis = rolls[ans-1];
				case 5: chari = rolls[ans-1];
				}
				used[i] = ans; // Add selection to used array
			}
		}
		s.close();
		
		// Output stats
		System.out.println("\nAssignment completed! Here are your stats: ");
		System.out.println("Strength: "+str);
		System.out.println("Dexterity: "+dex);
		System.out.println("Constitution: "+cons);
		System.out.println("Intelligence: "+intl);
		System.out.println("Wisdom: "+wis);
		System.out.println("Charisma: "+chari);
	}
	
	// Use Math.random() to return an int between 1-6 inclusively
	public static int getRandInt() {
		double num = (int)(Math.random()*((6-1)+1))+1;
		int res = (int)num;
		return res;
	}
	
	public static int getRoll() {
		// Rolls 4 times, then returns the sum of the highest 3 rolls in keeping with D&D rules
		int[] rolls = new int[4];
		for (int i = 0; i < 4; i++) {
			rolls[i]=getRandInt();
		}
		Arrays.sort(rolls);
		int total = rolls[1]+rolls[2]+rolls[3]; // Sum of highest 3 of 4 rolls
		return total;
	}

}
