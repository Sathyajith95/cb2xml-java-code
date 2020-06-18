// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.analysis;

import net.sf.cb2xml.sablecc.node.InvalidToken;
import net.sf.cb2xml.sablecc.node.EOF;
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
import net.sf.cb2xml.sablecc.node.ANumber88Number;
import net.sf.cb2xml.sablecc.node.ANumberNot88Number;
import net.sf.cb2xml.sablecc.node.ABracketedNumber;
import net.sf.cb2xml.sablecc.node.ADotZeeCharacterSubstring;
import net.sf.cb2xml.sablecc.node.ADotPlusCharacterSubstring;
import net.sf.cb2xml.sablecc.node.ADotMinusCharacterSubstring;
import net.sf.cb2xml.sablecc.node.ABracketedNumberCharacterSubstring;
import net.sf.cb2xml.sablecc.node.ANumericLiteralCharacterSubstring;
import net.sf.cb2xml.sablecc.node.ANumberCharacterSubstring;
import net.sf.cb2xml.sablecc.node.ACommaCharacterSubstring;
import net.sf.cb2xml.sablecc.node.ADollarCharacterSubstring;
import net.sf.cb2xml.sablecc.node.ASlashCharacterSubstring;
import net.sf.cb2xml.sablecc.node.AStarCharacterSubstring;
import net.sf.cb2xml.sablecc.node.AMinusCharacterSubstring;
import net.sf.cb2xml.sablecc.node.APlusCharacterSubstring;
import net.sf.cb2xml.sablecc.node.ADataNameCharacterSubstring;
import net.sf.cb2xml.sablecc.node.ASequenceCharacterString;
import net.sf.cb2xml.sablecc.node.ASingleCharacterString;
import net.sf.cb2xml.sablecc.node.AAlphanumericLiteralLiteral;
import net.sf.cb2xml.sablecc.node.ANumericLiteralLiteral;
import net.sf.cb2xml.sablecc.node.ANumberLiteral;
import net.sf.cb2xml.sablecc.node.ANullsLiteral;
import net.sf.cb2xml.sablecc.node.AQuotesLiteral;
import net.sf.cb2xml.sablecc.node.ALowValuesLiteral;
import net.sf.cb2xml.sablecc.node.AHighValuesLiteral;
import net.sf.cb2xml.sablecc.node.ASpacesLiteral;
import net.sf.cb2xml.sablecc.node.AZerosLiteral;
import net.sf.cb2xml.sablecc.node.AThroughSequenceLiteralSequence;
import net.sf.cb2xml.sablecc.node.AThroughSingleLiteralSequence;
import net.sf.cb2xml.sablecc.node.ASequenceLiteralSequence;
import net.sf.cb2xml.sablecc.node.ASingleLiteralSequence;
import net.sf.cb2xml.sablecc.node.AValuesValueOrValues;
import net.sf.cb2xml.sablecc.node.AValueValueOrValues;
import net.sf.cb2xml.sablecc.node.AValueItem;
import net.sf.cb2xml.sablecc.node.AValueClause;
import net.sf.cb2xml.sablecc.node.AThroughPhrase;
import net.sf.cb2xml.sablecc.node.ARenamesItem;
import net.sf.cb2xml.sablecc.node.AObjectReferencePhrase;
import net.sf.cb2xml.sablecc.node.AFunctionPointerUsagePhrase;
import net.sf.cb2xml.sablecc.node.AProcedurePointerUsagePhrase;
import net.sf.cb2xml.sablecc.node.APointerUsagePhrase;
import net.sf.cb2xml.sablecc.node.APackedDecimalUsagePhrase;
import net.sf.cb2xml.sablecc.node.AObjectReferencePhraseUsagePhrase;
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
import net.sf.cb2xml.sablecc.node.AUsageIs;
import net.sf.cb2xml.sablecc.node.AUsageClause;
import net.sf.cb2xml.sablecc.node.ARightLeftOrRight;
import net.sf.cb2xml.sablecc.node.ALeftLeftOrRight;
import net.sf.cb2xml.sablecc.node.ASynchronizedClause;
import net.sf.cb2xml.sablecc.node.ASeparateCharacter;
import net.sf.cb2xml.sablecc.node.ATrailingLeadingOrTrailing;
import net.sf.cb2xml.sablecc.node.ALeadingLeadingOrTrailing;
import net.sf.cb2xml.sablecc.node.ASignIs;
import net.sf.cb2xml.sablecc.node.ASignClause;
import net.sf.cb2xml.sablecc.node.APictureClause;
import net.sf.cb2xml.sablecc.node.AIndexedByPhrase;
import net.sf.cb2xml.sablecc.node.ADescendingAscendingOrDescending;
import net.sf.cb2xml.sablecc.node.AAscendingAscendingOrDescending;
import net.sf.cb2xml.sablecc.node.AAscendingOrDescendingKeyPhrase;
import net.sf.cb2xml.sablecc.node.AOccursTo;
import net.sf.cb2xml.sablecc.node.AVariableOccursFixedOrVariable;
import net.sf.cb2xml.sablecc.node.AFixedOccursFixedOrVariable;
import net.sf.cb2xml.sablecc.node.AOccursClause;
import net.sf.cb2xml.sablecc.node.AJustifiedClause;
import net.sf.cb2xml.sablecc.node.AGlobalClause;
import net.sf.cb2xml.sablecc.node.AExternalClause;
import net.sf.cb2xml.sablecc.node.ADateFormatClause;
import net.sf.cb2xml.sablecc.node.ABlankWhenZeroClause;
import net.sf.cb2xml.sablecc.node.AValueClauseClause;
import net.sf.cb2xml.sablecc.node.AUsageClauseClause;
import net.sf.cb2xml.sablecc.node.ASynchronizedClauseClause;
import net.sf.cb2xml.sablecc.node.ASignClauseClause;
import net.sf.cb2xml.sablecc.node.APictureClauseClause;
import net.sf.cb2xml.sablecc.node.AOccursClauseClause;
import net.sf.cb2xml.sablecc.node.AJustifiedClauseClause;
import net.sf.cb2xml.sablecc.node.AGlobalClauseClause;
import net.sf.cb2xml.sablecc.node.AExternalClauseClause;
import net.sf.cb2xml.sablecc.node.ADateFormatClauseClause;
import net.sf.cb2xml.sablecc.node.ABlankWhenZeroClauseClause;
import net.sf.cb2xml.sablecc.node.ASequenceClauseSequence;
import net.sf.cb2xml.sablecc.node.ASingleClauseSequence;
import net.sf.cb2xml.sablecc.node.ARedefinesClause;
import net.sf.cb2xml.sablecc.node.AFillerDataNameOrFiller;
import net.sf.cb2xml.sablecc.node.ADataNameDataNameOrFiller;
import net.sf.cb2xml.sablecc.node.AItem;
import net.sf.cb2xml.sablecc.node.AValueItemElementaryItem;
import net.sf.cb2xml.sablecc.node.ARenamesItemElementaryItem;
import net.sf.cb2xml.sablecc.node.AItemElementaryItem;
import net.sf.cb2xml.sablecc.node.ASequenceGroupItem;
import net.sf.cb2xml.sablecc.node.ASingleGroupItem;
import net.sf.cb2xml.sablecc.node.ARecordDescription;
import net.sf.cb2xml.sablecc.node.Start;
import net.sf.cb2xml.sablecc.node.Node;
import java.util.Hashtable;

