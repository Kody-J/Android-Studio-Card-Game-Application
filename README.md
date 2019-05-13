# CS449-Android-Project
Custom app using Agile method

HOT HANDS

Hot Hands is an Android device designed gaming application. The goal of the project is to create the ultimate experience for the casual card game player.

App Features:
  1) Custom home icon with graphic logo foreground and transparent background
  2) Custom round buttons x?
  3) Custom playing card images x52
  4) Custom playing card back image
  5) Custom Treasure Chest image
  6) Custom Poker Table and Texas Hold'em Table images
  7) Custom player Icon images (in game)
  8) Custom poker chips Images
  9) Two card game modes

App Tutorial:
  1) Launch app from home icon
  2) Click 'Play' button from home screen
  3) Click  which game to play
  4) Click 'New Game' (back button in top right takes you to previous screen)

To start with, Poker will be the first card game available. This is the standard 5 card poker game.

5 Card Poker: (Simple design, No card swapping)
  1) The user plays against Two other A/I players
  2) All players start with $50,000 in chips
  3) The Dealer Automatically deals each player 5 cards
  3) The user initiates the first round of betting based on their 5 cards by either betting, folding, checking, or calling.
      --> Fold: User ends turn loses chips in pot and remaining players continue automatically
      --> checking: User passes betting off to next player, round continues if bet not increased, player must call or raise otherwise
      --> Call: User matches exact bet amount and turn ends
  4) Each A/I player bets after the user, automatically
  5) A winner is determined based on the players in the hand and the rules of 5-Card Poker
  6) the hands of all the players are displayed for 10 secs. 
  7) the Winner is displayed, and the pot total is added to the winner’s chips
  8) If user still has chips and players remain, then next round starts
  --> Note: Hit back button to start new game
  
The second card game is Texas Hold'em Style Poker

Texas Hold'em
  1) The user plays against Two other A/I players
  2) All players start with $50,000
  3) The Dealer Automatically deals each player 2 cards
  4) The user initiates the first round of betting based on their 2 cards by either betting, folding, checking, or calling.
      --> Fold: User ends turn loses chips in pot and remaining players continue automatically
      --> checking: User passes betting off to next player, round continues if bet not increased, player must call or raise otherwise
      --> Call: User matches exact bet amount and turn ends
  5) Each A/I player bets after the user, automatically
  4) The dealer performs the flop. (discards the top card on the deck, and lays down three cards face up for all users to bet off)
  6) The user initiates the second round of betting just as before
  7) The A/I players bet after user, automatically
  8) The dealer performs the Turn. (just as before but only lays down one card)
  9) The user initiates the second round of betting just as before
  10) The A/I players bet after user, automatically
  11) The dealer performs the River. (just as before)
  12) The user initiates the last round of betting
  13) A/I bet automatically
  14) A winner is determined based on each player best 5 card combination and the rules of Texas Hold'em
  15) The winner is displayed, and the pot total is added to the winner’s chips
  16)  If user still has chips and players remain, start next round
  
Note: Other cards games will include solitary, and war. For now, only a coming soon page is displayed.

The focus will be on design, esthetics, art, and entertainment on the Android framework using Android studio. From there, the focus will be on creating a solid AI predictive system to match the user’s skill level and make the experience as organic as possible. The vison is to design an environment and develop the framework for what will later be more comprehensive selection of card games to play on a fun and interactive platform.  
