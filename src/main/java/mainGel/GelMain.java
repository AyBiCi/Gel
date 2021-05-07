package mainGel;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class GelMain extends JavaPlugin{
	
	static PlayerGelManager gelMan;
	
	@Override
	public
	void onEnable() {
		gelMan = new PlayerGelManager();
	}
	
	@Override
	public void onDisable() {
		gelMan.KillAllGel();
	}
	
	String[] usage = {"creategel","iterate [howMany = 5]","killgel"};
	String[] caption = {"creates new gel cell where player stands","grow gel by this amount of times","kills all the gel"};
	
	
	public void SendHelp(Player player) {
		player.sendMessage(ChatColor.YELLOW+"List of commands for GEL : ");
		for(int i=1;i<=3;i++) {
			player.sendMessage(ChatColor.AQUA+""+i+""+ChatColor.GREEN+usage[i-1]+" - "+ChatColor.YELLOW+caption[i-1]);
		}
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED+"This plugin is only usable by player!");
			return true;
		}
		
		Player player = (Player) sender;
		
		if(args.length == 0) {
			SendHelp(player);
			return true;
		}
		
		GelManager gMan = gelMan.getGelManager(player);
		
		if(args[0].equalsIgnoreCase("creategel")) {
			gMan.CreateGel(player.getLocation());
		}
		else if(args[0].equalsIgnoreCase("iterate")) {
			
			int howMany;
			
			try {
				howMany = Integer.parseInt(args[1]);
			}
			catch(IllegalArgumentException e) {
				howMany = 5;
			}
			
			gMan.Iterate(howMany);
		}
		else if(args[0].equalsIgnoreCase("killgel")) {
			gMan.DeleteAllGel();
		}
		else SendHelp(player);
		return true;
	}
	
}
