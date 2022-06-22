package le.inv.ho.Commands;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class avgping extends Command {
	public avgping() {
		super("avgping");
	}
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		int cc = 0, sum = 0;
		for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
			sum += all.getPing();
			cc++;
		}
		p.sendMessage("§8┃ §aHozexMC §8┃ §eAverage server ping: §7" + sum/cc);
		
	}

}
