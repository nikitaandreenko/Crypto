package user;

import dao.DaoCrypto;
import dao.DaoCryptoCrud;
import model.Crypto;

import java.sql.SQLException;

//create user;
public class User {
    private String name;
    private String surname;
    //private Crypto crypto;
    private int idCrypto;
    private String nameCrypto;
    private double priceCrypto;


    public User(String name, String surname, int idCrypto, String nameCrypto, double priceCrypto) {
        this.name = name;
        this.surname = surname;
        this.idCrypto = idCrypto;
        this.nameCrypto = nameCrypto;
        this.priceCrypto = priceCrypto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getIdCrypto() {
        return idCrypto;
    }

    public void setIdCrypto(int idCrypto) {
        this.idCrypto = idCrypto;
    }

    public String getNameCrypto() {
        return nameCrypto;
    }

    public void setNameCrypto(String nameCrypto) {
        this.nameCrypto = nameCrypto;
    }

    public double getPriceCrypto() {
        return priceCrypto;
    }

    public void setPriceCrypto(double priceCrypto) {
        this.priceCrypto = priceCrypto;
    }

    //метод запроса актуальной цены из БД
    public void actualPriceForCrypto(DaoCryptoCrud daoCryptoCrud, int id) throws SQLException {
        Crypto crypto = daoCryptoCrud.getById(id);
        System.out.println("Actual price for " + crypto.getName() + ":" + crypto.getPrice_usd());
    }

    //метод проверки актуальной цены и первоначальной цены
    public void actualPrice(User user, int id) throws SQLException {
        DaoCryptoCrud daoCryptoCrud = new DaoCryptoCrud();
        double differencePrice = daoCryptoCrud.getById(id).getPrice_usd() - user.priceCrypto;
        if (differencePrice > 0) {
            double changePrice = (differencePrice / user.priceCrypto)*100;
            if (changePrice > 1) {
                System.out.println("Crypto: " + id);
                System.out.println("User: " + user.getName());
                System.out.println("Percent increased for: " + changePrice);
            }
        }
        else if (differencePrice < 0){
            double changePrice = (-differencePrice / user.priceCrypto)*100;
            if (changePrice > 1){
            System.out.println("Crypto: " + id);
            System.out.println("User: " + user.getName());
            System.out.println("Percent decreased for: " + changePrice);
        }
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", idCrypto=" + idCrypto +
                ", nameCrypto='" + nameCrypto + '\'' +
                ", priceCrypto=" + priceCrypto +
                '}';
    }
}
