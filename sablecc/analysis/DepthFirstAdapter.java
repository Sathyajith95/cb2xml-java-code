// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.analysis;

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
import net.sf.cb2xml.sablecc.node.TDataName;
import net.sf.cb2xml.sablecc.node.AAscendingOrDescendingKeyPhrase;
import net.sf.cb2xml.sablecc.node.AOccursTo;
import net.sf.cb2xml.sablecc.node.AVariableOccursFixedOrVariable;
import net.sf.cb2xml.sablecc.node.AFixedOccursFixedOrVariable;
import java.util.Iterator;
import net.sf.cb2xml.sablecc.node.PIndexedByPhrase;
import java.util.Collection;
import net.sf.cb2xml.sablecc.node.PAscendingOrDescendingKeyPhrase;
import java.util.ArrayList;
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
import net.sf.cb2xml.sablecc.node.Switch;
import net.sf.cb2xml.sablecc.node.Node;
import net.sf.cb2xml.sablecc.node.Start;

public class DepthFirstAdapter extends AnalysisAdapter
{
    public void inStart(final Start start) {
        this.defaultIn(start);
    }
    
    public void outStart(final Start start) {
        this.defaultOut(start);
    }
    
    public void defaultIn(final Node node) {
    }
    
    public void defaultOut(final Node node) {
    }
    
    @Override
    public void caseStart(final Start start) {
        this.inStart(start);
        start.getPRecordDescription().apply(this);
        start.getEOF().apply(this);
        this.outStart(start);
    }
    
    public void inARecordDescription(final ARecordDescription aRecordDescription) {
        this.defaultIn(aRecordDescription);
    }
    
    public void outARecordDescription(final ARecordDescription aRecordDescription) {
        this.defaultOut(aRecordDescription);
    }
    
    @Override
    public void caseARecordDescription(final ARecordDescription aRecordDescription) {
        this.inARecordDescription(aRecordDescription);
        if (aRecordDescription.getGroupItem() != null) {
            aRecordDescription.getGroupItem().apply(this);
        }
        if (aRecordDescription.getDot() != null) {
            aRecordDescription.getDot().apply(this);
        }
        this.outARecordDescription(aRecordDescription);
    }
    
    public void inASingleGroupItem(final ASingleGroupItem aSingleGroupItem) {
        this.defaultIn(aSingleGroupItem);
    }
    
    public void outASingleGroupItem(final ASingleGroupItem aSingleGroupItem) {
        this.defaultOut(aSingleGroupItem);
    }
    
    @Override
    public void caseASingleGroupItem(final ASingleGroupItem aSingleGroupItem) {
        this.inASingleGroupItem(aSingleGroupItem);
        if (aSingleGroupItem.getElementaryItem() != null) {
            aSingleGroupItem.getElementaryItem().apply(this);
        }
        this.outASingleGroupItem(aSingleGroupItem);
    }
    
    public void inASequenceGroupItem(final ASequenceGroupItem aSequenceGroupItem) {
        this.defaultIn(aSequenceGroupItem);
    }
    
    public void outASequenceGroupItem(final ASequenceGroupItem aSequenceGroupItem) {
        this.defaultOut(aSequenceGroupItem);
    }
    
    @Override
    public void caseASequenceGroupItem(final ASequenceGroupItem aSequenceGroupItem) {
        this.inASequenceGroupItem(aSequenceGroupItem);
        if (aSequenceGroupItem.getGroupItem() != null) {
            aSequenceGroupItem.getGroupItem().apply(this);
        }
        if (aSequenceGroupItem.getDot() != null) {
            aSequenceGroupItem.getDot().apply(this);
        }
        if (aSequenceGroupItem.getElementaryItem() != null) {
            aSequenceGroupItem.getElementaryItem().apply(this);
        }
        this.outASequenceGroupItem(aSequenceGroupItem);
    }
    
    public void inAItemElementaryItem(final AItemElementaryItem aItemElementaryItem) {
        this.defaultIn(aItemElementaryItem);
    }
    
    public void outAItemElementaryItem(final AItemElementaryItem aItemElementaryItem) {
        this.defaultOut(aItemElementaryItem);
    }
    
    @Override
    public void caseAItemElementaryItem(final AItemElementaryItem aItemElementaryItem) {
        this.inAItemElementaryItem(aItemElementaryItem);
        if (aItemElementaryItem.getItem() != null) {
            aItemElementaryItem.getItem().apply(this);
        }
        this.outAItemElementaryItem(aItemElementaryItem);
    }
    
    public void inARenamesItemElementaryItem(final ARenamesItemElementaryItem aRenamesItemElementaryItem) {
        this.defaultIn(aRenamesItemElementaryItem);
    }
    
    public void outARenamesItemElementaryItem(final ARenamesItemElementaryItem aRenamesItemElementaryItem) {
        this.defaultOut(aRenamesItemElementaryItem);
    }
    
    @Override
    public void caseARenamesItemElementaryItem(final ARenamesItemElementaryItem aRenamesItemElementaryItem) {
        this.inARenamesItemElementaryItem(aRenamesItemElementaryItem);
        if (aRenamesItemElementaryItem.getRenamesItem() != null) {
            aRenamesItemElementaryItem.getRenamesItem().apply(this);
        }
        this.outARenamesItemElementaryItem(aRenamesItemElementaryItem);
    }
    
    public void inAValueItemElementaryItem(final AValueItemElementaryItem aValueItemElementaryItem) {
        this.defaultIn(aValueItemElementaryItem);
    }
    
    public void outAValueItemElementaryItem(final AValueItemElementaryItem aValueItemElementaryItem) {
        this.defaultOut(aValueItemElementaryItem);
    }
    
    @Override
    public void caseAValueItemElementaryItem(final AValueItemElementaryItem aValueItemElementaryItem) {
        this.inAValueItemElementaryItem(aValueItemElementaryItem);
        if (aValueItemElementaryItem.getValueItem() != null) {
            aValueItemElementaryItem.getValueItem().apply(this);
        }
        this.outAValueItemElementaryItem(aValueItemElementaryItem);
    }
    
    public void inAItem(final AItem aItem) {
        this.defaultIn(aItem);
    }
    
    public void outAItem(final AItem aItem) {
        this.defaultOut(aItem);
    }
    
    @Override
    public void caseAItem(final AItem aItem) {
        this.inAItem(aItem);
        if (aItem.getNumberNot88() != null) {
            aItem.getNumberNot88().apply(this);
        }
        if (aItem.getDataNameOrFiller() != null) {
            aItem.getDataNameOrFiller().apply(this);
        }
        if (aItem.getRedefinesClause() != null) {
            aItem.getRedefinesClause().apply(this);
        }
        if (aItem.getClauseSequence() != null) {
            aItem.getClauseSequence().apply(this);
        }
        this.outAItem(aItem);
    }
    
    public void inADataNameDataNameOrFiller(final ADataNameDataNameOrFiller aDataNameDataNameOrFiller) {
        this.defaultIn(aDataNameDataNameOrFiller);
    }
    
    public void outADataNameDataNameOrFiller(final ADataNameDataNameOrFiller aDataNameDataNameOrFiller) {
        this.defaultOut(aDataNameDataNameOrFiller);
    }
    
    @Override
    public void caseADataNameDataNameOrFiller(final ADataNameDataNameOrFiller aDataNameDataNameOrFiller) {
        this.inADataNameDataNameOrFiller(aDataNameDataNameOrFiller);
        if (aDataNameDataNameOrFiller.getDataName() != null) {
            aDataNameDataNameOrFiller.getDataName().apply(this);
        }
        this.outADataNameDataNameOrFiller(aDataNameDataNameOrFiller);
    }
    
    public void inAFillerDataNameOrFiller(final AFillerDataNameOrFiller aFillerDataNameOrFiller) {
        this.defaultIn(aFillerDataNameOrFiller);
    }
    
    public void outAFillerDataNameOrFiller(final AFillerDataNameOrFiller aFillerDataNameOrFiller) {
        this.defaultOut(aFillerDataNameOrFiller);
    }
    
    @Override
    public void caseAFillerDataNameOrFiller(final AFillerDataNameOrFiller aFillerDataNameOrFiller) {
        this.inAFillerDataNameOrFiller(aFillerDataNameOrFiller);
        if (aFillerDataNameOrFiller.getFiller() != null) {
            aFillerDataNameOrFiller.getFiller().apply(this);
        }
        this.outAFillerDataNameOrFiller(aFillerDataNameOrFiller);
    }
    
    public void inARedefinesClause(final ARedefinesClause aRedefinesClause) {
        this.defaultIn(aRedefinesClause);
    }
    
    public void outARedefinesClause(final ARedefinesClause aRedefinesClause) {
        this.defaultOut(aRedefinesClause);
    }
    
    @Override
    public void caseARedefinesClause(final ARedefinesClause aRedefinesClause) {
        this.inARedefinesClause(aRedefinesClause);
        if (aRedefinesClause.getRedefines() != null) {
            aRedefinesClause.getRedefines().apply(this);
        }
        if (aRedefinesClause.getDataName() != null) {
            aRedefinesClause.getDataName().apply(this);
        }
        this.outARedefinesClause(aRedefinesClause);
    }
    
    public void inASingleClauseSequence(final ASingleClauseSequence aSingleClauseSequence) {
        this.defaultIn(aSingleClauseSequence);
    }
    
    public void outASingleClauseSequence(final ASingleClauseSequence aSingleClauseSequence) {
        this.defaultOut(aSingleClauseSequence);
    }
    
    @Override
    public void caseASingleClauseSequence(final ASingleClauseSequence aSingleClauseSequence) {
        this.inASingleClauseSequence(aSingleClauseSequence);
        if (aSingleClauseSequence.getClause() != null) {
            aSingleClauseSequence.getClause().apply(this);
        }
        this.outASingleClauseSequence(aSingleClauseSequence);
    }
    
    public void inASequenceClauseSequence(final ASequenceClauseSequence aSequenceClauseSequence) {
        this.defaultIn(aSequenceClauseSequence);
    }
    
    public void outASequenceClauseSequence(final ASequenceClauseSequence aSequenceClauseSequence) {
        this.defaultOut(aSequenceClauseSequence);
    }
    
    @Override
    public void caseASequenceClauseSequence(final ASequenceClauseSequence aSequenceClauseSequence) {
        this.inASequenceClauseSequence(aSequenceClauseSequence);
        if (aSequenceClauseSequence.getClauseSequence() != null) {
            aSequenceClauseSequence.getClauseSequence().apply(this);
        }
        if (aSequenceClauseSequence.getClause() != null) {
            aSequenceClauseSequence.getClause().apply(this);
        }
        this.outASequenceClauseSequence(aSequenceClauseSequence);
    }
    
