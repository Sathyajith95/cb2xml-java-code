// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ACompUsagePhrase extends PUsagePhrase
{
    private TComp _comp_;
    
    public ACompUsagePhrase() {
    }
    
    public ACompUsagePhrase(final TComp comp) {
        this.setComp(comp);
    }
    
    @Override
    public Object clone() {
        return new ACompUsagePhrase(this.cloneNode(this._comp_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseACompUsagePhrase(this);
    }
    
    public TComp getComp() {
        return this._comp_;
    }
    
    public void setComp(final TComp comp_) {
        if (this._comp_ != null) {
            this._comp_.parent(null);
        }
        if (comp_ != null) {
            if (comp_.parent() != null) {
                comp_.parent().removeChild(comp_);
            }
            comp_.parent(this);
        }
        this._comp_ = comp_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._comp_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._comp_ == node) {
            this._comp_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._comp_ == node) {
            this.setComp((TComp)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
