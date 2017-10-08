import java.util.ArrayList;

public class PokemonVersion
	{
		static ArrayList<Pokemon> dictionary = new ArrayList<Pokemon>();
		public static void fillDictionary()
		{
			dictionary.add(new Pokemon("Bulbasaur", 1, "Grass", "Tackle 40", 40, "Vine Whip 40", 40, "None", 0, "None", 0, 5 ,100 ,100 ,30 ,10 ));
			dictionary.add(new Pokemon("Ivysaur", 2, "Grass", "Tackle 40", 40, "Vine Whip 40", 40, "Double-Edge 80", 60, "None", 0, 16 ,320 ,200 ,80 ,35 ));
			dictionary.add(new Pokemon("Venusaur", 3, "Grass", "Tackle 40", 40, "Vine Whip 40", 40, "Double-Edge 80", 60, "Solar Beam 80", 80, 36 ,720 ,420 ,200 ,80 ));
			dictionary.add(new Pokemon("Charmander", 4, "Fire",  "Scratch 40", 40, "Ember 40", 40, "None", 0, "None", 0, 5, 100, 100, 30, 10));
			dictionary.add(new Pokemon("Charmeleon", 5, "Fire", "Scratch 40", 40, "Ember 40", 40, "Bite 60", 60, "None", 0, 16 ,320 ,200 ,80 ,35));
			dictionary.add(new Pokemon("Charmander", 6, "Fire", "Scratch 40", 40, "Ember 40", 40, "Bite 60", 60, "Flare Blitz 80", 80, 36 ,720 ,420 ,200 ,80 ));
			dictionary.add(new Pokemon("Squirtle", 7, "Water", "Tackle 40", 40, "Water Gun 40", 40, "None", 0, "None", 0, 5, 100, 100, 30, 10));
			dictionary.add(new Pokemon("Wartortle", 8, "Water", "Tackle 40", 40, "Water Gun 40", 40, "Freeze 60", 60, "None", 0, 16 ,320 ,200 ,80 ,35));
			dictionary.add(new Pokemon("Blastoise", 9, "Water", "Tackle 40", 40, "Water Gun 40", 40, "Freeze 60", 60, "Hydro Pump 80", 80, 36 ,720 ,420 ,200 ,80 ));
		}
		
				
			
		
			

	}
