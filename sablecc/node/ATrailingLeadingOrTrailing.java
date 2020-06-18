// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ATrailingLeadingOrTrailing extends PLeadingOrTrailing
{
    private TTrailing _trailing_;
    
    public ATrailingLeadingOrTrailing() {
    }
    
    public ATrailingLeadingOrTrailing(final TTrailing trailing) {
        this.setTrailing(trailing);
    }
    
    @Override
    public Object clone() {
        return new ATrailingLeadingOrTrailing(this.cloneNode(this._trailing_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseATrailingLeadingOrTrailing(this);
    }
    
    public TTrailing getTrailing() {
        return this._trailing_;
    }
    
    public void setTrailing(final TTrailing trailing_) {
        if (this._trailing_ != null) {
            this._trailing_.parent(null);
        }
        if (trailing_ != null) {
            if (trailing_.parent() != null) {
                trailing_.parent().removeChild(trailing_);
            }
            trailing_.parent(this);
        }
        this._trailing_ = trailing_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._trailing_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._trailing_ == node) {
            this._trailing_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._trailing_ == node) {
            this.setTrailing((TTrailing)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
