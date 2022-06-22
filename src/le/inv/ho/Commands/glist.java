package le.inv.ho.Commands;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class glist extends Command {
	
	public glist() {
		super("tx");
	}
	public void execute(CommandSender sender, String[] args) {
		StringBuilder str = new StringBuilder();
		int cc = 0;
		for (String srv : BungeeCord.getInstance().getServers().keySet()) {
			str.append("\n§e[" + srv + "] (" + BungeeCord.getInstance().getServerInfo(srv).getPlayers().size() + "): §f ");
			for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
				if (all.hasPermission("H.Owner") || all.hasPermission("H.HeadAdmin") || all.hasPermission("H.Admin") || all.hasPermission("H.SrMod") || all.hasPermission("H.Mod") || all.hasPermission("H.Helper") || all.hasPermission("H.Developer")) {
					str.append(all.getName() + "§f, ");
				}
			}
			if (++cc != BungeeCord.getInstance().getServers().keySet().size()) {
				str.append("\n");
			}
		}
	}
	
}
