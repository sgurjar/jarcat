/*
 * Copyright (c) 2004-2010, P. Simon Tuffs (simon@simontuffs.com)
 * All rights reserved.
 *
 * See the full license at http://one-jar.sourceforge.net/one-jar-license.html
 * This license is also included in the distributions of this software
 * under doc/one-jar-license.txt
 */
package sg.main;

import java.io.*;
import java.util.zip.*;

public class JarcatMain {

    public static void main(String args[]) throws Exception {
        if(args.length < 2) {
            System.out.println("usage: java JarCat <jarfile> <path_of_jarfile_entry>");
            System.out.println("example: java JarCat myjar.jar \"META-INF/MANIFEST.MF\"");
            return;
        }
        String filename = args[0];
        String entryname = args[1];
        ZipFile z = new ZipFile(filename);
        ZipEntry ze = z.getEntry(entryname);
        InputStream in = z.getInputStream(ze);
        byte[] buf = new byte[in.available()];
        in.read(buf);
        System.out.println(new String(buf));
        z.close();
    }
}
