package Book_management;
import java.util.Comparator;
public class CompareBook implements Comparator<Book> {

    public int compare(Book x, Book y) {
        return (int) (x.price - y.price);
    }
}