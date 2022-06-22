package le.inv.ho.Commands;

import le.inv.ho.API;
import le.inv.ho.Main;
import le.inv.ho.mysql;
import net.md_5.bungee.PlayerInfoSerializer;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Verify extends Command {
    private Main bcb;

    public Verify(Main bcb) {
        super("chat");
        this.bcb = bcb;
    }
    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer p = (ProxiedPlayer) sender;
        if (args.length == 0) {
            if (getLinked(p.getName()) == null) {
                p.sendMessage("§8❘ §eHozexMC §8❘ §7§7type §e!verify §7at §9Discord §7server to get the code");
                p.sendMessage("§8❘ §eHozexMC §8❘ §7§7Then run §e/verify [code]");
            } else {
                p.sendMessage("§8❘ §cHozexMC §8❘ §7Your account is already connected to discord");
            }
        } else {
            String code = args[0];
            if (getLinked(p.getName()) == null) {
                if (getCode(code) != null) {
                    p.sendMessage("§8❘ §aHozexMC §8❘ §7You have successfully connected your minecraft account to discord");
                    linkPlayer(p.getName(), getCode(code));
                    deleteCode(code);
                } else {
                    p.sendMessage("§8❘ §cHozexMC §8❘ §7This code doesn't exist please make sure this is the right one");
                }
            } else {
                p.sendMessage("§8❘ §cHozexMC §8❘ §7Your account is already connected to discord");
            }
        }
    }

    public static String getLinked(String pname) {
        ResultSet Result = mysql.getResult("SELECT * FROM link WHERE IGN='" + pname + "'");
        try {
            if (Result.next()) {
                return Result.getString("Discord_ID");
            }
        }
        catch (SQLException sQLException) {
            return null;
        }
        return null;
    }

    public static String getCode(String code) {
        ResultSet Result = mysql.getResult("SELECT * FROM Verification WHERE code='" + code + "'");
        try {
            if (Result.next()) {
                return Result.getString("discord_id");
            }
        } catch (SQLException sQLException) {
            return null;
        }
        return null;
    }

    public static void linkPlayer(String name, String discordID) {
        if (getLinked(name) == null) {
            mysql.update("INSERT INTO `link` (`IGN`, `Discord_ID`) VALUES ('" + name + "', '" + discordID + "')");
            mysql.update("INSERT INTO `PInfo` (`Rank`, `Discord_ID`, `IGN`) VALUES ('" + API.getPrimaryGroup(name) + "', '" + discordID + "', '" + name + "')");
        } else {
            mysql.update("UPDATE link SET IGN='" + name + "', Discord_ID='" + discordID + "' WHERE IGN='" + name + "'");
        }
    }

    public static void deleteCode(String code) {
        if (getCode(code) != null) {
            mysql.update("DELETE FROM Verification WHERE code='" + code + "'");
        }
    }
}
