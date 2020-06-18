// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.parser;

import java.io.InputStream;
import java.io.DataInputStream;
import java.io.BufferedInputStream;
import net.sf.cb2xml.sablecc.node.PIndexedByPhrase;
import net.sf.cb2xml.sablecc.node.PAscendingOrDescendingKeyPhrase;
import net.sf.cb2xml.sablecc.node.ANumber88Number;
import net.sf.cb2xml.sablecc.node.ANumberNot88Number;
import net.sf.cb2xml.sablecc.node.ABracketedNumber;
import net.sf.cb2xml.sablecc.node.TRparen;
import net.sf.cb2xml.sablecc.node.TLparen;
import net.sf.cb2xml.sablecc.node.ADotZeeCharacterSubstring;
import net.sf.cb2xml.sablecc.node.TDotZee;
import net.sf.cb2xml.sablecc.node.ADotPlusCharacterSubstring;
import net.sf.cb2xml.sablecc.node.TDotPlus;
import net.sf.cb2xml.sablecc.node.ADotMinusCharacterSubstring;
import net.sf.cb2xml.sablecc.node.TDotMinus;
import net.sf.cb2xml.sablecc.node.ABracketedNumberCharacterSubstring;
import net.sf.cb2xml.sablecc.node.PBracketedNumber;
import net.sf.cb2xml.sablecc.node.ANumericLiteralCharacterSubstring;
import net.sf.cb2xml.sablecc.node.ANumberCharacterSubstring;
import net.sf.cb2xml.sablecc.node.ACommaCharacterSubstring;
import net.sf.cb2xml.sablecc.node.ADollarCharacterSubstring;
import net.sf.cb2xml.sablecc.node.TDollar;
import net.sf.cb2xml.sablecc.node.ASlashCharacterSubstring;
import net.sf.cb2xml.sablecc.node.TSlash;
import net.sf.cb2xml.sablecc.node.AStarCharacterSubstring;
import net.sf.cb2xml.sablecc.node.TStar;
import net.sf.cb2xml.sablecc.node.AMinusCharacterSubstring;
import net.sf.cb2xml.sablecc.node.TMinus;
import net.sf.cb2xml.sablecc.node.APlusCharacterSubstring;
import net.sf.cb2xml.sablecc.node.TPlus;
import net.sf.cb2xml.sablecc.node.ADataNameCharacterSubstring;
import net.sf.cb2xml.sablecc.node.ASequenceCharacterString;
import net.sf.cb2xml.sablecc.node.ASingleCharacterString;
import net.sf.cb2xml.sablecc.node.PCharacterSubstring;
import net.sf.cb2xml.sablecc.node.AAlphanumericLiteralLiteral;
import net.sf.cb2xml.sablecc.node.TAlphanumericLiteral;
import net.sf.cb2xml.sablecc.node.ANumericLiteralLiteral;
import net.sf.cb2xml.sablecc.node.TNumericLiteral;
import net.sf.cb2xml.sablecc.node.ANumberLiteral;
import net.sf.cb2xml.sablecc.node.ANullsLiteral;
import net.sf.cb2xml.sablecc.node.TNulls;
import net.sf.cb2xml.sablecc.node.AQuotesLiteral;
import net.sf.cb2xml.sablecc.node.TQuotes;
import net.sf.cb2xml.sablecc.node.ALowValuesLiteral;
import net.sf.cb2xml.sablecc.node.TLowValues;
import net.sf.cb2xml.sablecc.node.AHighValuesLiteral;
import net.sf.cb2xml.sablecc.node.THighValues;
import net.sf.cb2xml.sablecc.node.ASpacesLiteral;
import net.sf.cb2xml.sablecc.node.TSpaces;
import net.sf.cb2xml.sablecc.node.AZerosLiteral;
import net.sf.cb2xml.sablecc.node.AThroughSequenceLiteralSequence;
import net.sf.cb2xml.sablecc.node.AThroughSingleLiteralSequence;
import net.sf.cb2xml.sablecc.node.TComma;
import net.sf.cb2xml.sablecc.node.ASequenceLiteralSequence;
import net.sf.cb2xml.sablecc.node.ASingleLiteralSequence;
import net.sf.cb2xml.sablecc.node.TAre;
import net.sf.cb2xml.sablecc.node.AValuesValueOrValues;
import net.sf.cb2xml.sablecc.node.TValues;
import net.sf.cb2xml.sablecc.node.AValueValueOrValues;
import net.sf.cb2xml.sablecc.node.AValueItem;
import net.sf.cb2xml.sablecc.node.PLiteralSequence;
import net.sf.cb2xml.sablecc.node.PValueOrValues;
import net.sf.cb2xml.sablecc.node.TNumber88;
import net.sf.cb2xml.sablecc.node.TAll;
import net.sf.cb2xml.sablecc.node.AValueClause;
import net.sf.cb2xml.sablecc.node.PLiteral;
import net.sf.cb2xml.sablecc.node.TValue;
import net.sf.cb2xml.sablecc.node.AThroughPhrase;
import net.sf.cb2xml.sablecc.node.TThrough;
import net.sf.cb2xml.sablecc.node.PThroughPhrase;
import net.sf.cb2xml.sablecc.node.ARenamesItem;
import net.sf.cb2xml.sablecc.node.TRenames;
import net.sf.cb2xml.sablecc.node.AObjectReferencePhrase;
import net.sf.cb2xml.sablecc.node.TReference;
import net.sf.cb2xml.sablecc.node.TObject;
import net.sf.cb2xml.sablecc.node.AFunctionPointerUsagePhrase;
import net.sf.cb2xml.sablecc.node.TFunctionPointer;
import net.sf.cb2xml.sablecc.node.AProcedurePointerUsagePhrase;
import net.sf.cb2xml.sablecc.node.TProcedurePointer;
import net.sf.cb2xml.sablecc.node.APointerUsagePhrase;
import net.sf.cb2xml.sablecc.node.TPointer;
import net.sf.cb2xml.sablecc.node.APackedDecimalUsagePhrase;
import net.sf.cb2xml.sablecc.node.TPackedDecimal;
import net.sf.cb2xml.sablecc.node.AObjectReferencePhraseUsagePhrase;
import net.sf.cb2xml.sablecc.node.PObjectReferencePhrase;
import net.sf.cb2xml.sablecc.node.ANationalUsagePhrase;
import net.sf.cb2xml.sablecc.node.TNational;
import net.sf.cb2xml.sablecc.node.AIndexUsagePhrase;
import net.sf.cb2xml.sablecc.node.TIndex;
import net.sf.cb2xml.sablecc.node.ADisplay1UsagePhrase;
import net.sf.cb2xml.sablecc.node.TDisplay1;
import net.sf.cb2xml.sablecc.node.ADisplayUsagePhrase;
import net.sf.cb2xml.sablecc.node.TDisplay;
import net.sf.cb2xml.sablecc.node.AComp6UsagePhrase;
import net.sf.cb2xml.sablecc.node.TComp6;
import net.sf.cb2xml.sablecc.node.AComp5UsagePhrase;
import net.sf.cb2xml.sablecc.node.TComp5;
import net.sf.cb2xml.sablecc.node.AComp4UsagePhrase;
import net.sf.cb2xml.sablecc.node.TComp4;
import net.sf.cb2xml.sablecc.node.AComp3UsagePhrase;
import net.sf.cb2xml.sablecc.node.TComp3;
import net.sf.cb2xml.sablecc.node.AComp2UsagePhrase;
import net.sf.cb2xml.sablecc.node.TComp2;
import net.sf.cb2xml.sablecc.node.AComp1UsagePhrase;
import net.sf.cb2xml.sablecc.node.TComp1;
import net.sf.cb2xml.sablecc.node.ACompUsagePhrase;
import net.sf.cb2xml.sablecc.node.TComp;
import net.sf.cb2xml.sablecc.node.TNative;
import net.sf.cb2xml.sablecc.node.ABinaryUsagePhrase;
import net.sf.cb2xml.sablecc.node.TBinary;
import net.sf.cb2xml.sablecc.node.AUsageIs;
import net.sf.cb2xml.sablecc.node.TUsage;
import net.sf.cb2xml.sablecc.node.PUsageIs;
import net.sf.cb2xml.sablecc.node.AUsageClause;
import net.sf.cb2xml.sablecc.node.PUsagePhrase;
import net.sf.cb2xml.sablecc.node.ARightLeftOrRight;
import net.sf.cb2xml.sablecc.node.ALeftLeftOrRight;
import net.sf.cb2xml.sablecc.node.TLeft;
import net.sf.cb2xml.sablecc.node.PLeftOrRight;
import net.sf.cb2xml.sablecc.node.ASynchronizedClause;
import net.sf.cb2xml.sablecc.node.TSynchronized;
import net.sf.cb2xml.sablecc.node.TCharacter;
import net.sf.cb2xml.sablecc.node.ASeparateCharacter;
import net.sf.cb2xml.sablecc.node.TSeparate;
import net.sf.cb2xml.sablecc.node.ATrailingLeadingOrTrailing;
import net.sf.cb2xml.sablecc.node.TTrailing;
import net.sf.cb2xml.sablecc.node.ALeadingLeadingOrTrailing;
import net.sf.cb2xml.sablecc.node.TLeading;
import net.sf.cb2xml.sablecc.node.ASignIs;
import net.sf.cb2xml.sablecc.node.TSign;
import net.sf.cb2xml.sablecc.node.PSeparateCharacter;
import net.sf.cb2xml.sablecc.node.PSignIs;
import net.sf.cb2xml.sablecc.node.ASignClause;
import net.sf.cb2xml.sablecc.node.PLeadingOrTrailing;
import net.sf.cb2xml.sablecc.node.APictureClause;
import net.sf.cb2xml.sablecc.node.PCharacterString;
import net.sf.cb2xml.sablecc.node.TPicture;
import net.sf.cb2xml.sablecc.node.TBy;
import net.sf.cb2xml.sablecc.node.AIndexedByPhrase;
import net.sf.cb2xml.sablecc.node.TIndexed;
import net.sf.cb2xml.sablecc.node.ADescendingAscendingOrDescending;
import net.sf.cb2xml.sablecc.node.TDescending;
import net.sf.cb2xml.sablecc.node.AAscendingAscendingOrDescending;
import net.sf.cb2xml.sablecc.node.TAscending;
import net.sf.cb2xml.sablecc.node.TKey;
import net.sf.cb2xml.sablecc.node.AAscendingOrDescendingKeyPhrase;
import net.sf.cb2xml.sablecc.node.PAscendingOrDescending;
import net.sf.cb2xml.sablecc.node.AOccursTo;
import net.sf.cb2xml.sablecc.node.TTo;
import net.sf.cb2xml.sablecc.node.TOn;
import net.sf.cb2xml.sablecc.node.POccursTo;
import net.sf.cb2xml.sablecc.node.AVariableOccursFixedOrVariable;
import net.sf.cb2xml.sablecc.node.TDepending;
import net.sf.cb2xml.sablecc.node.TTimes;
import net.sf.cb2xml.sablecc.node.AFixedOccursFixedOrVariable;
import net.sf.cb2xml.sablecc.node.PNumber;
import net.sf.cb2xml.sablecc.node.TOccurs;
import java.util.Collection;
import net.sf.cb2xml.sablecc.node.AOccursClause;
import net.sf.cb2xml.sablecc.node.POccursFixedOrVariable;
import net.sf.cb2xml.sablecc.node.TRight;
import net.sf.cb2xml.sablecc.node.AJustifiedClause;
import net.sf.cb2xml.sablecc.node.TJustified;
import net.sf.cb2xml.sablecc.node.AGlobalClause;
import net.sf.cb2xml.sablecc.node.TGlobal;
import net.sf.cb2xml.sablecc.node.AExternalClause;
import net.sf.cb2xml.sablecc.node.TExternal;
import net.sf.cb2xml.sablecc.node.TIs;
import net.sf.cb2xml.sablecc.node.ADateFormatClause;
import net.sf.cb2xml.sablecc.node.TFormat;
import net.sf.cb2xml.sablecc.node.TDate;
import net.sf.cb2xml.sablecc.node.TWhen;
import net.sf.cb2xml.sablecc.node.ABlankWhenZeroClause;
import net.sf.cb2xml.sablecc.node.TZeros;
import net.sf.cb2xml.sablecc.node.TBlank;
import net.sf.cb2xml.sablecc.node.AValueClauseClause;
import net.sf.cb2xml.sablecc.node.PValueClause;
import net.sf.cb2xml.sablecc.node.AUsageClauseClause;
import net.sf.cb2xml.sablecc.node.PUsageClause;
import net.sf.cb2xml.sablecc.node.ASynchronizedClauseClause;
import net.sf.cb2xml.sablecc.node.PSynchronizedClause;
import net.sf.cb2xml.sablecc.node.ASignClauseClause;
import net.sf.cb2xml.sablecc.node.PSignClause;
import net.sf.cb2xml.sablecc.node.APictureClauseClause;
import net.sf.cb2xml.sablecc.node.PPictureClause;
import net.sf.cb2xml.sablecc.node.AOccursClauseClause;
import net.sf.cb2xml.sablecc.node.POccursClause;
import net.sf.cb2xml.sablecc.node.AJustifiedClauseClause;
import net.sf.cb2xml.sablecc.node.PJustifiedClause;
import net.sf.cb2xml.sablecc.node.AGlobalClauseClause;
import net.sf.cb2xml.sablecc.node.PGlobalClause;
import net.sf.cb2xml.sablecc.node.AExternalClauseClause;
import net.sf.cb2xml.sablecc.node.PExternalClause;
import net.sf.cb2xml.sablecc.node.ADateFormatClauseClause;
import net.sf.cb2xml.sablecc.node.PDateFormatClause;
import net.sf.cb2xml.sablecc.node.ABlankWhenZeroClauseClause;
import net.sf.cb2xml.sablecc.node.PBlankWhenZeroClause;
import net.sf.cb2xml.sablecc.node.ASequenceClauseSequence;
import net.sf.cb2xml.sablecc.node.ASingleClauseSequence;
import net.sf.cb2xml.sablecc.node.PClause;
import net.sf.cb2xml.sablecc.node.ARedefinesClause;
import net.sf.cb2xml.sablecc.node.TRedefines;
import net.sf.cb2xml.sablecc.node.AFillerDataNameOrFiller;
import net.sf.cb2xml.sablecc.node.TFiller;
import net.sf.cb2xml.sablecc.node.ADataNameDataNameOrFiller;
import net.sf.cb2xml.sablecc.node.TDataName;
import net.sf.cb2xml.sablecc.node.PClauseSequence;
import net.sf.cb2xml.sablecc.node.PRedefinesClause;
import net.sf.cb2xml.sablecc.node.PDataNameOrFiller;
import net.sf.cb2xml.sablecc.node.AItem;
import net.sf.cb2xml.sablecc.node.TNumberNot88;
import net.sf.cb2xml.sablecc.node.AValueItemElementaryItem;
import net.sf.cb2xml.sablecc.node.PValueItem;
import net.sf.cb2xml.sablecc.node.ARenamesItemElementaryItem;
import net.sf.cb2xml.sablecc.node.PRenamesItem;
import net.sf.cb2xml.sablecc.node.AItemElementaryItem;
import net.sf.cb2xml.sablecc.node.PItem;
import net.sf.cb2xml.sablecc.node.ASequenceGroupItem;
import net.sf.cb2xml.sablecc.node.ASingleGroupItem;
import net.sf.cb2xml.sablecc.node.PElementaryItem;
import net.sf.cb2xml.sablecc.node.ARecordDescription;
import net.sf.cb2xml.sablecc.node.TDot;
import net.sf.cb2xml.sablecc.node.PGroupItem;
import java.util.List;
import net.sf.cb2xml.sablecc.node.EOF;
import net.sf.cb2xml.sablecc.node.PRecordDescription;
import net.sf.cb2xml.sablecc.node.Node;
import net.sf.cb2xml.sablecc.node.Start;
import net.sf.cb2xml.sablecc.node.Switch;
import net.sf.cb2xml.sablecc.node.Switchable;
import java.io.IOException;
import net.sf.cb2xml.sablecc.lexer.LexerException;
import java.util.LinkedList;
import net.sf.cb2xml.sablecc.analysis.AnalysisAdapter;
import net.sf.cb2xml.sablecc.node.Token;
import java.util.ListIterator;
import net.sf.cb2xml.sablecc.lexer.Lexer;
import java.util.ArrayList;
import net.sf.cb2xml.sablecc.analysis.Analysis;

