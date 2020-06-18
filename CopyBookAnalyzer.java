// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml;

import java.text.DecimalFormat;
import net.sf.cb2xml.def.DialectManager;
import java.util.StringTokenizer;
import net.sf.cb2xml.sablecc.node.AThroughSequenceLiteralSequence;
import net.sf.cb2xml.sablecc.node.AThroughSingleLiteralSequence;
import net.sf.cb2xml.sablecc.node.ASequenceLiteralSequence;
import net.sf.cb2xml.sablecc.node.ASingleLiteralSequence;
import net.sf.cb2xml.sablecc.node.AValueItem;
import net.sf.cb2xml.sablecc.node.AValueClause;
import net.sf.cb2xml.sablecc.node.TAlphanumericLiteral;
import net.sf.cb2xml.sablecc.node.TNulls;
import net.sf.cb2xml.sablecc.node.TQuotes;
import net.sf.cb2xml.sablecc.node.TLowValues;
import net.sf.cb2xml.sablecc.node.THighValues;
import net.sf.cb2xml.sablecc.node.TSpaces;
import net.sf.cb2xml.sablecc.node.TZeros;
import net.sf.cb2xml.sablecc.node.AJustifiedClause;
import net.sf.cb2xml.sablecc.node.AFunctionPointerUsagePhrase;
import net.sf.cb2xml.sablecc.node.AProcedurePointerUsagePhrase;
import net.sf.cb2xml.sablecc.node.APointerUsagePhrase;
import net.sf.cb2xml.sablecc.node.APackedDecimalUsagePhrase;
import net.sf.cb2xml.sablecc.node.AObjectReferencePhrase;
import net.sf.cb2xml.sablecc.node.ANationalUsagePhrase;
import net.sf.cb2xml.sablecc.node.AIndexUsagePhrase;
import net.sf.cb2xml.sablecc.node.ADisplay1UsagePhrase;
import net.sf.cb2xml.sablecc.node.ADisplayUsagePhrase;
import net.sf.cb2xml.sablecc.node.AComp6UsagePhrase;
import net.sf.cb2xml.sablecc.node.AComp5UsagePhrase;
import net.sf.cb2xml.sablecc.node.AComp4UsagePhrase;
import net.sf.cb2xml.sablecc.node.AComp3UsagePhrase;
import net.sf.cb2xml.sablecc.node.AComp2UsagePhrase;
import net.sf.cb2xml.sablecc.node.AComp1UsagePhrase;
import net.sf.cb2xml.sablecc.node.ACompUsagePhrase;
import net.sf.cb2xml.sablecc.node.ABinaryUsagePhrase;
import net.sf.cb2xml.sablecc.node.ABlankWhenZeroClauseClause;
import net.sf.cb2xml.sablecc.node.ABlankWhenZeroClause;
import net.sf.cb2xml.sablecc.node.ATrailingLeadingOrTrailing;
import net.sf.cb2xml.sablecc.node.ALeadingLeadingOrTrailing;
import net.sf.cb2xml.sablecc.node.ASignClause;
import net.sf.cb2xml.sablecc.node.APictureClause;
import net.sf.cb2xml.sablecc.node.ASynchronizedClauseClause;
import net.sf.cb2xml.sablecc.node.AOccursTo;
import net.sf.cb2xml.sablecc.node.AOccursClause;
import net.sf.cb2xml.sablecc.node.AOccursClauseClause;
import net.sf.cb2xml.sablecc.node.AVariableOccursFixedOrVariable;
import net.sf.cb2xml.sablecc.node.AFixedOccursFixedOrVariable;
import net.sf.cb2xml.sablecc.node.ARedefinesClause;
import net.sf.cb2xml.sablecc.node.PDataNameOrFiller;
import net.sf.cb2xml.sablecc.node.AItem;
import java.util.Iterator;
import java.util.List;
import net.sf.cb2xml.sablecc.node.TNumber88;
import net.sf.cb2xml.sablecc.node.Token;
import net.sf.cb2xml.sablecc.node.TNumberNot88;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import net.sf.cb2xml.util.XmlUtils;
import net.sf.cb2xml.sablecc.node.ARecordDescription;
import org.w3c.dom.Document;
import net.sf.cb2xml.sablecc.parser.Parser;
import net.sf.cb2xml.def.NumericDefinition;
import net.sf.cb2xml.sablecc.analysis.DepthFirstAdapter;

