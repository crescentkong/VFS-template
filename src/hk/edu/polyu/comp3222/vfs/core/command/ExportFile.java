package hk.edu.polyu.comp3222.vfs.core.command;
import hk.edu.polyu.comp3222.vfs.core.FileManager;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class ExportFile extends FileManager {

    public static String reply;

    public ExportFile(){
        super();
    }

    @Override
    public void ope() throws IOException {
    }

    public String ope(String parameter) throws IOException {

        System.out.println("para:"+ parameter);
        String a = getFieldData(parameter,1," ");
        System.out.println("a:"+ a);
        String b = getFieldData(parameter,2," ");
        System.out.println("b:"+ b);
        String c = getFieldData(parameter,3," ");
        System.out.println("c:"+ c);



        VirDiskPath = "jar:file:" + a;
        tempAddNewFile = b;
        destinationPath = c;

        Path ZipFilePath1;
        URI zipFile = URI.create(VirDiskPath);

        //System.out.println("Enter the file that you want to Export: (e.g. happy.doc OR asas/a.doc)");
        //tempAddNewFile = keyRead.readLine(); //happy.doc OR asas/a.doc

        //System.out.println("Enter the destination Path: (e.g. C:\\Users\\Public)");
        //destinationPath = keyRead.readLine(); //C:\Users\Public
        if (tempAddNewFile.matches("(.*)" + "(/)"+ "(.*)"))
            destinationPath = destinationPath + "/" + tempAddNewFile.substring(tempAddNewFile.lastIndexOf("/") +1,tempAddNewFile.length()) ;
        else destinationPath = destinationPath + "/" + tempAddNewFile;
        File source = new File(destinationPath);

        try (FileSystem zipFileSys = FileSystems.newFileSystem(zipFile, attributes);) {
            ZipFilePath1 = zipFileSys.getPath(tempAddNewFile);
            Files.copy(ZipFilePath1, source.toPath());
            reply = tempAddNewFile + " Successfully Exported";
        }
        catch (Exception e){
            reply = "Please Try Again";
        }
        return "Success";
    }

}