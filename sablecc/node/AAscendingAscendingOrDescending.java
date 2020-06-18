// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AAscendingAscendingOrDescending extends PAscendingOrDescending
{
    private TAscending _ascending_;
    
    public AAscendingAscendingOrDescending() {
    }
    
    public AAscendingAscendingOrDescending(final TAscending ascending) {
        this.setAscending(ascending);
    }
    
    @Override
    public Object clone() {
        return new AAscendingAscendingOrDescending(this.cloneNode(this._ascending_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAAscendingAscendingOrDescending(this);
    }
    
    public TAscending getAscending() {
        return this._ascending_;
    }
    
    public void setAscending(final TAscending ascending_) {
        if (this._ascending_ != null) {
            this._ascending_.parent(null);
        }
        if (ascending_ != null) {
            if (ascending_.parent() != null) {
                ascending_.parent().removeChild(ascending_);
            }
            ascending_.parent(this);
        }
        this._ascending_ = ascending_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._ascending_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._ascending_ == node) {
            this._ascending_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._ascending_ == node) {
            this.setAscending((TAscending)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
