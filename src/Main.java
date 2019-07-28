import com.hillel.hw06.TaxiParkRunner;
import com.hillel.hw16.DatabaseRunner;
import com.hillel.hw16.dao.Database;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nhomework 15\n");
        new TaxiParkRunner().run();

        System.out.println("\nhomework 16\n");
        new DatabaseRunner(new Database()).run();
    }
}
