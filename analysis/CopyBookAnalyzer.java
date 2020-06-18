// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.analysis;

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
import net.sf.cb2xml.def.Cb2xmlConstants;
import net.sf.cb2xml.sablecc.node.APictureClause;
import net.sf.cb2xml.sablecc.node.ASynchronizedClauseClause;
import net.sf.cb2xml.sablecc.node.AOccursTo;
import net.sf.cb2xml.sablecc.node.AVariableOccursFixedOrVariable;
import net.sf.cb2xml.sablecc.node.AFixedOccursFixedOrVariable;
import net.sf.cb2xml.sablecc.node.ARedefinesClause;
import net.sf.cb2xml.sablecc.node.PDataNameOrFiller;
import net.sf.cb2xml.sablecc.node.AItem;
import net.sf.cb2xml.sablecc.node.Node;
import java.util.List;
import net.sf.cb2xml.sablecc.node.TNumber88;
import net.sf.cb2xml.sablecc.node.Token;
import net.sf.cb2xml.sablecc.node.TNumberNot88;
import java.util.Iterator;
import net.sf.cb2xml.sablecc.node.ARecordDescription;
import net.sf.cb2xml.sablecc.parser.Parser;
import net.sf.cb2xml.def.NumericDefinition;
import net.sf.cb2xml.sablecc.analysis.DepthFirstAdapter;

public class CopyBookAnalyzer extends DepthFirstAdapter
{
    private final NumericDefinition numDef;
    private final Parser parser;
    private final boolean loadComments;
    private String copyBookName;
    private Item prevItem;
    private Item curItem;
    private Condition condition;
    private Copybook copybook;
    private BaseItem parent;
    private int lowestLevel;
    
    public CopyBookAnalyzer(final String copyBookName, final Parser parser, final NumericDefinition numDef, final boolean loadComments) {
        this.lowestLevel = 1000;
        this.copyBookName = copyBookName;
        this.parser = parser;
        this.numDef = numDef;
        this.loadComments = loadComments;
    }
    
    public final Copybook getCopybook() {
        return this.copybook;
    }
    
    @Override
    public void inARecordDescription(final ARecordDescription aRecordDescription) {
        this.copybook = new Copybook(this.copyBookName, this.numDef.getName());
        this.parent = this.copybook;
    }
    
