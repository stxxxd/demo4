package dao;

import entity.User;
import entity.Stu;
import java.util.List;
import java.util.Map;

public interface UserDao {
    List<User> getUserByUsername(String username) ;
    void  registerUser(User user) ;
    void verifyUserBySecurityAnswer(String username,String securityAnswer) ;
    void  updatePassword(String username, String newPassword) ;
    List<Stu>findStus();
    void insert(Stu stu);
    Stu searchStu(int id);
    void updateStu(Stu stu);
    void deleteStuById(int id);
    List<Stu>findAllSTUPageable(int pageNow,int pageCount);
    int getTotalRows();
    public int getStuCount();
    public Map<String, Integer> getSexRatio();
    public Map<String, Integer> getProfessionalCount();
    List<Stu> getStudentsSortedBy(String sortField);
}
