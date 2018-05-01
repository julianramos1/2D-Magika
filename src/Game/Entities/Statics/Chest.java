package Game.Entities.Statics;

import Game.Entities.Creatures.Player;
import Game.Items.Item;
import Game.Tiles.Tile;
import Resources.Images;
import Main.Handler;

import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Elemental on 1/2/2017.
 */
public class Chest extends StaticEntity {

    private File audioFile;
    private AudioInputStream audioStream;
    private AudioFormat format;
    private DataLine.Info info;
    private Clip audioClip;
    private Rectangle ir = new Rectangle();
    public Boolean EP = false;
    protected float xMove, yMove;

    public Chest(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);

        bounds.x=0;
        bounds.y=0;
        bounds.width = 64;
        bounds.height = 64;
        health=10000000;
        
        ir.width = bounds.width;
        ir.height = bounds.height;
        int irx=(int)(bounds.x-handler.getGameCamera().getxOffset()+x);
        int iry= (int)(bounds.y-handler.getGameCamera().getyOffset()+height);
        ir.y=iry;
        ir.x=irx;

        try {
            audioFile = new File("res/music/Pickaxe.wav");
            audioStream = AudioSystem.getAudioInputStream(audioFile);
            format = audioStream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.open(audioStream);



        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void tick() {
        if(isBeinghurt()){
           // audioClip.start();
            setHealth(10000000);
        }
        if(handler.getKeyManager().attbut){
            EP=true;

        }else if(!handler.getKeyManager().attbut){
            EP=false;
        }

    }

    @Override
    public void render(Graphics g) {
    	if(handler.getKeyManager().attbut) {
            g.drawImage(Images.chest[1],(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);
        	}
    	else {
        g.drawImage(Images.chest[0],(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);
    	}
        checkForPlayer(g, handler.getWorld().getEntityManager().getPlayer());
    }
    
    private void checkForPlayer(Graphics g, Player p) {
        Rectangle pr = p.getCollisionBounds(0,0);

        if(ir.contains(pr) && !EP){
            g.drawImage(Images.E,(int) x+width,(int) y+10,32,32,null);
        }else if(ir.contains(pr) && EP){
            g.drawImage(Images.EP,(int) x+width,(int) y+10,32,32,null);
            g.drawImage(Images.loading,0,0,800,600,null);

        }
    }
        



    @Override
    public void die() {

    }
}
