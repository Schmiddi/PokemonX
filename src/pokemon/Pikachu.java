package pokemon;

public class Pikachu extends Pokemon {
	
	public Pikachu( int iHP) {
		super("Pikachu",35, "poke25",1);
		this.MaxDev=1;
	}

	public void attack(int inr, Pokemon ziel) {
		ziel.dmg(this.attack_list.get(inr).getBasicdmg());
	}
	
	public int lvlUp() {
		super.lvlUp();
		if(this.lvl==30){
			this.name="Raichu";
			this.maxHP=60;
			this.currentHP=this.maxHP;
			this.poke_img="poke26";
			return 1;
		}
		return 0;
	}

}
