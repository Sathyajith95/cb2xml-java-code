// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml;

import net.sf.cb2xml.util.XmlUtils;
import net.sf.cb2xml.convert.XmlToMainframe;

public class Xml2Dat
{
    public static void main(final String[] array) {
        if (array.length != 2) {
            System.err.println("Usage:\txml2dat <xmlDataFileName> <copybookFileName>");
            System.err.println();
            System.err.println("Output will be printed to stdout; you can redirect it to a file with \" > <outputFileName>");
            return;
        }
        System.out.println(new XmlToMainframe().convert(XmlUtils.fileToDom(array[0]), XmlUtils.fileToDom(array[1])));
    }
}
