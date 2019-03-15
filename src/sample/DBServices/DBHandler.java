package sample.DBServices;



import java.sql.*;

public class DBHandler extends Config{
    Connection connection;

    public Connection getConnection() throws ClassNotFoundException, SQLException{
        String connection = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?" + "autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";


        Class.forName("com.mysql.cj.jdbc.Driver");

        this.connection = DriverManager.getConnection(connection, dbUser, dbPass);

        return this.connection;
    }

    public void signUp(Account user){
        String insertCmd = "INSERT INTO " + Consts.USER_TABLE + " ( " + Consts.USERS_NAME + ", " + Consts.USERS_LOGIN + ", " +
                Consts.USERS_SURNAME + ", " + Consts.USERS_SIGN + ", "+ Consts.USERS_GENDER + ", " + Consts.USERS_PASSWORD + ") " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(insertCmd);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getSurname());
            preparedStatement.setString(4, user.getSign());
            preparedStatement.setString(5, user.getGenger());
            preparedStatement.setString(6, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getResultSet(String login, String pass){
        ResultSet set = null;

        String selectCmd = "SELECT * FROM " + Consts.USER_TABLE + " WHERE " + Consts.USERS_LOGIN + " = '" + login + "' AND " + Consts.USERS_PASSWORD
                + " = " + pass;

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(selectCmd);
            set = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return set;
    }
}