public class Parser
{
    public final Analysis ignoredTokens;
    protected ArrayList<Object> nodeList;
    private final Lexer lexer;
    private final ListIterator<Object> stack;
    private int last_pos;
    private int last_line;
    private Token last_token;
    private final TokenIndex converter;
    private final int[] action;
    private static final int SHIFT = 0;
    private static final int REDUCE = 1;
    private static final int ACCEPT = 2;
    private static final int ERROR = 3;
    private static int[][][] actionTable;
    private static int[][][] gotoTable;
    private static String[] errorMessages;
    private static int[] errors;
    
    public Parser(final Lexer lexer) {
        this.ignoredTokens = new AnalysisAdapter();
        this.stack = new LinkedList<Object>().listIterator();
        this.converter = new TokenIndex();
        this.action = new int[2];
        this.lexer = lexer;
    }
    
    protected void filter() throws ParserException, LexerException, IOException {
    }
    
    private void push(final int state, final ArrayList<Object> nodeList, final boolean b) throws ParserException, LexerException, IOException {
        this.nodeList = nodeList;
        if (!b) {
            this.filter();
        }
        if (!this.stack.hasNext()) {
            this.stack.add(new State(state, this.nodeList));
            return;
        }
        final State state2 = this.stack.next();
        state2.state = state;
        state2.nodes = this.nodeList;
    }
    
    private int goTo(final int n) {
        final int state = this.state();
        int i = 1;
        int n2 = Parser.gotoTable[n].length - 1;
        int n3 = Parser.gotoTable[n][0][1];
        while (i <= n2) {
            final int n4 = i + n2 >>> 1;
            if (state < Parser.gotoTable[n][n4][0]) {
                n2 = n4 - 1;
            }
            else {
                if (state <= Parser.gotoTable[n][n4][0]) {
                    n3 = Parser.gotoTable[n][n4][1];
                    break;
                }
                i = n4 + 1;
            }
        }
        return n3;
    }
    
    private int state() {
        final State state = this.stack.previous();
        this.stack.next();
        return state.state;
    }
    
    private ArrayList<Object> pop() {
        return this.stack.previous().nodes;
    }
    
    private int index(final Switchable switchable) {
        this.converter.index = -1;
        switchable.apply(this.converter);
        return this.converter.index;
    }
    