@Deprecated
public class CopyBookAnalyzer extends DepthFirstAdapter
{
    private static NumericDefinition defaultNumDef;
    private final NumericDefinition numDef;
    private final Parser parser;
    private String copyBookName;
    private Document document;
    private Item prevItem;
    private Item curItem;
    
    public CopyBookAnalyzer(final String s, final Parser parser) {
        this(s, parser, CopyBookAnalyzer.defaultNumDef);
    }
    
    public CopyBookAnalyzer(final String copyBookName, final Parser parser, final NumericDefinition numDef) {
        this.copyBookName = copyBookName;
        this.parser = parser;
        this.numDef = numDef;
    }
    
    public Document getDocument() {
        return this.document;
    }
    
    @Override
    public void inARecordDescription(final ARecordDescription aRecordDescription) {
        this.document = XmlUtils.getNewXmlDocument();
        final Element element = this.document.createElement("copybook");
        element.setAttribute("filename", this.copyBookName);
        this.document.appendChild(element);
    }
    
    @Override
    public void outARecordDescription(final ARecordDescription aRecordDescription) {
        int postProcessNode = 1;
        final NodeList childNodes = this.document.getDocumentElement().getChildNodes();
        for (int i = 0; i < childNodes.getLength(); ++i) {
            if (childNodes.item(i).getNodeType() == 1) {
                final Element element = (Element)childNodes.item(i);
                if ("01".equals(element.getAttribute("level"))) {
                    this.postProcessNode(element, 1);
                }
                else {
                    postProcessNode = this.postProcessNode(element, postProcessNode);
                }
            }
        }
    }
    
    @Override
    public void caseTNumberNot88(final TNumberNot88 tNumberNot88) {
        this.checkForComments(tNumberNot88);
    }
    
    @Override
    public void caseTNumber88(final TNumber88 tNumber88) {
        this.checkForComments(tNumber88);
    }
    
    public void checkForComments(final Token token) {
        final List list = (List)this.parser.ignoredTokens.getIn(token);
        if (list != null) {
            final Iterator<Object> iterator = list.iterator();
            while (iterator.hasNext()) {
                final String trim = iterator.next().toString().trim();
                if (trim.length() > 0) {
                    this.curItem.element.getParentNode().insertBefore(this.document.createComment(this.correctForMinus(trim)), this.curItem.element);
                }
            }
        }
    }
    
    private String correctForMinus(String string) {
        final int index = string.indexOf("--");
        if (index >= 0) {
            int i = index;
            final StringBuilder sb = new StringBuilder(string);
            int n = 0;
            while (i < string.length() - 1) {
                if (sb.charAt(i) == '-' && (n != 0 || sb.charAt(i + 1) == '-')) {
                    sb.setCharAt(i, '=');
                    n = 1;
                }
                else {
                    n = 0;
                }
                ++i;
            }
            final int n2 = string.length() - 1;
            if (sb.charAt(n2) == '-' && n != 0) {
                sb.setCharAt(n2, '=');
            }
            string = sb.toString();
        }
        return string;
    }
    
    @Override
    public void inAItem(final AItem aItem) {
        final int int1 = Integer.parseInt(aItem.getNumberNot88().toString().trim());
        final PDataNameOrFiller dataNameOrFiller = aItem.getDataNameOrFiller();
        String trim = "";
        if (dataNameOrFiller != null) {
            trim = dataNameOrFiller.toString().trim();
        }
        this.curItem = new Item(int1, trim);
        if (int1 <= 77) {
            if (this.prevItem == null) {
                this.document.getDocumentElement().appendChild(this.curItem.element);
            }
            else if (this.curItem.level > this.prevItem.level) {
                this.prevItem.element.appendChild(this.curItem.element);
            }
            else if (this.curItem.level == this.prevItem.level) {
                this.prevItem.element.getParentNode().appendChild(this.curItem.element);
            }
            else if (this.curItem.level < this.prevItem.level) {
                Element element = this.prevItem.element;
                while (true) {
                    element = (Element)element.getParentNode();
                    final String attribute = element.getAttribute("level");
                    if ("".equals(attribute)) {
                        element.appendChild(this.curItem.element);
                        break;
                    }
                    final int int2 = Integer.parseInt(attribute);
                    if (int2 == this.curItem.level) {
                        element.getParentNode().appendChild(this.curItem.element);
                        break;
                    }
                    if (int2 < this.curItem.level) {
                        element.appendChild(this.curItem.element);
                        break;
                    }
                }
            }
            this.prevItem = this.curItem;
        }
    }
    
