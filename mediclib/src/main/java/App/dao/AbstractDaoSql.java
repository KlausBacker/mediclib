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


import java.sql.*;

public abstract class AbstractDaoSql {
    protected static Connection connection;

    public AbstractDaoSql() {
        this.createConnection();
    }

    public void createConnection() {
        if (connection == null) {
            //Charger le pilote (méme si pas obligatoire depuis Java 8)
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            }

            catch (ClassNotFoundException cnex) {
                System.out.println("Chargement du pilote JDBC impossible ...");
                cnex.printStackTrace();
            }

            try {
                //Se connecter au serveur
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/MedicLib?serverTimezone=UTC", "root", "ktipiti");
                System.out.println("CONNEXION !!");

            }

            catch (SQLException sqle) {
                System.out.println("Impossible de se connecter.");
                sqle.printStackTrace();
            }
        }
    }

    public ResultSet getResult(String query) {
        try {
            Statement statement = connection.createStatement();

            return statement.executeQuery(query);
        }

        catch (Exception sqle) {
            System.out.println("Impossible d'exécuter la requéte.");

            return null;
        }
    }

    public CustomPreparedStatement prepare(String query) {
        try {
            return new CustomPreparedStatement(connection.prepareStatement(query));
        }

        catch (SQLException sqle) {
            sqle.printStackTrace(); //TODO : remove ...

            return null;
        }
    }
}
