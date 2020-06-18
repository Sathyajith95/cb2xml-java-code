// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AComp6UsagePhrase extends PUsagePhrase
{
    private TComp6 _comp6_;
    
    public AComp6UsagePhrase() {
    }
    
    public AComp6UsagePhrase(final TComp6 comp6) {
        this.setComp6(comp6);
    }
    
    @Override
    public Object clone() {
        return new AComp6UsagePhrase(this.cloneNode(this._comp6_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAComp6UsagePhrase(this);
    }
    
    public TComp6 getComp6() {
        return this._comp6_;
    }
    
    public void setComp6(final TComp6 comp6_) {
        if (this._comp6_ != null) {
            this._comp6_.parent(null);
        }
        if (comp6_ != null) {
            if (comp6_.parent() != null) {
                comp6_.parent().removeChild(comp6_);
            }
            comp6_.parent(this);
        }
        this._comp6_ = comp6_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._comp6_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._comp6_ == node) {
            this._comp6_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._comp6_ == node) {
            this.setComp6((TComp6)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