    @Override
    public void inARedefinesClause(final ARedefinesClause aRedefinesClause) {
        this.curItem.element.setAttribute("redefines", aRedefinesClause.getDataName().getText());
    }
    
    @Override
    public void inAFixedOccursFixedOrVariable(final AFixedOccursFixedOrVariable aFixedOccursFixedOrVariable) {
        this.curItem.element.setAttribute("occurs", aFixedOccursFixedOrVariable.getNumber().toString().trim());
    }
    
    @Override
    public void inAVariableOccursFixedOrVariable(final AVariableOccursFixedOrVariable aVariableOccursFixedOrVariable) {
        this.curItem.element.setAttribute("occurs", aVariableOccursFixedOrVariable.getNumber().toString().trim());
        this.curItem.element.setAttribute("depending-on", aVariableOccursFixedOrVariable.getDataName().getText());
    }
    
    @Override
    public void inAOccursClauseClause(final AOccursClauseClause aOccursClauseClause) {
        super.inAOccursClauseClause(aOccursClauseClause);
    }
    
    @Override
    public void inAOccursClause(final AOccursClause aOccursClause) {
        super.inAOccursClause(aOccursClause);
    }
    
    @Override
    public void inAOccursTo(final AOccursTo aOccursTo) {
        this.curItem.element.setAttribute("occurs-min", aOccursTo.getNumber().toString().trim());
    }
    
    @Override
    public void inASynchronizedClauseClause(final ASynchronizedClauseClause aSynchronizedClauseClause) {
        this.curItem.element.setAttribute("sync", "true");
    }
    
    @Override
    public void inAPictureClause(final APictureClause aPictureClause) {
        boolean b = true;
        String s = this.removeChars(aPictureClause.getCharacterString().toString(), " ");
        this.curItem.element.setAttribute("picture", s);
        if (s.charAt(0) == 'S' || s.charAt(0) == 's') {
            this.curItem.element.setAttribute("signed", "true");
            s = s.substring(1);
            b = false;
        }
        int int1 = 0;
        int i = 0;
        int n = 0;
        int n2 = 0;
        int n3 = 1;
        if (this.curItem.element.hasAttribute("display-length")) {
            int1 = Integer.parseInt(this.curItem.element.getAttribute("display-length"));
        }
        int n4 = -1;
        boolean b2 = false;
        boolean b3 = false;
        int n5 = 1;
        final String upperCase = s.toUpperCase();
        for (int j = 0; j < s.length(); ++j) {
            final char char1 = upperCase.charAt(j);
            int n6 = 0;
            switch (char1) {
                case 71:
                case 78: {
                    ++n2;
                    n6 = 1;
                }
                case 65:
                case 66:
                case 69: {
                    b3 = true;
                    ++int1;
                    break;
                }
                case 46: {
                    b3 = true;
                    ++int1;
                }
                case 86: {
                    b2 = true;
                    n4 = int1;
                    break;
                }
                case 80: {
                    b2 = true;
                    ++int1;
                    if (n4 < 0) {
                        ++i;
                        break;
                    }
                    ++n;
                    break;
                }
                case 36: {
                    b3 = true;
                    if (n5 != 0) {
                        n5 = 0;
                        b2 = true;
                        break;
                    }
                    ++int1;
                    break;
                }
                case 67:
                case 68: {
                    ++j;
                }
                case 42:
                case 43:
                case 45:
                case 48:
                case 90: {
                    b3 = true;
                }
                case 57: {
                    b2 = true;
                }
                case 44:
                case 47:
                case 88: {
                    ++int1;
                    break;
                }
                case 40: {
                    final int index = s.indexOf(41, j + 1);
                    final int int2 = Integer.parseInt(s.substring(j + 1, index));
                    j = index;
                    n2 += (int2 - 1) * n3;
                    int1 += int2 - 1;
                    break;
                }
            }
            n3 = n6;
        }
        if (b2) {
            this.curItem.element.setAttribute("numeric", "true");
            if (b3) {
                this.curItem.element.setAttribute("editted-numeric", "true");
            }
        }
        this.setLength(this.curItem.element, b, int1, i + n, n2);
        if (n4 != -1 && int1 - n4 != n) {
            this.curItem.element.setAttribute("scale", int1 - n4 + "");
            if (s.indexOf(46) != -1) {
                this.curItem.element.setAttribute("insert-decimal-point", "true");
            }
        }
        else if (i > 0) {
            this.curItem.element.setAttribute("scale", "-" + i);
        }
    }
    
