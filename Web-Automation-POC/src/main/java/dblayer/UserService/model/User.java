package dblayer.UserService.model;

public class User {
    private String username;
    private static String FAKE_EMAIL_EMAIL = "@fakedomain.com";
    public  String getUsername(){
        return username;
    }
    public  String getEmailFormat(){
        return   getUsername()+FAKE_EMAIL_EMAIL;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User(String username){
        setUsername(username);
    }

}
