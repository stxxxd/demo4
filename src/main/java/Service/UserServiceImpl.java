package Service;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.Stu;
import entity.User;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService{
    private UserDao userDao = new UserDaoImpl();
    @Override
    public List<User> getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }
    @Override
    public void registerUser(User user) {
        userDao.registerUser(user);
    }
    @Override
    public void verifyUserBySecurityAnswer(String username, String securityAnswer) {
       userDao.verifyUserBySecurityAnswer(username,securityAnswer);
    }
    @Override
    public void  updatePassword(String username, String newPassword) {
        userDao.updatePassword(username,newPassword);
    }

    @Override
    public List<Stu> findAllStus() {
        return  userDao.findStus();
    }

    @Override
    public void addstu(Stu stu) {
        userDao.insert(stu);
    }

    @Override
    public Stu searchStu(int id) {
        return userDao.searchStu(id);
    }

    @Override
    public void updateStu(Stu stu) {
        userDao.updateStu(stu);
    }

    @Override
    public void deleteStuById(int id) {
        userDao.deleteStuById(id);
    }

    @Override
    public List<Stu> findAllSTUPageable(int pageNow, int pageCount) {
        return userDao.findAllSTUPageable(pageNow,pageCount);
    }

    @Override
    public int getTotalUserCount() {
        return userDao.getTotalRows();
    }

    @Override
    public int getStuCount() {
        return userDao.getStuCount();
    }

    @Override
    public Map<String, Integer> getSexRatio() {
        return userDao.getSexRatio();
    }

    @Override
    public Map<String, Integer> getProfessionalCount() {
        return userDao.getProfessionalCount();
    }

    @Override
    public List<Stu> getStudentsSortedBy(String sortField) {
        return userDao.getStudentsSortedBy(sortField);
    }

}