    public void inABlankWhenZeroClauseClause(final ABlankWhenZeroClauseClause aBlankWhenZeroClauseClause) {
        this.defaultIn(aBlankWhenZeroClauseClause);
    }
    
    public void outABlankWhenZeroClauseClause(final ABlankWhenZeroClauseClause aBlankWhenZeroClauseClause) {
        this.defaultOut(aBlankWhenZeroClauseClause);
    }
    
    @Override
    public void caseABlankWhenZeroClauseClause(final ABlankWhenZeroClauseClause aBlankWhenZeroClauseClause) {
        this.inABlankWhenZeroClauseClause(aBlankWhenZeroClauseClause);
        if (aBlankWhenZeroClauseClause.getBlankWhenZeroClause() != null) {
            aBlankWhenZeroClauseClause.getBlankWhenZeroClause().apply(this);
        }
        this.outABlankWhenZeroClauseClause(aBlankWhenZeroClauseClause);
    }
    
    public void inADateFormatClauseClause(final ADateFormatClauseClause aDateFormatClauseClause) {
        this.defaultIn(aDateFormatClauseClause);
    }
    
    public void outADateFormatClauseClause(final ADateFormatClauseClause aDateFormatClauseClause) {
        this.defaultOut(aDateFormatClauseClause);
    }
    
    @Override
    public void caseADateFormatClauseClause(final ADateFormatClauseClause aDateFormatClauseClause) {
        this.inADateFormatClauseClause(aDateFormatClauseClause);
        if (aDateFormatClauseClause.getDateFormatClause() != null) {
            aDateFormatClauseClause.getDateFormatClause().apply(this);
        }
        this.outADateFormatClauseClause(aDateFormatClauseClause);
    }
    
    public void inAExternalClauseClause(final AExternalClauseClause aExternalClauseClause) {
        this.defaultIn(aExternalClauseClause);
    }
    
    public void outAExternalClauseClause(final AExternalClauseClause aExternalClauseClause) {
        this.defaultOut(aExternalClauseClause);
    }
    
    @Override
    public void caseAExternalClauseClause(final AExternalClauseClause aExternalClauseClause) {
        this.inAExternalClauseClause(aExternalClauseClause);
        if (aExternalClauseClause.getExternalClause() != null) {
            aExternalClauseClause.getExternalClause().apply(this);
        }
        this.outAExternalClauseClause(aExternalClauseClause);
    }
    
    public void inAGlobalClauseClause(final AGlobalClauseClause aGlobalClauseClause) {
        this.defaultIn(aGlobalClauseClause);
    }
    
    public void outAGlobalClauseClause(final AGlobalClauseClause aGlobalClauseClause) {
        this.defaultOut(aGlobalClauseClause);
    }
    
    @Override
    public void caseAGlobalClauseClause(final AGlobalClauseClause aGlobalClauseClause) {
        this.inAGlobalClauseClause(aGlobalClauseClause);
        if (aGlobalClauseClause.getGlobalClause() != null) {
            aGlobalClauseClause.getGlobalClause().apply(this);
        }
        this.outAGlobalClauseClause(aGlobalClauseClause);
    }
    
    public void inAJustifiedClauseClause(final AJustifiedClauseClause aJustifiedClauseClause) {
        this.defaultIn(aJustifiedClauseClause);
    }
    
    public void outAJustifiedClauseClause(final AJustifiedClauseClause aJustifiedClauseClause) {
        this.defaultOut(aJustifiedClauseClause);
    }
    
    @Override
    public void caseAJustifiedClauseClause(final AJustifiedClauseClause aJustifiedClauseClause) {
        this.inAJustifiedClauseClause(aJustifiedClauseClause);
        if (aJustifiedClauseClause.getJustifiedClause() != null) {
            aJustifiedClauseClause.getJustifiedClause().apply(this);
        }
        this.outAJustifiedClauseClause(aJustifiedClauseClause);
    }
    
    public void inAOccursClauseClause(final AOccursClauseClause aOccursClauseClause) {
        this.defaultIn(aOccursClauseClause);
    }
    
    public void outAOccursClauseClause(final AOccursClauseClause aOccursClauseClause) {
        this.defaultOut(aOccursClauseClause);
    }
    
    @Override
    public void caseAOccursClauseClause(final AOccursClauseClause aOccursClauseClause) {
        this.inAOccursClauseClause(aOccursClauseClause);
        if (aOccursClauseClause.getOccursClause() != null) {
            aOccursClauseClause.getOccursClause().apply(this);
        }
        this.outAOccursClauseClause(aOccursClauseClause);
    }
    
    public void inAPictureClauseClause(final APictureClauseClause aPictureClauseClause) {
        this.defaultIn(aPictureClauseClause);
    }
    
    public void outAPictureClauseClause(final APictureClauseClause aPictureClauseClause) {
        this.defaultOut(aPictureClauseClause);
    }
    
    @Override
    public void caseAPictureClauseClause(final APictureClauseClause aPictureClauseClause) {
        this.inAPictureClauseClause(aPictureClauseClause);
        if (aPictureClauseClause.getPictureClause() != null) {
            aPictureClauseClause.getPictureClause().apply(this);
        }
        this.outAPictureClauseClause(aPictureClauseClause);
    }
    
    public void inASignClauseClause(final ASignClauseClause aSignClauseClause) {
        this.defaultIn(aSignClauseClause);
    }
    
    public void outASignClauseClause(final ASignClauseClause aSignClauseClause) {
        this.defaultOut(aSignClauseClause);
    }
    
    @Override
    public void caseASignClauseClause(final ASignClauseClause aSignClauseClause) {
        this.inASignClauseClause(aSignClauseClause);
        if (aSignClauseClause.getSignClause() != null) {
            aSignClauseClause.getSignClause().apply(this);
        }
        this.outASignClauseClause(aSignClauseClause);
    }
    
    public void inASynchronizedClauseClause(final ASynchronizedClauseClause aSynchronizedClauseClause) {
        this.defaultIn(aSynchronizedClauseClause);
    }
    
    public void outASynchronizedClauseClause(final ASynchronizedClauseClause aSynchronizedClauseClause) {
        this.defaultOut(aSynchronizedClauseClause);
    }
    
    @Override
    public void caseASynchronizedClauseClause(final ASynchronizedClauseClause aSynchronizedClauseClause) {
        this.inASynchronizedClauseClause(aSynchronizedClauseClause);
        if (aSynchronizedClauseClause.getSynchronizedClause() != null) {
            aSynchronizedClauseClause.getSynchronizedClause().apply(this);
        }
        this.outASynchronizedClauseClause(aSynchronizedClauseClause);
    }
    
    public void inAUsageClauseClause(final AUsageClauseClause aUsageClauseClause) {
        this.defaultIn(aUsageClauseClause);
    }
    
    public void outAUsageClauseClause(final AUsageClauseClause aUsageClauseClause) {
        this.defaultOut(aUsageClauseClause);
    }
    
    @Override
    public void caseAUsageClauseClause(final AUsageClauseClause aUsageClauseClause) {
        this.inAUsageClauseClause(aUsageClauseClause);
        if (aUsageClauseClause.getUsageClause() != null) {
            aUsageClauseClause.getUsageClause().apply(this);
        }
        this.outAUsageClauseClause(aUsageClauseClause);
    }
    
    public void inAValueClauseClause(final AValueClauseClause aValueClauseClause) {
        this.defaultIn(aValueClauseClause);
    }
    
    public void outAValueClauseClause(final AValueClauseClause aValueClauseClause) {
        this.defaultOut(aValueClauseClause);
    }
    
    @Override
    public void caseAValueClauseClause(final AValueClauseClause aValueClauseClause) {
        this.inAValueClauseClause(aValueClauseClause);
        if (aValueClauseClause.getValueClause() != null) {
            aValueClauseClause.getValueClause().apply(this);
        }
        this.outAValueClauseClause(aValueClauseClause);
    }
    
    public void inABlankWhenZeroClause(final ABlankWhenZeroClause aBlankWhenZeroClause) {
        this.defaultIn(aBlankWhenZeroClause);
    }
    
    public void outABlankWhenZeroClause(final ABlankWhenZeroClause aBlankWhenZeroClause) {
        this.defaultOut(aBlankWhenZeroClause);
    }
    
    @Override
    public void caseABlankWhenZeroClause(final ABlankWhenZeroClause aBlankWhenZeroClause) {
        this.inABlankWhenZeroClause(aBlankWhenZeroClause);
        if (aBlankWhenZeroClause.getBlank() != null) {
            aBlankWhenZeroClause.getBlank().apply(this);
        }
        if (aBlankWhenZeroClause.getWhen() != null) {
            aBlankWhenZeroClause.getWhen().apply(this);
        }
        if (aBlankWhenZeroClause.getZeros() != null) {
            aBlankWhenZeroClause.getZeros().apply(this);
        }
        this.outABlankWhenZeroClause(aBlankWhenZeroClause);
    }
    
    public void inADateFormatClause(final ADateFormatClause aDateFormatClause) {
        this.defaultIn(aDateFormatClause);
    }
    
    public void outADateFormatClause(final ADateFormatClause aDateFormatClause) {
        this.defaultOut(aDateFormatClause);
    }
    
    @Override
    public void caseADateFormatClause(final ADateFormatClause aDateFormatClause) {
        this.inADateFormatClause(aDateFormatClause);
        if (aDateFormatClause.getDate() != null) {
            aDateFormatClause.getDate().apply(this);
        }
        if (aDateFormatClause.getFormat() != null) {
            aDateFormatClause.getFormat().apply(this);
        }
        if (aDateFormatClause.getIs() != null) {
            aDateFormatClause.getIs().apply(this);
        }
        if (aDateFormatClause.getDataName() != null) {
            aDateFormatClause.getDataName().apply(this);
        }
        this.outADateFormatClause(aDateFormatClause);
    }
    
    public void inAExternalClause(final AExternalClause aExternalClause) {
        this.defaultIn(aExternalClause);
    }
    
    public void outAExternalClause(final AExternalClause aExternalClause) {
        this.defaultOut(aExternalClause);
    }
    
    @Override
    public void caseAExternalClause(final AExternalClause aExternalClause) {
        this.inAExternalClause(aExternalClause);
        if (aExternalClause.getExternal() != null) {
            aExternalClause.getExternal().apply(this);
        }
        this.outAExternalClause(aExternalClause);
    }
    
    public void inAGlobalClause(final AGlobalClause aGlobalClause) {
        this.defaultIn(aGlobalClause);
    }
    
