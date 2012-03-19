package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import attack.Attack;

import fight.Fight;

import player.Player;
import poke_mp3.*;
import pokemon.Bisasam;
import pokemon.Glumanda;
import pokemon.Mauzi;
import pokemon.Pikachu;
import pokemon.Schiggy;


public class MainGUI extends JFrame implements ActionListener, Runnable, MouseListener{
	private JPanel jBar, jContent, jHoleWin;
	private JButton btn1,btn2,btn3,btnAtt1, btnAtt2, btnAtt3, btn4, btn5;
	private JLabel labelText1, labelChosenPoke, labelPokeGeg,namepoke, lvl, ep, hp, nameplayer, arena,dmgDoneE, dmgDoneP, keyCombo;
	private TextField tf;
	private int selected, round;
	private Icon icon_pokeball, icon_barBack, icon_loose;
	private Icon icon_pokeball1, icon_pokeball2, icon_pokeball3, icon_pokeball4, icon_pokeball5;
	private Icon arena_blue, arena_green, arena_normal, arena_red, arena_yellow;
	private JLabel poke1,poke2, poke3, poke4, poke5,emptyL;
	private JProgressBar prog, eprog;
	private JLabel enamepoke, elvl, eep, ehp, enameplayer;
	
	private static Player player, enemy;
	private Fight fight;
	
	private Attack glut, tackle, ruckzuck, rankenhieb, aquaknarre, kratzer, donnerblitz;
	
	private String[] namelist = { "Ash", "Gary", "Red", "Wally", "Barry",
			"Lucas", "James", "Jessie", "Misty", "Brock", "Danny", "Rudy",
			"Rocko" };
	
	Random rand;
	
	MP3 soundEnterName;
	
	public MainGUI(){
		emptyL = new JLabel();
		arena = new JLabel();
		namepoke = new JLabel();
		dmgDoneE = new JLabel();
		dmgDoneP = new JLabel();		
		lvl = new JLabel();
		keyCombo = new JLabel();
		ep = new JLabel();
		hp = new JLabel();
		nameplayer = new JLabel();
		labelPokeGeg = new JLabel();
		icon_pokeball1 = new ImageIcon("img/pokeball_1.png");
		icon_pokeball2 = new ImageIcon("img/pokeball_4.png");
		icon_pokeball3 = new ImageIcon("img/pokeball_7.png");
		icon_pokeball4 = new ImageIcon("img/pokeball_25.png");
		icon_pokeball5 = new ImageIcon("img/pokeball_52.png");
		
		
		enamepoke = new JLabel();
		elvl = new JLabel();
		eep = new JLabel();
		ehp = new JLabel();
		enameplayer = new JLabel();
		
		arena_blue = new ImageIcon("img/blue_arena.png");
		arena_green = new ImageIcon("img/green_arena.png");
		arena_normal = new ImageIcon("img/normal_arena.png");
		arena_red = new ImageIcon("img/red_arena.png");
		arena_yellow = new ImageIcon("img/yellow_arena.png");
		
		round = 1;

		btn1 = new JButton();
		btn2 = new JButton();
		btn3 = new JButton();
		btnAtt1 = new JButton();
		btnAtt2 = new JButton();
		btnAtt3 = new JButton();
		btn4 = new JButton();
		btn5 = new JButton();
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btnAtt1.addActionListener(this);
		btnAtt2.addActionListener(this);
		btnAtt3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		
		icon_pokeball = new ImageIcon("img/pokeball.png");
		
		icon_barBack = new ImageIcon("img/bar.jpg");
		
		icon_loose = new ImageIcon("img/game_over.jpg");
		
		char[] att = {'a', 't', 'a'};
		char[] att1 = {'a','s','d'};
		char[] att2 = {'a','b','b'};
		char[] att3 = {'a','a','a'};
		char[] att4 = {'b','a','b'};
		char[] att5 = {'v','a','s'};
		char[] att6 = {'a','s','s'};
		
		glut = new Attack("Glut", 10, 2, 3, att);
		tackle = new Attack("Tackle", 5, 3, 0, att1); 
		ruckzuck = new Attack("Ruckzuck", 7, 1, 0, att2); 
		rankenhieb = new Attack("Rankenhieb", 10, 2, 2, att3); 
		aquaknarre = new Attack("Aquaknarre", 10, 2, 4, att4);
		kratzer = new Attack("Kratzer", 12, 1, 0, att5);
		donnerblitz = new Attack("Donnerblitz", 8, 3, 1, att6);
				
		jBar = new JPanel();
		jContent = new JPanel();
		jHoleWin = new JPanel();
		labelChosenPoke = new JLabel();
		
		getContentPane().setLayout(null);
		jHoleWin.setLayout(null);
		jContent.setLayout(null);
		jBar.setLayout(null);
		
		setTitle("Pokemon Rote Edition");
		setSize(800,600);
		getContentPane().setPreferredSize(new Dimension(800, 600));
		setVisible(true);

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		labelText1 = new JLabel();
		
		drawEnterName();
	
	}
	

