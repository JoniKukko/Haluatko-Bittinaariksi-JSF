package mapper;



import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import model.Answer;
import model.Question;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class QuestionMapperSQL implements IQuestionMapper
{
    private MysqlDataSource dataSource;



    public QuestionMapperSQL() throws Exception
    {
        this.dataSource = new MysqlDataSource();
        this.dataSource.setUser("HBJSF");
        this.dataSource.setPassword("HBJSF");
        this.dataSource.setServerName("localhost");
        this.dataSource.setDatabaseName("HBJSF");
    }



    public Question getRandomQuestionByLevel(int level)
    {
        Question newQuestion = this.getQuestion(level);
        newQuestion = this.addAnswers(newQuestion);
        return newQuestion;
    }



    private Question getQuestion(int level)
    {
        // alustukset
        String queryString = "SELECT * FROM question WHERE level = ? ORDER BY RAND() LIMIT 1";
        Question newQuestion = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // haetaan yhteys ja suoritetaan kysely
            conn = this.dataSource.getConnection();
            stmt = conn.prepareStatement(queryString);
            stmt.setInt(1, level);
            rs = stmt.executeQuery();

            // build question
            while (rs.next()) {
                newQuestion = new Question(
                        rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4)
                );
            }

        } catch (Exception ex) {
            System.out.println("VIRHE: " + ex.getMessage());
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }

        return newQuestion;
    }



    private Question addAnswers(Question question)
    {
        // alustukset
        String queryString = "SELECT * FROM answer WHERE QuestionId = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // haetaan yhteys ja suoritetaan kysely
            conn = this.dataSource.getConnection();
            stmt = conn.prepareStatement(queryString);
            stmt.setInt(1, question.getQuestionId());
            rs = stmt.executeQuery();

            // build answers
            while (rs.next()) {
                question.addAnswer(new Answer(
                        rs.getInt(1), rs.getInt(2), rs.getString(3)
                ));
            }

        } catch (Exception ex) {
            System.out.println("VIRHE: " + ex.getMessage());
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }

        return question;
    }
}
