package Question2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Postgres 
{
    public static void main(String[] args) 
    {
        try 
        {
            Connection conn;
            String dbURL = "jdbc:postgresql://127.0.0.1:5432/new_db";
            String userName = "postgres";
            String password = "reenoip";
            conn = DriverManager.getConnection(dbURL, userName, password);
            String query = "select * from testdb.\"tbl_Cities\"";
            Statement st;
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) 
            {
                System.out.println(rs.getString("City_ID"));
                System.out.println(rs.getString("City_Name"));
            }
        } 
        catch (Exception ex) 
        {

            ex.printStackTrace();

        }

    }
}
