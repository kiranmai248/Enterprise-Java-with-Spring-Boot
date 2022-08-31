package GuessingGame;

import java.util.Scanner;

public class GuessingGame {
	public static void main(String args[])
	{
		// TODO Auto-generated method stub
		GuessingGame gg=new GuessingGame();
		gg.start();
	}
	public void start() {
	int NumOfPlayers;
    int flag=0;
    int chance=0;
    Scanner sc=new Scanner(System.in);
	System.out.print("Enter the number of players: ");
    NumOfPlayers=sc.nextInt();
    while(NumOfPlayers<1 || NumOfPlayers >5) {
    System.out.println("Enter the the number again as the number of players should be in the range of 1 to 5:");
    NumOfPlayers=sc.nextInt();
    }
    Play pla=new Play();
    int []a=new int[NumOfPlayers];
    pla.play(NumOfPlayers,flag,chance,a);
    }
}
	
class Guesser{
		int guessNum;
		public int guessedNum(int flag1) {
		Scanner sc=new Scanner(System.in);
		int flag=0;
		if(flag1==0)
			flag1=flag+1;
		do {
			if(flag==0) {
			System.out.print("Enter the number:");
			flag=1;
			}
			else
			System.out.print("Enter the number as again as it is not in the given range:");
			guessNum=sc.nextInt();
		}while(guessNum<0 || guessNum>(100/flag1));
		
		return guessNum;
		}
		
	}
	class Player{
	int guessNumber;
	public int playerGuess(int flag) {
	Scanner sc=new Scanner(System.in);
	guessNumber=sc.nextInt();
	if (flag!=0)
		while(guessNumber<0 || guessNumber >(100/flag)) {
		System.out.println("Enter the number again as the number should be in the range of 0 to "+(100/flag));
		guessNumber=sc.nextInt();
		}
	return guessNumber;
	}
	}
	
class Play{
		
public void play(int NumOfPlayers,int flag,int chance,int []a)
{
			Guesser gue=new Guesser();
			int num =gue.guessedNum(flag);
			int j=0;
			
			for(int i=0;i<NumOfPlayers;i++)
			{
				if(chance==0)
				{
					System.out.println("Guess the number by player :"+(i+1));
					Player p=new Player();
					
					 int playerGuess=p.playerGuess(flag);
					 if(playerGuess==num)
					 {
						 a[j]=i+1;
						 j++;
					 }
					 
				}
				else
				{
					System.out.println("Guess the number by player :"+a[i]);
					Player p=new Player();
					
			int PlayerGuess=p.playerGuess(flag);
			if(PlayerGuess==num)
			{
				a[j]=a[i];
				j++;
			}
				}
			}
			if (j>1 && j<=NumOfPlayers)
			{
				
				System.out.print("There is tie among the players");
				for(int i=0;i<j;i++)
				{
					System.out.print(a[i]+" ");
				}
				System.out.print("\n");
				NumOfPlayers=j;
				chance=1;
				this.play(NumOfPlayers, flag, chance, a);
				
			}
			else if(j==1)
			{
				System.out.print("Hurrya..........player "+a[0]+" is the winner");
				this.restart();
			}
			else if (j==0)
			{
				if(flag<4)
				{
					System.out.print("require the clue: number should be in the range of 0 to "+(100/(flag+1)));
					flag++;
					this.play(NumOfPlayers, flag, chance, a);
				}
				else
					System.out.println("No one won the game.............all the chances exceeded..................might start the game again");
				   this.restart();
				
		     }}
public void restart() {
	Scanner sc=new Scanner(System.in);
	System.out.println("Do you wanna play again if yes plese enter 1 or else  enter 0:");
	int n=sc.nextInt();
	if(n==1)
	{
		GuessingGame.main(null);
	}
	else
		System.exit(0);
}
	}
