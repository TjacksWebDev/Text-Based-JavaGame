package com.tysgames.main;

import java.util.Random;
import java.util.Scanner;

public class TextGameApp {

	public static void main(String[] args) {
		
		//System objects
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		
		//Game variables
		String[] enemies ={"Skeleton", "Zombie", "Warrior", "Assassin"};
		int maxEnemyHealth = 75;
		int enemyAttackDamage = 25;
		
		//Player variables
		int health = 100;
		int attackDamage = 50;
		int numHealthPots = 3;
		int healthPotionHealAmt = 30;
		int healthPotionDropChance = 50; //percentage
		
		//boolean variable
		boolean running = true;
		
		System.out.println("Welcome to the Dungeon!");
		
		//GAME:
			while(running) {
				System.out.println("------------------------------------");
				
				int enemyHealth = rand.nextInt(maxEnemyHealth);
				String enemy = enemies[rand.nextInt(enemies.length)];
				System.out.println("\t# "+ enemy + " has appeared! #\n");
				
				while(enemyHealth > 0) {
					System.out.println("\t Your HP: " + health);
					System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
					System.out.println("\n\t What do you want to do?");
					System.out.println("\t1. Attack!");
					System.out.println("\t2. Drink a health potion.");
					System.out.println("\t3. Run!");
					
					
					String input = in.nextLine();
					if(input.equals("1")) {
						int damageDealt = rand.nextInt(attackDamage);
						int damageTaken= rand.nextInt(enemyAttackDamage);
						
						enemyHealth -= damageDealt;
						health -= damageTaken;
						
						System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage");
						System.out.println("\t> You recieve " + damageTaken+ " in retaliation!");
						
						if(health < 1) {
							System.out.println("\t> You have taken too much damage, you are too weak to go on!");
							break;
						}
					
						
					}else if(input.equals("2")) {
						if(numHealthPots >0) {
							health+=healthPotionHealAmt;
							numHealthPots--;
							System.out.println("\t> You drink a health potion, healing yourself for: " + healthPotionHealAmt+ "."
											 +"\n\t> You now have "+health+ " HP."
											 +"\n\t> You have " + numHealthPots+" health potions remaining.");
							
						}
						else {
							System.out.println("\t> You have no health potions left, defeat enemies for a chance for one to drop.\n");
						}
											
					}
					else if (input.equals("3")) {
						System.out.println("\t> You run away from the " + enemy +" !");
						continue;
					}
					else {
						System.out.println("\t> INVALID COMMAND!");
						
					}
			}
				if(health < 1) {
					System.out.println("\t> You limp out of the Dungeon, weak from battle with blood loss.");
					break;
				}
				
				System.out.println("------------------------------------");
				System.out.println(" # " + enemy + " was defeated! #");
				System.out.println("YOU ARE THE WINNER!");
				System.out.println(" # You have "+health+ " HP left! #");
				if(rand.nextInt(100)< healthPotionDropChance) {
					numHealthPots++;
					System.out.println(" # The " + enemy + " has dropped a health potion! #");
					System.out.println(" # You now have a total of "+ numHealthPots+ " health pot(s). #");
					
				}
				
			System.out.println("------------------------------------");
			System.out.println("What would you liike to now?");
			System.out.println("1. Continue fighting");
			System.out.println("2. Exit Dungeon.");
				
			String input= in.nextLine();
			while(!input.equals("1") && !input.equals("2")) {
				System.out.println("> Invalid command!");
				input=in.nextLine();
				}
				if(input.equals("1")) {
					System.out.println("You shall continue your fun in Dungeon!");
				} else if(input.equals("2")) {
					System.out.println("You Exit the Dungeon, successful from your battle!!");
					System.out.println("WINNER!");
					System.out.println("Your winning stats are- Health: (" + health + ") Health Potions Remaining: (" + numHealthPots + ") Attack Damage amount: (" + attackDamage + ").\n");
					break;
				}
			}
			System.out.println("####################################");
			System.out.println(" # Thanks for Playig the Dungeon! # ");
			System.out.println("####################################");
	}
}



		


