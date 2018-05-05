package Worlds;
import Game.Entities.Creatures.Player;
import Game.Entities.Statics.Chest;
import Game.Entities.Statics.Door;
import Main.Handler;

/**
 * Created by Elemental on 2/10/2017.
 */
public class CaveWorld extends BaseWorld{
	private Handler handler;
	private Player player;
	private Chest chest;
	
	public CaveWorld(Handler handler, String path, Player player, Chest chest) {
		super(handler,path,player,chest);
		this.handler = handler;
		this.player=player;
		this.chest=chest;
		
		
	}

}