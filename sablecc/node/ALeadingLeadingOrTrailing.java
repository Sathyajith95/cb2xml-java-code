// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ALeadingLeadingOrTrailing extends PLeadingOrTrailing
{
    private TLeading _leading_;
    
    public ALeadingLeadingOrTrailing() {
    }
    
    public ALeadingLeadingOrTrailing(final TLeading leading) {
        this.setLeading(leading);
    }
    
    @Override
    public Object clone() {
        return new ALeadingLeadingOrTrailing(this.cloneNode(this._leading_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseALeadingLeadingOrTrailing(this);
    }
    
    public TLeading getLeading() {
        return this._leading_;
    }
    
    public void setLeading(final TLeading leading_) {
        if (this._leading_ != null) {
            this._leading_.parent(null);
        }
        if (leading_ != null) {
            if (leading_.parent() != null) {
                leading_.parent().removeChild(leading_);
            }
            leading_.parent(this);
        }
        this._leading_ = leading_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._leading_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._leading_ == node) {
            this._leading_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._leading_ == node) {
            this.setLeading((TLeading)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
