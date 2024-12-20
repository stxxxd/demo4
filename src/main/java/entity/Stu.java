package entity;

public class Stu {
    private int id;
    private int sno;
    private String name;
    private String sex;
    private String born;
    private String professional;
    private String  classment;
    public Stu(Integer id, Integer sno, String name, String sex, String born, String professional){}
    public Stu(int id,int sno, String name, String sex, String born, String professional, String classment){
        this.id = id;
        this.sno=sno;
        this.name = name;
        this.sex = sex;
        this.born = born;
        this.professional=professional;
        this.classment=classment;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getClassment() {
        return classment;
    }

    public void setClassment(String classment) {
        this.classment = classment;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", sno='" + sno + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", born='" + born + '\'' +
                ", professional='" + professional + '\'' +
                ", classment='" + classment + '\'' +
                '}';
    }
}
