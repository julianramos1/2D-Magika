package Worlds;

import Game.Entities.Creatures.Player;
import Game.Entities.Creatures.SkelyEnemy;
import Game.Entities.Creatures.Zombie;
import Game.Entities.Statics.*;
import Game.Inventories.Inventory;
import Game.Items.Item;
import Main.Handler;
import sun.management.counter.Variability;

/**
 * Created by Elemental on 1/2/2017.
 */
public class World1 extends BaseWorld{

    private Handler handler;
    private BaseWorld caveWorld;
    private Chest caveChest;

    public World1(Handler handler, String path, Player player, Chest chest){
        super(handler,path,player,chest);
        this.handler = handler;
        caveChest = new CaveChest(handler, 1400, 0);
        caveWorld = new CaveWorld(handler,"res/Maps/caveMap.map",player,caveChest);

        entityManager.addEntity(new Tree(handler, 100, 250));
        entityManager.addEntity(new Rock(handler, 100, 450));
        entityManager.addEntity(new Tree(handler, 533, 276));
        entityManager.addEntity(new Rock(handler, 684, 1370));
        entityManager.addEntity(new Tree(handler, 765, 888));
        entityManager.addEntity(new Rock(handler, 88, 1345));
        entityManager.addEntity(new Tree(handler, 77, 700));
        entityManager.addEntity(new Rock(handler, 700, 83));
        entityManager.addEntity(new SkelyEnemy(handler, 1250, 500));
        entityManager.addEntity(new Door(handler, 100, 0,caveWorld));
        entityManager.addEntity(new Bush(handler, 200, 200));
        entityManager.addEntity(new Bush(handler, 50, 1238));
        entityManager.addEntity(new Bush(handler, 876, 333));
        entityManager.addEntity(new Bush(handler, 1234, 678));
        entityManager.addEntity(new Bush(handler, 789, 1400));
        entityManager.addEntity(new Bush(handler, 500, 1000));
        entityManager.addEntity(new Bush(handler, 222, 750));
        entityManager.addEntity(new Bush(handler, 1111, 1000));


        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);
       

    }
    @Override
    public void tick() {
    	// TODO Auto-generated method stub
    	super.tick();
    	if(handler.getKeyManager().skipbut){
			BaseWorld caveWorld = new CaveWorld(handler,"res/Maps/caveMap.map",handler.getWorld().getEntityManager().getPlayer(), caveChest);
			handler.setWorld(caveWorld);
		}
    }

}