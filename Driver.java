import java.util.ArrayList;
public class Driver {

    public static void main(String[] args) {
        // First create a phone
        //Polymorphism
        Phone mayaPhone = new iPhone("Maya's phone");
        
        // Second get some apps on this phone
        AppStore appStore = new AppStore();
        
        for (int i = 0; i < 2; i++) {
            PhoneApp p = appStore.randomApp();
            mayaPhone.addApp(p);
        }
    
        mayaPhone.phoneInfo();
        //Polymorphism
        Phone momPhone = new Android("Mom's Phone");
        GooglePlay googleplay = new GooglePlay();
        momPhone.addApp(googleplay.createApps());
        momPhone.phoneInfo();
        
        ArrayList<Phone> phoneList= new ArrayList<>();
        phoneList.add(mayaPhone);
        phoneList.add(momPhone);
        //First for loop iterates through the phone list
        for (Phone phone : phoneList) {
            ArrayList<PhoneApp> apps = phone.searchApps("text");
            System.out.println(phone.getOwner());  

            for (PhoneApp app : apps) {
                if (app.getDescription().contains("chat")) {
                    System.out.println(app.getName() + ": " + app.getDescription());
                    //#7 String method indexOf
                    int start = app.getDescription().indexOf("chat");
                    //#7 String method substring
                    String newDescripition = app.getDescription().substring(0, start);
                    newDescripition += app.getDescription().substring(start+4);
                    System.out.println("new description after removing chat: " + newDescripition);                    
                    app.setDescription(newDescripition);
                }
            }
        }
        
        for (Phone phone : phoneList) {
            ArrayList<PhoneApp> apps = phone.getApps();
            PhoneApp [] phoneApp = new PhoneApp[apps.size()];
            for (int i = 0; i < apps.size(); i++) {
                phoneApp[i] = apps.get(i);
            }
            System.out.println("Apps sorted by rating");
            sort(phoneApp);
            
            for (int i = 0; i < phoneApp.length; i++) {
                
                System.out.println(phoneApp[i]);
            }
        }
    }
    static void sort(PhoneApp [] arr) 
    { 
        int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            PhoneApp key = arr[i]; 
            int j = i - 1; 
  
            while (j >= 0 && arr[j].compareTo(key) < 1) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        } 
    } 
    
}