    public void outAGlobalClause(final AGlobalClause aGlobalClause) {
        this.defaultOut(aGlobalClause);
    }
    
    @Override
    public void caseAGlobalClause(final AGlobalClause aGlobalClause) {
        this.inAGlobalClause(aGlobalClause);
        if (aGlobalClause.getGlobal() != null) {
            aGlobalClause.getGlobal().apply(this);
        }
        this.outAGlobalClause(aGlobalClause);
    }
    
    public void inAJustifiedClause(final AJustifiedClause aJustifiedClause) {
        this.defaultIn(aJustifiedClause);
    }
    
    public void outAJustifiedClause(final AJustifiedClause aJustifiedClause) {
        this.defaultOut(aJustifiedClause);
    }
    
    @Override
    public void caseAJustifiedClause(final AJustifiedClause aJustifiedClause) {
        this.inAJustifiedClause(aJustifiedClause);
        if (aJustifiedClause.getJustified() != null) {
            aJustifiedClause.getJustified().apply(this);
        }
        if (aJustifiedClause.getRight() != null) {
            aJustifiedClause.getRight().apply(this);
        }
        this.outAJustifiedClause(aJustifiedClause);
    }
    
    public void inAOccursClause(final AOccursClause aOccursClause) {
        this.defaultIn(aOccursClause);
    }
    
    public void outAOccursClause(final AOccursClause aOccursClause) {
        this.defaultOut(aOccursClause);
    }
    
    @Override
    public void caseAOccursClause(final AOccursClause aOccursClause) {
        this.inAOccursClause(aOccursClause);
        if (aOccursClause.getOccursFixedOrVariable() != null) {
            aOccursClause.getOccursFixedOrVariable().apply(this);
        }
        final Iterator<PAscendingOrDescendingKeyPhrase> iterator = new ArrayList<PAscendingOrDescendingKeyPhrase>(aOccursClause.getAscendingOrDescendingKeyPhrase()).iterator();
        while (iterator.hasNext()) {
            iterator.next().apply(this);
        }
        final Iterator<PIndexedByPhrase> iterator2 = new ArrayList<PIndexedByPhrase>(aOccursClause.getIndexedByPhrase()).iterator();
        while (iterator2.hasNext()) {
            iterator2.next().apply(this);
        }
        this.outAOccursClause(aOccursClause);
    }
    
    public void inAFixedOccursFixedOrVariable(final AFixedOccursFixedOrVariable aFixedOccursFixedOrVariable) {
        this.defaultIn(aFixedOccursFixedOrVariable);
    }
    
    public void outAFixedOccursFixedOrVariable(final AFixedOccursFixedOrVariable aFixedOccursFixedOrVariable) {
        this.defaultOut(aFixedOccursFixedOrVariable);
    }
    
    @Override
    public void caseAFixedOccursFixedOrVariable(final AFixedOccursFixedOrVariable aFixedOccursFixedOrVariable) {
        this.inAFixedOccursFixedOrVariable(aFixedOccursFixedOrVariable);
        if (aFixedOccursFixedOrVariable.getOccurs() != null) {
            aFixedOccursFixedOrVariable.getOccurs().apply(this);
        }
        if (aFixedOccursFixedOrVariable.getNumber() != null) {
            aFixedOccursFixedOrVariable.getNumber().apply(this);
        }
        if (aFixedOccursFixedOrVariable.getTimes() != null) {
            aFixedOccursFixedOrVariable.getTimes().apply(this);
        }
        this.outAFixedOccursFixedOrVariable(aFixedOccursFixedOrVariable);
    }
    
    public void inAVariableOccursFixedOrVariable(final AVariableOccursFixedOrVariable aVariableOccursFixedOrVariable) {
        this.defaultIn(aVariableOccursFixedOrVariable);
    }
    
    public void outAVariableOccursFixedOrVariable(final AVariableOccursFixedOrVariable aVariableOccursFixedOrVariable) {
        this.defaultOut(aVariableOccursFixedOrVariable);
    }
    
    @Override
    public void caseAVariableOccursFixedOrVariable(final AVariableOccursFixedOrVariable aVariableOccursFixedOrVariable) {
        this.inAVariableOccursFixedOrVariable(aVariableOccursFixedOrVariable);
        if (aVariableOccursFixedOrVariable.getOccurs() != null) {
            aVariableOccursFixedOrVariable.getOccurs().apply(this);
        }
        if (aVariableOccursFixedOrVariable.getOccursTo() != null) {
            aVariableOccursFixedOrVariable.getOccursTo().apply(this);
        }
        if (aVariableOccursFixedOrVariable.getNumber() != null) {
            aVariableOccursFixedOrVariable.getNumber().apply(this);
        }
        if (aVariableOccursFixedOrVariable.getTimes() != null) {
            aVariableOccursFixedOrVariable.getTimes().apply(this);
        }
        if (aVariableOccursFixedOrVariable.getDepending() != null) {
            aVariableOccursFixedOrVariable.getDepending().apply(this);
        }
        if (aVariableOccursFixedOrVariable.getOn() != null) {
            aVariableOccursFixedOrVariable.getOn().apply(this);
        }
        if (aVariableOccursFixedOrVariable.getDataName() != null) {
            aVariableOccursFixedOrVariable.getDataName().apply(this);
        }
        this.outAVariableOccursFixedOrVariable(aVariableOccursFixedOrVariable);
    }
    
    public void inAOccursTo(final AOccursTo aOccursTo) {
        this.defaultIn(aOccursTo);
    }
    
    public void outAOccursTo(final AOccursTo aOccursTo) {
        this.defaultOut(aOccursTo);
    }
    
    @Override
    public void caseAOccursTo(final AOccursTo aOccursTo) {
        this.inAOccursTo(aOccursTo);
        if (aOccursTo.getNumber() != null) {
            aOccursTo.getNumber().apply(this);
        }
        if (aOccursTo.getTo() != null) {
            aOccursTo.getTo().apply(this);
        }
        this.outAOccursTo(aOccursTo);
    }
    
    public void inAAscendingOrDescendingKeyPhrase(final AAscendingOrDescendingKeyPhrase aAscendingOrDescendingKeyPhrase) {
        this.defaultIn(aAscendingOrDescendingKeyPhrase);
    }
    
    public void outAAscendingOrDescendingKeyPhrase(final AAscendingOrDescendingKeyPhrase aAscendingOrDescendingKeyPhrase) {
        this.defaultOut(aAscendingOrDescendingKeyPhrase);
    }
    
    @Override
    public void caseAAscendingOrDescendingKeyPhrase(final AAscendingOrDescendingKeyPhrase aAscendingOrDescendingKeyPhrase) {
        this.inAAscendingOrDescendingKeyPhrase(aAscendingOrDescendingKeyPhrase);
        if (aAscendingOrDescendingKeyPhrase.getAscendingOrDescending() != null) {
            aAscendingOrDescendingKeyPhrase.getAscendingOrDescending().apply(this);
        }
        if (aAscendingOrDescendingKeyPhrase.getKey() != null) {
            aAscendingOrDescendingKeyPhrase.getKey().apply(this);
        }
        if (aAscendingOrDescendingKeyPhrase.getIs() != null) {
            aAscendingOrDescendingKeyPhrase.getIs().apply(this);
        }
        final Iterator<TDataName> iterator = new ArrayList<TDataName>(aAscendingOrDescendingKeyPhrase.getDataName()).iterator();
        while (iterator.hasNext()) {
            iterator.next().apply(this);
        }
        this.outAAscendingOrDescendingKeyPhrase(aAscendingOrDescendingKeyPhrase);
    }
    
    public void inAAscendingAscendingOrDescending(final AAscendingAscendingOrDescending aAscendingAscendingOrDescending) {
        this.defaultIn(aAscendingAscendingOrDescending);
    }
    
    public void outAAscendingAscendingOrDescending(final AAscendingAscendingOrDescending aAscendingAscendingOrDescending) {
        this.defaultOut(aAscendingAscendingOrDescending);
    }
    
    @Override
    public void caseAAscendingAscendingOrDescending(final AAscendingAscendingOrDescending aAscendingAscendingOrDescending) {
        this.inAAscendingAscendingOrDescending(aAscendingAscendingOrDescending);
        if (aAscendingAscendingOrDescending.getAscending() != null) {
            aAscendingAscendingOrDescending.getAscending().apply(this);
        }
        this.outAAscendingAscendingOrDescending(aAscendingAscendingOrDescending);
    }
    
    public void inADescendingAscendingOrDescending(final ADescendingAscendingOrDescending aDescendingAscendingOrDescending) {
        this.defaultIn(aDescendingAscendingOrDescending);
    }
    
    public void outADescendingAscendingOrDescending(final ADescendingAscendingOrDescending aDescendingAscendingOrDescending) {
        this.defaultOut(aDescendingAscendingOrDescending);
    }
    
    @Override
    public void caseADescendingAscendingOrDescending(final ADescendingAscendingOrDescending aDescendingAscendingOrDescending) {
        this.inADescendingAscendingOrDescending(aDescendingAscendingOrDescending);
        if (aDescendingAscendingOrDescending.getDescending() != null) {
            aDescendingAscendingOrDescending.getDescending().apply(this);
        }
        this.outADescendingAscendingOrDescending(aDescendingAscendingOrDescending);
    }
    
    public void inAIndexedByPhrase(final AIndexedByPhrase aIndexedByPhrase) {
        this.defaultIn(aIndexedByPhrase);
    }
    
    public void outAIndexedByPhrase(final AIndexedByPhrase aIndexedByPhrase) {
        this.defaultOut(aIndexedByPhrase);
    }
    
    @Override
    public void caseAIndexedByPhrase(final AIndexedByPhrase aIndexedByPhrase) {
        this.inAIndexedByPhrase(aIndexedByPhrase);
        if (aIndexedByPhrase.getIndexed() != null) {
            aIndexedByPhrase.getIndexed().apply(this);
        }
        if (aIndexedByPhrase.getBy() != null) {
            aIndexedByPhrase.getBy().apply(this);
        }
        final Iterator<TDataName> iterator = new ArrayList<TDataName>(aIndexedByPhrase.getDataName()).iterator();
        while (iterator.hasNext()) {
            iterator.next().apply(this);
        }
        this.outAIndexedByPhrase(aIndexedByPhrase);
    }
    
    public void inAPictureClause(final APictureClause aPictureClause) {
        this.defaultIn(aPictureClause);
    }
    
    public void outAPictureClause(final APictureClause aPictureClause) {
        this.defaultOut(aPictureClause);
    }
    
