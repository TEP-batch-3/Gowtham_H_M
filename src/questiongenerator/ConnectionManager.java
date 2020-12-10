package questiongenerator;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.*;



public class ConnectionManager {
	public static void closeConnection(Connection con)
	{
		try
		{
			if(con != null)
				con.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection()
	{
		Connection conn = null;
		String rootPath = null;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			ConnectionManager db = new ConnectionManager();
			String path = db.getPath();
			rootPath = path+"MyDB";
			conn= DriverManager.getConnection("jdbc:derby:"+rootPath+";create=true","iquest","");
		//	System.out.println(conn.toString());		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public String getPath() throws IOException {
		String path = this.getClass().getClassLoader().getResource("").getPath();
		String fullPath = URLDecoder.decode(path, "UTF-8");
		String rootPath = fullPath.replace(".metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/","");
		rootPath = rootPath.replace("WEB-INF/classes/","WebContent/WEB-INF/");
		rootPath = rootPath.replace("/","\\").substring(1);
	//	System.out.println("rootPath :"+rootPath);
		return rootPath;
		/*String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		System.out.println("rootPath :"+rootPath);
		rootPath = rootPath.replace("classes/", "");
		System.out.println("rootPath1 :"+rootPath);
		return rootPath;*/
}
}
