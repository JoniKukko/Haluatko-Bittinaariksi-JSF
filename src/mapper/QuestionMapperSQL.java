package mapper;



import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import model.Question;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;



public class QuestionMapperSQL implements IQuestionMapper
{
    private MysqlDataSource dataSource;



    public QuestionMapperSQL()
    {
        this.dataSource = new MysqlDataSource();
        this.dataSource.setUser("HBJSF");
        this.dataSource.setPassword("HBJSF");
        this.dataSource.setServerName("localhost");
        this.dataSource.setDatabaseName("HBJSF");
    }



    public Question getRandomQuestionByLevel(int level)
    {
        Question newQuestion = new Question();

        try
        {
            Connection conn = this.dataSource.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM question");



            while (rs.next()) {
                System.out.println(rs.getString(3));
            }


            rs.close();
            stmt.close();
            conn.close();
        }
        catch (Exception ex)
        {
            System.out.println("VIRHE " + ex.getMessage());
        }

        return newQuestion;
    }
}
