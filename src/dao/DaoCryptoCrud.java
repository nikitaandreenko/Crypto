package dao;

import model.Crypto;
import util.ReadingDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoCryptoCrud extends ReadingDatabase implements DaoCrypto {

    private Connection connection = getConnection();


    @Override
    public void add(Crypto crypto) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO crypto.crypto (id, symbol, name, price_usd) " +
                "VALUES(?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, crypto.getId());
            preparedStatement.setString(2, crypto.getSymbol());
            preparedStatement.setString(3, crypto.getName());
            preparedStatement.setDouble(4, crypto.getPrice_usd());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }

    @Override
    public List<Crypto> getAll() throws SQLException {
        List<Crypto> cryptoList = new ArrayList<>();

        String sql = "SELECT id, symbol, name, price_usd FROM crypto.crypto";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Crypto crypto = new Crypto();
                crypto.setId(resultSet.getInt("id"));
                crypto.setSymbol(resultSet.getString("symbol"));
                crypto.setName(resultSet.getString("name"));
                crypto.setPrice_usd(resultSet.getDouble("price_usd"));

                cryptoList.add(crypto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cryptoList;
    }

    @Override
    public Crypto getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT id, symbol, name, price_usd FROM crypto.crypto WHERE id=?";

        Crypto crypto = new Crypto();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                crypto.setId(resultSet.getInt("id"));
                crypto.setSymbol(resultSet.getString("symbol"));
                crypto.setName(resultSet.getString("name"));
                crypto.setPrice_usd(resultSet.getDouble("price_usd"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return crypto;
    }


    @Override
    public void update(Crypto crypto) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE crypto.crypto SET symbol=?, name=?, price_usd=? WHERE id=?";


        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, crypto.getSymbol());
            preparedStatement.setString(2, crypto.getName());
            preparedStatement.setDouble(3, crypto.getPrice_usd());
            preparedStatement.setInt(4, crypto.getId());
            int count = preparedStatement.executeUpdate();
            //preparedStatement.executeUpdate();
            if (count !=1) {
                throw new SQLException("On update modify more then 1 record" + count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void remove(Crypto crypto) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM crypto.crypto WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, crypto.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
