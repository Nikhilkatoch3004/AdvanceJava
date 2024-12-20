package Service;

import java.util.ArrayList;
import java.util.List;
import Registration.Regestration;

public class UserService {
//	private static UserService instance;
     public static List<Regestration> rg = new ArrayList<>();

    public 	boolean loginCheck(String user , String pss) {
    	boolean isValidUser = false ;
    	for(Regestration r : rg) {
            if (user.equals(r.uname) && pss.equals(r.pwd)) {
                
                isValidUser = true;
                return true ;
            }
        }
		return false;
    	
    }
}
