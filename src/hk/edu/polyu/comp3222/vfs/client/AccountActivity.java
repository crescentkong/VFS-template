package hk.edu.polyu.comp3222.vfs.client;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings("ALL")
public class AccountActivity {
    public static final HashMap<String, Account> accounts = new HashMap<String, Account>();
    protected static Account currentAccount = null;
    // hard coded rooms and accounts

    static String username = "admin";
    static String password = "admin";

    static {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("src/userinfo.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String str;

        List<String> list = new ArrayList<String>();
        try {
            while((str = in.readLine()) != null){
                list.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < list.size();) {
            username = list.get(i);
            System.out.println(username);
            password = list.get(i+1);
            System.out.println(password);
            accounts.put(username, new Account(username, password));
            i=i+2;
        }


        //accounts.put("admin", new Account("admin", "admin"));
        //accounts.put("user", new Account("user", "user"));
    }

    public static boolean checkExist(Account ac){
        if (ac != null && accounts.containsKey(ac.getId())) {
            return true;
        }
        return false;
    }

    public static String createAcc(Account ac)  {
        accounts.put(ac.getId(), new Account(ac.getId(), ac.getPw()));
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("src/userinfo.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String str;

        List<String> list = new ArrayList<String>();
        try {
            while((str = in.readLine()) != null){
                list.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        list.add(ac.getId());
        list.add(ac.getPw());

        try {
            FileWriter fw = new FileWriter("src/userinfo.txt");
            for (int i = 0; i < list.size(); i++) {
                fw.write(list.get(i));
                fw.write(System.getProperty("line.separator"));
            }
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    return "Success";
    }

    /**
     * @param ac
     * @return
     */
    //Authentication method, checks whether the username and password is a known user in our accounts records.
    public static boolean login(Account ac) {
        if (ac != null && accounts.containsKey(ac.getId())) {
            if (accounts.get(ac.getId()).getPw().equals(ac.getPw())) {
                currentAccount = accounts.get(ac.getId());
                return true;
            }
        }
        return false;
    }

    /**
     * @return
     */
    public Account getAccount() {
        return currentAccount;
    }
    
}