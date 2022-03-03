package Project2;

import java.math.MathContext;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import net.proteanit.sql.DbUtils;


public class DBhandler {

    public static String currentStudentName;
    public static int currentStudentID;
    public static int currentFuzzyQuestionNumber = 0;
    public static int currentMChoiceQuestionNumber = 0;
    public static List<Integer> fuzzyQuestions = new ArrayList<Integer>();
    public static List<Integer> multiChoiceQuestions = new ArrayList<Integer>();
    public static double randomNumber = Math.random() * 13;

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/abdSchema", "root", "1234");
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }

        return conn;
    }

    public static void insertStudentInfo(WelcomeFrame wf) {

        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            int result = 0;
            if (wf.getScientificRadioButton().isSelected()) {

                result = stmt.executeUpdate("INSERT INTO `student`"
                        + "(studentName, studentTotalMark, mathMark, physicsMark, chemistryMark, naturalScienceMark, arabicMark, englishMark, historyMark, geographyMark, gender, year)"
                        + " values('" + (wf.getStudentNameTexField().getText()) + "','" + wf.calculateTotalMark() + "',"
                        + " '" + Integer.parseInt(wf.getMathMark().getText()) + "', '" + Integer.parseInt(wf.getPhysicsMark().getText()) + "',"
                        + " '" + Integer.parseInt(wf.getChemistryMark().getText()) + "',"
                        + "'" + Integer.parseInt(wf.getNaturalScienceMark().getText()) + "',(NULL),(NULL),(NULL),(NULL), '" + wf.getGenderCombo().getSelectedItem() + "', '" + wf.getWfMofCombo().getSelectedItem() + "' )");
            } else if (wf.getLiteraryRadioButton().isSelected()) {

                result = stmt.executeUpdate("INSERT INTO `student`"
                        + "(studentName, studentTotalMark, mathMark, physicsMark, chemistryMark, naturalScienceMark, arabicMark, englishMark, historyMark, geographyMark, gender, year)"
                        + " values('" + (wf.getStudentNameTexField().getText()) + "','" + wf.calculateTotalMark() + "', (NULL),(NULL),(NULL),(NULL),"
                        + " '" + Integer.parseInt(wf.getArabicMark().getText()) + "', '" + Integer.parseInt(wf.getEnglishMark().getText()) + "',"
                        + " '" + Integer.parseInt(wf.getHistoryMark().getText()) + "',"
                        + "'" + Integer.parseInt(wf.getGeographyMark().getText()) + "', '" + wf.getGenderCombo().getSelectedItem() + "', '" + wf.getWfMofCombo().getSelectedItem() + "' )");
            }
            if (result == 1) {
                System.out.println("data inserted");
            } else {
                System.out.println("problem inserting data");
            }
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            for (Throwable t : e) {
                JOptionPane.showMessageDialog(null, "Exception.. please re-enter your info!");

                t.printStackTrace();
            }
        }

    }

    public static List<String> getCandidateColleges(int y, WelcomeFrame wf) {
        List<String> candidateColleges = new ArrayList<String>();
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();

            if (wf.getScientificRadioButton().isSelected()) {

                ResultSet rs = stmt.executeQuery("SELECT * FROM sci_mof WHERE `year` = '" + y + "'");
                while (rs.next()) {
                    if (Integer.parseInt(wf.getChemistryMark().getText()) >= rs.getInt("chemistryMinMark")
                            && wf.calculateTotalMark() >= rs.getInt("chemistryMinTotalMark")) {
                        candidateColleges.add("chemistry");
                    }
                    if (Integer.parseInt(wf.getMathMark().getText()) >= rs.getInt("mathMinMark")
                            && wf.calculateTotalMark() >= rs.getInt("mathMinTotalMark")) {
                        candidateColleges.add("math");
                    }
                    if (Integer.parseInt(wf.getPhysicsMark().getText()) >= rs.getInt("physicsMinMark")
                            && wf.calculateTotalMark() >= rs.getInt("physicsMinTotalMark")) {
                        candidateColleges.add("physics");
                    }
                    if (Integer.parseInt(wf.getNaturalScienceMark().getText()) >= rs.getInt("naturalScienceMinMark")
                            && wf.calculateTotalMark() >= rs.getInt("naturalScienceMinTotalMark")) {
                        candidateColleges.add("naturalScience");
                    }
                    if (Integer.parseInt(wf.getNaturalScienceMark().getText()) >= rs.getInt("medicineMinMark")
                            && wf.calculateTotalMark() >= rs.getInt("medicineMinTotalMark")) {
                        candidateColleges.add("medicine");
                    }

                }

            } else if (wf.getLiteraryRadioButton().isSelected()) {

                ResultSet rs = stmt.executeQuery("SELECT * FROM lit_mof WHERE `year` = '" + y + "'");
                while (rs.next()) {
                    if (Integer.parseInt(wf.getArabicMark().getText()) >= rs.getInt("arabicMinMark")
                            && wf.calculateTotalMark() >= rs.getInt("arabicMinTotalMark")) {
                        candidateColleges.add("arabic");
                    }
                    if (Integer.parseInt(wf.getEnglishMark().getText()) >= rs.getInt("englishMinMark")
                            && wf.calculateTotalMark() >= rs.getInt("englishMinTotalMark")) {
                        candidateColleges.add("english");
                    }
                    if (Integer.parseInt(wf.getHistoryMark().getText()) >= rs.getInt("historyMinMark")
                            && wf.calculateTotalMark() >= rs.getInt("historyMinTotalMark")) {
                        candidateColleges.add("history");
                    }
                    if (Integer.parseInt(wf.getGeographyMark().getText()) >= rs.getInt("geographyMinMark")
                            && wf.calculateTotalMark() >= rs.getInt("geographyMinTotalMark")) {
                        candidateColleges.add("geography");
                    }
                    if (Integer.parseInt(wf.getEnglishMark().getText()) >= rs.getInt("fineArtsMinMark")
                            && wf.calculateTotalMark() >= rs.getInt("fineArtsMinTotalMark")) {
                        candidateColleges.add("fineArts");
                    }

                }
            }
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }

        }
        System.out.println(candidateColleges);

        long seed = System.nanoTime();
