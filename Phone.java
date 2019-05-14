//Interface
import java.util.ArrayList;
public interface Phone{
    public String getOwner();
    public void setOwner(String owner);
    public ArrayList<PhoneApp> getApps();
    public void setApps(ArrayList<PhoneApp> apps);
    public void addApp(PhoneApp app);
    public void addApp(ArrayList<PhoneApp> appList);
    public int numberOfApps();
    public double maxPrice();
    public double minPrice();
    public ArrayList<PhoneApp> searchByPriceRating(double minPrice, double maxPrice, int minRate, int maxRate);
    public ArrayList<PhoneApp> searchApps(String keyword);
    public void phoneInfo();
}