public class AnalysisAdapter implements Analysis
{
    private Hashtable<Node, Object> in;
    private Hashtable<Node, Object> out;
    
    @Override
    public Object getIn(final Node key) {
        if (this.in == null) {
            return null;
        }
        return this.in.get(key);
    }
    
    @Override
    public void setIn(final Node node, final Object value) {
        if (this.in == null) {
            this.in = new Hashtable<Node, Object>(1);
        }
        if (value != null) {
            this.in.put(node, value);
        }
        else {
            this.in.remove(node);
        }
    }
    
    @Override
    public Object getOut(final Node key) {
        if (this.out == null) {
            return null;
        }
        return this.out.get(key);
    }
    
    @Override
    public void setOut(final Node node, final Object value) {
        if (this.out == null) {
            this.out = new Hashtable<Node, Object>(1);
        }
        if (value != null) {
            this.out.put(node, value);
        }
        else {
            this.out.remove(node);
        }
    }
    
    @Override
    public void caseStart(final Start start) {
        this.defaultCase(start);
    }
    
    @Override
    public void caseARecordDescription(final ARecordDescription aRecordDescription) {
        this.defaultCase(aRecordDescription);
    }
    
    @Override
    public void caseASingleGroupItem(final ASingleGroupItem aSingleGroupItem) {
        this.defaultCase(aSingleGroupItem);
    }
    
    @Override
    public void caseASequenceGroupItem(final ASequenceGroupItem aSequenceGroupItem) {
        this.defaultCase(aSequenceGroupItem);
    }
    
    @Override
    public void caseAItemElementaryItem(final AItemElementaryItem aItemElementaryItem) {
        this.defaultCase(aItemElementaryItem);
    }
    
    @Override
    public void caseARenamesItemElementaryItem(final ARenamesItemElementaryItem aRenamesItemElementaryItem) {
        this.defaultCase(aRenamesItemElementaryItem);
    }
    