    @Override
    public void inASignClause(final ASignClause aSignClause) {
        if (aSignClause.getSeparateCharacter() != null) {
            this.curItem.element.setAttribute("sign-separate", "true");
        }
    }
    
    @Override
    public void inALeadingLeadingOrTrailing(final ALeadingLeadingOrTrailing aLeadingLeadingOrTrailing) {
        this.curItem.element.setAttribute("sign-position", "leading");
    }
    
    @Override
    public void inATrailingLeadingOrTrailing(final ATrailingLeadingOrTrailing aTrailingLeadingOrTrailing) {
        this.curItem.element.setAttribute("sign-position", "trailing");
    }
    
    @Override
    public void inABlankWhenZeroClause(final ABlankWhenZeroClause aBlankWhenZeroClause) {
        this.curItem.element.setAttribute("blank-when-zero", "true");
        super.inABlankWhenZeroClause(aBlankWhenZeroClause);
    }
    
    @Override
    public void inABlankWhenZeroClauseClause(final ABlankWhenZeroClauseClause aBlankWhenZeroClauseClause) {
        this.curItem.element.setAttribute("blank-when-zero", "true");
        super.inABlankWhenZeroClauseClause(aBlankWhenZeroClauseClause);
    }
    
    @Override
    public void inABinaryUsagePhrase(final ABinaryUsagePhrase aBinaryUsagePhrase) {
        this.curItem.element.setAttribute("usage", "binary");
        this.curItem.element.setAttribute("numeric", "true");
    }
    
    @Override
    public void inACompUsagePhrase(final ACompUsagePhrase aCompUsagePhrase) {
        this.curItem.element.setAttribute("usage", "computational");
        this.curItem.element.setAttribute("numeric", "true");
    }
    
    @Override
    public void inAComp1UsagePhrase(final AComp1UsagePhrase aComp1UsagePhrase) {
        this.curItem.element.setAttribute("usage", "computational-1");
        this.curItem.element.setAttribute("numeric", "true");
    }
    
    @Override
    public void inAComp2UsagePhrase(final AComp2UsagePhrase aComp2UsagePhrase) {
        this.curItem.element.setAttribute("usage", "computational-2");
        this.curItem.element.setAttribute("numeric", "true");
    }
    
    @Override
    public void inAComp3UsagePhrase(final AComp3UsagePhrase aComp3UsagePhrase) {
        this.curItem.element.setAttribute("usage", "computational-3");
        this.curItem.element.setAttribute("numeric", "true");
    }
    
    @Override
    public void inAComp4UsagePhrase(final AComp4UsagePhrase aComp4UsagePhrase) {
        this.curItem.element.setAttribute("usage", "computational-4");
        this.curItem.element.setAttribute("numeric", "true");
    }
    
    @Override
    public void inAComp5UsagePhrase(final AComp5UsagePhrase aComp5UsagePhrase) {
        this.curItem.element.setAttribute("usage", "computational-5");
        this.curItem.element.setAttribute("numeric", "true");
    }
    
    @Override
    public void inAComp6UsagePhrase(final AComp6UsagePhrase aComp6UsagePhrase) {
        this.curItem.element.setAttribute("usage", "computational-6");
        this.curItem.element.setAttribute("numeric", "true");
    }
    
