/**
 * File Name: Game.java
 * Name: Chimaobi Onwuka
 * UNI: ceo2134
 * Date: 3/8/22
 * Purpose: This class represents the Odd-Even game
 * 
 * 
 */

import java.util.Scanner;

public class Game
{
    //Instance Variables for Interactive Player vs. Computer Game
    private int roundSum;
    private int compBal; //might not be necessary
    private int playerTokenBalance = 0;
    private int playerDec;
    private int compDec;
    private ComputerPlayer Computer;
    private Scanner input = new Scanner(System.in); 
    private int point = 1;
    private boolean playAgain;

//Instance Variables for the Simulated Computer vs. Computer Game
    private ComputerPlayer Computer1;
    private ComputerPlayer Computer2;
    private int comp1Dec;
    private int comp2Dec;
   
/* this version of the game constructor is for Part 1
 * it takes no parameters */
    public Game()
    {
        System.out.println("Hello. Welcome to OddEven game. You are Player 1.");
        Computer = new ComputerPlayer(0.5);
    }

    //Player 1 Decleration Entry
    private void UserEntry()
    {
        System.out.println("What number would you like to declare? '1' or '2'?");
        playerDec = input.nextInt();
        System.out.println("*Your Declaration is " + playerDec + "*.");
    }
    
/* this version of the game constructor is for Part 2
 * It requires two doubles as parameters. You will use 
 * these to set the initial thresholds for you computer players */
    public Game (double t1, double t2)
    {
       Computer1 = new ComputerPlayer(t1);
       Computer2 = new ComputerPlayer(t2);
    }
    
/* this version of the play method is for Part 1
 * It takes no parameters and should play the interactive
 * version of the game */
    public void play()
    {
        playCall();
        roundSum = (playerDec + compDec);
        playAgain = true;

        while (playAgain == true && point == 1)
        {
            if ((roundSum % 2) == 0)
            {
                pWinCoins();
                Computer.CloseCoins(roundSum);
                System.out.println("Round sum is " + roundSum + ".");
                System.out.println("Congrats! You (Even) won.");
            }

            else if ((roundSum % 2) != 0)
            {
                pLoseCoins();
                Computer.CwinCoins(roundSum);
                System.out.println("Round sum is " + roundSum + ".");
                System.out.println("Aw Shucks! You lost and Computer (Odd) won.");
            }
            Continue();
        }
    
    }
    
/** this version of the play method is for Part 2
 * It takes a single int as a parameter which is the
 * number of computer vs. computer games that should be played */
    public void play(int games)
    {

        for (int i=0; i<games; i++)
        {
        Computer1.CompShoot();
        Computer2.CompShoot();
        comp1Dec = Computer1.getcompDec();
        comp2Dec = Computer2.getcompDec();
        roundSum = (comp2Dec + comp1Dec);

        if ((roundSum % 2) == 0)
            {
                Computer2.CwinCoins(roundSum);
                Computer1.CloseCoins(roundSum);
            }

            else if ((roundSum % 2) != 0)
            {
                Computer1.CwinCoins(roundSum);
                Computer2.CloseCoins(roundSum);
            }
        }
    }

/* this method should return the current score (number of tokens)
 * that player 1 has */
    public int getP1Score()
    {
        return Computer1.getcompBal();
    }
    
/* this method should return the current score (number of tokens)
 * that player 2 has */
    public int getP2Score()
    {
        return Computer2.getcompBal();
    }  

    //Faciliates the play again sequence for interactive game
    private void Continue()
    {
        playAgain = false;
        System.out.println("Computer Score is " + getP1()+ ".");
        System.out.println("Your Score is " + getP2()+ ".");
        System.out.println("Would you like to play again? Type '1' for Yes or '2' for No.");
        point = input.nextInt();
        if (point == 1)
        {
            playAgain = true;
            play();
        }
        else if (point == 2)
        {
            playAgain = false;
            System.out.println("Thank you for playing the game. Come again soon!");
        }
    }

    //Mut & Access Methods to retrieve, +, & -  player, computer, & roundSum vars
    private void pWinCoins()
    {
        playerTokenBalance = playerTokenBalance + roundSum;
    }

    private void pLoseCoins()
    {
        
        playerTokenBalance = playerTokenBalance - roundSum;
    }
    
    private int getRoundSum()
    {
        return roundSum;
    }
    private int getP1()
    {
        return Computer.getcompBal();
    }
    private int getP2()
    {
        return playerTokenBalance;
        
    }  
    //Calls User Entry Method, tells Computer to declare a value using CompShoot method, prints compDec
    private void playCall()
    {
        UserEntry();
        Computer.CompShoot();
        compDec = Computer.getcompDec();
        System.out.println("*Computer Declaration is " + compDec + "*.");
    }

}