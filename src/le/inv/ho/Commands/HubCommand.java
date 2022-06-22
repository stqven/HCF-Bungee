package le.inv.ho.Commands;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class HubCommand extends Command {
	public HubCommand(String name) {
		super(name);
	}

	public void execute(final CommandSender sender, String[] args) {
		if ((sender instanceof ProxiedPlayer)) {
			ProxiedPlayer p = (ProxiedPlayer) sender;
			if (!p.getServer().getInfo().getName().contains("AuthMe")) {
				if (p.getServer().getInfo().getName().equalsIgnoreCase("Hub")) {
					p.sendMessage("§8▏ §cHozexMC §8▏ §7You are already connected to the lobby server.");
					return;
				}
				p.connect(BungeeCord.getInstance().getServerInfo("Hub"));
			}
		}
	}
}