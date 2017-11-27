
import java.sql.Time;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.omg.Messaging.SyncScopeHelper;

public class PokemonGame
{
	static ArrayList<Pokemon> myPokemon = new ArrayList<Pokemon>();
	static int powerOfSkill = 0;
	static int powerOfSkillE = 0;
	static int exp = 100;
	static String ui;
	static boolean playing;

	public static void main(String[] args)
	{
		PokemonVersion.fillDictionary();
		greetUser();
		choosePokemon();
		checkPokemon();
		tellStats();
		battleOpponent();
		chooseRandomEnemySkills();
		chooseUserSkills();
		levelUp();
		evolvePokemon();
	}

	private static void greetUser()
	{
		Scanner userinput = new Scanner(System.in);
		System.out.println("Welcome to the Pokemon world! Press enter to begin");
		String space1 = userinput.nextLine();
		System.out.println("Here, you will become a trainer and start your adventure into the Pokemon Battle");
		String space4 = userinput.nextLine();
		//this is unrealistic. pikachu does not look like this
	}

	private static void choosePokemon()
	{
		Scanner userInput = new Scanner(System.in);
		System.out.println("First, you need to pick up your first pokemon");
		System.out.println("1. Bulbasaur.     2. Charmander.     3. Squirtle");
		String chooser = userInput.nextLine();
		if (chooser.equals("Bulbasaur") || chooser.equals("1"))
		{
			System.out.println("Here is your pokemon: Bulbasaur!!!");
			myPokemon.add(PokemonVersion.dictionary.get(0));
			//please change the arrayList name it's very confusing.

		} else if (chooser.equals("Charmander") || chooser.equals("2"))
		{
			System.out.println("Here is your pokemon: Charmander!!!");
			myPokemon.add(PokemonVersion.dictionary.get(3));

		} else if (chooser.equals("Squirtle") || chooser.equals("3"))
		{
			System.out.println("Here is your pokemon: Squirtle!!!");
			myPokemon.add(PokemonVersion.dictionary.get(6));
		} else
		{
			System.out.println("pick error, please pick the number or the name");
			choosePokemon();
		}

	}

	private static void checkPokemon()
	{
		Scanner userInput = new Scanner(System.in);
		// fixed spelling
		System.out.println("Do you want to check your pokemon?");
		System.out.println("1. Yes   2. No");
		String u = userInput.nextLine();
		if (u.equals("2") || u.equals("No") || u.equals("no"))
		{
			askToKeepPlaying();
		}

	}

	private static void askToKeepPlaying()
	{
		Scanner userInput = new Scanner(System.in);
		System.out.println();
		System.out.println("Do you want to keep playing?");
		System.out.println("1. Yes   2. No");
		ui = userInput.nextLine();
		if (ui.equals("2") || ui.equals("No") || ui.equals("no"))
		{
			System.out.println("the end!!!");
			System.out.println("thanks for playing!!!");
			System.out.println("see you next time");
		} else
		{
			battleOpponent();
		}
	}

	private static void tellStats()
	{
		for (Pokemon p : myPokemon)
		{
			System.out.println("Name: " + p.getName());
			System.out.println("Type: " + p.getType());
			System.out.println("Level: " + p.getLevel());
			System.out.println("HP: " + p.getHealthPoint());
			System.out.println("AttackPoint: " + p.getAttackPoint());
			System.out.println("DefencePoint: " + p.getDefencePoint());
			System.out.println("Skill1: " + p.getSkill1());
			System.out.println("Skill2: " + p.getSkill2());
			System.out.println("Skill3: " + p.getSkill3());
			System.out.println("Skill4: " + p.getSkill4());

		}

	}

