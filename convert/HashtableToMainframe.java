// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.convert;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import java.util.Hashtable;

public class HashtableToMainframe
{
    private Hashtable keyValuePairs;
    
    public HashtableToMainframe() {
        this.keyValuePairs = null;
    }
    
    private StringBuffer getRepeatedChars(final char c, final int n) {
        final StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; ++i) {
            sb.append(c);
        }
        return sb;
    }
    
    public String convert(final Hashtable keyValuePairs, final Document document) {
        this.keyValuePairs = keyValuePairs;
        final Element documentElement = document.getDocumentElement();
        final Element firstElement = Utils.getFirstElement(documentElement);
        return this.convertNode(firstElement, "/" + documentElement.getTagName() + "/" + firstElement.getAttribute("name")).deleteCharAt(0).toString();
    }
    
    private StringBuffer convertNode(final Element element, final String s) {
        final StringBuffer sb = new StringBuffer();
        sb.append('0');
        final int int1 = Integer.parseInt(element.getAttribute("position"));
        final int int2 = Integer.parseInt(element.getAttribute("storage-length"));
        final boolean equalsIgnoreCase = "true".equalsIgnoreCase(element.getAttribute("numeric"));
        int n = 0;
        final NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); ++i) {
            final Node item = childNodes.item(i);
            if (item.getNodeType() == 1) {
                final Element element2 = (Element)item;
                if (!element2.getAttribute("level").equals("88")) {
                    final String attribute = element2.getAttribute("name");
                    ++n;
                    final int int3 = Integer.parseInt(element2.getAttribute("position"));
                    StringBuffer convertNode;
                    if (element2.hasAttribute("occurs")) {
                        convertNode = new StringBuffer();
                        convertNode.append('0');
                        for (int int4 = Integer.parseInt(element2.getAttribute("occurs")), j = 0; j < int4; ++j) {
                            final StringBuffer convertNode2 = this.convertNode(element2, s + "/" + attribute + "[" + j + "]");
                            if (convertNode2.charAt(0) == '1') {
                                convertNode.setCharAt(0, '1');
                            }
                            convertNode2.deleteCharAt(0);
                            convertNode.append(convertNode2);
                        }
                    }
                    else {
                        convertNode = this.convertNode(element2, s + "/" + attribute);
                    }
                    if (element2.hasAttribute("redefines") && convertNode.charAt(0) == '1') {
                        convertNode.deleteCharAt(0);
                        final int start = int3 - int1;
                        sb.replace(start, start + convertNode.length(), convertNode.toString());
                    }
                    else {
                        if (convertNode.charAt(0) == '1') {
                            sb.setCharAt(0, '1');
                        }
                        convertNode.deleteCharAt(0);
                        sb.append(convertNode);
                    }
                }
            }
        }
        if (n == 0) {
            if (this.keyValuePairs.containsKey(s)) {
                sb.setCharAt(0, '1');
                final Object value = this.keyValuePairs.get(s);
                String substring = (value == null) ? "" : value.toString();
                if (substring.length() < int2) {
                    if (equalsIgnoreCase) {
                        if (substring.startsWith("-")) {
                            sb.append('-').append(this.getRepeatedChars('0', int2 - substring.length())).append(substring);
                        }
                        else {
                            if (substring.startsWith("+")) {
                                substring = substring.substring(1);
                            }
                            sb.append(this.getRepeatedChars('0', int2 - substring.length())).append(substring);
                        }
                    }
                    else {
                        sb.append(substring).append(this.getRepeatedChars(' ', int2 - substring.length()));
                    }
                }
                else if (substring.length() < int2) {
                    sb.append(substring.substring(0, int2));
                }
                else {
                    sb.append(substring);
                }
            }
            else if (element.hasAttribute("value")) {
                sb.append(element.getAttribute("value"));
            }
            else if (element.hasAttribute("zeros")) {
                sb.append(this.getRepeatedChars('0', int2));
            }
            else {
                sb.append(this.getRepeatedChars(' ', int2));
            }
        }
        return sb;
    }
}
