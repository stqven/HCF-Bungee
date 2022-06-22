package le.inv.ho.Commands;

import java.io.File;
import java.io.IOException;

import le.inv.ho.API;
import le.inv.ho.Main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class IDCommand extends Command {
	  private Main bcb;
	  
	  public IDCommand(Main bcb) {
	    super("id", "id.admin", new String[] { "bungeecommandblocker" });
	    this.bcb = bcb;
	  }
	  
	  public void execute(CommandSender sender, String[] args) {
		    ProxiedPlayer p = (ProxiedPlayer) sender;
		    File file = new File(this.bcb.getDataFolder().getPath(), "bansid.yml");
		    
		    if (args.length == 0) {
		    	sender.sendMessage("§8┃ §cHozexMC §8┃ §7/id §7<ID>");
		    } else if (args.length == 1) {
			    	try {
						Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
						if (p.hasPermission("HozexMC.SrMod") || p.hasPermission("HozexMC.Admin") || p.hasPermission("HozexMC.Owner") || p.hasPermission("HozexMC.HeadAdmin")) {
							if (config.contains(args[0])) {
								sender.sendMessage("§8§m--------------§7§m-------§f- « §4Bans§7 §f» §f§m-§7§m-------§8§m--------------");
								sender.sendMessage("§8┃ §eHozexMC §8┃ §aStats for: " + args[0]);
								sender.sendMessage("§8┃ §eHozexMC §8┃ §7Name:§6 " + config.getString(args[0] + ".name"));
								sender.sendMessage("§8┃ §eHozexMC §8┃ §7Type:§6 " + config.getString(args[0] + ".type"));
								if (config.getString(args[0] + ".version") != null) {
									sender.sendMessage("§8┃ §eHozexMC §8┃ §7MC Version:§6 " + config.getString(args[0] + ".version"));
								}
								sender.sendMessage("§8┃ §eHozexMC §8┃ §7Reason:§6 " + config.getString(args[0] + ".reason"));
								sender.sendMessage("§8┃ §eHozexMC §8┃ §7By:§6 " + config.getString(args[0] + ".by"));
								if (config.getString(args[0] + ".evedence").contains("none") || config.getString(args[0] + ".evedence").equalsIgnoreCase("none")) {
									
								} else {
									sender.sendMessage("§8┃ §eHozexMC §8┃ §aEvedence:§6 " + config.getString(args[0] + ".evedence"));
								}
								if (config.contains(args[0] + ".teaming")) {
								}
								sender.sendMessage("§8┃ §eHozexMC §8┃ §aServer:§f " + config.getString(args[0] + ".server"));
								sender.sendMessage(
								API.getHoverClickRunCommandSuggest("§6More Information?", "§aClick for more information", "/history " + config.getString(args[0] + ".name")));
									
								sender.sendMessage("§8§m---------------§7§m-------§f- « §c✦§7 §f» §f§m-§7§m-------§8§m---------------");
							} else {
								sender.sendMessage("§8┃ §cHozexMC §8┃ §7This ID is not exist");
							}
						} else {
							if (p.hasPermission("H.Mod") || p.hasPermission("H.Helper") || p.hasPermission("H.Special")) {
								p.sendMessage("§8┃ §cHozexMC §8┃ §7You don't have enought permissions, Please give the code to a SrMod");
							} else {
								p.sendMessage("§8┃ §cHozexMC §8┃ §7Unknown command.");
							}
						}
					} catch (IOException e) {
						e.printStackTrace();
		    	}
		    }
	  }

}
