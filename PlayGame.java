/**
 * Name: Dale Savage
 * Course: CSE 271 H
 * Instructor: Chayan Walia
 * Name of Assignment: Go Fish Card Game
 * Purpose: The purpose of this program is to create a functioning go fish card game using card.java, deck.java, and hand.java
 */


import java.util.*; // imports everything

public class PlayGame
{
  
  public static void main(String args[]) throws InvalidCardReference{ 
    Scanner keyboardReader = new Scanner(System.in); // allows us to get the input
    System.out.println("Welcome to a game of Go Fish. How many people are playing? (0 to quit)");
    
    int numPlayers = keyboardReader.nextInt();
    
    while (numPlayers < 0 || numPlayers > 4 || numPlayers == 1)
    {
      System.out.println("Sorry, invalid number of players. Try again.");
      numPlayers = keyboardReader.nextInt();
    }
    
    
    DeckList deck = new DeckList();
    deck.shuffle();
    
    
    Hand player1Hand = new Hand(7);
    Hand player2Hand = new Hand(7);
    Hand player3Hand = new Hand(7);
    Hand player4Hand = new Hand(7);
    
    
    
    boolean game = true;
    int choice = 1;
    
    // GAME VERSION WITH 2 TOTAL PLAYERS
    //---------------------------------------------------
    if(numPlayers == 2)
    {
      for(int i = 0; i < 7; i++)
      {
        player1Hand.addCard(deck.getCard());
      }
      player1Hand.sortHandByRank();
      
      for(int i = 0; i < 7; i++)
      {
        player2Hand.addCard(deck.getCard());
      }
      player2Hand.sortHandByRank();
      
      while (deck.getCardsLeft() > 0 && player1Hand.getHandSize() > 0 && player2Hand.getHandSize() > 0)
      {
        // PLAYER 1 TURN
        System.out.println("Player 1's turn. Your cards are:");
        player1Hand.showHand();
        System.out.println("Move options: (0 to skip)");
        System.out.println("1. Ask player 2 for a card.");
        choice = keyboardReader.nextInt();
        
        while (choice > 1 && choice < 0)
        {
          System.out.println("Invalid input! Input correct choice by number.");
          choice = keyboardReader.nextInt();
        }
        // PLAYER 1 CHOICE 1
        if (choice == 1)
        {
          System.out.println("What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
          int cardRank = keyboardReader.nextInt();
          while(cardRank > 14 || cardRank < 1)
          {
            System.out.println("Invalid card! What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
            cardRank = keyboardReader.nextInt();
          }
          
          boolean hasCard = false;
          int gaveCardCount = 0;
          
          for (int i = 0; i < player1Hand.getHandSize(); i++)
          {
            if (player2Hand.getCard(i).getRank() == cardRank)
            {
              hasCard = true;
              player1Hand.addCard(player2Hand.getCard(i));
              player2Hand.removeCard(i);
              gaveCardCount++;
            }
          }
          
          if (hasCard == true)
          {
            System.out.println("Player 2 gave you " + gaveCardCount + ", " + cardRank + "'s");
          }
          else
          {
            System.out.println("Go fish!");
            player1Hand.addCard(deck.getCard());
          }
          
          
          
        }
        // PLAYER 1 SKIP
        else
        {
          System.out.println("Go fish!");
          player1Hand.addCard(deck.getCard());
        }
        
        
        
        
        
        
        // PLAYER 2 TURN
        System.out.println("Player 2's turn. Your cards are:");
        player2Hand.showHand();
        System.out.println("Move options: (0 to skip)");
        System.out.println("1. Ask player 1 for a card.");
        choice = keyboardReader.nextInt();
        
        while (choice > 1 && choice < 0)
        {
          System.out.println("Invalid input! Input correct choice by number.");
          choice = keyboardReader.nextInt();
        }
        // PLAYER 2 CHOICE 1
        if (choice == 1)
        {
          System.out.println("What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
          int cardRank = keyboardReader.nextInt();
          while(cardRank > 14 || cardRank < 1)
          {
            System.out.println("Invalid card! What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
            cardRank = keyboardReader.nextInt();
          }
          
          boolean hasCard = false;
          int gaveCardCount = 0;
          
          for (int i = 0; i < player1Hand.getHandSize(); i++)
          {
            if (player2Hand.getCard(i).getRank() == cardRank)
            {
              hasCard = true;
              player2Hand.addCard(player1Hand.getCard(i));
              player1Hand.removeCard(i);
              gaveCardCount++;
            }
          }
          
          if (hasCard == true)
          {
            System.out.println("Player 1 gave you " + gaveCardCount + ", " + cardRank + "'s");
          }
          else
          {
            System.out.println("Go fish!");
            player2Hand.addCard(deck.getCard());
          }
        }
        // PLAYER 2 SKIP
        else
        {
          System.out.println("Go fish!");
          player2Hand.addCard(deck.getCard());
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
      } // end 2 players while
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
    } // end 2 players if
    
    // THIS IF FOR IF THERE ARE 3 TOTAL PLAYERS
    // ---------------------------------------------------------------
    else if(numPlayers == 3) 
    {
      
      for(int i = 0; i < 7; i++)
      {
        player1Hand.addCard(deck.getCard());
      }
      player1Hand.sortHandByRank();
      
      for(int i = 0; i < 7; i++)
      {
        player2Hand.addCard(deck.getCard());
      }
      player2Hand.sortHandByRank();
      
      for(int i = 0; i < 7; i++)
      {
        player3Hand.addCard(deck.getCard());
      }
      player3Hand.sortHandByRank();
      
      while (deck.getCardsLeft() > 0 && player1Hand.getHandSize() > 0 && player2Hand.getHandSize() > 0 && player3Hand.getHandSize() > 0)
      {
        
        // PLAYER 1 TURN
        System.out.println("Player 1's turn. Your cards are:");
        player1Hand.showHand();
        System.out.println("Move options: (0 to skip)");
        System.out.println("1. Ask player 2 for a card.");
        System.out.println("2. Ask player 3 for a card.");
        choice = keyboardReader.nextInt();
        
        while (choice > 2 && choice < 0)
        {
          System.out.println("Invalid input! Input correct choice by number.");
          choice = keyboardReader.nextInt();
        }
        
        // PLAYER 1 CHOICE 1
        if (choice == 1)
        {
          System.out.println("What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
          int cardRank = keyboardReader.nextInt();
          while(cardRank > 14 || cardRank < 1)
          {
            System.out.println("Invalid card! What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
            cardRank = keyboardReader.nextInt();
          }
          
          boolean hasCard = false;
          int gaveCardCount = 0;
          
          for (int i = 0; i < player2Hand.getHandSize(); i++)
          {
            if (player2Hand.getCard(i).getRank() == cardRank)
            {
              hasCard = true;
              player1Hand.addCard(player2Hand.getCard(i));
              player2Hand.removeCard(i);
              gaveCardCount++;
            }
          }
          
          if (hasCard == true)
          {
            System.out.println("Player 2 gave you " + gaveCardCount + ", " + cardRank + "'s");
          }
          else
          {
            System.out.println("Go fish!");
            player1Hand.addCard(deck.getCard());
          }
          
          
          
        }
        // PLAYER 1 CHOICE 2
        else if (choice == 2)
        {
          System.out.println("What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
          int cardRank = keyboardReader.nextInt();
          while(cardRank > 14 || cardRank < 1)
          {
            System.out.println("Invalid card! What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
            cardRank = keyboardReader.nextInt();
          }
          
          boolean hasCard = false;
          int gaveCardCount = 0;
          
          for (int i = 0; i < player2Hand.getCard(i).getRank(); i++)
          {
            if (player2Hand.getCard(i).getRank() == cardRank)
            {
              hasCard = true;
              player1Hand.addCard(player3Hand.getCard(i));
              player3Hand.removeCard(i);
              gaveCardCount++;
            }
          }
          
          if (hasCard == true)
          {
            System.out.println("Player 3 gave you " + gaveCardCount + ", " + cardRank + "'s");
          }
          else
          {
            System.out.println("Go fish!");
            player1Hand.addCard(deck.getCard());
          }
          
          
          
        }
        // PLAYER 1 SKIP
        else
        {
          System.out.println("Go fish!");
          player1Hand.addCard(deck.getCard());
        }
        
        
        
        
        
        // PLAYER 2'S TURN
        
        System.out.println("Player 2's turn. Your cards are:");
        player2Hand.showHand();
        System.out.println("Move options: (0 to skip)");
        System.out.println("1. Ask player 1 for a card.");
        System.out.println("2. Ask player 2 for a card.");
        choice = keyboardReader.nextInt();
        
        while (choice > 2 && choice < 0)
        {
          System.out.println("Invalid input! Input correct choice by number.");
          choice = keyboardReader.nextInt();
        }
        // PLAYER 2 CHOICE 1
        if (choice == 1)
        {
          System.out.println("What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
          int cardRank = keyboardReader.nextInt();
          while(cardRank > 14 || cardRank < 1)
          {
            System.out.println("Invalid card! What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
            cardRank = keyboardReader.nextInt();
          }
          
          boolean hasCard = false;
          int gaveCardCount = 0;
          
          for (int i = 0; i < player1Hand.getHandSize(); i++)
          {
            if (player2Hand.getCard(i).getRank() == cardRank)
            {
              hasCard = true;
              player2Hand.addCard(player1Hand.getCard(i));
              player1Hand.removeCard(i);
              gaveCardCount++;
            }
          }
          
          if (hasCard == true)
          {
            System.out.println("Player 1 gave you " + gaveCardCount + ", " + cardRank + "'s");
          }
          else
          {
            System.out.println("Go fish!");
            player2Hand.addCard(deck.getCard());
          }
          
          
          
        }
        // PLAYER 2 CHOICE 2
        else if (choice == 2)
        {
          System.out.println("What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
          int cardRank = keyboardReader.nextInt();
          while(cardRank > 14 || cardRank < 1)
          {
            System.out.println("Invalid card! What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
            cardRank = keyboardReader.nextInt();
          }
          
          boolean hasCard = false;
          int gaveCardCount = 0;
          
          for (int i = 0; i < player3Hand.getHandSize(); i++)
          {
            if (player2Hand.getCard(i).getRank() == cardRank)
            {
              hasCard = true;
              player2Hand.addCard(player3Hand.getCard(i));
              player3Hand.removeCard(i);
              gaveCardCount++;
            }
          }
          
          if (hasCard == true)
          {
            System.out.println("Player 3 gave you " + gaveCardCount + ", " + cardRank + "'s");
          }
          else
          {
            System.out.println("Go fish!");
            player2Hand.addCard(deck.getCard());
          }
          
          
          
        }
        // PLAYER 2 SKIP
        else
        {
          System.out.println("Go fish!");
          player2Hand.addCard(deck.getCard());
        }
        
        
        // PLAYER 3 TURN
        
        System.out.println("Player 3's turn. Your cards are:");
        player3Hand.showHand();
        System.out.println("Move options: (0 to skip)");
        System.out.println("1. Ask player 1 for a card.");
        System.out.println("2. Ask player 2 for a card.");
        choice = keyboardReader.nextInt();
        
        while (choice > 2 && choice < 0)
        {
          System.out.println("Invalid input! Input correct choice by number.");
          choice = keyboardReader.nextInt();
        }
        // PLAYER 3 CHOICE 1
        if (choice == 1)
        {
          System.out.println("What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
          int cardRank = keyboardReader.nextInt();
          while(cardRank > 14 || cardRank < 1)
          {
            System.out.println("Invalid card! What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
            cardRank = keyboardReader.nextInt();
          }
          
          boolean hasCard = false;
          int gaveCardCount = 0;
          
          for (int i = 0; i < player2Hand.getHandSize(); i++)
          {
            if (player2Hand.getCard(i).getRank() == cardRank)
            {
              hasCard = true;
              player3Hand.addCard(player1Hand.getCard(i));
              player1Hand.removeCard(i);
              gaveCardCount++;
            }
          }
          
          if (hasCard == true)
          {
            System.out.println("Player 1 gave you " + gaveCardCount + ", " + cardRank + "'s");
          }
          else
          {
            System.out.println("Go fish!");
            player3Hand.addCard(deck.getCard());
          }
          
          
          
        }
        // PLAYER 3 CHOICE 2
        else if (choice == 2)
        {
          System.out.println("What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
          int cardRank = keyboardReader.nextInt();
          while(cardRank > 14 || cardRank < 1)
          {
            System.out.println("Invalid card! What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
            cardRank = keyboardReader.nextInt();
          }
          
          boolean hasCard = false;
          int gaveCardCount = 0;
          
          for (int i = 0; i < player2Hand.getHandSize(); i++)
          {
            if (player2Hand.getCard(i).getRank() == cardRank)
            {
              hasCard = true;
              player3Hand.addCard(player2Hand.getCard(i));
              player2Hand.removeCard(i);
              gaveCardCount++;
            }
          }
          
          if (hasCard == true)
          {
            System.out.println("Player 2 gave you " + gaveCardCount + ", " + cardRank + "'s");
          }
          else
          {
            System.out.println("Go fish!");
            player3Hand.addCard(deck.getCard());
          }
          
          
          
        }
        // PLAYER 3 SKIP
        else
        {
          System.out.println("Go fish!");
          player3Hand.addCard(deck.getCard());
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
      } // end 3 players while
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
    } // end 3 players if
    
    // GAME VERSION WITH 4 PLAYERS
    // -----------------------------------------
    else if(numPlayers == 4) 
    {
      
      
      
        
      for(int i = 0; i < 7; i++)
      {
        player1Hand.addCard(deck.getCard());
      }
      player1Hand.sortHandByRank();
      
      for(int i = 0; i < 7; i++)
      {
        player2Hand.addCard(deck.getCard());
      } 
      player2Hand.sortHandByRank();
      
      for(int i = 0; i < 7; i++)
      {
        player3Hand.addCard(deck.getCard());
      }
      player3Hand.sortHandByRank();
      
      for(int i = 0; i < 7; i++)
      {
        player4Hand.addCard(deck.getCard());
      }
      player4Hand.sortHandByRank();
      
      while (deck.getCardsLeft() > 0 && player1Hand.getHandSize() > 0 && player2Hand.getHandSize() > 0 && player3Hand.getHandSize() > 0 && player4Hand.getHandSize() > 0)
      {
        
        // PLAYER 1 TURN
        System.out.println("Player 1's turn. Your cards are:");
        player1Hand.showHand();
        System.out.println("Move options: (0 to skip)");
        System.out.println("1. Ask player 2 for a card.");
        System.out.println("2. Ask player 3 for a card.");
        System.out.println("3. Ask player 4 for a card.");
        choice = keyboardReader.nextInt();
        
        while (choice > 3 && choice < 0)
        {
          System.out.println("Invalid input! Input correct choice by number.");
          choice = keyboardReader.nextInt();
        }
        
        // PLAYER 1 CHOICE 1
        if (choice == 1)
        {
          System.out.println("What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
          int cardRank = keyboardReader.nextInt();
          while(cardRank > 14 || cardRank < 1)
          {
            System.out.println("Invalid card! What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
            cardRank = keyboardReader.nextInt();
          }
          
          boolean hasCard = false;
          int gaveCardCount = 0;
          
          for (int i = 0; i < player2Hand.getHandSize(); i++)
          {
            if (player2Hand.getCard(i).getRank() == cardRank)
            {
              hasCard = true;
              player1Hand.addCard(player2Hand.getCard(i));
              player2Hand.removeCard(i);
              gaveCardCount++;
            }
          }
          
          if (hasCard == true)
          {
            System.out.println("Player 2 gave you " + gaveCardCount + ", " + cardRank + "'s");
          }
          else
          {
            System.out.println("Go fish!");
            player1Hand.addCard(deck.getCard());
          }
          
          
          
        }
        // PLAYER 1 CHOICE 2
        else if (choice == 2)
        {
          System.out.println("What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
          int cardRank = keyboardReader.nextInt();
          while(cardRank > 14 || cardRank < 1)
          {
            System.out.println("Invalid card! What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
            cardRank = keyboardReader.nextInt();
          }
          
          boolean hasCard = false;
          int gaveCardCount = 0;
          
          for (int i = 0; i < player3Hand.getHandSize(); i++)
          {
            if (player2Hand.getCard(i).getRank() == cardRank)
            {
              hasCard = true;
              player1Hand.addCard(player3Hand.getCard(i));
              player3Hand.removeCard(i);
              gaveCardCount++;
            }
          }
          
          if (hasCard == true)
          {
            System.out.println("Player 3 gave you " + gaveCardCount + ", " + cardRank + "'s");
          }
          else
          {
            System.out.println("Go fish!");
            player1Hand.addCard(deck.getCard());
          }
          
          
          
        }
        // PLAYER 1 CHOICE 3
        else if (choice == 3)
        {
          System.out.println("What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
          int cardRank = keyboardReader.nextInt();
          while(cardRank > 14 || cardRank < 1)
          {
            System.out.println("Invalid card! What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
            cardRank = keyboardReader.nextInt();
          }
          
          boolean hasCard = false;
          int gaveCardCount = 0;
          
          for (int i = 0; i < player4Hand.getHandSize(); i++)
          {
            if (player2Hand.getCard(i).getRank() == cardRank)
            {
              hasCard = true;
              player1Hand.addCard(player4Hand.getCard(i));
              player4Hand.removeCard(i);
              gaveCardCount++;
            }
          }
          
          if (hasCard == true)
          {
            System.out.println("Player 4 gave you " + gaveCardCount + ", " + cardRank + "'s");
          }
          else
          {
            System.out.println("Go fish!");
            player1Hand.addCard(deck.getCard());
          }
          
          
          
        }
        // PLAYER 1 SKIP
        else
        {
          System.out.println("Go fish!");
          player1Hand.addCard(deck.getCard());
        }
        
        
        
        
        
        // PLAYER 2'S TURN
        
        System.out.println("Player 2's turn. Your cards are:");
        player2Hand.showHand();
        System.out.println("Move options: (0 to skip)");
        System.out.println("1. Ask player 1 for a card.");
        System.out.println("2. Ask player 2 for a card.");
        System.out.println("3. Ask player 3 for a card.");
        choice = keyboardReader.nextInt();
        
        while (choice > 3 && choice < 0)
        {
          System.out.println("Invalid input! Input correct choice by number.");
          choice = keyboardReader.nextInt();
        }
        // PLAYER 2 CHOICE 1
        if (choice == 1)
        {
          System.out.println("What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
          int cardRank = keyboardReader.nextInt();
          while(cardRank > 14 || cardRank < 1)
          {
            System.out.println("Invalid card! What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
            cardRank = keyboardReader.nextInt();
          }
          
          boolean hasCard = false;
          int gaveCardCount = 0;
          
          for (int i = 0; i < player1Hand.getHandSize(); i++)
          {
            if (player2Hand.getCard(i).getRank() == cardRank)
            {
              hasCard = true;
              player2Hand.addCard(player1Hand.getCard(i));
              player1Hand.removeCard(i);
              gaveCardCount++;
            }
          }
          
          if (hasCard == true)
          {
            System.out.println("Player 1 gave you " + gaveCardCount + ", " + cardRank + "'s");
          }
          else
          {
            System.out.println("Go fish!");
            player2Hand.addCard(deck.getCard());
          }
          
          
          
        }
        // PLAYER 2 CHOICE 2
        else if (choice == 2)
        {
          System.out.println("What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
          int cardRank = keyboardReader.nextInt();
          while(cardRank > 14 || cardRank < 1)
          {
            System.out.println("Invalid card! What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
            cardRank = keyboardReader.nextInt();
          }
          
          boolean hasCard = false;
          int gaveCardCount = 0;
          
          for (int i = 0; i < player3Hand.getHandSize(); i++)
          {
            if (player2Hand.getCard(i).getRank() == cardRank)
            {
              hasCard = true;
              player2Hand.addCard(player3Hand.getCard(i));
              player3Hand.removeCard(i);
              gaveCardCount++;
            }
          }
          
          if (hasCard == true)
          {
            System.out.println("Player 3 gave you " + gaveCardCount + ", " + cardRank + "'s");
          }
          else
          {
            System.out.println("Go fish!");
            player2Hand.addCard(deck.getCard());
          }
          
          
          
        }
        // PLAYER 2 CHOICE 3
        else if (choice == 2)
        {
          System.out.println("What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
          int cardRank = keyboardReader.nextInt();
          while(cardRank > 14 || cardRank < 1)
          {
            System.out.println("Invalid card! What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
            cardRank = keyboardReader.nextInt();
          }
          
          boolean hasCard = false;
          int gaveCardCount = 0;
          
          for (int i = 0; i < player4Hand.getHandSize(); i++)
          {
            if (player2Hand.getCard(i).getRank() == cardRank)
            {
              hasCard = true;
              player2Hand.addCard(player4Hand.getCard(i));
              player4Hand.removeCard(i);
              gaveCardCount++;
            }
          }
          
          if (hasCard == true)
          {
            System.out.println("Player 4 gave you " + gaveCardCount + ", " + cardRank + "'s");
          }
          else
          {
            System.out.println("Go fish!");
            player2Hand.addCard(deck.getCard());
          }
          
          
          
        }
        // PLAYER 2 SKIP
        else
        {
          System.out.println("Go fish!");
          player2Hand.addCard(deck.getCard());
        }
        
        
        // PLAYER 3 TURN
        
        System.out.println("Player 3's turn. Your cards are:");
        player3Hand.showHand();
        System.out.println("Move options: (0 to skip)");
        System.out.println("1. Ask player 1 for a card.");
        System.out.println("2. Ask player 2 for a card.");
        System.out.println("3. Ask player 4 for a card.");
        choice = keyboardReader.nextInt();
        
        while (choice > 3 && choice < 0)
        {
          System.out.println("Invalid input! Input correct choice by number.");
          choice = keyboardReader.nextInt();
        }
        // PLAYER 3 CHOICE 1
        if (choice == 1)
        {
          System.out.println("What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
          int cardRank = keyboardReader.nextInt();
          while(cardRank > 14 || cardRank < 1)
          {
            System.out.println("Invalid card! What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
            cardRank = keyboardReader.nextInt();
          }
          
          boolean hasCard = false;
          int gaveCardCount = 0;
          
          for (int i = 0; i < player1Hand.getHandSize(); i++)
          {
            if (player2Hand.getCard(i).getRank() == cardRank)
            {
              hasCard = true;
              player3Hand.addCard(player1Hand.getCard(i));
              player1Hand.removeCard(i);
              gaveCardCount++;
            }
          }
          
          if (hasCard == true)
          {
            System.out.println("Player 1 gave you " + gaveCardCount + ", " + cardRank + "'s");
          }
          else
          {
            System.out.println("Go fish!");
            player3Hand.addCard(deck.getCard());
          }
          
          
          
        }
        // PLAYER 3 CHOICE 2
        else if (choice == 2)
        {
          System.out.println("What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
          int cardRank = keyboardReader.nextInt();
          while(cardRank > 14 || cardRank < 1)
          {
            System.out.println("Invalid card! What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
            cardRank = keyboardReader.nextInt();
          }
          
          boolean hasCard = false;
          int gaveCardCount = 0;
          
          for (int i = 0; i < player2Hand.getHandSize(); i++)
          {
            if (player2Hand.getCard(i).getRank() == cardRank)
            {
              hasCard = true;
              player3Hand.addCard(player2Hand.getCard(i));
              player2Hand.removeCard(i);
              gaveCardCount++;
            }
          }
          
          if (hasCard == true)
          {
            System.out.println("Player 2 gave you " + gaveCardCount + ", " + cardRank + "'s");
          }
          else
          {
            System.out.println("Go fish!");
            player3Hand.addCard(deck.getCard());
          }
          
          
          
        }
        // PLAYER 3 CHOICE 3
        else if (choice == 3)
        {
          System.out.println("What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
          int cardRank = keyboardReader.nextInt();
          while(cardRank > 14 || cardRank < 1)
          {
            System.out.println("Invalid card! What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
            cardRank = keyboardReader.nextInt();
          }
          
          boolean hasCard = false;
          int gaveCardCount = 0;
          
          for (int i = 0; i < player4Hand.getHandSize(); i++)
          {
            if (player2Hand.getCard(i).getRank() == cardRank)
            {
              hasCard = true;
              player3Hand.addCard(player4Hand.getCard(i));
              player4Hand.removeCard(i);
              gaveCardCount++;
            }
          }
          
          if (hasCard == true)
          {
            System.out.println("Player 4 gave you " + gaveCardCount + ", " + cardRank + "'s");
          }
          else
          {
            System.out.println("Go fish!");
            player3Hand.addCard(deck.getCard());
          }
          
          
          
        }
        // PLAYER 3 SKIP
        else
        {
          System.out.println("Go fish!");
          player3Hand.addCard(deck.getCard());
        }
        
        
        
        
        
        // PLAYER 4 TURN
        
        System.out.println("Player 4's turn. Your cards are:");
        player4Hand.showHand();
        System.out.println("Move options: (0 to skip)");
        System.out.println("1. Ask player 1 for a card.");
        System.out.println("2. Ask player 2 for a card.");
        System.out.println("3. Ask player 3 for a card.");
        choice = keyboardReader.nextInt();
        
        while (choice > 3 && choice < 0)
        {
          System.out.println("Invalid input! Input correct choice by number.");
          choice = keyboardReader.nextInt();
        }
        // PLAYER 4 CHOICE 1
        if (choice == 1)
        {
          System.out.println("What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
          int cardRank = keyboardReader.nextInt();
          while(cardRank > 14 || cardRank < 1)
          {
            System.out.println("Invalid card! What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
            cardRank = keyboardReader.nextInt();
          }
          
          boolean hasCard = false;
          int gaveCardCount = 0;
          
          for (int i = 0; i < player1Hand.getHandSize(); i++)
          {
            if (player2Hand.getCard(i).getRank() == cardRank)
            {
              hasCard = true;
              player4Hand.addCard(player1Hand.getCard(i));
              player1Hand.removeCard(i);
              gaveCardCount++;
            }
          }
          
          if (hasCard == true)
          {
            System.out.println("Player 1 gave you " + gaveCardCount + ", " + cardRank + "'s");
          }
          else
          {
            System.out.println("Go fish!");
            player4Hand.addCard(deck.getCard());
          }
          
          
          
        }
        // PLAYER 4 CHOICE 2
        else if (choice == 2)
        {
          System.out.println("What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
          int cardRank = keyboardReader.nextInt();
          while(cardRank > 14 || cardRank < 1)
          {
            System.out.println("Invalid card! What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
            cardRank = keyboardReader.nextInt();
          }
          
          boolean hasCard = false;
          int gaveCardCount = 0;
          
          for (int i = 0; i < player2Hand.getHandSize(); i++)
          {
            if (player2Hand.getCard(i).getRank() == cardRank)
            {
              hasCard = true;
              player4Hand.addCard(player2Hand.getCard(i));
              player2Hand.removeCard(i);
              gaveCardCount++;
            }
          }
          
          if (hasCard == true)
          {
            System.out.println("Player 2 gave you " + gaveCardCount + ", " + cardRank + "'s");
          }
          else
          {
            System.out.println("Go fish!");
            player4Hand.addCard(deck.getCard());
          }
          
          
          
        }
        // PLAYER 4 CHOICE 3
        else if (choice == 3)
        {
          System.out.println("What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
          int cardRank = keyboardReader.nextInt();
          while(cardRank > 14 || cardRank < 1)
          {
            System.out.println("Invalid card! What card do you want to ask for? (1 = ace, 11 = jack, ect.)");
            cardRank = keyboardReader.nextInt();
          }
          
          boolean hasCard = false;
          int gaveCardCount = 0;
          
          for (int i = 0; i < player3Hand.getHandSize(); i++)
          {
            if (player2Hand.getCard(i).getRank() == cardRank)
            {
              hasCard = true;
              player4Hand.addCard(player3Hand.getCard(i));
              player3Hand.removeCard(i);
              gaveCardCount++;
            }
          }
          
          if (hasCard == true)
          {
            System.out.println("Player 3 gave you " + gaveCardCount + ", " + cardRank + "'s");
          }
          else
          {
            System.out.println("Go fish!");
            player4Hand.addCard(deck.getCard());
          }
          
          
          
        }
        // PLAYER 4 SKIP
        else
        {
          System.out.println("Go fish!");
          player4Hand.addCard(deck.getCard());
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
      } // end 4 player while
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
    } // end 4 player if statement go fish
    
    
    
    
    
  } // end of main
  
  
  
  
  
  // this method creates a hand for each player
  public Hand createHand(DeckList inDeck)
  {
    
    Hand playerHand = new Hand(7);
    
    for(int i = 0; i < 7; i++)
    {
      playerHand.addCard(inDeck.getCard());
    }
    
    
    return playerHand;
  } // end of create hand method
  
  
  
  
  
  
  
} // end PlayGame class
