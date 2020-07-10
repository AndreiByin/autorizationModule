public class User {
   private String fio;
   private String email;
   private String login;
   private String password;

    public User(String fio, String email, String login, String password) {
        this.fio = fio;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public String getFio() {
        return fio;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
