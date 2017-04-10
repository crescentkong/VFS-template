package hk.edu.polyu.comp3222.vfs.core.command;
import hk.edu.polyu.comp3222.vfs.core.FunctionManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipInputStream;

@SuppressWarnings("ALL")
public class CheckSize extends FunctionManager {

    public static String reply;
    final double kb = 1024.0;
    public CheckSize(){
        super();
    }

    @Override
    public void ope() throws IOException {
    }

    public String ope(String parameter) throws IOException {
        try {
                //System.out.println("Enter the path of the Virtual Disk: (e.g./Users/Public/COMP3222/home2.zip)");
        //tempVirDiskPath = keyRead.readLine();

        System.out.print("para"+ parameter);
        tempVirDiskPath  = parameter;

        File file = new File(tempVirDiskPath.toString());


        ZipInputStream zis = null;

        FileInputStream fis = new FileInputStream(tempVirDiskPath);
        int size = fis.available();
        System.out.println("size in KB : " + (int) Math.ceil(size/kb));
        reply = "size in KB : " + (int) Math.ceil(size/kb);
        zis = new ZipInputStream(fis);
    }
        catch (Exception e){
            reply = "Please Try Again";
        }
    return "Success";
    }

}