    @Override
    public void caseAValueItemElementaryItem(final AValueItemElementaryItem aValueItemElementaryItem) {
        this.defaultCase(aValueItemElementaryItem);
    }
    
    @Override
    public void caseAItem(final AItem aItem) {
        this.defaultCase(aItem);
    }
    
    @Override
    public void caseADataNameDataNameOrFiller(final ADataNameDataNameOrFiller aDataNameDataNameOrFiller) {
        this.defaultCase(aDataNameDataNameOrFiller);
    }
    
    @Override
    public void caseAFillerDataNameOrFiller(final AFillerDataNameOrFiller aFillerDataNameOrFiller) {
        this.defaultCase(aFillerDataNameOrFiller);
    }
    
    @Override
    public void caseARedefinesClause(final ARedefinesClause aRedefinesClause) {
        this.defaultCase(aRedefinesClause);
    }
    
    @Override
    public void caseASingleClauseSequence(final ASingleClauseSequence aSingleClauseSequence) {
        this.defaultCase(aSingleClauseSequence);
    }
    
    @Override
    public void caseASequenceClauseSequence(final ASequenceClauseSequence aSequenceClauseSequence) {
        this.defaultCase(aSequenceClauseSequence);
    }
    
    @Override
    public void caseABlankWhenZeroClauseClause(final ABlankWhenZeroClauseClause aBlankWhenZeroClauseClause) {
        this.defaultCase(aBlankWhenZeroClauseClause);
    }
    
    @Override
    public void caseADateFormatClauseClause(final ADateFormatClauseClause aDateFormatClauseClause) {
        this.defaultCase(aDateFormatClauseClause);
    }
    
    @Override
    public void caseAExternalClauseClause(final AExternalClauseClause aExternalClauseClause) {
        this.defaultCase(aExternalClauseClause);
    }
    
    @Override
    public void caseAGlobalClauseClause(final AGlobalClauseClause aGlobalClauseClause) {
        this.defaultCase(aGlobalClauseClause);
    }
    
    @Override
    public void caseAJustifiedClauseClause(final AJustifiedClauseClause aJustifiedClauseClause) {
        this.defaultCase(aJustifiedClauseClause);
    }
    
    @Override
    public void caseAOccursClauseClause(final AOccursClauseClause aOccursClauseClause) {
        this.defaultCase(aOccursClauseClause);
    }
    
    @Override
    public void caseAPictureClauseClause(final APictureClauseClause aPictureClauseClause) {
        this.defaultCase(aPictureClauseClause);
    }
    
    @Override
    public void caseASignClauseClause(final ASignClauseClause aSignClauseClause) {
        this.defaultCase(aSignClauseClause);
    }
    
    @Override
    public void caseASynchronizedClauseClause(final ASynchronizedClauseClause aSynchronizedClauseClause) {
        this.defaultCase(aSynchronizedClauseClause);
    }
    
    @Override
    public void caseAUsageClauseClause(final AUsageClauseClause aUsageClauseClause) {
        this.defaultCase(aUsageClauseClause);
    }
    
    @Override
    public void caseAValueClauseClause(final AValueClauseClause aValueClauseClause) {
        this.defaultCase(aValueClauseClause);
    }
    
    @Override
    public void caseABlankWhenZeroClause(final ABlankWhenZeroClause aBlankWhenZeroClause) {
        this.defaultCase(aBlankWhenZeroClause);
    }
    
    @Override
    public void caseADateFormatClause(final ADateFormatClause aDateFormatClause) {
        this.defaultCase(aDateFormatClause);
    }
    
    @Override
    public void caseAExternalClause(final AExternalClause aExternalClause) {
        this.defaultCase(aExternalClause);
    }
    
    @Override
    public void caseAGlobalClause(final AGlobalClause aGlobalClause) {
        this.defaultCase(aGlobalClause);
    }
    
    @Override
    public void caseAJustifiedClause(final AJustifiedClause aJustifiedClause) {
        this.defaultCase(aJustifiedClause);
    }
    
    @Override
    public void caseAOccursClause(final AOccursClause aOccursClause) {
        this.defaultCase(aOccursClause);
    }
    
    @Override
    public void caseAFixedOccursFixedOrVariable(final AFixedOccursFixedOrVariable aFixedOccursFixedOrVariable) {
        this.defaultCase(aFixedOccursFixedOrVariable);
    }
    
    @Override
    public void caseAVariableOccursFixedOrVariable(final AVariableOccursFixedOrVariable aVariableOccursFixedOrVariable) {
        this.defaultCase(aVariableOccursFixedOrVariable);
    }
    
