package attack;

public class Attack {

	private int basicdmg;
	private String name;
	private int boost;
	private int attackclass;
	private int attackid;
	private char[] keyKombo = new char[3];
	
	public Attack(String pName, int pBasicdmg, int pBoost, int pPokeclass, char[] pKeykombo){
		name = pName;
		basicdmg = pBasicdmg;
		boost = pBoost;
		attackclass = pPokeclass;
		keyKombo = pKeykombo;
	}
	
	public int getBasicdmg(){
		return basicdmg;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName(){
		return name;
	}
	
	public int getBoost(){
		return boost;
	}
	
	public int getPokeclass(){
		return attackclass;
	}
	
	public char[] getKeykombo(){
		return keyKombo;
	}

	
	
	
	

}