	public void drawEnterName(){
		soundEnterName = new MP3(4);
		
		labelText1.setText("Bitte Name eingeben:");
		labelText1.setHorizontalAlignment(labelText1.CENTER);
		labelText1.setBounds(0,150,800,50);
		labelText1.setFont(new Font("sans-serif",Font.PLAIN,24));
		
		
		tf = new TextField("", 30);
		tf.setBounds(250, 250, 200, 20);
		
		btn1.setText("Weiter");
		btn1.setPreferredSize(new Dimension(100, 50));
		btn1.setBounds(470, 250, 80, 20);		
		getContentPane().add(btn1);
		
		jHoleWin.add(tf);
		jHoleWin.add(labelText1);
		jHoleWin.add(btn1);
		jHoleWin.setBackground(new Color(250,100,100));
		jHoleWin.setBounds(0, 0, 800, 600);
		add(jHoleWin);

		jContent.repaint();
		jBar.repaint();
		validate();
		
		soundEnterName.play();
	}
	public void drawChoosePoke(){
			remove(jContent);
			remove(jBar);
			jHoleWin.removeAll();
			labelText1.setText("Wähle dein Pokemon");
			labelText1.setBounds(0, 50, 800, 50);
			jHoleWin.add(labelText1);
			
			labelChosenPoke.setHorizontalAlignment(labelChosenPoke.CENTER);
			labelChosenPoke.setBounds(0, 270, 800, 250);
			
			jHoleWin.add(labelChosenPoke);
			
			poke1 = new JLabel();
			poke1.setIcon(icon_pokeball);
			poke1.setBounds(70, 150, 100, 100);
			jHoleWin.add(poke1);
			
			poke2 = new JLabel();
			poke2.setIcon(icon_pokeball);
			poke2.setBounds(210, 150, 100, 100);
			jHoleWin.add(poke2);
			
			poke3 = new JLabel();
			poke3.setIcon(icon_pokeball);
			poke3.setBounds(350, 150, 100, 100);
			jHoleWin.add(poke3);
			
			poke4 = new JLabel();
			poke4.setIcon(icon_pokeball);
			poke4.setBounds(490, 150, 100, 100);
			jHoleWin.add(poke4);
			
			poke5 = new JLabel();
			poke5.setIcon(icon_pokeball);
			poke5.setBounds(630, 150, 100, 100);

			poke1.addMouseListener((MouseListener) this);
			poke2.addMouseListener((MouseListener) this);
			poke3.addMouseListener((MouseListener) this);
			poke4.addMouseListener((MouseListener) this);
			poke5.addMouseListener((MouseListener) this);

			btn2.setText("Auswählen");
			btn2.setBounds(600, 460, 100, 30);
			
			jHoleWin.add(poke5);
			
			add(jHoleWin);
			jHoleWin.repaint();
	}
	public void drawBar(boolean bEnemy){
		//TODO Werte abfragen
		jBar.removeAll();
		JLabel barBack = new JLabel();
		barBack.setBounds(0, 0, 800, 70);
		barBack.setIcon(icon_barBack);
		namepoke.setText(player.getPokemon().getName());
		namepoke.setBounds(50, 25, 100, 20);
		lvl.setText("LVL: " + player.getPokemon().getLevel());
		lvl.setBounds(50, 45, 50, 20);
		ep.setText("EP: " + player.getPokemon().getCurrentEp());
		ep.setHorizontalAlignment(ep.CENTER);
		ep.setBounds(150, 40, 100, 20);
		hp.setText(player.getPokemon().getCurrentHP() + "/" + player.getPokemon().getMaxHP());
		hp.setHorizontalAlignment(hp.CENTER);
		hp.setBounds(150, 10, 100, 20);
		nameplayer.setText(player.getName());
		nameplayer.setBounds(50, 5, 100, 20);
		
		prog = new JProgressBar(0, player.getPokemon().getMaxHP());
		prog.setValue(player.getPokemon().getCurrentHP());
		prog.setBounds(150, 10, 100, 20);
		
		jBar.add(namepoke);
		jBar.add(lvl);
		jBar.add(ep);
		jBar.add(hp);
		jBar.add(nameplayer);
		jBar.add(prog);
		
		if(bEnemy) {
	
			enamepoke.setText(enemy.getPokemon().getName());
			enamepoke.setBounds(450, 25, 100, 20);
			elvl.setText("LVL: " + enemy.getPokemon().getLevel());
			elvl.setBounds(450, 45, 50, 20);
			eep.setText("EP: " + enemy.getPokemon().getCurrentEp());
			eep.setHorizontalAlignment(eep.CENTER);
			eep.setBounds(550, 40, 100, 20);
			ehp.setText(enemy.getPokemon().getCurrentHP() + "/" + enemy.getPokemon().getMaxHP());
			ehp.setHorizontalAlignment(ehp.CENTER);
			ehp.setBounds(550, 10, 100, 20);
			enameplayer.setText(enemy.getName());
			enameplayer.setBounds(450, 5, 100, 20);

			eprog = new JProgressBar(0, enemy.getPokemon().getMaxHP());
			eprog.setValue(enemy.getPokemon().getCurrentHP());
			eprog.setBounds(550, 10, 100, 20);
			
			jBar.add(enamepoke);
			jBar.add(elvl);
			jBar.add(eep);
			jBar.add(ehp);
			jBar.add(enameplayer);
			jBar.add(eprog);
		}
		jBar.setBounds(0, 0, 800, 70);
		jBar.add(barBack);
		
		jBar.repaint();
		

	}
	public void drawFight(){
		remove(jHoleWin);
		jContent.removeAll();
		drawBar(true);
		
		btnAtt1.setText(player.getPokemon().getAttackFromList(0).getName());
		btnAtt1.setBounds(40, 457, 100, 20);		


		btnAtt2.setText(player.getPokemon().getAttackFromList(1).getName());
		btnAtt2.setBounds(160, 465, 100, 20);
		
		btnAtt3.setText(player.getPokemon().getAttackFromList(2).getName());
		btnAtt3.setBounds(280, 457, 100, 20);
		
		btn4.setText("Flucht");
		btn4.setBounds(690, 465, 80, 20);
		
		dmgDoneE.setBounds(100,50,150,50);
		dmgDoneE.setFont(new Font("sans serif",Font.BOLD,25));
		dmgDoneE.setForeground(new Color(255,100,100));
		dmgDoneE.setText("");
		
		dmgDoneP.setBounds(600,350,150,50);
		dmgDoneP.setFont(new Font("sans serif",Font.BOLD,25));
		dmgDoneP.setText("");
		
		keyCombo.setBounds(220, 150, 200, 40);
		keyCombo.setFont(new Font("sans serif",Font.BOLD,20));
		
		labelChosenPoke.setIcon(player.getPokemon().getPImage());
		labelChosenPoke.setBounds(90, 170, 270, 300);
		
		emptyL.setBounds(0, 0, 800, 530);
		jContent.add(emptyL);
		// 0=normal, 1=blitz, 2 blatt, 3 feuer, 4 wasser
		
		switch(enemy.getPokemon().getPokeClass()){
			case 0:
				arena.setIcon(arena_normal);
				break;
			case 1:
				arena.setIcon(arena_yellow);
				break;
			case 2:
				arena.setIcon(arena_green);
				break;
			case 3:
				arena.setIcon(arena_red);
				break;
			case 4:
				arena.setIcon(arena_blue);
				break;
		}
		
		labelPokeGeg.setIcon(enemy.getPokemon().getEImage());
		labelPokeGeg.setBounds(500, 0, 270, 300);
		
		jContent.add(labelChosenPoke);
		jContent.add(labelPokeGeg);
		
		arena.setBounds(0, 0, 800, 530);
		jContent.add(keyCombo);
		jContent.add(dmgDoneE);
		jContent.add(dmgDoneP);
		jContent.add(btnAtt1);
		jContent.add(btnAtt2);
		jContent.add(btnAtt3);
		jContent.add(btn4);
		jContent.add(arena);
		
		jContent.setBounds(0, 70, 800, 530);
			
		add(jContent);
		add(jBar);
		
		jContent.repaint();
		jBar.repaint();
		validate();
	}
	public void drawStopScreen(){
		remove(jHoleWin);
		jContent.removeAll();
		drawBar(false);		
		
		labelText1.setText("Runde "+round);
		labelText1.setBounds(500, 100, 100, 50);
		
		jContent.add(labelText1);

		
		btn3.setText("Runde starten");
		btn3.setBounds(600, 400, 150, 30);
		
		jContent.add(btn3);

		labelChosenPoke.setBounds(150, 100, 270, 300);
		jContent.add(labelChosenPoke);
		
		jContent.setBounds(0, 70, 800, 530);
		jContent.setBackground(new Color(100,200,100));
			
		add(jContent);
		add(jBar);
		
		jContent.repaint();
		jBar.repaint();
		
		validate();
	}
	
