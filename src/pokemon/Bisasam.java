package pokemon;

public class Bisasam extends Pokemon {
	

	public Bisasam(int iHP) {
		super("Bisasam", 45, "poke1", 2);
		this.MaxDev=2;
	}

	public void attack(int inr, Pokemon ziel) {
		ziel.dmg(this.attack_list.get(inr).getBasicdmg());
	}
	
	public int lvlUp() {
		super.lvlUp();
		if(this.lvl==16){
			this.name="Bisaknosp";
			this.maxHP=60;
			this.currentHP=this.maxHP;
			this.poke_img="poke2";
			return 1;
		}
		if(this.lvl==32){
			this.name="Bisaflor";
			this.maxHP=80;
			this.currentHP=this.maxHP;
			this.poke_img="poke3";
			return 1;
		}
		return 0;
	}
}
