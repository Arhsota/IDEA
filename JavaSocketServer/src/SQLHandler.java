import java.sql.*;

public class SQLHandler {

    private static Connection c;
    private static PreparedStatement ps;

    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:maindb.db");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        try {
            if (c != null && !c.isClosed()) {
                c.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getNickByLoginAndPassword(String login, String password) {
        ResultSet rs;
        String str = null;
        try {
            ps = c.prepareStatement("SELECT Nickname FROM Main WHERE Login = ? AND Password = ?");
            ps.setString(1, login);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                str = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static void addEntry(String login, String pass, String nick) {
        try {
            ps = c.prepareStatement("INSERT INTO Main (Login, Password, Nickname) VALUES (?, ?, ?);");
            ps.setString(1, login);
            ps.setString(2, pass);
            ps.setString(3, nick);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
