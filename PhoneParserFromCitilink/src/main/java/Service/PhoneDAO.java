package Service;

import java.sql.SQLException;
import java.util.List;

public interface PhoneDAO {
    void add(Phone phone)throws SQLException,ClassNotFoundException;
    Phone getById(int id)throws SQLException,ClassNotFoundException;
    void update(Phone phone)throws SQLException,ClassNotFoundException;
    void delete(int id)throws SQLException,ClassNotFoundException;
    List<Phone> getAll()throws SQLException,ClassNotFoundException;
}
