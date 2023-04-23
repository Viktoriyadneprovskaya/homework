package app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {

   private static String DB_URL ="jdbc:postgresql://localhost:5432/postgres";
   private static String DB_USERNAME = "postgres";
   private static String DB_PASSWORD = "mkibsh2503";

   public static Connection getConnection() throws SQLException {
     return DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
   }
}
