// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml;

import java.io.IOException;
import net.sf.cb2xml.sablecc.lexer.LexerException;
import javax.xml.stream.XMLStreamException;
import net.sf.cb2xml.def.Cb2xmlConstants;
import org.w3c.dom.Document;
import net.sf.cb2xml.sablecc.parser.ParserException;
import java.io.Writer;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileReader;
import net.sf.cb2xml.util.Parms;

public class Cb2Xml
{
    private static final int FIRST_COBOL_COLUMN = 6;
    private static final int LAST_COBOL_COLUMN = 72;
    
    public static void main(final String[] array) {
        final Parms parms = new Parms(array);
        if (parms.ok) {
            try {
                InputStreamReader inputStreamReader;
                if (parms.font == null || parms.font.length() == 0) {
                    inputStreamReader = new FileReader(parms.cobol);
                }
                else {
                    inputStreamReader = new InputStreamReader(new FileInputStream(parms.cobol), parms.font);
                }
                final ICb2XmlBuilder setDialect = Cb2Xml3.newBuilder(inputStreamReader, new File(parms.cobol).getName()).setDebug(parms.debug).setIndent(parms.indentXml).setXmlFormat(parms.xmlFormat).setXmlEncoding(parms.font).setDialect(parms.dialect);
                setDialect.setStackSize(parms.stackSize);
                if (parms.xml == null || parms.xml.length() == 0) {
                    setDialect.setXmlEncoding("").writeXml(new OutputStreamWriter(System.out));
                }
                else {
                    setDialect.writeXml(parms.xml);
                }
            }
            catch (DebugParserException ex) {
                System.err.println("*** fatal parse error ***");
                System.err.println(ex.getMessage());
                System.err.println("=== buffer dump start ===");
                System.err.println(ex.buffer);
                System.err.println("=== buffer dump end ===");
            }
            catch (ParserException ex2) {
                System.err.println("*** fatal parse error ***");
                System.err.println(ex2.getMessage());
            }
            catch (Exception ex3) {
                ex3.printStackTrace();
            }
        }
    }
    
    public static Document convertToXMLDOM(final File file) {
        return convert(file, null, null, false);
    }
    
    public static Document convertToXMLDOM(final File file, final boolean b) {
        return convert(file, null, null, b);
    }
    
    public static Document convertToXMLDOM(final File file, final boolean b, final int n) {
        return convert(file, null, null, b, n, 6, 72);
    }
    
    public static Document convertToXMLDOM(final File file, final boolean b, final int n, final int n2) {
        return convert(file, null, null, b, 2, n, n2);
    }
    
    public static Document convertToXMLDOM(final InputStream inputStream, final String s, final boolean b, final int n) {
        return convert(null, inputStream, s, b, n, 6, 72);
    }
    
    public static Document convertToXMLDOM(final InputStream inputStream, final String s, final boolean b, final int n, final int n2) {
        return convert(null, inputStream, s, b, 2, n, n2);
    }
    
    public static String convertToXMLString(final File file) {
        return convertToXMLString(file, false);
    }
    
    public static String convertToXMLString(final File file, final boolean debug) {
        try {
            return Cb2Xml3.newBuilder(file).setDebug(debug).setXmlFormat(Cb2xmlConstants.Cb2xmlXmlFormat.CLASSIC).asXmlString();
        }
        catch (XMLStreamException cause) {
            throw new RuntimeException(cause);
        }
        catch (LexerException cause2) {
            throw new RuntimeException(cause2);
        }
        catch (IOException cause3) {
            throw new RuntimeException(cause3);
        }
        catch (ParserException cause4) {
            throw new RuntimeException(cause4);
        }
    }
    
    public static String convertToXMLString(final InputStream inputStream, final String s) {
        return convertToXMLString(inputStream, s, false);
    }
    
    public static String convertToXMLString(final InputStream in, final String s, final boolean debug) {
        try {
            return Cb2Xml3.newBuilder(new InputStreamReader(in), s).setDebug(debug).setXmlFormat(Cb2xmlConstants.Cb2xmlXmlFormat.CLASSIC).asXmlString();
        }
        catch (XMLStreamException cause) {
            throw new RuntimeException(cause);
        }
        catch (LexerException cause2) {
            throw new RuntimeException(cause2);
        }
        catch (IOException cause3) {
            throw new RuntimeException(cause3);
        }
        catch (ParserException cause4) {
            throw new RuntimeException(cause4);
        }
    }
    
    public static Document convertToXMLDOM(final InputStream inputStream, final String s) {
        return convert(null, inputStream, s, false);
    }
    
    public static Document convertToXMLDOM(final InputStream inputStream, final String s, final boolean b) {
        return convert(null, inputStream, s, b);
    }
    
    private static Document convert(final File file, final InputStream inputStream, final String s, final boolean b) {
        return convert(file, inputStream, s, b, 8, 6, 72);
    }
    
    public static Document convert(final File file, final InputStream inputStream, final String s, final boolean b, final int n, final int n2, final int n3) {
        Document convert = null;
        try {
            convert = Cb2Xml2.convert(file, inputStream, s, b, n, n2, n3);
        }
        catch (DebugParserException ex) {
            System.err.println("*** fatal parse error ***");
            System.err.println(ex.getMessage());
            System.err.println("=== buffer dump start ===");
            System.err.println(ex.buffer);
            System.err.println("=== buffer dump end ===");
        }
        catch (ParserException ex2) {
            System.err.println("*** fatal parse error ***");
            System.err.println(ex2.getMessage());
        }
        catch (Exception ex3) {
            ex3.printStackTrace();
        }
        return convert;
    }
}
