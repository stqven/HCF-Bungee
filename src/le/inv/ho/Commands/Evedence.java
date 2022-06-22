package le.inv.ho.Commands;

import java.io.File;
import java.io.IOException;

import de.simonsator.partyandfriends.main.Main;
import le.inv.ho.API;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class Evedence extends Command {
	
	  private Main bcb;
	  public Evedence(Main bcb) {
	    super("evedence");
	    this.bcb = bcb;
	  }
	  
	@Override
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if (args.length == 0) {
			if (p.hasPermission("H.Owner") || p.hasPermission("H.HeadAdmin") || p.hasPermission("H.Admin") || p.hasPermission("H.Developer") || p.hasPermission("H.Special") || p.hasPermission("H.SrMod")) {
				p.sendMessage("§8┃ §cHozexMC §8┃ §7/Evedence [id] [link]");
				p.sendMessage("§8┃ §cHozexMC §8┃ §7/Evedence remove [id]");
			} else {
				p.sendMessage("§8┃ §cHozexMC §8┃ §7/Evedence [id] [link]");
			}
		} else if (args.length == 1) {
			if (p.hasPermission("H.Owner") || p.hasPermission("H.HeadAdmin") || p.hasPermission("H.Admin") || p.hasPermission("H.Developer") || p.hasPermission("H.Special") || p.hasPermission("H.SrMod")) {
				p.sendMessage("§8┃ §cHozexMC §8┃ §7/Evedence [id] [link]");
				p.sendMessage("§8┃ §cHozexMC §8┃ §7/Evedence remove [id]");
			} else {
				p.sendMessage("§8┃ §cHozexMC §8┃ §7/Evedence [id] [link]");
			}
		} else {
		    File file = new File(this.bcb.getDataFolder().getPath(), "bansid.yml");
		    
		    if (args.length == 0) {
		    	sender.sendMessage("§8┃ §cHozexMC §8┃ §7/id §7<ID>");
		    } else if (args.length == 1) {
			    	try {
						Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
						if (config.contains(args[0] + ".type")) {
							if (config.getString(args[0] + ".type").contains("ban")) {
								if (p.hasPermission("H.Owner") || p.hasPermission("H.HeadAdmin") || p.hasPermission("H.Admin") || p.hasPermission("H.Developer") || p.hasPermission("H.Special") || p.hasPermission("H.SrMod")) {
									config.set(args[0] + ".evedence", args[1]);
								} else if (p.hasPermission("H.Mod")) {
									if (config.getString(args[0] + ".by").equals(p.getName())) {
										config.set(args[0] + ".evedence", args[1]);
									} else {
										p.sendMessage("§8┃ §cHozexMC §8┃ §7You haven't banned this player");
									}
								} else if (p.hasPermission("H.Helper")) {
									p.sendMessage("§8┃ §cHozexMC §8┃ §7This ID doesn't exist!");
								}
							} else {
								if (p.hasPermission("H.Owner") || p.hasPermission("H.HeadAdmin") || p.hasPermission("H.Admin") || p.hasPermission("H.Developer") || p.hasPermission("H.Special") || p.hasPermission("H.SrMod")) {
									config.set(args[0] + ".evedence", args[1]);
								} else {
									if (config.getString(args[0] + ".by").equals(p.getName())) {
										config.set(args[0] + ".evedence", args[1]);
									} else {
										p.sendMessage("§8┃ §cHozexMC §8┃ §7You haven't muted this player");
									}
								}
							}
						} else {
							p.sendMessage("§8┃ §cHozexMC §8┃ §7This ID doesn't exist!");
						}
			    	} catch (IOException et) {
			    		et.printStackTrace();
			    	}
			if (p.hasPermission("H.Owner") || p.hasPermission("H.HeadAdmin") || p.hasPermission("H.Admin") || p.hasPermission("H.Developer") || p.hasPermission("H.Special") || p.hasPermission("H.SrMod")) {
				p.sendMessage("§8┃ §cHozexMC §8┃ §7/Evedence [id] [link]");
				p.sendMessage("§8┃ §cHozexMC §8┃ §7/Evedence remove [id]");
			} else {
				p.sendMessage("§8┃ §cHozexMC §8┃ §7/Evedence [id] [link]");
			}
		}
			for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
				if (all.hasPermission("H.Owner") || all.hasPermission("H.HeadAdmin") || all.hasPermission("H.Admin") || all.hasPermission("H.Developer") || all.hasPermission("H.Special") || all.hasPermission("H.SrMod") || all.hasPermission("H.Mod") || all.hasPermission("H.Helper")) {
            		all.sendMessage("§8┃ §6HozexMC §8┃ §e" + sender + " §7 Attached an evedence for ID: §e" + args[0]);
				}
			}
	}
	}
}
