package software.project.backend.sercuirty;

import java.util.Hashtable;
import java.util.UUID;

public class Singelton {
    private static Singelton instance = null;
    private static Hashtable<String,String> onlineUser=new Hashtable<>();

    private Singelton(){}

    public static Singelton getInstance() {
        if (instance==null){
            instance=new Singelton();
        }
        return instance;
    }
    public  Hashtable getOnlineUser(){
        return this.onlineUser;
    }
    public String addOnlineUser(String id){
        String uniqueID = UUID.randomUUID().toString();
        onlineUser.put(uniqueID,id);
        return uniqueID;
    }
    public boolean checkUser(String id){
        return onlineUser.containsKey(id);
    }
    public String checkAcess(String id){
        String realID=null;
        try {
            realID=onlineUser.get(id);
        }catch (Exception e){
            return null;
        }
        return realID;
    }
    public void deleteOnlineUser(String id){
        onlineUser.remove(id);
    }

}