    @Override
    public void caseAPictureClause(final APictureClause aPictureClause) {
        this.inAPictureClause(aPictureClause);
        if (aPictureClause.getPicture() != null) {
            aPictureClause.getPicture().apply(this);
        }
        if (aPictureClause.getIs() != null) {
            aPictureClause.getIs().apply(this);
        }
        if (aPictureClause.getCharacterString() != null) {
            aPictureClause.getCharacterString().apply(this);
        }
        this.outAPictureClause(aPictureClause);
    }
    
    public void inASignClause(final ASignClause aSignClause) {
        this.defaultIn(aSignClause);
    }
    
    public void outASignClause(final ASignClause aSignClause) {
        this.defaultOut(aSignClause);
    }
    
    @Override
    public void caseASignClause(final ASignClause aSignClause) {
        this.inASignClause(aSignClause);
        if (aSignClause.getSignIs() != null) {
            aSignClause.getSignIs().apply(this);
        }
        if (aSignClause.getLeadingOrTrailing() != null) {
            aSignClause.getLeadingOrTrailing().apply(this);
        }
        if (aSignClause.getSeparateCharacter() != null) {
            aSignClause.getSeparateCharacter().apply(this);
        }
        this.outASignClause(aSignClause);
    }
    
    public void inASignIs(final ASignIs aSignIs) {
        this.defaultIn(aSignIs);
    }
    
    public void outASignIs(final ASignIs aSignIs) {
        this.defaultOut(aSignIs);
    }
    
    @Override
    public void caseASignIs(final ASignIs aSignIs) {
        this.inASignIs(aSignIs);
        if (aSignIs.getSign() != null) {
            aSignIs.getSign().apply(this);
        }
        if (aSignIs.getIs() != null) {
            aSignIs.getIs().apply(this);
        }
        this.outASignIs(aSignIs);
    }
    
    public void inALeadingLeadingOrTrailing(final ALeadingLeadingOrTrailing aLeadingLeadingOrTrailing) {
        this.defaultIn(aLeadingLeadingOrTrailing);
    }
    
    public void outALeadingLeadingOrTrailing(final ALeadingLeadingOrTrailing aLeadingLeadingOrTrailing) {
        this.defaultOut(aLeadingLeadingOrTrailing);
    }
    
    @Override
    public void caseALeadingLeadingOrTrailing(final ALeadingLeadingOrTrailing aLeadingLeadingOrTrailing) {
        this.inALeadingLeadingOrTrailing(aLeadingLeadingOrTrailing);
        if (aLeadingLeadingOrTrailing.getLeading() != null) {
            aLeadingLeadingOrTrailing.getLeading().apply(this);
        }
        this.outALeadingLeadingOrTrailing(aLeadingLeadingOrTrailing);
    }
    
    public void inATrailingLeadingOrTrailing(final ATrailingLeadingOrTrailing aTrailingLeadingOrTrailing) {
        this.defaultIn(aTrailingLeadingOrTrailing);
    }
    
    public void outATrailingLeadingOrTrailing(final ATrailingLeadingOrTrailing aTrailingLeadingOrTrailing) {
        this.defaultOut(aTrailingLeadingOrTrailing);
    }
    
    @Override
    public void caseATrailingLeadingOrTrailing(final ATrailingLeadingOrTrailing aTrailingLeadingOrTrailing) {
        this.inATrailingLeadingOrTrailing(aTrailingLeadingOrTrailing);
        if (aTrailingLeadingOrTrailing.getTrailing() != null) {
            aTrailingLeadingOrTrailing.getTrailing().apply(this);
        }
        this.outATrailingLeadingOrTrailing(aTrailingLeadingOrTrailing);
    }
    
    public void inASeparateCharacter(final ASeparateCharacter aSeparateCharacter) {
        this.defaultIn(aSeparateCharacter);
    }
    
    public void outASeparateCharacter(final ASeparateCharacter aSeparateCharacter) {
        this.defaultOut(aSeparateCharacter);
    }
    
    @Override
    public void caseASeparateCharacter(final ASeparateCharacter aSeparateCharacter) {
        this.inASeparateCharacter(aSeparateCharacter);
        if (aSeparateCharacter.getSeparate() != null) {
            aSeparateCharacter.getSeparate().apply(this);
        }
        if (aSeparateCharacter.getCharacter() != null) {
            aSeparateCharacter.getCharacter().apply(this);
        }
        this.outASeparateCharacter(aSeparateCharacter);
    }
    
    public void inASynchronizedClause(final ASynchronizedClause aSynchronizedClause) {
        this.defaultIn(aSynchronizedClause);
    }
    
    public void outASynchronizedClause(final ASynchronizedClause aSynchronizedClause) {
        this.defaultOut(aSynchronizedClause);
    }
    
    @Override
    public void caseASynchronizedClause(final ASynchronizedClause aSynchronizedClause) {
        this.inASynchronizedClause(aSynchronizedClause);
        if (aSynchronizedClause.getSynchronized() != null) {
            aSynchronizedClause.getSynchronized().apply(this);
        }
        if (aSynchronizedClause.getLeftOrRight() != null) {
            aSynchronizedClause.getLeftOrRight().apply(this);
        }
        this.outASynchronizedClause(aSynchronizedClause);
    }
    
    public void inALeftLeftOrRight(final ALeftLeftOrRight aLeftLeftOrRight) {
        this.defaultIn(aLeftLeftOrRight);
    }
    
    public void outALeftLeftOrRight(final ALeftLeftOrRight aLeftLeftOrRight) {
        this.defaultOut(aLeftLeftOrRight);
    }
    
    @Override
    public void caseALeftLeftOrRight(final ALeftLeftOrRight aLeftLeftOrRight) {
        this.inALeftLeftOrRight(aLeftLeftOrRight);
        if (aLeftLeftOrRight.getLeft() != null) {
            aLeftLeftOrRight.getLeft().apply(this);
        }
        this.outALeftLeftOrRight(aLeftLeftOrRight);
    }
    
    public void inARightLeftOrRight(final ARightLeftOrRight aRightLeftOrRight) {
        this.defaultIn(aRightLeftOrRight);
    }
    
    public void outARightLeftOrRight(final ARightLeftOrRight aRightLeftOrRight) {
        this.defaultOut(aRightLeftOrRight);
    }
    
    @Override
    public void caseARightLeftOrRight(final ARightLeftOrRight aRightLeftOrRight) {
        this.inARightLeftOrRight(aRightLeftOrRight);
        if (aRightLeftOrRight.getRight() != null) {
            aRightLeftOrRight.getRight().apply(this);
        }
        this.outARightLeftOrRight(aRightLeftOrRight);
    }
    
    public void inAUsageClause(final AUsageClause aUsageClause) {
        this.defaultIn(aUsageClause);
    }
    
    public void outAUsageClause(final AUsageClause aUsageClause) {
        this.defaultOut(aUsageClause);
    }
    
    @Override
    public void caseAUsageClause(final AUsageClause aUsageClause) {
        this.inAUsageClause(aUsageClause);
        if (aUsageClause.getUsageIs() != null) {
            aUsageClause.getUsageIs().apply(this);
        }
        if (aUsageClause.getUsagePhrase() != null) {
            aUsageClause.getUsagePhrase().apply(this);
        }
        this.outAUsageClause(aUsageClause);
    }
    
    public void inAUsageIs(final AUsageIs aUsageIs) {
        this.defaultIn(aUsageIs);
    }
    
    public void outAUsageIs(final AUsageIs aUsageIs) {
        this.defaultOut(aUsageIs);
    }
    
    @Override
    public void caseAUsageIs(final AUsageIs aUsageIs) {
        this.inAUsageIs(aUsageIs);
        if (aUsageIs.getUsage() != null) {
            aUsageIs.getUsage().apply(this);
        }
        if (aUsageIs.getIs() != null) {
            aUsageIs.getIs().apply(this);
        }
        this.outAUsageIs(aUsageIs);
    }
    
    public void inABinaryUsagePhrase(final ABinaryUsagePhrase aBinaryUsagePhrase) {
        this.defaultIn(aBinaryUsagePhrase);
    }
    
    public void outABinaryUsagePhrase(final ABinaryUsagePhrase aBinaryUsagePhrase) {
        this.defaultOut(aBinaryUsagePhrase);
    }
    
    @Override
    public void caseABinaryUsagePhrase(final ABinaryUsagePhrase aBinaryUsagePhrase) {
        this.inABinaryUsagePhrase(aBinaryUsagePhrase);
        if (aBinaryUsagePhrase.getBinary() != null) {
            aBinaryUsagePhrase.getBinary().apply(this);
        }
        if (aBinaryUsagePhrase.getNative() != null) {
            aBinaryUsagePhrase.getNative().apply(this);
        }
        this.outABinaryUsagePhrase(aBinaryUsagePhrase);
    }
    
    public void inACompUsagePhrase(final ACompUsagePhrase aCompUsagePhrase) {
        this.defaultIn(aCompUsagePhrase);
    }
    
    public void outACompUsagePhrase(final ACompUsagePhrase aCompUsagePhrase) {
        this.defaultOut(aCompUsagePhrase);
    }
    
    @Override
    public void caseACompUsagePhrase(final ACompUsagePhrase aCompUsagePhrase) {
        this.inACompUsagePhrase(aCompUsagePhrase);
        if (aCompUsagePhrase.getComp() != null) {
            aCompUsagePhrase.getComp().apply(this);
        }
        this.outACompUsagePhrase(aCompUsagePhrase);
    }
    
    public void inAComp1UsagePhrase(final AComp1UsagePhrase aComp1UsagePhrase) {
        this.defaultIn(aComp1UsagePhrase);
    }
    
    public void outAComp1UsagePhrase(final AComp1UsagePhrase aComp1UsagePhrase) {
        this.defaultOut(aComp1UsagePhrase);
    }
    
    @Override
    public void caseAComp1UsagePhrase(final AComp1UsagePhrase aComp1UsagePhrase) {
        this.inAComp1UsagePhrase(aComp1UsagePhrase);
        if (aComp1UsagePhrase.getComp1() != null) {
            aComp1UsagePhrase.getComp1().apply(this);
        }
        if (aComp1UsagePhrase.getNative() != null) {
            aComp1UsagePhrase.getNative().apply(this);
        }
        this.outAComp1UsagePhrase(aComp1UsagePhrase);
    }
    
    public void inAComp2UsagePhrase(final AComp2UsagePhrase aComp2UsagePhrase) {
        this.defaultIn(aComp2UsagePhrase);
    }
    
    public void outAComp2UsagePhrase(final AComp2UsagePhrase aComp2UsagePhrase) {
        this.defaultOut(aComp2UsagePhrase);
    }
    
