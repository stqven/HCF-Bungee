package le.inv.ho;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.md_5.bungee.BungeeCord;

public class msgsql {
  public static Connection Conn;
  
  public static boolean isClosed() {
    return Conn == null;
  }
  
  public static boolean isConnected() {
    return Conn != null;
  }
  
  public static void connect() {
    try {
      Conn = DriverManager.getConnection("jdbc:mysql://eu.sql.titannodes.com:3306/" + "s6510_counters" + "?autoReconnect=true", "u6510_CLVzNKCHjv", "xsNpQ0+MU1xTxV1Y7stvJ!ui");
      BungeeCord.getInstance().getConsole().sendMessage("§aMsgSQL Connected!");
    } catch (SQLException e) {
      Conn = null;
      BungeeCord.getInstance().getConsole().sendMessage("§cMsgSQL Error!");
    }
  }
  
  public static String getIDPlayer(String ID) {
	     ResultSet Result = getResult("SELECT * FROM Players WHERE PID='" + ID + "'");
	     try {
	       if (Result.next()) {
	         return Result.getString("Name");
	       }
	     }
	     catch (SQLException localSQLException) {}
	   return null;
	}
  
  public static int getLastID(String Name) {
	      ResultSet Result = getResult("SELECT * FROM Players WHERE Name='" + Name + "'");
	      try {
	        if (Result.next()) {
	          return Result.getInt("LastID");
	        }
	      }
	      catch (SQLException localSQLException) {}
	    return 0;
  }
  
  public static int getPlayerID(String Name) {
      ResultSet Result = getResult("SELECT * FROM Players WHERE Name='" + Name + "'");
      try {
        if (Result.next()) {
          return Result.getInt("PID");
        }
      }
      catch (SQLException localSQLException) {}
    return 0;
}
  
  public static String getMessage(int ID) {
      ResultSet Result = getResult("SELECT * FROM Messaging WHERE ID='" + ID + "'");
      try {
        if (Result.next()) {
          return Result.getString("Message");
        }
      }
      catch (SQLException localSQLException) {}
    return null;
}
  public static String getMessageSender(int ID) {
      ResultSet Result = getResult("SELECT * FROM Messaging WHERE ID=" + ID);
      try {
        if (Result.next()) {
          return Result.getString("Name");
        }
      }
      catch (SQLException localSQLException) {}
    return null;
}
  
  public static int getIDMessage(String msg) {
      ResultSet Result = getResult("SELECT * FROM Messaging WHERE Message='" + msg + "'");
      try {
        if (Result.next()) {
          return Result.getInt("ID");
        }
      }
      catch (SQLException localSQLException) {}
    return 0;
}
  
  public static ArrayList<String> getLastMessages(String Name, int Limit) {
	    ArrayList<String> messages = new ArrayList();
	    if (exists(Name)) {
		    ResultSet Result = getResult("SELECT * FROM Messaging WHERE Name='" + Name + "' ORDER BY ID desc LIMIT " + Limit);
		    try {
		      while (Result.next()) {
		        messages.add(Result.getString("Message"));
		      }
		    } catch (SQLException localSQLException) {}
	    }
	    return messages;
}
  
  public static boolean exists(String Name) {
	    ResultSet Result = getResult("SELECT * FROM Players WHERE Name='" + Name + "'");
	    try {
	      if (Result.next()) {
	        return true;
	      }
	    }
	    catch (SQLException localSQLException) {}
	    return false;
}
  
  public static boolean existsMessage(int ID) {
	    ResultSet Result = getResult("SELECT * FROM Messaging WHERE ID='" + ID + "'");
	    try {
	      if (Result.next()) {
	        return true;
	      }
	    }
	    catch (SQLException localSQLException) {}
	    return false;
}
  
  public static void setLastID(String Name, int ID) {
	  if (exists(Name)) {
	      update("UPDATE Players SET LastID='" + ID + "' WHERE Name='" + Name + "'");
	  }
  }
  
  public static void addMessage(String Name, String msg) {
	  if (exists(Name)) {
		  int lid = getLastID(Name);
	      update("INSERT INTO Messaging (Name, ID, Message) VALUES ('" + Name + "', '" + (Integer.toString(getPlayerID(Name)) + Integer.toString((lid + 1))) + "', '" + msg + "');");
	      setLastID(Name, (lid + 1));
	  }
  }
  
  public static void addPlayer(String Name) {
	  if (!exists(Name)) {
	      update("INSERT INTO Players (Name, PID, LastID) VALUES ('" + Name + "', '" + Main.getRandom(1000, 99999)+ "', 0);");
	  }
  }
  
  public static void close() {
    try {
      Conn.close();
      BungeeCord.getInstance().getConsole().sendMessage("§aMsgSQL Connection closed successfuly");
    } catch (SQLException e) {
      Conn = null;
      BungeeCord.getInstance().getConsole().sendMessage("§cFaild to close MsgSQL connection");
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
