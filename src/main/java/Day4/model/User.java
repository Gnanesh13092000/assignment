package Day4.model;

public class User {
    public int id;
    public String userName;
    public String password;

    public User(int id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("User{id=%d, userName='%s', password='%s'}", id, userName, password);
    }
}
