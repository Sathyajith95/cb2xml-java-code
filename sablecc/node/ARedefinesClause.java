// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ARedefinesClause extends PRedefinesClause
{
    private TRedefines _redefines_;
    private TDataName _dataName_;
    
    public ARedefinesClause() {
    }
    
    public ARedefinesClause(final TRedefines redefines, final TDataName dataName) {
        this.setRedefines(redefines);
        this.setDataName(dataName);
    }
    
    @Override
    public Object clone() {
        return new ARedefinesClause(this.cloneNode(this._redefines_), this.cloneNode(this._dataName_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseARedefinesClause(this);
    }
    
    public TRedefines getRedefines() {
        return this._redefines_;
    }
    
    public void setRedefines(final TRedefines redefines_) {
        if (this._redefines_ != null) {
            this._redefines_.parent(null);
        }
        if (redefines_ != null) {
            if (redefines_.parent() != null) {
                redefines_.parent().removeChild(redefines_);
            }
            redefines_.parent(this);
        }
        this._redefines_ = redefines_;
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
        return "" + this.toString(this._redefines_) + this.toString(this._dataName_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._redefines_ == node) {
            this._redefines_ = null;
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
        if (this._redefines_ == node) {
            this.setRedefines((TRedefines)node2);
            return;
        }
        if (this._dataName_ == node) {
            this.setDataName((TDataName)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
