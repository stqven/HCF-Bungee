package le.inv.ho.Commands;

import java.io.PrintStream;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class PremiumCommand extends Command {
  public PremiumCommand() {
    super("prem");
  }
  
  public void execute(CommandSender sender, String[] args) {
      sender.sendMessage("§8┃ §6HozexMC §8┃ §8§m---------------§r  §c§lPremium §r§8§m---------------");
      sender.sendMessage("§8┃ §6HozexMC §8┃ §6What do I get");
      sender.sendMessage("§8┃ §6HozexMC §8┃ §eFly in the lobbies");
      sender.sendMessage("§8┃ §6HozexMC §8┃ §eSpecial kits in PvP games");
      sender.sendMessage("§8┃ §6HozexMC §8┃ §eSpacial cosmetics in lobby");
      sender.sendMessage("§8┃ §6HozexMC §8┃ §eOther futures");
      sender.sendMessage("§8┃ §6HozexMC §8┃");
      sender.sendMessage("§8┃ §6HozexMC §8┃ §eHow do I get a rank? you could buy any of them by the links below");
      sender.sendMessage("§8┃ §6HozexMC §8┃");
      sender.sendMessage("§8┃ §6HozexMC §8┃ §6Discord §ediscord.gg/3DAgcZb");
      sender.sendMessage("§8┃ §6HozexMC §8┃ §6Link §eHozexMC.com");
      sender.sendMessage("§8┃ §6HozexMC §8┃ §6Email §eHozexMC@Gmail.com");
      sender.sendMessage("§8┃ §6HozexMC §8┃");
      sender.sendMessage("§8┃ §6HozexMC §8┃ §bSawa/PayPal/CashU");
      sender.sendMessage("§8┃ §6HozexMC §8┃ §6Gold: §b15 Sawa §8/ §b2$");
      sender.sendMessage("§8┃ §6HozexMC §8┃ §bDiamond: §b30 Sawa §8/§b 5$");
      sender.sendMessage("§8┃ §6HozexMC §8┃ §aEmerald§6: §b50 Sawa §8/§b 8$");
      sender.sendMessage("§8┃ §6HozexMC §8┃ §cMod: §b120 Sawa §8/§b 12$");
      sender.sendMessage("§8┃ §6HozexMC §8┃ §8§m-----------------------------------------");
  }
}