//        Collections.shuffle(candidateColleges, new Random(seed));
        return candidateColleges;

    }

    public static int updateExistingMof(Mofadala m, int year) {
        boolean inserted = false;
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
//            int result = 0;
            if (m.getSciMofRadioButton().isSelected()) {
                int result = stmt.executeUpdate("UPDATE `sci_mof` SET `year` = '" + Integer.parseInt(m.getMofYearTextField().getText()) + "',"
                        + " `mathMinMark` = '" + Integer.parseInt(m.mathMof.getText()) + "', "
                        + "`mathMinTotalMark` = '" + Integer.parseInt(m.mathMofTotal.getText()) + "',"
                        + " `physicsMinMark` = '" + Integer.parseInt(m.physicsMof.getText()) + "',"
                        + " `physicsMinTotalMark` = '" + Integer.parseInt(m.physicsMofTotal.getText()) + "',"
                        + " `chemistryMinMark` = '" + Integer.parseInt(m.chemistryMof.getText()) + "', "
                        + "`chemistryMinTotalMark` = '" + Integer.parseInt(m.chemistryMofTotal.getText()) + "', "
                        + "`naturalScienceMinMark` = '" + Integer.parseInt(m.naturalMof.getText()) + "',"
                        + " `naturalScienceMinTotalMark` = '" + Integer.parseInt(m.naturalScienceMofTotal.getText()) + "', "
                        + "`medicineMinMark` = '" + Integer.parseInt(m.medicineMof.getText()) + "',"
                        + " `medicineMinTotalMark` = '" + Integer.parseInt(m.medicineMofTotal.getText()) + "' WHERE `year` = '" + year + "'");
                return year;
//                inserted = true;
            }
            if (inserted) {
                System.out.println("data updated");

            } else {
                System.out.println("problem updating data");
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }
        return year;
    }

    public static int insertMof(Mofadala m) {
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
//            int result = 0;
            if (m.getSciMofRadioButton().isSelected()) {
                int result = stmt.executeUpdate("INSERT INTO `sci_mof` (`year`, `mathMinMark`, `mathMinTotalMark`, `physicsMinMark`, `physicsMinTotalMark`, `chemistryMinMark`, `chemistryMinTotalMark`, `naturalScienceMinMark`, `naturalScienceMinTotalMark`, `medicineMinMark`, `medicineMinTotalMark`)"
                        + " VALUES ('" + Integer.parseInt(m.getMofYearTextField().getText()) + "', "
                        + "'" + Integer.parseInt(m.mathMof.getText()) + "', "
                        + "'" + Integer.parseInt(m.mathMofTotal.getText()) + "',"
                        + " '" + Integer.parseInt(m.physicsMof.getText()) + "',"
                        + " '" + Integer.parseInt(m.physicsMofTotal.getText()) + "',"
                        + " '" + Integer.parseInt(m.chemistryMof.getText()) + "', "
                        + " '" + Integer.parseInt(m.chemistryMofTotal.getText()) + "', "
                        + " '" + Integer.parseInt(m.naturalMof.getText()) + "',"
                        + "  '" + Integer.parseInt(m.naturalScienceMofTotal.getText()) + "', "
                        + "'" + Integer.parseInt(m.medicineMof.getText()) + "',"
                        + "  '" + Integer.parseInt(m.medicineMofTotal.getText()) + "')");

                return Integer.parseInt(m.getMofYearTextField().getText());

            } else if (m.getLitMofRadioButton().isSelected()) {
                int result = stmt.executeUpdate("INSERT INTO `lit_mof` (`year`, `arabicMinMark`, `arabichMinTotalMark`, `englishMinMark`, `englishMinTotalMark`, `historyMinMark`, `historyMinTotalMark`, `geographyMinMark`, `geographyMinTotalMark`, `fineArtsMinMark`, `fineArtsMinTotalMark`)"
                        + " VALUES ('" + Integer.parseInt(m.getMofYearTextField().getText()) + "', "
                        + "'" + Integer.parseInt(m.arabicMof.getText()) + "', "
                        + "'" + Integer.parseInt(m.arabicMofTotal.getText()) + "',"
                        + " '" + Integer.parseInt(m.englishMof.getText()) + "',"
                        + " '" + Integer.parseInt(m.englishMofTotal.getText()) + "',"
                        + " '" + Integer.parseInt(m.historyMof.getText()) + "', "
                        + " '" + Integer.parseInt(m.historyMofTotal.getText()) + "', "
                        + " '" + Integer.parseInt(m.geographyMof.getText()) + "',"
                        + "  '" + Integer.parseInt(m.geographyMofTotal.getText()) + "', "
                        + "'" + Integer.parseInt(m.fineArtsMof.getText()) + "',"
                        + "  '" + Integer.parseInt(m.fineArtsMofTotal.getText()) + "')");

                return Integer.parseInt(m.getMofYearTextField().getText());
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }
        return 0;
    }

    public static void insertStudentCollegeRank(int stdID, int clgID, float amt) {
//        boolean inserted = false;
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
//            int result = 0;
//            if (m.getSciMofRadioButton().isSelected()) {
            int result = stmt.executeUpdate("INSERT INTO `student_college` (studentID, collegeID, rank)"
                    + " VALUES ('" + stdID + "', '" + clgID + "', '" + amt + "')");
//                inserted = true;
//            }
//            if (inserted) {
//                System.out.println("data updated");

//            } else {
//                System.out.println("problem updating data");
//            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
//        }
//        return 0;

        }
    }

    public static List<Integer> getFuzzyQuestionsIDsArray(List<String> candidateCollegesArray) {
        List<Integer> questionsBrought = new ArrayList<Integer>();
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            // System.out.println(college);
//                if (!college.equalsIgnoreCase("")) {
            for (String college : candidateCollegesArray) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM `fuzzy_question` WHERE collegeName = '" + college + "'");
                while (rs.next()) {
                    questionsBrought.add((rs.getInt("questionID")));
                }
            }
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }
        System.out.println(questionsBrought);
        return questionsBrought;

    }

    public static List<Integer> getMultiChoiceQuestionsIDsArray(List<String> candidateCollegesArray) {
        List<Integer> questionsNeeded = new ArrayList<Integer>();

        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            // System.out.println(college);
//                if (!college.equalsIgnoreCase("")) {
            for (String college : candidateCollegesArray) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM `multi_choice_question` WHERE collegeName = '" + college + "'");
                while (rs.next()) {
                    questionsNeeded.add((rs.getInt("questionID")));
                }
            }
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }
        System.out.println(questionsNeeded);
        return questionsNeeded;

    }

    public static String[] getMultiChoiceQuestionByID(int id) {
        String[] s = new String[6];
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
//              Question q = new Question();
            // System.out.println(college);
//                if (!college.equalsIgnoreCase("")) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM `multi_choice_question` WHERE questionID = '" + id + "'");
            while (rs.next()) {
                s[0] = rs.getString("questionText");
                s[1] = rs.getString("option1");
                s[2] = rs.getString("option2");
                s[3] = rs.getString("option3");
                s[4] = rs.getString("correctOption");
                s[5] = rs.getString("collegeName");
//                q.getQuestionTextArea().setText(text);
            }

            stmt.close();
            conn.close();
//            JOptionPane.showMessageDialog(null, s[3]);
            for (String string : s) {
                System.out.println(string);
            }
            return s;

        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();

            }

        }

        return s;
    }

    public static String[] getMultiChoiceQuestionByText(String txt) {
        String[] s = new String[6];
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
//              Question q = new Question();
            // System.out.println(college);
//                if (!college.equalsIgnoreCase("")) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM `multi_choice_question` WHERE questionText = '" + txt + "'");
            while (rs.next()) {
                s[0] = rs.getString("questionText");
                s[1] = rs.getString("option1");
                s[2] = rs.getString("option2");
                s[3] = rs.getString("option3");
                s[4] = rs.getString("correctOption");
                s[5] = rs.getString("collegeName");
//                q.getQuestionTextArea().setText(text);
            }

            stmt.close();
            conn.close();
//            JOptionPane.showMessageDialog(null, s[3]);

            return s;

        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();

            }

        }

        return s;
    }

    public static String[] getFuzzyQuestionByID(int id) {
        String[] s = new String[2];
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
//              Question q = new Question();
            // System.out.println(college);
//                if (!college.equalsIgnoreCase("")) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM `fuzzy_question` WHERE questionID = '" + id + "'");
            while (rs.next()) {
                s[0] = rs.getString("questionText");
                s[1] = rs.getString("collegeName");
//                q.getQuestionTextArea().setText(text);
            }

            stmt.close();
            conn.close();
//            JOptionPane.showMessageDialog(null, s[3]);

            return s;

        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();

            }

        }

        return s;
    }

    public static String[] getFuzzyQuestionByText(String txt) {
        String[] s = new String[2];
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
//              Question q = new Question();
            // System.out.println(college);
//                if (!college.equalsIgnoreCase("")) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM `fuzzy_question` WHERE questionText = '" + txt + "'");
            while (rs.next()) {
                s[0] = rs.getString("questionText");
                s[1] = rs.getString("collegeName");
//                q.getQuestionTextArea().setText(text);
            }

            stmt.close();
            conn.close();
//            JOptionPane.showMessageDialog(null, s[3]);

            return s;

        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();

            }

        }

        return s;
    }

    public static int getStudentIDByName(String studentName) {
        int s = 0;
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            //   Question q = new Question();
            // System.out.println(college);
//                if (!college.equalsIgnoreCase("")) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM student WHERE studentName = '" + studentName + "'");
            while (rs.next()) {
                if (rs.isLast()) {
                    s = rs.getInt("studentID");
                    System.out.println(s);
                    return s;
                }

            }
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }

        }
        return s;
    }

    public static String getStudentGenderByID(int id) {
        String s = "";
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            //   Question q = new Question();
            // System.out.println(college);
//                if (!college.equalsIgnoreCase("")) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM student WHERE studentID = '" + id + "'");
            while (rs.next()) {
                    s = rs.getString("gender");
                    System.out.println(s);
                    return s;

            }
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }

        }
        return s;
    }
    
    public static int getDifficultyByMChoiceQID(int id) {
        int d = 0;
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
//              Question q = new Question();
            // System.out.println(college);
//                if (!college.equalsIgnoreCase("")) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM `multi_choice_question` WHERE questionID = '" + id + "'");
            if (rs.next()) {
                d = rs.getInt("difficulty");
                stmt.close();
                conn.close();
                System.out.println(d);
                return d;
            }

//            JOptionPane.showMessageDialog(null, s[3]);
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();

            }

        }

        return d;
    }

    public static int getCollegeIDByFuzzyQuestionID(int qID) {
        int clgID = 0;
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
//              Question q = new Question();
            // System.out.println(college);
//                if (!college.equalsIgnoreCase("")) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM `fuzzy_question` INNER JOIN "
                    + "                      `college` ON `fuzzy_question`.`collegeName` = `college`.`collegeName` WHERE questionID = '" + qID + "'");
            if (rs.next()) {
                clgID = rs.getInt("collegeID");
                System.out.println(clgID);
                return clgID;
//                q.getQuestionTextArea().setText(text);
            }

            stmt.close();
            conn.close();
