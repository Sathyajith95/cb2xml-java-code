// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ADescendingAscendingOrDescending extends PAscendingOrDescending
{
    private TDescending _descending_;
    
    public ADescendingAscendingOrDescending() {
    }
    
    public ADescendingAscendingOrDescending(final TDescending descending) {
        this.setDescending(descending);
    }
    
    @Override
    public Object clone() {
        return new ADescendingAscendingOrDescending(this.cloneNode(this._descending_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseADescendingAscendingOrDescending(this);
    }
    
    public TDescending getDescending() {
        return this._descending_;
    }
    
    public void setDescending(final TDescending descending_) {
        if (this._descending_ != null) {
            this._descending_.parent(null);
        }
        if (descending_ != null) {
            if (descending_.parent() != null) {
                descending_.parent().removeChild(descending_);
            }
            descending_.parent(this);
        }
        this._descending_ = descending_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._descending_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._descending_ == node) {
            this._descending_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._descending_ == node) {
            this.setDescending((TDescending)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
