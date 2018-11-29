package sample;

import java.lang.*;
import java.lang.String;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

public class baseConnect {

    Connection conn = null;
    Statement stmt = null;
    public ObservableList<pojoAI> list = FXCollections.observableArrayList();
    String sql = "Select * FROM benz_main";

    void Connection ()
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:benz.db");
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                //Проходим построчно по выборке и сохраняем ячейки в переменные, добавляем в коллекцию
                String tableBenz_nameAzs = rs.getString("name_azs");
                String tableBenz_ai_80 = rs.getString("ai_80");
                String tableBenz_ai_92 = rs.getString("ai_92");
                String tableBenz_ai_92_plus = rs.getString("ai_92_plus");
                String tableBenz_ai_95 = rs.getString("ai_95");
                String tableBenz_ai_95_plus = rs.getString("ai_95_plus");
                String tableBenz_ai_98 = rs.getString("ai_98");
                String tableBenz_ai_100 = rs.getString("ai_100");
                String tableBenz_ai_DT = rs.getString("ai_DT");
                String tableBenz_ai_DT_plus = rs.getString("ai_DT_plus");
                String tableBenz_ai_Propan = rs.getString("ai_Propan");
                String tableBenz_ai_Metan = rs.getString("ai_Metan");
                String tableBenz_adress = rs.getString("Adress");

                list.add(new pojoAI(tableBenz_nameAzs, tableBenz_ai_80, tableBenz_ai_92, tableBenz_ai_92_plus,
                        tableBenz_ai_95, tableBenz_ai_95_plus, tableBenz_ai_98,
                        tableBenz_ai_100, tableBenz_ai_DT, tableBenz_ai_DT_plus,
                        tableBenz_ai_Propan, tableBenz_ai_Metan, tableBenz_adress));
            }
        }

     catch (ClassNotFoundException e) {
        e.printStackTrace();
        System.out.println("no connect");
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("no connect");
    }


    }

}


