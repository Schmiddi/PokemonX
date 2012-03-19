package poke_mp3;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javazoom.jl.player.Player;


public class MP3 {
    private String filename;
    private Player player; 
    String[] poke_sound_array = new String[9];
    
    
    
    // constructor that takes the name of an MP3 file
    public MP3(int auswahl) {
        poke_sound_array[0]="src/poke_mp3/1.mp3";
        poke_sound_array[1]="src/poke_mp3/2.mp3";
        poke_sound_array[2]="src/poke_mp3/3.mp3";
        poke_sound_array[3]="src/poke_mp3/4.mp3";
        poke_sound_array[4]="src/poke_mp3/bisasam.mp3";
        poke_sound_array[5]="src/poke_mp3/glumanda.mp3";
        poke_sound_array[6]="src/poke_mp3/shiggy.mp3";
        poke_sound_array[7]="src/poke_mp3/pikachu.mp3";
        poke_sound_array[8]="src/poke_mp3/mauzi.mp3";
       
    	switch (auswahl) {
		case 1:
			this.filename = poke_sound_array[0];
			break;
		case 2:
			this.filename = poke_sound_array[1];
			break;
		case 3:
			this.filename = poke_sound_array[2];
			break;
		case 4:
			this.filename = poke_sound_array[3];
			break;
		case 5:
			this.filename = poke_sound_array[4];
			break;
		case 6:
			this.filename = poke_sound_array[5];
			break;
		case 7:
			this.filename = poke_sound_array[6];
			break;
		case 8:
			this.filename = poke_sound_array[7];
			break;
		case 9:
			this.filename = poke_sound_array[8];
			break;
		default:
			break;
		}
        
    }

    public void close() { if (player != null) player.close(); }

    // play the MP3 file to the sound card
    public void play() {
        try {
            FileInputStream fis     = new FileInputStream(filename);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new Player(bis);
        }
        catch (Exception e) {
            System.out.println("Problem playing file " + filename);
            System.out.println(e);
        }

        // run in new thread to play in background
        new Thread() {
            public void run() {
                try { player.play(); }
                catch (Exception e) { System.out.println(e); }
            }
        }.start();

   

    }


}

