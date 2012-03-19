package pokemon;

public class Mauzi extends Pokemon {

	public Mauzi( int iHP) {
		super("Mauzi",40, "poke52",2);
		this.MaxDev=1;
	}

	public void attack(int inr, Pokemon ziel) {
		ziel.dmg(this.attack_list.get(inr).getBasicdmg());
	}
	
	public int lvlUp() {
		super.lvlUp();
		if(this.lvl==28){
			this.name="Snobilikat";
			this.maxHP=65;
			this.currentHP=this.maxHP;
			this.poke_img="poke53";
			return 1;
		}
		return 0;
	}
}
