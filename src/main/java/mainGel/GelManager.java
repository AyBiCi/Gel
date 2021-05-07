package mainGel;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;

public class GelManager {

	private List<Gel> aliveGel = new ArrayList<Gel>();
	
	public void Iterate(int howMany) {
		for(int i=0;i<howMany;i++) {
			
			List<Gel> clonedList = new ArrayList<Gel>();
		
			for(Gel g : aliveGel) 
				clonedList.add(g);
			
			
			for(Gel g : clonedList) 
				g.Pregnate(this);
			
		}
		
	}
	
	public void CreateGel(Location location) {
		aliveGel.add(new Gel(location));
	}
	
	public void DeleteAllGel() {
		for(Gel g : aliveGel)
			g.DestroyGel();
		
		aliveGel.clear();
	}
	
}
