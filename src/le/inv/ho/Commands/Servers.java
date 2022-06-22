package le.inv.ho.Commands;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;

public class Servers extends Command {
	private static Plugin plugin;
	
	public Servers(Plugin plugin) {
		super("servers");
		plugin = plugin;
	}
	
	public void execute(CommandSender sender, String[] args) {
		if (sender instanceof ProxiedPlayer) {
			ProxiedPlayer p = (ProxiedPlayer) sender;
			if (p.hasPermission("H.Owner") || p.hasPermission("H.Admin") || p.hasPermission("H.SrMod") || p.hasPermission("H.Mod") || p.hasPermission("H.Special") || p.hasPermission("H.Developer") || p.hasPermission("H.Helper")) {
				if (args.length == 0) {
					
				} else {
					if (BungeeCord.getInstance().getServers().containsKey(BungeeCord.getInstance().getServerInfo(args[0]).getName())) {
						p.connect(BungeeCord.getInstance().getServerInfo(args[0]));
					} else {
					}
				}
			}
		} else {
			sender.sendMessage("§cYou should be a player to run this command");
		}
	}

}
