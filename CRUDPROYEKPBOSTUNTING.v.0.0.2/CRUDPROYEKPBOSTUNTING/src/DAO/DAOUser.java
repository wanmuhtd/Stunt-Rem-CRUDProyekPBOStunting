/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DAO;
import DAOInterface.IDAOUser;
import Helper.KoneksiDB;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
/**
 *
 * @author $arwan
 */
public class DAOUser implements IDAOUser {
    public DAOUser()
    {
        con = KoneksiDB.getConnection();
    }
    
    @Override
    public boolean addUser(User b)
    {
        boolean result = true;
        PreparedStatement statement = null;
        
        if (b.getNama().isEmpty() || b.getEmail().isEmpty() || b.getPassword().isEmpty() || b.getNo_tlp().isEmpty()) {
            System.out.println("Input tidak lengkap");
            result = false; // Langsung kembalikan false jika ada field kosong
        } else {
            try
            {
                statement = con.prepareStatement(strInsert);

                statement.setString(1, b.getNama());
                statement.setString(2, b.getEmail());
                statement.setString(3, b.getPassword());
                statement.setString(4, b.getNo_tlp());
                statement.execute();
            }catch(SQLException e)
            {
                System.out.println("gagal input");
                result = false;
            }
            finally
            {
                try
                {
                    statement.close();
                } catch (SQLException ex)
                {
                    System.out.println("gagal input");
                    result = false;
                }
            }
        }
        
        
        return result;
    }
    
    @Override
    public boolean authenticate(String email, String password)
    {
        boolean result;
        boolean ce = checkEmail(email); 
        if(ce){
            String pass = getPass(email);
            if (pass.equals(password)){
                result = true;
            } else {
                result = false;
            }
        } else {
            result = false;
        }
        return result;
    }
    
    public boolean checkEmail(String email)
    {
        boolean result = false;
        PreparedStatement statement = null;
        try
        {
            statement = con.prepareStatement(strCheckEmail);
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e)
        {
            System.out.println("gagal mengautentikasi");
            result = false;
        } finally
        {
            try
            {
                statement.close();
            } catch (SQLException ex)
            {
                System.out.println("gagal mengautentikasi");
                result = false;
            }
        }
        return result;
    }
    
    public String getPass(String email)
    {
        String pass = null;
        PreparedStatement statement = null;
        try
        {
            statement = con.prepareStatement(strGetPass);
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                return pass = rs.getString("password");
            }
        } catch (SQLException e)
        {
            System.out.println("gagal mengautentikasi");
            pass = null;
        } finally
        {
            try
            {
                statement.close();
            } catch (SQLException ex)
            {
                System.out.println("gagal mengautentikasi");
                pass = null;
            }
        }
        return pass;
    }
    /*
    @Override
    public boolean authenticate(String email, String nama){
        boolean result = true;
        PreparedStatement statement = null;
        PreparedStatement stt = null;
        try
        {
            statement = con.prepareStatement(strCheckEmail);
            statement.setString(1, "%"+email+"%");
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                stt = con.prepareStatement(strCheckPass);
                stt.setString(1, "%"+email+"%");
                ResultSet rs2 = stt.executeQuery();
                System.out.println(rs2.getString("password"));
                result = (rs2.getString("password").equals(nama));
            }
        } catch (SQLException e)
        {
            System.out.println("gagal mengautentikasi");
            result = false;
        }
        finally
        {
            try
            {
                statement.close();
            } catch (SQLException ex)
            {
                System.out.println("gagal mengautentikasi");
                result = false;
            }
        }
        return result;
    }
    */
    Connection con;
    String strInsert = "insert into user (nama,email,password,no_tlp) values (?,?,?,?);";
    String strCheckEmail = "SELECT COUNT(*) FROM user WHERE email = ?;";
    String strGetPass = "SELECT password FROM user WHERE email = ?;";
}
