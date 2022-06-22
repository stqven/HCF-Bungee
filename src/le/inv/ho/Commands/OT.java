package le.inv.ho.Commands;

import le.inv.ho.API;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class OT extends Command {
	
	public OT() {
		super("ot");
	}
	
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		StringBuilder time = new StringBuilder();
		int ss = API.getOT(p.getName());
		int yy = ss/(ss*36*4800000);
		int mo = (ss%(ss*36*4800000))/(3600*24*12);
		int dd = ((ss%(ss*36*4800000))%(3600*24*12))/(3600*24);
		int hh = (((ss%(ss*36*4800000))%(3600*24*12))%(3600*24))/(3600);
		int mm = ((((ss%(ss*36*4800000))%(3600*24*12))%(3600*24))%(3600))/60;
		ss = ((((ss%(ss*36*4800000))%(3600*24*12))%(3600*24))%(3600))%60;
		if (yy != 0) {
			if (yy == 1) {
				time.append(" " + time + " year");
			} else {
				time.append(" " + time + " years");
			}
		}
		if (mo != 0) {
			if (mo == 1) {
				time.append(" " + time + " month");
			} else {
				time.append(" " + time + " months");
			}
		}
		if (dd != 0) {
			if (dd == 1) {
				time.append(" " + time + " day");
			} else {
				time.append(" " + time + " days");
			}
		}
		if (hh != 0) {
			if (hh == 1) {
				time.append(" " + time + " hour");
			} else {
				time.append(" " + time + " hours");
			}
		}
		if (mm != 0) {
			if (dd == 1) {
				time.append(" " + time + " minute");
			} else {
				time.append(" " + time + " minutes");
			}
		}
		if (dd != 0) {
			if (dd == 1) {
				time.append(" " + time + " second");
			} else {
				time.append(" " + time + " seconds");
			}
		}
		if (args.length == 0) {
			p.sendMessage("&8┃ &eHozexMC &8┃ &6Name&7's OnlineTime: &e");
		}
	}
}
