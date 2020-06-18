// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.util;

import javax.xml.transform.stream.StreamSource;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import javax.xml.transform.TransformerException;
import java.io.OutputStream;
import java.io.IOException;
import java.io.FileOutputStream;
import javax.xml.transform.Transformer;
import javax.xml.transform.Result;
import java.io.Writer;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.TransformerFactory;
import java.io.StringWriter;
import java.io.File;
import javax.xml.transform.Source;
import org.w3c.dom.Node;
import javax.xml.transform.dom.DOMSource;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class XmlUtils
{
    public static Document getNewXmlDocument() {
        try {
            return DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static StringBuffer domToString(final Document n) {
        if (n == null) {
            return new StringBuffer();
        }
        return transformToString(new DOMSource(n), null);
    }
    
    public static Document fileToDom(final String pathname) {
        try {
            return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(pathname));
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static StringBuffer transformToString(final Source source, final Source source2) {
        final StringWriter writer = new StringWriter();
        try {
            Transformer transformer;
            if (source2 == null) {
                transformer = TransformerFactory.newInstance().newTransformer();
            }
            else {
                transformer = TransformerFactory.newInstance().newTransformer(source2);
            }
            transformer.setOutputProperty("omit-xml-declaration", "no");
            transformer.transform(source, new StreamResult(writer));
            return writer.getBuffer();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return writer.getBuffer();
        }
        finally {
            try {
                writer.close();
            }
            catch (Exception ex2) {
                ex2.printStackTrace();
            }
        }
    }
    
    public static void writeDocument(final String s, final Document document, final boolean b) {
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(s);
            writeDoc(outputStream, document, b);
        }
        catch (Exception ex) {
            System.err.println("Failed to write output file [" + s + "]");
            System.err.println("Reason: " + ex.getMessage());
            ex.printStackTrace(System.err);
            if (outputStream != null) {
                try {
                    ((FileOutputStream)outputStream).close();
                }
                catch (IOException ex2) {
                    ex2.printStackTrace();
                }
            }
        }
        finally {
            if (outputStream != null) {
                try {
                    ((FileOutputStream)outputStream).close();
                }
                catch (IOException ex3) {
                    ex3.printStackTrace();
                }
            }
        }
    }
    
    public static void writeDocument(final OutputStream outputStream, final Document document, final boolean b) {
        try {
            writeDoc(outputStream, document, b);
        }
        catch (TransformerException ex) {
            System.err.println("Reason: " + ex.getMessage());
            ex.printStackTrace(System.err);
        }
    }
    
    private static void writeDoc(final OutputStream out, final Document n, final boolean b) throws TransformerException {
        Writer writer = null;
        try {
            writer = new OutputStreamWriter(out, Charset.forName("UTF-8"));
            final Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty("omit-xml-declaration", "no");
            transformer.setOutputProperty("encoding", "UTF-8");
            if (b) {
                transformer.setOutputProperty("indent", "yes");
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            }
            transformer.transform(new DOMSource(n), new StreamResult(writer));
        }
        finally {
            if (writer != null) {
                try {
                    ((OutputStreamWriter)writer).close();
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    public static StringBuffer transformToString(final String pathname, final String pathname2) {
        return transformToString(new StreamSource(new File(pathname)), new StreamSource(new File(pathname2)));
    }
    
    public static StringBuffer transformToString(final Document n, final String pathname) {
        return transformToString(new DOMSource(n), new StreamSource(new File(pathname)));
    }
}
