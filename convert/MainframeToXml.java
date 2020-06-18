// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.convert;

import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import net.sf.cb2xml.util.XmlUtils;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.StringReader;
import org.w3c.dom.Document;

public class MainframeToXml
{
    private String mainframeBuffer;
    private Document resultDocument;
    
    public MainframeToXml() {
        this.mainframeBuffer = null;
        this.resultDocument = null;
    }
    
    private static String stripNullChars(final String s) {
        try {
            final BufferedReader bufferedReader = new BufferedReader(new StringReader(s));
            final StringBuffer sb = new StringBuffer();
            int read;
            while ((read = bufferedReader.read()) > -1) {
                if (read != 0) {
                    sb.append((char)read);
                }
                else {
                    sb.append(' ');
                }
            }
            bufferedReader.close();
            return sb.toString();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public Document convert(final String s, final Document document) {
        this.mainframeBuffer = stripNullChars(s);
        this.resultDocument = XmlUtils.getNewXmlDocument();
        final int length = s.length();
        final Element documentElement = document.getDocumentElement();
        final Element firstElement = Utils.getFirstElement(documentElement);
        final Element element = this.resultDocument.createElement(documentElement.getTagName());
        for (int int1 = Integer.parseInt(firstElement.getAttribute("storage-length")), i = 0; i < length; i += int1) {
            element.appendChild(this.convertNode(firstElement, i));
        }
        this.resultDocument.appendChild(element);
        return this.resultDocument;
    }
    
    private Element convertNode(final Element element, final int n) {
        final Element element2 = this.resultDocument.createElement(element.getAttribute("name"));
        int int1 = Integer.parseInt(element.getAttribute("position"));
        final int int2 = Integer.parseInt(element.getAttribute("storage-length"));
        final boolean equalsIgnoreCase = "true".equalsIgnoreCase(element.getAttribute("numeric"));
        int n2 = 0;
        final NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); ++i) {
            final Node item = childNodes.item(i);
            if (item.getNodeType() == 1) {
                final Element element3 = (Element)item;
                if (!element3.getAttribute("level").equals("88")) {
                    ++n2;
                    if (element3.hasAttribute("occurs")) {
                        final int int3 = Integer.parseInt(element3.getAttribute("occurs"));
                        final int int4 = Integer.parseInt(element3.getAttribute("storage-length"));
                        for (int j = 0; j < int3; ++j) {
                            element2.appendChild(this.convertNode(element3, n + j * int4));
                        }
                    }
                    else {
                        element2.appendChild(this.convertNode(element3, n));
                    }
                }
            }
        }
        if (n2 == 0) {
            if (n > 0) {
                int1 += n;
            }
            String s = null;
            try {
                s = this.mainframeBuffer.substring(int1 - 1, int1 + int2 - 1);
                if (equalsIgnoreCase) {
                    s = s.trim();
                }
            }
            catch (Exception x) {
                System.err.println(x);
                System.err.println("element = " + element.getAttribute("name"));
                System.err.println("position = " + int1);
                System.err.println("length = " + int2);
                System.err.println("Mainframe buffer length = " + this.mainframeBuffer.length());
            }
            element2.appendChild(this.resultDocument.createTextNode(s));
        }
        return element2;
    }
}
