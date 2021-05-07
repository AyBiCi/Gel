package mainGel;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.util.Vector;

public class Gel {
	Location location;
	boolean isDead = false;
	
	static Material aliveGelMaterial = Material.LIME_STAINED_GLASS;
	static Material deadGelMaterial = Material.RED_STAINED_GLASS;
	
	public void Pregnate(GelManager gMan) {
		
		if(isDead) return;
		
		int numberOfCreated = 0;
		
		for(int x =-1;x != 2;x++) {
			for(int y =-1;y != 2;y++) {
				for(int z =-1;z != 2;z++) {
					int hm = 0;
					if(x == 0) hm++;
					if(y == 0) hm++;
					if(z == 0) hm++;
					
					if(hm == 2) {
					
						Location locCopy = location.clone();
						locCopy.add(new Vector(x,y,z));
						
						if(IsBlockGoable(locCopy.getBlock())) {
							gMan.CreateGel(locCopy);
							numberOfCreated++;
						}
					}
				}
			}
		}
		if(numberOfCreated == 0) {
			KillGel();
		}
	}
	
	Gel(Location location){
		this.location = location.clone();
		
		Block block = location.getBlock();
		
		if(block.getType().equals(Material.AIR)) {
			block.setType(aliveGelMaterial);
		}
	}

	public static boolean IsBlockGoable(Block block) {
		return (block.getType().equals(Material.AIR));
	}
	
	public void KillGel() {
		isDead = true;
		Block block = location.getBlock();
		if(block.getType().equals(aliveGelMaterial)) {
			block.setType(deadGelMaterial);
		}
	}
	
	public void DestroyGel() {
		Block block = location.getBlock();
		if(block.getType().equals(aliveGelMaterial) || block.getType().equals(deadGelMaterial)) {
			block.setType(Material.AIR);
		}
	}
	
}
