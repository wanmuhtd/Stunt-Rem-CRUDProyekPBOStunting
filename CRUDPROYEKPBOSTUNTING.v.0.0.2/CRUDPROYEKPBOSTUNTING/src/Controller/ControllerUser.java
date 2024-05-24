/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Controller;
import DAO.DAOUser;
import DAOInterface.IDAOUser;
import Model.User;
import View.SignUp;
import View.SignUpConfirm;
import View.LogIn;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author $arwan
 */
public class ControllerUser {
    public ControllerUser(SignUp dftr)
    {
        this.dftr = dftr;
        iUser = new DAOUser();
    }
    
    public ControllerUser(LogIn msk)
    {
        this.msk = msk;
        iUser = new DAOUser();
    }
    
    public ControllerUser(SignUpConfirm suc)
    {
        this.suc = suc;
        iUser = new DAOUser();
    }
    
    public void addUser()
    {
        boolean conf = ((dftr.getTxtPassword().getText()).equals(dftr.getTxtConfirmPassword().getText()));
        if (conf)
        {
            User b = new User();
            b.setNama(dftr.getTxtNama().getText());
            b.setEmail(dftr.getTxtEmail().getText());
            b.setPassword(dftr.getTxtPassword().getText());
            b.setNo_tlp(dftr.getTxtNoTlp().getText());
            boolean res = iUser.addUser(b);
            
            if (res){
                SignUpConfirm confirmSignUp = new SignUpConfirm();
                confirmSignUp.setVisible(true);
                // Menutup form pendaftaran
                dftr.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Gagal/ Data Belum Lengkap/ Data Duplikat");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Konfirmasi Kata Sandi tidak sesuai dengan Kata Sandi");
        }
    }
    
    public boolean authenticate(JTextField email, JTextField password)
    {
        boolean res = iUser.authenticate(email.getText(), password.getText());
        if (res){
            SignUpConfirm confirmSignUp = new SignUpConfirm();
            confirmSignUp.setVisible(true);
            // Menutup form pendaftaran
            msk.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Email atau Kata Sandi tidak sesuai");
        }
        return res;
    }
    
    public void login(JFrame currentFrame)
    {
        LogIn lgn = new LogIn();
        lgn.setVisible(true);
        // Menutup form sebelumnya
        currentFrame.dispose();
    }
    
    public void signup(JFrame currentFrame)
    {
        SignUp sgn = new SignUp();
        sgn.setVisible(true);
        // Menutup form sebelumnya
        currentFrame.dispose();
    }
    
    IDAOUser iUser;
    SignUp dftr;
    LogIn msk;
    SignUpConfirm suc;
}