    public Start parse(final int n) throws ParserException, LexerException, IOException {
        this.push(0, null, true);
        List<Token> list = null;
        while (true) {
            if (this.index(this.lexer.peek()) == -1) {
                if (list == null) {
                    list = new LinkedList<Token>();
                }
                list.add(this.lexer.next());
            }
            else {
                if (list != null) {
                    this.ignoredTokens.setIn(this.lexer.peek(), list);
                    list = null;
                }
                this.last_pos = this.lexer.peek().getPos();
                this.last_line = this.lexer.peek().getLine();
                this.last_token = this.lexer.peek();
                final int index = this.index(this.lexer.peek());
                this.action[0] = Parser.actionTable[this.state()][0][1];
                this.action[1] = Parser.actionTable[this.state()][0][2];
                int i = 1;
                int n2 = Parser.actionTable[this.state()].length - 1;
                while (i <= n2) {
                    final int n3 = (i + n2) / 2;
                    if (index < Parser.actionTable[this.state()][n3][0]) {
                        n2 = n3 - 1;
                    }
                    else {
                        if (index <= Parser.actionTable[this.state()][n3][0]) {
                            this.action[0] = Parser.actionTable[this.state()][n3][1];
                            this.action[1] = Parser.actionTable[this.state()][n3][2];
                            break;
                        }
                        i = n3 + 1;
                    }
                }
                switch (this.action[0]) {
                    case 0: {
                        final ArrayList<Object> list2 = new ArrayList<Object>();
                        list2.add(this.lexer.next());
                        this.push(this.action[1], list2, false);
                        continue;
                    }
                    case 1: {
                        final int n4 = this.action[1];
                        if (n4 >= 500) {
                            continue;
                        }
                        this.reduce_0(n4);
                        continue;
                    }
                    case 2: {
                        return new Start(this.pop().get(0), (EOF)this.lexer.next());
                    }
                    case 3: {
                        throw new ParserException(this.last_token, "[line=" + this.last_line + ", Column=" + (n + this.last_pos) + "] " + Parser.errorMessages[Parser.errors[this.action[1]]]);
                    }
                }
            }
        }
    }
    
    private void reduce_0(final int n) throws IOException, LexerException, ParserException {
        switch (n) {
            case 0: {
                this.push(this.goTo(0), this.new0(), false);
                break;
            }
            case 1: {
                this.push(this.goTo(1), this.new1(), false);
                break;
            }
            case 2: {
                this.push(this.goTo(1), this.new2(), false);
                break;
            }
            case 3: {
                this.push(this.goTo(2), this.new3(), false);
                break;
            }
            case 4: {
                this.push(this.goTo(2), this.new4(), false);
                break;
            }
            case 5: {
                this.push(this.goTo(2), this.new5(), false);
                break;
            }
            case 6: {
                this.push(this.goTo(3), this.new6(), false);
                break;
            }
            case 7: {
                this.push(this.goTo(3), this.new7(), false);
                break;
            }
            case 8: {
                this.push(this.goTo(3), this.new8(), false);
                break;
            }
            case 9: {
                this.push(this.goTo(3), this.new9(), false);
                break;
            }
            case 10: {
                this.push(this.goTo(3), this.new10(), false);
                break;
            }
            case 11: {
                this.push(this.goTo(3), this.new11(), false);
                break;
            }
            case 12: {
                this.push(this.goTo(3), this.new12(), false);
                break;
            }
            case 13: {
                this.push(this.goTo(3), this.new13(), false);
                break;
            }
            case 14: {
                this.push(this.goTo(4), this.new14(), false);
                break;
            }
            case 15: {
                this.push(this.goTo(4), this.new15(), false);
                break;
            }
            case 16: {
                this.push(this.goTo(5), this.new16(), false);
                break;
            }
            case 17: {
                this.push(this.goTo(6), this.new17(), false);
                break;
            }
            case 18: {
                this.push(this.goTo(6), this.new18(), false);
                break;
            }
            case 19: {
                this.push(this.goTo(7), this.new19(), false);
                break;
            }
            case 20: {
                this.push(this.goTo(7), this.new20(), false);
                break;
            }
            case 21: {
                this.push(this.goTo(7), this.new21(), false);
                break;
            }
            case 22: {
                this.push(this.goTo(7), this.new22(), false);
                break;
            }
            case 23: {
                this.push(this.goTo(7), this.new23(), false);
                break;
            }
            case 24: {
                this.push(this.goTo(7), this.new24(), false);
                break;
            }
            case 25: {
                this.push(this.goTo(7), this.new25(), false);
                break;
            }
            case 26: {
                this.push(this.goTo(7), this.new26(), false);
                break;
            }
            case 27: {
                this.push(this.goTo(7), this.new27(), false);
                break;
            }
            case 28: {
                this.push(this.goTo(7), this.new28(), false);
                break;
            }
            case 29: {
                this.push(this.goTo(7), this.new29(), false);
                break;
            }
            case 30: {
                this.push(this.goTo(8), this.new30(), false);
                break;
            }
            case 31: {
                this.push(this.goTo(8), this.new31(), false);
                break;
            }
            case 32: {
                this.push(this.goTo(9), this.new32(), false);
                break;
            }
            case 33: {
                this.push(this.goTo(9), this.new33(), false);
                break;
            }
            case 34: {
                this.push(this.goTo(10), this.new34(), false);
                break;
            }
            case 35: {
                this.push(this.goTo(11), this.new35(), false);
                break;
            }
            case 36: {
                this.push(this.goTo(12), this.new36(), false);
                break;
            }
            case 37: {
                this.push(this.goTo(12), this.new37(), false);
                break;
            }
            case 38: {
                this.push(this.goTo(13), this.new38(), false);
                break;
            }
            case 39: {
                this.push(this.goTo(13), this.new39(), false);
                break;
            }
            case 40: {
                this.push(this.goTo(13), this.new40(), false);
                break;
            }
            case 41: {
                this.push(this.goTo(13), this.new41(), false);
                break;
            }
            case 42: {
                this.push(this.goTo(14), this.new42(), false);
                break;
            }
            case 43: {
                this.push(this.goTo(14), this.new43(), false);
                break;
            }
            case 44: {
                this.push(this.goTo(14), this.new44(), false);
                break;
            }
            case 45: {
                this.push(this.goTo(14), this.new45(), false);
                break;
            }
            case 46: {
                this.push(this.goTo(14), this.new46(), false);
                break;
            }
            case 47: {
                this.push(this.goTo(14), this.new47(), false);
                break;
            }
            case 48: {
                this.push(this.goTo(14), this.new48(), false);
                break;
            }
            case 49: {
                this.push(this.goTo(14), this.new49(), false);
                break;
            }
            case 50: {
                this.push(this.goTo(14), this.new50(), false);
                break;
            }
            case 51: {
                this.push(this.goTo(14), this.new51(), false);
                break;
            }
            case 52: {
                this.push(this.goTo(15), this.new52(), false);
                break;
            }
            case 53: {
                this.push(this.goTo(16), this.new53(), false);
                break;
            }
            case 54: {
                this.push(this.goTo(16), this.new54(), false);
                break;
            }
            case 55: {
                this.push(this.goTo(16), this.new55(), false);
                break;
            }
            case 56: {
                this.push(this.goTo(16), this.new56(), false);
                break;
            }
            case 57: {
                this.push(this.goTo(17), this.new57(), false);
                break;
            }
            case 58: {
                this.push(this.goTo(17), this.new58(), false);
                break;
            }
            case 59: {
                this.push(this.goTo(18), this.new59(), false);
                break;
            }
            case 60: {
                this.push(this.goTo(18), this.new60(), false);
                break;
            }
            case 61: {
                this.push(this.goTo(19), this.new61(), false);
                break;
            }
            case 62: {
                this.push(this.goTo(19), this.new62(), false);
                break;
            }
            case 63: {
                this.push(this.goTo(20), this.new63(), false);
                break;
            }
            case 64: {
                this.push(this.goTo(20), this.new64(), false);
                break;
            }
            case 65: {
                this.push(this.goTo(20), this.new65(), false);
                break;
            }
            case 66: {
                this.push(this.goTo(20), this.new66(), false);
                break;
            }
            case 67: {
                this.push(this.goTo(21), this.new67(), false);
                break;
            }
            case 68: {
                this.push(this.goTo(21), this.new68(), false);
                break;
            }
            case 69: {
                this.push(this.goTo(22), this.new69(), false);
                break;
            }
            case 70: {
                this.push(this.goTo(22), this.new70(), false);
                break;
            }
            case 71: {
                this.push(this.goTo(23), this.new71(), false);
                break;
            }
            case 72: {
                this.push(this.goTo(23), this.new72(), false);
                break;
            }
            case 73: {
                this.push(this.goTo(24), this.new73(), false);
                break;
            }
            case 74: {
                this.push(this.goTo(24), this.new74(), false);
                break;
            }
            case 75: {
                this.push(this.goTo(25), this.new75(), false);
                break;
            }
            case 76: {
                this.push(this.goTo(25), this.new76(), false);
                break;
            }
            case 77: {
                this.push(this.goTo(26), this.new77(), false);
                break;
            }
            case 78: {
                this.push(this.goTo(26), this.new78(), false);
                break;
            }
            case 79: {
                this.push(this.goTo(27), this.new79(), false);
                break;
            }
            case 80: {
                this.push(this.goTo(27), this.new80(), false);
                break;
            }
            case 81: {
                this.push(this.goTo(28), this.new81(), false);
                break;
            }
            case 82: {
                this.push(this.goTo(28), this.new82(), false);
                break;
            }
            case 83: {
                this.push(this.goTo(28), this.new83(), false);
                break;
            }
            case 84: {
                this.push(this.goTo(28), this.new84(), false);
                break;
            }
            case 85: {
                this.push(this.goTo(28), this.new85(), false);
                break;
            }
            case 86: {
                this.push(this.goTo(28), this.new86(), false);
                break;
            }
            case 87: {
                this.push(this.goTo(28), this.new87(), false);
                break;
            }
            case 88: {
                this.push(this.goTo(28), this.new88(), false);
                break;
            }
            case 89: {
                this.push(this.goTo(28), this.new89(), false);
                break;
            }
            case 90: {
                this.push(this.goTo(28), this.new90(), false);
                break;
            }
            case 91: {
                this.push(this.goTo(28), this.new91(), false);
                break;
            }
            case 92: {
                this.push(this.goTo(28), this.new92(), false);
                break;
            }
            case 93: {
                this.push(this.goTo(28), this.new93(), false);
                break;
            }
            case 94: {
                this.push(this.goTo(28), this.new94(), false);
                break;
            }
            case 95: {
                this.push(this.goTo(28), this.new95(), false);
                break;
            }
            case 96: {
                this.push(this.goTo(28), this.new96(), false);
                break;
            }
            case 97: {
                this.push(this.goTo(28), this.new97(), false);
                break;
            }
            case 98: {
                this.push(this.goTo(28), this.new98(), false);
                break;
            }
            case 99: {
                this.push(this.goTo(28), this.new99(), false);
                break;
            }
            case 100: {
                this.push(this.goTo(28), this.new100(), false);
                break;
            }
            case 101: {
                this.push(this.goTo(28), this.new101(), false);
                break;
            }
            case 102: {
                this.push(this.goTo(28), this.new102(), false);
                break;
            }
            case 103: {
                this.push(this.goTo(28), this.new103(), false);
                break;
            }
            case 104: {
                this.push(this.goTo(29), this.new104(), false);
                break;
            }
            case 105: {
                this.push(this.goTo(29), this.new105(), false);
                break;
            }
            case 106: {
                this.push(this.goTo(30), this.new106(), false);
                break;
            }
            case 107: {
                this.push(this.goTo(30), this.new107(), false);
                break;
            }
            case 108: {
                this.push(this.goTo(31), this.new108(), false);
                break;
            }
            case 109: {
                this.push(this.goTo(32), this.new109(), false);
                break;
            }
            case 110: {
                this.push(this.goTo(32), this.new110(), false);
                break;
            }
            case 111: {
                this.push(this.goTo(32), this.new111(), false);
                break;
            }
            case 112: {
                this.push(this.goTo(32), this.new112(), false);
                break;
            }
            case 113: {
                this.push(this.goTo(33), this.new113(), false);
                break;
            }
            case 114: {
                this.push(this.goTo(34), this.new114(), false);
                break;
            }
            case 115: {
                this.push(this.goTo(34), this.new115(), false);
                break;
            }
            case 116: {
                this.push(this.goTo(34), this.new116(), false);
                break;
            }
            case 117: {
                this.push(this.goTo(34), this.new117(), false);
                break;
            }
            case 118: {
                this.push(this.goTo(35), this.new118(), false);
                break;
            }
            case 119: {
                this.push(this.goTo(35), this.new119(), false);
                break;
            }
            case 120: {
                this.push(this.goTo(35), this.new120(), false);
                break;
            }
            case 121: {
                this.push(this.goTo(35), this.new121(), false);
                break;
            }
            case 122: {
                this.push(this.goTo(35), this.new122(), false);
                break;
            }
            case 123: {
                this.push(this.goTo(35), this.new123(), false);
                break;
            }
            case 124: {
                this.push(this.goTo(35), this.new124(), false);
                break;
            }
            case 125: {
                this.push(this.goTo(36), this.new125(), false);
                break;
            }
            case 126: {
                this.push(this.goTo(36), this.new126(), false);
                break;
            }
            case 127: {
                this.push(this.goTo(36), this.new127(), false);
                break;
            }
            case 128: {
                this.push(this.goTo(36), this.new128(), false);
                break;
            }
            case 129: {
                this.push(this.goTo(36), this.new129(), false);
                break;
            }
            case 130: {
                this.push(this.goTo(36), this.new130(), false);
                break;
            }
            case 131: {
                this.push(this.goTo(36), this.new131(), false);
                break;
            }
            case 132: {
                this.push(this.goTo(36), this.new132(), false);
                break;
            }
            case 133: {
                this.push(this.goTo(36), this.new133(), false);
                break;
            }
            case 134: {
                this.push(this.goTo(37), this.new134(), false);
                break;
            }
            case 135: {
                this.push(this.goTo(37), this.new135(), false);
                break;
            }
            case 136: {
                this.push(this.goTo(38), this.new136(), false);
                break;
            }
            case 137: {
                this.push(this.goTo(38), this.new137(), false);
                break;
            }
            case 138: {
                this.push(this.goTo(38), this.new138(), false);
                break;
            }
            case 139: {
                this.push(this.goTo(38), this.new139(), false);
                break;
            }
            case 140: {
                this.push(this.goTo(38), this.new140(), false);
                break;
            }
            case 141: {
                this.push(this.goTo(38), this.new141(), false);
                break;
            }
            case 142: {
                this.push(this.goTo(38), this.new142(), false);
                break;
            }
            case 143: {
                this.push(this.goTo(38), this.new143(), false);
                break;
            }
            case 144: {
                this.push(this.goTo(38), this.new144(), false);
                break;
            }
            case 145: {
                this.push(this.goTo(38), this.new145(), false);
                break;
            }
            case 146: {
                this.push(this.goTo(38), this.new146(), false);
                break;
            }
            case 147: {
                this.push(this.goTo(38), this.new147(), false);
                break;
            }
            case 148: {
                this.push(this.goTo(38), this.new148(), false);
                break;
            }
            case 149: {
                this.push(this.goTo(39), this.new149(), false);
                break;
            }
            case 150: {
                this.push(this.goTo(40), this.new150(), false);
                break;
            }
            case 151: {
                this.push(this.goTo(40), this.new151(), false);
                break;
            }
            case 152: {
                this.push(this.goTo(41), this.new152(), true);
                break;
            }
            case 153: {
                this.push(this.goTo(41), this.new153(), true);
                break;
            }
            case 154: {
                this.push(this.goTo(42), this.new154(), true);
                break;
            }
            case 155: {
                this.push(this.goTo(42), this.new155(), true);
                break;
            }
            case 156: {
                this.push(this.goTo(43), this.new156(), true);
                break;
            }
            case 157: {
                this.push(this.goTo(43), this.new157(), true);
                break;
            }
        }
    }
    
