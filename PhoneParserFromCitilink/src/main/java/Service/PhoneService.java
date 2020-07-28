package Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneService implements PhoneDAO {
    @Override
    public void add(Phone phone) throws SQLException {
        Connection connection = ConnectionDB.getConnection();

        String sql = "INSERT INTO Phones (PhoneName, Price, UrlOnImage, UrlOnPagePhone) Values (?, ? ,? ,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,phone.getName());
        preparedStatement.setString(2,phone.getPrice());
        preparedStatement.setString(3,phone.getUrlOnImage());
        preparedStatement.setString(4,phone.getUrlOnPagePhone());
        preparedStatement.execute();
    }

    @Override
    public Phone getById(int id) throws SQLException {
        Phone phone = new Phone();
        String sql = "SELECT * FROM Phones WHERE id = " + id;
        Connection connection = ConnectionDB.getConnection();
        Statement statement= connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            if (resultSet.getInt("id") == id){
                phone.setId(resultSet.getInt("id"));
                phone.setName(resultSet.getString("PhoneName"));
                phone.setPrice(resultSet.getString("Price"));
                phone.setUrlOnImage(resultSet.getString("UrlOnImage"));
                phone.setUrlOnPagePhone(resultSet.getString("UrlOnPagePhone"));
            }
        }
        return phone;
    }

    @Override
    public void update(Phone phone) throws SQLException {
        String sql = "UPDATE Phones SET phoneName='" + phone.getName() + "',  Price='" + phone.getPrice() + "',  UrlOnImage='" + phone.getUrlOnImage() + "' ,  UrlOnPhonePage='" + phone.getUrlOnPagePhone() + "' WHERE id=" + phone.getId();
        Connection connection = ConnectionDB.getConnection();
        Statement statement = connection.createStatement();
        statement.execute(sql);
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Phones WHERE id=" + id;
        Connection connection = ConnectionDB.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
    }

    @Override
    public List<Phone> getAll() throws SQLException {
        String sql = "SELECT * FROM Phones";
        List<Phone> phoneList = new ArrayList<>();
        Connection connection = ConnectionDB.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            Phone phone = new Phone();
            phone.setId(resultSet.getInt("id"));
            phone.setName(resultSet.getString("PhoneName"));
            phone.setUrlOnPagePhone(resultSet.getString("UrlOnPagePhone"));
            phone.setUrlOnImage(resultSet.getString("UrlOnImage"));
            phone.setPrice(resultSet.getString("Price"));
            phoneList.add(phone);
        }

        return phoneList;
    }
    public void truncateTable() throws SQLException {
        String sql = "TRUNCATE TABLE Phones;";
        Connection connection = ConnectionDB.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
    }
}
