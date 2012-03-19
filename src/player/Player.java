package player;

import pokemon.Pokemon;

public class Player {

	private Pokemon pokemon;
	private String name;

	public Player() {
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

	public void givePokemon(Pokemon pPokemon) {
		this.pokemon = pPokemon;
	}
}
