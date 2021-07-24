package sl.springboot.rabbitmq.bean;

import java.io.Serializable;

public class Book implements Serializable {

    private String bookName;

    public Book(){
        super();
    }

    public Book(String bookName, String authName) {
        this.bookName = bookName;
        this.authName = authName;
    }

    private String authName;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", authName='" + authName + '\'' +
                '}';
    }
}
