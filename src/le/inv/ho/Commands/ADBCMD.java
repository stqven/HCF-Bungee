package le.inv.ho.Commands;

import java.io.File;
import java.io.IOException;
import java.util.List;

import le.inv.ho.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class ADBCMD extends Command {
	private Main bcb;
	public ADBCMD() {
		super("bvb");
		this.bcb = bcb;
	}
	
	@Override
	public void execute(CommandSender sender, String[] args) {
		  File file = new File(bcb.getDataFolder().getPath(), "bvb.yml");
		  
		    if (args.length == 0) {
		      sender.sendMessage("§cYou must add a message!");
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
		      
		      TextComponent titleComp = new TextComponent();
		      titleComp.setBold(Boolean.valueOf(true));
		      
				try {
					Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
					List<String> list = (List<String>) config.getList("list");
					list.add(message);
					config.set("list", list);
				} catch (IOException e) {
					e.printStackTrace();
				}
		      
		    }
	}

}