	private static void battleOpponent()
	{
		Scanner userinput = new Scanner(System.in);
		String space = userinput.nextLine();
		int n = (int) ((Math.random() * 4) + 3);
		for (int p = 0; p < n; p++)
		{
			try
			{
				Thread.sleep(200);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print(".");
		}
		System.out.println();
		int randomNumber = (int) (Math.random() * 3);
		int randomNumber1 = randomNumber * 3;
		int randomNumber2 = randomNumber * 3 + 1;
		int randomNumber3 = randomNumber * 3 + 2;
		if (myPokemon.get(0).getLevel() < 17)
		{
			// spelling
			System.out.println(
					"The wild " + PokemonVersion.dictionary.get(randomNumber1).getName() + " jumps out. Time to fight");
			String space1 = userinput.nextLine();
			int wildPokemonLevel = myPokemon.get(0).getLevel() - 2;
			System.out.println();
			System.out.println(PokemonVersion.dictionary.get(randomNumber1).getName());
			System.out.println("level: " + wildPokemonLevel);
			int wildPokemonHP = myPokemon.get(0).getHealthPoint() - 40;
			System.out.println("HP: " + wildPokemonHP);
			String space2 = userinput.nextLine();

			int wildPokemonAttack = myPokemon.get(0).getAttackPoint() - 10;
			int wildPokemonDefence = myPokemon.get(0).getDefencePoint() - 4;
			int differenceOfAttAndDef = myPokemon.get(0).getAttackPoint() / wildPokemonDefence;
			int differenceOfDefAndAtt = wildPokemonAttack / myPokemon.get(0).getDefencePoint();
			int myPokemonHP = myPokemon.get(0).getHealthPoint();
			int totalDamageToEnemy = 0;
			int totalDamageToPlayer = 0;
			while (myPokemonHP > 0 && wildPokemonHP > 0)
			{

				System.out.println("my Pokemon HP: " + myPokemonHP);
				System.out.println("the wild pokemon HP: " + wildPokemonHP);
				chooseUserSkills();
				chooseRandomEnemySkills();
				int randomNumberAttack = (int) (Math.random() * 10) + 1;
				if (myPokemonHP < 0 || myPokemonHP == 0)
				{
					System.out.println("you lose");
					break;
				} else
				{
					switch (randomNumberAttack)
					{
					case 1:
					{

						totalDamageToEnemy = 0;
						wildPokemonHP = wildPokemonHP - totalDamageToEnemy;
						try
						{
							Thread.sleep(500);
						} catch (InterruptedException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("Oh no, you missed, so you made " + totalDamageToEnemy + " damage");
						System.out.println(PokemonVersion.dictionary.get(randomNumber1).getName() + " has "
								+ wildPokemonHP + " HP left");
						System.out.println();
						break;

					}
					case 2:
					case 3:
					case 4:
					case 5:
					case 6:
					case 7:
					case 8:
					case 9:
					{

						totalDamageToEnemy = differenceOfAttAndDef * powerOfSkill / 10;
						wildPokemonHP = wildPokemonHP - totalDamageToEnemy;
						try
						{
							Thread.sleep(500);
						} catch (InterruptedException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						// spelling
						System.out.println("you made " + totalDamageToEnemy + " damage");
						System.out.println(PokemonVersion.dictionary.get(randomNumber1).getName() + " has "
								+ wildPokemonHP + " HP left");
						System.out.println();
						break;

					}
					case 10:
					{

						totalDamageToEnemy = differenceOfAttAndDef * powerOfSkill / 5;
						wildPokemonHP = wildPokemonHP - totalDamageToEnemy;
						try
						{
							Thread.sleep(500);
						} catch (InterruptedException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						// spelling
						System.out.println("Good job, that is critical, you made " + totalDamageToEnemy + " damage");
						System.out.println(PokemonVersion.dictionary.get(randomNumber1).getName() + " has "
								+ wildPokemonHP + " HP left");
						System.out.println();
						break;

					}
					}
				}
				// for wild pokemon
				int randomNumberAttack2 = (int) (Math.random() * 10) + 1;
				if (wildPokemonHP < 0 || wildPokemonHP == 0)
				{
					System.out.println("you win!!!");
					System.out.println("EXP adding...");
					System.out.println();
					levelUp();
					evolvePokemon();
					System.out.println();
					break;
				} else
				{
					switch (randomNumberAttack2)
					{
					case 1:
					{
						totalDamageToPlayer = 0;
						myPokemonHP = myPokemonHP - totalDamageToPlayer;
						try
						{
							Thread.sleep(500);
						} catch (InterruptedException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(
								"the wild pokemon missed, so " + PokemonVersion.dictionary.get(randomNumber1).getName()
										+ " made " + totalDamageToPlayer + " damage to you");
						System.out.println("your pokemon has " + myPokemonHP + " HP left");
						System.out.println();
						break;

					}
					case 2:
					case 3:
					case 4:
					case 5:
					case 6:
					case 7:
					case 8:
					case 9:
					{

						totalDamageToPlayer = differenceOfDefAndAtt * powerOfSkillE / 10;
						myPokemonHP = myPokemonHP - totalDamageToPlayer;
						try
						{
							Thread.sleep(500);
						} catch (InterruptedException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(PokemonVersion.dictionary.get(randomNumber1).getName() + " made "
								+ totalDamageToPlayer + " damage to you");
						System.out.println("your pokemon has " + myPokemonHP + " HP left");
						System.out.println();
						break;

					}
					case 10:
					{
						totalDamageToPlayer = differenceOfDefAndAtt * powerOfSkillE / 5;
						myPokemonHP = myPokemonHP - totalDamageToPlayer;
						try
						{
							Thread.sleep(500);
						} catch (InterruptedException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("Oh no, the wild pokemon made a critical, so "
								+ PokemonVersion.dictionary.get(randomNumber1).getName() + " made "
								+ totalDamageToPlayer + " damage to you");
						System.out.println("your pokemon has " + myPokemonHP + " HP left");
						System.out.println();
						break;
					}
					}

				}
			}

		}

		else if (myPokemon.get(0).getLevel() > 17 && myPokemon.get(0).getLevel() < 37)
		{
			System.out.println(
					"the wild " + PokemonVersion.dictionary.get(randomNumber1).getName() + " jumps out, time to fight");
			String space1 = userinput.nextLine();
			int wildPokemonLevel = myPokemon.get(0).getLevel() - 2;
			System.out.println();
			System.out.println(PokemonVersion.dictionary.get(randomNumber2).getName());
			System.out.println("level: " + wildPokemonLevel);
			int wildPokemonHP = myPokemon.get(0).getHealthPoint() - 40;
			System.out.println("HP: " + wildPokemonHP);
			String space2 = userinput.nextLine();

			int wildPokemonAttack = myPokemon.get(0).getAttackPoint() - 20;
			int wildPokemonDefence = myPokemon.get(0).getDefencePoint() - 8;
			int differenceOfAttAndDef = myPokemon.get(0).getAttackPoint() / wildPokemonDefence;
			int differenceOfDefAndAtt = wildPokemonAttack / myPokemon.get(0).getDefencePoint();
			int myPokemonHP = myPokemon.get(0).getHealthPoint();
			int totalDamageToEnemy = 0;
			int totalDamageToPlayer = 0;
			while (myPokemonHP > 0 && wildPokemonHP > 0)
			{

				System.out.println("my Pokemon HP: " + myPokemonHP);
				System.out.println("the wild pokemon HP: " + wildPokemonHP);
				chooseUserSkills();
				chooseRandomEnemySkills();
				int randomNumberAttack = (int) (Math.random() * 10) + 1;
				if (myPokemonHP < 0 || myPokemonHP == 0)
				{
					System.out.println("you lose");
					break;
				} else
				{
					switch (randomNumberAttack)
					{
					case 1:
					{

						totalDamageToEnemy = 0;
						wildPokemonHP = wildPokemonHP - totalDamageToEnemy;
						try
						{
							Thread.sleep(500);
						} catch (InterruptedException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("Oh no, you missed, so you made " + totalDamageToEnemy + " damage");
						System.out.println(PokemonVersion.dictionary.get(randomNumber1).getName() + " has "
								+ wildPokemonHP + " HP left");
						System.out.println();
						break;

					}
					case 2:
					case 3:
					case 4:
					case 5:
					case 6:
					case 7:
					case 8:
					case 9:
					{

						totalDamageToEnemy = differenceOfAttAndDef * powerOfSkill / 10;
						wildPokemonHP = wildPokemonHP - totalDamageToEnemy;
						try
						{
							Thread.sleep(500);
						} catch (InterruptedException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("you made " + totalDamageToEnemy + " damage");
						System.out.println(PokemonVersion.dictionary.get(randomNumber1).getName() + " has "
								+ wildPokemonHP + " HP left");
						System.out.println();
						break;

					}
					case 10:
					{

						totalDamageToEnemy = differenceOfAttAndDef * powerOfSkill / 5;
						wildPokemonHP = wildPokemonHP - totalDamageToEnemy;
						try
						{
							Thread.sleep(500);
						} catch (InterruptedException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out
								.println("Good job, that is critical, you made the " + totalDamageToEnemy + " damage");
						System.out.println(PokemonVersion.dictionary.get(randomNumber1).getName() + " has "
								+ wildPokemonHP + " HP left");
						System.out.println();
						break;

					}

					}

				}

				int randomNumberAttack2 = (int) (Math.random() * 10) + 1;
				if (wildPokemonHP < 0 || wildPokemonHP == 0)
				{
					System.out.println("you win!!!");
					System.out.println("EXP adding...");
					levelUp();
					evolvePokemon();
					System.out.println();
					break;
				} else
				{
					switch (randomNumberAttack2)
					{
					case 1:
					{
						totalDamageToPlayer = 0;
						myPokemonHP = myPokemonHP - totalDamageToPlayer;
						try
						{
							Thread.sleep(500);
						} catch (InterruptedException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(
								"the wild pokemon missed, so " + PokemonVersion.dictionary.get(randomNumber1).getName()
										+ " made " + totalDamageToPlayer + " damage to you");
						System.out.println("your pokemon has " + myPokemonHP + " HP left");
						System.out.println();
						break;

					}
					case 2:
					case 3:
					case 4:
					case 5:
					case 6:
					case 7:
					case 8:
					case 9:
					{

						totalDamageToPlayer = differenceOfDefAndAtt * powerOfSkillE / 10;
						myPokemonHP = myPokemonHP - totalDamageToPlayer;
						try
						{
							Thread.sleep(500);
						} catch (InterruptedException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(PokemonVersion.dictionary.get(randomNumber1).getName() + " made "
								+ totalDamageToPlayer + " damage to you");
						System.out.println("your pokemon has " + myPokemonHP + " HP left");
						System.out.println();
						break;

					}
					case 10:
					{
						totalDamageToPlayer = differenceOfDefAndAtt * powerOfSkillE / 5;
						myPokemonHP = myPokemonHP - totalDamageToPlayer;
						try
						{
							Thread.sleep(500);
						} catch (InterruptedException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("Oh no, the wild pokemon made a critical, so "
								+ PokemonVersion.dictionary.get(randomNumber1).getName() + " made "
								+ totalDamageToPlayer + " damage to you");
						System.out.println("your pokemon has " + myPokemonHP + " HP left");
						System.out.println();
						break;
					}
					}

				}
			}
		} else if (myPokemon.get(0).getLevel() > 37)
		{
			System.out.println(
					"the wild " + PokemonVersion.dictionary.get(randomNumber1).getName() + " jumps out, time to fight");
			String space1 = userinput.nextLine();
			int wildPokemonLevel = myPokemon.get(0).getLevel() - 2;
			System.out.println();
			System.out.println(PokemonVersion.dictionary.get(randomNumber3).getName());
			System.out.println("level: " + wildPokemonLevel);
			int wildPokemonHP = myPokemon.get(0).getHealthPoint() - 40;
			System.out.println("HP: " + wildPokemonHP);
			String space2 = userinput.nextLine();

			int wildPokemonAttack = myPokemon.get(0).getAttackPoint() - 30;
			int wildPokemonDefence = myPokemon.get(0).getDefencePoint() - 12;
			int differenceOfAttAndDef = myPokemon.get(0).getAttackPoint() / wildPokemonDefence;
			int differenceOfDefAndAtt = wildPokemonAttack / myPokemon.get(0).getDefencePoint();
			int myPokemonHP = myPokemon.get(0).getHealthPoint();
			int totalDamageToEnemy = 0;
			int totalDamageToPlayer = 0;
			while (myPokemonHP > 0 && wildPokemonHP > 0)
			{

				System.out.println("my Pokemon HP: " + myPokemonHP);
				System.out.println("the wild pokemon HP: " + wildPokemonHP);
				chooseUserSkills();
				chooseRandomEnemySkills();
				int randomNumberAttack = (int) (Math.random() * 10) + 1;
				if (myPokemonHP < 0 || myPokemonHP == 0)
				{
					System.out.println("you lose");
					break;
				} else
				{
					switch (randomNumberAttack)
					{
					case 1:
					{

						totalDamageToEnemy = 0;
						wildPokemonHP = wildPokemonHP - totalDamageToEnemy;
						try
						{
							Thread.sleep(500);
						} catch (InterruptedException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("Oh no, you missed, so you made " + totalDamageToEnemy + " damage");
						System.out.println(PokemonVersion.dictionary.get(randomNumber1).getName() + " has "
								+ wildPokemonHP + " HP left");
						System.out.println();
						break;

					}
					case 2:
					case 3:
					case 4:
					case 5:
					case 6:
					case 7:
					case 8:
					case 9:
					{

						totalDamageToEnemy = differenceOfAttAndDef * powerOfSkill / 10;
						wildPokemonHP = wildPokemonHP - totalDamageToEnemy;
						try
						{
							Thread.sleep(500);
						} catch (InterruptedException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("you made the " + totalDamageToEnemy + " damage");
						System.out.println(PokemonVersion.dictionary.get(randomNumber1).getName() + " has "
								+ wildPokemonHP + " HP left");
						System.out.println();
						break;

					}
					case 10:
					{

						totalDamageToEnemy = differenceOfAttAndDef * powerOfSkill / 5;
						wildPokemonHP = wildPokemonHP - totalDamageToEnemy;
						try
						{
							Thread.sleep(500);
						} catch (InterruptedException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out
								.println("Good job, that is critical, you made the " + totalDamageToEnemy + " damage");
						System.out.println(PokemonVersion.dictionary.get(randomNumber1).getName() + " has "
								+ wildPokemonHP + " HP left");
						System.out.println();
						break;

					}

					}

				}

				int randomNumberAttack2 = (int) (Math.random() * 10) + 1;
				if (wildPokemonHP < 0 || wildPokemonHP == 0)
				{
					System.out.println("you win!!!");
					System.out.println("EXP adding...");
					levelUp();
					evolvePokemon();
					System.out.println();
					break;
				} else
				{
					switch (randomNumberAttack2)
					{
					case 1:
					{
						totalDamageToPlayer = 0;
						myPokemonHP = myPokemonHP - totalDamageToPlayer;
						try
						{
							Thread.sleep(500);
						} catch (InterruptedException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(
								"the wild pokemon missed, so " + PokemonVersion.dictionary.get(randomNumber1).getName()
										+ " made " + totalDamageToPlayer + " damage to you");
						System.out.println("your pokemon has " + myPokemonHP + " HP left");
						System.out.println();
						break;

					}
					case 2:
					case 3:
					case 4:
					case 5:
					case 6:
					case 7:
					case 8:
					case 9:
					{

						totalDamageToPlayer = differenceOfDefAndAtt * powerOfSkillE / 10;
						myPokemonHP = myPokemonHP - totalDamageToPlayer;
						try
						{
							Thread.sleep(500);
						} catch (InterruptedException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(PokemonVersion.dictionary.get(randomNumber1).getName() + " made "
								+ totalDamageToPlayer + " damage to you");
						System.out.println("your pokemon has " + myPokemonHP + " HP left");
						System.out.println();
						break;

					}
					case 10:
					{
						totalDamageToPlayer = differenceOfDefAndAtt * powerOfSkillE / 5;
						myPokemonHP = myPokemonHP - totalDamageToPlayer;
						try
						{
							Thread.sleep(500);
						} catch (InterruptedException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("Oh no, the wild pokemon made a critical, so "
								+ PokemonVersion.dictionary.get(randomNumber1).getName() + " made "
								+ totalDamageToPlayer + " damage to you");
						System.out.println("your pokemon has " + myPokemonHP + " HP left");
						System.out.println();
						break;
					}
					}

				}

			}
		} else
		{

		}

	}

	private static void chooseRandomEnemySkills()
	{
		int randomNumber = 0;
		if (myPokemon.get(0).getLevel() < 17)
		{
			randomNumber = (int) (Math.random() * 2) + 1;
		} else if (myPokemon.get(0).getLevel() > 16 && myPokemon.get(0).getLevel() < 37)
		{
			randomNumber = (int) (Math.random() * 3) + 1;
		} else if (myPokemon.get(0).getLevel() > 37)
		{
			randomNumber = (int) (Math.random() * 4) + 1;
		} else
		{

		}
		switch (randomNumber)
		{
		case 1:
		{
			powerOfSkillE = PokemonVersion.dictionary.get(2).getSkill1Power();
		}
		case 2:
		{
			powerOfSkillE = PokemonVersion.dictionary.get(2).getSkill2Power();
		}
		case 3:
		{
			powerOfSkillE = PokemonVersion.dictionary.get(2).getSkill3Power();
		}
		case 4:
		{
			powerOfSkillE = PokemonVersion.dictionary.get(2).getSkill4Power();
		}
		}

	}

	private static void chooseUserSkills()
	{
		System.out.println();
		System.out.println("which skills you want to choose?");
		System.out.println("1. " + myPokemon.get(0).getSkill1() + "  2. " + myPokemon.get(0).getSkill2() + "  3. "
				+ myPokemon.get(0).getSkill3() + "  4. " + myPokemon.get(0).getSkill4());
		Scanner userinput = new Scanner(System.in);
		int userChoose = userinput.nextInt();
		if (userChoose == 1)
		{
			powerOfSkill = myPokemon.get(0).getSkill1Power();
		} else if (userChoose == 2)
		{
			powerOfSkill = myPokemon.get(0).getSkill2Power();
		} else if (userChoose == 3)
		{
			powerOfSkill = myPokemon.get(0).getSkill3Power();
		} else if (userChoose == 4)
		{
			powerOfSkill = myPokemon.get(0).getSkill4Power();
		} else
		{
			System.out.println("error pick, do it again");
			chooseUserSkills();

		}

	}

	private static void levelUp()
	{
		exp -= exp;
		if (exp == 0)
		{
			System.out.println("level up");
			myPokemon.get(0).setLevel(myPokemon.get(0).getLevel() + 1);
			myPokemon.get(0).setAttackPoint(myPokemon.get(0).getAttackPoint() + 5);
			myPokemon.get(0).setDefencePoint(myPokemon.get(0).getDefencePoint() + 2);
			myPokemon.get(0).setExperiencePoint(myPokemon.get(0).getExperiencePoint() + 20);
			;
			exp = myPokemon.get(0).getExperiencePoint();

		} else
		{

		}

	}

	private static void evolvePokemon()
	{
		if (myPokemon.get(0).getLevel() == 16)
		{
			if (myPokemon.get(0).getName().equals(PokemonVersion.dictionary.get(0).getName()))
			{
				System.out.println("Congragulations!!!!! Your " + myPokemon.get(0).getName() + " evolve to "
						+ PokemonVersion.dictionary.get(1).getName());
				myPokemon.remove(0);
				myPokemon.add(PokemonVersion.dictionary.get(1));
			} else if (myPokemon.get(0).getName().equals(PokemonVersion.dictionary.get(3).getName()))
			{
				System.out.println("Congragulations!!!!! Your " + myPokemon.get(0).getName() + " evolve to "
						+ PokemonVersion.dictionary.get(4).getName());
				myPokemon.remove(0);
				myPokemon.add(PokemonVersion.dictionary.get(4));
			} else if (myPokemon.get(0).getName().equals(PokemonVersion.dictionary.get(6).getName()))
			{
				System.out.println("Congragulations!!!!! Your " + myPokemon.get(0).getName() + " evolve to "
						+ PokemonVersion.dictionary.get(7).getName());
				myPokemon.remove(0);
				myPokemon.add(PokemonVersion.dictionary.get(7));
			} else
			{

			}

		} else if (myPokemon.get(0).getLevel() == 36)
		{
			if (myPokemon.get(0).getName().equals(PokemonVersion.dictionary.get(1).getName()))
			{
				System.out.println("Congragulations!!!!! Your " + myPokemon.get(0).getName() + " evolve to "
						+ PokemonVersion.dictionary.get(2).getName());
				myPokemon.remove(0);
				myPokemon.add(PokemonVersion.dictionary.get(2));
			} else if (myPokemon.get(0).getName().equals(PokemonVersion.dictionary.get(4).getName()))
			{
				System.out.println("Congragulations!!!!! Your " + myPokemon.get(0).getName() + " evolve to "
						+ PokemonVersion.dictionary.get(5).getName());
				myPokemon.remove(0);
				myPokemon.add(PokemonVersion.dictionary.get(5));
			} else if (myPokemon.get(0).getName().equals(PokemonVersion.dictionary.get(7).getName()))
			{
				System.out.println("Congragulations!!!!! Your " + myPokemon.get(0).getName() + " evolve to "
						+ PokemonVersion.dictionary.get(8).getName());
				myPokemon.remove(0);
				myPokemon.add(PokemonVersion.dictionary.get(8));
			} else
			{

			}

		} else
		{

		}

	}

}
