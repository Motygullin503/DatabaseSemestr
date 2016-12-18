package interfaces;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;


public interface ORM {
    ArrayList selectAll(Class c) throws SQLException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException;
    void insert(Class c, Object instance) throws NoSuchMethodException, SQLException, InvocationTargetException, IllegalAccessException;
    void update(Class c, Object instance, String columnName);
    void delete(Class c, Object instance);
    ArrayList selectColumn(Class c, String columnName) throws SQLException;
}
