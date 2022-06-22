package le.inv.ho.Commands;


import le.inv.ho.API;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Contact extends Command {
	
	public Contact() {
		super("contact");
	}
	
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		p.sendMessage("§8§m------------§7§m-------§f- « §3Contact§7 §f» §f§m-§7§m-------§8§m-------------");
		p.sendMessage("");
		p.sendMessage("§7 §9Discord: §fhttps://discord.gg/PrDua3m");
		p.sendMessage("§7 §bSite: §fHozexMC.com §c[Maintenance]");
		p.sendMessage("");
		p.sendMessage("§8§m---------------§7§m-------§f- « §c✦§7 §f» §f§m-§7§m-------§8§m---------------");
	}

}