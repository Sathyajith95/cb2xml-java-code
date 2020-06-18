// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.util;

import java.io.PrintStream;
import net.sf.cb2xml.def.DialectManager;
import net.sf.cb2xml.def.Cb2xmlConstants;
import net.sf.cb2xml.def.IBasicDialect;

public class Parms
{
    public static final String FONT_PRM = "-font";
    public static final String COBOL_PRM = "-cobol";
    public static final String XML_PRM = "-xml";
    public static final String DEBUG_PRM = "-debug";
    public static final String INDENT_XML_PRM = "-indentxml";
    public static final String XML_FORMAT_PRM = "-xmlformat";
    public static final String STACK_SIZE_PRM = "-stacksize";
    public static final String DIALECT_PRM = "-dialect";
    private static final int FONT_IDX = 0;
    private static final int COBOL_IDX = 1;
    private static final int XML_IDX = 2;
    private static final int DEBUG_IDX = 3;
    private static final int INDENT_IDX = 4;
    private static final int XML_FORMAT_IDX = 5;
    private static final int STACK_SIZE_IDX = 6;
    private static final int DIALECT_IDX = 7;
    private static final String[] ARG_NAMES;
    private static final IBasicDialect[] ALL_DIALECTS;
    public final String font;
    public final String cobol;
    public final String xml;
    public final boolean debug;
    public final boolean indentXml;
    public final Cb2xmlConstants.Cb2xmlXmlFormat xmlFormat;
    public final long stackSize;
    public boolean ok;
    public final IBasicDialect dialect;
    
    public Parms(final String[] array) {
        this.ok = true;
        String[] attrs = new String[Parms.ARG_NAMES.length];
        PrintStream printStream = System.err;
        if (array != null && array.length != 0) {
            if (array[0] != null) {
                if (array[0].toLowerCase().startsWith("-h")) {
                    printStream = System.out;
                }
                else if (array[0].startsWith("-")) {
                    attrs = this.getAttrs(array);
                }
                else {
                    attrs[1] = array[0];
                    if (array.length > 1) {
                        attrs[3] = "t";
                    }
                    attrs[5] = "Classic";
                }
            }
        }
        this.font = attrs[0];
        this.cobol = attrs[1];
        this.xml = attrs[2];
        this.debug = (attrs[3] != null && !attrs[3].toLowerCase().startsWith("f"));
        this.indentXml = (attrs[4] != null);
        this.xmlFormat = ((attrs[5] == null || "".equals(attrs[5]) || "2017".equals(attrs[5]) || "new".equalsIgnoreCase(attrs[5])) ? Cb2xmlConstants.Cb2xmlXmlFormat.FORMAT_2017 : Cb2xmlConstants.Cb2xmlXmlFormat.CLASSIC);
        int n = -1;
        if (attrs[6] != null) {
            if ("normal".equalsIgnoreCase(attrs[6])) {
                n = 0;
            }
            else {
                try {
                    n = Integer.parseInt(attrs[6]) * 1024 * 1024;
                }
                catch (Exception ex) {
                    this.ok = false;
                    System.err.println();
                    System.err.println("Invalid Stacksize: " + attrs[6] + " it should be normal or the number of megabytes");
                    System.err.println();
                }
            }
        }
        this.stackSize = n;
        IBasicDialect dialect = DialectManager.MAINFRAME_COBOL;
        final String s = attrs[7];
        if (s != null && s.length() != 0 && !s.startsWith("m")) {
            if (!s.startsWith("M")) {
                if (s.toLowerCase().startsWith("gnu_")) {
                    dialect = DialectManager.GNU_COBOL;
                }
                else if (s.toLowerCase().startsWith("f")) {
                    dialect = DialectManager.FUJITSU_COBOL;
                }
                else {
                    boolean b = true;
                    for (final IBasicDialect basicDialect : Parms.ALL_DIALECTS) {
                        if (basicDialect.getNumericDefinition().getName().equalsIgnoreCase(s)) {
                            dialect = basicDialect;
                            b = false;
                        }
                    }
                    if (b) {
                        this.ok = false;
                        System.err.println();
                        System.err.println("Invalid Cobol Dialect: " + s + "it should be Mainframe, Gnu_Cobol or Fujitsu");
                        System.err.println();
                    }
                }
            }
        }
        this.dialect = dialect;
        this.ok = (this.ok && this.cobol != null);
        if (this.ok) {
            if (this.xml == null && this.font != null) {
                System.err.println();
                System.err.println("  --------------- Warning  ---------  Warning -------------");
                System.err.println();
                System.err.println(" You have specified a -font parameter but no -Xml parameter");
                System.err.println(" This combination could result in corrupt Xml !!!");
                System.err.println();
                System.err.println("  ---------------------------------------------------------");
                System.err.println();
            }
        }
        else {
            printMsg(printStream);
        }
    }
    
    private String[] getAttrs(final String[] array) {
        final String[] array2 = new String[Parms.ARG_NAMES.length + 1];
        String str = "";
        final StringBuilder sb = new StringBuilder();
        int n = Parms.ARG_NAMES.length;
        for (int i = 0; i < array.length; ++i) {
            final String anObject = (array[i] == null) ? "" : array[i].toLowerCase();
            if (anObject.startsWith("-")) {
                array2[n] = sb.toString();
                sb.setLength(0);
                n = Parms.ARG_NAMES.length;
                for (int j = 0; j < Parms.ARG_NAMES.length; ++j) {
                    if (Parms.ARG_NAMES[j].equals(anObject)) {
                        n = j;
                        break;
                    }
                }
                if (n == Parms.ARG_NAMES.length) {
                    System.out.println("Invalid Argument: " + array[i]);
                    this.ok = false;
                }
                str = "";
            }
            else {
                sb.append(str).append(array[i]);
                str = " ";
            }
        }
        array2[n] = sb.toString();
        return array2;
    }
    
    private static void printMsg(final PrintStream printStream) {
        printStream.println();
        printStream.print("Usage:\n\n  Either:\n\tcb2xml <copybookFileName> [debug]\n  or:\n\tcb2xml <attributes>\n \n  Where <attributes> are:\n\n\t-cobol - Cobol Copybook\n\t-xml   - Output xml file\n\t-font  - Font (encoding) of the copybook\n\t-debug - true:  run in debug mode\n\t-indentXml - indent (or format) the generated Xml \n\t-XmlFormat - for the new Xml format: old or 2017 (for the new 2017 format) default\n\t-StackSize - Stack Size (in megabytes (or normal to use the default) \n\t-Dialect   - Cobol Dialect: ");
        final IBasicDialect[] all_DIALECTS = Parms.ALL_DIALECTS;
        for (int length = all_DIALECTS.length, i = 0; i < length; ++i) {
            printStream.print(all_DIALECTS[i].getNumericDefinition().getName() + "\t");
        }
        printStream.println();
        printStream.println();
    }
    
    static {
        ARG_NAMES = new String[] { "-font", "-cobol", "-xml", "-debug", "-indentxml", "-xmlformat", "-stacksize", "-dialect" };
        ALL_DIALECTS = new IBasicDialect[] { DialectManager.MAINFRAME_COBOL, DialectManager.GNU_COBOL, DialectManager.FUJITSU_COBOL };
    }
}