    @Override
    public void caseAComp2UsagePhrase(final AComp2UsagePhrase aComp2UsagePhrase) {
        this.inAComp2UsagePhrase(aComp2UsagePhrase);
        if (aComp2UsagePhrase.getComp2() != null) {
            aComp2UsagePhrase.getComp2().apply(this);
        }
        if (aComp2UsagePhrase.getNative() != null) {
            aComp2UsagePhrase.getNative().apply(this);
        }
        this.outAComp2UsagePhrase(aComp2UsagePhrase);
    }
    
    public void inAComp3UsagePhrase(final AComp3UsagePhrase aComp3UsagePhrase) {
        this.defaultIn(aComp3UsagePhrase);
    }
    
    public void outAComp3UsagePhrase(final AComp3UsagePhrase aComp3UsagePhrase) {
        this.defaultOut(aComp3UsagePhrase);
    }
    
    @Override
    public void caseAComp3UsagePhrase(final AComp3UsagePhrase aComp3UsagePhrase) {
        this.inAComp3UsagePhrase(aComp3UsagePhrase);
        if (aComp3UsagePhrase.getComp3() != null) {
            aComp3UsagePhrase.getComp3().apply(this);
        }
        this.outAComp3UsagePhrase(aComp3UsagePhrase);
    }
    
    public void inAComp4UsagePhrase(final AComp4UsagePhrase aComp4UsagePhrase) {
        this.defaultIn(aComp4UsagePhrase);
    }
    
    public void outAComp4UsagePhrase(final AComp4UsagePhrase aComp4UsagePhrase) {
        this.defaultOut(aComp4UsagePhrase);
    }
    
    @Override
    public void caseAComp4UsagePhrase(final AComp4UsagePhrase aComp4UsagePhrase) {
        this.inAComp4UsagePhrase(aComp4UsagePhrase);
        if (aComp4UsagePhrase.getComp4() != null) {
            aComp4UsagePhrase.getComp4().apply(this);
        }
        if (aComp4UsagePhrase.getNative() != null) {
            aComp4UsagePhrase.getNative().apply(this);
        }
        this.outAComp4UsagePhrase(aComp4UsagePhrase);
    }
    
    public void inAComp5UsagePhrase(final AComp5UsagePhrase aComp5UsagePhrase) {
        this.defaultIn(aComp5UsagePhrase);
    }
    
    public void outAComp5UsagePhrase(final AComp5UsagePhrase aComp5UsagePhrase) {
        this.defaultOut(aComp5UsagePhrase);
    }
    
    @Override
    public void caseAComp5UsagePhrase(final AComp5UsagePhrase aComp5UsagePhrase) {
        this.inAComp5UsagePhrase(aComp5UsagePhrase);
        if (aComp5UsagePhrase.getComp5() != null) {
            aComp5UsagePhrase.getComp5().apply(this);
        }
        this.outAComp5UsagePhrase(aComp5UsagePhrase);
    }
    
    public void inAComp6UsagePhrase(final AComp6UsagePhrase aComp6UsagePhrase) {
        this.defaultIn(aComp6UsagePhrase);
    }
    
    public void outAComp6UsagePhrase(final AComp6UsagePhrase aComp6UsagePhrase) {
        this.defaultOut(aComp6UsagePhrase);
    }
    
    @Override
    public void caseAComp6UsagePhrase(final AComp6UsagePhrase aComp6UsagePhrase) {
        this.inAComp6UsagePhrase(aComp6UsagePhrase);
        if (aComp6UsagePhrase.getComp6() != null) {
            aComp6UsagePhrase.getComp6().apply(this);
        }
        this.outAComp6UsagePhrase(aComp6UsagePhrase);
    }
    
    public void inADisplayUsagePhrase(final ADisplayUsagePhrase aDisplayUsagePhrase) {
        this.defaultIn(aDisplayUsagePhrase);
    }
    
    public void outADisplayUsagePhrase(final ADisplayUsagePhrase aDisplayUsagePhrase) {
        this.defaultOut(aDisplayUsagePhrase);
    }
    
    @Override
    public void caseADisplayUsagePhrase(final ADisplayUsagePhrase aDisplayUsagePhrase) {
        this.inADisplayUsagePhrase(aDisplayUsagePhrase);
        if (aDisplayUsagePhrase.getDisplay() != null) {
            aDisplayUsagePhrase.getDisplay().apply(this);
        }
        if (aDisplayUsagePhrase.getNative() != null) {
            aDisplayUsagePhrase.getNative().apply(this);
        }
        this.outADisplayUsagePhrase(aDisplayUsagePhrase);
    }
    
    public void inADisplay1UsagePhrase(final ADisplay1UsagePhrase aDisplay1UsagePhrase) {
        this.defaultIn(aDisplay1UsagePhrase);
    }
    
    public void outADisplay1UsagePhrase(final ADisplay1UsagePhrase aDisplay1UsagePhrase) {
        this.defaultOut(aDisplay1UsagePhrase);
    }
    
    @Override
    public void caseADisplay1UsagePhrase(final ADisplay1UsagePhrase aDisplay1UsagePhrase) {
        this.inADisplay1UsagePhrase(aDisplay1UsagePhrase);
        if (aDisplay1UsagePhrase.getDisplay1() != null) {
            aDisplay1UsagePhrase.getDisplay1().apply(this);
        }
        if (aDisplay1UsagePhrase.getNative() != null) {
            aDisplay1UsagePhrase.getNative().apply(this);
        }
        this.outADisplay1UsagePhrase(aDisplay1UsagePhrase);
    }
    
    public void inAIndexUsagePhrase(final AIndexUsagePhrase aIndexUsagePhrase) {
        this.defaultIn(aIndexUsagePhrase);
    }
    
    public void outAIndexUsagePhrase(final AIndexUsagePhrase aIndexUsagePhrase) {
        this.defaultOut(aIndexUsagePhrase);
    }
    
    @Override
    public void caseAIndexUsagePhrase(final AIndexUsagePhrase aIndexUsagePhrase) {
        this.inAIndexUsagePhrase(aIndexUsagePhrase);
        if (aIndexUsagePhrase.getIndex() != null) {
            aIndexUsagePhrase.getIndex().apply(this);
        }
        this.outAIndexUsagePhrase(aIndexUsagePhrase);
    }
    
    public void inANationalUsagePhrase(final ANationalUsagePhrase aNationalUsagePhrase) {
        this.defaultIn(aNationalUsagePhrase);
    }
    
    public void outANationalUsagePhrase(final ANationalUsagePhrase aNationalUsagePhrase) {
        this.defaultOut(aNationalUsagePhrase);
    }
    
    @Override
    public void caseANationalUsagePhrase(final ANationalUsagePhrase aNationalUsagePhrase) {
        this.inANationalUsagePhrase(aNationalUsagePhrase);
        if (aNationalUsagePhrase.getNational() != null) {
            aNationalUsagePhrase.getNational().apply(this);
        }
        this.outANationalUsagePhrase(aNationalUsagePhrase);
    }
    
    public void inAObjectReferencePhraseUsagePhrase(final AObjectReferencePhraseUsagePhrase aObjectReferencePhraseUsagePhrase) {
        this.defaultIn(aObjectReferencePhraseUsagePhrase);
    }
    
    public void outAObjectReferencePhraseUsagePhrase(final AObjectReferencePhraseUsagePhrase aObjectReferencePhraseUsagePhrase) {
        this.defaultOut(aObjectReferencePhraseUsagePhrase);
    }
    
    @Override
    public void caseAObjectReferencePhraseUsagePhrase(final AObjectReferencePhraseUsagePhrase aObjectReferencePhraseUsagePhrase) {
        this.inAObjectReferencePhraseUsagePhrase(aObjectReferencePhraseUsagePhrase);
        if (aObjectReferencePhraseUsagePhrase.getObjectReferencePhrase() != null) {
            aObjectReferencePhraseUsagePhrase.getObjectReferencePhrase().apply(this);
        }
        this.outAObjectReferencePhraseUsagePhrase(aObjectReferencePhraseUsagePhrase);
    }
    
    public void inAPackedDecimalUsagePhrase(final APackedDecimalUsagePhrase aPackedDecimalUsagePhrase) {
        this.defaultIn(aPackedDecimalUsagePhrase);
    }
    
    public void outAPackedDecimalUsagePhrase(final APackedDecimalUsagePhrase aPackedDecimalUsagePhrase) {
        this.defaultOut(aPackedDecimalUsagePhrase);
    }
    
    @Override
    public void caseAPackedDecimalUsagePhrase(final APackedDecimalUsagePhrase aPackedDecimalUsagePhrase) {
        this.inAPackedDecimalUsagePhrase(aPackedDecimalUsagePhrase);
        if (aPackedDecimalUsagePhrase.getPackedDecimal() != null) {
            aPackedDecimalUsagePhrase.getPackedDecimal().apply(this);
        }
        this.outAPackedDecimalUsagePhrase(aPackedDecimalUsagePhrase);
    }
    
    public void inAPointerUsagePhrase(final APointerUsagePhrase aPointerUsagePhrase) {
        this.defaultIn(aPointerUsagePhrase);
    }
    
    public void outAPointerUsagePhrase(final APointerUsagePhrase aPointerUsagePhrase) {
        this.defaultOut(aPointerUsagePhrase);
    }
    
    @Override
    public void caseAPointerUsagePhrase(final APointerUsagePhrase aPointerUsagePhrase) {
        this.inAPointerUsagePhrase(aPointerUsagePhrase);
        if (aPointerUsagePhrase.getPointer() != null) {
            aPointerUsagePhrase.getPointer().apply(this);
        }
        this.outAPointerUsagePhrase(aPointerUsagePhrase);
    }
    
    public void inAProcedurePointerUsagePhrase(final AProcedurePointerUsagePhrase aProcedurePointerUsagePhrase) {
        this.defaultIn(aProcedurePointerUsagePhrase);
    }
    
    public void outAProcedurePointerUsagePhrase(final AProcedurePointerUsagePhrase aProcedurePointerUsagePhrase) {
        this.defaultOut(aProcedurePointerUsagePhrase);
    }
    
    @Override
    public void caseAProcedurePointerUsagePhrase(final AProcedurePointerUsagePhrase aProcedurePointerUsagePhrase) {
        this.inAProcedurePointerUsagePhrase(aProcedurePointerUsagePhrase);
        if (aProcedurePointerUsagePhrase.getProcedurePointer() != null) {
            aProcedurePointerUsagePhrase.getProcedurePointer().apply(this);
        }
        this.outAProcedurePointerUsagePhrase(aProcedurePointerUsagePhrase);
    }
    
    public void inAFunctionPointerUsagePhrase(final AFunctionPointerUsagePhrase aFunctionPointerUsagePhrase) {
        this.defaultIn(aFunctionPointerUsagePhrase);
    }
    
