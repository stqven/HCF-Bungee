package le.inv.ho;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.md_5.bungee.BungeeCord;

public class mysql {
  public static Connection Conn;
  
  public static boolean isClosed() {
    return Conn == null;
  }
  
  public static boolean isConnected() {
    return Conn != null;
  }
  
  public static void connect() {
    try {
      Conn = DriverManager.getConnection("jdbc:mysql://eu.sql.titannodes.com:3306/" + Main.datebase + "?autoReconnect=true", Main.User, Main.pss);
      BungeeCord.getInstance().getConsole().sendMessage("§aMySQL Connected!");
    } catch (SQLException e) {
      Conn = null;
      BungeeCord.getInstance().getConsole().sendMessage("§cMySQL Error!");
    }
  }
  
  public static void close() {
    try {
      Conn.close();
      BungeeCord.getInstance().getConsole().sendMessage("§aMySQL Connection closed successfuly");
    } catch (SQLException e) {
      Conn = null;
      BungeeCord.getInstance().getConsole().sendMessage("§cFaild to close MySQL connection");
    }
  }
  
  public static void update(String Query) {
    try {
      PreparedStatement P = Conn.prepareStatement(Query);
      P.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  public static ResultSet getResult(String Query) {
	    try {
	      PreparedStatement P = Conn.prepareStatement(Query);
	      return P.executeQuery();
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return null;
	  }
}
