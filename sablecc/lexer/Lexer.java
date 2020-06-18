// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.lexer;

import java.io.InputStream;
import java.io.DataInputStream;
import java.io.BufferedInputStream;
import net.sf.cb2xml.sablecc.node.TUnknown;
import net.sf.cb2xml.sablecc.node.TDataName;
import net.sf.cb2xml.sablecc.node.TZeros;
import net.sf.cb2xml.sablecc.node.TWhen;
import net.sf.cb2xml.sablecc.node.TValues;
import net.sf.cb2xml.sablecc.node.TValue;
import net.sf.cb2xml.sablecc.node.TUsage;
import net.sf.cb2xml.sablecc.node.TTrailing;
import net.sf.cb2xml.sablecc.node.TTo;
import net.sf.cb2xml.sablecc.node.TTimes;
import net.sf.cb2xml.sablecc.node.TThrough;
import net.sf.cb2xml.sablecc.node.TSynchronized;
import net.sf.cb2xml.sablecc.node.TSpaces;
import net.sf.cb2xml.sablecc.node.TSign;
import net.sf.cb2xml.sablecc.node.TSeparate;
import net.sf.cb2xml.sablecc.node.TRight;
import net.sf.cb2xml.sablecc.node.TRenames;
import net.sf.cb2xml.sablecc.node.TReference;
import net.sf.cb2xml.sablecc.node.TRedefines;
import net.sf.cb2xml.sablecc.node.TQuotes;
import net.sf.cb2xml.sablecc.node.TProcedurePointer;
import net.sf.cb2xml.sablecc.node.TPointer;
import net.sf.cb2xml.sablecc.node.TPicture;
import net.sf.cb2xml.sablecc.node.TPackedDecimal;
import net.sf.cb2xml.sablecc.node.TOn;
import net.sf.cb2xml.sablecc.node.TOccurs;
import net.sf.cb2xml.sablecc.node.TObject;
import net.sf.cb2xml.sablecc.node.TNulls;
import net.sf.cb2xml.sablecc.node.TNative;
import net.sf.cb2xml.sablecc.node.TNational;
import net.sf.cb2xml.sablecc.node.TLowValues;
import net.sf.cb2xml.sablecc.node.TLeft;
import net.sf.cb2xml.sablecc.node.TLeading;
import net.sf.cb2xml.sablecc.node.TKey;
import net.sf.cb2xml.sablecc.node.TJustified;
import net.sf.cb2xml.sablecc.node.TIs;
import net.sf.cb2xml.sablecc.node.TIndexed;
import net.sf.cb2xml.sablecc.node.TIndex;
import net.sf.cb2xml.sablecc.node.THighValues;
import net.sf.cb2xml.sablecc.node.TGlobal;
import net.sf.cb2xml.sablecc.node.TFunctionPointer;
import net.sf.cb2xml.sablecc.node.TFormat;
import net.sf.cb2xml.sablecc.node.TFiller;
import net.sf.cb2xml.sablecc.node.TExternal;
import net.sf.cb2xml.sablecc.node.TDisplay1;
import net.sf.cb2xml.sablecc.node.TDisplay;
import net.sf.cb2xml.sablecc.node.TDescending;
import net.sf.cb2xml.sablecc.node.TDepending;
import net.sf.cb2xml.sablecc.node.TDate;
import net.sf.cb2xml.sablecc.node.TComp6;
import net.sf.cb2xml.sablecc.node.TComp5;
import net.sf.cb2xml.sablecc.node.TComp4;
import net.sf.cb2xml.sablecc.node.TComp3;
import net.sf.cb2xml.sablecc.node.TComp2;
import net.sf.cb2xml.sablecc.node.TComp1;
import net.sf.cb2xml.sablecc.node.TComp;
import net.sf.cb2xml.sablecc.node.TCharacter;
import net.sf.cb2xml.sablecc.node.TBy;
import net.sf.cb2xml.sablecc.node.TBlank;
import net.sf.cb2xml.sablecc.node.TBinary;
import net.sf.cb2xml.sablecc.node.TAscending;
import net.sf.cb2xml.sablecc.node.TAre;
import net.sf.cb2xml.sablecc.node.TAll;
import net.sf.cb2xml.sablecc.node.TDotPlus;
import net.sf.cb2xml.sablecc.node.TDotMinus;
import net.sf.cb2xml.sablecc.node.TDotZee;
import net.sf.cb2xml.sablecc.node.TNumericLiteral;
import net.sf.cb2xml.sablecc.node.TAlphanumericLiteral;
import net.sf.cb2xml.sablecc.node.TNumberNot88;
import net.sf.cb2xml.sablecc.node.TNumber88;
import net.sf.cb2xml.sablecc.node.TRparen;
import net.sf.cb2xml.sablecc.node.TLparen;
import net.sf.cb2xml.sablecc.node.TDollar;
import net.sf.cb2xml.sablecc.node.TStar;
import net.sf.cb2xml.sablecc.node.TMinus;
import net.sf.cb2xml.sablecc.node.TPlus;
import net.sf.cb2xml.sablecc.node.TSlash;
import net.sf.cb2xml.sablecc.node.TComma;
import net.sf.cb2xml.sablecc.node.TDot;
import net.sf.cb2xml.sablecc.node.TComment;
import net.sf.cb2xml.sablecc.node.TWhiteSpaces;
import net.sf.cb2xml.sablecc.node.EOF;
import net.sf.cb2xml.sablecc.node.InvalidToken;
import java.io.PushbackReader;
import java.io.IOException;
import net.sf.cb2xml.sablecc.node.Token;

