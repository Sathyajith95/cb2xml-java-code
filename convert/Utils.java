// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.convert;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

public class Utils
{
    public static final Element getFirstElement(final Element element) {
        final NodeList childNodes = element.getChildNodes();
        Node item = null;
        for (int n = 0; n < childNodes.getLength() && !((item = childNodes.item(n)) instanceof Element); ++n) {}
        return (Element)item;
    }
}
