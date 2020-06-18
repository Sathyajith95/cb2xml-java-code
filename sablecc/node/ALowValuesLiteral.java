// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ALowValuesLiteral extends PLiteral
{
    private TLowValues _lowValues_;
    
    public ALowValuesLiteral() {
    }
    
    public ALowValuesLiteral(final TLowValues lowValues) {
        this.setLowValues(lowValues);
    }
    
    @Override
    public Object clone() {
        return new ALowValuesLiteral(this.cloneNode(this._lowValues_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseALowValuesLiteral(this);
    }
    
    public TLowValues getLowValues() {
        return this._lowValues_;
    }
    
    public void setLowValues(final TLowValues lowValues_) {
        if (this._lowValues_ != null) {
            this._lowValues_.parent(null);
        }
        if (lowValues_ != null) {
            if (lowValues_.parent() != null) {
                lowValues_.parent().removeChild(lowValues_);
            }
            lowValues_.parent(this);
        }
        this._lowValues_ = lowValues_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._lowValues_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._lowValues_ == node) {
            this._lowValues_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._lowValues_ == node) {
            this.setLowValues((TLowValues)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