    @Override
    public void caseAOccursTo(final AOccursTo aOccursTo) {
        this.defaultCase(aOccursTo);
    }
    
    @Override
    public void caseAAscendingOrDescendingKeyPhrase(final AAscendingOrDescendingKeyPhrase aAscendingOrDescendingKeyPhrase) {
        this.defaultCase(aAscendingOrDescendingKeyPhrase);
    }
    
    @Override
    public void caseAAscendingAscendingOrDescending(final AAscendingAscendingOrDescending aAscendingAscendingOrDescending) {
        this.defaultCase(aAscendingAscendingOrDescending);
    }
    
    @Override
    public void caseADescendingAscendingOrDescending(final ADescendingAscendingOrDescending aDescendingAscendingOrDescending) {
        this.defaultCase(aDescendingAscendingOrDescending);
    }
    
    @Override
    public void caseAIndexedByPhrase(final AIndexedByPhrase aIndexedByPhrase) {
        this.defaultCase(aIndexedByPhrase);
    }
    
    @Override
    public void caseAPictureClause(final APictureClause aPictureClause) {
        this.defaultCase(aPictureClause);
    }
    
    @Override
    public void caseASignClause(final ASignClause aSignClause) {
        this.defaultCase(aSignClause);
    }
    
    @Override
    public void caseASignIs(final ASignIs aSignIs) {
        this.defaultCase(aSignIs);
    }
    
    @Override
    public void caseALeadingLeadingOrTrailing(final ALeadingLeadingOrTrailing aLeadingLeadingOrTrailing) {
        this.defaultCase(aLeadingLeadingOrTrailing);
    }
    
    @Override
    public void caseATrailingLeadingOrTrailing(final ATrailingLeadingOrTrailing aTrailingLeadingOrTrailing) {
        this.defaultCase(aTrailingLeadingOrTrailing);
    }
    
    @Override
    public void caseASeparateCharacter(final ASeparateCharacter aSeparateCharacter) {
        this.defaultCase(aSeparateCharacter);
    }
    
    @Override
    public void caseASynchronizedClause(final ASynchronizedClause aSynchronizedClause) {
        this.defaultCase(aSynchronizedClause);
    }
    
    @Override
    public void caseALeftLeftOrRight(final ALeftLeftOrRight aLeftLeftOrRight) {
        this.defaultCase(aLeftLeftOrRight);
    }
    
    @Override
    public void caseARightLeftOrRight(final ARightLeftOrRight aRightLeftOrRight) {
        this.defaultCase(aRightLeftOrRight);
    }
    
    @Override
    public void caseAUsageClause(final AUsageClause aUsageClause) {
        this.defaultCase(aUsageClause);
    }
    
    @Override
    public void caseAUsageIs(final AUsageIs aUsageIs) {
        this.defaultCase(aUsageIs);
    }
    
    @Override
    public void caseABinaryUsagePhrase(final ABinaryUsagePhrase aBinaryUsagePhrase) {
        this.defaultCase(aBinaryUsagePhrase);
    }
    
    @Override
    public void caseACompUsagePhrase(final ACompUsagePhrase aCompUsagePhrase) {
        this.defaultCase(aCompUsagePhrase);
    }
    
    @Override
    public void caseAComp1UsagePhrase(final AComp1UsagePhrase aComp1UsagePhrase) {
        this.defaultCase(aComp1UsagePhrase);
    }
    
    @Override
    public void caseAComp2UsagePhrase(final AComp2UsagePhrase aComp2UsagePhrase) {
        this.defaultCase(aComp2UsagePhrase);
    }
    
    @Override
    public void caseAComp3UsagePhrase(final AComp3UsagePhrase aComp3UsagePhrase) {
        this.defaultCase(aComp3UsagePhrase);
    }
    
    @Override
    public void caseAComp4UsagePhrase(final AComp4UsagePhrase aComp4UsagePhrase) {
        this.defaultCase(aComp4UsagePhrase);
    }
    
    @Override
    public void caseAComp5UsagePhrase(final AComp5UsagePhrase aComp5UsagePhrase) {
        this.defaultCase(aComp5UsagePhrase);
    }
    
    @Override
    public void caseAComp6UsagePhrase(final AComp6UsagePhrase aComp6UsagePhrase) {
        this.defaultCase(aComp6UsagePhrase);
    }
    
    @Override
    public void caseADisplayUsagePhrase(final ADisplayUsagePhrase aDisplayUsagePhrase) {
        this.defaultCase(aDisplayUsagePhrase);
    }
    
    @Override
    public void caseADisplay1UsagePhrase(final ADisplay1UsagePhrase aDisplay1UsagePhrase) {
        this.defaultCase(aDisplay1UsagePhrase);
    }
    
