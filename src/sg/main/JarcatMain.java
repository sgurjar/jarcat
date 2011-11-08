package sg.main;

import java.io.*;
import java.util.zip.*;

public class JarcatMain {

    public static void main(String args[]) throws Exception {
        if(args.length < 2) {
            System.out.println("usage: java -jar jarcat.jar <jarfile> <path_of_jarfile_entry>");
            System.out.println("example: java -jar jarcat.jar myjar.jar \"META-INF/MANIFEST.MF\"");
            return;
        }
        String filename = args[0];
        String entryname = args[1];
        ZipFile z = new ZipFile(filename);
        ZipEntry ze = z.getEntry(entryname);
        InputStream in = z.getInputStream(ze);
        byte[] buf = new byte[1024*8];
        ByteArrayOutputStream bos = new ByteArrayOutputStream(1024*8);
        for(int len=0;;){
          len = in.read(buf);
          if(len==-1)break;
          bos.write(buf, 0, len);
        }
        System.out.println(new String(bos.toByteArray()));
        z.close();
    }
}