public class Lexer
{
    protected Token token;
    protected State state;
    private IPushbackReader in;
    private int line;
    private int pos;
    private boolean cr;
    private boolean eof;
    private final StringBuffer text;
    private static int[][][][] gotoTable;
    private static int[][] accept;
    
    protected void filter() throws LexerException, IOException {
    }
    
    public Lexer(final PushbackReader pushbackReader) {
        this.state = State.INITIAL;
        this.text = new StringBuffer();
        this.in = new IPushbackReader() {
            private PushbackReader pushbackReader = pushbackReader;
            
            @Override
            public void unread(final int c) throws IOException {
                this.pushbackReader.unread(c);
            }
            
            @Override
            public int read() throws IOException {
                return this.pushbackReader.read();
            }
        };
    }
    
    public Lexer(final IPushbackReader in) {
        this.state = State.INITIAL;
        this.text = new StringBuffer();
        this.in = in;
    }
    
    public Token peek() throws LexerException, IOException {
        while (this.token == null) {
            this.token = this.getToken();
            this.filter();
        }
        return this.token;
    }
    
    public Token next() throws LexerException, IOException {
        while (this.token == null) {
            this.token = this.getToken();
            this.filter();
        }
        final Token token = this.token;
        this.token = null;
        return token;
    }
    
