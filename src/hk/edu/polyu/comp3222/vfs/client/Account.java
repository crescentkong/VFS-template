package hk.edu.polyu.comp3222.vfs.client;

public class Account {
    private String id;
    private String pw;

    //Constructor for creating an Account object with provided id and pw.
    public Account(String id, String pw) {
        this.setId(id);
        this.setPw(pw);
    }

    private static Account instance;

    private Account() {
        System.out.println("Singleton(): Initializing Instance");
    }

    public static Account getInstance() {
        if (instance == null) {
            synchronized(Account.class) {
                if (instance == null) {
                    System.out.println("getInstance(): First time getInstance was invoked!");
                    instance = new Account();
                }
            }
        }
        return instance;
    }

    //Getter method for retrieving the internal value of the staff id.
    public String getId() {
        return id;
    }

     //Getter method for retrieving the internal value of the staff password.
    public String getPw() {
        return pw;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPw(String pw) {this.pw = pw;}

     //Overridden method to compute hashCode base on the values of the attributes
    public int hashCode() {
        final int prime = 37;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPw() == null) ? 0 : getPw().hashCode());
        return result;
    }

     //Overridden equals method to compare id and pw instead of just object references
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Account))
            return false;
        Account other = (Account) obj;
        if (getId() == null) {
            if (other.getId() != null)
                return false;
        } else if (!getId().equalsIgnoreCase(other.getId()))
            return false;
        if (getPw() == null) {
            if (other.getPw() != null)
                return false;
        } else if (!getPw().equals(other.getPw()))
            return false;
        return true;
    }
}