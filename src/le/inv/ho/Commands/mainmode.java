package le.inv.ho.Commands;

import java.util.UUID;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class mainmode extends Command {
	
	public mainmode() {
		super("maintenance");
	}
	
	public void execute(CommandSender sender, String[] args) {
		if (sender.hasPermission("HozexMC.Owner") || sender.hasPermission("HozexMC.HeadAdmin") || sender.hasPermission("HozexMC.Admin")) {
			for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
				if (all.hasPermission("HozexMC.Owner") || all.hasPermission("HozexMC.HeadAdmin") || all.hasPermission("HozexMC.Admin") || all.hasPermission("HozexMC.SrMod")) {
					all.sendMessage( new TextComponent("§cMaintenance mode has been enabled by §e" + sender.getName()));
				} else {
	        		all.sendMessage("§8▏ §eHozexMC §8▏ §7Good Bye..");
	        		all.disconnect("§8+ §8§m---------§7§m-§6§m-§e§m-------------§6§m-§7§m-§8§m---------§8 +\n§7\n§6Hozex§eMC \n §4Maintenance \n §aWe will back as soon as possiple\n§7\n§8+ §8§m---------§7§m-§6§m-§e§m-------------§6§m-§7§m-§8§m---------§8 +");

					ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "whitelist on");
					ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "whitelist message set &fThe server is under §bMaintenance§f, Please come back later");
					ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "whitelist add InVisTeK_");
				}
			}
		}
	}

}
