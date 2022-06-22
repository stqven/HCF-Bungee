package le.inv.ho.Commands;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class blockadv extends Command {
	
	public blockadv() {
	    super("blockadv", "H.Owner", new String[] { "badv" });
	}
	
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		File file = new File("plugins/HN-Bungee/blockadv.yml");
		if (args.length == 0) {
			p.sendMessage("§8┃ §cHozexMC §8┃ §7/blockadv [add | reomve] [player]");
		} else if (args.length == 1) {
			if (args[0].equalsIgnoreCase("add")) {
				p.sendMessage("§8┃ §cHozexMC §8┃ §7/blockadv add [player]");
			} else if (args[0].equalsIgnoreCase("remove")) {
				p.sendMessage("§8┃ §cHozexMC §8┃ §7/blockadv reomve [player]");
			} else {
				p.sendMessage("§8┃ §cHozexMC §8┃ §7/blockadv [add | reomve] [player]");
			}
		} else if (args.length == 2) {
			if (args[0].equalsIgnoreCase("add")) {
				try {
					Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
					List<String> l = config.getStringList("adv");
					if (l.contains(args[1])) {
						p.sendMessage("§8┃ §cHozexMC §8┃ §e" + args[1] + " §7is already in the list");
					} else {
						l.add(args[1].toLowerCase());
						config.set("adv", l);
						ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
						p.sendMessage("§8┃ §aHozexMC §8┃ §7Added §e" + args[1] + " §7to the list");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (args[0].equalsIgnoreCase("remove")) {
				try {
					Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
					List<String> l = config.getStringList("adv");
					if (l.contains(args[1]) || l.contains(args[1].toLowerCase())) {
						p.sendMessage("§8┃ §aHozexMC §8┃ §7Removed §e" + args[1] + " §7from the list");
						l.remove(args[1].toLowerCase());
						l.remove(args[1]);
						config.set("adv", l);
						ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
					} else {
						l.remove(args[1].toLowerCase());
						l.remove(args[1]);
						p.sendMessage("§8┃ §cHozexMC §8┃ §e" + args[1] + " §7is not in the list");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				p.sendMessage("§8┃ §cHozexMC §8┃ §7/blockadv [add | reomve] [player]");
			}
		}
	}

}
