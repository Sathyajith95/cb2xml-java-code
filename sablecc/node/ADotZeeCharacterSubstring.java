// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ADotZeeCharacterSubstring extends PCharacterSubstring
{
    private TDotZee _dotZee_;
    
    public ADotZeeCharacterSubstring() {
    }
    
    public ADotZeeCharacterSubstring(final TDotZee dotZee) {
        this.setDotZee(dotZee);
    }
    
    @Override
    public Object clone() {
        return new ADotZeeCharacterSubstring(this.cloneNode(this._dotZee_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseADotZeeCharacterSubstring(this);
    }
    
    public TDotZee getDotZee() {
        return this._dotZee_;
    }
    
    public void setDotZee(final TDotZee dotZee_) {
        if (this._dotZee_ != null) {
            this._dotZee_.parent(null);
        }
        if (dotZee_ != null) {
            if (dotZee_.parent() != null) {
                dotZee_.parent().removeChild(dotZee_);
            }
            dotZee_.parent(this);
        }
        this._dotZee_ = dotZee_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._dotZee_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._dotZee_ == node) {
            this._dotZee_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._dotZee_ == node) {
            this.setDotZee((TDotZee)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
