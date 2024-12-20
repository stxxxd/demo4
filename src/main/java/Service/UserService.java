package Service;

import entity.Stu;
import entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> getUserByUsername(String username);
    public void registerUser(User user);
    public void verifyUserBySecurityAnswer(String username, String securityAnswer);
    public void updatePassword(String username, String newPassword);
    List<Stu>findAllStus();
    public void addstu(Stu stu);
    public Stu searchStu(int id );
    public void updateStu(Stu stu);
    public void deleteStuById(int id);
    List<Stu> findAllSTUPageable(int pageNow, int pageCount);
    public int getTotalUserCount();
    public int getStuCount();
    public Map<String, Integer> getSexRatio();
    public Map<String, Integer> getProfessionalCount();
    List<Stu> getStudentsSortedBy(String sortField);
}
