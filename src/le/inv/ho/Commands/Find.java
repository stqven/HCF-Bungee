package le.inv.ho.Commands;

import java.io.File;
import java.io.IOException;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class Find extends Command {
	
	public Find() {
	    super("f", "H.ModShip", new String[] { "find" });
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if (p.hasPermission("H.Owner") || p.hasPermission("H.HeadAdmin") || p.hasPermission("H.Admin") || p.hasPermission("H.Developer") || p.hasPermission("H.Special") || p.hasPermission("H.SrMod") || (p.hasPermission("H.Mod"))) {
			if (args.length == 0) {
				p.sendMessage("§8▏ §cHozexMC §8▏ §7 /f <name>");
				p.sendMessage("§8▏ §cHozexMC §8▏ §7This command will give you the player server's name");
			} else if (args.length == 1) {
				ProxiedPlayer t = BungeeCord.getInstance().getPlayer(args[0]);
				if (t != null) {
					if (args[0].equals(p.getName())) {
						p.sendMessage("§8▏ §aHozexMC §8▏  §7You are online at §a" + p.getServer().getInfo().getName());
					} else {
						if (p.hasPermission("H.Owner") || p.hasPermission("H.HeadAdmin") || p.hasPermission("H.Admin")) {
							p.sendMessage("§8▏ §aHozexMC §8▏ §7" + args[0] + " §7is online at §a" + t.getServer().getInfo().getName());
						} else {
							if (p.hasPermission("H.Owner") || p.hasPermission("H.HeadAdmin") || p.hasPermission("H.Admin") || p.hasPermission("H.Developer") || p.hasPermission("H.Special") || p.hasPermission("H.SrMod") || (p.hasPermission("H.Mod"))) {
								p.sendMessage("§8▏ §cHozexMC §8▏ §7This player isn't online");
							} else {
								p.sendMessage("§8▏ §aHozexMC §8▏ §7" + args[0] + " §7is online at §a" + t.getServer().getInfo().getName());
							}
						}
					}
				} else {
					p.sendMessage("§8▏ §cHozexMC §8▏ §7This player isn't online");
				}
			}
		}
		
	}
}
