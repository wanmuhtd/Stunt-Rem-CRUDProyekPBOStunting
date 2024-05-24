/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;

import Model.User;
import java.util.List;

/**
 *
 * @author Arwan Muhtada
 */
public interface IDAOUser {
    public boolean addUser(User b);
    public boolean authenticate(String email, String nama);
}
