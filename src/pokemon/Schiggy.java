package pokemon;

public class Schiggy extends Pokemon {
	
	public Schiggy( int iHP) {
		super("Schiggy",44, "poke7",4);
		this.MaxDev=2;
	}


	public void attack(int inr, Pokemon ziel) {
		ziel.dmg(this.attack_list.get(inr).getBasicdmg());
	}
	
	public int lvlUp() {
		super.lvlUp();
		if(this.lvl==16){
			this.name="Schillok";
			this.maxHP=59;
			this.currentHP=this.maxHP;
			this.poke_img="poke8";
			return 1;
		}
		if(this.lvl==36){
			this.name="Turtok";
			this.maxHP=79;
			this.currentHP=this.maxHP;
			this.poke_img="poke9";
			return 1;
		}
		return 0;
	}

}