    public void outAFunctionPointerUsagePhrase(final AFunctionPointerUsagePhrase aFunctionPointerUsagePhrase) {
        this.defaultOut(aFunctionPointerUsagePhrase);
    }
    
    @Override
    public void caseAFunctionPointerUsagePhrase(final AFunctionPointerUsagePhrase aFunctionPointerUsagePhrase) {
        this.inAFunctionPointerUsagePhrase(aFunctionPointerUsagePhrase);
        if (aFunctionPointerUsagePhrase.getFunctionPointer() != null) {
            aFunctionPointerUsagePhrase.getFunctionPointer().apply(this);
        }
        this.outAFunctionPointerUsagePhrase(aFunctionPointerUsagePhrase);
    }
    
    public void inAObjectReferencePhrase(final AObjectReferencePhrase aObjectReferencePhrase) {
        this.defaultIn(aObjectReferencePhrase);
    }
    
    public void outAObjectReferencePhrase(final AObjectReferencePhrase aObjectReferencePhrase) {
        this.defaultOut(aObjectReferencePhrase);
    }
    
    @Override
    public void caseAObjectReferencePhrase(final AObjectReferencePhrase aObjectReferencePhrase) {
        this.inAObjectReferencePhrase(aObjectReferencePhrase);
        if (aObjectReferencePhrase.getObject() != null) {
            aObjectReferencePhrase.getObject().apply(this);
        }
        if (aObjectReferencePhrase.getReference() != null) {
            aObjectReferencePhrase.getReference().apply(this);
        }
        if (aObjectReferencePhrase.getDataName() != null) {
            aObjectReferencePhrase.getDataName().apply(this);
        }
        this.outAObjectReferencePhrase(aObjectReferencePhrase);
    }
    
    public void inARenamesItem(final ARenamesItem aRenamesItem) {
        this.defaultIn(aRenamesItem);
    }
    
    public void outARenamesItem(final ARenamesItem aRenamesItem) {
        this.defaultOut(aRenamesItem);
    }
    
    @Override
    public void caseARenamesItem(final ARenamesItem aRenamesItem) {
        this.inARenamesItem(aRenamesItem);
        if (aRenamesItem.getNumberNot88() != null) {
            aRenamesItem.getNumberNot88().apply(this);
        }
        if (aRenamesItem.getRenameTo() != null) {
            aRenamesItem.getRenameTo().apply(this);
        }
        if (aRenamesItem.getRenames() != null) {
            aRenamesItem.getRenames().apply(this);
        }
        if (aRenamesItem.getRenameFrom() != null) {
            aRenamesItem.getRenameFrom().apply(this);
        }
        if (aRenamesItem.getThroughPhrase() != null) {
            aRenamesItem.getThroughPhrase().apply(this);
        }
        this.outARenamesItem(aRenamesItem);
    }
    
    public void inAThroughPhrase(final AThroughPhrase aThroughPhrase) {
        this.defaultIn(aThroughPhrase);
    }
    
    public void outAThroughPhrase(final AThroughPhrase aThroughPhrase) {
        this.defaultOut(aThroughPhrase);
    }
    
    @Override
    public void caseAThroughPhrase(final AThroughPhrase aThroughPhrase) {
        this.inAThroughPhrase(aThroughPhrase);
        if (aThroughPhrase.getThrough() != null) {
            aThroughPhrase.getThrough().apply(this);
        }
        if (aThroughPhrase.getDataName() != null) {
            aThroughPhrase.getDataName().apply(this);
        }
        this.outAThroughPhrase(aThroughPhrase);
    }
    
    public void inAValueClause(final AValueClause aValueClause) {
        this.defaultIn(aValueClause);
    }
    
    public void outAValueClause(final AValueClause aValueClause) {
        this.defaultOut(aValueClause);
    }
    
    @Override
    public void caseAValueClause(final AValueClause aValueClause) {
        this.inAValueClause(aValueClause);
        if (aValueClause.getValue() != null) {
            aValueClause.getValue().apply(this);
        }
        if (aValueClause.getIs() != null) {
            aValueClause.getIs().apply(this);
        }
        if (aValueClause.getAll() != null) {
            aValueClause.getAll().apply(this);
        }
        if (aValueClause.getLiteral() != null) {
            aValueClause.getLiteral().apply(this);
        }
        this.outAValueClause(aValueClause);
    }
    
    public void inAValueItem(final AValueItem aValueItem) {
        this.defaultIn(aValueItem);
    }
    
    public void outAValueItem(final AValueItem aValueItem) {
        this.defaultOut(aValueItem);
    }
    
    @Override
    public void caseAValueItem(final AValueItem aValueItem) {
        this.inAValueItem(aValueItem);
        if (aValueItem.getNumber88() != null) {
            aValueItem.getNumber88().apply(this);
        }
        if (aValueItem.getDataName() != null) {
            aValueItem.getDataName().apply(this);
        }
        if (aValueItem.getValueOrValues() != null) {
            aValueItem.getValueOrValues().apply(this);
        }
        if (aValueItem.getLiteralSequence() != null) {
            aValueItem.getLiteralSequence().apply(this);
        }
        this.outAValueItem(aValueItem);
    }
    
    public void inAValueValueOrValues(final AValueValueOrValues aValueValueOrValues) {
        this.defaultIn(aValueValueOrValues);
    }
    
    public void outAValueValueOrValues(final AValueValueOrValues aValueValueOrValues) {
        this.defaultOut(aValueValueOrValues);
    }
    
    @Override
    public void caseAValueValueOrValues(final AValueValueOrValues aValueValueOrValues) {
        this.inAValueValueOrValues(aValueValueOrValues);
        if (aValueValueOrValues.getValue() != null) {
            aValueValueOrValues.getValue().apply(this);
        }
        if (aValueValueOrValues.getIs() != null) {
            aValueValueOrValues.getIs().apply(this);
        }
        this.outAValueValueOrValues(aValueValueOrValues);
    }
    
    public void inAValuesValueOrValues(final AValuesValueOrValues aValuesValueOrValues) {
        this.defaultIn(aValuesValueOrValues);
    }
    
    public void outAValuesValueOrValues(final AValuesValueOrValues aValuesValueOrValues) {
        this.defaultOut(aValuesValueOrValues);
    }
    
    @Override
    public void caseAValuesValueOrValues(final AValuesValueOrValues aValuesValueOrValues) {
        this.inAValuesValueOrValues(aValuesValueOrValues);
        if (aValuesValueOrValues.getValues() != null) {
            aValuesValueOrValues.getValues().apply(this);
        }
        if (aValuesValueOrValues.getAre() != null) {
            aValuesValueOrValues.getAre().apply(this);
        }
        this.outAValuesValueOrValues(aValuesValueOrValues);
    }
    
    public void inASingleLiteralSequence(final ASingleLiteralSequence aSingleLiteralSequence) {
        this.defaultIn(aSingleLiteralSequence);
    }
    
    public void outASingleLiteralSequence(final ASingleLiteralSequence aSingleLiteralSequence) {
        this.defaultOut(aSingleLiteralSequence);
    }
    
    @Override
    public void caseASingleLiteralSequence(final ASingleLiteralSequence aSingleLiteralSequence) {
        this.inASingleLiteralSequence(aSingleLiteralSequence);
        if (aSingleLiteralSequence.getAll() != null) {
            aSingleLiteralSequence.getAll().apply(this);
        }
        if (aSingleLiteralSequence.getLiteral() != null) {
            aSingleLiteralSequence.getLiteral().apply(this);
        }
        this.outASingleLiteralSequence(aSingleLiteralSequence);
    }
    
    public void inASequenceLiteralSequence(final ASequenceLiteralSequence aSequenceLiteralSequence) {
        this.defaultIn(aSequenceLiteralSequence);
    }
    
    public void outASequenceLiteralSequence(final ASequenceLiteralSequence aSequenceLiteralSequence) {
        this.defaultOut(aSequenceLiteralSequence);
    }
    
    @Override
    public void caseASequenceLiteralSequence(final ASequenceLiteralSequence aSequenceLiteralSequence) {
        this.inASequenceLiteralSequence(aSequenceLiteralSequence);
        if (aSequenceLiteralSequence.getLiteralSequence() != null) {
            aSequenceLiteralSequence.getLiteralSequence().apply(this);
        }
        if (aSequenceLiteralSequence.getComma() != null) {
            aSequenceLiteralSequence.getComma().apply(this);
        }
        if (aSequenceLiteralSequence.getLiteral() != null) {
            aSequenceLiteralSequence.getLiteral().apply(this);
        }
        this.outASequenceLiteralSequence(aSequenceLiteralSequence);
    }
    
    public void inAThroughSingleLiteralSequence(final AThroughSingleLiteralSequence aThroughSingleLiteralSequence) {
        this.defaultIn(aThroughSingleLiteralSequence);
    }
    
    public void outAThroughSingleLiteralSequence(final AThroughSingleLiteralSequence aThroughSingleLiteralSequence) {
        this.defaultOut(aThroughSingleLiteralSequence);
    }
    
    @Override
    public void caseAThroughSingleLiteralSequence(final AThroughSingleLiteralSequence aThroughSingleLiteralSequence) {
        this.inAThroughSingleLiteralSequence(aThroughSingleLiteralSequence);
        if (aThroughSingleLiteralSequence.getFrom() != null) {
            aThroughSingleLiteralSequence.getFrom().apply(this);
        }
        if (aThroughSingleLiteralSequence.getThrough() != null) {
            aThroughSingleLiteralSequence.getThrough().apply(this);
        }
        if (aThroughSingleLiteralSequence.getTo() != null) {
            aThroughSingleLiteralSequence.getTo().apply(this);
        }
        this.outAThroughSingleLiteralSequence(aThroughSingleLiteralSequence);
    }
    
    public void inAThroughSequenceLiteralSequence(final AThroughSequenceLiteralSequence aThroughSequenceLiteralSequence) {
        this.defaultIn(aThroughSequenceLiteralSequence);
    }
    
    public void outAThroughSequenceLiteralSequence(final AThroughSequenceLiteralSequence aThroughSequenceLiteralSequence) {
        this.defaultOut(aThroughSequenceLiteralSequence);
    }
    