    @Override
    public void inADisplayUsagePhrase(final ADisplayUsagePhrase aDisplayUsagePhrase) {
        this.curItem.element.setAttribute("usage", "display");
    }
    
    @Override
    public void inADisplay1UsagePhrase(final ADisplay1UsagePhrase aDisplay1UsagePhrase) {
        this.curItem.element.setAttribute("usage", "display-1");
    }
    
    @Override
    public void inAIndexUsagePhrase(final AIndexUsagePhrase aIndexUsagePhrase) {
        this.curItem.element.setAttribute("usage", "index");
    }
    
    @Override
    public void inANationalUsagePhrase(final ANationalUsagePhrase aNationalUsagePhrase) {
        this.curItem.element.setAttribute("usage", "national");
    }
    
    @Override
    public void inAObjectReferencePhrase(final AObjectReferencePhrase aObjectReferencePhrase) {
        this.curItem.element.setAttribute("object-reference", aObjectReferencePhrase.getDataName().getText());
    }
    
    @Override
    public void inAPackedDecimalUsagePhrase(final APackedDecimalUsagePhrase aPackedDecimalUsagePhrase) {
        this.curItem.element.setAttribute("usage", "packed-decimal");
    }
    
    @Override
    public void inAPointerUsagePhrase(final APointerUsagePhrase aPointerUsagePhrase) {
        this.curItem.element.setAttribute("usage", "pointer");
    }
    
    @Override
    public void inAProcedurePointerUsagePhrase(final AProcedurePointerUsagePhrase aProcedurePointerUsagePhrase) {
        this.curItem.element.setAttribute("usage", "procedure-pointer");
    }
    
    @Override
    public void inAFunctionPointerUsagePhrase(final AFunctionPointerUsagePhrase aFunctionPointerUsagePhrase) {
        this.curItem.element.setAttribute("usage", "function-pointer");
    }
    
    @Override
    public void inAJustifiedClause(final AJustifiedClause aJustifiedClause) {
        String s = "right";
        if (aJustifiedClause.getRight() == null) {
            s = "true";
        }
        this.curItem.element.setAttribute("justified", s);
    }
    
    @Override
    public void caseTZeros(final TZeros tZeros) {
        tZeros.setText("zeros");
    }
    
    @Override
    public void caseTSpaces(final TSpaces tSpaces) {
        tSpaces.setText("spaces");
    }
    
    @Override
    public void caseTHighValues(final THighValues tHighValues) {
        tHighValues.setText("high-values");
    }
    
    @Override
    public void caseTLowValues(final TLowValues tLowValues) {
        tLowValues.setText("low-values");
    }
    
    @Override
    public void caseTQuotes(final TQuotes tQuotes) {
        tQuotes.setText("quotes");
    }
    
    @Override
    public void caseTNulls(final TNulls tNulls) {
        tNulls.setText("nulls");
    }
    
    @Override
    public void caseTAlphanumericLiteral(final TAlphanumericLiteral tAlphanumericLiteral) {
        final String text = tAlphanumericLiteral.getText();
        if (text.startsWith("X")) {
            tAlphanumericLiteral.setText(text.replace('\"', '\''));
        }
        else {
            int n = 0;
            int length = text.length();
            final StringBuilder sb = new StringBuilder(length);
            char c = '\uffff';
            int n2 = 0;
            boolean b = false;
            if (text.startsWith("'") || text.startsWith("\"")) {
                n = 1;
                if (text.endsWith(text.substring(0, 1))) {
                    --length;
                }
                b = true;
            }
            for (int i = n; i < length; ++i) {
                final char char1 = text.charAt(i);
                if (n2 != 0) {
                    switch (char1) {
                        case 9:
                        case 13:
                        case 32:
                        case 45: {
                            break;
                        }
                        default: {
                            c = '\uffff';
                            n2 = 0;
                            break;
                        }
                    }
                }
                else {
                    switch (char1) {
                        case 10: {
                            n2 = 1;
                            c = char1;
                            continue;
                        }
                        case 34:
                        case 39: {
                            if (char1 == c) {
                                c = '\uffff';
                                continue;
                            }
                            break;
                        }
                    }
                    sb.append(char1);
                    c = char1;
                }
            }
            if (b) {
                char c2 = '\"';
                if (sb.indexOf("\"") > 0) {
                    c2 = '\'';
                    adj(sb);
                }
                sb.insert(0, c2);
                sb.append(c2);
            }
            tAlphanumericLiteral.setText(sb.toString());
        }
    }
    
