package Game.Entities.Statics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import Game.Entities.EntityManager;
import Game.Entities.Creatures.Player;
import Game.Inventories.Inventory;
import Game.Items.Item;
import Game.SpellCast.SpellCastUI;
import Game.Tiles.Tile;
import Main.Handler;
import Resources.Images;
import Worlds.BaseWorld;
import Worlds.CaveWorld;
import Worlds.World1;

import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Created by Elemental on 2/2/2017.
 */


public class CaveChest extends Chest {

	private SpellCastUI chestGUI;

	public Rectangle ir = new Rectangle();
	public Boolean EP = false;
	protected EntityManager entityManager;
	private BaseWorld caveWorld;
	public boolean isOpen = false;
	private boolean healthPowerUp;
	private int slime = 1;
	private int rocks = 10;

	public CaveChest(Handler handler, float x, float y) {
		super(handler, x, y);
		health=10000000;
		bounds.x=0;
		bounds.y=0;
		bounds.width = 68;
		bounds.height = 64;

		ir.width = bounds.width;
		ir.height = bounds.height;
		int irx=(int)(bounds.x-handler.getGameCamera().getxOffset()+x);
		int iry= (int)(bounds.y-handler.getGameCamera().getyOffset()+height);
		ir.y=iry;
		ir.x=irx;

		chestGUI= new SpellCastUI(handler);
	}


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
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_X)){
			handler.getWorld().getEntityManager().getChest().getChestInventory().setActive(false);
		}
		if(handler.getKeyManager().attbut && ir.contains(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0,0))) {
			for (Item i : handler.getWorld().getEntityManager().getPlayer().getInventory().getInventoryItems() ) {
				if (i.getName() == "Rock" && i.getCount() >= 1) {
					for (int j = 0; j <= i.getCount(); j++) {
						if (rocks > 0) {
							caveChestInventory.addItem(Item.rockItem);
							i.setCount(i.getCount() - 1);
							rocks --;
							System.out.println("Added rock to chest");
						}
					}

				}
			}
			for (Item j : handler.getWorld().getEntityManager().getPlayer().getInventory().getInventoryItems() ) {
				if (j.getName() == "Slime" && j.getCount() == 1) {
					if (slime > 0) {
						caveChestInventory.addItem(Item.slime);
						slime--;
						System.out.println("Added slime to chest");
						j.setCount(j.getCount() - 1);
					}
				}
			}
		}
		caveChestInventory.tick();
		if(rocks == 0 && healthPowerUp == false) {
			handler.getWorld().getEntityManager().getPlayer().setHealth(handler.getWorld().getEntityManager().getPlayer().getHealth()+20);
			healthPowerUp = true;
		}
	}

	@Override
	public void render(Graphics g) {

		caveWorld = new CaveWorld(handler,"res/Maps/caveMap.map",handler.getWorld().getEntityManager().getPlayer(), handler.getWorld().getEntityManager().getChest());

		if(handler.getKeyManager().attbut && ir.contains(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0,0)) || isOpen == true) {
			isOpen = true;
			g.drawImage(Images.chest[1],(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);
			g.drawImage(Images.caveWorldQuest,(int)((x+70)-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);
		}

		else {
			g.drawImage(Images.chest[0],(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);
		}
		if(isOpen == true){
			update(g, "Slime");
			update(g, "Rocks");
		}


		g.setColor(Color.black);
		checkForPlayer(g, handler.getWorld().getEntityManager().getPlayer());
		
	}

	private void checkForPlayer(Graphics g, Player p) {
		Rectangle pr = p.getCollisionBounds(0,0);

		if(ir.contains(pr) && !EP){
			g.drawImage(Images.E,(int) x+width,(int) y+10,32,32,null);
		}else if(ir.contains(pr) && EP){
			g.drawImage(Images.EP,(int) x+width,(int) y+10,32,32,null);

		}


	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	@Override
	public void die() {
		// Without this, the class blows up

	}

	public Inventory getCaveChestInventory() {
		return caveChestInventory;
	}

	public void update(Graphics g, String object ) {
		g.setColor(Color.black);
		tick();
		if (object.equals("Slime")) {
			g.drawString("" + slime,(int) ((x+110)-handler.getGameCamera().getxOffset()),(int) (y-handler.getGameCamera().getyOffset()+21));
		}
		else if(object.equals("Rocks")) {
			g.drawString("" + rocks,(int) ((x+110)-handler.getGameCamera().getxOffset()),(int) (y-handler.getGameCamera().getyOffset()+51));
		}
	}
}