    @Override
    public void caseAThroughSequenceLiteralSequence(final AThroughSequenceLiteralSequence aThroughSequenceLiteralSequence) {
        this.inAThroughSequenceLiteralSequence(aThroughSequenceLiteralSequence);
        if (aThroughSequenceLiteralSequence.getLiteralSequence() != null) {
            aThroughSequenceLiteralSequence.getLiteralSequence().apply(this);
        }
        if (aThroughSequenceLiteralSequence.getComma() != null) {
            aThroughSequenceLiteralSequence.getComma().apply(this);
        }
        if (aThroughSequenceLiteralSequence.getFrom() != null) {
            aThroughSequenceLiteralSequence.getFrom().apply(this);
        }
        if (aThroughSequenceLiteralSequence.getThrough() != null) {
            aThroughSequenceLiteralSequence.getThrough().apply(this);
        }
        if (aThroughSequenceLiteralSequence.getTo() != null) {
            aThroughSequenceLiteralSequence.getTo().apply(this);
        }
        this.outAThroughSequenceLiteralSequence(aThroughSequenceLiteralSequence);
    }
    
    public void inAZerosLiteral(final AZerosLiteral aZerosLiteral) {
        this.defaultIn(aZerosLiteral);
    }
    
    public void outAZerosLiteral(final AZerosLiteral aZerosLiteral) {
        this.defaultOut(aZerosLiteral);
    }
    
    @Override
    public void caseAZerosLiteral(final AZerosLiteral aZerosLiteral) {
        this.inAZerosLiteral(aZerosLiteral);
        if (aZerosLiteral.getZeros() != null) {
            aZerosLiteral.getZeros().apply(this);
        }
        this.outAZerosLiteral(aZerosLiteral);
    }
    
    public void inASpacesLiteral(final ASpacesLiteral aSpacesLiteral) {
        this.defaultIn(aSpacesLiteral);
    }
    
    public void outASpacesLiteral(final ASpacesLiteral aSpacesLiteral) {
        this.defaultOut(aSpacesLiteral);
    }
    
    @Override
    public void caseASpacesLiteral(final ASpacesLiteral aSpacesLiteral) {
        this.inASpacesLiteral(aSpacesLiteral);
        if (aSpacesLiteral.getSpaces() != null) {
            aSpacesLiteral.getSpaces().apply(this);
        }
        this.outASpacesLiteral(aSpacesLiteral);
    }
    
    public void inAHighValuesLiteral(final AHighValuesLiteral aHighValuesLiteral) {
        this.defaultIn(aHighValuesLiteral);
    }
    
    public void outAHighValuesLiteral(final AHighValuesLiteral aHighValuesLiteral) {
        this.defaultOut(aHighValuesLiteral);
    }
    
    @Override
    public void caseAHighValuesLiteral(final AHighValuesLiteral aHighValuesLiteral) {
        this.inAHighValuesLiteral(aHighValuesLiteral);
        if (aHighValuesLiteral.getHighValues() != null) {
            aHighValuesLiteral.getHighValues().apply(this);
        }
        this.outAHighValuesLiteral(aHighValuesLiteral);
    }
    
    public void inALowValuesLiteral(final ALowValuesLiteral aLowValuesLiteral) {
        this.defaultIn(aLowValuesLiteral);
    }
    
    public void outALowValuesLiteral(final ALowValuesLiteral aLowValuesLiteral) {
        this.defaultOut(aLowValuesLiteral);
    }
    
    @Override
    public void caseALowValuesLiteral(final ALowValuesLiteral aLowValuesLiteral) {
        this.inALowValuesLiteral(aLowValuesLiteral);
        if (aLowValuesLiteral.getLowValues() != null) {
            aLowValuesLiteral.getLowValues().apply(this);
        }
        this.outALowValuesLiteral(aLowValuesLiteral);
    }
    
    public void inAQuotesLiteral(final AQuotesLiteral aQuotesLiteral) {
        this.defaultIn(aQuotesLiteral);
    }
    
    public void outAQuotesLiteral(final AQuotesLiteral aQuotesLiteral) {
        this.defaultOut(aQuotesLiteral);
    }
    
    @Override
    public void caseAQuotesLiteral(final AQuotesLiteral aQuotesLiteral) {
        this.inAQuotesLiteral(aQuotesLiteral);
        if (aQuotesLiteral.getQuotes() != null) {
            aQuotesLiteral.getQuotes().apply(this);
        }
        this.outAQuotesLiteral(aQuotesLiteral);
    }
    
    public void inANullsLiteral(final ANullsLiteral aNullsLiteral) {
        this.defaultIn(aNullsLiteral);
    }
    
    public void outANullsLiteral(final ANullsLiteral aNullsLiteral) {
        this.defaultOut(aNullsLiteral);
    }
    
    @Override
    public void caseANullsLiteral(final ANullsLiteral aNullsLiteral) {
        this.inANullsLiteral(aNullsLiteral);
        if (aNullsLiteral.getNulls() != null) {
            aNullsLiteral.getNulls().apply(this);
        }
        this.outANullsLiteral(aNullsLiteral);
    }
    
    public void inANumberLiteral(final ANumberLiteral aNumberLiteral) {
        this.defaultIn(aNumberLiteral);
    }
    
    public void outANumberLiteral(final ANumberLiteral aNumberLiteral) {
        this.defaultOut(aNumberLiteral);
    }
    
    @Override
    public void caseANumberLiteral(final ANumberLiteral aNumberLiteral) {
        this.inANumberLiteral(aNumberLiteral);
        if (aNumberLiteral.getNumber() != null) {
            aNumberLiteral.getNumber().apply(this);
        }
        this.outANumberLiteral(aNumberLiteral);
    }
    
    public void inANumericLiteralLiteral(final ANumericLiteralLiteral aNumericLiteralLiteral) {
        this.defaultIn(aNumericLiteralLiteral);
    }
    
    public void outANumericLiteralLiteral(final ANumericLiteralLiteral aNumericLiteralLiteral) {
        this.defaultOut(aNumericLiteralLiteral);
    }
    
    @Override
    public void caseANumericLiteralLiteral(final ANumericLiteralLiteral aNumericLiteralLiteral) {
        this.inANumericLiteralLiteral(aNumericLiteralLiteral);
        if (aNumericLiteralLiteral.getNumericLiteral() != null) {
            aNumericLiteralLiteral.getNumericLiteral().apply(this);
        }
        this.outANumericLiteralLiteral(aNumericLiteralLiteral);
    }
    
    public void inAAlphanumericLiteralLiteral(final AAlphanumericLiteralLiteral aAlphanumericLiteralLiteral) {
        this.defaultIn(aAlphanumericLiteralLiteral);
    }
    
    public void outAAlphanumericLiteralLiteral(final AAlphanumericLiteralLiteral aAlphanumericLiteralLiteral) {
        this.defaultOut(aAlphanumericLiteralLiteral);
    }
    
    @Override
    public void caseAAlphanumericLiteralLiteral(final AAlphanumericLiteralLiteral aAlphanumericLiteralLiteral) {
        this.inAAlphanumericLiteralLiteral(aAlphanumericLiteralLiteral);
        if (aAlphanumericLiteralLiteral.getAlphanumericLiteral() != null) {
            aAlphanumericLiteralLiteral.getAlphanumericLiteral().apply(this);
        }
        this.outAAlphanumericLiteralLiteral(aAlphanumericLiteralLiteral);
    }
    
    public void inASingleCharacterString(final ASingleCharacterString aSingleCharacterString) {
        this.defaultIn(aSingleCharacterString);
    }
    
    public void outASingleCharacterString(final ASingleCharacterString aSingleCharacterString) {
        this.defaultOut(aSingleCharacterString);
    }
    
    @Override
    public void caseASingleCharacterString(final ASingleCharacterString aSingleCharacterString) {
        this.inASingleCharacterString(aSingleCharacterString);
        if (aSingleCharacterString.getCharacterSubstring() != null) {
            aSingleCharacterString.getCharacterSubstring().apply(this);
        }
        this.outASingleCharacterString(aSingleCharacterString);
    }
    
    public void inASequenceCharacterString(final ASequenceCharacterString aSequenceCharacterString) {
        this.defaultIn(aSequenceCharacterString);
    }
    
    public void outASequenceCharacterString(final ASequenceCharacterString aSequenceCharacterString) {
        this.defaultOut(aSequenceCharacterString);
    }
    
    @Override
    public void caseASequenceCharacterString(final ASequenceCharacterString aSequenceCharacterString) {
        this.inASequenceCharacterString(aSequenceCharacterString);
        if (aSequenceCharacterString.getCharacterString() != null) {
            aSequenceCharacterString.getCharacterString().apply(this);
        }
        if (aSequenceCharacterString.getCharacterSubstring() != null) {
            aSequenceCharacterString.getCharacterSubstring().apply(this);
        }
        this.outASequenceCharacterString(aSequenceCharacterString);
    }
    
    public void inADataNameCharacterSubstring(final ADataNameCharacterSubstring aDataNameCharacterSubstring) {
        this.defaultIn(aDataNameCharacterSubstring);
    }
    
    public void outADataNameCharacterSubstring(final ADataNameCharacterSubstring aDataNameCharacterSubstring) {
        this.defaultOut(aDataNameCharacterSubstring);
    }
    
    @Override
    public void caseADataNameCharacterSubstring(final ADataNameCharacterSubstring aDataNameCharacterSubstring) {
        this.inADataNameCharacterSubstring(aDataNameCharacterSubstring);
        if (aDataNameCharacterSubstring.getDataName() != null) {
            aDataNameCharacterSubstring.getDataName().apply(this);
        }
        this.outADataNameCharacterSubstring(aDataNameCharacterSubstring);
    }
    
    public void inAPlusCharacterSubstring(final APlusCharacterSubstring aPlusCharacterSubstring) {
        this.defaultIn(aPlusCharacterSubstring);
    }
    
    public void outAPlusCharacterSubstring(final APlusCharacterSubstring aPlusCharacterSubstring) {
        this.defaultOut(aPlusCharacterSubstring);
    }
    
    @Override
    public void caseAPlusCharacterSubstring(final APlusCharacterSubstring aPlusCharacterSubstring) {
        this.inAPlusCharacterSubstring(aPlusCharacterSubstring);
        if (aPlusCharacterSubstring.getPlus() != null) {
            aPlusCharacterSubstring.getPlus().apply(this);
        }
        this.outAPlusCharacterSubstring(aPlusCharacterSubstring);
    }
    
    public void inAMinusCharacterSubstring(final AMinusCharacterSubstring aMinusCharacterSubstring) {
        this.defaultIn(aMinusCharacterSubstring);
    }
    
    public void outAMinusCharacterSubstring(final AMinusCharacterSubstring aMinusCharacterSubstring) {
        this.defaultOut(aMinusCharacterSubstring);
    }
    