    @Override
    public void caseAIndexUsagePhrase(final AIndexUsagePhrase aIndexUsagePhrase) {
        this.defaultCase(aIndexUsagePhrase);
    }
    
    @Override
    public void caseANationalUsagePhrase(final ANationalUsagePhrase aNationalUsagePhrase) {
        this.defaultCase(aNationalUsagePhrase);
    }
    
    @Override
    public void caseAObjectReferencePhraseUsagePhrase(final AObjectReferencePhraseUsagePhrase aObjectReferencePhraseUsagePhrase) {
        this.defaultCase(aObjectReferencePhraseUsagePhrase);
    }
    
    @Override
    public void caseAPackedDecimalUsagePhrase(final APackedDecimalUsagePhrase aPackedDecimalUsagePhrase) {
        this.defaultCase(aPackedDecimalUsagePhrase);
    }
    
    @Override
    public void caseAPointerUsagePhrase(final APointerUsagePhrase aPointerUsagePhrase) {
        this.defaultCase(aPointerUsagePhrase);
    }
    
    @Override
    public void caseAProcedurePointerUsagePhrase(final AProcedurePointerUsagePhrase aProcedurePointerUsagePhrase) {
        this.defaultCase(aProcedurePointerUsagePhrase);
    }
    
    @Override
    public void caseAFunctionPointerUsagePhrase(final AFunctionPointerUsagePhrase aFunctionPointerUsagePhrase) {
        this.defaultCase(aFunctionPointerUsagePhrase);
    }
    
    @Override
    public void caseAObjectReferencePhrase(final AObjectReferencePhrase aObjectReferencePhrase) {
        this.defaultCase(aObjectReferencePhrase);
    }
    
    @Override
    public void caseARenamesItem(final ARenamesItem aRenamesItem) {
        this.defaultCase(aRenamesItem);
    }
    
    @Override
    public void caseAThroughPhrase(final AThroughPhrase aThroughPhrase) {
        this.defaultCase(aThroughPhrase);
    }
    
    @Override
    public void caseAValueClause(final AValueClause aValueClause) {
        this.defaultCase(aValueClause);
    }
    
    @Override
    public void caseAValueItem(final AValueItem aValueItem) {
        this.defaultCase(aValueItem);
    }
    
    @Override
    public void caseAValueValueOrValues(final AValueValueOrValues aValueValueOrValues) {
        this.defaultCase(aValueValueOrValues);
    }
    
    @Override
    public void caseAValuesValueOrValues(final AValuesValueOrValues aValuesValueOrValues) {
        this.defaultCase(aValuesValueOrValues);
    }
    
    @Override
    public void caseASingleLiteralSequence(final ASingleLiteralSequence aSingleLiteralSequence) {
        this.defaultCase(aSingleLiteralSequence);
    }
    
    @Override
    public void caseASequenceLiteralSequence(final ASequenceLiteralSequence aSequenceLiteralSequence) {
        this.defaultCase(aSequenceLiteralSequence);
    }
    
    @Override
    public void caseAThroughSingleLiteralSequence(final AThroughSingleLiteralSequence aThroughSingleLiteralSequence) {
        this.defaultCase(aThroughSingleLiteralSequence);
    }
    
    @Override
    public void caseAThroughSequenceLiteralSequence(final AThroughSequenceLiteralSequence aThroughSequenceLiteralSequence) {
        this.defaultCase(aThroughSequenceLiteralSequence);
    }
    
    @Override
    public void caseAZerosLiteral(final AZerosLiteral aZerosLiteral) {
        this.defaultCase(aZerosLiteral);
    }
    
    @Override
    public void caseASpacesLiteral(final ASpacesLiteral aSpacesLiteral) {
        this.defaultCase(aSpacesLiteral);
    }
    
    @Override
    public void caseAHighValuesLiteral(final AHighValuesLiteral aHighValuesLiteral) {
        this.defaultCase(aHighValuesLiteral);
    }
    
    @Override
    public void caseALowValuesLiteral(final ALowValuesLiteral aLowValuesLiteral) {
        this.defaultCase(aLowValuesLiteral);
    }
    
    @Override
    public void caseAQuotesLiteral(final AQuotesLiteral aQuotesLiteral) {
        this.defaultCase(aQuotesLiteral);
    }
    
    @Override
    public void caseANullsLiteral(final ANullsLiteral aNullsLiteral) {
        this.defaultCase(aNullsLiteral);
    }
    
    @Override
    public void caseANumberLiteral(final ANumberLiteral aNumberLiteral) {
        this.defaultCase(aNumberLiteral);
    }
    
