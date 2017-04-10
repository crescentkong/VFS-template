package hk.edu.polyu.comp3222.vfs.core.command;
import hk.edu.polyu.comp3222.vfs.core.FunctionManager;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("ALL")
public class DeleteVD extends FunctionManager {

    public static String reply;

    public DeleteVD(){
        super();
    }

    @Override
    public void ope() throws IOException {
    }

    public String ope(String parameter) throws IOException {
        //System.out.println("Enter the path of the Virtual Disk to be Deleted: (e.g./Users/Public/COMP3222/home2.zip)");

        //tempVirDiskPath = keyRead.readLine();

        System.out.print("para"+ parameter);
        //VirDiskPath = "jar:file:" + parameter;
        tempDeleteVDisk = parameter;

        File file = new File(tempDeleteVDisk.toString());
        boolean deleted = file.delete();
        if (deleted){
            System.out.println("About to delete an entry from ZIP File" + tempDeleteVDisk.toString());
            System.out.println("File successfully deleted");
            reply = parameter + " Successfully Deleted";
        } else reply = "Please Try Again";
        return "Success";}
}