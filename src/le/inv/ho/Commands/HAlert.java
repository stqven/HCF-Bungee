package le.inv.ho.Commands;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import le.inv.ho.API;
import le.inv.ho.Arabic;
import le.inv.ho.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.Title;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class HAlert extends Command {
	  private Main bcb;
	  
	  public HAlert(Main bcb) {
		    super("announcer", "hozex.alert", new String[] { "alert" });
		    this.bcb = bcb;
		  }
  
  public void execute(CommandSender sender, String[] args) {
	  File file = new File(bcb.getDataFolder().getPath(), "alert.yml");
    if (args.length == 0) {
        sender.sendMessage("§8❘ §cHozexMC §8❘ §7You must say something.");
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
      
      Title title = ProxyServer.getInstance().createTitle();
      
      TextComponent titleComp = new TextComponent();
      titleComp.setBold(Boolean.valueOf(true));
      for (ProxiedPlayer p1 : ProxyServer.getInstance().getPlayers()) {
    	  if (p1.hasPermission("H.Owner") || p1.hasPermission("H.HeadAdmin") || p1.hasPermission("H.Admin") || p1.hasPermission("H.SrMod") || p1.hasPermission("H.Developer")) {
        	  p1.sendMessage(API.getHoverMessage("§8❘ §6Hozex§eMC §8❘ §7" + Arabic.changeArabic(message), "§eMessage by:§f" + sender.getName()));
      } else {
    	  p1.sendMessage("§8❘ §6Hozex§eMC §8❘ §7" + Arabic.changeArabic(message));
      }
      
      
      TextComponent titleSubComp = new TextComponent(message);
      
      
      title.title(titleComp);
      title.subTitle(titleSubComp);
      
      title.fadeIn(40);
      title.stay(100);
      title.fadeOut(40);
      
      
		try {
			Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
			if (config.getBoolean("title") == true) {
			      for (ProxiedPlayer proxplayer : ProxyServer.getInstance().getPlayers()) {
			    	  ArrayList<String> tl = new ArrayList<String>(Arrays.asList(title.toString().split(" ")));
			    	  if (tl.size() > 5) {
			    	      Title ititle = ProxyServer.getInstance().createTitle();
			    	      
			    	      TextComponent titleSubCompa = new TextComponent("§8« §b§lIMPORTANT ALERT §8»");
			    	      TextComponent titleCompa = new TextComponent();
			    	      
			    	      titleComp.setBold(Boolean.valueOf(true));
			    	      ititle.title(titleCompa);
			    	      ititle.subTitle(titleSubCompa);
			    	      
			    	      ititle.fadeIn(40);
			    	      ititle.stay(100);
			    	      ititle.fadeOut(40);
				          proxplayer.sendTitle(ititle);
			    	  } else {
				          proxplayer.sendTitle(title);
			    	  }
			      }
			        }
		} catch (IOException e) {
			e.printStackTrace();
		}
      }
    }
  }
}