    @Override
    public void caseANumericLiteralLiteral(final ANumericLiteralLiteral aNumericLiteralLiteral) {
        this.defaultCase(aNumericLiteralLiteral);
    }
    
    @Override
    public void caseAAlphanumericLiteralLiteral(final AAlphanumericLiteralLiteral aAlphanumericLiteralLiteral) {
        this.defaultCase(aAlphanumericLiteralLiteral);
    }
    
    @Override
    public void caseASingleCharacterString(final ASingleCharacterString aSingleCharacterString) {
        this.defaultCase(aSingleCharacterString);
    }
    
    @Override
    public void caseASequenceCharacterString(final ASequenceCharacterString aSequenceCharacterString) {
        this.defaultCase(aSequenceCharacterString);
    }
    
    @Override
    public void caseADataNameCharacterSubstring(final ADataNameCharacterSubstring aDataNameCharacterSubstring) {
        this.defaultCase(aDataNameCharacterSubstring);
    }
    
    @Override
    public void caseAPlusCharacterSubstring(final APlusCharacterSubstring aPlusCharacterSubstring) {
        this.defaultCase(aPlusCharacterSubstring);
    }
    
    @Override
    public void caseAMinusCharacterSubstring(final AMinusCharacterSubstring aMinusCharacterSubstring) {
        this.defaultCase(aMinusCharacterSubstring);
    }
    
    @Override
    public void caseAStarCharacterSubstring(final AStarCharacterSubstring aStarCharacterSubstring) {
        this.defaultCase(aStarCharacterSubstring);
    }
    
    @Override
    public void caseASlashCharacterSubstring(final ASlashCharacterSubstring aSlashCharacterSubstring) {
        this.defaultCase(aSlashCharacterSubstring);
    }
    
    @Override
    public void caseADollarCharacterSubstring(final ADollarCharacterSubstring aDollarCharacterSubstring) {
        this.defaultCase(aDollarCharacterSubstring);
    }
    
    @Override
    public void caseACommaCharacterSubstring(final ACommaCharacterSubstring aCommaCharacterSubstring) {
        this.defaultCase(aCommaCharacterSubstring);
    }
    
    @Override
    public void caseANumberCharacterSubstring(final ANumberCharacterSubstring aNumberCharacterSubstring) {
        this.defaultCase(aNumberCharacterSubstring);
    }
    
    @Override
    public void caseANumericLiteralCharacterSubstring(final ANumericLiteralCharacterSubstring aNumericLiteralCharacterSubstring) {
        this.defaultCase(aNumericLiteralCharacterSubstring);
    }
    
    @Override
    public void caseABracketedNumberCharacterSubstring(final ABracketedNumberCharacterSubstring aBracketedNumberCharacterSubstring) {
        this.defaultCase(aBracketedNumberCharacterSubstring);
    }
    
    @Override
    public void caseADotMinusCharacterSubstring(final ADotMinusCharacterSubstring aDotMinusCharacterSubstring) {
        this.defaultCase(aDotMinusCharacterSubstring);
    }
    
    @Override
    public void caseADotPlusCharacterSubstring(final ADotPlusCharacterSubstring aDotPlusCharacterSubstring) {
        this.defaultCase(aDotPlusCharacterSubstring);
    }
    
    @Override
    public void caseADotZeeCharacterSubstring(final ADotZeeCharacterSubstring aDotZeeCharacterSubstring) {
        this.defaultCase(aDotZeeCharacterSubstring);
    }
    
    @Override
    public void caseABracketedNumber(final ABracketedNumber aBracketedNumber) {
        this.defaultCase(aBracketedNumber);
    }
    
    @Override
    public void caseANumberNot88Number(final ANumberNot88Number aNumberNot88Number) {
        this.defaultCase(aNumberNot88Number);
    }
    
    @Override
    public void caseANumber88Number(final ANumber88Number aNumber88Number) {
        this.defaultCase(aNumber88Number);
    }
    
    @Override
    public void caseTWhiteSpaces(final TWhiteSpaces tWhiteSpaces) {
        this.defaultCase(tWhiteSpaces);
    }
    
    @Override
    public void caseTComment(final TComment tComment) {
        this.defaultCase(tComment);
    }
    
    @Override
    public void caseTDot(final TDot tDot) {
        this.defaultCase(tDot);
    }
    
    @Override
    public void caseTComma(final TComma tComma) {
        this.defaultCase(tComma);
    }
    
    @Override
    public void caseTSlash(final TSlash tSlash) {
        this.defaultCase(tSlash);
    }
    
    @Override
    public void caseTPlus(final TPlus tPlus) {
        this.defaultCase(tPlus);
    }
    
    @Override
    public void caseTMinus(final TMinus tMinus) {
        this.defaultCase(tMinus);
    }
    
