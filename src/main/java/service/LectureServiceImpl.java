package service;

import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class LectureServiceImpl implements LectureService{

    @Override
    public void getLectures() throws ClassNotFoundException, SQLException {
        String className = "com.mysql.cj.jdbc.Driver";
        Class.forName(className);
        String dbUrl = "jdbc:mysql://localhost:3306/scheme";
        String dbUser = "root";
        String dbPassword = "example";
        Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        String query = "SELECT * FROM lectures WHERE grades = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, "2");

        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            System.out.println(
                    resultSet.getString("code")+" "+
                    resultSet.getString("name")+" "+
                    resultSet.getString("professor")+" "+
                    resultSet.getString("grades")
            );
        }

        connection.close();
    }
}
