import ви.DB;

import java.sql.*;
public class IssueBook {

    public static boolean checkBook(String bookNom){
        boolean status=false;
        try{
            Connection con= DB.getConnection();
            PreparedStatement ps=con.prepareStatement("select nom");
            ps.setString(1, bookNom);
            ResultSet rs=ps.executeQuery();
            status=rs.next();
            con.close();
        }catch(Exception r){System.out.println(r);}
        return status;
    }

    public static int save(String bookNom, int studentid, String studentname, String studentcontact){
        int status=0;
        try{
            Connection con=DB.getConnection();
            status=updatebook(bookNom);
            if(status>0){
                PreparedStatement ps=con.prepareStatement("insert into issuebooks");
                ps.setString(1,bookNom);
                ps.setInt(2,studentid);
                ps.setString(3,studentname);
                ps.setString(4,studentcontact);
                status=ps.executeUpdate();
            }

            con.close();
        }catch(Exception r){System.out.println(r);}
        return status;
    }
    public static int updatebook(String bookNom){
        int status=0;
        int quantity=0,issued=0;
        try{
            Connection con=DB.getConnection();

            PreparedStatement ps=con.prepareStatement("select quantity,issued from books where callno=?");
            ps.setString(1, bookNom);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                quantity=rs.getInt("quantity");
                issued=rs.getInt("issued");
            }

            if(quantity>0){
                PreparedStatement ps2=con.prepareStatement("update books");
                ps2.setInt(1,quantity-1);
                ps2.setInt(2,issued+1);
                ps2.setString(3, bookNom);

                status=ps2.executeUpdate();
            }
            con.close();
        }catch(Exception r){System.out.println(r);}
        return status;
    }
}