    @Override
    public void caseAMinusCharacterSubstring(final AMinusCharacterSubstring aMinusCharacterSubstring) {
        this.inAMinusCharacterSubstring(aMinusCharacterSubstring);
        if (aMinusCharacterSubstring.getMinus() != null) {
            aMinusCharacterSubstring.getMinus().apply(this);
        }
        this.outAMinusCharacterSubstring(aMinusCharacterSubstring);
    }
    
    public void inAStarCharacterSubstring(final AStarCharacterSubstring aStarCharacterSubstring) {
        this.defaultIn(aStarCharacterSubstring);
    }
    
    public void outAStarCharacterSubstring(final AStarCharacterSubstring aStarCharacterSubstring) {
        this.defaultOut(aStarCharacterSubstring);
    }
    
    @Override
    public void caseAStarCharacterSubstring(final AStarCharacterSubstring aStarCharacterSubstring) {
        this.inAStarCharacterSubstring(aStarCharacterSubstring);
        if (aStarCharacterSubstring.getStar() != null) {
            aStarCharacterSubstring.getStar().apply(this);
        }
        this.outAStarCharacterSubstring(aStarCharacterSubstring);
    }
    
    public void inASlashCharacterSubstring(final ASlashCharacterSubstring aSlashCharacterSubstring) {
        this.defaultIn(aSlashCharacterSubstring);
    }
    
    public void outASlashCharacterSubstring(final ASlashCharacterSubstring aSlashCharacterSubstring) {
        this.defaultOut(aSlashCharacterSubstring);
    }
    
    @Override
    public void caseASlashCharacterSubstring(final ASlashCharacterSubstring aSlashCharacterSubstring) {
        this.inASlashCharacterSubstring(aSlashCharacterSubstring);
        if (aSlashCharacterSubstring.getSlash() != null) {
            aSlashCharacterSubstring.getSlash().apply(this);
        }
        this.outASlashCharacterSubstring(aSlashCharacterSubstring);
    }
    
    public void inADollarCharacterSubstring(final ADollarCharacterSubstring aDollarCharacterSubstring) {
        this.defaultIn(aDollarCharacterSubstring);
    }
    
    public void outADollarCharacterSubstring(final ADollarCharacterSubstring aDollarCharacterSubstring) {
        this.defaultOut(aDollarCharacterSubstring);
    }
    
    @Override
    public void caseADollarCharacterSubstring(final ADollarCharacterSubstring aDollarCharacterSubstring) {
        this.inADollarCharacterSubstring(aDollarCharacterSubstring);
        if (aDollarCharacterSubstring.getDollar() != null) {
            aDollarCharacterSubstring.getDollar().apply(this);
        }
        this.outADollarCharacterSubstring(aDollarCharacterSubstring);
    }
    
    public void inACommaCharacterSubstring(final ACommaCharacterSubstring aCommaCharacterSubstring) {
        this.defaultIn(aCommaCharacterSubstring);
    }
    
    public void outACommaCharacterSubstring(final ACommaCharacterSubstring aCommaCharacterSubstring) {
        this.defaultOut(aCommaCharacterSubstring);
    }
    
    @Override
    public void caseACommaCharacterSubstring(final ACommaCharacterSubstring aCommaCharacterSubstring) {
        this.inACommaCharacterSubstring(aCommaCharacterSubstring);
        if (aCommaCharacterSubstring.getComma() != null) {
            aCommaCharacterSubstring.getComma().apply(this);
        }
        this.outACommaCharacterSubstring(aCommaCharacterSubstring);
    }
    
    public void inANumberCharacterSubstring(final ANumberCharacterSubstring aNumberCharacterSubstring) {
        this.defaultIn(aNumberCharacterSubstring);
    }
    
    public void outANumberCharacterSubstring(final ANumberCharacterSubstring aNumberCharacterSubstring) {
        this.defaultOut(aNumberCharacterSubstring);
    }
    
    @Override
    public void caseANumberCharacterSubstring(final ANumberCharacterSubstring aNumberCharacterSubstring) {
        this.inANumberCharacterSubstring(aNumberCharacterSubstring);
        if (aNumberCharacterSubstring.getNumberNot88() != null) {
            aNumberCharacterSubstring.getNumberNot88().apply(this);
        }
        this.outANumberCharacterSubstring(aNumberCharacterSubstring);
    }
    
    public void inANumericLiteralCharacterSubstring(final ANumericLiteralCharacterSubstring aNumericLiteralCharacterSubstring) {
        this.defaultIn(aNumericLiteralCharacterSubstring);
    }
    
    public void outANumericLiteralCharacterSubstring(final ANumericLiteralCharacterSubstring aNumericLiteralCharacterSubstring) {
        this.defaultOut(aNumericLiteralCharacterSubstring);
    }
    
    @Override
    public void caseANumericLiteralCharacterSubstring(final ANumericLiteralCharacterSubstring aNumericLiteralCharacterSubstring) {
        this.inANumericLiteralCharacterSubstring(aNumericLiteralCharacterSubstring);
        if (aNumericLiteralCharacterSubstring.getNumericLiteral() != null) {
            aNumericLiteralCharacterSubstring.getNumericLiteral().apply(this);
        }
        this.outANumericLiteralCharacterSubstring(aNumericLiteralCharacterSubstring);
    }
    
    public void inABracketedNumberCharacterSubstring(final ABracketedNumberCharacterSubstring aBracketedNumberCharacterSubstring) {
        this.defaultIn(aBracketedNumberCharacterSubstring);
    }
    
    public void outABracketedNumberCharacterSubstring(final ABracketedNumberCharacterSubstring aBracketedNumberCharacterSubstring) {
        this.defaultOut(aBracketedNumberCharacterSubstring);
    }
    
    @Override
    public void caseABracketedNumberCharacterSubstring(final ABracketedNumberCharacterSubstring aBracketedNumberCharacterSubstring) {
        this.inABracketedNumberCharacterSubstring(aBracketedNumberCharacterSubstring);
        if (aBracketedNumberCharacterSubstring.getBracketedNumber() != null) {
            aBracketedNumberCharacterSubstring.getBracketedNumber().apply(this);
        }
        this.outABracketedNumberCharacterSubstring(aBracketedNumberCharacterSubstring);
    }
    
    public void inADotMinusCharacterSubstring(final ADotMinusCharacterSubstring aDotMinusCharacterSubstring) {
        this.defaultIn(aDotMinusCharacterSubstring);
    }
    
    public void outADotMinusCharacterSubstring(final ADotMinusCharacterSubstring aDotMinusCharacterSubstring) {
        this.defaultOut(aDotMinusCharacterSubstring);
    }
    
    @Override
    public void caseADotMinusCharacterSubstring(final ADotMinusCharacterSubstring aDotMinusCharacterSubstring) {
        this.inADotMinusCharacterSubstring(aDotMinusCharacterSubstring);
        if (aDotMinusCharacterSubstring.getDotMinus() != null) {
            aDotMinusCharacterSubstring.getDotMinus().apply(this);
        }
        this.outADotMinusCharacterSubstring(aDotMinusCharacterSubstring);
    }
    
    public void inADotPlusCharacterSubstring(final ADotPlusCharacterSubstring aDotPlusCharacterSubstring) {
        this.defaultIn(aDotPlusCharacterSubstring);
    }
    
    public void outADotPlusCharacterSubstring(final ADotPlusCharacterSubstring aDotPlusCharacterSubstring) {
        this.defaultOut(aDotPlusCharacterSubstring);
    }
    
    @Override
    public void caseADotPlusCharacterSubstring(final ADotPlusCharacterSubstring aDotPlusCharacterSubstring) {
        this.inADotPlusCharacterSubstring(aDotPlusCharacterSubstring);
        if (aDotPlusCharacterSubstring.getDotPlus() != null) {
            aDotPlusCharacterSubstring.getDotPlus().apply(this);
        }
        this.outADotPlusCharacterSubstring(aDotPlusCharacterSubstring);
    }
    
    public void inADotZeeCharacterSubstring(final ADotZeeCharacterSubstring aDotZeeCharacterSubstring) {
        this.defaultIn(aDotZeeCharacterSubstring);
    }
    
    public void outADotZeeCharacterSubstring(final ADotZeeCharacterSubstring aDotZeeCharacterSubstring) {
        this.defaultOut(aDotZeeCharacterSubstring);
    }
    
    @Override
    public void caseADotZeeCharacterSubstring(final ADotZeeCharacterSubstring aDotZeeCharacterSubstring) {
        this.inADotZeeCharacterSubstring(aDotZeeCharacterSubstring);
        if (aDotZeeCharacterSubstring.getDotZee() != null) {
            aDotZeeCharacterSubstring.getDotZee().apply(this);
        }
        this.outADotZeeCharacterSubstring(aDotZeeCharacterSubstring);
    }
    
    public void inABracketedNumber(final ABracketedNumber aBracketedNumber) {
        this.defaultIn(aBracketedNumber);
    }
    
    public void outABracketedNumber(final ABracketedNumber aBracketedNumber) {
        this.defaultOut(aBracketedNumber);
    }
    
    @Override
    public void caseABracketedNumber(final ABracketedNumber aBracketedNumber) {
        this.inABracketedNumber(aBracketedNumber);
        if (aBracketedNumber.getLparen() != null) {
            aBracketedNumber.getLparen().apply(this);
        }
        if (aBracketedNumber.getNumber() != null) {
            aBracketedNumber.getNumber().apply(this);
        }
        if (aBracketedNumber.getRparen() != null) {
            aBracketedNumber.getRparen().apply(this);
        }
        this.outABracketedNumber(aBracketedNumber);
    }
    
    public void inANumberNot88Number(final ANumberNot88Number aNumberNot88Number) {
        this.defaultIn(aNumberNot88Number);
    }
    
    public void outANumberNot88Number(final ANumberNot88Number aNumberNot88Number) {
        this.defaultOut(aNumberNot88Number);
    }
    
    @Override
    public void caseANumberNot88Number(final ANumberNot88Number aNumberNot88Number) {
        this.inANumberNot88Number(aNumberNot88Number);
        if (aNumberNot88Number.getNumberNot88() != null) {
            aNumberNot88Number.getNumberNot88().apply(this);
        }
        this.outANumberNot88Number(aNumberNot88Number);
    }
    
    public void inANumber88Number(final ANumber88Number aNumber88Number) {
        this.defaultIn(aNumber88Number);
    }
    
    public void outANumber88Number(final ANumber88Number aNumber88Number) {
        this.defaultOut(aNumber88Number);
    }
    
    @Override
    public void caseANumber88Number(final ANumber88Number aNumber88Number) {
        this.inANumber88Number(aNumber88Number);
        if (aNumber88Number.getNumber88() != null) {
            aNumber88Number.getNumber88().apply(this);
        }
        this.outANumber88Number(aNumber88Number);
    }
}
