    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import java.time.format.DateTimeFormatter;

    import javafx.beans.property.SimpleStringProperty;
    import javafx.beans.property.StringProperty;

    public class Book {

    private final StringProperty id;
    private final StringProperty title;
    private final StringProperty author;
    private final StringProperty year;
    // private final StringProperty mydate;

    public Book() {
        id = new SimpleStringProperty(this, "id");
        title = new SimpleStringProperty(this, "title");
        author = new SimpleStringProperty(this, "author");
        year = new SimpleStringProperty(this, "year");
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

    public StringProperty titleProperty() {
        return title;
    }

    public String gettitle() {
        return title.get();
    }

    public void settitle(String newtitle) {
        title.set(newtitle);
    }

    public StringProperty authorProperty() {
        return author;
    }

    public String getauthor() {
        return author.get();
    }

    public void setauthor(String newauthor) {
        author.set(newauthor);
    }

    public StringProperty yearProperty() {
        return year;
    }

    public String getyear() {
        return year.get();
    }

    public void setyear(String newyear) {
        year.set(newyear);
    }

    // public StringProperty myDateProperty() {
    // return mydate;
    // }

    // public String getMyDate() {
    // return mydate.get();
    // }

    // public void setMyDate(String newMyDate) {
    // mydate.set(newMyDate);
    // }

}