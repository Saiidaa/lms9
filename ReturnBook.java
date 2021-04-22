import ви.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReturnBook {
    public static int updateBook(String bookNom){
        int status=0;
        int quantity=0,issued=0;
        try{
            Connection con= DB.getConnection();

            PreparedStatement ps=con.prepareStatement("select quantity");
            ps.setString(1, bookNom);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                quantity=rs.getInt("quantity");
                issued=rs.getInt("issued");
            }

            if(issued>0){
                PreparedStatement ps2=con.prepareStatement("update books ");
                ps2.setInt(1,quantity+1);
                ps2.setInt(2,issued-1);
                ps2.setString(3, bookNom);

                status=ps2.executeUpdate();
            }
            con.close();
        }catch(Exception r){System.out.println(r);}
        return status;
    }
}
