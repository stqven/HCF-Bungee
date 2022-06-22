package le.inv.ho.Commands;

import java.awt.TextComponent;
import java.util.ArrayList;

import le.inv.ho.API;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class PingCommand extends Command {

	public PingCommand() {
		super("ping");
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		if (sender instanceof ProxiedPlayer) {
			ProxiedPlayer p = (ProxiedPlayer) sender;
			if (args.length == 0) {
				int ping = p.getPing();
				if (ping < 110) {
					p.sendMessage("§4§8┃§c §aHozexMC §8┃§c §7Your ping: §a" + ping + " §7ms");
				} else if (ping < 150) {
					p.sendMessage("§4§8┃§c §aHozexMC §8┃§c §7Your ping: §2" + ping + " §7ms");
				} else if (ping < 250) {
					p.sendMessage("§4§8┃§c §aHozexMC §8┃§c §7Your ping: §c" + ping + " §7ms");
				} else {
					p.sendMessage("§4§8┃§c §aHozexMC §8┃§c §7Your ping: §4" + ping + " §7ms");
				}
			} else if (args.length == 1) {
				if (p.hasPermission("HozexMC.Owner") || p.hasPermission("HozexMC.Admin") || p.hasPermission("HozexMC.SrMod")) {
					ProxiedPlayer t = BungeeCord.getInstance().getPlayer(args[0]);
					if (t != null) {
						int ping = t.getPing();
						if (t.getName().contains(p.getName())) {
							if (ping < 110) {
								p.sendMessage("§4§8┃§c §aHozexMC §8┃§c §7Your ping: §a" + ping + " §7ms");
							} else if (ping < 150) {
								p.sendMessage("§4§8┃§c §aHozexMC §8┃§c §7Your ping: §2" + ping + " §7ms");
							} else if (ping < 250) {
								p.sendMessage("§4§8┃§c §aHozexMC §8┃§c §7Your ping: §c" + ping + " §7ms");
							} else {
								p.sendMessage("§4§8┃§c §aHozexMC §8┃§c §7Your ping: §4" + ping + " §7ms");
							}
						} else {
							if (ping < 110) {
								p.sendMessage("§8▏ §aHozexMC §8▏ §7" + t.getName() + "'s ping: §a" + ping + " §7ms");
							} else if (ping < 150) {
								p.sendMessage("§8▏ §aHozexMC §8▏ §7" + t.getName() + "'s ping: §2" + ping + " §7ms");
							} else if (ping < 250) {
								p.sendMessage("§8▏ §aHozexMC §8▏ §7" + t.getName() + "'s ping: §c" + ping + " §7ms");
							} else {
								p.sendMessage("§8▏ §aHozexMC §8▏ §7" + t.getName() + "'s ping: §4" + ping + " §7ms");
							}
						}
					} else {
						p.sendMessage("§8▏ §cHozexMC §8▏ §7" + args[0] + " is not online!");
					}
				} else {
					ProxiedPlayer t = BungeeCord.getInstance().getPlayer(args[0]);
					if (t != null) {
						if (!API.isVanished(t.getName())) {
							int ping = t.getPing();
							if (t.getName().contains(p.getName())) {
								if (ping < 110) {
									p.sendMessage("§4§8┃§c §aHozexMC §8┃§c §7Your ping: §a" + ping + " §7ms");
								} else if (ping < 150) {
									p.sendMessage("§4§8┃§c §aHozexMC §8┃§c §7Your ping: §2" + ping + " §7ms");
								} else if (ping < 250) {
									p.sendMessage("§4§8┃§c §aHozexMC §8┃§c §7Your ping: §c" + ping + " §7ms");
								} else {
									p.sendMessage("§4§8┃§c §aHozexMC §8┃§c §7Your ping: §4" + ping + " §7ms");
								}
							} else {
								if (ping < 110) {
									p.sendMessage("§8▏ §aHozexMC §8▏ §7" + t.getName() + "'s ping: §a" + ping + " §7ms");
								} else if (ping < 150) {
									p.sendMessage("§8▏ §aHozexMC §8▏ §7" + t.getName() + "'s ping: §2" + ping + " §7ms");
								} else if (ping < 250) {
									p.sendMessage("§8▏ §aHozexMC §8▏ §7" + t.getName() + "'s ping: §c" + ping + " §7ms");
								} else {
									p.sendMessage("§8▏ §aHozexMC §8▏ §7" + t.getName() + "'s ping: §4" + ping + " §7ms");
								}
							}
						} else {
							p.sendMessage("§8▏ §cHozexMC §8▏ §7" + args[0] + " is not online!");
						}
					} else {
						p.sendMessage("§8▏ §cHozexMC §8▏ §7" + args[0] + " is not online!");
					}
				}
			}
		}
	}

}
