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
import net.sf.cb2xml.sablecc.node.Switch;

public interface Analysis extends Switch
{
    Object getIn(final Node p0);
    
    void setIn(final Node p0, final Object p1);
    
    Object getOut(final Node p0);
    
    void setOut(final Node p0, final Object p1);
    
    void caseStart(final Start p0);
    
    void caseARecordDescription(final ARecordDescription p0);
    
    void caseASingleGroupItem(final ASingleGroupItem p0);
    
    void caseASequenceGroupItem(final ASequenceGroupItem p0);
    
    void caseAItemElementaryItem(final AItemElementaryItem p0);
    
    void caseARenamesItemElementaryItem(final ARenamesItemElementaryItem p0);
    
    void caseAValueItemElementaryItem(final AValueItemElementaryItem p0);
    
    void caseAItem(final AItem p0);
    
    void caseADataNameDataNameOrFiller(final ADataNameDataNameOrFiller p0);
    
    void caseAFillerDataNameOrFiller(final AFillerDataNameOrFiller p0);
    
    void caseARedefinesClause(final ARedefinesClause p0);
    
    void caseASingleClauseSequence(final ASingleClauseSequence p0);
    
    void caseASequenceClauseSequence(final ASequenceClauseSequence p0);
    
    void caseABlankWhenZeroClauseClause(final ABlankWhenZeroClauseClause p0);
    
    void caseADateFormatClauseClause(final ADateFormatClauseClause p0);
    
    void caseAExternalClauseClause(final AExternalClauseClause p0);
    
    void caseAGlobalClauseClause(final AGlobalClauseClause p0);
    
    void caseAJustifiedClauseClause(final AJustifiedClauseClause p0);
    
    void caseAOccursClauseClause(final AOccursClauseClause p0);
    
    void caseAPictureClauseClause(final APictureClauseClause p0);
    
    void caseASignClauseClause(final ASignClauseClause p0);
    
    void caseASynchronizedClauseClause(final ASynchronizedClauseClause p0);
    
    void caseAUsageClauseClause(final AUsageClauseClause p0);
    
    void caseAValueClauseClause(final AValueClauseClause p0);
    
    void caseABlankWhenZeroClause(final ABlankWhenZeroClause p0);
    
    void caseADateFormatClause(final ADateFormatClause p0);
    
    void caseAExternalClause(final AExternalClause p0);
    
    void caseAGlobalClause(final AGlobalClause p0);
    
    void caseAJustifiedClause(final AJustifiedClause p0);
    
    void caseAOccursClause(final AOccursClause p0);
    
    void caseAFixedOccursFixedOrVariable(final AFixedOccursFixedOrVariable p0);
    
    void caseAVariableOccursFixedOrVariable(final AVariableOccursFixedOrVariable p0);
    
    void caseAOccursTo(final AOccursTo p0);
    
    void caseAAscendingOrDescendingKeyPhrase(final AAscendingOrDescendingKeyPhrase p0);
    
    void caseAAscendingAscendingOrDescending(final AAscendingAscendingOrDescending p0);
    
    void caseADescendingAscendingOrDescending(final ADescendingAscendingOrDescending p0);
    
    void caseAIndexedByPhrase(final AIndexedByPhrase p0);
    
    void caseAPictureClause(final APictureClause p0);
    
    void caseASignClause(final ASignClause p0);
    
    void caseASignIs(final ASignIs p0);
    
    void caseALeadingLeadingOrTrailing(final ALeadingLeadingOrTrailing p0);
    
    void caseATrailingLeadingOrTrailing(final ATrailingLeadingOrTrailing p0);
    
    void caseASeparateCharacter(final ASeparateCharacter p0);
    
    void caseASynchronizedClause(final ASynchronizedClause p0);
    
    void caseALeftLeftOrRight(final ALeftLeftOrRight p0);
    
    void caseARightLeftOrRight(final ARightLeftOrRight p0);
    
    void caseAUsageClause(final AUsageClause p0);
    
    void caseAUsageIs(final AUsageIs p0);
    
    void caseABinaryUsagePhrase(final ABinaryUsagePhrase p0);
    
    void caseACompUsagePhrase(final ACompUsagePhrase p0);
    
    void caseAComp1UsagePhrase(final AComp1UsagePhrase p0);
    
    void caseAComp2UsagePhrase(final AComp2UsagePhrase p0);
    
