import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
public class StudentList {
    private final StringProperty id;
    private final StringProperty fullname;
    private final StringProperty username ;
    private final StringProperty password;
    private final StringProperty school;
    private final StringProperty department;

    // private final StringProperty mydate;

    public StudentList() {
        id = new SimpleStringProperty(this, "id");
        fullname = new SimpleStringProperty(this, "fullname");
        username = new SimpleStringProperty(this, "username");
        password = new SimpleStringProperty(this, "password");
        school = new SimpleStringProperty(this, "school");
        department = new SimpleStringProperty(this, "department");
        // mydate = new SimpleStringProperty(this, "mydate");
    }

    public StringProperty idProperty() {
        return id;
    }

    public String getid() {
        return id.get();
    }

    public void setid(String newid) {
        id.set(newid);
    }

    public StringProperty fullnameProperty() {
        return fullname;
    }

    public String getfullname() {
        return fullname.get();
    }

    public void setfullname(String newfullname) {
        fullname.set(newfullname);
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public String getusername() {
        return username.get();
    }

    public void setusername(String newusername) {
        username.set(newusername);
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public String getpassword() {
        return password.get();
    }

    public void setpassword(String newpassword) {
        password.set(newpassword);
    }
    
    public StringProperty schoolProperty() {
        return school;
    }

    public String getschool() {
        return school.get();
    }

    public void setschool(String newschool) {
        school.set(newschool);
    }

    public StringProperty departmentProperty() {
        return department;
    }

    public String getdepartment() {
        return department.get();
    }

    public void setdepartment(String newdepartment) {
        department.set(newdepartment);
    }

}
