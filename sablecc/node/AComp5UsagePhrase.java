// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AComp5UsagePhrase extends PUsagePhrase
{
    private TComp5 _comp5_;
    
    public AComp5UsagePhrase() {
    }
    
    public AComp5UsagePhrase(final TComp5 comp5) {
        this.setComp5(comp5);
    }
    
    @Override
    public Object clone() {
        return new AComp5UsagePhrase(this.cloneNode(this._comp5_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAComp5UsagePhrase(this);
    }
    
    public TComp5 getComp5() {
        return this._comp5_;
    }
    
    public void setComp5(final TComp5 comp5_) {
        if (this._comp5_ != null) {
            this._comp5_.parent(null);
        }
        if (comp5_ != null) {
            if (comp5_.parent() != null) {
                comp5_.parent().removeChild(comp5_);
            }
            comp5_.parent(this);
        }
        this._comp5_ = comp5_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._comp5_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._comp5_ == node) {
            this._comp5_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._comp5_ == node) {
            this.setComp5((TComp5)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
