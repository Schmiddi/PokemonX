package fight;

import java.util.Random;
import java.util.Scanner;

import GUI.*;
import java.util.Timer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import attack.Attack;

import player.Player;
import pokemon.Pokemon;

//import javax.swing.plaf.SliderUI;

public class Fight implements KeyListener {
	private Random rand = new Random();

	protected Player player;
	protected Player enemy;
	
	protected char pressed;
	
	private char[] cButtonToPressArray;
	private char cButtonToPress = 'a';
	private int boosting = 0;
	private int boostDmg = 0;
	private int boostCnt = 0;
	private int boostAttackId;
	
	private long timer;
	private long timer2;
	private boolean timerFlag = true;

	public Fight(Player pPlayer, Player pEnemy) {
		player = pPlayer;
		enemy = pEnemy;
	}



	public int PlayerAttack(int pAttackid) {
		int iExtraDmg = 0;
		boostAttackId = pAttackid;
		Attack playerAttack = player.getPokemon().getAttackFromList(pAttackid);
		cButtonToPress = playerAttack.getKeykombo()[0];
		
		switch (pAttackid) {

		case 0:
			player.getPokemon().attack(0, enemy.getPokemon());
			break;

		case 1:
			player.getPokemon().attack(1, enemy.getPokemon());
			break;

		case 2:
			player.getPokemon().attack(2, enemy.getPokemon());
			break;

		default:
			break;
		}
		
		iExtraDmg += this.GetPlayerBoost(playerAttack);
		System.out.println(iExtraDmg);
		iExtraDmg += player.getPokemon().getDmgMulti() * 4;
		iExtraDmg += player.getPokemon().getDmgAdd();
		
		if((player.getPokemon().getPokeClass() == 1 && enemy.getPokemon().getPokeClass() == 4) ||
				(player.getPokemon().getPokeClass() == 2 && enemy.getPokemon().getPokeClass() == 1) ||
				(player.getPokemon().getPokeClass() == 3 && enemy.getPokemon().getPokeClass() == 2) ||
				(player.getPokemon().getPokeClass() == 4 && enemy.getPokemon().getPokeClass() == 3)) {
			iExtraDmg += playerAttack.getBasicdmg() / 2;
		}
		
		if(((player.getPokemon().getPokeClass() == 1 && enemy.getPokemon().getPokeClass() == 3) ||
				(player.getPokemon().getPokeClass() == 2 && enemy.getPokemon().getPokeClass() == 4) ||
				(player.getPokemon().getPokeClass() == 3 && enemy.getPokemon().getPokeClass() == 1) ||
				(player.getPokemon().getPokeClass() == 4 && enemy.getPokemon().getPokeClass() == 2)) && 
				iExtraDmg >= playerAttack.getBasicdmg() / 2) {
			iExtraDmg -= playerAttack.getBasicdmg() / 2;
		}
		
		enemy.getPokemon().dmg(iExtraDmg);
		
		if(enemy.getPokemon().getCurrentHP() <= 0) {
			enemy.getPokemon().setCurrentHP(0);
			return 0;
		}
		
		return 1;
	}

	public int EnemyAttack() {
		int iExtraDmg = 0;
		int iRandAttack = rand.nextInt(3);
		Attack enemyAttack = enemy.getPokemon().getAttackFromList(iRandAttack);
		
		enemy.getPokemon().attack(iRandAttack, player.getPokemon());
		
		iExtraDmg += this.GetEnemyBoost();
		iExtraDmg += enemy.getPokemon().getDmgAdd();
		
		if((enemy.getPokemon().getPokeClass() == 1 && player.getPokemon().getPokeClass() == 4) ||
				(enemy.getPokemon().getPokeClass() == 2 && player.getPokemon().getPokeClass() == 1) ||
				(enemy.getPokemon().getPokeClass() == 3 && player.getPokemon().getPokeClass() == 2) ||
				(enemy.getPokemon().getPokeClass() == 4 && player.getPokemon().getPokeClass() == 3)) {
			iExtraDmg += enemyAttack.getBasicdmg() / 2;
		}
		
		if(((enemy.getPokemon().getPokeClass() == 1 && player.getPokemon().getPokeClass() == 3) ||
				(enemy.getPokemon().getPokeClass() == 2 && player.getPokemon().getPokeClass() == 4) ||
				(enemy.getPokemon().getPokeClass() == 3 && player.getPokemon().getPokeClass() == 1) ||
				(enemy.getPokemon().getPokeClass() == 4 && player.getPokemon().getPokeClass() == 2)) && 
				iExtraDmg >= enemyAttack.getBasicdmg() / 2) {
			iExtraDmg -= enemyAttack.getBasicdmg() / 2;
		}
		
		player.getPokemon().dmg(iExtraDmg);
		
		if(player.getPokemon().getCurrentHP() <= 0) {
			player.getPokemon().setCurrentHP(0);
			return 0;
		}
		
		return 1;
	}
	
	private int GetPlayerBoost(Attack pAttack) {
		boostDmg = 0;
		boostCnt = 0;
		boosting = pAttack.getBoost();
		int iBoost = 0;
		
		
		timer = System.currentTimeMillis();
		
		
		while(timer + 2500 > System.currentTimeMillis());
		
		System.out.println(boostDmg);
		if(boostDmg >= 5) {
			iBoost = 3;
		}
		
		if(boostDmg >= 7) {
			iBoost = 5;
		}
		
		if(boostDmg >= 10) {
			iBoost = 7;
		}
		
		iBoost = iBoost * boosting;
		boosting = 0;
		
		return iBoost;
	}

	private int GetEnemyBoost() {
		return rand.nextInt(4);
	}


	@Override
	public void keyPressed(KeyEvent e) {
			char cInput = e.getKeyChar();

			if(cInput == cButtonToPress && boostCnt < 2) {
				boostDmg++;
				boostCnt++;
				cButtonToPress = player.getPokemon().getAttackFromList(boostAttackId).getKeykombo()[boostCnt];
			}
			
			else if(cInput == cButtonToPress && boostCnt == 2) {
				boostDmg++;
				boostCnt = 0;
				cButtonToPress = player.getPokemon().getAttackFromList(boostAttackId).getKeykombo()[boostCnt];
			}
			
			else if(cInput != cButtonToPress) {
				boostCnt = 0;
				cButtonToPress = player.getPokemon().getAttackFromList(boostAttackId).getKeykombo()[boostCnt];
			}
		
	}



	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}