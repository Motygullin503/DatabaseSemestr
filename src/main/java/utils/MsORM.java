package utils;

import interfaces.ORM;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by UseR7 on 16.12.2016.
 */
public class MsORM implements ORM {

    /*
    Имплементация двух методов ORM insert() и selectAll(), необходимых для взаимодействия программы с базой данных
     */

    Field[] fields;


    public ArrayList selectAll(Class c) throws SQLException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        Connection conn = DatabaseUtil.getConn();

        ArrayList list = new ArrayList();

        fields = c.getDeclaredFields();
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM [semestr].dbo." + c.getName().substring(9) + "s");

        Method[] methods = c.getMethods();
        List<String> methodsNames = new ArrayList<String>();
        List<Method> methodList = new ArrayList<Method>();

        for(int i=0; i<fields.length; i++) {
            for (Method method : methods) {

                if (method.getName().startsWith("set") && method.getName().endsWith(fields[i].getName().substring(1))) {
                    methodsNames.add(method.getName().replace("entities."+c.getName()+".",""));
                    break;
                }
            }
        }

        for (int i = 0; i < methodsNames.size(); i++) {
            Method method = c.getMethod(methodsNames.get(i), fields[i].getType());
            methodList.add(method);
        }

        while (rs.next()) {
            c = Class.forName(c.getName());
            Object object = c.newInstance();
            int i =0;
            for (Field f : fields) {
                String type = String.valueOf(f.getType());

                if (type.equals("int")) {
                    methodList.get(i)
                            .invoke(object,(rs.getInt(f.toString()
                                    .replace("int " + c.getName() + ".", "")
                                    .replace("private ",""))));
                    i++;
                } else if (type.equals("class java.lang.String")) {
                    methodList.get(i)
                            .invoke(object,(rs.getString(f.toString()
                                    .replace("java.lang.String " + c.getName() + ".", "")
                                    .replace("private ",""))));
                    i++;
                }

            }
            list.add(object);
        }
        return list;
    }
/*
Имплементация метода определяемого хранимой процедурой findServiceById_procedure,
которая отвечает за выдачу всех сервисов представляемых данной компанией
 */
    public ArrayList<String> findServicesById(int id) throws SQLException {
        Connection conn = DatabaseUtil.getConn();
        ResultSet rs = conn.createStatement().executeQuery("EXEC [semestr].dbo.findServicesById_procedure "+id);
        ArrayList list= new ArrayList();
        while (rs.next()){
            list.add(rs.getString("service_name"));
        }
        return list;
    }
/*
Выборка данных одной колонки по ее имени
 */
    public ArrayList<String> selectColumn(Class c, String columnName) throws SQLException {
        Connection conn = DatabaseUtil.getConn();
        ArrayList<String> values = new ArrayList<String>();

        ResultSet rs = conn.createStatement().executeQuery("SELECT "+columnName+" FROM [semestr].dbo."+c.getName().substring(9)+"s");

        while (rs.next()){
            values.add(rs.getString(columnName));
        }

    return values;
    }

    public void insert(Class c, Object instance) throws NoSuchMethodException, SQLException, InvocationTargetException, IllegalAccessException {
        Connection conn = DatabaseUtil.getConn();

        fields = c.getDeclaredFields();

        Method[] methods = c.getMethods();
        List<String> methodsNames = new ArrayList<String>();
        List<Method> methodList = new ArrayList<Method>();
        for(int i=0; i<fields.length; i++) {
            for (Method method : methods) {

                if (method.getName().startsWith("get") && method.getName().endsWith(fields[i].getName().substring(1))) {
                    methodsNames.add(method.getName());
                    break;
                }
            }
        }
        for (int i = 0; i < methodsNames.size(); i++) {
            Method method = c.getMethod(methodsNames.get(i));
            methodList.add(method);
        }
        String preparedString = "INSERT INTO " +c.getName().substring(9)+"s (";
        for(int i=1; i<fields.length; i++){
            preparedString = preparedString + fields[i].getName()+", ";
        }

        preparedString = preparedString.substring(0, preparedString.length()-2)+") VALUES (";

        for(int i=1; i<fields.length; i++){
            preparedString = preparedString+"?,";
        }
        preparedString = preparedString.substring(0, preparedString.length()-1)+");";

        PreparedStatement statement = conn.prepareStatement(preparedString);
        for (int i = 1; i<fields.length; i++ ){
            try {
                if(methodList.get(i).invoke(instance) instanceof Integer){
                    statement.setInt(i, (Integer) methodList.get(i).invoke(instance));
                } else if(methodList.get(i).invoke(instance) instanceof String){
                    statement.setString(i, (String) methodList.get(i).invoke(instance));
                }

            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } statement.executeUpdate();
        System.out.println("New row was added successfully");
    }

    public void update(Class c, Object instance, String columnName){
        Connection conn = DatabaseUtil.getConn();


    }

    public void delete(Class c, Object instance){
        Connection conn = DatabaseUtil.getConn();

        fields = c.getDeclaredFields();

        Method[] methods = c.getMethods();


    }
}
