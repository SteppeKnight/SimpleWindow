package sample.DBServices;

public class Account {
    private String name;
    private String surname;
    private String password;
    private String login;
    private String genger;
    private String sign;

    public Account(String name, String surname, String password, String login, String genger, String sign) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.login = login;
        this.genger = genger;
        this.sign = sign;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getGenger() {
        return genger;
    }

    public void setGenger(String genger) {
        this.genger = genger;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
