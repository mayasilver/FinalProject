//Inheritance
import java.util.ArrayList;
public class Android implements Phone{
     
    private String owner = "";	
    private ArrayList<PhoneApp> apps = null;
    public Android() {
		this.owner = "unknown";
		this.apps = new ArrayList<>();
	}

	// multi-arg constructor
	public Android(String owner) {
		this();
		this.owner = owner;
	}

	// setters
	public void setOwner(String owner) {
		this.owner = owner;
	}

	// getters
	public String getOwner() {
		return "Android: " + this.owner;
	}

	public ArrayList<PhoneApp> getApps() {
		return apps;
	}

	public void setApps(ArrayList<PhoneApp> apps) {
		this.apps = apps;
	}


	public void addApp(PhoneApp app) {
		if (this.apps == null) {
			throw new NullPointerException("this phone cannot have apps!");
		}
		int size = apps.size();
		
		if (size == 0) {
			this.apps.add(app);
		} else {
			boolean exist = false;
			
			for  (int i = 0; i < size; i++) {
				if (apps.get(i).getName().equalsIgnoreCase(app.getName())) {
					exist = true;
					//System.out.println("You already have " + app.getName() + " app.");
					break;
				} 			
			}
			if (!exist) {
				//System.out.println("adding app " + app.getName());
				this.apps.add(app);

			}
		}
	}
         
	public void addApp(ArrayList<PhoneApp> appList) {
		for (PhoneApp phoneApp : appList) {
			addApp(phoneApp);
		}
	}
	public int numberOfApps() {
		int size = apps.size();//number of apps in the phone
		
		//If the number of apps is less than 4 then add apps to the phone
		if ( size < Math.pow(2.0, 2.0)) {
			System.out.println("Get more apps. You only have " + size + " apps.");
			
		//if the number of apps is between 4 and 16 then there are too many apps	
		} else if (size > Math.pow(2.0, 2.0) && size < Math.pow(2, 4)) {
			System.out.println("Too many apps. " + size + " apps");
	        //if the numer of apps is greater than 16 then delete apps
		} else if (size > Math.pow(2.0, 4.0)) {
			System.out.println("Delete some apps. " + size + " apps");
		}
		
		return size;
	}
	
	
	// find the maximum price of the app
	public double maxPrice() {
		double max = Double.MIN_VALUE;
		for (PhoneApp phoneApp : apps) {
			Double price = phoneApp.getPrice();
			if (price > max) {
				max = price;
			}
		}
		return max;
	}

	// find the minimum price of the app
	public double minPrice() {
		double min = Double.MAX_VALUE;
		for (PhoneApp phoneApp : apps) {
			Double price = phoneApp.getPrice();
			if (price < min) {
				min = price;
			}
		}
		return min;
	}

	//Checking to see if the price of the app is between the range of the min and max price
	public ArrayList<PhoneApp> searchByPriceRating(double minPrice, double maxPrice, 
													int minRate, int maxRate) {
		ArrayList<PhoneApp> list = new ArrayList<PhoneApp>();
		for (PhoneApp phoneApp : apps) {
			double price = phoneApp.getPrice();
			int rating = phoneApp.getRating();
			if (price >= minPrice && price <= maxPrice && rating >= minRate && rating <= maxRate) {
				list.add(phoneApp);
			}

		}
		return list;
	}
        
	//Finds all the apps with a key word in their description
	public ArrayList<PhoneApp> searchApps(String keyword) {
	        ArrayList<PhoneApp> searchResults = new ArrayList<>();
		for (PhoneApp phoneApp : this.apps) {
			if (phoneApp.getDescription() != null) {
			    if (phoneApp.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
					searchResults.add(phoneApp);
				} 
			} else {
				System.out.println(phoneApp.getName() + " does not have description");
			}
		}

		return searchResults;
	}

	
	public String toString() {
		if (this.owner.equals("unknown")) {
			throw new IllegalArgumentException("Owner must be a valid person.");
		}
		String output = "Phone: Owner=" + owner + "\n";
		if (apps.size() == 0) {
			output += "\tThis phone has no app\n";
		} else {
			//System.out.println("size = " + apps.size());
			for (int i = 0; i < apps.size(); i++) {
				output += "\t" + apps.get(i);
				output += "\n";
			}
		}
		return output;
	}
	
	public void phoneInfo() {
		System.out.println(this);
		System.out.println("App minimum price: $" + this.minPrice());
		System.out.println("App maximum price: $" + this.maxPrice());
	}
}


