//Ivan Matos

import java.util.Random;
import java.util.Scanner;
import java.util.Scanner;
public class HW3 {

	public static final int MAX = 2; // 0 1 2
	public static void main(String[] args) {

		Random r = new Random();
		Scanner key = new Scanner(System.in);		//Create scanner and random 
		
		int computerScore = 0;
		int playerScore = 0;
		
		while (true)
		{
			for (int i = 0; i < 3; i++)    //Loop for three rounds
			{
				System.out.println("\nRound "+(i+1)+". Please enter \"rock\", \"paper\", or \"scissors\":");
				
				String playerChoice = key.nextLine();
				
				if (playerChoice.equalsIgnoreCase("rock") && playerChoice.equalsIgnoreCase("paper") && playerChoice.equalsIgnoreCase("scissors"))
				{
					System.out.println("Invalid choice! Computer gets a point.");		//Computer gets a point for invalid choice
					computerScore++;	
				}
				
				else
				{
					int	computerInt = r.nextInt(MAX);
					
					String computerChoice = "";
					
					switch (computerInt)
					{
					case 0:
						computerChoice = "rock";			//Set each random int to rock paper or scissors
						break;
					case 1:
						computerChoice = "paper";
						break;
					case 2:
						computerChoice = "scissors";
						break;
					}
					
					System.out.println("You chose "+playerChoice+". Computer chose "+computerChoice+".");
					
					if(playerChoice.equalsIgnoreCase(computerChoice))
					{
						System.out.println("You tied this round.");
					}
					else if(playerChoice.equalsIgnoreCase("rock") && computerChoice.equalsIgnoreCase("scissors") || playerChoice.equalsIgnoreCase("paper") && computerChoice.equalsIgnoreCase("rock") || playerChoice.equalsIgnoreCase("scissors") && computerChoice.equalsIgnoreCase ("papaer"))
					{
						System.out.println("You win this round.");
						playerScore++;
					}
					else
					{
						System.out.println("You lose this round.");
						computerScore++;
					}
				}				
			}
			
			System.out.println("\nYour score was "+playerScore+". Computer's score was "+computerScore+".");

			if (playerScore > computerScore)
			{
				System.out.println("You win the game.");
			}
			else if (computerScore > playerScore)
			{
				System.out.println("You lose the game.");
			}
			else
			{
				System.out.println("You tied the game.");
			}
				
			System.out.println("Do you want to play again? (yes/no)");
			
            String response = key.nextLine();
            
            if (response.equalsIgnoreCase("no")) 
            {								
                break;
            }
            
            playerScore = 0;
            computerScore = 0;			//Reset scores at the end of the game 
			
		}	
		
	}

}
