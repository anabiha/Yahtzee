package YahtzeeGame;

import javafx.scene.layout.Pane;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class YahtzeeGame extends Applet {
	
    JButton dice1, dice2, dice3, dice4, dice5;
    int timesPressed = 0;
    ImageIcon d1, d2, d3, d4, d5, d6;
    ImageIcon[]  diceImages = new ImageIcon[6];
    JButton aces1, twos1, threes1, fours1, fives1, sixes1, threeOfAKind1, fourOfAKind1, fullHouse1, smStraight1,lgStraight1, chance1, yahtzee1;
    JButton aces2, twos2, threes2, fours2, fives2, sixes2, threeOfAKind2, fourOfAKind2, fullHouse2, smStraight2,lgStraight2, chance2, yahtzee2;
    int die1,die2,die3,die4,die5;
    JLabel sumUpper1, sumUpper2, bonusSum1, bonusSum2, totalSumUpper1, totalSumUpper2, totalSumLower1, totalSumLower2, yahtzeeBonus1, yahtzeeBonus2;
    private ArrayList<Integer> upperSectionTotal1 = new ArrayList<Integer>();
    private ArrayList<Integer> upperSectionTotal2 = new ArrayList<Integer>();
    private ArrayList<Integer> lowerSectionTotal1 = new ArrayList<Integer>();
    private ArrayList<Integer> lowerSectionTotal2 = new ArrayList<Integer>();
    private ArrayList<Integer> diceFaces = new ArrayList<Integer>();
    Panel p1, p2;
    
    public void init() {
        d1 = new ImageIcon("//Users//ayeshanabiha//eclipse-workspace//GraphicsProjects//bin//dice1.png");
        d2 = new ImageIcon("//Users//ayeshanabiha//eclipse-workspace//GraphicsProjects//bin//dice2.png");
        d3 = new ImageIcon("//Users//ayeshanabiha//eclipse-workspace//GraphicsProjects//bin//dice3.png");
        d4 = new ImageIcon("//Users//ayeshanabiha//eclipse-workspace//GraphicsProjects//bin//dice4.png");
        d5 = new ImageIcon("//Users//ayeshanabiha//eclipse-workspace//GraphicsProjects//bin//dice5.png");
        d6 = new ImageIcon("//Users//ayeshanabiha//eclipse-workspace//GraphicsProjects//bin//dice6.png");
        
        diceImages[0] = d1;
        diceImages[1] = d2;
        diceImages[2] = d3;
        diceImages[3] = d4;
        diceImages[4] = d5;
        diceImages[5] = d6;
        
        //sets the layout, background color, and the size of the applet
        setLayout(new BorderLayout());
        setBackground(new Color(113, 121, 45));
        setSize(800, 800);
        

        //creates a panel that will contain the dice
        Panel dicePanel = new Panel();
        //creates buttons that will represent the dice and sets them to a size of 100x100
        dice1 = new JButton(new ImageIcon(d1.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
        dice1.setPreferredSize(new Dimension(100, 100));
        dice1.setOpaque(false);
        dice1.setContentAreaFilled(false);
        dice1.setBorderPainted(false);
        dice1.setFocusPainted(false);

        dice2 = new JButton(new ImageIcon(d2.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
        dice2.setPreferredSize(new Dimension(100, 100));
        dice2.setOpaque(false);
        dice2.setContentAreaFilled(false);
        dice2.setBorderPainted(false);
        dice2.setFocusPainted(false);
     
        dice3 = new JButton(new ImageIcon(d3.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
        dice3.setPreferredSize(new Dimension(100, 100));
        dice3.setOpaque(false);
        dice3.setContentAreaFilled(false);
        dice3.setBorderPainted(false);
        dice3.setFocusPainted(false);
    
        dice4 = new JButton(new ImageIcon(d4.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
        dice4.setPreferredSize(new Dimension(100, 100));
        dice4.setOpaque(false);
        dice4.setContentAreaFilled(false);
        dice4.setBorderPainted(false);
        dice4.setFocusPainted(false);

        dice5 = new JButton(new ImageIcon(d5.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
        dice5.setPreferredSize(new Dimension(100, 100));
        dice5.setOpaque(false);
        dice5.setContentAreaFilled(false);
        dice5.setBorderPainted(false);
        dice5.setFocusPainted(false);
   
        dice1.addActionListener(new HoldDice("dice1"));
        dice2.addActionListener(new HoldDice("dice2"));
        dice3.addActionListener(new HoldDice("dice3"));
        dice4.addActionListener(new HoldDice("dice4"));
        dice5.addActionListener(new HoldDice("dice5"));
        
        //adds dice to panel
        dicePanel.add(dice1);
        dicePanel.add(dice2);
        dicePanel.add(dice3);
        dicePanel.add(dice4);
        dicePanel.add(dice5);
        //adds panel to applet
        add(dicePanel, BorderLayout.NORTH);

        Panel lowerPanel = new Panel();
        lowerPanel.setLayout(new BorderLayout());
        Panel rollPanel = new Panel();
        JButton rollDice = new JButton("Roll Dice");
        rollDice.setPreferredSize(new Dimension(100, 50));
        rollDice.setFont(new Font("Monospaced", Font.PLAIN, 12));
        rollDice.addActionListener(new DiceRoll());
        rollPanel.add(rollDice);
        lowerPanel.add(rollPanel, BorderLayout.NORTH);

        //creates a panel that contains the categories that a player can choose
        Panel categories = new Panel();
        categories.setLayout(new GridLayout(0, 1));
        JLabel upper = new JLabel("Upper Section");
        upper.setForeground(Color.white);
        upper.setFont(new Font("Monospaced", Font.BOLD, 18));
        JLabel lower = new JLabel("Lower Section");
        lower.setForeground(Color.white);
        lower.setFont(new Font("Monospaced", Font.BOLD, 18));
        categories.add(upper);
        JLabel aces = new JLabel("Aces");
        aces.setForeground(Color.white);
        aces.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JLabel twos = new JLabel("Twos");
        twos.setForeground(Color.white);
        aces.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JLabel threes = new JLabel("Threes");
        threes.setForeground(Color.white);
        threes.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JLabel fours = new JLabel("Fours");
        fours.setForeground(Color.white);
        fours.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JLabel fives = new JLabel("Fives");
        fives.setForeground(Color.white);
        fives.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JLabel sixes = new JLabel("Sixes");
        sixes.setForeground(Color.white);
        sixes.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JLabel threeOfAKind = new JLabel("Three of A Kind");
        threeOfAKind.setForeground(Color.white);
        threeOfAKind.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JLabel fourOfAKind = new JLabel("Four of A Kind");
        fourOfAKind.setForeground(Color.white);
        fourOfAKind.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JLabel fullHouse = new JLabel("Full House");
        fullHouse.setForeground(Color.white);
        fullHouse.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JLabel smStraight = new JLabel("Small Straight");
        smStraight.setForeground(Color.white);
        smStraight.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JLabel lgStraight = new JLabel("Large Straight");
        lgStraight.setForeground(Color.white);
        lgStraight.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JLabel chance = new JLabel("Chance");
        chance.setForeground(Color.white);
        chance.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JLabel yahtzee = new JLabel("YAHTZEE");
        yahtzee.setForeground(Color.white);
        yahtzee.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JLabel sum = new JLabel("Sum");
        sum.setForeground(Color.white);
        sum.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JLabel bonus = new JLabel("Bonus");
        bonus.setForeground(Color.white);
        bonus.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JLabel totalSum = new JLabel("Total Sum");
        totalSum.setForeground(Color.white);
        totalSum.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JLabel yahtzeeBonus = new JLabel("Yahtzee Bonus");
        yahtzeeBonus.setForeground(Color.white);
        yahtzeeBonus.setFont(new Font("Monospaced", Font.PLAIN, 14));
        categories.add(aces);
        categories.add(twos);
        categories.add(threes);
        categories.add(fours);
        categories.add(fives);
        categories.add(sixes);
        categories.add(sum);
        categories.add(bonus);
        //categories.add(sumUpper);
        categories.add(lower);
        categories.add(threeOfAKind);
        categories.add(fourOfAKind);
        categories.add(fullHouse);
        categories.add(smStraight);
        categories.add(lgStraight);
        categories.add(chance);
        categories.add(yahtzee);
        categories.add(yahtzeeBonus);
        categories.add(totalSum);
        lowerPanel.add(categories, BorderLayout.WEST);

        //creates a panel that will contain the scores of the players
        Panel playerScores = new Panel();
        playerScores.setLayout(new GridLayout(0, 2));
        //creates panels for player 1 and player 2
        p1 = new Panel();
        p1.setLayout(new GridLayout(0, 1));
        JLabel player1 = new JLabel("Player 1", SwingConstants.CENTER);
        player1.setForeground(Color.white);
        player1.setFont(new Font("Monospaced", Font.BOLD, 12));
        p1.add(player1);
        aces1 = new JButton();
        twos1 = new JButton();
        threes1 = new JButton();
        fours1 = new JButton();
        fives1 = new JButton();
        sixes1 = new JButton();
        threeOfAKind1 = new JButton();
        fourOfAKind1 = new JButton();
        fullHouse1 = new JButton();
        smStraight1 = new JButton();
        lgStraight1 = new JButton();
        chance1 = new JButton();
        yahtzee1 = new JButton();
        
        aces1.addActionListener(new CategoryScore("aces1"));
        twos1.addActionListener(new CategoryScore("twos1"));
        threes1.addActionListener(new CategoryScore("threes1"));
        fours1.addActionListener(new CategoryScore("fours1"));
        fives1.addActionListener(new CategoryScore("fives1"));
        sixes1.addActionListener(new CategoryScore("sixes1"));
        threeOfAKind1.addActionListener(new CategoryScore("threeOfAKind1"));
        fourOfAKind1.addActionListener(new CategoryScore("fourOfAKind1"));
        fullHouse1.addActionListener(new CategoryScore("fullHouse1"));
        smStraight1.addActionListener(new CategoryScore("smStraight1"));
        lgStraight1.addActionListener(new CategoryScore("lgStraight1"));
        chance1.addActionListener(new CategoryScore("chance1"));
        yahtzee1.addActionListener(new CategoryScore("yahtzee1"));
        
        
        p1.add(aces1);
        p1.add(twos1);
        p1.add(threes1);
        p1.add(fours1);
        p1.add(fives1);
        p1.add(sixes1);
        sumUpper1 = new JLabel();
        sumUpper1.setHorizontalAlignment(SwingConstants.CENTER);
        sumUpper1.setForeground(Color.white);
        sumUpper1.setFont(new Font("Monospaced", Font.PLAIN, 14));
        bonusSum1 = new JLabel();
        bonusSum1.setHorizontalAlignment(SwingConstants.CENTER);
        bonusSum1.setForeground(Color.white);
        bonusSum1.setFont(new Font("Monospaced", Font.PLAIN, 14));
        //totalSumUpper1 = new JLabel();
        totalSumLower1 = new JLabel();
        totalSumLower1.setForeground(Color.white);
        totalSumLower1.setFont(new Font("Monospaced", Font.PLAIN, 14));
        totalSumLower1.setHorizontalAlignment(SwingConstants.CENTER);
        yahtzeeBonus1 = new JLabel();
        yahtzeeBonus1.setForeground(Color.white);
        yahtzeeBonus1.setFont(new Font("Monospaced", Font.PLAIN, 14));
        yahtzeeBonus1.setHorizontalAlignment(SwingConstants.CENTER);
        p1.add(sumUpper1); //sum
        p1.add(bonusSum1); //bonus
        //p1.add(totalSumUpper1);
        p1.add(new JLabel()); //adds a space in between
        p1.add(threeOfAKind1);
        p1.add(fourOfAKind1);
        p1.add(fullHouse1);
        p1.add(smStraight1);
        p1.add(lgStraight1);
        p1.add(chance1);
        p1.add(yahtzee1);
        p1.add(yahtzeeBonus1);
        p1.add(totalSumLower1); //total sum
        
        
        p2 = new Panel();
        p2.setLayout(new GridLayout(0, 1));
        JLabel player2 = new JLabel("Player 2", SwingConstants.CENTER);
        player2.setForeground(Color.white);
        player2.setFont(new Font("Monospaced", Font.BOLD, 12));
        p2.add(player2);
        
        aces2 = new JButton();
        twos2 = new JButton();
        threes2 = new JButton();
        fours2 = new JButton();
        fives2 = new JButton();
        sixes2 = new JButton();
        threeOfAKind2 = new JButton();
        fourOfAKind2 = new JButton();
        fullHouse2 = new JButton();
        smStraight2 = new JButton();
        lgStraight2 = new JButton();
        chance2 = new JButton();
        yahtzee2 = new JButton();
        
        aces2.addActionListener(new CategoryScore("aces2"));
        twos2.addActionListener(new CategoryScore("twos2"));
        threes2.addActionListener(new CategoryScore("threes2"));
        fours2.addActionListener(new CategoryScore("fours2"));
        fives2.addActionListener(new CategoryScore("fives2"));
        sixes2.addActionListener(new CategoryScore("sixes2"));
        threeOfAKind2.addActionListener(new CategoryScore("threeOfAKind2"));
        fourOfAKind2.addActionListener(new CategoryScore("fourOfAKind2"));
        fullHouse2.addActionListener(new CategoryScore("fullHouse2"));
        smStraight2.addActionListener(new CategoryScore("smStraight2"));
        lgStraight2.addActionListener(new CategoryScore("lgStraight2"));
        chance2.addActionListener(new CategoryScore("chance2"));
        yahtzee2.addActionListener(new CategoryScore("yahtzee2"));
        
        p2.add(aces2);
        p2.add(twos2);
        p2.add(threes2);
        p2.add(fours2);
        p2.add(fives2);
        p2.add(sixes2);
        sumUpper2 = new JLabel();
        sumUpper2.setHorizontalAlignment(SwingConstants.CENTER);
        sumUpper2.setForeground(Color.white);
        sumUpper2.setFont(new Font("Monospaced", Font.PLAIN, 14));
        bonusSum2 = new JLabel();
        bonusSum2.setHorizontalAlignment(SwingConstants.CENTER);
        bonusSum2.setForeground(Color.white);
        bonusSum2.setFont(new Font("Monospaced", Font.PLAIN, 14));
        //totalSumUpper2 = new JLabel();
        totalSumLower2 = new JLabel();
        totalSumLower2.setForeground(Color.white);
        totalSumLower2.setFont(new Font("Monospaced", Font.PLAIN, 14));
        totalSumLower2.setHorizontalAlignment(SwingConstants.CENTER);
        yahtzeeBonus2 = new JLabel();
        yahtzeeBonus2.setForeground(Color.white);
        yahtzeeBonus2.setFont(new Font("Monospaced", Font.PLAIN, 14));
        yahtzeeBonus2.setHorizontalAlignment(SwingConstants.CENTER);
        p2.add(sumUpper2); //sum
        p2.add(bonusSum2); //bonus
        //p2.add(totalSumUpper2);
        p2.add(new JLabel()); //adds a space in between
        p2.add(threeOfAKind2);
        p2.add(fourOfAKind2);
        p2.add(fullHouse2);
        p2.add(smStraight2);
        p2.add(lgStraight2);
        p2.add(chance2);
        p2.add(yahtzee2);
        p2.add(yahtzeeBonus2);
        p2.add(totalSumLower2); //total sum
        playerScores.add(p1);
        playerScores.add(p2);
        lowerPanel.add(playerScores, BorderLayout.CENTER);
        add(lowerPanel);
        
        //fix this button
        Panel helpPanel = new Panel();
        JButton help = new JButton("Help");
        help.setPreferredSize(new Dimension(100,25));
        help.setFont(new Font("Monospaced", Font.PLAIN, 10));
        help.addActionListener(new HelpButtonListener());
        helpPanel.add(help);
        add(helpPanel, BorderLayout.SOUTH);
       
    }
   
    private class HoldDice implements ActionListener {
        private String diceRoll;

        public HoldDice(String diceRoll) {
            this.diceRoll = diceRoll;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (diceRoll == "dice1") {
            	dice1.setEnabled(false);
            } else if (diceRoll == "dice2") {
            	dice2.setEnabled(false);
            } else if (diceRoll == "dice3") {
            	dice3.setEnabled(false);
            } else if (diceRoll == "dice4") {
            	dice4.setEnabled(false);
            } else if (diceRoll == "dice5") {
            	dice5.setEnabled(false);

            }
        }
    }

    private class DiceRoll implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Random rand = new Random();
            if(timesPressed < 3) {
            	if(dice1.isEnabled()) {
            		die1 = rand.nextInt(6);
            	}
            	if(dice2.isEnabled()) {
            		die2 = rand.nextInt(6);
            	}
            	if(dice3.isEnabled()) {
            		die3 = rand.nextInt(6);
            	}
            	if(dice4.isEnabled()) {
            		die4 = rand.nextInt(6);
            	}
            	if(dice5.isEnabled()) {
            		die5 = rand.nextInt(6);
            	}
                
            	diceFaces.clear();
            	
            		diceFaces.add(die1+1);
            		diceFaces.add(die2+1);
            		diceFaces.add(die3+1);
            		diceFaces.add(die4+1);
            		diceFaces.add(die5+1);
           
                
                if(dice1.isEnabled()) {
                	dice1.setIcon(new ImageIcon(diceImages[die1].getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
                }
                if(dice2.isEnabled()) {
                	dice2.setIcon(new ImageIcon(diceImages[die2].getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
                }
                if(dice3.isEnabled()){
                	dice3.setIcon(new ImageIcon(diceImages[die3].getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
                }
                if(dice4.isEnabled()) {
                	dice4.setIcon(new ImageIcon(diceImages[die4].getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
                }
                if(dice5.isEnabled()){
                dice5.setIcon(new ImageIcon(diceImages[die5].getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
                }
                timesPressed++;
                dice1.setEnabled(true);
                dice2.setEnabled(true);
                dice3.setEnabled(true);
                dice4.setEnabled(true);
                dice5.setEnabled(true);
            }else{
                JOptionPane.showMessageDialog(null, "You have already rolled the maximum number of times (3) per turn. You must pick a category.", "Maximum Rolls Reached", 1);
                timesPressed = 0;
            }

        }
    }
    
    private class HelpButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane helpMenu = new JOptionPane();
			helpMenu.showMessageDialog(null, "The Rules of Yahtzee", "Help", 1);
			helpMenu.setVisible(true);
			helpMenu.setSize(800,600);
			helpMenu.setVisible(true);
		}	
    }
    
    private class CategoryScore implements ActionListener{
    	private String category;
    	private int yahtzeeTimes1 = 0;
    	private int yahtzeeTimes2 = 0;
    	int playerOneScore = 0;
    	int playerTwoScore = 0;
    	boolean selectedCategory1 = false;
    	boolean selectedCategory2 = false;
    	
 

        public CategoryScore(String category) {
            this.category = category;
        }

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(category.equals("aces1") || category.equals("aces2")){
				int sumToDisplay = 0;
				if(category.equals("aces1")){
			          for(int i = 0; i < diceFaces.size(); i++) {
			        	  if(diceFaces.get(i) == 1) {
			        		  sumToDisplay++;
			        	  }
			          }
			          aces1.setText(Integer.toString(sumToDisplay));
			          aces1.setEnabled(false);
			          selectedCategory1 = true;
			          selectedCategory2 = false;
			          upperSectionTotal1.add(sumToDisplay);
				}else {
					for(int i = 0; i < diceFaces.size(); i++) {
			        	  if(diceFaces.get(i) == 1) {
			        		  sumToDisplay++;
			        	  }
					}
		          aces2.setText(Integer.toString(sumToDisplay));
		          upperSectionTotal2.add(sumToDisplay);
		          selectedCategory1 = false;
		          selectedCategory2 = true;
		          aces2.setEnabled(false);
				}
			}else if(category.equals("twos1") || category.equals("twos2")) {
				int sumToDisplay = 0;
				if(category.equals("twos1")){
			          for(int i = 0; i < diceFaces.size(); i++) {
			        	  if(diceFaces.get(i) == 2) {
			        		  sumToDisplay += 2;
			        	  }
			          }
			     twos1.setText(Integer.toString(sumToDisplay));
			     twos1.setEnabled(false);
			     upperSectionTotal1.add(sumToDisplay);
			     selectedCategory1 = true;
		         selectedCategory2 = false;
				}else {
					for(int i = 0; i < diceFaces.size(); i++) {
			        	  if(diceFaces.get(i) == 2) {
			        		  sumToDisplay += 2;
			        	  }
					}
		          twos2.setText(Integer.toString(sumToDisplay));
		          upperSectionTotal2.add(sumToDisplay);
		          twos2.setEnabled(false);
		          selectedCategory1 = false;
		          selectedCategory2 = true;
				}
			}else if(category.equals("threes1") || category.equals("threes2")) {
				int sumToDisplay = 0;
				if(category.equals("threes1")){
			          for(int i = 0; i < diceFaces.size(); i++) {
			        	  if(diceFaces.get(i) == 3) {
			        		  sumToDisplay += 3;
			        	  }
			          }
			     threes1.setText(Integer.toString(sumToDisplay));
			     threes1.setEnabled(false);
			     upperSectionTotal1.add(sumToDisplay);
			     selectedCategory1 = true;
		         selectedCategory2 = false;
				}else {
					for(int i = 0; i < diceFaces.size(); i++) {
			        	  if(diceFaces.get(i) == 3) {
			        		  sumToDisplay += 3;
			        	  }
					}
		          threes2.setText(Integer.toString(sumToDisplay));
		          threes2.setEnabled(false);
		          upperSectionTotal2.add(sumToDisplay);
		          selectedCategory1 = false;
		          selectedCategory2 = true;
				}
			}else if(category.equals("fours1") || category.equals("fours2")) {
				int sumToDisplay = 0;
				if(category.equals("fours1")){
			          for(int i = 0; i < diceFaces.size(); i++) {
			        	  if(diceFaces.get(i) == 4) {
			        		  sumToDisplay += 4;
			        	  }
			          }
			     fours1.setText(Integer.toString(sumToDisplay));
			     fours1.setEnabled(false);
			     upperSectionTotal1.add(sumToDisplay);
			     selectedCategory1 = true;
		         selectedCategory2 = false;
				}else {
					for(int i = 0; i < diceFaces.size(); i++) {
			        	  if(diceFaces.get(i) == 4) {
			        		  sumToDisplay += 4;
			        	  }
					}
		          fours2.setText(Integer.toString(sumToDisplay));
		          fours2.setEnabled(false);
		          upperSectionTotal2.add(sumToDisplay);
		          selectedCategory1 = false;
		          selectedCategory2 = true;
				}
			}else if(category.equals("fives1") || category.equals("fives2")) {
				int sumToDisplay = 0;
				if(category.equals("fives1")){
			          for(int i = 0; i < diceFaces.size(); i++) {
			        	  if(diceFaces.get(i) == 5) {
			        		  sumToDisplay += 5;
			        	  }
			          }
			     fives1.setText(Integer.toString(sumToDisplay));
			     fives1.setEnabled(false);
			     upperSectionTotal1.add(sumToDisplay);
			     selectedCategory1 = true;
		         selectedCategory2 = false;
				}else {
					for(int i = 0; i < diceFaces.size(); i++) {
			        	  if(diceFaces.get(i) == 5) {
			        		  sumToDisplay += 5;
			        	  }
					}
		          fives2.setText(Integer.toString(sumToDisplay));
		          fives2.setEnabled(false);
		          upperSectionTotal2.add(sumToDisplay);
		          selectedCategory1 = false;
		          selectedCategory2 = true;
				}
			}else if(category.equals("sixes1") || category.equals("sixes2")) {
				int sumToDisplay = 0;
				if(category.equals("sixes1")){
			          for(int i = 0; i < diceFaces.size(); i++) {
			        	  if(diceFaces.get(i) == 6) {
			        		  sumToDisplay += 6;
			        	  }
			          }
			     sixes1.setText(Integer.toString(sumToDisplay));
			     sixes1.setEnabled(false);
			     upperSectionTotal1.add(sumToDisplay);
			     selectedCategory1 = true;
		         selectedCategory2 = false;
				}else {
					for(int i = 0; i < diceFaces.size(); i++) {
			        	  if(diceFaces.get(i) == 6) {
			        		  sumToDisplay += 6;
			        	  }
					}
		          sixes2.setText(Integer.toString(sumToDisplay));
		          sixes2.setEnabled(false);
		          upperSectionTotal2.add(sumToDisplay);
		          selectedCategory1 = false;
		          selectedCategory2 = true;
				}	
			}else if(category.equals("threeOfAKind1") || category.equals("threeOfAKind2")) {
			 if(category.equals("threeOfAKind1")) {
				threeOfAKind1.setText(Integer.toString(100));
	             threeOfAKind1.setEnabled(false); 
	         
	           
	         }else {
	        	 threeOfAKind2.setText(Integer.toString(100));
	             threeOfAKind2.setEnabled(false); 
	         }
			
				
			}else if(category.equals("fullHouse1") || category.equals("fullHouse2")) {
		        if(category.equals("fullHouse1")) {
		        	fullHouse1.setText(Integer.toString(100));
		             fullHouse1.setEnabled(false); 
		         
		           
		         }else {
		        	 fullHouse2.setText(Integer.toString(100));
		             fullHouse2.setEnabled(false); 
		         }
		         
			}else if(category.equals("fourOfAKind1") || category.equals("fourOfAKind2")) {
			 	if(category.equals("fourOfAKind1")) {
				fourOfAKind1.setText(Integer.toString(100));
	             fourOfAKind1.setEnabled(false); 
	           
	         }else {
	        	 fourOfAKind2.setText(Integer.toString(100));
	             fourOfAKind2.setEnabled(false); 
	         }
				
			}else if(category.equals("smStraight1") || category.equals("smStraight2")) {
		         if(category.equals("smStraight1")) {
		        	 if(diceFaces.contains(1) && diceFaces.contains(2) && diceFaces.contains(3) && diceFaces.contains(4)) {
		        	
		        		 smStraight1.setText("30");
		        		 lowerSectionTotal1.add(30);
		        		 smStraight1.setEnabled(false);	 
		        		 selectedCategory1 = true;
				         selectedCategory2 = false;
		        		 
		        	 }else if(diceFaces.contains(2) && diceFaces.contains(3) && diceFaces.contains(4) && diceFaces.contains(5)) {        		
		        		 smStraight1.setText("30");
		        		 lowerSectionTotal1.add(30);
				         smStraight1.setEnabled(false);	
				         selectedCategory1 = true;
				         selectedCategory2 = false;
		 
		        	 }else if(diceFaces.contains(3) && diceFaces.contains(4) && diceFaces.contains(5) && diceFaces.contains(6)) {
		        		
		        		 smStraight1.setText("30");
		        		 lowerSectionTotal1.add(30);
				         smStraight1.setEnabled(false);	
				         selectedCategory1 = true;
				         selectedCategory2 = false;
		        	 }else {
		        		 smStraight1.setText("0");
				         smStraight1.setEnabled(false);
				         selectedCategory1 = true;
				         selectedCategory2 = false;
		    
		        	 }
		        	
		           
		         }else {
		        	 if(diceFaces.contains(1) && diceFaces.contains(2) && diceFaces.contains(3) && diceFaces.contains(4)) {
			        		
		        		 smStraight2.setText("30");
		        		 lowerSectionTotal2.add(30);
		        		 smStraight2.setEnabled(false);	
		        		 selectedCategory1 = false;
				         selectedCategory2 = true;
		        		 
		        	 }else if(diceFaces.contains(2) && diceFaces.contains(3) && diceFaces.contains(4) && diceFaces.contains(5)) {
		        		
		        		 smStraight2.setText("30");
		        		 lowerSectionTotal2.add(30);
				         smStraight2.setEnabled(false);
				         selectedCategory1 = false;
				         selectedCategory2 = true;
		 
		        	 }else if(diceFaces.contains(3) && diceFaces.contains(4) && diceFaces.contains(5) && diceFaces.contains(6)) {
		        		
		        		 smStraight2.setText("30");
		        		 lowerSectionTotal2.add(30);
				         smStraight2.setEnabled(false);	
				         selectedCategory1 = false;
				         selectedCategory2 = true;
				         
		        	 }else {
		        		 smStraight2.setText("0");
				         smStraight2.setEnabled(false);	
				         selectedCategory1 = false;
				         selectedCategory2 = true;
		        	 }
		         }
		         
		       }else if(category.equals("lgStraight1") || category.equals("lgStraight2")) {
		         if(category.equals("lgStraight1")) {
		        	 if(diceFaces.contains(1) && diceFaces.contains(2) && diceFaces.contains(3) && diceFaces.contains(4) && diceFaces.contains(5)) {
		        		 lgStraight1.setText("40");
		        		 lowerSectionTotal1.add(40);
				         lgStraight1.setEnabled(false);
				         selectedCategory1 = true;
				         selectedCategory2 = false;
		        	 }else if(diceFaces.contains(2) && diceFaces.contains(3) && diceFaces.contains(4) && diceFaces.contains(5) && diceFaces.contains(6)) {
		        		 lgStraight1.setText("40");
		        		 lowerSectionTotal1.add(40);
				         lgStraight1.setEnabled(false);
				         selectedCategory1 = true;
				         selectedCategory2 = false;
		        	 }else {
		        		 lgStraight1.setText("0");
				         lgStraight1.setEnabled(false);	
				         selectedCategory1 = true;
				         selectedCategory2 = false;
		        	 }
		         }else {
		        	 if(diceFaces.contains(1) && diceFaces.contains(2) && diceFaces.contains(3) && diceFaces.contains(4) && diceFaces.contains(5)) {
		        		 lgStraight2.setText("40");
		        		 lowerSectionTotal2.add(40);
				         lgStraight2.setEnabled(false);
				         selectedCategory1 = false;
				         selectedCategory2 = true;
		        	 }else if(diceFaces.contains(2) && diceFaces.contains(3) && diceFaces.contains(4) && diceFaces.contains(5) && diceFaces.contains(6)) {
		        		 lgStraight2.setText("40");
		        		 lowerSectionTotal2.add(40);
				         lgStraight2.setEnabled(false);
				         selectedCategory1 = false;
				         selectedCategory2 = true;
		        	 }else {
		        		 lgStraight2.setText("0");
				         lgStraight2.setEnabled(false);
				         selectedCategory1 = false;
				         selectedCategory2 = true;
		        	 }
		           
		         }
		         
		       }else if(category.equals("chance1") || category.equals("chance2")) {
		           int sum = 0;
		           if(category.equals("chance1")) {
		             for(int i = 0 ; i < diceFaces.size(); i++){
		               sum += diceFaces.get(i);
		             }
		             chance1.setText(Integer.toString(sum));
		             chance1.setEnabled(false);
		             lowerSectionTotal1.add(sum);
		             selectedCategory1 = true;
			         selectedCategory2 = false;
		           }else {
		             for(int i = 0 ; i < diceFaces.size(); i++){
		               sum += diceFaces.get(i);
		               }
		             chance2.setText(Integer.toString(sum));
		             chance2.setEnabled(false);
		             lowerSectionTotal2.add(sum);
		             selectedCategory1 = false;
			         selectedCategory2 = true;
		           }
		       }else if(category.equals("yahtzee1") || category.equals("yahtzee2")) {
		         if(category.equals("yahtzee1")) {
		        	 int isEqual = 0;
		        	 for(int i = 0; i < diceFaces.size()-1; i++) {
		        		 if(diceFaces.get(i) == diceFaces.get(i+1)) {
		        			 isEqual++;
		        		 }
		        	 }
		        	 System.out.println(isEqual);
		        	 if(isEqual == 4) {
		        		 yahtzee1.setText("50");
		        		 lowerSectionTotal1.add(50);
		        		 yahtzee1.setEnabled(false);
		        		 selectedCategory1 = true;
				         selectedCategory2 = false;
		        	 }else {
		        		 yahtzee1.setText("0");
		        		 yahtzee1.setEnabled(false);
		        		 selectedCategory1 = true;
				         selectedCategory2 = false;
		        	 }
		          /* yahtzeeTimes1++;
		           if(yahtzeeTimes1 > 1) {
		             JOptionPane.showMessageDialog(null, "You rolled another Yahtzee! 100 point bonus!", "YAHTZEE!", 1);
		             int newPointValue = Integer.parseInt(yahtzee1.getText()) + 100;
		             yahtzee1.setText(Integer.toString(newPointValue));
		           }*/
		           
		         }else {
		        	 int isEqual = 0;
		        	 for(int i = 0; i < diceFaces.size()-1; i++) {
		        		 if(diceFaces.get(i) == diceFaces.get(i+1)) {
		        			 isEqual++;
		        		 }
		        	 }
		        	 if(isEqual == 4) {
		        		 yahtzee2.setText("50");
		        		 lowerSectionTotal2.add(30);
		        		 yahtzee2.setEnabled(false);
		        		 selectedCategory1 = false;
				         selectedCategory2 = true;
		        	 }else {
		        		 yahtzee2.setText("0");
		        		 yahtzee2.setEnabled(false);
		        		 selectedCategory1 = false;
				         selectedCategory2 = true;
		        	 }
		        	/* yahtzeeTimes2++;
		           	if(yahtzeeTimes2 > 1) {
		             JOptionPane.showMessageDialog(null, "You rolled another Yahtzee! 100 point bonus!", "YAHTZEE!", 1);
		             int newPointValue = Integer.parseInt(yahtzee2.getText()) + 100;
		             yahtzee2.setText(Integer.toString(newPointValue));
		           }*/
		           
		         }
		         
		       }
				int bonus1 = 0;
				int bonus2 = 0;
				if((!(aces1.isEnabled()))&&(!(twos1.isEnabled()))&&(!(threes1.isEnabled()))&&(!(fours1.isEnabled()))&&(!(fives1.isEnabled()))&&(!(sixes1.isEnabled()))){
					for(int i = 0; i < upperSectionTotal1.size(); i++) {
						playerOneScore += upperSectionTotal1.get(i);
					}
					sumUpper1.setText(Integer.toString(playerOneScore));
					if(playerOneScore >= 63) {
						bonusSum1.setText("35");
						bonus1 = 35;
					}else {
						bonusSum1.setText("0");	
					}
				
				}
				if((!(aces2.isEnabled()))&&(!(twos2.isEnabled()))&&(!(threes2.isEnabled()))&&(!(fours2.isEnabled()))&&(!(fives2.isEnabled()))&&(!(sixes2.isEnabled()))){
					for(int i = 0; i < upperSectionTotal2.size(); i++) {
						playerTwoScore += upperSectionTotal2.get(i);
					}
					sumUpper2.setText(Integer.toString(playerTwoScore));
					if(playerTwoScore >= 63) {
						bonusSum2.setText("35");
						bonus2 = 35;
					}else {
						bonusSum2.setText("0");	
					}
				}
				
				int totalSum1 = 0;
				int totalSum2 = 0;
				boolean gameOver1 = false;
				boolean gameOver2 = false;
				
				if((!(threeOfAKind1.isEnabled())) && (!(fourOfAKind1.isEnabled())) && (!(fullHouse1.isEnabled())) && (!(smStraight1.isEnabled())) && (!(lgStraight1.isEnabled())) && (!(chance1.isEnabled())) && (!(yahtzee1.isEnabled()))) {
					for(int i = 0; i < lowerSectionTotal1.size(); i++) {
						totalSum1 += lowerSectionTotal1.get(i);
					}
					totalSum1 += playerOneScore + bonus1;
					totalSumLower1.setText(Integer.toString(totalSum1));
					gameOver1 = true;
				}
				
				if((!(threeOfAKind2.isEnabled())) && (!(fourOfAKind2.isEnabled())) && (!(fullHouse2.isEnabled())) && (!(smStraight2.isEnabled())) && (!(lgStraight2.isEnabled())) && (!(chance2.isEnabled())) && (!(yahtzee2.isEnabled()))) {
					for(int i = 0; i < lowerSectionTotal2.size(); i++) {
						totalSum2 += lowerSectionTotal2.get(i);
					}
					totalSum2 += playerTwoScore + bonus2;
					totalSumLower2.setText(Integer.toString(totalSum2));
					gameOver2 = true;
				}
			
			if(selectedCategory1) {
				p1.setEnabled(false);
			}else {
				p1.setEnabled(true);
			}
			
			if(selectedCategory2) {
				p2.setEnabled(false);
			}else {
				p2.setEnabled(true);
			}
			
			if(gameOver1 && gameOver2) {
				//if player one wins
				if(Integer.parseInt(totalSumLower1.getText()) > Integer.parseInt(totalSumLower2.getText())) {
					JOptionPane.showMessageDialog(null, "Player 1 wins!", "Game Over", 1);	
				}else if(Integer.parseInt(totalSumLower1.getText()) < Integer.parseInt(totalSumLower2.getText())) { //if player two wins
					JOptionPane.showMessageDialog(null, "Player 2 wins!", "Game Over", 1);	
				}else { //if tie
					JOptionPane.showMessageDialog(null, "Tie!", "Game Over", 1);	
				}
			}
    	
		}
    }
}