	public void drawWin()
	{
		JLabel text1 = new JLabel();
		JLabel text2 = new JLabel();
		
		int EP = player.getPokemon().getLevel() * 4;
		int retLvl = player.getPokemon().increaseEP(EP);
		
		if(retLvl==1)
			drawEvo();
		
		
		jContent.removeAll();
		drawBar(true);		
		
		labelText1.setText("You Win!");
		labelText1.setBounds(500, 100, 100, 50);
		
		text1.setText("Du erh�ltst: " + EP +"EP");
		text1.setBounds(500, 150, 150, 20);
		
		if(retLvl == 2){
			text2.setText("Du steigst um 1 lvl auf!");
			text2.setBounds(500, 170, 150, 20);
		}
		
		jContent.add(labelText1);
		jContent.add(text1);
		jContent.add(text2);
		
		btn5.setText("Weiter");
		btn5.setBounds(600, 400, 150, 30);
		
		jContent.add(btn5);

		labelChosenPoke.setBounds(150, 100, 270, 300);
		jContent.add(labelChosenPoke);
		
		jContent.setBounds(0, 70, 800, 530);
		jContent.setBackground(new Color(100,200,100));
			
		add(jContent);
		add(jBar);
		
		jContent.repaint();
		jBar.repaint();
		
		validate();
	}
	public void drawLoose()
	{
		remove(jContent);
		remove(jBar);
		jHoleWin.removeAll();

		JLabel looseBack = new JLabel();
		looseBack.setIcon(icon_loose);
		looseBack.setBounds(-5, 0, 800, 600);
		
		jHoleWin.add(looseBack);
		add(jHoleWin);
		jHoleWin.repaint();
		repaint();
		validate();
		
	}
	public void drawEvo(){
		new Thread(){
			public void run()
			{

				Icon buffer = new ImageIcon();
				buffer = labelChosenPoke.getIcon();
				
					remove(jHoleWin);
					jContent.removeAll();
					drawBar(false);		
					
					labelText1.setText("Evolution");
					labelText1.setBounds(500, 100, 100, 50);
					
					jContent.add(labelText1);					
			
					labelChosenPoke.setBounds(150, 100, 270, 300);
					jContent.add(labelChosenPoke);
					
					jContent.setBounds(0, 70, 800, 530);
					jContent.setBackground(new Color(100,200,100));
						
					add(jContent);
					add(jBar);
					
					jContent.repaint();
					jBar.repaint();		
					for(int i=50; i<=350;i+=50){
					try {
						Thread.sleep(i);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					labelChosenPoke.setIcon(player.getPokemon().getPImage());
					jContent.repaint();
					try {
						Thread.sleep(i);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					labelChosenPoke.setIcon(buffer);
					jContent.repaint();
					}
					
					labelChosenPoke.setIcon(buffer);
					jContent.repaint();
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					labelChosenPoke.setIcon(player.getPokemon().getPImage());
					jContent.repaint();
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					drawStopScreen();
					
					validate();
				}
			}.start();
			

		
	}
	
	public void animate(String atts){
		if(atts.equals("Aquaknarre")){
		new Thread(){
			public void run(){
					int x = labelChosenPoke.getX();
					int y = labelChosenPoke.getY();
					
					
					ImageIcon att = new ImageIcon("img/aquaknarre.png");
					JLabel attimg = new JLabel();
					int attind;
					
					labelChosenPoke.setLocation(x+20, y);
					jContent.repaint();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//JOptionPane.showMessageDialog(this,"hallo");
					labelChosenPoke.setLocation(x+40, y);
					jContent.repaint();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//JOptionPane.showMessageDialog(this,"hallo");
					labelChosenPoke.setLocation(x+60, y);
					jContent.repaint();
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
										
					attimg.setIcon(att);
					attimg.setBounds(70, 150, 100, 100);
					emptyL.add(attimg);
					
					
					for(attind=0;attind<23;attind++){
						attimg.setLocation(x+attind*20, y+125-(attind*13));
						jContent.repaint();
						try {
							Thread.sleep(15);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					emptyL.removeAll();
					jContent.repaint();
					
					labelChosenPoke.setLocation(x, y);				
					
					validate();
			}
		}.start();
		}
		if(atts.equals("Glut")){
			new Thread(){
				public void run(){
						int x = labelChosenPoke.getX();
						int y = labelChosenPoke.getY();
						
						
						ImageIcon att = new ImageIcon("img/glut.gif");
						JLabel attimg = new JLabel();
						int attind;
						
						labelChosenPoke.setLocation(x+20, y);
						jContent.repaint();
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//JOptionPane.showMessageDialog(this,"hallo");
						labelChosenPoke.setLocation(x+40, y);
						jContent.repaint();
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//JOptionPane.showMessageDialog(this,"hallo");
						labelChosenPoke.setLocation(x+60, y);
						jContent.repaint();
						try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
											
						attimg.setIcon(att);
						attimg.setBounds(70, 150, 100, 100);
						emptyL.add(attimg);
						
						
						for(attind=0;attind<23;attind++){
							attimg.setLocation(x+attind*20, y+125-(attind*13));
							jContent.repaint();
							try {
								Thread.sleep(15);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
						labelChosenPoke.setLocation(x, y);	
						
						int xa = labelPokeGeg.getX();
						int ya = labelPokeGeg.getY();
						
						attimg.setIcon(att);
						attimg.setBounds(700, 30, 100, 100);
						emptyL.add(attimg);
						
						validate();
						for(attind=0;attind<15;attind++){
							attimg.setLocation(740, ya);
							emptyL.repaint();
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							attimg.setLocation(650, ya);
							emptyL.repaint();
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								
							}
							emptyL.removeAll();
						}
						
						
				}
			}.start();
			}
		if(atts.equals("Rankenhieb")){
			new Thread(){
				public void run(){
						int x = labelChosenPoke.getX();
						int y = labelChosenPoke.getY();
						
						
						ImageIcon att = new ImageIcon("img/Ruten.png");
						JLabel attimg = new JLabel();
						int attind;
						
						labelChosenPoke.setLocation(x+20, y);
						jContent.repaint();
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//JOptionPane.showMessageDialog(this,"hallo");
						labelChosenPoke.setLocation(x+40, y);
						jContent.repaint();
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//JOptionPane.showMessageDialog(this,"hallo");
						labelChosenPoke.setLocation(x+60, y);
						jContent.repaint();
						try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
											
						attimg.setIcon(att);
						attimg.setBounds(70, 150, 100, 100);
						emptyL.add(attimg);
						
						
						for(attind=0;attind<23;attind++){
							attimg.setLocation(x+attind*20, y+125-(attind*13));
							jContent.repaint();
							try {
								Thread.sleep(15);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
						labelChosenPoke.setLocation(x, y);	
						
						int xa = labelPokeGeg.getX();
						int ya = labelPokeGeg.getY();
						
						attimg.setIcon(att);
						attimg.setBounds(700, 30, 100, 100);
						emptyL.add(attimg);
						
						validate();
						for(attind=0;attind<15;attind++){
							attimg.setLocation(740, ya);
							emptyL.repaint();
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							attimg.setLocation(650, ya);
							emptyL.repaint();
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								
							}
							emptyL.removeAll();
						}
						
						validate();
				}
			}.start();
			}
		if(atts.equals("Kratzer")){
			new Thread(){
				public void run(){
						int x = labelChosenPoke.getX();
						int y = labelChosenPoke.getY();
						
						
						
						
						ImageIcon att = new ImageIcon("img/kratzer.png");
						JLabel attimg = new JLabel();
						int attind;
						
						labelChosenPoke.setLocation(x+20, y);
						jContent.repaint();
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//JOptionPane.showMessageDialog(this,"hallo");
						labelChosenPoke.setLocation(x+40, y);
						jContent.repaint();
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//JOptionPane.showMessageDialog(this,"hallo");
						labelChosenPoke.setLocation(x+60, y);
						jContent.repaint();
						try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
											
						attimg.setIcon(att);
						attimg.setBounds(70, 150, 100, 100);
						emptyL.add(attimg);
						
						int xa = labelPokeGeg.getX();
						int ya = labelPokeGeg.getY();
						
						
						for(attind=0;attind<20;attind++){
							attimg.setLocation(xa+100-(attind*10), ya-50+(attind*10));
							jContent.repaint();
							try {
								Thread.sleep(20);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
						labelChosenPoke.setLocation(x, y);			
						emptyL.removeAll();
						jContent.repaint();
						
						validate();
				}
			}.start();
			}
		if(atts.equals("Donnerblitz")){
			new Thread(){
				public void run(){
						int x = labelChosenPoke.getX();
						int y = labelChosenPoke.getY();
						
						
						ImageIcon att = new ImageIcon("img/blitz.gif");
						JLabel attimg = new JLabel();
						int attind;
						
						labelChosenPoke.setLocation(x+20, y);
						jContent.repaint();
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//JOptionPane.showMessageDialog(this,"hallo");
						labelChosenPoke.setLocation(x+40, y);
						jContent.repaint();
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//JOptionPane.showMessageDialog(this,"hallo");
						labelChosenPoke.setLocation(x+60, y);
						jContent.repaint();
						try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
											
						attimg.setIcon(att);
						attimg.setBounds(70, 150, 100, 100);
						emptyL.add(attimg);
						
						
						for(attind=0;attind<23;attind++){
							attimg.setLocation(x+attind*20, y+125-(attind*13));
							jContent.repaint();
							try {
								Thread.sleep(15);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
						labelChosenPoke.setLocation(x, y);	
						
						ImageIcon att2 = new ImageIcon("img/Blitz2.png");
						
						int xa = labelPokeGeg.getX();
						int ya = labelPokeGeg.getY();
						
						attimg.setIcon(att2);
						attimg.setBounds(70, 150, 100, 100);
						emptyL.add(attimg);
						
						for(attind=0;attind<20;attind++){
							attimg.setLocation(xa+20, -10+attind*10);
							jContent.repaint();
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						emptyL.removeAll();
						jContent.repaint();
						
						validate();
				}
			}.start();
			}
		if(atts.equals("Ruckzuck")){
			new Thread(){
				public void run(){
						int x = labelPokeGeg.getX();
						int y = labelPokeGeg.getY();
						int xi = labelChosenPoke.getX();
						int yi = labelChosenPoke.getY();
						
						labelChosenPoke.setLocation(xi+40, yi);
						jContent.repaint();
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
												
						for(int gein=0; gein<6;gein++){
							labelPokeGeg.setLocation(x+20, y);
							jContent.repaint();
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							labelPokeGeg.setLocation(x-20, y);
							jContent.repaint();
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						labelChosenPoke.setLocation(xi, yi);				
						
						validate();
				}
			}.start();
		}
		
		if(atts.equals("Tackle")){
			new Thread(){
				public void run(){
					int x = labelChosenPoke.getX();
					int y = labelChosenPoke.getY();
					
					
					ImageIcon att = new ImageIcon("img/tackle.png");
					JLabel attimg = new JLabel();
					int attind;
					
					labelChosenPoke.setLocation(x+20, y);
					jContent.repaint();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//JOptionPane.showMessageDialog(this,"hallo");
					labelChosenPoke.setLocation(x+40, y);
					jContent.repaint();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//JOptionPane.showMessageDialog(this,"hallo");
					labelChosenPoke.setLocation(x+60, y);
					jContent.repaint();
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
										
					attimg.setIcon(att);
					attimg.setBounds(70, 150, 200, 200);
					emptyL.add(attimg);
					
					
					for(attind=0;attind<23;attind++){
						attimg.setLocation(x+attind*20, y+125-(attind*13));
						jContent.repaint();
						try {
							Thread.sleep(15);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					labelChosenPoke.setLocation(x, y);	
					emptyL.removeAll();
					jContent.repaint();
					
					validate();
				}
			}.start();
		}
	}
	
	public void poke_select_sound(final int poke_sound_index){

		new Thread() {
		public void run(){
		MP3 poke1_sound = new MP3(poke_sound_index); //mod Jan
		poke1_sound.play();
		try {
		Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		poke1_sound.close();
		}
		}.start();
		try {
		Thread.currentThread().sleep(500);
		} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		soundEnterName.close();
		soundEnterName.play();
		}
	
	public void run() {
		// TODO Auto-generated method stub
	}
	public static void main(String[] args) {
		new Thread(new MainGUI()).start();	
		
		player = new Player();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== btn1){
			player.setName(tf.getText());
			drawChoosePoke();
		}
		else if(e.getSource()== btn2){
			switch(selected){
			case 1:
				player.setPokemon(new Bisasam(50));
				player.getPokemon().learn(rankenhieb);
				break;
			case 2:
				player.setPokemon(new Glumanda(50));
				player.getPokemon().learn(glut);
				break;
			case 3:
				player.setPokemon(new Schiggy(50));
				player.getPokemon().learn(aquaknarre);
				break;
			case 4:
				player.setPokemon(new Pikachu(50));
				player.getPokemon().learn(donnerblitz);
				break;
			case 5:
				player.setPokemon(new Mauzi(50));
				player.getPokemon().learn(kratzer);
				break;
			}
			
			player.getPokemon().learn(ruckzuck);
			player.getPokemon().learn(tackle);
			drawStopScreen();
		}
		else if(e.getSource()== btn3){
			rand = new Random();
			enemy = new Player();
			int iRand = rand.nextInt(namelist.length);
			enemy.setName(namelist[iRand]);
			iRand = rand.nextInt(5);
			int iRand2 = rand.nextInt(20);
			
			switch (iRand) {
			case 0:	
				enemy.setPokemon(new Glumanda(player.getPokemon().getLevel() * 4 + iRand2));
				enemy.getPokemon().learn(glut);
				break;
			case 1:
				enemy.setPokemon(new Schiggy(player.getPokemon().getLevel() * 4 + iRand2));
				enemy.getPokemon().learn(aquaknarre);
				break;
			case 2:
				enemy.setPokemon(new Bisasam(player.getPokemon().getLevel() * 4 + iRand2));
				enemy.getPokemon().learn(rankenhieb);
				break;
			case 3:
				enemy.setPokemon(new Pikachu(player.getPokemon().getLevel() * 4 + iRand2));
				enemy.getPokemon().learn(donnerblitz);
				break;
			case 4:
				enemy.setPokemon(new Mauzi(player.getPokemon().getLevel() * 4 + iRand2));
				enemy.getPokemon().learn(kratzer);
				break;
				
			default:
				break;
			}
			
			enemy.getPokemon().learn(ruckzuck);
			enemy.getPokemon().learn(tackle);
			
			fight = new Fight(player, enemy);
			
			drawFight();
			round++;
		}
		else if(e.getSource()== btn4){
			/*
			drawStopScreen();
			round--;*/
			if(player.getPokemon().increaseEP(1300)==1)
				drawEvo();
			
//			drawFight();
			else drawStopScreen();
			round--;
		}
		else if(e.getSource()== btnAtt1){
			btnAtt1.addKeyListener(fight);
			btnAtt1.requestFocusInWindow();
			keyCombo.setText("Combo: "+player.getPokemon().getAttackFromList(0).getKeykombo()[0] + " + " 
					+ player.getPokemon().getAttackFromList(0).getKeykombo()[1] + " + " 
					+ player.getPokemon().getAttackFromList(0).getKeykombo()[2]);
			
			new Thread() {
				public void run() {
					animate(btnAtt1.getText());
				}
			}.start();
			
			new Thread() {
				public void run() {
					int dmgE,dmgP;
					dmgE = player.getPokemon().getCurrentHP();
					dmgP = enemy.getPokemon().getCurrentHP();
					if (fight.PlayerAttack(0) == 0)
						drawWin();
					else {
						drawBar(true);
						dmgP -= enemy.getPokemon().getCurrentHP();
						
						Integer iDmgP = new Integer(dmgP);
						dmgDoneP.setText(iDmgP.toString());
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							//continue
						}
						
						if (fight.EnemyAttack() == 0)
							drawLoose();
						else
							drawBar(true);
					}

					dmgE -= player.getPokemon().getCurrentHP();
					

					Integer iDmgE = new Integer(dmgE);
					
					dmgDoneE.setText(iDmgE.toString());
					keyCombo.setText("");
					
				}
			}.start();
			
			
			
			new Thread() {
				public void run() {
					long timer = System.currentTimeMillis();
					while (timer + 2500 > System.currentTimeMillis())
						;
					btnAtt1.removeKeyListener(fight);
				}
			}.start();
		}
		else if(e.getSource()== btnAtt2){
			btnAtt2.addKeyListener(fight);
			btnAtt2.requestFocusInWindow();
			keyCombo.setText("Combo: "+player.getPokemon().getAttackFromList(1).getKeykombo()[0] + " + " 
					+ player.getPokemon().getAttackFromList(1).getKeykombo()[1] + " + " 
					+ player.getPokemon().getAttackFromList(1).getKeykombo()[2]);
			
			new Thread() {
				public void run() {
					animate(btnAtt2.getText());
				}
			}.start();
			
			new Thread() {
				public void run() {
					int dmgE,dmgP;
					dmgE = player.getPokemon().getCurrentHP();
					dmgP = enemy.getPokemon().getCurrentHP();
					
					if (fight.PlayerAttack(1) == 0)
						drawWin();
					else {
						drawBar(true);
						dmgP -= enemy.getPokemon().getCurrentHP();
						
						Integer iDmgP = new Integer(dmgP);
						dmgDoneP.setText(iDmgP.toString());
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							//continue
						}
						if (fight.EnemyAttack() == 0)
							drawLoose();
						else
							drawBar(true);
					}
					
					dmgE -= player.getPokemon().getCurrentHP();
					

					Integer iDmgE = new Integer(dmgE);
					
					dmgDoneE.setText(iDmgE.toString());
					keyCombo.setText("");
				}
			}.start();
			
			
			
			new Thread() {
				public void run() {
					long timer = System.currentTimeMillis();
					while (timer + 2500 > System.currentTimeMillis())
						;
					btnAtt2.removeKeyListener(fight);
				}
			}.start();
		}
		else if(e.getSource()== btnAtt3){
			btnAtt3.addKeyListener(fight);
			btnAtt3.requestFocusInWindow();
			keyCombo.setText("Combo: "+player.getPokemon().getAttackFromList(2).getKeykombo()[0] + " + " 
					+ player.getPokemon().getAttackFromList(2).getKeykombo()[1] + " + " 
					+ player.getPokemon().getAttackFromList(2).getKeykombo()[2]);
			
			new Thread() {
				public void run() {
					animate(btnAtt3.getText());
				}
			}.start();

			new Thread() {
				public void run() {
					int dmgE,dmgP;
					dmgE = player.getPokemon().getCurrentHP();
					dmgP = enemy.getPokemon().getCurrentHP();
					
					if (fight.PlayerAttack(2) == 0)
						drawWin();
					else {
							drawBar(true);
							dmgP -= enemy.getPokemon().getCurrentHP();
							
							Integer iDmgP = new Integer(dmgP);
							dmgDoneP.setText(iDmgP.toString());
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								//continue
							}
						if (fight.EnemyAttack() == 0)
							drawLoose();
						else
							drawBar(true);
					}
					dmgE -= player.getPokemon().getCurrentHP();
					

					Integer iDmgE = new Integer(dmgE);
					
					dmgDoneE.setText(iDmgE.toString());
					keyCombo.setText("");
				}
			}.start();
			
			
			new Thread() {
				public void run() {
					long timer = System.currentTimeMillis();
					while (timer + 2500 > System.currentTimeMillis())
						;
					btnAtt3.removeKeyListener(fight);
				}
			}.start();
		}
		else if(e.getSource()== btn5){
			drawStopScreen();
		}
	}
	/*
	public void animate(int player) throws InterruptedException{
		int x = labelChosenPoke.getX();
		int y = labelChosenPoke.getY();
		
		labelChosenPoke.setLocation(x+20, y);
		jContent.repaint();
		Thread.sleep(100);
		labelChosenPoke.setLocation(x+40, y);
		jContent.repaint();
		Thread.sleep(100);
		labelChosenPoke.setLocation(x+60, y);
		jContent.repaint();
		Thread.sleep(100);
		
		validate();
	}*/
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

		if(arg0.getComponent()==poke1)
		{
			poke1.setBounds(45, 100, 150, 150);
			poke1.setIcon(icon_pokeball1);
		}
		else if(arg0.getComponent()==poke2)
		{
			poke2.setBounds(185, 100, 150, 150);
			poke2.setIcon(icon_pokeball2);
		}
		else if(arg0.getComponent()==poke3)
		{
			poke3.setBounds(325, 100, 150, 150);
			poke3.setIcon(icon_pokeball3);
		}
		else if(arg0.getComponent()==poke4)
		{
			poke4.setBounds(465, 100,150, 150);
			poke4.setIcon(icon_pokeball4);
		}
		else if(arg0.getComponent()==poke5)
		{

			poke5.setBounds(615, 100, 150, 150);
			poke5.setIcon(icon_pokeball5);
		}
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getComponent()==poke1)
		{
			poke1.setBounds(70, 150, 100, 100);
			poke1.setIcon(icon_pokeball);
		}
		if(arg0.getComponent()==poke2)
		{
			poke2.setBounds(210, 150, 100, 100);
			poke2.setIcon(icon_pokeball);
		}
		if(arg0.getComponent()==poke3)
		{
			poke3.setBounds(350, 150, 100, 100);
			poke3.setIcon(icon_pokeball);
		}
		if(arg0.getComponent()==poke4)
		{
			poke4.setBounds(490, 150, 100, 100);
			poke4.setIcon(icon_pokeball);
		}
		if(arg0.getComponent()==poke5)
		{
			poke5.setBounds(630, 150, 100, 100);
			poke5.setIcon(icon_pokeball);
		}
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getComponent()==poke1)
		{
			selected = 1;
			labelChosenPoke.setIcon(new Bisasam(20).getPImage());
			poke_select_sound(5);
			jHoleWin.add(btn2);
		}
		if(arg0.getComponent()==poke2)
		{
			selected = 2;
			labelChosenPoke.setIcon(new Glumanda(20).getPImage());
			poke_select_sound(6);
			jHoleWin.add(btn2);
		}
		if(arg0.getComponent()==poke3)
		{
			selected = 3;
			labelChosenPoke.setIcon(new Schiggy(20).getPImage());
			poke_select_sound(7);
			jHoleWin.add(btn2);
		}
		if(arg0.getComponent()==poke4)
		{
			selected = 4;
			labelChosenPoke.setIcon(new Pikachu(20).getPImage());
			poke_select_sound(8);
			jHoleWin.add(btn2);
		}
		if(arg0.getComponent()==poke5)
		{
			selected = 5;
			labelChosenPoke.setIcon(new Mauzi(20).getPImage());
			poke_select_sound(9);
			jHoleWin.add(btn2);
		}
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
