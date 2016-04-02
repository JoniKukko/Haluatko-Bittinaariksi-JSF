package test;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.*;


public class mysql {

    public static void main(String[] argv) {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("HBJSF");
        dataSource.setPassword("HBJSF");
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("HBJSF");

        try {
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM question");

            while (rs.next()) {
                System.out.println(rs.getString(3));
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception ex)
        {
            System.out.println("VIRHE " + ex.getMessage());
        }
    }
}
