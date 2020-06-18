// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ADataNameCharacterSubstring extends PCharacterSubstring
{
    private TDataName _dataName_;
    
    public ADataNameCharacterSubstring() {
    }
    
    public ADataNameCharacterSubstring(final TDataName dataName) {
        this.setDataName(dataName);
    }
    
    @Override
    public Object clone() {
        return new ADataNameCharacterSubstring(this.cloneNode(this._dataName_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseADataNameCharacterSubstring(this);
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
        return "" + this.toString(this._dataName_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._dataName_ == node) {
            this._dataName_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._dataName_ == node) {
            this.setDataName((TDataName)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
