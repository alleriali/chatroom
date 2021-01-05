public class Users{
    private String username;
    private String password;
    public Users(String username, String password){
        this.username = username;
        this.password = password;
    }
    public String getUsername(){
        return this.username;
    }
    public void setUsername(String name){
        this.username = name;
    }
    public void setPassword(String password){
        this.password = password;
    }
}
