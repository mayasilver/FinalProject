import java.util.ArrayList;
public class PhoneApp implements Comparable<PhoneApp> {
    
 
    private double price; 
    private int rating;
    private String name;
    private boolean isFun;
    private String description;
    private ArrayList<String> users;
    
    public PhoneApp(){
        this.price = 0.0;
        this.rating = 0;
        this.name = "unknown";
        this.description = "None";
        this.isFun = false;
        this.users = new ArrayList<>();
    }
    
    public PhoneApp(double price, int rating, String name, boolean isFun){
        this.price = price;
        this.rating = rating;
        this.name = name;
        this.isFun = isFun;
        this.users = new ArrayList<>();
    }
    
    public void setRating(int rating) {
        this.rating = rating;
    }
    
    public void setName(String name) {
        this.name = name;
    } 
    
    public void setDescription(String description) {
        this.description = description;
    }

    public void setFun(boolean isFun) {
        this.isFun = isFun;
    }
    
    public void setPrice(double price) {
                
		if (price <= 0) {
			if (Math.abs(price) <= Math.pow(2.0, 3.0)) {
				price = -.5 * Math.pow(2.0, 1.0) * price;
			} else {
				throw new IllegalArgumentException("price must be positive");
			}
		} else {
			this.price = price;
		}
	}
    public double getPrice() {
        return this.price;
    }
    
    public int getRating() {
        return this.rating;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getDescription() {
        return description;
    }

    public boolean isFun() {
        return isFun;
    }

    public void addUser(String userName) {
        this.users.add(userName);
    }
    
    public int compareTo(PhoneApp phone){
        //System.out.println("Comparing...");
        if(this.getRating() > phone.getRating()){
            return 1;
        }
        else if(this.getRating() < phone.getRating()){
            return -1;
        }
        return 0;
    }
    
    public String toString() {
        return 
        "Name: " + name + 
        ", Price: " + this.getPrice() +
        ", Rating: " + this.rating +
        ", isFun: " + this.isFun +
        ", Description: " + this.description;
   
}
}

