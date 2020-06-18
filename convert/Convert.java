// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.convert;

import net.sf.cb2xml.util.FileUtils;
import net.sf.cb2xml.util.XmlUtils;

public class Convert
{
    public static void main(final String[] array) {
        FileUtils.writeFile(new XmlToMainframe().convert(XmlUtils.fileToDom(array[0]), XmlUtils.fileToDom(array[1])), "mfresult.txt", false);
    }
}
