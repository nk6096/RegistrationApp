
package db;
import java.sql.*;
public class DBConnect {
    static public Connection con;
    static public Statement st;
    static public PreparedStatement checkLogin;
    static public PreparedStatement addUser;
    static public PreparedStatement getUserLike;
    static public PreparedStatement updateUser;
    static public PreparedStatement deleteUser;
    static{
        try{
//Class.forName("com.mysql.jdbc.Driver");
//con=DriverManager.getConnection("jdbc:mysql://localhost:3306/regdb12","root","incapp");
Class.forName("oracle.jdbc.driver.OracleDriver");
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","regdb","regdb"); 
st=con.createStatement();
checkLogin=con.prepareStatement(
        "select * from admin_login where aid=? and pass=?");
addUser=con.prepareStatement(
 "insert into student (name,gender,dob,country,skills,address) "
         + "values(?,?,?,?,?,?)");
getUserLike=con.prepareStatement(
        "select * from student where name like ?");
updateUser=con.prepareStatement(
 "update student set name=?,gender=?,dob=?,country=?,skills=?,address=? "
         + " where cid=?");
deleteUser=con.prepareStatement(
 "delete student where cid=?");
        }catch(Exception ex){  ex.printStackTrace();  }
    }
}
