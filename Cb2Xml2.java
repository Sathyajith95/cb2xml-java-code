// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml;

import javax.xml.transform.Result;
import org.w3c.dom.Node;
import javax.xml.transform.dom.DOMResult;
import net.sf.cb2xml.def.Cb2xmlConstants;
import java.io.InputStreamReader;
import net.sf.cb2xml.util.XmlUtils;
import java.io.InputStream;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import net.sf.cb2xml.sablecc.lexer.LexerException;
import net.sf.cb2xml.sablecc.parser.ParserException;
import java.io.Reader;
import java.io.FileReader;
import org.w3c.dom.Document;
import java.io.File;

public class Cb2Xml2
{
    static final int USE_DEFAULT_THREADSIZE = 0;
    static final int USE_DEFAULT_CB2XML_THREADSIZE = 1;
    static final int ONE_MEG = 1048576;
    static final int DEFAULT_THREAD_SIZE = 4194304;
    private static final int FIRST_COBOL_COLUMN = 6;
    private static final int LAST_COBOL_COLUMN = 72;
    private static int[] END_COLS;
    
    public static Document convertToXMLDOM(final File file) throws ParserException, LexerException, IOException, XMLStreamException {
        return convert(new FileReader(file), file.getName(), false, 8, 6, 72, 1L);
    }
    
    public static Document convertToXMLDOM(final File file, final boolean b) throws ParserException, LexerException, IOException, XMLStreamException {
        return convert(new FileReader(file), file.getName(), b, 8, 6, 72, 1L);
    }
    
    public static Document convertToXMLDOM(final File file, final boolean b, final int n) throws ParserException, LexerException, IOException, XMLStreamException {
        return convert(file, null, null, b, n, 6, 72);
    }
    
    public static Document convertToXMLDOM(final File file, final boolean b, final int n, final int n2) throws ParserException, LexerException, IOException, XMLStreamException {
        return convert(file, null, null, b, 2, n, n2);
    }
    
    public static Document convertToXMLDOM(final InputStream inputStream, final String s, final boolean b, final int n) throws ParserException, LexerException, IOException, XMLStreamException {
        return convert(null, inputStream, s, b, n, 6, 72);
    }
    
    public static Document convertToXMLDOM(final InputStream inputStream, final String s, final boolean b, final int n, final int n2) throws ParserException, LexerException, IOException, XMLStreamException {
        return convert(null, inputStream, s, b, 2, n, n2);
    }
    
    public static Document convertToXMLDOM(final InputStream inputStream, final String s) throws ParserException, LexerException, IOException, XMLStreamException {
        return convert(null, inputStream, s, false, 8, 6, 72);
    }
    
    public static Document convertToXMLDOM(final InputStream inputStream, final String s, final boolean b) throws ParserException, LexerException, IOException, XMLStreamException {
        return convert(null, inputStream, s, b, 8, 6, 72);
    }
    
    public static String convertToXMLString(final Document document) {
        return XmlUtils.domToString(document).toString();
    }
    
    public static Document convert(final File file, final InputStream in, final String s, final boolean b, final int n, final int n2, final int n3) throws ParserException, LexerException, IOException, XMLStreamException {
        String name = s;
        InputStreamReader inputStreamReader;
        if (in == null) {
            inputStreamReader = new FileReader(file);
            name = file.getName();
        }
        else {
            inputStreamReader = new InputStreamReader(in);
        }
        return convert(inputStreamReader, name, b, n, n2, n3, 1L);
    }
    
    public static Document convert(final Reader reader, final String s, final boolean b, final int n) throws ParserException, LexerException, IOException, XMLStreamException {
        return convert(reader, s, b, n, 6, 72, 1L);
    }
    
    public static Document convert(final Reader reader, final String s, final boolean debug, final int cobolLineFormat, final int n, final int n2, final long stackSize) throws ParserException, LexerException, IOException, XMLStreamException {
        final ICb2XmlBuilder setStackSize = Cb2Xml3.newBuilder(reader, s).setDebug(debug).setXmlFormat(Cb2xmlConstants.Cb2xmlXmlFormat.CLASSIC).setStackSize(stackSize);
        switch (cobolLineFormat) {
            case 2: {
                setStackSize.setCobolColumns(n, n2);
                break;
            }
            default: {
                setStackSize.setCobolLineFormat(cobolLineFormat);
                break;
            }
        }
        return bldrToDocument(setStackSize);
    }
    
    public static Document bldrToDocument(final ICb2XmlBuilder cb2XmlBuilder) throws XMLStreamException, LexerException, IOException, ParserException {
        final Document newXmlDocument = XmlUtils.getNewXmlDocument();
        cb2XmlBuilder.writeXml(new DOMResult(newXmlDocument));
        return newXmlDocument;
    }
    
    static {
        (Cb2Xml2.END_COLS = new int[9])[1] = 72;
        Cb2Xml2.END_COLS[3] = 80;
        Cb2Xml2.END_COLS[4] = 16000;
    }
}
