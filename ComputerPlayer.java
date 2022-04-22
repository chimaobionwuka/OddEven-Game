/**
 *ComputerPlayer.java
 * Name: Chimaobi Onwuka
 * UNI: ceo2134
 * Date: 3/8/22
 * Purpose: This class represents a computer
 * player in the Odd-Even game
 * 
 *  
 */

public class ComputerPlayer
{
    // Instance variables of class
    private double t;
    private int tokenBalance;

    private double compVal;
    private int compDec;
    private int roundSum;

    
    // This is the constructor for the Computer Player Class
    public ComputerPlayer(double threshold) 
    {
        t=threshold;
        tokenBalance=0;
    }

    // This is the method that determines what the Computer Declares in the 1v1
    public void CompShoot()
    {
        compVal = Math.random();
        if (compVal > t)
        {
            compDec = 2;
        }
        else
        {
            compDec = 1;
        }

    }

    //This accessor method adds the value of P1 and P2's declarations to the Computer's tokenBalance
    //if the Computer wins

    public void CwinCoins(int roundSum)
    {
        roundSum = roundSum;
        tokenBalance = tokenBalance + roundSum;
    }

    //This accessor method subtracts the value of P1 and P2's declarations to the Computer's tokenBalance
    //if the Computer loses
    public void CloseCoins(int roundSum)
    {
        roundSum = roundSum;
        tokenBalance = tokenBalance - roundSum;

    }
    
    //Accessor methods that return current Computer's token balance and declaration
    public int getcompBal()
    {
        return tokenBalance;
    }

    public int getcompDec()
    {
        return compDec;
    }
    
}