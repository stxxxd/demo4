package dao;

import com.example.demo4.JDBCUtils;
import entity.User;
import entity.Stu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoImpl  implements UserDao {
    // 根据用户名查询用户信息
    public List<User> getUserByUsername(String username) {
        List<User> users = new ArrayList<User>();
        String sql = "SELECT * FROM users WHERE username =?";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement ptmt = conn.prepareStatement(sql)) {
            ptmt.setString(1, username);
            ResultSet rs = ptmt.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6));
                users.add(user);
            }
            JDBCUtils.release(conn, ptmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // 注册新用户
    public void registerUser(User user) {
        String sql = "INSERT INTO users (username, password, email, role, securityQuestion, securityAnswer) VALUES (?,?,?,?,?,?)";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement ptmt = conn.prepareStatement(sql)) {
            ptmt.setString(1, user.getUsername());
            ptmt.setString(2, user.getPassword());
            ptmt.setString(3, user.getEmail());
            ptmt.setString(4, user.getRole());
            ptmt.setString(5, user.getSecurityQuestion());
            ptmt.setString(6, user.getSecurityAnswer());
            ptmt.executeUpdate();
            JDBCUtils.release(conn, ptmt, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // 根据用户名和安全问题答案验证用户，用于密码找回等
    public void verifyUserBySecurityAnswer(String username, String securityAnswer) {
        String sql = "SELECT * FROM users WHERE username =? AND securityAnswer =? ";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement ptmt = conn.prepareStatement(sql)) {
            ptmt.setString(1, username);
            ptmt.setString(2, securityAnswer);
            ResultSet resultSet = ptmt.executeQuery();
            ptmt.executeUpdate();
            JDBCUtils.release(conn, ptmt, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // 更新用户密码
    public void updatePassword(String username, String newPassword) {
        String sql = "UPDATE users SET password =? WHERE username =?";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement ptmt = conn.prepareStatement(sql)) {
            ptmt.setString(1, newPassword);
            ptmt.setString(2, username);
            ptmt.executeUpdate();
            JDBCUtils.release(conn, ptmt, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Stu> findStus() {
        List<Stu> stus = new ArrayList<Stu>();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from stus";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Stu stu = new Stu(rs.getInt(1), rs.getInt(2),
                        rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7));
                stus.add(stu);
            }
            JDBCUtils.release(conn, pstmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stus;
    }

    @Override
    public void insert(Stu stu) {
        Connection conn = JDBCUtils.getConnection();
        String sql = "insert into stus(id,sno,name,sex,born,professional,classment)values (?,?,?,?,?,?,?)";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, stu.getId());
            pstmt.setInt(2, stu.getSno());
            pstmt.setString(3, stu.getName());
            pstmt.setString(4, stu.getSex());
            pstmt.setString(5, stu.getBorn());
            pstmt.setString(6, stu.getProfessional());
            pstmt.setString(7, stu.getClassment());
            pstmt.executeUpdate();
            JDBCUtils.release(conn, pstmt, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Stu searchStu(int id) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM stus WHERE id = ?";
        Stu stu = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                stu = new Stu(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
            }
            JDBCUtils.release(conn, pstmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stu;
    }

    @Override
    public void updateStu(Stu stu) {
        Connection conn = JDBCUtils.getConnection();
        String sql = "update stus set sno=?,name=?,sex=?,born=?,professional=?,classment=? where id=?";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, stu.getSno());
            pstmt.setString(2, stu.getName());
            pstmt.setString(3, stu.getSex());
            pstmt.setString(4, stu.getBorn());
            pstmt.setString(5, stu.getProfessional());
            pstmt.setString(6, stu.getClassment());
            pstmt.setInt(7, stu.getId());
            pstmt.executeUpdate();
            JDBCUtils.release(conn, pstmt, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStuById(int id) {
        Connection conn = JDBCUtils.getConnection();
        String sql = "delete from stus where id=?";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            JDBCUtils.release(conn, pstmt, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Stu> findAllSTUPageable(int pageNow, int pageCount) {
        List<Stu> stus = new ArrayList<Stu>();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from stus limit ?,?";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, (pageNow - 1) * pageCount);
            pstmt.setInt(2, pageCount);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Stu stu = new Stu(rs.getInt(1), rs.getInt(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                stus.add(stu);
            }
            JDBCUtils.release(conn, pstmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stus;
    }

    @Override
    public int getTotalRows() {
        Connection conn = JDBCUtils.getConnection();
        String sql = "select count(*) from stus";
        PreparedStatement pstmt = null;
        int count = 0;
        try {
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            JDBCUtils.release(conn, pstmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int getStuCount() {
        int count = 0;
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT COUNT(*) FROM stus")) {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
            JDBCUtils.release(conn, pstmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public Map<String, Integer> getSexRatio() {
        Map<String, Integer> sexRatio = new HashMap<>();
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT sex, COUNT(*) FROM stus GROUP BY sex")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                sexRatio.put(resultSet.getString(1), resultSet.getInt(2));
            }
            JDBCUtils.release(connection, preparedStatement, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sexRatio;
    }

    @Override
    public Map<String, Integer> getProfessionalCount() {
        Map<String, Integer> professionalCount = new HashMap<>();
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT professional, COUNT(*) FROM stus GROUP BY professional")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                professionalCount.put(resultSet.getString(1), resultSet.getInt(2));
            }
            JDBCUtils.release(connection, preparedStatement, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professionalCount;
    }

    public List<Stu> getStudentsSortedBy(String sortField) {
        List<Stu> stus = new ArrayList<Stu>();
        String sql = "SELECT*FROM stus ORDER BY " + sortField;
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int sno = resultSet.getInt("sno");
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                String born = resultSet.getString("born");
                String professional = resultSet.getString("professional");
                String classment = resultSet.getString("classment");
                stus.add(new Stu(id, sno, name, sex, born, professional, classment));
            }
            JDBCUtils.release(connection, statement, resultSet);
        }catch(SQLException e){
                e.printStackTrace();
            }
            return stus;
        }
    }
