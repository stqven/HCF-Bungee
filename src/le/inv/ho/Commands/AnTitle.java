package le.inv.ho.Commands;

import java.io.File;
import java.io.IOException;

import le.inv.ho.Main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class AnTitle extends Command {
	  private Main bcb;
	  
	  public AnTitle(Main bcb) {
		    super("ant", "hozex.alert", new String[] { "alt" });
		    this.bcb = bcb;
		  }
  
  public void execute(CommandSender sender, String[] args) {
	  File file = new File(bcb.getDataFolder().getPath(), "alert.yml");
	  ProxiedPlayer p = (ProxiedPlayer) sender;
	  if (args.length == 0) {
		  p.sendMessage("§8❘ §cHozexMC §8❘ §7/ant [true | false]");
		  
	  } else if (args.length == 1) {
		  if (args[0].equalsIgnoreCase("true")) {
			  try {
				  Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
				  config.set("title", true);
				  ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
				  p.sendMessage("§8❘ §cHozexMC §8❘ §7Alert title has been toggled §8(§aTrue§8)");
			  } catch (IOException e) {
				  e.printStackTrace();
			  }
		  } else if (args[0].equalsIgnoreCase("false")) {
			  try {
				  Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
				  config.set("title", false);
				  ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
				  p.sendMessage("§8❘ §cHozexMC §8❘ §7Alert title has been toggled §8(§cFalse§8)");
			  } catch (IOException e) {
				  e.printStackTrace();
			  }
		  } else {
			  p.sendMessage("§8❘ §cHozexMC §8❘ §7/ant [true | false]");
		  }
	  } else {
		  
	  }
  }
}
