package le.inv.ho.Commands;

import java.io.File;
import java.util.ArrayList;

import le.inv.ho.API;
import le.inv.ho.Arabic;
import le.inv.ho.Main;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ModChat extends Command {
	private Main bcb;

	public ModChat(Main bcb) {
		super("mod", "hozex.modchat", new String[] { "mc" });
		this.bcb = bcb;
	}

	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if (args.length == 0) {
			sender.sendMessage("§cYou must say something");
		} else {
			StringBuilder builder = new StringBuilder();
			String[] arrayOfString;
			int j = (arrayOfString = args).length;
			for (int i = 0; i < j; i++) {
				String s = arrayOfString[i];
				builder.append(ChatColor.translateAlternateColorCodes('&', s));
				builder.append(" ");
			}
			String message = builder.substring(0, builder.length() - 1);

			TextComponent titleComp = new TextComponent();
			titleComp.setBold(Boolean.valueOf(true));
			for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
				if (all.hasPermission("hozexmc.modchat")) {
					if (all.hasPermission("H.Owner") || all.hasPermission("H.HeadAdmin") || all.hasPermission("H.Admin") || all.hasPermission("H.SrMod")) {
						all.sendMessage(new TextComponent(API.getHoverMessage("§8❘ §bMod§7Chat §8❘ §e" + API.getP(sender.getName()) + " §8» §f" + Arabic.changeArabic(message),
								"§e" + sender.getName() + "'s Server: §7" + p.getServer().getInfo().getName())));
					} else {
						all.sendMessage("§8❘ §bMod§7Chat §8❘ §e" + API.getP(sender.getName()) + " §8» §f" + Arabic.changeArabic(message));
					}
				}
			}
		}
	}
}