package le.inv.ho.Commands;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import le.inv.ho.API;
import le.inv.ho.Main;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import net.md_5.bungee.event.EventHandler;

public class RoleChat_H implements Listener {
	private Main bcb;
	
	public RoleChat_H() {
		bcb = this.bcb;
	}
	
	@EventHandler
	public void onChatCMD(ChatEvent e) {
		ProxiedPlayer p = (ProxiedPlayer) e.getSender();
		if (p.hasPermission("H.Owner") || p.hasPermission("H.HeadAdmin") || p.hasPermission("H.Admin")) {
				  File file = new File(bcb.getDataFolder().getPath(), "infos.yml");
					try {
						Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
						if (!config.get(p.getName() + "isSelecting").toString().contains("--")) {
							if (e.getMessage().equals("Y")) {
								ArrayList<String> players = new ArrayList<String>(Arrays.asList(config.get(p.getName() + "isSelecting").toString().split(",")));
								String player1 = players.get(0);
								String player2 = players.get(1);
								String p1rank = API.getPrimaryGroup(player1);
									BungeeCord.getInstance().getPluginManager().dispatchCommand(p, "lp user " + player2 + " group set " + p1rank);
									BungeeCord.getInstance().getPluginManager().dispatchCommand(p, "lp user " + player1 + " clear");
									p.sendMessage("§8┃ §aHozexMC §8┃ §7You have given §e" + player2 + " §7" + p1rank);
							} else {
		  						try {
	    	  						config.set(p.getName() + ".isSelecting", "--");
									ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
									p.sendMessage("§8┃ §aHozexMC §8┃ §7You've  selected §cNo");
								} catch (IOException et) {
									et.printStackTrace();
								}
							}
						} else {
						}
						
					} catch (Exception et) {
						et.printStackTrace();
					}
		}
	}

}
