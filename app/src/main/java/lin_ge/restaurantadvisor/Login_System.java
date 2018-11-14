package lin_ge.restaurantadvisor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class Login_System implements Serializable{

    private HashMap<String, String> logins;

    public Login_System()
    {
        logins = new HashMap<String, String>();
    }

    /**
     * puts user into system if unique username
     * @param username
     * @param password
     * @return whether put user in
     */
    public boolean putUser(String username, String password)
    {
        if(logins.containsKey(username))
            return false;
        logins.put(username, password);
        return true;
    }


    /**
     * String representation of system
     */
    @Override
    public String toString()
    {
        return logins.entrySet().toString();
    }

    /**
     * saves login system for use later on
     * @param system login system used
     */
    public static void serializeOBJ(Login_System system)
    {
        try
        {
            FileOutputStream file = new FileOutputStream("login.dat");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(system);
            out.close();
            file.close();
        }
        catch(Exception e)
        {
            return;
        }
    }

    /**
     * puts all previous logins back into hashmap
     * @return deserialized obj
     */
    public static Login_System deserializeOBJ()
    {
        Login_System log = new Login_System();
        try
        {
            FileInputStream file = new FileInputStream("login.dat");
            @SuppressWarnings("resource")
            ObjectInputStream in = new ObjectInputStream(file);
            log = (Login_System)in.readObject();
        }
        catch(Exception e)
        {
            return log;
        }
        return log;
    }

    /**
     * when user login, method check if right login
     * @param username
     * @param password
     * @return
     */
    public boolean isRight(String username, String password)
    {
        return logins.containsKey(username) && logins.containsValue(password);
    }
}

