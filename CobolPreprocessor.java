// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml;

import java.io.IOException;
import java.io.BufferedReader;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.Reader;
import java.io.FileReader;
import java.io.File;

public class CobolPreprocessor
{
    public static String preProcess(final File file) {
        try {
            return preProcess(new FileReader(file));
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static String preProcess(final File file, final int n, final int n2) {
        try {
            return preProcess(new FileReader(file), n, n2);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static String preProcess(final InputStream in) {
        return preProcess(new InputStreamReader(in));
    }
    
    public static String preProcess(final Reader reader) {
        int int1 = 6;
        int int2 = 72;
        final File file = new File("cb2xml.properties");
        if (file.exists()) {
            try {
                final FileInputStream inStream = new FileInputStream(file);
                final Properties properties = new Properties();
                properties.load(inStream);
                inStream.close();
                final String property = properties.getProperty("column.start");
                final String property2 = properties.getProperty("column.end");
                if (property != null) {
                    int1 = Integer.parseInt(property);
                }
                if (property2 != null) {
                    int2 = Integer.parseInt(property2);
                }
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else {
            System.err.println("*** -------------------------------------------------------");
            System.err.println("*** Warning there was no \"cb2xml.properties\" file, ");
            System.err.println("*** using the default Cobol columns of 6 to 72 ");
            System.err.println("*** -------------------------------------------------------");
        }
        System.err.println("*** using start column = " + int1 + ", end column = " + int2);
        return preProcess(reader, int1, int2);
    }
    
    public static String preProcess(final InputStream in, final int n, final int n2) {
        return preProcess(new InputStreamReader(in), n, n2);
    }
    
    public static String preProcess(final Reader in, final int index, final int endIndex) {
        final StringBuffer sb = new StringBuffer();
        try {
            String s;
            while ((s = new BufferedReader(in).readLine()) != null) {
                if (s.length() > index) {
                    int n = index;
                    final int index2 = s.indexOf(9);
                    if (index2 >= 0 && index2 <= index) {
                        s = "        " + s.substring(index2 + 1);
                    }
                    if (s.charAt(index) == '/') {
                        sb.append('*');
                        ++n;
                    }
                    if (s.length() < endIndex) {
                        sb.append(s.substring(n));
                    }
                    else {
                        sb.append(s.substring(n, endIndex));
                    }
                }
                sb.append("\n");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        finally {
            if (in != null) {
                try {
                    in.close();
                }
                catch (IOException ex2) {}
            }
        }
        return sb.toString();
    }
}
