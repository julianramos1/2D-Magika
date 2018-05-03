package Game.Entities.Statics;

import Game.Entities.EntityManager;
import Game.Entities.Creatures.Player;
import Game.GameStates.State;
import Game.Inventories.Inventory;
import Game.Items.Item;
import Game.Tiles.Tile;
import Main.Handler;
import Resources.Images;
import Worlds.BaseWorld;
import Worlds.CaveWorld;

import java.awt.*;

import javax.swing.JOptionPane;

/**
 * Created by Elemental on 2/2/2017.
 */


public class Chest extends StaticEntity {

    private Rectangle ir = new Rectangle();
    public Boolean EP = false;
    private Inventory inventory;
    protected EntityManager entityManager;
    private BaseWorld caveWorld;
    public boolean var = false;

    public Chest(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
        health=10000000;
        bounds.x=0;
        bounds.y=0;
        bounds.width = 100;
        bounds.height = 64;

        ir.width = bounds.width;
        ir.height = bounds.height;
        int irx=(int)(bounds.x-handler.getGameCamera().getxOffset()+x);
        int iry= (int)(bounds.y-handler.getGameCamera().getyOffset()+height);
        ir.y=iry;
        ir.x=irx;
    }

    @Override
    public void tick() {

        if(isBeinghurt()){
            setHealth(10000000);
        }
        //This is where the condition to put the door invisible should work.
        //TODO
        if(handler.getKeyManager().attbut){
            EP=true;

        }else if(!handler.getKeyManager().attbut){
            EP=false;
        }
        
        getInventory();
    }

    @Override
    public void render(Graphics g) {
        caveWorld = new CaveWorld(handler,"res/Maps/caveMap.map",handler.getWorld().getEntityManager().getPlayer());
        for (Item i : handler.getWorld().getEntityManager().getPlayer().getInventory().getInventoryItems() ) {
            if (i.getName() == "Stick" && i.getCount() >= 3) {
            	var = true;
            	//handler.getWorld().getEntityManager().addEntity(new Door(handler, 100, 0,caveWorld));
                //g.drawImage(Images.door,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);
                return;
            }
        }
    	if((handler.getKeyManager().attbut && ir.contains(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0,0)))) {
            g.drawImage(Images.chest[1],(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),100,height,null);
            JOptionPane.showMessageDialog(null, "To open the door deliver 3 sticks");
        	}
    	else {
        g.drawImage(Images.chest[0],(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),100,height,null);
        checkForPlayer(g, handler.getWorld().getEntityManager().getPlayer());
    	}
        g.setColor(Color.black);
//        checkForPlayer(g, handler.getWorld().getEntityManager().getPlayer());
    }

    private void checkForPlayer(Graphics g, Player p) {
        Rectangle pr = p.getCollisionBounds(0,0);

        if(ir.contains(pr) && !EP){
            g.drawImage(Images.E,(int) x+width,(int) y+10,32,32,null);
        }else if(ir.contains(pr) && EP){
            g.drawImage(Images.EP,(int) x+width,(int) y+10,32,32,null);

        }


    }
    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public void die() {

    }
}
