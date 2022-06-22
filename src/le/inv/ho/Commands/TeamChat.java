package le.inv.ho.Commands;

import java.io.File;

import le.inv.ho.API;
import le.inv.ho.Arabic;
import le.inv.ho.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class TeamChat extends Command {
	  private Main bcb;
	  
	  public TeamChat(Main bcb) {
		    super("tc", "H.Admin", new String[] { "teamchat" });
		    this.bcb = bcb;
		  }
  
  public void execute(CommandSender sender, String[] args) {
	  File file = new File(bcb.getDataFolder().getPath(), "modchat.yml");
	  ProxiedPlayer p = (ProxiedPlayer) sender;
    if (args.length == 0) {
      sender.sendMessage("§cYou must say something");
    } else {
      StringBuilder builder = new StringBuilder();
      String[] arrayOfString;
      int j = (arrayOfString = args).length;
      for (int i = 0; i < j; i++) {
        String s = arrayOfString[i];
        builder.append(s);
        builder.append(" ");
      }
      String message = builder.substring(0, builder.length() - 1);
      
      TextComponent titleComp = new TextComponent();
      titleComp.setBold(Boolean.valueOf(true));
      for (ProxiedPlayer p1 : ProxyServer.getInstance().getPlayers()) {
    	  if (p1.getName().equals("InVisTeK_") || p1.getName().equals("iFvhd") || p1.getName().equals("abdulloh") || p1.getName().equals("Bskwet") || p1.getName().equals("xXM7mo0odXx") || p1.getName().equals("SqlM7md") || p1.getName().equals("Jonsss")) {
			  if (p.getServer().getInfo().getName().equals("SkyPvP")) {
    	            p1.sendMessage(new TextComponent("§8❘ §7SP §8❘ §4TeamChat §8❘ §f" + p.getName() + " §8» §f" + Arabic.changeArabic(message)));
  			  } else if (p.getServer().getInfo().getName().equals("RedstonePvP")) {
    	            p1.sendMessage(new TextComponent("§8❘ §7RP §8❘ §4TeamChat §8❘ §f" + p.getName() + " §8» §f" + Arabic.changeArabic(message)));
  			  } else if (p.getServer().getInfo().getName().equals("FFA")) {
  	            p1.sendMessage(new TextComponent("§8❘ §7FFA §8❘ §4TeamChat §8❘ §f" + p.getName() + " §8» §f" + Arabic.changeArabic(message)));
			  } else if (p.getServer().getInfo().getName().equals("GunGame")) {
    	            p1.sendMessage(new TextComponent("§8❘ §7GG §8❘ §4TeamChat §8❘ §f" + p.getName() + " §8» §f" + Arabic.changeArabic(message)));
  			  } else if (p.getServer().getInfo().getName().equals("Hub")) {
      	            p1.sendMessage(new TextComponent("§8❘ §7Hub §8❘ §4TeamChat §8❘ §f" + p.getName() + " §8» §f" + Arabic.changeArabic(message)));
  			  } else {
    	            p1.sendMessage(new TextComponent("§8❘ §7UK §8❘ §4TeamChat §8❘ §f" + p.getName() + " §8» §f" + Arabic.changeArabic(message)));
  			  }
    	  } else {
    		  
    	  }
      }
      
    }
  }
}