    @Override
    public void outARecordDescription(final ARecordDescription aRecordDescription) {
        Positions postProcessNode = new Positions();
        for (final Item item : this.copybook.getChildItems()) {
            if (item.levelNumber == 1) {
                this.postProcessNode(item, new Positions());
            }
            else {
                postProcessNode = this.postProcessNode(item, postProcessNode);
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
        if (this.loadComments) {
            final List list = (List)this.parser.ignoredTokens.getIn(token);
            if (list != null) {
                final Iterator<Object> iterator = list.iterator();
                while (iterator.hasNext()) {
                    final String trim = iterator.next().toString().trim();
                    if (trim.length() > 0) {
                        this.parent.addBefore(this.curItem, this.correctForMinus(trim));
                    }
                }
            }
        }
    }
    
    private String correctForMinus(String string) {
        final int index = string.indexOf("--");
        if (index >= 0 || string.endsWith("-")) {
            int i = (index >= 0) ? index : (string.length() - 1);
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
            if (sb.charAt(n2) == '-') {
                sb.setCharAt(n2, '=');
            }
            string = sb.toString();
        }
        return string;
    }
    
    @Override
    public void inAItem(final AItem aItem) {
        final String trim = aItem.getNumberNot88().toString().trim();
        final int int1 = Integer.parseInt(trim);
        final PDataNameOrFiller dataNameOrFiller = aItem.getDataNameOrFiller();
        String trim2 = "";
        if (dataNameOrFiller != null) {
            trim2 = dataNameOrFiller.toString().trim();
        }
        if (int1 <= 77) {
            if (int1 <= this.lowestLevel || this.prevItem == null) {
                this.parent = this.copybook;
                this.lowestLevel = int1;
            }
            else if (int1 > this.prevItem.levelNumber) {
                this.parent = this.prevItem;
            }
            else if (int1 <= this.prevItem.levelNumber) {
                this.parent = this.prevItem.parentItem;
                Item item;
                while (this.parent instanceof Item && (item = (Item)this.parent).levelNumber >= int1) {
                    this.parent = item.parentItem;
                }
            }
            this.curItem = new Item(this.parent, int1, trim, trim2);
            this.prevItem = this.curItem;
        }
    }
    
    @Override
    public void inARedefinesClause(final ARedefinesClause aRedefinesClause) {
        this.curItem.redefines = aRedefinesClause.getDataName().getText();
    }
    
    @Override
    public void inAFixedOccursFixedOrVariable(final AFixedOccursFixedOrVariable aFixedOccursFixedOrVariable) {
        this.curItem.occurs = Integer.parseInt(aFixedOccursFixedOrVariable.getNumber().toString().trim());
    }
    
    @Override
    public void inAVariableOccursFixedOrVariable(final AVariableOccursFixedOrVariable aVariableOccursFixedOrVariable) {
        this.curItem.occurs = Integer.parseInt(aVariableOccursFixedOrVariable.getNumber().toString().trim());
        this.curItem.dependingOn = aVariableOccursFixedOrVariable.getDataName().getText();
    }
    
    @Override
    public void inAOccursTo(final AOccursTo aOccursTo) {
        this.curItem.occursMin = Integer.parseInt(aOccursTo.getNumber().toString().trim());
    }
    
    @Override
    public void inASynchronizedClauseClause(final ASynchronizedClauseClause aSynchronizedClauseClause) {
        this.curItem.sync = true;
    }
    
    @Override
    public void inAPictureClause(final APictureClause aPictureClause) {
        boolean b = true;
        String picture = this.removeChars(aPictureClause.getCharacterString().toString(), " ");
        this.curItem.picture = picture;
        if (picture.charAt(0) == 'S' || picture.charAt(0) == 's') {
            this.curItem.signed = true;
            picture = picture.substring(1);
            b = false;
        }
        int displayLength = 0;
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 1;
        if (this.curItem.displayLength >= 0) {
            displayLength = this.curItem.displayLength;
        }
        int n5 = -1;
        int scale = 0;
        boolean b2 = false;
        boolean b3 = false;
        int n6 = 1;
        final String upperCase = picture.toUpperCase();
        for (int i = 0; i < picture.length(); ++i) {
            final char char1 = upperCase.charAt(i);
            int n7 = 0;
            switch (char1) {
                case 71:
                case 78: {
                    ++n3;
                    n7 = 1;
                }
                case 65:
                case 66:
                case 69: {
                    b3 = true;
                    ++displayLength;
                    break;
                }
                case 46: {
                    b3 = true;
                    ++displayLength;
                }
                case 86: {
                    b2 = true;
                    n5 = displayLength;
                    break;
                }
                case 80: {
                    b2 = true;
                    ++displayLength;
                    if (n5 < 0) {
                        ++n;
                        break;
                    }
                    ++n2;
                    ++scale;
                    break;
                }
                case 36: {
                    b3 = true;
                    if (n6 != 0) {
                        n6 = 0;
                        b2 = true;
                        break;
                    }
                    ++displayLength;
                    break;
                }
                case 67:
                case 68: {
                    ++i;
                }
                case 42:
                case 43:
                case 45:
                case 90: {
                    b3 = true;
                    b2 = true;
                    ++displayLength;
                    break;
                }
                case 48: {
                    b3 = true;
                }
                case 57: {
                    b2 = true;
                    if (n5 >= 0) {
                        ++scale;
                    }
                }
                case 44:
                case 47:
                case 88: {
                    ++displayLength;
                    break;
                }
                case 40: {
                    final int index = picture.indexOf(41, i + 1);
                    final int int1 = Integer.parseInt(picture.substring(i + 1, index));
                    i = index;
                    n3 += (int1 - 1) * n4;
                    displayLength += int1 - 1;
                    if (b2 && n5 >= 0) {
                        scale += int1 - 1;
                        break;
                    }
                    break;
                }
            }
            n4 = n7;
        }
        if (b2) {
            if (b3) {
                this.curItem.numericClass = Cb2xmlConstants.NumericClass.NUMERIC_EDITED;
            }
            else {
                this.curItem.numericClass = Cb2xmlConstants.NumericClass.NUMERIC_IN_COBOL;
            }
        }
        this.setLength(this.curItem, b, displayLength, n + n2, n3);
        if (n5 != -1 && displayLength - n5 != n2) {
            this.curItem.scale = scale;
            if (picture.indexOf(46) != -1) {
                this.curItem.insertDecimal = true;
            }
        }
        else if (n > 0) {
            this.curItem.scale = -n;
        }
    }
    
    @Override
    public void inASignClause(final ASignClause aSignClause) {
        if (aSignClause.getSeparateCharacter() != null) {
            this.curItem.signClause = Cb2xmlConstants.SignClause.SIGN_SEPARATE;
        }
    }
    
    @Override
    public void inALeadingLeadingOrTrailing(final ALeadingLeadingOrTrailing aLeadingLeadingOrTrailing) {
        if (this.curItem.signClause != null && this.curItem.signClause.signSeparate) {
            this.curItem.signClause = Cb2xmlConstants.SignClause.SIGN_LEADING_SEPARATE;
        }
        else {
            this.curItem.signClause = Cb2xmlConstants.SignClause.SIGN_LEADING;
        }
    }
    
    @Override
    public void inATrailingLeadingOrTrailing(final ATrailingLeadingOrTrailing aTrailingLeadingOrTrailing) {
        if (this.curItem.signClause != null && this.curItem.signClause.signSeparate) {
            this.curItem.signClause = Cb2xmlConstants.SignClause.SIGN_TRAILING_SEPARATE;
        }
        else {
            this.curItem.signClause = Cb2xmlConstants.SignClause.SIGN_TRAILING;
        }
    }
    
    @Override
    public void inABlankWhenZeroClause(final ABlankWhenZeroClause aBlankWhenZeroClause) {
        this.curItem.blankWhenZero = true;
        super.inABlankWhenZeroClause(aBlankWhenZeroClause);
    }
    
    @Override
    public void inABlankWhenZeroClauseClause(final ABlankWhenZeroClauseClause aBlankWhenZeroClauseClause) {
        this.curItem.blankWhenZero = true;
        super.inABlankWhenZeroClauseClause(aBlankWhenZeroClauseClause);
    }
    
    @Override
    public void inABinaryUsagePhrase(final ABinaryUsagePhrase aBinaryUsagePhrase) {
        this.curItem.usage = Cb2xmlConstants.Usage.BINARY;
        this.curItem.numericClass = Cb2xmlConstants.NumericClass.NUMERIC_IN_COBOL;
    }
    
    @Override
    public void inACompUsagePhrase(final ACompUsagePhrase aCompUsagePhrase) {
        this.curItem.usage = Cb2xmlConstants.Usage.COMP;
        this.curItem.numericClass = Cb2xmlConstants.NumericClass.NUMERIC_IN_COBOL;
    }
    
    @Override
    public void inAComp1UsagePhrase(final AComp1UsagePhrase aComp1UsagePhrase) {
        this.curItem.usage = Cb2xmlConstants.Usage.COMP_1;
        this.curItem.numericClass = Cb2xmlConstants.NumericClass.NUMERIC_IN_COBOL;
    }
    
    @Override
    public void inAComp2UsagePhrase(final AComp2UsagePhrase aComp2UsagePhrase) {
        this.curItem.usage = Cb2xmlConstants.Usage.COMP_2;
        this.curItem.numericClass = Cb2xmlConstants.NumericClass.NUMERIC_IN_COBOL;
    }
    
    @Override
    public void inAComp3UsagePhrase(final AComp3UsagePhrase aComp3UsagePhrase) {
        this.curItem.usage = Cb2xmlConstants.Usage.COMP_3;
        this.curItem.numericClass = Cb2xmlConstants.NumericClass.NUMERIC_IN_COBOL;
    }
    
    @Override
    public void inAComp4UsagePhrase(final AComp4UsagePhrase aComp4UsagePhrase) {
        this.curItem.usage = Cb2xmlConstants.Usage.COMP_4;
        this.curItem.numericClass = Cb2xmlConstants.NumericClass.NUMERIC_IN_COBOL;
    }
    
    @Override
    public void inAComp5UsagePhrase(final AComp5UsagePhrase aComp5UsagePhrase) {
        this.curItem.usage = Cb2xmlConstants.Usage.COMP_5;
        this.curItem.numericClass = Cb2xmlConstants.NumericClass.NUMERIC_IN_COBOL;
    }
    
    @Override
    public void inAComp6UsagePhrase(final AComp6UsagePhrase aComp6UsagePhrase) {
        this.curItem.usage = Cb2xmlConstants.Usage.COMP_6;
        this.curItem.numericClass = Cb2xmlConstants.NumericClass.NUMERIC_IN_COBOL;
    }
    
    @Override
    public void inADisplayUsagePhrase(final ADisplayUsagePhrase aDisplayUsagePhrase) {
        this.curItem.usage = Cb2xmlConstants.Usage.DISPLAY;
    }
    
    @Override
    public void inADisplay1UsagePhrase(final ADisplay1UsagePhrase aDisplay1UsagePhrase) {
        this.curItem.usage = Cb2xmlConstants.Usage.DISPLAY_1;
    }
    
    @Override
    public void inAIndexUsagePhrase(final AIndexUsagePhrase aIndexUsagePhrase) {
        this.curItem.usage = Cb2xmlConstants.Usage.INDEX;
    }
    
    @Override
    public void inANationalUsagePhrase(final ANationalUsagePhrase aNationalUsagePhrase) {
        this.curItem.usage = Cb2xmlConstants.Usage.NATIONAL;
    }
    
    @Override
    public void inAObjectReferencePhrase(final AObjectReferencePhrase aObjectReferencePhrase) {
        this.curItem.usage = Cb2xmlConstants.Usage.OBJECT_REFERENCE;
    }
    
    @Override
    public void inAPackedDecimalUsagePhrase(final APackedDecimalUsagePhrase aPackedDecimalUsagePhrase) {
        this.curItem.usage = Cb2xmlConstants.Usage.PACKED_DECIMAL;
    }
    
    @Override
    public void inAPointerUsagePhrase(final APointerUsagePhrase aPointerUsagePhrase) {
        this.curItem.usage = Cb2xmlConstants.Usage.POINTER;
    }
    
    @Override
    public void inAProcedurePointerUsagePhrase(final AProcedurePointerUsagePhrase aProcedurePointerUsagePhrase) {
        this.curItem.usage = Cb2xmlConstants.Usage.PROCEDURAL_POINTER;
    }
    
    @Override
    public void inAFunctionPointerUsagePhrase(final AFunctionPointerUsagePhrase aFunctionPointerUsagePhrase) {
        this.curItem.usage = Cb2xmlConstants.Usage.FUNCTION_POINTER;
    }
    
    @Override
    public void inAJustifiedClause(final AJustifiedClause aJustifiedClause) {
        this.curItem.justified = Cb2xmlConstants.Justified.RIGHT;
        if (aJustifiedClause.getRight() == null) {
            this.curItem.justified = Cb2xmlConstants.Justified.JUSTIFIED;
        }
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
        this.curItem.value = aValueClause.getLiteral().toString().trim();
    }
    
    @Override
    public void inAValueItem(final AValueItem aValueItem) {
        this.condition = new Condition(aValueItem.getDataName().getText(), "", "");
        this.prevItem.addCondition(this.condition);
        this.parent = this.prevItem;
    }
    
    @Override
    public void outASingleLiteralSequence(final ASingleLiteralSequence aSingleLiteralSequence) {
        if (aSingleLiteralSequence.getAll() != null) {
            this.condition.all = true;
        }
        this.condition.addCondition(new Condition("", "", aSingleLiteralSequence.getLiteral().toString().trim()));
    }
    
    @Override
    public void outASequenceLiteralSequence(final ASequenceLiteralSequence aSequenceLiteralSequence) {
        this.condition.addCondition(new Condition("", "", aSequenceLiteralSequence.getLiteral().toString().trim()));
    }
    
    @Override
    public void outAThroughSingleLiteralSequence(final AThroughSingleLiteralSequence aThroughSingleLiteralSequence) {
        this.condition.addCondition(new Condition("", aThroughSingleLiteralSequence.getTo().toString().trim(), aThroughSingleLiteralSequence.getFrom().toString().trim()));
    }
    
    @Override
    public void outAThroughSequenceLiteralSequence(final AThroughSequenceLiteralSequence aThroughSequenceLiteralSequence) {
        this.condition.addCondition(new Condition("", aThroughSequenceLiteralSequence.getTo().toString().trim(), aThroughSequenceLiteralSequence.getFrom().toString().trim()));
    }
    
    private String removeChars(final String str, final String delim) {
        final StringTokenizer stringTokenizer = new StringTokenizer(str, delim, false);
        final StringBuilder sb = new StringBuilder();
        while (stringTokenizer.hasMoreElements()) {
            sb.append(stringTokenizer.nextElement());
        }
        return sb.toString();
    }
    
    private Positions postProcessNode(final Item item, final Positions positions) {
        int n = 0;
        int n2 = 0;
        final int n3 = 0;
        final int n4 = 0;
        final Positions clonePos = positions.clonePos();
        final String usage = this.getUsage(item);
        if (item.redefines != null && item.redefines.length() > 0) {
            final String redefines = item.redefines;
            Item item2 = null;
            for (final Item item3 : item.parentItem.getChildItems()) {
                if (redefines.equalsIgnoreCase(item3.getFieldName())) {
                    item2 = item3;
                    break;
                }
                if (item3 == item) {
                    break;
                }
            }
            if (item2 != null && item2.position > 0) {
                positions.set(item2.position, item2.displayPosition);
                item2.fieldRedefined = true;
            }
            else {
                System.out.println(">> position error " + item.getFieldName() + " %% " + redefines);
            }
        }
        Positions positions2 = positions.clonePos();
        if (item.displayLength > 0) {
            n = this.setLength(item, !item.signed, item.displayLength, Math.max(0, item.assumedDigits), Math.max(0, item.doubleByteChars));
            n2 = item.displayLength;
        }
        else {
            final List<? extends Item> childItems = item.getChildItems();
            if (childItems.size() == 0) {
                n = this.setLength(item, !item.signed, n2, n3, n4);
                n2 = item.displayLength;
            }
            else {
                final Iterator<? extends Item> iterator2 = childItems.iterator();
                while (iterator2.hasNext()) {
                    positions2 = this.postProcessNode((Item)iterator2.next(), positions2);
                    n2 = Math.max(n2, positions2.display - positions.display);
                    n = Math.max(n, positions2.storage - positions.storage);
                }
                item.displayLength = n2;
                item.storageLength = n;
            }
        }
        int storage = positions.storage;
        if (item.sync) {
            final int sync = this.numDef.getSyncAt(usage, n);
            final int n5 = (storage - 1) % sync;
            if (n5 > 0) {
                storage = storage - n5 + sync;
                positions.storage = storage;
            }
        }
        item.position = storage;
        item.displayPosition = positions.display;
        if (item.occurs >= 0) {
            n *= item.occurs;
            n2 *= item.occurs;
        }
        positions.storage += n;
        positions.display += n2;
        positions.max(clonePos);
        return positions;
    }
    
    private int setLength(final Item item, final boolean b, int chkStorageLength, final int assumedDigits, final int doubleByteChars) {
        int binarySize = chkStorageLength - assumedDigits + doubleByteChars;
        if (item.getChildItems().size() <= 0) {
            final Cb2xmlConstants.Usage usage = item.usage;
            if (usage != null && usage != Cb2xmlConstants.Usage.NONE) {
                if (this.numDef != null) {
                    chkStorageLength = this.numDef.chkStorageLength(chkStorageLength, usage.getName());
                    binarySize = this.numDef.getBinarySize(usage.getName(), binarySize, b, item.isSync());
                }
            }
            else if (item.signClause.signSeparate) {
                ++binarySize;
                ++chkStorageLength;
            }
        }
        item.displayLength = chkStorageLength;
        item.storageLength = binarySize;
        if (doubleByteChars > 0) {
            item.doubleByteChars = doubleByteChars;
        }
        if (assumedDigits != 0) {
            item.assumedDigits = assumedDigits;
        }
        return binarySize;
    }
    
    private String getUsage(final Item item) {
        String name = "";
        if (item.usage != Cb2xmlConstants.Usage.NONE) {
            name = item.usage.getName();
        }
        else if (item.numericClass == Cb2xmlConstants.NumericClass.NUMERIC_IN_COBOL) {
            Item item2 = item;
            while (item2.parentItem != null && item2.parentItem instanceof Item && (item2 = (Item)item2.parentItem).usage == Cb2xmlConstants.Usage.NONE) {}
            if (item2 != null && item2.usage != null && item2.usage != Cb2xmlConstants.Usage.NONE) {
                item.inheritedUsage = true;
                item.usage = item2.usage;
            }
        }
        return name;
    }
    
    private static class Positions
    {
        int storage;
        int display;
        
        private Positions() {
            this.storage = 1;
            this.display = 1;
        }
        
        public Positions set(final int storage, final int display) {
            this.storage = storage;
            this.display = display;
            return this;
        }
        
        Positions clonePos() {
            return new Positions().set(this.storage, this.display);
        }
        
        void max(final Positions positions) {
            this.storage = Math.max(this.storage, positions.storage);
            this.display = Math.max(this.display, positions.display);
        }
        
        void add(final Positions positions) {
            this.storage += positions.storage;
            this.display += positions.display;
        }
    }
}
