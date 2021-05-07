package App.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomPreparedStatement {
    private PreparedStatement myStatement;
    private int index = 1;

    //Constructor to set default
    public CustomPreparedStatement (PreparedStatement myStatement) {
        this.myStatement = myStatement;
    }

    // "= ?" present within the query content represents the parameter that will be later introduced into query
    // Therefore preparedStatement requires setters defines the values of these parameters
    // setObject is a good default as any type, class may be introduced later on
    // if we know what we want in our function we can just define parse/introduce a parameter of any type
    // thus it allows to adjust the parameters type with respect to the requirements of input query (method prepare in abstractdaosql)
    public CustomPreparedStatement setParameter(int index, Object value) {
       try {
           this.myStatement.setObject(index, value);
       }
       catch (SQLException throwables) {
           throwables.printStackTrace();
       }
       return this;
    }

    public CustomPreparedStatement setParameter(Object value) {
           return this.setParameter(this.index++, value);
    }

    //It executes the defined CustomPreparedStatement (prepare + setParameters)
    // returns boolean to verify if everything went fine
    public boolean execute() {
        try {
            this.myStatement.execute();
            return true;
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    //Why do we have it if cannot be called on PreparedStatement?
    public ResultSet executeQuery() {
        try {
           return this.myStatement.executeQuery();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
