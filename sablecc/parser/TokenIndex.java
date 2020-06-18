// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.parser;

import net.sf.cb2xml.sablecc.node.EOF;
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
import net.sf.cb2xml.sablecc.analysis.AnalysisAdapter;

class TokenIndex extends AnalysisAdapter
{
    int index;
    
    @Override
    public void caseTDot(final TDot tDot) {
        this.index = 0;
    }
    
    @Override
    public void caseTComma(final TComma tComma) {
        this.index = 1;
    }
    
    @Override
    public void caseTSlash(final TSlash tSlash) {
        this.index = 2;
    }
    
    @Override
    public void caseTPlus(final TPlus tPlus) {
        this.index = 3;
    }
    
    @Override
    public void caseTMinus(final TMinus tMinus) {
        this.index = 4;
    }
    
    @Override
    public void caseTStar(final TStar tStar) {
        this.index = 5;
    }
    
    @Override
    public void caseTDollar(final TDollar tDollar) {
        this.index = 6;
    }
    
    @Override
    public void caseTLparen(final TLparen tLparen) {
        this.index = 7;
    }
    
    @Override
    public void caseTRparen(final TRparen tRparen) {
        this.index = 8;
    }
    
    @Override
    public void caseTNumber88(final TNumber88 tNumber88) {
        this.index = 9;
    }
    
    @Override
    public void caseTNumberNot88(final TNumberNot88 tNumberNot88) {
        this.index = 10;
    }
    
    @Override
    public void caseTAlphanumericLiteral(final TAlphanumericLiteral tAlphanumericLiteral) {
        this.index = 11;
    }
    
    @Override
    public void caseTNumericLiteral(final TNumericLiteral tNumericLiteral) {
        this.index = 12;
    }
    
    @Override
    public void caseTDotZee(final TDotZee tDotZee) {
        this.index = 13;
    }
    
    @Override
    public void caseTDotMinus(final TDotMinus tDotMinus) {
        this.index = 14;
    }
    
    @Override
    public void caseTDotPlus(final TDotPlus tDotPlus) {
        this.index = 15;
    }
    
    @Override
    public void caseTAll(final TAll tAll) {
        this.index = 16;
    }
    
    @Override
    public void caseTAre(final TAre tAre) {
        this.index = 17;
    }
    
    @Override
    public void caseTAscending(final TAscending tAscending) {
        this.index = 18;
    }
    
    @Override
    public void caseTBinary(final TBinary tBinary) {
        this.index = 19;
    }
    
    @Override
    public void caseTBlank(final TBlank tBlank) {
        this.index = 20;
    }
    
    @Override
    public void caseTBy(final TBy tBy) {
        this.index = 21;
    }
    
    @Override
    public void caseTCharacter(final TCharacter tCharacter) {
        this.index = 22;
    }
    
    @Override
    public void caseTComp(final TComp tComp) {
        this.index = 23;
    }
    
    @Override
    public void caseTComp1(final TComp1 tComp1) {
        this.index = 24;
    }
    
    @Override
    public void caseTComp2(final TComp2 tComp2) {
        this.index = 25;
    }
    
    @Override
    public void caseTComp3(final TComp3 tComp3) {
        this.index = 26;
    }
    
    @Override
    public void caseTComp4(final TComp4 tComp4) {
        this.index = 27;
    }
    
    @Override
    public void caseTComp5(final TComp5 tComp5) {
        this.index = 28;
    }
    
    @Override
    public void caseTComp6(final TComp6 tComp6) {
        this.index = 29;
    }
    
    @Override
    public void caseTDate(final TDate tDate) {
        this.index = 30;
    }
    
    @Override
    public void caseTDepending(final TDepending tDepending) {
        this.index = 31;
    }
    
    @Override
    public void caseTDescending(final TDescending tDescending) {
        this.index = 32;
    }
    
    @Override
    public void caseTDisplay(final TDisplay tDisplay) {
        this.index = 33;
    }
    
    @Override
    public void caseTDisplay1(final TDisplay1 tDisplay1) {
        this.index = 34;
    }
    
    @Override
    public void caseTExternal(final TExternal tExternal) {
        this.index = 35;
    }
    
    @Override
    public void caseTFiller(final TFiller tFiller) {
        this.index = 36;
    }
    
    @Override
    public void caseTFormat(final TFormat tFormat) {
        this.index = 37;
    }
    
