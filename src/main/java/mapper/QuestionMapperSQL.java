package mapper;

import interfaces.IQuestionMapper;
import model.Answer;
import model.Question;

import java.sql.*;



public class QuestionMapperSQL implements IQuestionMapper
{
    private Connection conn;



    public QuestionMapperSQL()
    {
        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost/HBJSF", "HBJSF", "HBJSF");
        } catch (SQLException ex)
        {
            System.out.println("SQLEXception " + ex.getMessage());
        }
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
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // haetaan yhteys ja suoritetaan kysely
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
        }

        return newQuestion;
    }



    private Question addAnswers(Question question)
    {
        // alustukset
        String queryString = "SELECT * FROM answer WHERE QuestionId = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // haetaan yhteys ja suoritetaan kysely
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
        }

        return question;
    }
}

