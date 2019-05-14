import java.util.ArrayList;
import java.util.Scanner;
public class GooglePlay implements iAppStore{
    private ArrayList<PhoneApp> list = new ArrayList<>();
	private String[] names = { "Instagram", "snapchat", "imessage", "WhatsApp", "WeatherApp" };
	private double[] prices = { 0, .99, 1.99, 2.99, 0 };
	private int[] ratings = { 3, 2, 4, 5, 3 };
	private boolean[] fun = { true, false, true, false, true };
	private String[] desp = { "social media", "chat texting", "texting", "messaging chat texting call voice", "weather information" };
	public ArrayList<PhoneApp> createApps() {
		for (int i = 0; i < names.length; i++) {
			PhoneApp phoneApp = new PhoneApp(prices[i], ratings[i], names[i], fun[i]);
			phoneApp.setDescription(desp[i]);
			list.add(phoneApp);
		}
		return list;
	}

	// Get an app randomly from app store
	public PhoneApp randomApp() {
	        
		int index = (int) (Math.random() * names.length);

		PhoneApp phoneApp = new PhoneApp(prices[index], ratings[index], names[index], fun[index]);
		phoneApp.setDescription(desp[index]);
		
		return phoneApp;
	}

      public  ArrayList<PhoneApp> createUserDefinedApps() {
		ArrayList<PhoneApp> createdApps = new ArrayList<>();
		Scanner in = new Scanner(System.in);
		boolean moreApp = true;
		PhoneApp phoneApp;
		
		System.out.print("Enter App name or enter key to end: ");
		String name = in.nextLine().trim();
		do {
		    //User input where they can make their own app
			System.out.print("Enter App price: ");
			double price = Double.parseDouble(in.nextLine().trim());

			System.out.print("Enter App rating: ");
			int rating = Integer.parseInt(in.nextLine().trim());

			System.out.print("Enter App fun level: ");
			boolean fun = Boolean.parseBoolean(in.nextLine().trim());

			System.out.print("Enter App  description: ");
			String description = in.nextLine().trim();

			phoneApp = new PhoneApp(price, rating, name, fun);
			phoneApp.setDescription(description);
			

			System.out.print("Do you want to enter users for this app? y/N: ");
			String response = in.nextLine().trim();
		    switch (response) {
			case "y":
	 		//if the user presses y then they will be prompted to add a username to the app and if they press n it will exit 
			
			while (true) {
					System.out.print("Enter a user for your app or press enter key to end: ");
					String userName = in.nextLine().trim();
					if (userName.length() > 0) {
						phoneApp.addUser(userName);

					} else {
						break; // end the loop
					}
				}

			case "N":
			case "n":
				System.out.println("Thank you for using this app!");
			}
			
			createdApps.add(phoneApp);
			
			System.out.print("Enter App name or enter key to end: ");
			name = in.nextLine().trim();
			
			if (name.length() == 0) {
				moreApp = false;
			}

		} while (moreApp);

		 // close the scanner
		in.close();
		
		return createdApps;
   
	}
}