    public static void adj(final StringBuilder sb) {
        final int n = sb.length() - 2;
        if (sb.charAt(sb.length() - 1) == '\'') {
            sb.append('\'');
        }
        for (int i = n; i >= 0; --i) {
            if (sb.charAt(i) == '\'') {
                sb.insert(i + 1, '\'');
            }
        }
    }
    
    @Override
    public void outAValueClause(final AValueClause aValueClause) {
        this.curItem.element.setAttribute("value", aValueClause.getLiteral().toString().trim());
    }
    
    @Override
    public void inAValueItem(final AValueItem aValueItem) {
        final String text = aValueItem.getDataName().getText();
        this.curItem = new Item();
        (this.curItem.element = this.document.createElement("condition")).setAttribute("name", text);
        this.prevItem.element.appendChild(this.curItem.element);
    }
    
    @Override
    public void outASingleLiteralSequence(final ASingleLiteralSequence aSingleLiteralSequence) {
        if (aSingleLiteralSequence.getAll() != null) {
            this.curItem.element.setAttribute("all", "true");
        }
        final Element element = this.document.createElement("condition");
        element.setAttribute("value", aSingleLiteralSequence.getLiteral().toString().trim());
        this.curItem.element.appendChild(element);
    }
    
    @Override
    public void outASequenceLiteralSequence(final ASequenceLiteralSequence aSequenceLiteralSequence) {
        final Element element = this.document.createElement("condition");
        element.setAttribute("value", aSequenceLiteralSequence.getLiteral().toString().trim());
        this.curItem.element.appendChild(element);
    }
    
    @Override
    public void outAThroughSingleLiteralSequence(final AThroughSingleLiteralSequence aThroughSingleLiteralSequence) {
        final Element element = this.document.createElement("condition");
        element.setAttribute("value", aThroughSingleLiteralSequence.getFrom().toString().trim());
        element.setAttribute("through", aThroughSingleLiteralSequence.getTo().toString().trim());
        this.curItem.element.appendChild(element);
    }
    
    @Override
    public void outAThroughSequenceLiteralSequence(final AThroughSequenceLiteralSequence aThroughSequenceLiteralSequence) {
        final Element element = this.document.createElement("condition");
        element.setAttribute("value", aThroughSequenceLiteralSequence.getFrom().toString().trim());
        element.setAttribute("through", aThroughSequenceLiteralSequence.getTo().toString().trim());
        this.curItem.element.appendChild(element);
    }
    
    private String removeChars(final String str, final String delim) {
        final StringTokenizer stringTokenizer = new StringTokenizer(str, delim, false);
        final StringBuilder sb = new StringBuilder();
        while (stringTokenizer.hasMoreElements()) {
            sb.append(stringTokenizer.nextElement());
        }
        return sb.toString();
    }
    
