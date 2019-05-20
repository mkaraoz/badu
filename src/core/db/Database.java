
package core.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import core.reporter.enums.Severity;
import core.reporter.Vulnerability;
import core.reporter.enums.Category;
import core.reporter.enums.Domain;

/**
 *
 * @author mk
 */
public final class Database {

    private static final Database DB = new Database();

    private Database() {
        connect();
    }

    public static Database init() {
        return DB;
    }

    private Connection connect() {
        String url = "jdbc:sqlite:./base/vulcat.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public boolean insert(Vulnerability vulnerability) {
        String sql = "INSERT INTO base (title, severity, body,recom, domain, cat) VALUES(?,?,?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, vulnerability.getTitle());
            pstmt.setString(2, vulnerability.getSeverity().getName());
            pstmt.setString(3, vulnerability.getBody());
            pstmt.setString(4, vulnerability.getRecommendation());
            pstmt.setString(5, vulnerability.getDomain().getName());
            pstmt.setString(6, vulnerability.getCategory().getName());
            pstmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<Vulnerability> selectAll() {
        String sql = "SELECT * FROM base ORDER BY title";
        List<Vulnerability> vulnerabilities = new ArrayList<>();
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                Vulnerability v = new Vulnerability(
                        rs.getString("title"),
                        Severity.get(rs.getString("severity")),
                        rs.getString("body"),
                        rs.getString("recom"),
                        Domain.get(rs.getString("domain")),
                        Category.get(rs.getString("cat"))); 
                vulnerabilities.add(v);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return vulnerabilities;
    }
    
    public List<Vulnerability> search(final String text) {
        String query = "SELECT * FROM base where title like '%"+text+"%' or body like '%"+text+"%'";
        List<Vulnerability> vulnerabilities = new ArrayList<>();
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {

            // loop through the result set
            while (rs.next()) {
                Vulnerability v = new Vulnerability(
                        rs.getString("title"),
                        Severity.get(rs.getString("severity")),
                        rs.getString("body"),
                        rs.getString("recom"),
                        Domain.get(rs.getString("domain")),
                        Category.get(rs.getString("cat"))); 
                vulnerabilities.add(v);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return vulnerabilities;
    }

    public boolean delete(Vulnerability v) {
        String sql = "DELETE FROM base WHERE title = ? AND severity = ?";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, v.getTitle());
            pstmt.setString(2, v.getSeverity().getName());
            // execute the delete statement
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