    @Override
    public void caseTStar(final TStar tStar) {
        this.defaultCase(tStar);
    }
    
    @Override
    public void caseTDollar(final TDollar tDollar) {
        this.defaultCase(tDollar);
    }
    
    @Override
    public void caseTLparen(final TLparen tLparen) {
        this.defaultCase(tLparen);
    }
    
    @Override
    public void caseTRparen(final TRparen tRparen) {
        this.defaultCase(tRparen);
    }
    
    @Override
    public void caseTNumber88(final TNumber88 tNumber88) {
        this.defaultCase(tNumber88);
    }
    
    @Override
    public void caseTNumberNot88(final TNumberNot88 tNumberNot88) {
        this.defaultCase(tNumberNot88);
    }
    
    @Override
    public void caseTAlphanumericLiteral(final TAlphanumericLiteral tAlphanumericLiteral) {
        this.defaultCase(tAlphanumericLiteral);
    }
    
    @Override
    public void caseTNumericLiteral(final TNumericLiteral tNumericLiteral) {
        this.defaultCase(tNumericLiteral);
    }
    
    @Override
    public void caseTDotZee(final TDotZee tDotZee) {
        this.defaultCase(tDotZee);
    }
    
    @Override
    public void caseTDotMinus(final TDotMinus tDotMinus) {
        this.defaultCase(tDotMinus);
    }
    
    @Override
    public void caseTDotPlus(final TDotPlus tDotPlus) {
        this.defaultCase(tDotPlus);
    }
    
    @Override
    public void caseTAll(final TAll tAll) {
        this.defaultCase(tAll);
    }
    
    @Override
    public void caseTAre(final TAre tAre) {
        this.defaultCase(tAre);
    }
    
    @Override
    public void caseTAscending(final TAscending tAscending) {
        this.defaultCase(tAscending);
    }
    
    @Override
    public void caseTBinary(final TBinary tBinary) {
        this.defaultCase(tBinary);
    }
    
    @Override
    public void caseTBlank(final TBlank tBlank) {
        this.defaultCase(tBlank);
    }
    
    @Override
    public void caseTBy(final TBy tBy) {
        this.defaultCase(tBy);
    }
    
    @Override
    public void caseTCharacter(final TCharacter tCharacter) {
        this.defaultCase(tCharacter);
    }
    
    @Override
    public void caseTComp(final TComp tComp) {
        this.defaultCase(tComp);
    }
    
    @Override
    public void caseTComp1(final TComp1 tComp1) {
        this.defaultCase(tComp1);
    }
    
    @Override
    public void caseTComp2(final TComp2 tComp2) {
        this.defaultCase(tComp2);
    }
    
    @Override
    public void caseTComp3(final TComp3 tComp3) {
        this.defaultCase(tComp3);
    }
    
    @Override
    public void caseTComp4(final TComp4 tComp4) {
        this.defaultCase(tComp4);
    }
    
    @Override
    public void caseTComp5(final TComp5 tComp5) {
        this.defaultCase(tComp5);
    }
    
    @Override
    public void caseTComp6(final TComp6 tComp6) {
        this.defaultCase(tComp6);
    }
    
    @Override
    public void caseTDate(final TDate tDate) {
        this.defaultCase(tDate);
    }
    
    @Override
    public void caseTDepending(final TDepending tDepending) {
        this.defaultCase(tDepending);
    }
    
    @Override
    public void caseTDescending(final TDescending tDescending) {
        this.defaultCase(tDescending);
    }
    
    @Override
    public void caseTDisplay(final TDisplay tDisplay) {
        this.defaultCase(tDisplay);
    }
    
    @Override
    public void caseTDisplay1(final TDisplay1 tDisplay1) {
        this.defaultCase(tDisplay1);
    }
    
    @Override
    public void caseTExternal(final TExternal tExternal) {
        this.defaultCase(tExternal);
    }
    
    @Override
    public void caseTFiller(final TFiller tFiller) {
        this.defaultCase(tFiller);
    }
    
    @Override
    public void caseTFormat(final TFormat tFormat) {
        this.defaultCase(tFormat);
    }
    
    @Override
    public void caseTFunctionPointer(final TFunctionPointer tFunctionPointer) {
        this.defaultCase(tFunctionPointer);
    }
    
    @Override
    public void caseTGlobal(final TGlobal tGlobal) {
        this.defaultCase(tGlobal);
    }
    
    @Override
    public void caseTHighValues(final THighValues tHighValues) {
        this.defaultCase(tHighValues);
    }
    
    @Override
    public void caseTIndex(final TIndex tIndex) {
        this.defaultCase(tIndex);
    }
    
