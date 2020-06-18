// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AComp3UsagePhrase extends PUsagePhrase
{
    private TComp3 _comp3_;
    
    public AComp3UsagePhrase() {
    }
    
    public AComp3UsagePhrase(final TComp3 comp3) {
        this.setComp3(comp3);
    }
    
    @Override
    public Object clone() {
        return new AComp3UsagePhrase(this.cloneNode(this._comp3_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAComp3UsagePhrase(this);
    }
    
    public TComp3 getComp3() {
        return this._comp3_;
    }
    
    public void setComp3(final TComp3 comp3_) {
        if (this._comp3_ != null) {
            this._comp3_.parent(null);
        }
        if (comp3_ != null) {
            if (comp3_.parent() != null) {
                comp3_.parent().removeChild(comp3_);
            }
            comp3_.parent(this);
        }
        this._comp3_ = comp3_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._comp3_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._comp3_ == node) {
            this._comp3_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._comp3_ == node) {
            this.setComp3((TComp3)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