    private int postProcessNode(final Element element, int int1) {
        int int2 = 0;
        int int3 = 0;
        int int4 = 0;
        final int a = int1;
        final String usage = this.getUsage(element);
        if (element.hasAttribute("redefines")) {
            final String attribute = element.getAttribute("redefines");
            Element element2 = null;
            final NodeList elementsByTagName = this.document.getDocumentElement().getElementsByTagName("item");
            for (int i = 0; i < elementsByTagName.getLength(); ++i) {
                final Element element3 = (Element)elementsByTagName.item(i);
                if (element3.getAttribute("name").equalsIgnoreCase(attribute)) {
                    element2 = element3;
                    break;
                }
            }
            if (element2 != null && element2.hasAttribute("position")) {
                int1 = Integer.parseInt(element2.getAttribute("position"));
                element2.setAttribute("redefined", "true");
            }
            else if (element2.hasAttribute("level") && "01".equals("level")) {
                int1 = 0;
                element2.setAttribute("redefined", "true");
            }
            else {
                System.out.println(">> position error " + element.getAttribute("name") + " %% " + attribute);
            }
        }
        int postProcessNode = int1;
        if (element.hasAttribute("display-length")) {
            int2 = Integer.parseInt(element.getAttribute("display-length"));
            if (element.hasAttribute("assumed-digits")) {
                int3 = Integer.parseInt(element.getAttribute("assumed-digits"));
            }
            if (element.hasAttribute("double-byte-chars")) {
                int4 = Integer.parseInt(element.getAttribute("double-byte-chars"));
            }
        }
        else {
            final NodeList childNodes = element.getChildNodes();
            for (int j = 0; j < childNodes.getLength(); ++j) {
                final Node item = childNodes.item(j);
                if (item.getNodeType() == 1) {
                    final Element element4 = (Element)item;
                    if (!element4.getTagName().equals("condition")) {
                        postProcessNode = this.postProcessNode(element4, postProcessNode);
                    }
                }
                int2 = postProcessNode - int1;
            }
        }
        int setLength = this.setLength(element, !"true".equals(element.getAttribute("signed")), int2, int3, int4);
        if (element.hasAttribute("sync")) {
            final int sync = this.numDef.getSyncAt(usage, setLength);
            final int n = (int1 - 1) % sync;
            if (n > 0) {
                int1 = int1 - n + sync;
            }
        }
        element.setAttribute("position", Integer.toString(int1));
        if (element.hasAttribute("occurs")) {
            setLength *= Integer.parseInt(element.getAttribute("occurs"));
        }
        return Math.max(a, int1 + setLength);
    }
    
    private int setLength(final Element element, final boolean b, int chkStorageLength, final int i, final int j) {
        int binarySize = chkStorageLength - i + j;
        if (!this.hasChildItems(element)) {
            final String usage = this.getUsage(element);
            if (usage != null && usage.length() > 0) {
                if (this.numDef != null) {
                    chkStorageLength = this.numDef.chkStorageLength(chkStorageLength, usage);
                    binarySize = this.numDef.getBinarySize(usage, binarySize, b, element.hasAttribute("sync"));
                }
            }
            else if (element.hasAttribute("sign-separate") && "true".equalsIgnoreCase(element.getAttribute("sign-separate"))) {
                ++binarySize;
                ++chkStorageLength;
            }
        }
        element.setAttribute("display-length", Integer.toString(chkStorageLength));
        element.setAttribute("storage-length", Integer.toString(binarySize));
        if (j > 0) {
            element.setAttribute("double-byte-chars", Integer.toString(j));
        }
        if (i != 0) {
            element.setAttribute("assumed-digits", Integer.toString(i));
        }
        return binarySize;
    }
    
    private boolean hasChildItems(final Element element) {
        if (element.hasChildNodes()) {
            final NodeList childNodes = element.getChildNodes();
            for (int i = childNodes.getLength() - 1; i >= 0; --i) {
                if (childNodes.item(i).getNodeType() == 1 && !((Element)childNodes.item(i)).getTagName().equals("condition")) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private String getUsage(final Element element) {
        String s = "";
        if (element.hasAttribute("usage")) {
            s = element.getAttribute("usage");
        }
        else if ("true".equalsIgnoreCase(element.getAttribute("numeric")) && !"true".equalsIgnoreCase(element.getAttribute("editted-numeric"))) {
            Node parentNode = element;
            do {
                parentNode = parentNode.getParentNode();
            } while (parentNode != null && parentNode instanceof Element && !((Element)parentNode).hasAttribute("usage"));
            if (parentNode != null && parentNode instanceof Element) {
                s = ((Element)parentNode).getAttribute("usage");
                if (s != null && s.length() > 0) {
                    element.setAttribute("inherited-usage", "true");
                    element.setAttribute("usage", s);
                }
            }
        }
        return s;
    }
    
    static {
        CopyBookAnalyzer.defaultNumDef = DialectManager.MAINFRAME_COBOL.getNumericDefinition();
    }
    
    class Item
    {
        int level;
        Element element;
        
        Item(final int level, final String s) {
            this.level = level;
            (this.element = CopyBookAnalyzer.this.document.createElement("item")).setAttribute("level", new DecimalFormat("00").format(level));
            this.element.setAttribute("name", s);
        }
        
        Item() {
        }
    }
}
