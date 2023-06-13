import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
public class ReturnList {
    private final StringProperty id;
    private final StringProperty fullname;
    private final StringProperty bid ;
    private final StringProperty booktitle;
    private final StringProperty laondate;
    private final StringProperty returningdate;
    

    // private final StringProperty mydate;

    public ReturnList() {
        id = new SimpleStringProperty(this, "id");
        fullname = new SimpleStringProperty(this, "fullname");
        bid = new SimpleStringProperty(this, "bid");
        booktitle = new SimpleStringProperty(this, "booktitle");
        laondate = new SimpleStringProperty(this, "laondate");
        returningdate = new SimpleStringProperty(this, "returningdate");
        
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

    public StringProperty bidProperty() {
        return bid;
    }

    public String getbid() {
        return bid.get();
    }

    public void setbid(String newbid) {
        bid.set(newbid);
    }

    public StringProperty booktitleProperty() {
        return booktitle;
    }

    public String booktitle() {
        return booktitle.get();
    }

    public void setbooktitle(String newbooktitle) {
        booktitle.set(newbooktitle);
    }

    public StringProperty laondateProperty() {
        return laondate;
    }

    public String getlaondate() {
        return laondate.get();
    }

    public void setlaondate(String newlaondate) {
        laondate.set(newlaondate);
    }

    public StringProperty returningdateProperty() {
        return returningdate;
    }

    public String returningdate() {
        return returningdate.get();
    }

    public void setreturningdate(String newreturningdate) {
        returningdate.set(newreturningdate);
    }

}


