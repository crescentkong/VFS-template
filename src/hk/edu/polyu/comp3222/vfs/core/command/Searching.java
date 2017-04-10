package hk.edu.polyu.comp3222.vfs.core.command;
import hk.edu.polyu.comp3222.vfs.core.FunctionManager;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Created by Fiona on 4/8/2017.
 */
@SuppressWarnings("ALL")
public class Searching extends FunctionManager {

    public static String reply;

    public Searching(){
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
        String d = getFieldData(parameter,4," ");
        System.out.println("d:"+ d);
        String e = getFieldData(parameter,5," ");
        System.out.println("e:"+ e);


        searchPath = "jar:file:" + a;
        System.out.println(searchPath);
        tempSearchFileFolder = b;
        tempSearchWord =  c;
        tempCaseSensitive = d;
        tempMatchAllKeywords = e;

        //Path searchFile = Paths.get("a.doc");
        Path searchFile = Paths.get(tempSearchWord);
        Search walk = new Search(searchFile);

        ZipFile zipFile = new ZipFile(a);

        Enumeration<? extends ZipEntry> entries = zipFile.entries();

        reply = "";
        int matchNo = 0;

        ArrayList<String> ar = new ArrayList<String>();

        ArrayList<String> arFile = new ArrayList<String>();

        while(entries.hasMoreElements()) {

            ZipEntry entry = entries.nextElement();
            tempEntry = entry.toString();
            if (tempEntry.matches("(.*)" + ("/") )){
                ar.add(tempEntry);
            }
            if (!tempEntry.matches("(.*)" + ("/") )){
                arFile.add(tempEntry);
            }


            InputStream stream = zipFile.getInputStream(entry);

        }

        if (tempSearchFileFolder.equals("Folder")) {
            //for (String ent : ar) {
            for (int i = 0; i < ar.size(); i++) {

                if (tempCaseSensitive.equals("CaseSensitive")) {
                    if (tempMatchAllKeywords.equals("MatchAll")) {
                        if (ar.get(i).equals(tempSearchWord + "/")||(ar.get(i).matches("(.*)" + "(/)" + tempSearchWord+ "(/)"))) {
                            matchNo = matchNo +1;
                            System.out.println("ZIP File Contains " + searchFile +
                                    " at " + ar.get(i));
                            if (matchNo == 1){
                                reply = "ZIP File Contains " + searchFile +
                                        " at " + ar.get(i);
                            }
                            else if (matchNo > 1) {
                                reply = reply + " ; " + "ZIP File Contains " + searchFile +
                                        " at " + ar.get(i);
                            }
                            walk.file_found_flag = true;
                        }

                    }

                    if (tempMatchAllKeywords.equals("MatchAny")) {
                        if (ar.get(i).matches("(.*)" + tempSearchWord + "(.*)" + "(/)")) {
                            //if (i > 0) {
                            //for (int j = 0; j < (ar.size() - 1); j++) {
                            //if (!ar.get(i).matches(ar.get(j) + "(.*)")) {
                            matchNo = matchNo +1;
                            System.out.println("ZIP File Contains " + searchFile +
                                    " at " + ar.get(i));
                            if (matchNo == 1){
                                reply = "ZIP File Contains " + searchFile +
                                        " at " + ar.get(i);
                            }
                            else if (matchNo > 1) {
                                reply = reply + " ; " + "ZIP File Contains " + searchFile +
                                        " at " + ar.get(i);
                            }
                            walk.file_found_flag = true;
                        }
                    }
                }

                if (tempCaseSensitive.equals("CaseInsensitive")) {
                    if (tempMatchAllKeywords.equals("MatchAll")) {
                        if (ar.get(i).toLowerCase().matches((tempSearchWord + "/").toLowerCase())||(ar.get(i).matches(("(.*)" + "(/)" + tempSearchWord+ "(/)").toLowerCase()))) {

                           // if (ar.get(i).equals(tempSearchWord + "/")||(ar.get(i).matches("(.*)" + "(/)" + tempSearchWord+ "(/)")))

                            matchNo = matchNo +1;
                            System.out.println("ZIP File Contains " + searchFile +
                                    " at " + ar.get(i));
                            if (matchNo == 1){
                                reply = "ZIP File Contains " + searchFile +
                                        " at " + ar.get(i);
                            }
                            else if (matchNo > 1) {
                                reply = reply + " ; " + "ZIP File Contains " + searchFile +
                                        " at " + ar.get(i);
                            }
                            walk.file_found_flag = true;
                        }


                    }
                    if (tempMatchAllKeywords.equals("MatchAny")) {
                        if (ar.get(i).toLowerCase().matches("(.*)".toLowerCase() + tempSearchWord.toLowerCase() + "(.*)".toLowerCase() + "(/)")) {
                            matchNo = matchNo +1;
                            System.out.println("ZIP File Contains " + searchFile +
                                    " at " + ar.get(i));
                            if (matchNo == 1){
                                reply = "ZIP File Contains " + searchFile +
                                        " at " + ar.get(i);
                            }
                            else if (matchNo > 1) {
                                reply = reply + " ; " + "ZIP File Contains " + searchFile +
                                        " at " + ar.get(i);
                            }
                            walk.file_found_flag = true;
                        }
                    }
                }
            }
            if (matchNo == 0){
                reply = "ZIP File does not contain " + searchFile;;
            }
        }


        if (tempSearchFileFolder.equals("File")) {
//            for (String entFile : arFile)
//                System.out.println(entFile);
            for (int i = 0; i < arFile.size(); i++) {

                if (tempCaseSensitive.equals("CaseSensitive")) {
                    if (tempMatchAllKeywords.equals("MatchAll")) {
                        if ((arFile.get(i).equals(tempSearchWord))||(arFile.get(i).matches("(.*)" + "(/)" + tempSearchWord))){
                            matchNo = matchNo +1;
                            System.out.println("ZIP File Contains " + searchFile +
                                    " at " + arFile.get(i));
                            if (matchNo == 1){
                                reply = "ZIP File Contains " + searchFile +
                                        " at " + arFile.get(i);
                            }
                            else if (matchNo > 1) {
                                reply = reply + " ; " + "ZIP File Contains " + searchFile +
                                        " at " + arFile.get(i);
                            }
                            walk.file_found_flag = true;
                        }

                    }

                    if (tempMatchAllKeywords.equals("MatchAny")) {
                        if (arFile.get(i).matches("(.*)" + tempSearchWord + "(.*)" )) {
                            //if (i > 0) {
                            //for (int j = 0; j < (ar.size() - 1); j++) {
                            //if (!ar.get(i).matches(ar.get(j) + "(.*)")) {
                            matchNo = matchNo +1;
                            System.out.println("ZIP File Contains " + searchFile +
                                    " at " + arFile.get(i));
                            if (matchNo == 1){
                                reply = "ZIP File Contains " + searchFile +
                                        " at " + arFile.get(i);
                            }
                            else if (matchNo > 1) {
                                reply = reply + " ; " + "ZIP File Contains " + searchFile +
                                        " at " + arFile.get(i);
                            }
                            walk.file_found_flag = true;
                            //}
                            //}
                            //}
                        }
                    }
                }

                if (tempCaseSensitive.equals("CaseInsensitive")) {
                    if (tempMatchAllKeywords.equals("MatchAll")) {
                        if ((arFile.get(i).toLowerCase().matches((tempSearchWord).toLowerCase()))||(arFile.get(i).toLowerCase().matches(("(.*)" + "(/)" + tempSearchWord).toLowerCase()))) {
                            matchNo = matchNo +1;
                            System.out.println("ZIP File Contains " + searchFile +
                                    " at " + arFile.get(i));
                            if (matchNo == 1){
                                reply = "ZIP File Contains " + searchFile +
                                        " at " + arFile.get(i);
                            }
                            else if (matchNo > 1) {
                                reply = reply + " ; " + "ZIP File Contains " + searchFile +
                                        " at " + arFile.get(i);
                            }
                            walk.file_found_flag = true;
                        }


                    }
                    if (tempMatchAllKeywords.equals("MatchAny")) {
                        if (arFile.get(i).toLowerCase().matches("(.*)".toLowerCase() + tempSearchWord.toLowerCase() + "(.*)".toLowerCase())) {
                            matchNo = matchNo +1;
                            System.out.println("ZIP File Contains " + searchFile +
                                    " at " + arFile.get(i));
                            if (matchNo == 1){
                                reply = "ZIP File Contains " + searchFile +
                                        " at " + arFile.get(i);
                            }
                            else if (matchNo > 1) {
                                reply = reply + " ; " + "ZIP File Contains " + searchFile +
                                        " at " + arFile.get(i);
                            }
                            walk.file_found_flag = true;
                        }
                    }
                }
            }
            if (matchNo == 0){
                reply = "ZIP File does not contain " + searchFile;;
            }
        }
        return "Success";
    }
}