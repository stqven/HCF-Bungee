package le.inv.ho.Commands;

import java.util.Iterator;

import de.simonsator.partyandfriends.communication.sql.cache.PlayerCache;
import le.inv.ho.API;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;

public class testcmd extends Command {
	private Plugin plugin;
	
	public testcmd(Plugin plugin) {
		super("topot");
		plugin = plugin;
	}
	
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer px = (ProxiedPlayer) sender;
	      String player;
	        int rank = 1;
	          sender.sendMessage("§6«§8§m--------§e§m------§8§m-§6 §6Top OnlineTime§6 §8§m-§e§m------§8§m---------§6»");
	        for (Iterator localIterator1 = API.getTopPlayers().iterator(); localIterator1.hasNext();) {
	          player = (String)localIterator1.next();
	          StringBuilder str = new StringBuilder();
	          int mm = API.getDaysOT(player).get(0)/30;
	          int ww = (API.getDaysOT(player).get(0)%30)/7;
	          int dd = (API.getDaysOT(player).get(0)%30)%7;
	          int hh = API.getDaysOT(player).get(1);
	          if (mm != 0) {
		          if (ww <= 1) {
		        	  str.append(mm + " month and ");
		          } else {
		        	  str.append(mm + " months and ");
		          }
	          }
	          if (ww != 0) {
		          if (ww <= 1) {
		        	  str.append(ww + " week and ");
		          } else {
		        	  str.append(ww + " weeks and ");
		          }
	          }
	          if (dd != 0) {
		          if (dd <= 1) {
		        	  str.append(dd + " day and ");
		          } else {
		        	  str.append(dd + " days and ");
		          }  
	          }
	          if (hh != 0) {
		          if (hh <= 1) {
		        	  str.append(hh + " hour.");
		          } else {
		        	  str.append(hh + " hours.");
		          }  
	          }
	          if (player.equals(sender.getName())) {
		          sender.sendMessage("§6#" + rank + " §c" + player + " §8➫ §b" + str);
	          } else {
		          sender.sendMessage("§6#" + rank + " §e" + player + " §8➫ §b" + str);
	          }
	          rank++;
	        }
	          sender.sendMessage("§6«§8§m--------§e§m------§8§m-§6 §6Top OnlineTime§6 §8§m-§e§m------§8§m---------§6»");
	          if (args.length == 1) {
	        	  ProxiedPlayer p = (ProxiedPlayer) sender;
	        	  p.sendMessage("#" + API.getRanking(args[0]));
	          }
	}

}