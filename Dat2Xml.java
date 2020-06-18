// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml;

import net.sf.cb2xml.util.XmlUtils;
import net.sf.cb2xml.util.FileUtils;
import net.sf.cb2xml.convert.MainframeToXml;

public class Dat2Xml
{
    public static void main(final String[] array) {
        if (array.length != 2) {
            System.err.println("Usage:\tdat2xml <dataFileName> <xmlCopybookFileName>");
            System.err.println();
            System.err.println("Output will be printed to stdout; you can redirect it to a file with \" > <outputFileName>");
            return;
        }
        System.out.println(XmlUtils.domToString(new MainframeToXml().convert(FileUtils.readFile(array[0]).toString(), XmlUtils.fileToDom(array[1]))).toString());
    }
}
