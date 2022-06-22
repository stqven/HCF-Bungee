package le.inv.ho.Commands;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;

public class RequestAnyDesk extends Command {
	private Plugin plugin;
	
	public RequestAnyDesk(Plugin plugin) {
		super("ReAD");
		plugin = plugin;
	}
	
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if (p.hasPermission("H.Owner") || p.hasPermission("H.HeadAdmin") || p.hasPermission("H.Admin") || p.hasPermission("H.Developer") || p.hasPermission("H.Special") || p.hasPermission("H.SrMod") || p.hasPermission("H.Mod") || p.hasPermission("H.Helper")) {
			if (args.length == 0) {
				p.sendMessage("§8┃ §cHozexMC §8┃ §7Usage: §e/ReAD [Name] §7[AnyDeskID]");
			} else if (args.length == 1) {
				if (p.hasPermission("H.AnyDesk")) {
					if (isOnlineAnyDesk() == true) {
						ProxiedPlayer t = BungeeCord.getInstance().getPlayer(args[0]);
						if (t != null) {
							if (t.hasPermission("H.Owner") || t.hasPermission("H.HeadAdmin") || t.hasPermission("H.Admin") || t.hasPermission("H.SrMod") || t.hasPermission("H.Developer") || t.hasPermission("H.Special") || t.hasPermission("H.Mod") || t.hasPermission("H.Helper")) {
								p.sendMessage("§8┃ §cHozexMC §8┃ §7You are not allowed to do this.");
							} else {
								for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
									if (all.hasPermission("H.AnyDesk")) {
										all.sendMessage("§4┃ §e" + p.getName() + " §7has sent you a request to check §c" + args[0] + " §7PC");
										all.sendMessage("§4┃ §7His AnyDesk ID: §c-");
									}
								}
							}
						} else {
							p.sendMessage("§8┃ §cHozexMC §8┃ §e" + args[0] + " §7is not online");
						}
					} else {
						p.sendMessage("§8┃ §cHozexMC §8┃ §7There are not any user has perms to use anydesk right now!");
					}
				} else {
					p.sendMessage("§8┃ §cHozexMC §8┃ §7You are not allowed to do this.");
				}
			} else {
				if (p.hasPermission("H.AnyDesk")) {
					if (isOnlineAnyDesk() == true) {
						ProxiedPlayer t = BungeeCord.getInstance().getPlayer(args[0]);
						if (t != null) {
							if (t.hasPermission("H.Owner") || t.hasPermission("H.HeadAdmin") || t.hasPermission("H.Admin") || t.hasPermission("H.SrMod") || t.hasPermission("H.Developer") || t.hasPermission("H.Special") || t.hasPermission("H.Mod") || t.hasPermission("H.Helper")) {
								p.sendMessage("§8┃ §cHozexMC §8┃ §7You are not allowed to do this.");
							} else {
								for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
									if (all.hasPermission("H.AnyDesk")) {
										all.sendMessage("§4┃ §e" + p.getName() + " §7has sent you a request to check §c" + args[0] + " §7PC");
										all.sendMessage("§4┃ §7His AnyDesk ID: §e" + args[1]);
									}
								}
							}
						} else {
							p.sendMessage("§8┃ §cHozexMC §8┃ §e" + args[0] + " §7is not online");
						}
					} else {
						p.sendMessage("§8┃ §cHozexMC §8┃ §7There are not any user has perms to use anydesk right now!");
					}
				} else {
					p.sendMessage("§8┃ §cHozexMC §8┃ §7You are not allowed to do this.");
				}
			}
		} else {
			p.sendMessage("§8┃ §cHozexMC §8┃ §7Unknown command.");
		}
	}
	
	public boolean isOnlineAnyDesk() {
		boolean i = false;
		for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
			if (all.hasPermission("H.AnyDesk")) {
				i = true;
			}
		}
		return i;
	}

}
