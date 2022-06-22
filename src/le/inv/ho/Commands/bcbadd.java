package le.inv.ho.Commands;

import java.io.File;
import java.io.IOException;
import java.util.List;

import le.inv.ho.Main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class bcbadd extends Command {
	
	  private Main bcb;
	  
	  public bcbadd(Main bcb) {
	    super("bcb");
	    this.bcb = bcb;
	  }
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		File file = new File("plugins/HN-Bungee/commands.yml");
		
		if (args.length == 0) {
			p.sendMessage("§8┃ §cHozexMC §8┃ §7/bcb [add | reomve] [command]");
		} else if (args.length == 1) {
			if (args[0].equalsIgnoreCase("add")) {
				p.sendMessage("§8┃ §cHozexMC §8┃ §7/bcb add [command]");
			} else if (args[0].equalsIgnoreCase("remove")) {
				p.sendMessage("§8┃ §cHozexMC §8┃ §7/bcb reomve [command]");
			} else {
				p.sendMessage("§8┃ §cHozexMC §8┃ §7/bcb [add | reomve] [command]");
			}
		} else if (args.length == 2) {
			if (args[0].equalsIgnoreCase("add")) {
				try {
					Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
					List<String> l = config.getStringList("commands");
					if (l.contains(args[1])) {
						p.sendMessage("§8┃ §cHozexMC §8┃ §e" + args[1] + " §7is already in the list");
					} else {
						l.add(args[1].toLowerCase());
						config.set("commands", l);
						ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
						p.sendMessage("§8┃ §aHozexMC §8┃ §e" + args[1] + " §7has been added to the list");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (args[0].equalsIgnoreCase("remove")) {
				try {
					Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
					List<String> l = config.getStringList("commands");
					if (l.contains(args[1]) || l.contains(args[1].toLowerCase())) {
						p.sendMessage("§8┃ §aHozexMC §8┃ §e" + args[1] + " §7has been removed to the list");
						l.remove(args[1].toLowerCase());
						l.remove(args[1]);
						config.set("commands", l);
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
				p.sendMessage("§8┃ §cHozexMC §8┃ §7/bcb [add | reomve] [command]");
			}
		}
	}

}
