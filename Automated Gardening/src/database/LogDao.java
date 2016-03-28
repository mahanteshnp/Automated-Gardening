package database;

import java.util.List;

public interface LogDao {
	
	
	public Log addLog(Log log);
	public List<Log> getAllLogs(String path);
	public List<Log> getLogs(String path, int day);
	
	public void deleteLogs();
}
