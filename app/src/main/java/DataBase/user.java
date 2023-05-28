package DataBase;

public class user {
    int id;
    String name ;
    String Email;
    String password;

    public user( String name, String email, String password) {

        this.name = name;
        Email = email;
        this.password = password;
    }
    public user( ) {


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