    void caseAComp3UsagePhrase(final AComp3UsagePhrase p0);
    
    void caseAComp4UsagePhrase(final AComp4UsagePhrase p0);
    
    void caseAComp5UsagePhrase(final AComp5UsagePhrase p0);
    
    void caseAComp6UsagePhrase(final AComp6UsagePhrase p0);
    
    void caseADisplayUsagePhrase(final ADisplayUsagePhrase p0);
    
    void caseADisplay1UsagePhrase(final ADisplay1UsagePhrase p0);
    
    void caseAIndexUsagePhrase(final AIndexUsagePhrase p0);
    
    void caseANationalUsagePhrase(final ANationalUsagePhrase p0);
    
    void caseAObjectReferencePhraseUsagePhrase(final AObjectReferencePhraseUsagePhrase p0);
    
    void caseAPackedDecimalUsagePhrase(final APackedDecimalUsagePhrase p0);
    
    void caseAPointerUsagePhrase(final APointerUsagePhrase p0);
    
    void caseAProcedurePointerUsagePhrase(final AProcedurePointerUsagePhrase p0);
    
    void caseAFunctionPointerUsagePhrase(final AFunctionPointerUsagePhrase p0);
    
    void caseAObjectReferencePhrase(final AObjectReferencePhrase p0);
    
    void caseARenamesItem(final ARenamesItem p0);
    
    void caseAThroughPhrase(final AThroughPhrase p0);
    
    void caseAValueClause(final AValueClause p0);
    
    void caseAValueItem(final AValueItem p0);
    
    void caseAValueValueOrValues(final AValueValueOrValues p0);
    
    void caseAValuesValueOrValues(final AValuesValueOrValues p0);
    
    void caseASingleLiteralSequence(final ASingleLiteralSequence p0);
    
    void caseASequenceLiteralSequence(final ASequenceLiteralSequence p0);
    
    void caseAThroughSingleLiteralSequence(final AThroughSingleLiteralSequence p0);
    
    void caseAThroughSequenceLiteralSequence(final AThroughSequenceLiteralSequence p0);
    
    void caseAZerosLiteral(final AZerosLiteral p0);
    
    void caseASpacesLiteral(final ASpacesLiteral p0);
    
    void caseAHighValuesLiteral(final AHighValuesLiteral p0);
    
    void caseALowValuesLiteral(final ALowValuesLiteral p0);
    
    void caseAQuotesLiteral(final AQuotesLiteral p0);
    
    void caseANullsLiteral(final ANullsLiteral p0);
    
    void caseANumberLiteral(final ANumberLiteral p0);
    
    void caseANumericLiteralLiteral(final ANumericLiteralLiteral p0);
    
    void caseAAlphanumericLiteralLiteral(final AAlphanumericLiteralLiteral p0);
    
    void caseASingleCharacterString(final ASingleCharacterString p0);
    
    void caseASequenceCharacterString(final ASequenceCharacterString p0);
    
    void caseADataNameCharacterSubstring(final ADataNameCharacterSubstring p0);
    
    void caseAPlusCharacterSubstring(final APlusCharacterSubstring p0);
    
    void caseAMinusCharacterSubstring(final AMinusCharacterSubstring p0);
    
    void caseAStarCharacterSubstring(final AStarCharacterSubstring p0);
    
    void caseASlashCharacterSubstring(final ASlashCharacterSubstring p0);
    
    void caseADollarCharacterSubstring(final ADollarCharacterSubstring p0);
    
    void caseACommaCharacterSubstring(final ACommaCharacterSubstring p0);
    
    void caseANumberCharacterSubstring(final ANumberCharacterSubstring p0);
    
    void caseANumericLiteralCharacterSubstring(final ANumericLiteralCharacterSubstring p0);
    
    void caseABracketedNumberCharacterSubstring(final ABracketedNumberCharacterSubstring p0);
    
    void caseADotMinusCharacterSubstring(final ADotMinusCharacterSubstring p0);
    
    void caseADotPlusCharacterSubstring(final ADotPlusCharacterSubstring p0);
    
    void caseADotZeeCharacterSubstring(final ADotZeeCharacterSubstring p0);
    
    void caseABracketedNumber(final ABracketedNumber p0);
    
    void caseANumberNot88Number(final ANumberNot88Number p0);
    
    void caseANumber88Number(final ANumber88Number p0);
    
