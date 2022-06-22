package le.inv.ho.Commands;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import de.simonsator.partyandfriends.updatechecker.UpdateSearcher;
import le.inv.ho.API;
import le.inv.ho.Main;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class otmove extends Command {
	  private Main bcb;
	  
	  public otmove(Main bcb) {
	    super("otmove", "hozex.base", new String[] { "otch" });
	    this.bcb = bcb;
	  }

public void execute(CommandSender cs, String[] args) {
	  ProxiedPlayer p = (ProxiedPlayer)cs;
	  File file1 = new File("plugins/OnlineTime/names.yml");
	  File file2 = new File("plugins/OnlineTime/time.yml");	
	  if (p.hasPermission("HozexMC.Owner") || p.hasPermission("HozexMC.Admin") || p.hasPermission("HozexMC.Manager")) {
		  if (args.length == 0) {
			  p.sendMessage("§c/otmove <name_from> <name_to>");
		  } else if (args.length == 1) {
			  p.sendMessage("§c/otmove <name_from> <name_to>");
		  } else if (args.length == 2) {
			  try {
					Configuration names = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file1);
					Configuration time = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file2);
					
					  String uuid1 = names.getString(args[0]);
					  String uuid2 = names.getString(args[1]);
					  int time1 = time.getInt(uuid1);
					  int time2 = time.getInt(uuid2);
					  int total = (time1 + time2);

					  p.sendMessage("§aTrans Info:");
					  p.sendMessage("§6UUID1:§e " + uuid1);
					  p.sendMessage("§6UUID2:§e " + uuid2);
					  p.sendMessage("§6TIME1:§e " + time1);
					  p.sendMessage("§6TIME2:§e " + time2);
					  p.sendMessage("§6TOTAL:§f " + total);
					  time.set(uuid2, total);
					  time.set(uuid1, 0);
		    		  ConfigurationProvider.getProvider(YamlConfiguration.class).save(time, file2);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			  
		  }
	  }
}

public static void OTRefresh(String Playername) {
	  File file1 = new File("plugins/OnlineTime/names.yml");
	  File file2 = new File("plugins/OnlineTime/time.yml");	
	  try {
			Configuration cnames = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file1);
			Configuration ctime = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file2);
			
			  String uuid = cnames.getString(Playername);
			  int time = ctime.getInt(uuid);
			  if (API.exists(Playername)) {
		  		  API.setOT(Playername, time);
			  }
			
		} catch (IOException e) {
			e.printStackTrace();
		}
}

}
