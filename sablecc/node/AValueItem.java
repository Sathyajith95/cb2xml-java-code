// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AValueItem extends PValueItem
{
    private TNumber88 _number88_;
    private TDataName _dataName_;
    private PValueOrValues _valueOrValues_;
    private PLiteralSequence _literalSequence_;
    
    public AValueItem() {
    }
    
    public AValueItem(final TNumber88 number88, final TDataName dataName, final PValueOrValues valueOrValues, final PLiteralSequence literalSequence) {
        this.setNumber88(number88);
        this.setDataName(dataName);
        this.setValueOrValues(valueOrValues);
        this.setLiteralSequence(literalSequence);
    }
    
    @Override
    public Object clone() {
        return new AValueItem(this.cloneNode(this._number88_), this.cloneNode(this._dataName_), this.cloneNode(this._valueOrValues_), this.cloneNode(this._literalSequence_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAValueItem(this);
    }
    
    public TNumber88 getNumber88() {
        return this._number88_;
    }
    
    public void setNumber88(final TNumber88 number88_) {
        if (this._number88_ != null) {
            this._number88_.parent(null);
        }
        if (number88_ != null) {
            if (number88_.parent() != null) {
                number88_.parent().removeChild(number88_);
            }
            number88_.parent(this);
        }
        this._number88_ = number88_;
    }
    
    public TDataName getDataName() {
        return this._dataName_;
    }
    
    public void setDataName(final TDataName dataName_) {
        if (this._dataName_ != null) {
            this._dataName_.parent(null);
        }
        if (dataName_ != null) {
            if (dataName_.parent() != null) {
                dataName_.parent().removeChild(dataName_);
            }
            dataName_.parent(this);
        }
        this._dataName_ = dataName_;
    }
    
    public PValueOrValues getValueOrValues() {
        return this._valueOrValues_;
    }
    
    public void setValueOrValues(final PValueOrValues valueOrValues_) {
        if (this._valueOrValues_ != null) {
            this._valueOrValues_.parent(null);
        }
        if (valueOrValues_ != null) {
            if (valueOrValues_.parent() != null) {
                valueOrValues_.parent().removeChild(valueOrValues_);
            }
            valueOrValues_.parent(this);
        }
        this._valueOrValues_ = valueOrValues_;
    }
    
    public PLiteralSequence getLiteralSequence() {
        return this._literalSequence_;
    }
    
    public void setLiteralSequence(final PLiteralSequence literalSequence_) {
        if (this._literalSequence_ != null) {
            this._literalSequence_.parent(null);
        }
        if (literalSequence_ != null) {
            if (literalSequence_.parent() != null) {
                literalSequence_.parent().removeChild(literalSequence_);
            }
            literalSequence_.parent(this);
        }
        this._literalSequence_ = literalSequence_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._number88_) + this.toString(this._dataName_) + this.toString(this._valueOrValues_) + this.toString(this._literalSequence_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._number88_ == node) {
            this._number88_ = null;
            return;
        }
        if (this._dataName_ == node) {
            this._dataName_ = null;
            return;
        }
        if (this._valueOrValues_ == node) {
            this._valueOrValues_ = null;
            return;
        }
        if (this._literalSequence_ == node) {
            this._literalSequence_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._number88_ == node) {
            this.setNumber88((TNumber88)node2);
            return;
        }
        if (this._dataName_ == node) {
            this.setDataName((TDataName)node2);
            return;
        }
        if (this._valueOrValues_ == node) {
            this.setValueOrValues((PValueOrValues)node2);
            return;
        }
        if (this._literalSequence_ == node) {
            this.setLiteralSequence((PLiteralSequence)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
