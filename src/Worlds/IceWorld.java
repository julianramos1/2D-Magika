package Worlds;
import Game.Entities.Creatures.IceGolem;
import Game.Entities.Creatures.Player;
import Game.Entities.Creatures.SkelyEnemy;
import Game.Entities.Creatures.Zombie;
import Game.Entities.Statics.Chest;
import Game.Entities.Statics.Door;
import Game.Entities.Statics.Snow;
import Game.Entities.Statics.Snow;
import Main.Handler;

/**
 * Created by Elemental on 2/10/2017.
 */
public class IceWorld extends BaseWorld{
	private Handler handler;
	private Player player;
	
	public IceWorld(Handler handler, String path, Player player, Chest chest) {
		super(handler,path,player,chest);
		this.handler = handler;
		this.player=player;
		
        entityManager.addEntity(new IceGolem(handler, 1000, 500));
        
        entityManager.addEntity(new Snow(handler, 300, 500));
        entityManager.addEntity(new Snow(handler, 675, 350));
        entityManager.addEntity(new Snow(handler, 780, 232));
        entityManager.addEntity(new Snow(handler, 432, 202));
        entityManager.addEntity(new Snow(handler, 932, 821));
        entityManager.addEntity(new Snow(handler, 123, 410));
        entityManager.addEntity(new Snow(handler, 156, 265));
        entityManager.addEntity(new Snow(handler, 632, 123));
        entityManager.addEntity(new Snow(handler, 232, 800));
        entityManager.addEntity(new Snow(handler, 112, 1201));
        entityManager.addEntity(new Snow(handler, 612, 123));
        entityManager.addEntity(new Snow(handler, 762, 508));
        entityManager.addEntity(new Snow(handler, 101, 670));
        entityManager.addEntity(new Snow(handler, 461, 800));
        entityManager.addEntity(new Snow(handler, 89, 900));
        entityManager.addEntity(new Snow(handler, 712, 850));
        entityManager.addEntity(new Snow(handler, 612, 1234));
        entityManager.addEntity(new Snow(handler, 212, 1000));
        entityManager.addEntity(new Snow(handler, 300, 699));
        entityManager.addEntity(new Snow(handler, 888, 1000));
        entityManager.addEntity(new Snow(handler, 1032, 900));
        entityManager.addEntity(new Snow(handler, 809, 1032));
        entityManager.addEntity(new Snow(handler, 100, 645));
        entityManager.addEntity(new Snow(handler, 1200, 1045));
        entityManager.addEntity(new Snow(handler, 1000, 333));
        entityManager.addEntity(new Snow(handler, 222, 988));
        entityManager.addEntity(new Snow(handler, 345, 900));
        entityManager.addEntity(new Snow(handler, 789, 600));
        entityManager.addEntity(new Snow(handler, 650, 877));
        entityManager.addEntity(new Snow(handler, 666, 1002));
        entityManager.addEntity(new Snow(handler, 809, 790));
        entityManager.addEntity(new Snow(handler, 999, 1200));
        entityManager.addEntity(new Snow(handler, 1090, 1098));


	}

}