    ArrayList<Object> new0() {
        final ArrayList<ARecordDescription> list = (ArrayList<ARecordDescription>)new ArrayList<Object>();
        list.add(new ARecordDescription(this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new1() {
        final ArrayList<ASingleGroupItem> list = (ArrayList<ASingleGroupItem>)new ArrayList<Object>();
        list.add(new ASingleGroupItem(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new2() {
        final ArrayList<ASequenceGroupItem> list = (ArrayList<ASequenceGroupItem>)new ArrayList<Object>();
        list.add(new ASequenceGroupItem(this.pop().get(0), this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new3() {
        final ArrayList<AItemElementaryItem> list = (ArrayList<AItemElementaryItem>)new ArrayList<Object>();
        list.add(new AItemElementaryItem(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new4() {
        final ArrayList<ARenamesItemElementaryItem> list = (ArrayList<ARenamesItemElementaryItem>)new ArrayList<Object>();
        list.add(new ARenamesItemElementaryItem(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new5() {
        final ArrayList<AValueItemElementaryItem> list = (ArrayList<AValueItemElementaryItem>)new ArrayList<Object>();
        list.add(new AValueItemElementaryItem(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new6() {
        final ArrayList<AItem> list = (ArrayList<AItem>)new ArrayList<Object>();
        list.add(new AItem(this.pop().get(0), null, null, null));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new7() {
        final ArrayList<AItem> list = (ArrayList<AItem>)new ArrayList<Object>();
        list.add(new AItem(this.pop().get(0), this.pop().get(0), null, null));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new8() {
        final ArrayList<AItem> list = (ArrayList<AItem>)new ArrayList<Object>();
        list.add(new AItem(this.pop().get(0), null, this.pop().get(0), null));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new9() {
        final ArrayList<AItem> list = (ArrayList<AItem>)new ArrayList<Object>();
        list.add(new AItem(this.pop().get(0), this.pop().get(0), this.pop().get(0), null));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new10() {
        final ArrayList<AItem> list = (ArrayList<AItem>)new ArrayList<Object>();
        list.add(new AItem(this.pop().get(0), null, null, this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new11() {
        final ArrayList<AItem> list = (ArrayList<AItem>)new ArrayList<Object>();
        list.add(new AItem(this.pop().get(0), this.pop().get(0), null, this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new12() {
        final ArrayList<AItem> list = (ArrayList<AItem>)new ArrayList<Object>();
        list.add(new AItem(this.pop().get(0), null, this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new13() {
        final ArrayList<AItem> list = (ArrayList<AItem>)new ArrayList<Object>();
        list.add(new AItem(this.pop().get(0), this.pop().get(0), this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new14() {
        final ArrayList<ADataNameDataNameOrFiller> list = (ArrayList<ADataNameDataNameOrFiller>)new ArrayList<Object>();
        list.add(new ADataNameDataNameOrFiller(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new15() {
        final ArrayList<AFillerDataNameOrFiller> list = (ArrayList<AFillerDataNameOrFiller>)new ArrayList<Object>();
        list.add(new AFillerDataNameOrFiller(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new16() {
        final ArrayList<ARedefinesClause> list = (ArrayList<ARedefinesClause>)new ArrayList<Object>();
        list.add(new ARedefinesClause(this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new17() {
        final ArrayList<ASingleClauseSequence> list = (ArrayList<ASingleClauseSequence>)new ArrayList<Object>();
        list.add(new ASingleClauseSequence(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new18() {
        final ArrayList<ASequenceClauseSequence> list = (ArrayList<ASequenceClauseSequence>)new ArrayList<Object>();
        list.add(new ASequenceClauseSequence(this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new19() {
        final ArrayList<ABlankWhenZeroClauseClause> list = (ArrayList<ABlankWhenZeroClauseClause>)new ArrayList<Object>();
        list.add(new ABlankWhenZeroClauseClause(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new20() {
        final ArrayList<ADateFormatClauseClause> list = (ArrayList<ADateFormatClauseClause>)new ArrayList<Object>();
        list.add(new ADateFormatClauseClause(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new21() {
        final ArrayList<AExternalClauseClause> list = (ArrayList<AExternalClauseClause>)new ArrayList<Object>();
        list.add(new AExternalClauseClause(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new22() {
        final ArrayList<AGlobalClauseClause> list = (ArrayList<AGlobalClauseClause>)new ArrayList<Object>();
        list.add(new AGlobalClauseClause(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new23() {
        final ArrayList<AJustifiedClauseClause> list = (ArrayList<AJustifiedClauseClause>)new ArrayList<Object>();
        list.add(new AJustifiedClauseClause(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new24() {
        final ArrayList<AOccursClauseClause> list = (ArrayList<AOccursClauseClause>)new ArrayList<Object>();
        list.add(new AOccursClauseClause(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new25() {
        final ArrayList<APictureClauseClause> list = (ArrayList<APictureClauseClause>)new ArrayList<Object>();
        list.add(new APictureClauseClause(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new26() {
        final ArrayList<ASignClauseClause> list = (ArrayList<ASignClauseClause>)new ArrayList<Object>();
        list.add(new ASignClauseClause(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new27() {
        final ArrayList<ASynchronizedClauseClause> list = (ArrayList<ASynchronizedClauseClause>)new ArrayList<Object>();
        list.add(new ASynchronizedClauseClause(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new28() {
        final ArrayList<AUsageClauseClause> list = (ArrayList<AUsageClauseClause>)new ArrayList<Object>();
        list.add(new AUsageClauseClause(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new29() {
        final ArrayList<AValueClauseClause> list = (ArrayList<AValueClauseClause>)new ArrayList<Object>();
        list.add(new AValueClauseClause(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new30() {
        final ArrayList<ABlankWhenZeroClause> list = (ArrayList<ABlankWhenZeroClause>)new ArrayList<Object>();
        list.add(new ABlankWhenZeroClause(this.pop().get(0), null, this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new31() {
        final ArrayList<ABlankWhenZeroClause> list = (ArrayList<ABlankWhenZeroClause>)new ArrayList<Object>();
        list.add(new ABlankWhenZeroClause(this.pop().get(0), this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new32() {
        final ArrayList<ADateFormatClause> list = (ArrayList<ADateFormatClause>)new ArrayList<Object>();
        list.add(new ADateFormatClause(this.pop().get(0), this.pop().get(0), null, this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new33() {
        final ArrayList<ADateFormatClause> list = (ArrayList<ADateFormatClause>)new ArrayList<Object>();
        list.add(new ADateFormatClause(this.pop().get(0), this.pop().get(0), this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new34() {
        final ArrayList<AExternalClause> list = (ArrayList<AExternalClause>)new ArrayList<Object>();
        list.add(new AExternalClause(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new35() {
        final ArrayList<AGlobalClause> list = (ArrayList<AGlobalClause>)new ArrayList<Object>();
        list.add(new AGlobalClause(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new36() {
        final ArrayList<AJustifiedClause> list = (ArrayList<AJustifiedClause>)new ArrayList<Object>();
        list.add(new AJustifiedClause(this.pop().get(0), null));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new37() {
        final ArrayList<AJustifiedClause> list = (ArrayList<AJustifiedClause>)new ArrayList<Object>();
        list.add(new AJustifiedClause(this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new38() {
        final ArrayList<AOccursClause> list = (ArrayList<AOccursClause>)new ArrayList<Object>();
        list.add(new AOccursClause(this.pop().get(0), new LinkedList<Object>(), new LinkedList<Object>()));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new39() {
        final ArrayList<AOccursClause> list = (ArrayList<AOccursClause>)new ArrayList<Object>();
        final ArrayList<Object> pop = this.pop();
        final ArrayList<Object> pop2 = this.pop();
        final LinkedList<Object> list2 = new LinkedList<Object>();
        final LinkedList<Object> list3 = new LinkedList<Object>();
        final POccursFixedOrVariable pOccursFixedOrVariable = pop2.get(0);
        final LinkedList list4 = new LinkedList();
        final LinkedList<?> c = pop.get(0);
        if (c != null) {
            list2.addAll(c);
        }
        list.add(new AOccursClause(pOccursFixedOrVariable, list2, list3));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new40() {
        final ArrayList<AOccursClause> list = (ArrayList<AOccursClause>)new ArrayList<Object>();
        final ArrayList<Object> pop = this.pop();
        final ArrayList<Object> pop2 = this.pop();
        final LinkedList<Object> list2 = new LinkedList<Object>();
        final LinkedList<Object> list3 = new LinkedList<Object>();
        final POccursFixedOrVariable pOccursFixedOrVariable = pop2.get(0);
        final LinkedList list4 = new LinkedList();
        final LinkedList<?> c = pop.get(0);
        if (c != null) {
            list3.addAll(c);
        }
        list.add(new AOccursClause(pOccursFixedOrVariable, list2, list3));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new41() {
        final ArrayList<AOccursClause> list = (ArrayList<AOccursClause>)new ArrayList<Object>();
        final ArrayList<Object> pop = this.pop();
        final ArrayList<Object> pop2 = this.pop();
        final ArrayList<Object> pop3 = this.pop();
        final LinkedList<Object> list2 = new LinkedList<Object>();
        final LinkedList<Object> list3 = new LinkedList<Object>();
        final POccursFixedOrVariable pOccursFixedOrVariable = pop3.get(0);
        final LinkedList list4 = new LinkedList();
        final LinkedList<?> c = pop2.get(0);
        if (c != null) {
            list2.addAll(c);
        }
        final LinkedList list5 = new LinkedList();
        final LinkedList<?> c2 = pop.get(0);
        if (c2 != null) {
            list3.addAll(c2);
        }
        list.add(new AOccursClause(pOccursFixedOrVariable, list2, list3));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new42() {
        final ArrayList<AFixedOccursFixedOrVariable> list = (ArrayList<AFixedOccursFixedOrVariable>)new ArrayList<Object>();
        list.add(new AFixedOccursFixedOrVariable(this.pop().get(0), this.pop().get(0), null));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new43() {
        final ArrayList<AFixedOccursFixedOrVariable> list = (ArrayList<AFixedOccursFixedOrVariable>)new ArrayList<Object>();
        list.add(new AFixedOccursFixedOrVariable(this.pop().get(0), this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new44() {
        final ArrayList<AVariableOccursFixedOrVariable> list = (ArrayList<AVariableOccursFixedOrVariable>)new ArrayList<Object>();
        list.add(new AVariableOccursFixedOrVariable(this.pop().get(0), null, this.pop().get(0), null, this.pop().get(0), null, this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new45() {
        final ArrayList<AVariableOccursFixedOrVariable> list = (ArrayList<AVariableOccursFixedOrVariable>)new ArrayList<Object>();
        list.add(new AVariableOccursFixedOrVariable(this.pop().get(0), this.pop().get(0), this.pop().get(0), null, this.pop().get(0), null, this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new46() {
        final ArrayList<AVariableOccursFixedOrVariable> list = (ArrayList<AVariableOccursFixedOrVariable>)new ArrayList<Object>();
        list.add(new AVariableOccursFixedOrVariable(this.pop().get(0), null, this.pop().get(0), this.pop().get(0), this.pop().get(0), null, this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new47() {
        final ArrayList<AVariableOccursFixedOrVariable> list = (ArrayList<AVariableOccursFixedOrVariable>)new ArrayList<Object>();
        list.add(new AVariableOccursFixedOrVariable(this.pop().get(0), this.pop().get(0), this.pop().get(0), this.pop().get(0), this.pop().get(0), null, this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new48() {
        final ArrayList<AVariableOccursFixedOrVariable> list = (ArrayList<AVariableOccursFixedOrVariable>)new ArrayList<Object>();
        list.add(new AVariableOccursFixedOrVariable(this.pop().get(0), null, this.pop().get(0), null, this.pop().get(0), this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new49() {
        final ArrayList<AVariableOccursFixedOrVariable> list = (ArrayList<AVariableOccursFixedOrVariable>)new ArrayList<Object>();
        list.add(new AVariableOccursFixedOrVariable(this.pop().get(0), this.pop().get(0), this.pop().get(0), null, this.pop().get(0), this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new50() {
        final ArrayList<AVariableOccursFixedOrVariable> list = (ArrayList<AVariableOccursFixedOrVariable>)new ArrayList<Object>();
        list.add(new AVariableOccursFixedOrVariable(this.pop().get(0), null, this.pop().get(0), this.pop().get(0), this.pop().get(0), this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new51() {
        final ArrayList<AVariableOccursFixedOrVariable> list = (ArrayList<AVariableOccursFixedOrVariable>)new ArrayList<Object>();
        list.add(new AVariableOccursFixedOrVariable(this.pop().get(0), this.pop().get(0), this.pop().get(0), this.pop().get(0), this.pop().get(0), this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new52() {
        final ArrayList<AOccursTo> list = (ArrayList<AOccursTo>)new ArrayList<Object>();
        list.add(new AOccursTo(this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new53() {
        final ArrayList<AAscendingOrDescendingKeyPhrase> list = (ArrayList<AAscendingOrDescendingKeyPhrase>)new ArrayList<Object>();
        final ArrayList<Object> pop = this.pop();
        final ArrayList<Object> pop2 = this.pop();
        final LinkedList<Object> list2 = new LinkedList<Object>();
        final PAscendingOrDescending pAscendingOrDescending = pop2.get(0);
        final LinkedList list3 = new LinkedList();
        final LinkedList<?> c = pop.get(0);
        if (c != null) {
            list2.addAll(c);
        }
        list.add(new AAscendingOrDescendingKeyPhrase(pAscendingOrDescending, null, null, list2));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new54() {
        final ArrayList<AAscendingOrDescendingKeyPhrase> list = (ArrayList<AAscendingOrDescendingKeyPhrase>)new ArrayList<Object>();
        final ArrayList<Object> pop = this.pop();
        final ArrayList<Object> pop2 = this.pop();
        final ArrayList<Object> pop3 = this.pop();
        final LinkedList<Object> list2 = new LinkedList<Object>();
        final PAscendingOrDescending pAscendingOrDescending = pop3.get(0);
        final TKey tKey = pop2.get(0);
        final LinkedList list3 = new LinkedList();
        final LinkedList<?> c = pop.get(0);
        if (c != null) {
            list2.addAll(c);
        }
        list.add(new AAscendingOrDescendingKeyPhrase(pAscendingOrDescending, tKey, null, list2));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new55() {
        final ArrayList<AAscendingOrDescendingKeyPhrase> list = (ArrayList<AAscendingOrDescendingKeyPhrase>)new ArrayList<Object>();
        final ArrayList<Object> pop = this.pop();
        final ArrayList<Object> pop2 = this.pop();
        final ArrayList<Object> pop3 = this.pop();
        final LinkedList<Object> list2 = new LinkedList<Object>();
        final PAscendingOrDescending pAscendingOrDescending = pop3.get(0);
        final TIs tIs = pop2.get(0);
        final LinkedList list3 = new LinkedList();
        final LinkedList<?> c = pop.get(0);
        if (c != null) {
            list2.addAll(c);
        }
        list.add(new AAscendingOrDescendingKeyPhrase(pAscendingOrDescending, null, tIs, list2));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new56() {
        final ArrayList<AAscendingOrDescendingKeyPhrase> list = (ArrayList<AAscendingOrDescendingKeyPhrase>)new ArrayList<Object>();
        final ArrayList<Object> pop = this.pop();
        final ArrayList<Object> pop2 = this.pop();
        final ArrayList<Object> pop3 = this.pop();
        final ArrayList<Object> pop4 = this.pop();
        final LinkedList<Object> list2 = new LinkedList<Object>();
        final PAscendingOrDescending pAscendingOrDescending = pop4.get(0);
        final TKey tKey = pop3.get(0);
        final TIs tIs = pop2.get(0);
        final LinkedList list3 = new LinkedList();
        final LinkedList<?> c = pop.get(0);
        if (c != null) {
            list2.addAll(c);
        }
        list.add(new AAscendingOrDescendingKeyPhrase(pAscendingOrDescending, tKey, tIs, list2));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new57() {
        final ArrayList<AAscendingAscendingOrDescending> list = (ArrayList<AAscendingAscendingOrDescending>)new ArrayList<Object>();
        list.add(new AAscendingAscendingOrDescending(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new58() {
        final ArrayList<ADescendingAscendingOrDescending> list = (ArrayList<ADescendingAscendingOrDescending>)new ArrayList<Object>();
        list.add(new ADescendingAscendingOrDescending(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new59() {
        final ArrayList<AIndexedByPhrase> list = (ArrayList<AIndexedByPhrase>)new ArrayList<Object>();
        final ArrayList<Object> pop = this.pop();
        final ArrayList<Object> pop2 = this.pop();
        final LinkedList<Object> list2 = new LinkedList<Object>();
        final TIndexed tIndexed = pop2.get(0);
        final LinkedList list3 = new LinkedList();
        final LinkedList<?> c = pop.get(0);
        if (c != null) {
            list2.addAll(c);
        }
        list.add(new AIndexedByPhrase(tIndexed, null, list2));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new60() {
        final ArrayList<AIndexedByPhrase> list = (ArrayList<AIndexedByPhrase>)new ArrayList<Object>();
        final ArrayList<Object> pop = this.pop();
        final ArrayList<Object> pop2 = this.pop();
        final ArrayList<Object> pop3 = this.pop();
        final LinkedList<Object> list2 = new LinkedList<Object>();
        final TIndexed tIndexed = pop3.get(0);
        final TBy tBy = pop2.get(0);
        final LinkedList list3 = new LinkedList();
        final LinkedList<?> c = pop.get(0);
        if (c != null) {
            list2.addAll(c);
        }
        list.add(new AIndexedByPhrase(tIndexed, tBy, list2));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new61() {
        final ArrayList<APictureClause> list = (ArrayList<APictureClause>)new ArrayList<Object>();
        list.add(new APictureClause(this.pop().get(0), null, this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new62() {
        final ArrayList<APictureClause> list = (ArrayList<APictureClause>)new ArrayList<Object>();
        list.add(new APictureClause(this.pop().get(0), this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new63() {
        final ArrayList<ASignClause> list = (ArrayList<ASignClause>)new ArrayList<Object>();
        list.add(new ASignClause(null, this.pop().get(0), null));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new64() {
        final ArrayList<ASignClause> list = (ArrayList<ASignClause>)new ArrayList<Object>();
        list.add(new ASignClause(this.pop().get(0), this.pop().get(0), null));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new65() {
        final ArrayList<ASignClause> list = (ArrayList<ASignClause>)new ArrayList<Object>();
        list.add(new ASignClause(null, this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new66() {
        final ArrayList<ASignClause> list = (ArrayList<ASignClause>)new ArrayList<Object>();
        list.add(new ASignClause(this.pop().get(0), this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new67() {
        final ArrayList<ASignIs> list = (ArrayList<ASignIs>)new ArrayList<Object>();
        list.add(new ASignIs(this.pop().get(0), null));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new68() {
        final ArrayList<ASignIs> list = (ArrayList<ASignIs>)new ArrayList<Object>();
        list.add(new ASignIs(this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new69() {
        final ArrayList<ALeadingLeadingOrTrailing> list = (ArrayList<ALeadingLeadingOrTrailing>)new ArrayList<Object>();
        list.add(new ALeadingLeadingOrTrailing(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new70() {
        final ArrayList<ATrailingLeadingOrTrailing> list = (ArrayList<ATrailingLeadingOrTrailing>)new ArrayList<Object>();
        list.add(new ATrailingLeadingOrTrailing(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new71() {
        final ArrayList<ASeparateCharacter> list = (ArrayList<ASeparateCharacter>)new ArrayList<Object>();
        list.add(new ASeparateCharacter(this.pop().get(0), null));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new72() {
        final ArrayList<ASeparateCharacter> list = (ArrayList<ASeparateCharacter>)new ArrayList<Object>();
        list.add(new ASeparateCharacter(this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new73() {
        final ArrayList<ASynchronizedClause> list = (ArrayList<ASynchronizedClause>)new ArrayList<Object>();
        list.add(new ASynchronizedClause(this.pop().get(0), null));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new74() {
        final ArrayList<ASynchronizedClause> list = (ArrayList<ASynchronizedClause>)new ArrayList<Object>();
        list.add(new ASynchronizedClause(this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new75() {
        final ArrayList<ALeftLeftOrRight> list = (ArrayList<ALeftLeftOrRight>)new ArrayList<Object>();
        list.add(new ALeftLeftOrRight(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new76() {
        final ArrayList<ARightLeftOrRight> list = (ArrayList<ARightLeftOrRight>)new ArrayList<Object>();
        list.add(new ARightLeftOrRight(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new77() {
        final ArrayList<AUsageClause> list = (ArrayList<AUsageClause>)new ArrayList<Object>();
        list.add(new AUsageClause(null, this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new78() {
        final ArrayList<AUsageClause> list = (ArrayList<AUsageClause>)new ArrayList<Object>();
        list.add(new AUsageClause(this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new79() {
        final ArrayList<AUsageIs> list = (ArrayList<AUsageIs>)new ArrayList<Object>();
        list.add(new AUsageIs(this.pop().get(0), null));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new80() {
        final ArrayList<AUsageIs> list = (ArrayList<AUsageIs>)new ArrayList<Object>();
        list.add(new AUsageIs(this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new81() {
        final ArrayList<ABinaryUsagePhrase> list = (ArrayList<ABinaryUsagePhrase>)new ArrayList<Object>();
        list.add(new ABinaryUsagePhrase(this.pop().get(0), null));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new82() {
        final ArrayList<ABinaryUsagePhrase> list = (ArrayList<ABinaryUsagePhrase>)new ArrayList<Object>();
        list.add(new ABinaryUsagePhrase(this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new83() {
        final ArrayList<ACompUsagePhrase> list = (ArrayList<ACompUsagePhrase>)new ArrayList<Object>();
        list.add(new ACompUsagePhrase(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new84() {
        final ArrayList<AComp1UsagePhrase> list = (ArrayList<AComp1UsagePhrase>)new ArrayList<Object>();
        list.add(new AComp1UsagePhrase(this.pop().get(0), null));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new85() {
        final ArrayList<AComp1UsagePhrase> list = (ArrayList<AComp1UsagePhrase>)new ArrayList<Object>();
        list.add(new AComp1UsagePhrase(this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new86() {
        final ArrayList<AComp2UsagePhrase> list = (ArrayList<AComp2UsagePhrase>)new ArrayList<Object>();
        list.add(new AComp2UsagePhrase(this.pop().get(0), null));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new87() {
        final ArrayList<AComp2UsagePhrase> list = (ArrayList<AComp2UsagePhrase>)new ArrayList<Object>();
        list.add(new AComp2UsagePhrase(this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new88() {
        final ArrayList<AComp3UsagePhrase> list = (ArrayList<AComp3UsagePhrase>)new ArrayList<Object>();
        list.add(new AComp3UsagePhrase(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new89() {
        final ArrayList<AComp4UsagePhrase> list = (ArrayList<AComp4UsagePhrase>)new ArrayList<Object>();
        list.add(new AComp4UsagePhrase(this.pop().get(0), null));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new90() {
        final ArrayList<AComp4UsagePhrase> list = (ArrayList<AComp4UsagePhrase>)new ArrayList<Object>();
        list.add(new AComp4UsagePhrase(this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new91() {
        final ArrayList<AComp5UsagePhrase> list = (ArrayList<AComp5UsagePhrase>)new ArrayList<Object>();
        list.add(new AComp5UsagePhrase(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new92() {
        final ArrayList<AComp6UsagePhrase> list = (ArrayList<AComp6UsagePhrase>)new ArrayList<Object>();
        list.add(new AComp6UsagePhrase(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new93() {
        final ArrayList<ADisplayUsagePhrase> list = (ArrayList<ADisplayUsagePhrase>)new ArrayList<Object>();
        list.add(new ADisplayUsagePhrase(this.pop().get(0), null));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new94() {
        final ArrayList<ADisplayUsagePhrase> list = (ArrayList<ADisplayUsagePhrase>)new ArrayList<Object>();
        list.add(new ADisplayUsagePhrase(this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new95() {
        final ArrayList<ADisplay1UsagePhrase> list = (ArrayList<ADisplay1UsagePhrase>)new ArrayList<Object>();
        list.add(new ADisplay1UsagePhrase(this.pop().get(0), null));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new96() {
        final ArrayList<ADisplay1UsagePhrase> list = (ArrayList<ADisplay1UsagePhrase>)new ArrayList<Object>();
        list.add(new ADisplay1UsagePhrase(this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new97() {
        final ArrayList<AIndexUsagePhrase> list = (ArrayList<AIndexUsagePhrase>)new ArrayList<Object>();
        list.add(new AIndexUsagePhrase(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new98() {
        final ArrayList<ANationalUsagePhrase> list = (ArrayList<ANationalUsagePhrase>)new ArrayList<Object>();
        list.add(new ANationalUsagePhrase(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new99() {
        final ArrayList<AObjectReferencePhraseUsagePhrase> list = (ArrayList<AObjectReferencePhraseUsagePhrase>)new ArrayList<Object>();
        list.add(new AObjectReferencePhraseUsagePhrase(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new100() {
        final ArrayList<APackedDecimalUsagePhrase> list = (ArrayList<APackedDecimalUsagePhrase>)new ArrayList<Object>();
        list.add(new APackedDecimalUsagePhrase(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new101() {
        final ArrayList<APointerUsagePhrase> list = (ArrayList<APointerUsagePhrase>)new ArrayList<Object>();
        list.add(new APointerUsagePhrase(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new102() {
        final ArrayList<AProcedurePointerUsagePhrase> list = (ArrayList<AProcedurePointerUsagePhrase>)new ArrayList<Object>();
        list.add(new AProcedurePointerUsagePhrase(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new103() {
        final ArrayList<AFunctionPointerUsagePhrase> list = (ArrayList<AFunctionPointerUsagePhrase>)new ArrayList<Object>();
        list.add(new AFunctionPointerUsagePhrase(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new104() {
        final ArrayList<AObjectReferencePhrase> list = (ArrayList<AObjectReferencePhrase>)new ArrayList<Object>();
        list.add(new AObjectReferencePhrase(this.pop().get(0), this.pop().get(0), null));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new105() {
        final ArrayList<AObjectReferencePhrase> list = (ArrayList<AObjectReferencePhrase>)new ArrayList<Object>();
        list.add(new AObjectReferencePhrase(this.pop().get(0), this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new106() {
        final ArrayList<ARenamesItem> list = (ArrayList<ARenamesItem>)new ArrayList<Object>();
        list.add(new ARenamesItem(this.pop().get(0), this.pop().get(0), this.pop().get(0), this.pop().get(0), null));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new107() {
        final ArrayList<ARenamesItem> list = (ArrayList<ARenamesItem>)new ArrayList<Object>();
        list.add(new ARenamesItem(this.pop().get(0), this.pop().get(0), this.pop().get(0), this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new108() {
        final ArrayList<AThroughPhrase> list = (ArrayList<AThroughPhrase>)new ArrayList<Object>();
        list.add(new AThroughPhrase(this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new109() {
        final ArrayList<AValueClause> list = (ArrayList<AValueClause>)new ArrayList<Object>();
        list.add(new AValueClause(this.pop().get(0), null, null, this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new110() {
        final ArrayList<AValueClause> list = (ArrayList<AValueClause>)new ArrayList<Object>();
        list.add(new AValueClause(this.pop().get(0), this.pop().get(0), null, this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new111() {
        final ArrayList<AValueClause> list = (ArrayList<AValueClause>)new ArrayList<Object>();
        list.add(new AValueClause(this.pop().get(0), null, this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new112() {
        final ArrayList<AValueClause> list = (ArrayList<AValueClause>)new ArrayList<Object>();
        list.add(new AValueClause(this.pop().get(0), this.pop().get(0), this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new113() {
        final ArrayList<AValueItem> list = (ArrayList<AValueItem>)new ArrayList<Object>();
        list.add(new AValueItem(this.pop().get(0), this.pop().get(0), this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new114() {
        final ArrayList<AValueValueOrValues> list = (ArrayList<AValueValueOrValues>)new ArrayList<Object>();
        list.add(new AValueValueOrValues(this.pop().get(0), null));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new115() {
        final ArrayList<AValueValueOrValues> list = (ArrayList<AValueValueOrValues>)new ArrayList<Object>();
        list.add(new AValueValueOrValues(this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new116() {
        final ArrayList<AValuesValueOrValues> list = (ArrayList<AValuesValueOrValues>)new ArrayList<Object>();
        list.add(new AValuesValueOrValues(this.pop().get(0), null));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new117() {
        final ArrayList<AValuesValueOrValues> list = (ArrayList<AValuesValueOrValues>)new ArrayList<Object>();
        list.add(new AValuesValueOrValues(this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new118() {
        final ArrayList<ASingleLiteralSequence> list = (ArrayList<ASingleLiteralSequence>)new ArrayList<Object>();
        list.add(new ASingleLiteralSequence(null, this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new119() {
        final ArrayList<ASingleLiteralSequence> list = (ArrayList<ASingleLiteralSequence>)new ArrayList<Object>();
        list.add(new ASingleLiteralSequence(this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new120() {
        final ArrayList<ASequenceLiteralSequence> list = (ArrayList<ASequenceLiteralSequence>)new ArrayList<Object>();
        list.add(new ASequenceLiteralSequence(this.pop().get(0), null, this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new121() {
        final ArrayList<ASequenceLiteralSequence> list = (ArrayList<ASequenceLiteralSequence>)new ArrayList<Object>();
        list.add(new ASequenceLiteralSequence(this.pop().get(0), this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new122() {
        final ArrayList<AThroughSingleLiteralSequence> list = (ArrayList<AThroughSingleLiteralSequence>)new ArrayList<Object>();
        list.add(new AThroughSingleLiteralSequence(this.pop().get(0), this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new123() {
        final ArrayList<AThroughSequenceLiteralSequence> list = (ArrayList<AThroughSequenceLiteralSequence>)new ArrayList<Object>();
        list.add(new AThroughSequenceLiteralSequence(this.pop().get(0), null, this.pop().get(0), this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new124() {
        final ArrayList<AThroughSequenceLiteralSequence> list = (ArrayList<AThroughSequenceLiteralSequence>)new ArrayList<Object>();
        list.add(new AThroughSequenceLiteralSequence(this.pop().get(0), this.pop().get(0), this.pop().get(0), this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new125() {
        final ArrayList<AZerosLiteral> list = (ArrayList<AZerosLiteral>)new ArrayList<Object>();
        list.add(new AZerosLiteral(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new126() {
        final ArrayList<ASpacesLiteral> list = (ArrayList<ASpacesLiteral>)new ArrayList<Object>();
        list.add(new ASpacesLiteral(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new127() {
        final ArrayList<AHighValuesLiteral> list = (ArrayList<AHighValuesLiteral>)new ArrayList<Object>();
        list.add(new AHighValuesLiteral(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new128() {
        final ArrayList<ALowValuesLiteral> list = (ArrayList<ALowValuesLiteral>)new ArrayList<Object>();
        list.add(new ALowValuesLiteral(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new129() {
        final ArrayList<AQuotesLiteral> list = (ArrayList<AQuotesLiteral>)new ArrayList<Object>();
        list.add(new AQuotesLiteral(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new130() {
        final ArrayList<ANullsLiteral> list = (ArrayList<ANullsLiteral>)new ArrayList<Object>();
        list.add(new ANullsLiteral(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new131() {
        final ArrayList<ANumberLiteral> list = (ArrayList<ANumberLiteral>)new ArrayList<Object>();
        list.add(new ANumberLiteral(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new132() {
        final ArrayList<ANumericLiteralLiteral> list = (ArrayList<ANumericLiteralLiteral>)new ArrayList<Object>();
        list.add(new ANumericLiteralLiteral(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new133() {
        final ArrayList<AAlphanumericLiteralLiteral> list = (ArrayList<AAlphanumericLiteralLiteral>)new ArrayList<Object>();
        list.add(new AAlphanumericLiteralLiteral(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new134() {
        final ArrayList<ASingleCharacterString> list = (ArrayList<ASingleCharacterString>)new ArrayList<Object>();
        list.add(new ASingleCharacterString(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new135() {
        final ArrayList<ASequenceCharacterString> list = (ArrayList<ASequenceCharacterString>)new ArrayList<Object>();
        list.add(new ASequenceCharacterString(this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new136() {
        final ArrayList<ADataNameCharacterSubstring> list = (ArrayList<ADataNameCharacterSubstring>)new ArrayList<Object>();
        list.add(new ADataNameCharacterSubstring(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new137() {
        final ArrayList<APlusCharacterSubstring> list = (ArrayList<APlusCharacterSubstring>)new ArrayList<Object>();
        list.add(new APlusCharacterSubstring(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new138() {
        final ArrayList<AMinusCharacterSubstring> list = (ArrayList<AMinusCharacterSubstring>)new ArrayList<Object>();
        list.add(new AMinusCharacterSubstring(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new139() {
        final ArrayList<AStarCharacterSubstring> list = (ArrayList<AStarCharacterSubstring>)new ArrayList<Object>();
        list.add(new AStarCharacterSubstring(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new140() {
        final ArrayList<ASlashCharacterSubstring> list = (ArrayList<ASlashCharacterSubstring>)new ArrayList<Object>();
        list.add(new ASlashCharacterSubstring(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new141() {
        final ArrayList<ADollarCharacterSubstring> list = (ArrayList<ADollarCharacterSubstring>)new ArrayList<Object>();
        list.add(new ADollarCharacterSubstring(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new142() {
        final ArrayList<ACommaCharacterSubstring> list = (ArrayList<ACommaCharacterSubstring>)new ArrayList<Object>();
        list.add(new ACommaCharacterSubstring(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new143() {
        final ArrayList<ANumberCharacterSubstring> list = (ArrayList<ANumberCharacterSubstring>)new ArrayList<Object>();
        list.add(new ANumberCharacterSubstring(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new144() {
        final ArrayList<ANumericLiteralCharacterSubstring> list = (ArrayList<ANumericLiteralCharacterSubstring>)new ArrayList<Object>();
        list.add(new ANumericLiteralCharacterSubstring(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new145() {
        final ArrayList<ABracketedNumberCharacterSubstring> list = (ArrayList<ABracketedNumberCharacterSubstring>)new ArrayList<Object>();
        list.add(new ABracketedNumberCharacterSubstring(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new146() {
        final ArrayList<ADotMinusCharacterSubstring> list = (ArrayList<ADotMinusCharacterSubstring>)new ArrayList<Object>();
        list.add(new ADotMinusCharacterSubstring(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new147() {
        final ArrayList<ADotPlusCharacterSubstring> list = (ArrayList<ADotPlusCharacterSubstring>)new ArrayList<Object>();
        list.add(new ADotPlusCharacterSubstring(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new148() {
        final ArrayList<ADotZeeCharacterSubstring> list = (ArrayList<ADotZeeCharacterSubstring>)new ArrayList<Object>();
        list.add(new ADotZeeCharacterSubstring(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new149() {
        final ArrayList<ABracketedNumber> list = (ArrayList<ABracketedNumber>)new ArrayList<Object>();
        list.add(new ABracketedNumber(this.pop().get(0), this.pop().get(0), this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new150() {
        final ArrayList<ANumberNot88Number> list = (ArrayList<ANumberNot88Number>)new ArrayList<Object>();
        list.add(new ANumberNot88Number(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new151() {
        final ArrayList<ANumber88Number> list = (ArrayList<ANumber88Number>)new ArrayList<Object>();
        list.add(new ANumber88Number(this.pop().get(0)));
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new152() {
        final ArrayList<LinkedList<PAscendingOrDescendingKeyPhrase>> list = (ArrayList<LinkedList<PAscendingOrDescendingKeyPhrase>>)new ArrayList<Object>();
        final ArrayList<Object> pop = this.pop();
        final LinkedList<PAscendingOrDescendingKeyPhrase> e = new LinkedList<PAscendingOrDescendingKeyPhrase>();
        final PAscendingOrDescendingKeyPhrase e2 = pop.get(0);
        if (e2 != null) {
            e.add(e2);
        }
        list.add(e);
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new153() {
        final ArrayList<LinkedList<PAscendingOrDescendingKeyPhrase>> list = (ArrayList<LinkedList<PAscendingOrDescendingKeyPhrase>>)new ArrayList<Object>();
        final ArrayList<Object> pop = this.pop();
        final ArrayList<Object> pop2 = this.pop();
        final LinkedList<PAscendingOrDescendingKeyPhrase> e = new LinkedList<PAscendingOrDescendingKeyPhrase>();
        final LinkedList list2 = new LinkedList();
        final LinkedList<? extends PAscendingOrDescendingKeyPhrase> c = pop2.get(0);
        final PAscendingOrDescendingKeyPhrase e2 = pop.get(0);
        if (c != null) {
            e.addAll(c);
        }
        if (e2 != null) {
            e.add(e2);
        }
        list.add(e);
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new154() {
        final ArrayList<LinkedList<PIndexedByPhrase>> list = (ArrayList<LinkedList<PIndexedByPhrase>>)new ArrayList<Object>();
        final ArrayList<Object> pop = this.pop();
        final LinkedList<PIndexedByPhrase> e = new LinkedList<PIndexedByPhrase>();
        final PIndexedByPhrase e2 = pop.get(0);
        if (e2 != null) {
            e.add(e2);
        }
        list.add(e);
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new155() {
        final ArrayList<LinkedList<PIndexedByPhrase>> list = (ArrayList<LinkedList<PIndexedByPhrase>>)new ArrayList<Object>();
        final ArrayList<Object> pop = this.pop();
        final ArrayList<Object> pop2 = this.pop();
        final LinkedList<PIndexedByPhrase> e = new LinkedList<PIndexedByPhrase>();
        final LinkedList list2 = new LinkedList();
        final LinkedList<? extends PIndexedByPhrase> c = pop2.get(0);
        final PIndexedByPhrase e2 = pop.get(0);
        if (c != null) {
            e.addAll(c);
        }
        if (e2 != null) {
            e.add(e2);
        }
        list.add(e);
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new156() {
        final ArrayList<LinkedList<TDataName>> list = (ArrayList<LinkedList<TDataName>>)new ArrayList<Object>();
        final ArrayList<Object> pop = this.pop();
        final LinkedList<TDataName> e = new LinkedList<TDataName>();
        final TDataName e2 = pop.get(0);
        if (e2 != null) {
            e.add(e2);
        }
        list.add(e);
        return (ArrayList<Object>)list;
    }
    
    ArrayList<Object> new157() {
        final ArrayList<LinkedList<TDataName>> list = (ArrayList<LinkedList<TDataName>>)new ArrayList<Object>();
        final ArrayList<Object> pop = this.pop();
        final ArrayList<Object> pop2 = this.pop();
        final LinkedList<TDataName> e = new LinkedList<TDataName>();
        final LinkedList list2 = new LinkedList();
        final LinkedList<? extends TDataName> c = pop2.get(0);
        final TDataName e2 = pop.get(0);
        if (c != null) {
            e.addAll(c);
        }
        if (e2 != null) {
            e.add(e2);
        }
        list.add(e);
        return (ArrayList<Object>)list;
    }
    
    static {
        try {
            final DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(Parser.class.getResourceAsStream("parser.dat")));
            Parser.actionTable = new int[dataInputStream.readInt()][][];
            for (int i = 0; i < Parser.actionTable.length; ++i) {
                Parser.actionTable[i] = new int[dataInputStream.readInt()][3];
                for (int j = 0; j < Parser.actionTable[i].length; ++j) {
                    for (int k = 0; k < 3; ++k) {
                        Parser.actionTable[i][j][k] = dataInputStream.readInt();
                    }
                }
            }
            Parser.gotoTable = new int[dataInputStream.readInt()][][];
            for (int l = 0; l < Parser.gotoTable.length; ++l) {
                Parser.gotoTable[l] = new int[dataInputStream.readInt()][2];
                for (int n = 0; n < Parser.gotoTable[l].length; ++n) {
                    for (int n2 = 0; n2 < 2; ++n2) {
                        Parser.gotoTable[l][n][n2] = dataInputStream.readInt();
                    }
                }
            }
            Parser.errorMessages = new String[dataInputStream.readInt()];
            for (int n3 = 0; n3 < Parser.errorMessages.length; ++n3) {
                final int int1 = dataInputStream.readInt();
                final StringBuffer sb = new StringBuffer();
                for (int n4 = 0; n4 < int1; ++n4) {
                    sb.append(dataInputStream.readChar());
                }
                Parser.errorMessages[n3] = sb.toString();
            }
            Parser.errors = new int[dataInputStream.readInt()];
            for (int n5 = 0; n5 < Parser.errors.length; ++n5) {
                Parser.errors[n5] = dataInputStream.readInt();
            }
            dataInputStream.close();
        }
        catch (Exception ex) {
            throw new RuntimeException("The file \"parser.dat\" is either missing or corrupted.");
        }
    }
}