//            JOptionPane.showMessageDialog(null, s[3]);

        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();

            }

        }
        return clgID;
    }

    public static int getCollegeIDByMChoiceQuestionID(int qID) {
        int clgID = 0;
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
//              Question q = new Question();
            // System.out.println(college);
//                if (!college.equalsIgnoreCase("")) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM `multi_choice_question` INNER JOIN "
                    + "                      `college` ON `multi_choice_question`.`collegeName` = `college`.`collegeName` WHERE questionID = '" + qID + "'");
            if (rs.next()) {
                clgID = rs.getInt("collegeID");
                System.out.println(clgID);
                return clgID;
//                q.getQuestionTextArea().setText(text);
            }

            stmt.close();
            conn.close();
//            JOptionPane.showMessageDialog(null, s[3]);

        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();

            }

        }
        return clgID;
    }

    public static List<Integer> getMofYears(String mofType) {
        List<Integer> s = new ArrayList<Integer>();
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
//              Question q = new Question();
            // System.out.println(college);
//                if (!college.equalsIgnoreCase("")) {
            if (mofType.equalsIgnoreCase("sci_mof")) {

                ResultSet rs = stmt.executeQuery("SELECT * FROM `sci_mof`");
                while (rs.next()) {
                    s.add(rs.getInt("year"));
                    //    System.out.println(rs.getString("year"));
                }

                stmt.close();
                conn.close();
//            JOptionPane.showMessageDialog(null, s[3]);
                System.out.println(s);
                return s;
            } else if (mofType.equalsIgnoreCase("lit_mof")) {

                ResultSet rs = stmt.executeQuery("SELECT * FROM `lit_mof`");
                while (rs.next()) {
                    s.add(rs.getInt("year"));
                    //    System.out.println(rs.getString("year"));
                }
                System.out.println(s);
                return s;
            } else {
                JOptionPane.showMessageDialog(null, "Please enter \"sci_mof\" or \"lit+mof\" as an argument!");
            }

//            JOptionPane.showMessageDialog(null, s[3]);
            return s;

        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();

            }

        }
        return s;
    }

    public static void studentCollegeRankExists_ThenUpdateRank_ElseInsert(int stdID, int clgID, float amt) {
        boolean exists = false;
        float newRank = 0;
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `student_college` "
                    + "WHERE studentID = '" + stdID + "' AND collegeID = '" + clgID + "'");
            if (rs.next()) {
                float prevRank = rs.getFloat("rank");
                newRank = prevRank + amt;
                exists = true;
                System.out.println("found!");
            }
            if (exists) {
                int result = stmt.executeUpdate("UPDATE `student_college` SET `rank` = '" + newRank + "'"
                        + " WHERE `studentID` = '" + stdID + "' AND `collegeID` = '" + clgID + "'");
                System.out.println("updated!!");
            } else {
                int result = stmt.executeUpdate("INSERT INTO `student_college` (studentID, collegeID, rank) "
                        + "VALUES ('" + stdID + "', '" + clgID + "', '" + amt + "')");
                System.out.println("inserted!");
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }
    }

    public static boolean mofYearExists(Mofadala m) {
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();

            if (m.getSciMofRadioButton().isSelected()) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM sci_mof WHERE year = '" + Integer.parseInt(m.getMofYearTextField().getText()) + "'");
                if (rs.next()) {
//                    if (rs.getInt("year") == Integer.parseInt(m.getMofYearTextField().getText())) {
                    return true;
//                    }
                }
            } else if (m.getLitMofRadioButton().isSelected()) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM lit_mof WHERE year = '" + Integer.parseInt(m.getMofYearTextField().getText()) + "'");
                if (rs.next()) {
//                    if (rs.getInt("year") == Integer.parseInt(m.getMofYearTextField().getText()));
                    return true;
                }

                stmt.close();
                conn.close();
            }
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }

        }
        return false;

    }

    public static void delete() {
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate(" DELETE FROM user " + " WHERE id=3 ");
            if (result == 1) {
                System.out.println("data deleted");
            } else {
                System.out.println("problem deleting data");
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }

    }

    public static String getCollegeNameByFuzzyQuestionID(int id) {
        String s = "";
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
//              Question q = new Question();
            // System.out.println(college);
//                if (!college.equalsIgnoreCase("")) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM `fuzzy_question` WHERE questionID = '" + id + "'");
            if (rs.next()) {
                s = rs.getString("collegeName");
                System.out.println(s);
                return s;

            }

            stmt.close();
            conn.close();
//            JOptionPane.showMessageDialog(null, s[3]);

        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();

            }

        }
        return s;

    }

    public static String getCollegeNameByMChoiceQuestionID(int id) {
        String s = "";
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
//              Question q = new Question();
            // System.out.println(college);
//                if (!college.equalsIgnoreCase("")) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM `multi_choice_question` WHERE questionID = '" + id + "'");
            if (rs.next()) {
                s = rs.getString("collegeName");
                System.out.println(s);
                return s;

            }

            stmt.close();
            conn.close();
//            JOptionPane.showMessageDialog(null, s[3]);

        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();

            }

        }
        return s;

    }

    public static void main(String[] args) {

        getCollegeNameByMChoiceQuestionID(16);
//        List<Integer> years = new ArrayList<>();
//        years = getMofYears("sci_mof");
//
//        long seed = System.nanoTime();
//        Collections.shuffle(years, new Random(seed));
//        System.out.println(years);

//        for (int i = 0; i < 10; i++) {
//            double y = (Math.random()*12)%8;
//            double x = Math.random()%4;
//            System.out.println("x=" + x * 5);
//            System.out.println("y= " + y * 12);
//        }
//        getDifficultyByMChoiceQID(4);
//        List<String> s = new ArrayList<String>();
//        s.add("math");
//        s.add("medicine");
//        studentCollegeRankExists_ThenUpdateRank_ElseInsert(291, 3, (float) -1 / 2);
//        getCollegeNameByMChoiceQuestionID(2);
    }
}
