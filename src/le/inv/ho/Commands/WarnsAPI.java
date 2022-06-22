package le.inv.ho.Commands;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import le.inv.ho.msgsql;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class WarnsAPI {
	
	public static void barnPlayer(String id, String reason, long time, String by, String barnid, String eve) {
		if (isWarned(id)) {
			changeLastWarn(id, reason, time);
		} else {
			ProxiedPlayer t = BungeeCord.getInstance().getPlayer(msgsql.getIDPlayer(id));
			if (t != null) {
			      msgsql.update("INSERT INTO hozex_warns (ID, Reason, Time, Date, Moderator, WarnID, Server, Evedence, Unbarn) VALUES ('" + id + "', '" + reason + "', '" + (System.currentTimeMillis() + time) + "', '" + System.currentTimeMillis() + "', '" + by + "', '" + barnid + "', '" + t.getServer().getInfo().getName() + "', '" + eve + "', '-');");
			} else {
			      msgsql.update("INSERT INTO hozex_warns (ID, Reason, Time, Date, Moderator, WarnID, Server, Evedence, Unbarn) VALUES ('" + id + "', '" + reason + "', '" + (System.currentTimeMillis() + time) + "', '" + System.currentTimeMillis() + "', '" + by + "', '" + barnid + "', '" + "-" + "', '" + eve + "', '-');");
			}	
		}
	}
	
	public static void unbarnPlayer(String id, String pname) {
		if (isWarned(id)) {
			  msgsql.update("UPDATE hozex_warns SET Unbarn='" + pname + "' WHERE Date='" + getDates(id, 1).get(0) + "'");
		}
	}
	
	public static void removeUnbarnPlayer(String id) {
		  msgsql.update("UPDATE hozex_warns SET Unbarn='-' WHERE Date='" + getDates(id, 1).get(0) + "'");
	}
	
	public static void removeWarn(String id, long date) {
		msgsql.update("DELETE FROM hozex_warns WHERE Date='" + date + "'");
	}
	
	  public static ArrayList<String> getReasons(String id, int limit) {
		    ArrayList<String> reason = new ArrayList();
		    ResultSet Result;
		    if (limit == -1) {
			    Result = msgsql.getResult("SELECT * FROM hozex_warns WHERE ID='" + id + "' ORDER BY Date desc LIMIT 100");	
		    } else {
			    Result = msgsql.getResult("SELECT * FROM hozex_warns WHERE ID='" + id + "' ORDER BY Date desc LIMIT " + limit);
		    }
		    try {
		      while (Result.next()) {
		        reason.add(Result.getString("Reason"));
		      }
		    } catch (SQLException localSQLException) {}
		    return reason;
	}
	  
	  public static ArrayList<String> getTime(String id, int limit) {
		    ArrayList<String> time = new ArrayList();
		    ResultSet Result;
		    if (limit == -1) {
			    Result = msgsql.getResult("SELECT * FROM hozex_warns WHERE ID='" + id + "' ORDER BY Date desc LIMIT 100");	
		    } else {
			    Result = msgsql.getResult("SELECT * FROM hozex_warns WHERE ID='" + id + "' ORDER BY Date desc LIMIT " + limit);
		    }
		    try {
		      while (Result.next()) {
		        time.add(Result.getString("Time"));
		      }
		    } catch (SQLException localSQLException) {}
		    return time;
	}
	  
	  public static ArrayList<String> getModerators(String id, int limit) {
		    ArrayList<String> time = new ArrayList();
		    ResultSet Result;
		    if (limit == -1) {
			    Result = msgsql.getResult("SELECT * FROM hozex_warns WHERE ID='" + id + "' ORDER BY Date desc LIMIT 100");	
		    } else {
			    Result = msgsql.getResult("SELECT * FROM hozex_warns WHERE ID='" + id + "' ORDER BY Date desc LIMIT " + limit);
		    }
		    try {
		      while (Result.next()) {
		        time.add(Result.getString("Moderator"));
		      }
		    } catch (SQLException localSQLException) {}
		    return time;
	}
	  
	  public static ArrayList<String> getUnbarn(String id, int limit) {
		    ArrayList<String> time = new ArrayList();
		    ResultSet Result;
		    if (limit == -1) {
			    Result = msgsql.getResult("SELECT * FROM hozex_warns WHERE ID='" + id + "' ORDER BY Date desc LIMIT 100");	
		    } else {
			    Result = msgsql.getResult("SELECT * FROM hozex_warns WHERE ID='" + id + "' ORDER BY Date desc LIMIT " + limit);
		    }
		    try {
		      while (Result.next()) {
		        time.add(Result.getString("Unbarn"));
		      }
		    } catch (SQLException localSQLException) {}
		    return time;
	}
	  
	  public static ArrayList<String> getWarnIDs(String id, int limit) {
		    ArrayList<String> time = new ArrayList();
		    ResultSet Result;
		    if (limit == -1) {
			    Result = msgsql.getResult("SELECT * FROM hozex_warns WHERE ID='" + id + "' ORDER BY Date desc LIMIT 100");	
		    } else {
			    Result = msgsql.getResult("SELECT * FROM hozex_warns WHERE ID='" + id + "' ORDER BY Date desc LIMIT " + limit);
		    }
		    try {
		      while (Result.next()) {
		        time.add(Result.getString("WarnID"));
		      }
		    } catch (SQLException localSQLException) {}
		    return time;
	}
	  
	  public static ArrayList<String> getServers(String id, int limit) {
		    ArrayList<String> time = new ArrayList();
		    ResultSet Result;
		    if (limit == -1) {
			    Result = msgsql.getResult("SELECT * FROM hozex_warns WHERE ID='" + id + "' ORDER BY Date desc LIMIT 100");	
		    } else {
			    Result = msgsql.getResult("SELECT * FROM hozex_warns WHERE ID='" + id + "' ORDER BY Date desc LIMIT " + limit);
		    }
		    try {
		      while (Result.next()) {
		        time.add(Result.getString("Server"));
		      }
		    } catch (SQLException localSQLException) {}
		    return time;
	}
	
	  public static ArrayList<String> getDates(String id, int limit) {
		    ArrayList<String> date = new ArrayList();
		    ResultSet Result;
		    if (limit == -1) {
			    Result = msgsql.getResult("SELECT * FROM hozex_warns WHERE ID='" + id + "' ORDER BY Date desc LIMIT 100");	
		    } else {
			    Result = msgsql.getResult("SELECT * FROM hozex_warns WHERE ID='" + id + "' ORDER BY Date desc LIMIT " + limit);
		    }
		    try {
		      while (Result.next()) {
		        date.add(Result.getString("Date"));
		      }
		    } catch (SQLException localSQLException) {}
		    return date;
	}
	  
	  public static ArrayList<String> getEvedences(String id, int limit) {
		    ArrayList<String> evedence = new ArrayList();
		    ResultSet Result;
		    if (limit == -1) {
			    Result = msgsql.getResult("SELECT * FROM hozex_warns WHERE ID='" + id + "' ORDER BY Date desc LIMIT 100");	
		    } else {
			    Result = msgsql.getResult("SELECT * FROM hozex_warns WHERE ID='" + id + "' ORDER BY Date desc LIMIT " + limit);
		    }
		    try {
		      while (Result.next()) {
		        evedence.add(Result.getString("Evedence"));
		      }
		    } catch (SQLException localSQLException) {}
		    return evedence;
	}
	  
	  public static void changeLastWarn(String id, String reason, long time) {
		  if (isWarned(id)) {
			  long oldtime = Long.valueOf(getTime(id, 1).get(0));
			  if (reason != null) {
				  msgsql.update("UPDATE hozex_warns SET Reason='" + reason + "' WHERE Time='" + oldtime + "'");
			  }
			  if (time != -1) {
				  msgsql.update("UPDATE hozex_warns SET Time='" + (System.currentTimeMillis() + time) + "' WHERE Time='" + oldtime + "'");  
			  }
		  }
	  }
	  public static boolean isWarned(String id) {
		  if (isListed(id)) {
			  if (!getUnbarn(id, 1).get(0).equals("-")) return false;
			  if (Long.valueOf(getTime(id, 1).get(0)) >= System.currentTimeMillis()) {
				  return true;
			  } else {
				  return false;
			  }
		  } else {
			  return false;
		  }
	  }
	  
	  public static boolean isListed(String id) {
		    ResultSet Result = msgsql.getResult("SELECT * FROM hozex_warns WHERE ID='" + id + "'");
		    try {
		      if (Result.next()) {
		        return true;
		      }
		    }
		    catch (SQLException localSQLException) {}
		    return false;
	}
	  
	  public static int countWarns(String id) {
		  if (isListed(id)) {
			  return getReasons(id, 100).size();
		  } else {
			  return 0;
		  }
	  }
}