    @Override
    public void caseTFunctionPointer(final TFunctionPointer tFunctionPointer) {
        this.index = 38;
    }
    
    @Override
    public void caseTGlobal(final TGlobal tGlobal) {
        this.index = 39;
    }
    
    @Override
    public void caseTHighValues(final THighValues tHighValues) {
        this.index = 40;
    }
    
    @Override
    public void caseTIndex(final TIndex tIndex) {
        this.index = 41;
    }
    
    @Override
    public void caseTIndexed(final TIndexed tIndexed) {
        this.index = 42;
    }
    
    @Override
    public void caseTIs(final TIs tIs) {
        this.index = 43;
    }
    
    @Override
    public void caseTJustified(final TJustified tJustified) {
        this.index = 44;
    }
    
    @Override
    public void caseTKey(final TKey tKey) {
        this.index = 45;
    }
    
    @Override
    public void caseTLeading(final TLeading tLeading) {
        this.index = 46;
    }
    
    @Override
    public void caseTLeft(final TLeft tLeft) {
        this.index = 47;
    }
    
    @Override
    public void caseTLowValues(final TLowValues tLowValues) {
        this.index = 48;
    }
    
    @Override
    public void caseTNational(final TNational tNational) {
        this.index = 49;
    }
    
    @Override
    public void caseTNative(final TNative tNative) {
        this.index = 50;
    }
    
    @Override
    public void caseTNulls(final TNulls tNulls) {
        this.index = 51;
    }
    
    @Override
    public void caseTObject(final TObject tObject) {
        this.index = 52;
    }
    
    @Override
    public void caseTOccurs(final TOccurs tOccurs) {
        this.index = 53;
    }
    
    @Override
    public void caseTOn(final TOn tOn) {
        this.index = 54;
    }
    
    @Override
    public void caseTPackedDecimal(final TPackedDecimal tPackedDecimal) {
        this.index = 55;
    }
    
    @Override
    public void caseTPicture(final TPicture tPicture) {
        this.index = 56;
    }
    
    @Override
    public void caseTPointer(final TPointer tPointer) {
        this.index = 57;
    }
    
    @Override
    public void caseTProcedurePointer(final TProcedurePointer tProcedurePointer) {
        this.index = 58;
    }
    
    @Override
    public void caseTQuotes(final TQuotes tQuotes) {
        this.index = 59;
    }
    
    @Override
    public void caseTRedefines(final TRedefines tRedefines) {
        this.index = 60;
    }
    
    @Override
    public void caseTReference(final TReference tReference) {
        this.index = 61;
    }
    
    @Override
    public void caseTRenames(final TRenames tRenames) {
        this.index = 62;
    }
    
    @Override
    public void caseTRight(final TRight tRight) {
        this.index = 63;
    }
    
    @Override
    public void caseTSeparate(final TSeparate tSeparate) {
        this.index = 64;
    }
    
    @Override
    public void caseTSign(final TSign tSign) {
        this.index = 65;
    }
    
    @Override
    public void caseTSpaces(final TSpaces tSpaces) {
        this.index = 66;
    }
    
    @Override
    public void caseTSynchronized(final TSynchronized tSynchronized) {
        this.index = 67;
    }
    
    @Override
    public void caseTThrough(final TThrough tThrough) {
        this.index = 68;
    }
    
    @Override
    public void caseTTimes(final TTimes tTimes) {
        this.index = 69;
    }
    
    @Override
    public void caseTTo(final TTo tTo) {
        this.index = 70;
    }
    
    @Override
    public void caseTTrailing(final TTrailing tTrailing) {
        this.index = 71;
    }
    
    @Override
    public void caseTUsage(final TUsage tUsage) {
        this.index = 72;
    }
    
    @Override
    public void caseTValue(final TValue tValue) {
        this.index = 73;
    }
    
    @Override
    public void caseTValues(final TValues tValues) {
        this.index = 74;
    }
    
    @Override
    public void caseTWhen(final TWhen tWhen) {
        this.index = 75;
    }
    
    @Override
    public void caseTZeros(final TZeros tZeros) {
        this.index = 76;
    }
    
    @Override
    public void caseTDataName(final TDataName tDataName) {
        this.index = 77;
    }
    
    @Override
    public void caseEOF(final EOF eof) {
        this.index = 78;
    }
}
