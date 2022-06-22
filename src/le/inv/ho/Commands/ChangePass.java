package le.inv.ho.Commands;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ChangePass extends Command {
	
	public ChangePass() {
		super("changepass");
	}
	
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		p.connect(BungeeCord.getInstance().getServerInfo("ChangePass"));
	}

}