    protected Token getToken() throws IOException, LexerException {
        int i = 0;
        final int pos = this.pos;
        final int line = this.line;
        int n = -1;
        int n2 = -1;
        int length = -1;
        int pos2 = -1;
        int line2 = -1;
        final int[][][] array = Lexer.gotoTable[this.state.id()];
        final int[] array2 = Lexer.accept[this.state.id()];
        this.text.setLength(0);
        while (true) {
            final int char1 = this.getChar();
            if (char1 != -1) {
                switch (char1) {
                    case 10: {
                        if (this.cr) {
                            this.cr = false;
                            break;
                        }
                        ++this.line;
                        this.pos = 0;
                        break;
                    }
                    case 13: {
                        ++this.line;
                        this.pos = 0;
                        this.cr = true;
                        break;
                    }
                    default: {
                        ++this.pos;
                        this.cr = false;
                        break;
                    }
                }
                this.text.append((char)char1);
                do {
                    final int n3 = (i < -1) ? (-2 - i) : i;
                    i = -1;
                    final int[][] array3 = array[n3];
                    int j = 0;
                    int n4 = array3.length - 1;
                    while (j <= n4) {
                        final int n5 = j + n4 >>> 1;
                        final int[] array4 = array3[n5];
                        if (char1 < array4[0]) {
                            n4 = n5 - 1;
                        }
                        else {
                            if (char1 <= array4[1]) {
                                i = array4[2];
                                break;
                            }
                            j = n5 + 1;
                        }
                    }
                } while (i < -1);
            }
            else {
                i = -1;
            }
            if (i >= 0) {
                if (array2[i] == -1) {
                    continue;
                }
                n = i;
                n2 = array2[i];
                length = this.text.length();
                pos2 = this.pos;
                line2 = this.line;
            }
            else if (n != -1) {
                switch (n2) {
                    case 0: {
                        final Token new0 = this.new0(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new0;
                    }
                    case 1: {
                        final Token new2 = this.new1(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new2;
                    }
                    case 2: {
                        final Token new3 = this.new2(line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new3;
                    }
                    case 3: {
                        final Token new4 = this.new3(line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new4;
                    }
                    case 4: {
                        final Token new5 = this.new4(line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new5;
                    }
                    case 5: {
                        final Token new6 = this.new5(line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new6;
                    }
                    case 6: {
                        final Token new7 = this.new6(line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new7;
                    }
                    case 7: {
                        final Token new8 = this.new7(line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new8;
                    }
                    case 8: {
                        final Token new9 = this.new8(line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new9;
                    }
                    case 9: {
                        final Token new10 = this.new9(line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new10;
                    }
                    case 10: {
                        final Token new11 = this.new10(line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new11;
                    }
                    case 11: {
                        final Token new12 = this.new11(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new12;
                    }
                    case 12: {
                        final Token new13 = this.new12(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new13;
                    }
                    case 13: {
                        final Token new14 = this.new13(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new14;
                    }
                    case 14: {
                        final Token new15 = this.new14(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new15;
                    }
                    case 15: {
                        final Token new16 = this.new15(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new16;
                    }
                    case 16: {
                        final Token new17 = this.new16(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new17;
                    }
                    case 17: {
                        final Token new18 = this.new17(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new18;
                    }
                    case 18: {
                        final Token new19 = this.new18(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new19;
                    }
                    case 19: {
                        final Token new20 = this.new19(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new20;
                    }
                    case 20: {
                        final Token new21 = this.new20(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new21;
                    }
                    case 21: {
                        final Token new22 = this.new21(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new22;
                    }
                    case 22: {
                        final Token new23 = this.new22(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new23;
                    }
                    case 23: {
                        final Token new24 = this.new23(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new24;
                    }
                    case 24: {
                        final Token new25 = this.new24(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new25;
                    }
                    case 25: {
                        final Token new26 = this.new25(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new26;
                    }
                    case 26: {
                        final Token new27 = this.new26(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new27;
                    }
                    case 27: {
                        final Token new28 = this.new27(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new28;
                    }
                    case 28: {
                        final Token new29 = this.new28(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new29;
                    }
                    case 29: {
                        final Token new30 = this.new29(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new30;
                    }
                    case 30: {
                        final Token new31 = this.new30(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new31;
                    }
                    case 31: {
                        final Token new32 = this.new31(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new32;
                    }
                    case 32: {
                        final Token new33 = this.new32(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new33;
                    }
                    case 33: {
                        final Token new34 = this.new33(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new34;
                    }
                    case 34: {
                        final Token new35 = this.new34(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new35;
                    }
                    case 35: {
                        final Token new36 = this.new35(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new36;
                    }
                    case 36: {
                        final Token new37 = this.new36(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new37;
                    }
                    case 37: {
                        final Token new38 = this.new37(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new38;
                    }
                    case 38: {
                        final Token new39 = this.new38(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new39;
                    }
                    case 39: {
                        final Token new40 = this.new39(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new40;
                    }
                    case 40: {
                        final Token new41 = this.new40(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new41;
                    }
                    case 41: {
                        final Token new42 = this.new41(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new42;
                    }
                    case 42: {
                        final Token new43 = this.new42(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new43;
                    }
                    case 43: {
                        final Token new44 = this.new43(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new44;
                    }
                    case 44: {
                        final Token new45 = this.new44(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new45;
                    }
                    case 45: {
                        final Token new46 = this.new45(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new46;
                    }
                    case 46: {
                        final Token new47 = this.new46(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new47;
                    }
                    case 47: {
                        final Token new48 = this.new47(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new48;
                    }
                    case 48: {
                        final Token new49 = this.new48(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new49;
                    }
                    case 49: {
                        final Token new50 = this.new49(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new50;
                    }
                    case 50: {
                        final Token new51 = this.new50(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new51;
                    }
                    case 51: {
                        final Token new52 = this.new51(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new52;
                    }
                    case 52: {
                        final Token new53 = this.new52(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new53;
                    }
                    case 53: {
                        final Token new54 = this.new53(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new54;
                    }
                    case 54: {
                        final Token new55 = this.new54(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new55;
                    }
                    case 55: {
                        final Token new56 = this.new55(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new56;
                    }
                    case 56: {
                        final Token new57 = this.new56(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new57;
                    }
                    case 57: {
                        final Token new58 = this.new57(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new58;
                    }
                    case 58: {
                        final Token new59 = this.new58(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new59;
                    }
                    case 59: {
                        final Token new60 = this.new59(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new60;
                    }
                    case 60: {
                        final Token new61 = this.new60(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new61;
                    }
                    case 61: {
                        final Token new62 = this.new61(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new62;
                    }
                    case 62: {
                        final Token new63 = this.new62(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new63;
                    }
                    case 63: {
                        final Token new64 = this.new63(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new64;
                    }
                    case 64: {
                        final Token new65 = this.new64(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new65;
                    }
                    case 65: {
                        final Token new66 = this.new65(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new66;
                    }
                    case 66: {
                        final Token new67 = this.new66(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new67;
                    }
                    case 67: {
                        final Token new68 = this.new67(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new68;
                    }
                    case 68: {
                        final Token new69 = this.new68(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new69;
                    }
                    case 69: {
                        final Token new70 = this.new69(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new70;
                    }
                    case 70: {
                        final Token new71 = this.new70(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new71;
                    }
                    case 71: {
                        final Token new72 = this.new71(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new72;
                    }
                    case 72: {
                        final Token new73 = this.new72(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new73;
                    }
                    case 73: {
                        final Token new74 = this.new73(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new74;
                    }
                    case 74: {
                        final Token new75 = this.new74(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new75;
                    }
                    case 75: {
                        final Token new76 = this.new75(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new76;
                    }
                    case 76: {
                        final Token new77 = this.new76(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new77;
                    }
                    case 77: {
                        final Token new78 = this.new77(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new78;
                    }
                    case 78: {
                        final Token new79 = this.new78(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new79;
                    }
                    case 79: {
                        final Token new80 = this.new79(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new80;
                    }
                    case 80: {
                        final Token new81 = this.new80(this.getText(length), line + 1, pos + 1);
                        this.pushBack(length);
                        this.pos = pos2;
                        this.line = line2;
                        return new81;
                    }
                    default: {
                        continue;
                    }
                }
            }
            else {
                if (this.text.length() > 0) {
                    throw new LexerException(new InvalidToken(this.text.substring(0, 1), line + 1, pos + 1), "[" + (line + 1) + "," + (pos + 1) + "] Unknown token: " + (Object)this.text);
                }
                return new EOF(line + 1, pos + 1);
            }
        }
    }
    
    Token new0(final String s, final int n, final int n2) {
        return new TWhiteSpaces(s, n, n2);
    }
    
    Token new1(final String s, final int n, final int n2) {
        return new TComment(s, n, n2);
    }
    
    Token new2(final int n, final int n2) {
        return new TDot(n, n2);
    }
    
    Token new3(final int n, final int n2) {
        return new TComma(n, n2);
    }
    
    Token new4(final int n, final int n2) {
        return new TSlash(n, n2);
    }
    
    Token new5(final int n, final int n2) {
        return new TPlus(n, n2);
    }
    
    Token new6(final int n, final int n2) {
        return new TMinus(n, n2);
    }
    
    Token new7(final int n, final int n2) {
        return new TStar(n, n2);
    }
    
    Token new8(final int n, final int n2) {
        return new TDollar(n, n2);
    }
    
    Token new9(final int n, final int n2) {
        return new TLparen(n, n2);
    }
    
    Token new10(final int n, final int n2) {
        return new TRparen(n, n2);
    }
    
    Token new11(final String s, final int n, final int n2) {
        return new TNumber88(s, n, n2);
    }
    
    Token new12(final String s, final int n, final int n2) {
        return new TNumberNot88(s, n, n2);
    }
    
    Token new13(final String s, final int n, final int n2) {
        return new TAlphanumericLiteral(s, n, n2);
    }
    
    Token new14(final String s, final int n, final int n2) {
        return new TNumericLiteral(s, n, n2);
    }
    
    Token new15(final String s, final int n, final int n2) {
        return new TDotZee(s, n, n2);
    }
    
    Token new16(final String s, final int n, final int n2) {
        return new TDotMinus(s, n, n2);
    }
    
    Token new17(final String s, final int n, final int n2) {
        return new TDotPlus(s, n, n2);
    }
    
    Token new18(final String s, final int n, final int n2) {
        return new TAll(s, n, n2);
    }
    
    Token new19(final String s, final int n, final int n2) {
        return new TAre(s, n, n2);
    }
    
    Token new20(final String s, final int n, final int n2) {
        return new TAscending(s, n, n2);
    }
    
    Token new21(final String s, final int n, final int n2) {
        return new TBinary(s, n, n2);
    }
    
    Token new22(final String s, final int n, final int n2) {
        return new TBlank(s, n, n2);
    }
    
    Token new23(final String s, final int n, final int n2) {
        return new TBy(s, n, n2);
    }
    
    Token new24(final String s, final int n, final int n2) {
        return new TCharacter(s, n, n2);
    }
    
    Token new25(final String s, final int n, final int n2) {
        return new TComp(s, n, n2);
    }
    
    Token new26(final String s, final int n, final int n2) {
        return new TComp1(s, n, n2);
    }
    
    Token new27(final String s, final int n, final int n2) {
        return new TComp2(s, n, n2);
    }
    
    Token new28(final String s, final int n, final int n2) {
        return new TComp3(s, n, n2);
    }
    
    Token new29(final String s, final int n, final int n2) {
        return new TComp4(s, n, n2);
    }
    
    Token new30(final String s, final int n, final int n2) {
        return new TComp5(s, n, n2);
    }
    
    Token new31(final String s, final int n, final int n2) {
        return new TComp6(s, n, n2);
    }
    
    Token new32(final String s, final int n, final int n2) {
        return new TDate(s, n, n2);
    }
    
    Token new33(final String s, final int n, final int n2) {
        return new TDepending(s, n, n2);
    }
    
    Token new34(final String s, final int n, final int n2) {
        return new TDescending(s, n, n2);
    }
    
    Token new35(final String s, final int n, final int n2) {
        return new TDisplay(s, n, n2);
    }
    
    Token new36(final String s, final int n, final int n2) {
        return new TDisplay1(s, n, n2);
    }
    
    Token new37(final String s, final int n, final int n2) {
        return new TExternal(s, n, n2);
    }
    
    Token new38(final String s, final int n, final int n2) {
        return new TFiller(s, n, n2);
    }
    
    Token new39(final String s, final int n, final int n2) {
        return new TFormat(s, n, n2);
    }
    
    Token new40(final String s, final int n, final int n2) {
        return new TFunctionPointer(s, n, n2);
    }
    
    Token new41(final String s, final int n, final int n2) {
        return new TGlobal(s, n, n2);
    }
    
    Token new42(final String s, final int n, final int n2) {
        return new THighValues(s, n, n2);
    }
    
    Token new43(final String s, final int n, final int n2) {
        return new TIndex(s, n, n2);
    }
    
    Token new44(final String s, final int n, final int n2) {
        return new TIndexed(s, n, n2);
    }
    
    Token new45(final String s, final int n, final int n2) {
        return new TIs(s, n, n2);
    }
    
    Token new46(final String s, final int n, final int n2) {
        return new TJustified(s, n, n2);
    }
    
    Token new47(final String s, final int n, final int n2) {
        return new TKey(s, n, n2);
    }
    
    Token new48(final String s, final int n, final int n2) {
        return new TLeading(s, n, n2);
    }
    
    Token new49(final String s, final int n, final int n2) {
        return new TLeft(s, n, n2);
    }
    
    Token new50(final String s, final int n, final int n2) {
        return new TLowValues(s, n, n2);
    }
    
    Token new51(final String s, final int n, final int n2) {
        return new TNational(s, n, n2);
    }
    
    Token new52(final String s, final int n, final int n2) {
        return new TNative(s, n, n2);
    }
    
    Token new53(final String s, final int n, final int n2) {
        return new TNulls(s, n, n2);
    }
    
    Token new54(final String s, final int n, final int n2) {
        return new TObject(s, n, n2);
    }
    
    Token new55(final String s, final int n, final int n2) {
        return new TOccurs(s, n, n2);
    }
    
    Token new56(final String s, final int n, final int n2) {
        return new TOn(s, n, n2);
    }
    
    Token new57(final String s, final int n, final int n2) {
        return new TPackedDecimal(s, n, n2);
    }
    
    Token new58(final String s, final int n, final int n2) {
        return new TPicture(s, n, n2);
    }
    
    Token new59(final String s, final int n, final int n2) {
        return new TPointer(s, n, n2);
    }
    
    Token new60(final String s, final int n, final int n2) {
        return new TProcedurePointer(s, n, n2);
    }
    
    Token new61(final String s, final int n, final int n2) {
        return new TQuotes(s, n, n2);
    }
    
    Token new62(final String s, final int n, final int n2) {
        return new TRedefines(s, n, n2);
    }
    
    Token new63(final String s, final int n, final int n2) {
        return new TReference(s, n, n2);
    }
    
    Token new64(final String s, final int n, final int n2) {
        return new TRenames(s, n, n2);
    }
    
    Token new65(final String s, final int n, final int n2) {
        return new TRight(s, n, n2);
    }
    
    Token new66(final String s, final int n, final int n2) {
        return new TSeparate(s, n, n2);
    }
    
    Token new67(final String s, final int n, final int n2) {
        return new TSign(s, n, n2);
    }
    
    Token new68(final String s, final int n, final int n2) {
        return new TSpaces(s, n, n2);
    }
    
    Token new69(final String s, final int n, final int n2) {
        return new TSynchronized(s, n, n2);
    }
    
    Token new70(final String s, final int n, final int n2) {
        return new TThrough(s, n, n2);
    }
    
    Token new71(final String s, final int n, final int n2) {
        return new TTimes(s, n, n2);
    }
    
    Token new72(final String s, final int n, final int n2) {
        return new TTo(s, n, n2);
    }
    
    Token new73(final String s, final int n, final int n2) {
        return new TTrailing(s, n, n2);
    }
    
    Token new74(final String s, final int n, final int n2) {
        return new TUsage(s, n, n2);
    }
    
    Token new75(final String s, final int n, final int n2) {
        return new TValue(s, n, n2);
    }
    
    Token new76(final String s, final int n, final int n2) {
        return new TValues(s, n, n2);
    }
    
    Token new77(final String s, final int n, final int n2) {
        return new TWhen(s, n, n2);
    }
    
    Token new78(final String s, final int n, final int n2) {
        return new TZeros(s, n, n2);
    }
    
    Token new79(final String s, final int n, final int n2) {
        return new TDataName(s, n, n2);
    }
    
    Token new80(final String s, final int n, final int n2) {
        return new TUnknown(s, n, n2);
    }
    
    private int getChar() throws IOException {
        if (this.eof) {
            return -1;
        }
        final int read = this.in.read();
        if (read == -1) {
            this.eof = true;
        }
        return read;
    }
    
    private void pushBack(final int n) throws IOException {
        for (int i = this.text.length() - 1; i >= n; --i) {
            this.eof = false;
            this.in.unread(this.text.charAt(i));
        }
    }
    
    protected void unread(final Token token) throws IOException {
        final String text = token.getText();
        for (int i = text.length() - 1; i >= 0; --i) {
            this.eof = false;
            this.in.unread(text.charAt(i));
        }
        this.pos = token.getPos() - 1;
        this.line = token.getLine() - 1;
    }
    
    private String getText(final int capacity) {
        final StringBuffer sb = new StringBuffer(capacity);
        for (int i = 0; i < capacity; ++i) {
            sb.append(this.text.charAt(i));
        }
        return sb.toString();
    }
    
    static {
        try {
            final DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(Lexer.class.getResourceAsStream("lexer.dat")));
            Lexer.gotoTable = new int[dataInputStream.readInt()][][][];
            for (int i = 0; i < Lexer.gotoTable.length; ++i) {
                Lexer.gotoTable[i] = new int[dataInputStream.readInt()][][];
                for (int j = 0; j < Lexer.gotoTable[i].length; ++j) {
                    Lexer.gotoTable[i][j] = new int[dataInputStream.readInt()][3];
                    for (int k = 0; k < Lexer.gotoTable[i][j].length; ++k) {
                        for (int l = 0; l < 3; ++l) {
                            Lexer.gotoTable[i][j][k][l] = dataInputStream.readInt();
                        }
                    }
                }
            }
            Lexer.accept = new int[dataInputStream.readInt()][];
            for (int n = 0; n < Lexer.accept.length; ++n) {
                Lexer.accept[n] = new int[dataInputStream.readInt()];
                for (int n2 = 0; n2 < Lexer.accept[n].length; ++n2) {
                    Lexer.accept[n][n2] = dataInputStream.readInt();
                }
            }
            dataInputStream.close();
        }
        catch (Exception ex) {
            throw new RuntimeException("The file \"lexer.dat\" is either missing or corrupted.");
        }
    }
    
    public static class State
    {
        public static final State INITIAL;
        private int id;
        
        private State(final int id) {
            this.id = id;
        }
        
        public int id() {
            return this.id;
        }
        
        static {
            INITIAL = new State(0);
        }
    }
}