    @Override
    public void caseTIndexed(final TIndexed tIndexed) {
        this.defaultCase(tIndexed);
    }
    
    @Override
    public void caseTIs(final TIs tIs) {
        this.defaultCase(tIs);
    }
    
    @Override
    public void caseTJustified(final TJustified tJustified) {
        this.defaultCase(tJustified);
    }
    
    @Override
    public void caseTKey(final TKey tKey) {
        this.defaultCase(tKey);
    }
    
    @Override
    public void caseTLeading(final TLeading tLeading) {
        this.defaultCase(tLeading);
    }
    
    @Override
    public void caseTLeft(final TLeft tLeft) {
        this.defaultCase(tLeft);
    }
    
    @Override
    public void caseTLowValues(final TLowValues tLowValues) {
        this.defaultCase(tLowValues);
    }
    
    @Override
    public void caseTNational(final TNational tNational) {
        this.defaultCase(tNational);
    }
    
    @Override
    public void caseTNative(final TNative tNative) {
        this.defaultCase(tNative);
    }
    
    @Override
    public void caseTNulls(final TNulls tNulls) {
        this.defaultCase(tNulls);
    }
    
    @Override
    public void caseTObject(final TObject tObject) {
        this.defaultCase(tObject);
    }
    
    @Override
    public void caseTOccurs(final TOccurs tOccurs) {
        this.defaultCase(tOccurs);
    }
    
    @Override
    public void caseTOn(final TOn tOn) {
        this.defaultCase(tOn);
    }
    
    @Override
    public void caseTPackedDecimal(final TPackedDecimal tPackedDecimal) {
        this.defaultCase(tPackedDecimal);
    }
    
    @Override
    public void caseTPicture(final TPicture tPicture) {
        this.defaultCase(tPicture);
    }
    
    @Override
    public void caseTPointer(final TPointer tPointer) {
        this.defaultCase(tPointer);
    }
    
    @Override
    public void caseTProcedurePointer(final TProcedurePointer tProcedurePointer) {
        this.defaultCase(tProcedurePointer);
    }
    
    @Override
    public void caseTQuotes(final TQuotes tQuotes) {
        this.defaultCase(tQuotes);
    }
    
    @Override
    public void caseTRedefines(final TRedefines tRedefines) {
        this.defaultCase(tRedefines);
    }
    
    @Override
    public void caseTReference(final TReference tReference) {
        this.defaultCase(tReference);
    }
    
    @Override
    public void caseTRenames(final TRenames tRenames) {
        this.defaultCase(tRenames);
    }
    
    @Override
    public void caseTRight(final TRight tRight) {
        this.defaultCase(tRight);
    }
    
    @Override
    public void caseTSeparate(final TSeparate tSeparate) {
        this.defaultCase(tSeparate);
    }
    
    @Override
    public void caseTSign(final TSign tSign) {
        this.defaultCase(tSign);
    }
    
    @Override
    public void caseTSpaces(final TSpaces tSpaces) {
        this.defaultCase(tSpaces);
    }
    
    @Override
    public void caseTSynchronized(final TSynchronized tSynchronized) {
        this.defaultCase(tSynchronized);
    }
    
    @Override
    public void caseTThrough(final TThrough tThrough) {
        this.defaultCase(tThrough);
    }
    
    @Override
    public void caseTTimes(final TTimes tTimes) {
        this.defaultCase(tTimes);
    }
    
    @Override
    public void caseTTo(final TTo tTo) {
        this.defaultCase(tTo);
    }
    
    @Override
    public void caseTTrailing(final TTrailing tTrailing) {
        this.defaultCase(tTrailing);
    }
    
    @Override
    public void caseTUsage(final TUsage tUsage) {
        this.defaultCase(tUsage);
    }
    
    @Override
    public void caseTValue(final TValue tValue) {
        this.defaultCase(tValue);
    }
    
    @Override
    public void caseTValues(final TValues tValues) {
        this.defaultCase(tValues);
    }
    
    @Override
    public void caseTWhen(final TWhen tWhen) {
        this.defaultCase(tWhen);
    }
    
    @Override
    public void caseTZeros(final TZeros tZeros) {
        this.defaultCase(tZeros);
    }
    
    @Override
    public void caseTDataName(final TDataName tDataName) {
        this.defaultCase(tDataName);
    }
    
    @Override
    public void caseTUnknown(final TUnknown tUnknown) {
        this.defaultCase(tUnknown);
    }
    
    @Override
    public void caseEOF(final EOF eof) {
        this.defaultCase(eof);
    }
    
    @Override
    public void caseInvalidToken(final InvalidToken invalidToken) {
        this.defaultCase(invalidToken);
    }
    
    public void defaultCase(final Node node) {
    }
}