    void caseTWhiteSpaces(final TWhiteSpaces p0);
    
    void caseTComment(final TComment p0);
    
    void caseTDot(final TDot p0);
    
    void caseTComma(final TComma p0);
    
    void caseTSlash(final TSlash p0);
    
    void caseTPlus(final TPlus p0);
    
    void caseTMinus(final TMinus p0);
    
    void caseTStar(final TStar p0);
    
    void caseTDollar(final TDollar p0);
    
    void caseTLparen(final TLparen p0);
    
    void caseTRparen(final TRparen p0);
    
    void caseTNumber88(final TNumber88 p0);
    
    void caseTNumberNot88(final TNumberNot88 p0);
    
    void caseTAlphanumericLiteral(final TAlphanumericLiteral p0);
    
    void caseTNumericLiteral(final TNumericLiteral p0);
    
    void caseTDotZee(final TDotZee p0);
    
    void caseTDotMinus(final TDotMinus p0);
    
    void caseTDotPlus(final TDotPlus p0);
    
    void caseTAll(final TAll p0);
    
    void caseTAre(final TAre p0);
    
    void caseTAscending(final TAscending p0);
    
    void caseTBinary(final TBinary p0);
    
    void caseTBlank(final TBlank p0);
    
    void caseTBy(final TBy p0);
    
    void caseTCharacter(final TCharacter p0);
    
    void caseTComp(final TComp p0);
    
    void caseTComp1(final TComp1 p0);
    
    void caseTComp2(final TComp2 p0);
    
    void caseTComp3(final TComp3 p0);
    
    void caseTComp4(final TComp4 p0);
    
    void caseTComp5(final TComp5 p0);
    
    void caseTComp6(final TComp6 p0);
    
    void caseTDate(final TDate p0);
    
    void caseTDepending(final TDepending p0);
    
    void caseTDescending(final TDescending p0);
    
    void caseTDisplay(final TDisplay p0);
    
    void caseTDisplay1(final TDisplay1 p0);
    
    void caseTExternal(final TExternal p0);
    
    void caseTFiller(final TFiller p0);
    
    void caseTFormat(final TFormat p0);
    
    void caseTFunctionPointer(final TFunctionPointer p0);
    
    void caseTGlobal(final TGlobal p0);
    
    void caseTHighValues(final THighValues p0);
    
    void caseTIndex(final TIndex p0);
    
    void caseTIndexed(final TIndexed p0);
    
    void caseTIs(final TIs p0);
    
    void caseTJustified(final TJustified p0);
    
    void caseTKey(final TKey p0);
    
    void caseTLeading(final TLeading p0);
    
    void caseTLeft(final TLeft p0);
    
    void caseTLowValues(final TLowValues p0);
    
    void caseTNational(final TNational p0);
    
    void caseTNative(final TNative p0);
    
    void caseTNulls(final TNulls p0);
    
    void caseTObject(final TObject p0);
    
    void caseTOccurs(final TOccurs p0);
    
    void caseTOn(final TOn p0);
    
    void caseTPackedDecimal(final TPackedDecimal p0);
    
    void caseTPicture(final TPicture p0);
    
    void caseTPointer(final TPointer p0);
    
    void caseTProcedurePointer(final TProcedurePointer p0);
    
    void caseTQuotes(final TQuotes p0);
    
    void caseTRedefines(final TRedefines p0);
    
    void caseTReference(final TReference p0);
    
    void caseTRenames(final TRenames p0);
    
    void caseTRight(final TRight p0);
    
    void caseTSeparate(final TSeparate p0);
    
    void caseTSign(final TSign p0);
    
    void caseTSpaces(final TSpaces p0);
    
    void caseTSynchronized(final TSynchronized p0);
    
    void caseTThrough(final TThrough p0);
    
    void caseTTimes(final TTimes p0);
    
    void caseTTo(final TTo p0);
    
    void caseTTrailing(final TTrailing p0);
    
    void caseTUsage(final TUsage p0);
    
    void caseTValue(final TValue p0);
    
    void caseTValues(final TValues p0);
    
    void caseTWhen(final TWhen p0);
    
    void caseTZeros(final TZeros p0);
    
    void caseTDataName(final TDataName p0);
    
    void caseTUnknown(final TUnknown p0);
    
    void caseEOF(final EOF p0);
    
    void caseInvalidToken(final InvalidToken p0);
}
