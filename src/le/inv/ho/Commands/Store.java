package le.inv.ho.Commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Store extends Command {
	
	public Store() {
		super("store");
	}
	
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		p.sendMessage("§8§m------------§7§m-------§f- « §3Discord§7 §f» §f§m-§7§m-------§8§m-------------");
		p.sendMessage("");
		p.sendMessage("§7 §bLink: §f§nHozexMC.com §c[Maintenance]");
		p.sendMessage("");
		p.sendMessage("§8§m---------------§7§m-------§f- « §c✦§7 §f» §f§m-§7§m-------§8§m---------------");
	}

}