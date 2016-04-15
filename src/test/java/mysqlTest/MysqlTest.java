package mysqlTest;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by VMhomeUser on 15.4.2016.
 */
public class MysqlTest {

    private MysqlDataSource dataSource;



    @Before
    public void setUp() throws Exception
    {
        this.dataSource = new MysqlDataSource();
        this.dataSource.setUser("HBJSF");
        this.dataSource.setPassword("HBJSF");
        this.dataSource.setServerName("localhost");
        this.dataSource.setDatabaseName("HBJSF");
    }


    @Test
    public void getQuestions() throws Exception
    {
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
