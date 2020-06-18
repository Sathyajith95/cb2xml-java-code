// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AThroughPhrase extends PThroughPhrase
{
    private TThrough _through_;
    private TDataName _dataName_;
    
    public AThroughPhrase() {
    }
    
    public AThroughPhrase(final TThrough through, final TDataName dataName) {
        this.setThrough(through);
        this.setDataName(dataName);
    }
    
    @Override
    public Object clone() {
        return new AThroughPhrase(this.cloneNode(this._through_), this.cloneNode(this._dataName_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAThroughPhrase(this);
    }
    
    public TThrough getThrough() {
        return this._through_;
    }
    
    public void setThrough(final TThrough through_) {
        if (this._through_ != null) {
            this._through_.parent(null);
        }
        if (through_ != null) {
            if (through_.parent() != null) {
                through_.parent().removeChild(through_);
            }
            through_.parent(this);
        }
        this._through_ = through_;
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
    
    @Override
    public String toString() {
        return "" + this.toString(this._through_) + this.toString(this._dataName_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._through_ == node) {
            this._through_ = null;
            return;
        }
        if (this._dataName_ == node) {
            this._dataName_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._through_ == node) {
            this.setThrough((TThrough)node2);
            return;
        }
        if (this._dataName_ == node) {
            this.setDataName((TDataName)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
