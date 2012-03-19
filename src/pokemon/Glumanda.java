package pokemon;

public class Glumanda extends Pokemon {
	
	public Glumanda(int iHP) {
		super("Glumanda", 39, "poke4", 3);
		this.MaxDev=2;
	}

	public void attack(int inr, Pokemon ziel) {
		ziel.dmg(this.attack_list.get(inr).getBasicdmg());
	}
	
	public int lvlUp() {
		super.lvlUp();
		System.out.println(this.lvl);
		if(this.lvl==16){

			System.out.println("lvl16");
			this.name="Glutexo";
			this.maxHP=58;
			this.currentHP=this.maxHP;
			this.poke_img="poke5";
			return 1;
		}
		else if(this.lvl==36){
			this.name="Glurak";
			this.maxHP=78;
			this.currentHP=this.maxHP;
			this.poke_img="poke6";
			return 1;
		}
		return 0;
	}

}
