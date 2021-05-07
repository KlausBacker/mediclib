package App.dao;

import java.sql.*;

public abstract class AbstractDaoSql {
    protected Connection connection;

    public AbstractDaoSql() {
        this.establishConnection();
    }

    public void establishConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException cnex) {
                System.out.println("Impossible to load JDBC. ");
            }
            try {
                System.out.println("Connection established.");
                this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/MedicLib?serverTimezone=UTC", "root", "44Schrodinger!");
            } catch (SQLException sqle) {
                System.out.println("Impossible to establish the connection.");
            }
        }
    }
    //Data extraction
    public ResultSet extractResults(String inputQuery) {
        try {
            Statement newStatement = connection.createStatement();

            return newStatement.executeQuery(inputQuery);
//            ResultSet myData = newStatement.executeQuery(inputQuery);
//            return myData;

        } catch (Exception extResultsFail) {
            System.out.println("Execution of given query is impossible." + extResultsFail.getMessage());

            return null;
        }
    }

    public CustomPreparedStatement prepare(String queryToExecute) {
        try {
            // It is the same thing as:
            // CustomPreparedStatement myCustomPrepStat = myConnection.prepareStatement(inputQuery);
            // return myCustomPrepStat; --> return of method prepare
            return new CustomPreparedStatement(connection.prepareStatement(queryToExecute));
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
