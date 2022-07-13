package dao;

import model.Crypto;

import java.sql.SQLException;
import java.util.List;

public interface DaoCrypto {

    //create
    void add(Crypto crypto) throws SQLException;

    //read
    List<Crypto> getAll() throws SQLException;

    Crypto getById(int id) throws SQLException;

    //update
    void update(Crypto crypto) throws SQLException;

    //delete
    void remove(Crypto crypto) throws SQLException;

}
