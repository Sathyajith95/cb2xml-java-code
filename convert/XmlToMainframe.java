// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.convert;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import java.util.Hashtable;

public class XmlToMainframe
{
    private Hashtable keyValuePairs;
    
    public XmlToMainframe() {
        this.keyValuePairs = new Hashtable();
    }
    
    public String convert(final Document document, final Document document2) {
        final HashtableToMainframe hashtableToMainframe = new HashtableToMainframe();
        final Element documentElement = document.getDocumentElement();
        final StringBuilder sb = new StringBuilder();
        final NodeList childNodes = documentElement.getChildNodes();
        String str = "";
        for (int i = 0; i < childNodes.getLength(); ++i) {
            final Node item = childNodes.item(i);
            if (item instanceof Element) {
                final Element element = (Element)item;
                final String string = "/" + documentElement.getTagName() + "/" + element.getTagName();
                this.keyValuePairs.clear();
                this.convertNode(element, string);
                sb.append(str).append(hashtableToMainframe.convert(this.keyValuePairs, document2));
                str = "\n";
            }
        }
        return sb.toString();
    }
    
    private void convertNode(final Element element, final String str) {
        final NodeList childNodes = element.getChildNodes();
        final Hashtable hashtable = new Hashtable<Object, Object>(childNodes.getLength(), 1.0f);
        int n = 0;
        for (int i = 0; i < childNodes.getLength(); ++i) {
            final Node item = childNodes.item(i);
            if (item.getNodeType() == 1) {
                final Element element2 = (Element)item;
                final String tagName = element2.getTagName();
                if (hashtable.containsKey(tagName)) {
                    n = Integer.parseInt(hashtable.get(tagName).toString()) + 1;
                    hashtable.put(tagName, n + "");
                }
                else {
                    hashtable.put(tagName, "0");
                }
                element2.setAttribute("index", n + "");
            }
            else if (item.getNodeType() == 3) {
                this.keyValuePairs.put(str, item.getNodeValue());
            }
        }
        for (int j = 0; j < childNodes.getLength(); ++j) {
            final Node item2 = childNodes.item(j);
            if (item2.getNodeType() == 1) {
                final Element element3 = (Element)item2;
                final String tagName2 = element3.getTagName();
                if (!hashtable.get(tagName2).equals("0")) {
                    this.convertNode(element3, str + "/" + tagName2 + "[" + element3.getAttribute("index") + "]");
                }
                else {
                    this.convertNode(element3, str + "/" + tagName2);
                }
            }
        }
    }
}
