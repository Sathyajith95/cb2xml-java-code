// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.util;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.File;

public class FileUtils
{
    public static StringBuffer readFile(final String pathname) {
        final File file = new File(pathname);
        InputStream in = null;
        final StringBuffer sb = new StringBuffer();
        try {
            in = new FileInputStream(file);
            String line;
            while ((line = new BufferedReader(new InputStreamReader(in)).readLine()) != null) {
                sb.append(line);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        finally {
            if (in != null) {
                try {
                    ((FileInputStream)in).close();
                }
                catch (IOException ex2) {}
            }
        }
        return sb;
    }
    
    public static void writeFile(final String str, final String fileName, final boolean append) {
        Writer writer = null;
        try {
            writer = new FileWriter(fileName, append);
            writer.write(str);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            if (writer != null) {
                try {
                    ((OutputStreamWriter)writer).close();
                }
                catch (Exception ex2) {}
            }
        }
    }
}
