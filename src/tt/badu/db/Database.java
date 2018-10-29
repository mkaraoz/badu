/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tt.badu.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import core.reporter.Severity;
import core.reporter.Vulnerability;

/**
 *
 * @author mk
 */
public final class Database {

    private static final Database d = new Database();

    private Database() {
        connect();
    }

    public static Database init() {
        return d;
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
        String sql = "INSERT INTO base (title, severity, body,recom) VALUES(?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, vulnerability.getTitle());
            pstmt.setString(2, vulnerability.getSeverity().getName());
            pstmt.setString(3, vulnerability.getBody());
            pstmt.setString(4, vulnerability.getRecommendation());
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
                Vulnerability v = new Vulnerability(rs.getString("title"),
                        Severity.get(rs.getString("severity")),
                        rs.getString("body"),
                        rs.getString("recom"));
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
