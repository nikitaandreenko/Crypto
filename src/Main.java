import dao.DaoCryptoCrud;
import model.Crypto;
import user.User;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        DaoCryptoCrud daoCryptoCrud = new DaoCryptoCrud();
        //просмотр списка доступных валют
        System.out.println(daoCryptoCrud.getAll());
        //получаю текущую криптовалюту по id
        System.out.println(daoCryptoCrud.getById(90));
        //регистрирую пользователя c привязкой криптовалюты по id 90
        User user = new User("Mike", "Watkinson", 90,
                "Bitcoin",6465.26);
        //просмотр актуальной цены для указаной криптовалюты по id
        user.actualPriceForCrypto(90);
        //метод проверки актуальной цены и первоначальной цены
        user.actualPrice(user, 90);
    }
}