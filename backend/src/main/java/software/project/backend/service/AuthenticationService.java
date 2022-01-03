package software.project.backend.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import software.project.backend.Database.UserDAO;
import software.project.backend.Model.User;
import software.project.backend.Model.builder.Director;
import software.project.backend.sercuirty.Singelton;
import software.project.backend.sercuirty.passwordOperations;

public class AuthenticationService {
    private Director director=new Director();
    private Singelton trackingSystem;
    private software.project.backend.sercuirty.passwordOperations passwordOperations=new passwordOperations();
    @Autowired
    private UserDAO userDAO=new UserDAO();
    public boolean signUp(String dataSent){
        User user = (User) director.composeModel("user",dataSent);
        System.out.println(user.getUserName()+
                " "+user.getFirstName()+
                " " +user.getPassword()+
                " "+user.getLastName()+
                " "+user.getAddress()+
                " "+user.getPhone()
        );
        return userDAO.insertUser(user);
    }
    public boolean checkUserName(String userName){
        return !userDAO.isUserNameExist(userName);
    }
    public JSONObject signIn(String dataSent){
        String userName;
        String password;
        try {
            JSONObject obj = new JSONObject(dataSent);
            userName=obj.getString("userName");
            password=passwordOperations.passswordToHash(obj.getString("password"));
            System.out.println(userName+"-->"+password+"-->"+obj.getString("password"));
        } catch (JSONException e) {
            return null;
        }
        User temp=userDAO.checkSignIn(userName,password);
        if(temp==null) return null;
        trackingSystem= Singelton.getInstance();
        String sessionID=trackingSystem.addOnlineUser(userName);
        JSONObject object=new JSONObject();
        try {
            object.put("sessionID",sessionID);
            object.put("role",temp.getRole());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object;
    }
    public boolean logout(String sessionID){
       return trackingSystem.deleteOnlineUser(sessionID);
    }
}
