package pokemon;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import attack.Attack;

public abstract class Pokemon {

	protected int lvl;
	protected int maxHP;
	protected int currentHP;
	protected int maxEP, dmgAdd;
	protected int currentEP;
	protected String name;
	protected List<Attack> attack_list = new ArrayList<Attack>();
	protected int dmg_multi;
	protected int MaxDev;
	protected String poke_img;
	protected int poke_class; // 0=normal, 1=blitz, 2 blatt, 3 feuer, 4 wasser

	public Pokemon(String pName, int pHP, String pPoke_img, int Poke_class) {
		this.dmgAdd = 0;
		this.name = pName;
		this.poke_class = Poke_class;
		this.poke_img = pPoke_img;
		this.maxHP = pHP;
		this.currentHP = pHP;
		this.lvl = 1;
		this.dmg_multi = 0;
		this.MaxDev = 0;
		this.maxEP = this.lvl * 10;
		this.currentEP = 0;
	}
	
	public ImageIcon getPImage(){
		String pfad= "img/"+this.poke_img + "p.png";
		return new ImageIcon(pfad);
	}
	
	public ImageIcon getEImage(){
		String pfad= "img/"+this.poke_img + "e.png";
		return new ImageIcon(pfad);
	}

	public void learn(Attack pAtt) {
		attack_list.add(pAtt);
		}

	public int getLevel() {
		return lvl;
	}
	
	public int getCurrentEp() {
		return currentEP;
	}
	
	public int increaseEP(int EPinc) {
		int retVal=2;
		currentEP += EPinc;
		if(currentEP < maxEP)
			retVal=0;
		
		while(currentEP >= maxEP){
			if(lvlUp()==1)
				retVal=1;
		}
		return retVal;
			
			
	}
	
	public int getDmgAdd() {
		return dmgAdd;
	}

	public int getMaxHP() {
		return this.maxHP;
	}

	public int lvlUp() {
		this.lvl++;
		this.maxHP++;
		this.dmgAdd++;
		this.currentEP-=this.maxEP;
		this.maxEP=this.lvl*10;
		heal((int)(0.5*this.maxHP));
		return 0;
	}

	public void dmg(int pDmg) {
		this.currentHP -= pDmg;
		if (this.currentHP < 0)
			this.currentHP = 0;
	}

	public void heal(int pHeal) {
		this.currentHP += pHeal;
		if (this.currentHP > this.maxHP)
			this.currentHP = this.maxHP;
	}

	public abstract void attack(int pNr, Pokemon pZiel);

	public int getPokeClass() {
		return this.poke_class;
	}

	public String getName() {
		return this.name;
	}

	public String getImage() {
		return this.poke_img;
	}

	public int getCurrentHP() {
		return this.currentHP;
	}

	public Attack getAttackFromList(int pID) {
		return attack_list.get(pID);
	}

	public int getMaxEP() {
		return this.maxEP;
	}

	public void setCurrentHP(int pCurrentHP) {
		this.currentHP = pCurrentHP;
	}

	public int getDmgMulti() {
		return this.dmg_multi;
	}

	public String toString() {
		ArrayList<String> typeclass = new ArrayList<String>();
		typeclass.add("Normal");
		typeclass.add("Elektro");
		typeclass.add("Pflanze");
		typeclass.add("Feuer");
		typeclass.add("Wasser");

		String info = this.name + "";
		info += "\nLevel: " + this.lvl;
		info += "\nmaxHP: " + this.maxHP;
		info += "\ncurrentHP: " + this.currentHP;
		info += "\nmaxEP: " + this.maxEP;
		info += "\ncurrentEP: " + this.currentEP;
		info += "\ndmg_multi: " + this.dmg_multi;
		info += "\nPfad img: " + this.poke_img;
		info += "\npoke_class: " + this.poke_class + " "
				+ typeclass.get(this.poke_class) + "\n\n";

		for (Attack a : attack_list)
			info += a + "\n";
		return info;
	}
}
