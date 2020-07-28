package Service;

import java.sql.*;

public class WriteToDataBase {

    String userName = "root";
    String password = "misha1234E!";
    String url = "jdbc:mysql://localhost:3306/PhoneFromCitilink";

    public  void write(String itemName,String itemPrice,String urlOnImage,String urlOnItemPage) throws SQLException {
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            System.out.println("Is connection ");
            String checkInclusion = "SELECT * FROM Phones where PhoneName = ? AND Price = ?";
            PreparedStatement statement = conn.prepareStatement(checkInclusion);
            statement.setString(1,itemName);
            statement.setString(2,itemPrice);



            if (!statement.execute())
            {
                String sql = "INSERT INTO Phones (PhoneName, Price, UrlOnImage, UrlOnPagePhone) Values (?, ? ,? ,?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1,itemName);
                preparedStatement.setString(2,itemPrice);
                preparedStatement.setString(3,urlOnImage);
                preparedStatement.setString(4,urlOnItemPage);
                int rows = preparedStatement.executeUpdate();
                System.out.println(rows + "rows added");


            }


        }
        catch (Exception e)
        {
            System.out.println("Connection failed");
            e.printStackTrace();
        }
    }


}