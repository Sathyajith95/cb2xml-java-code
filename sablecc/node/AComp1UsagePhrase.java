// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AComp1UsagePhrase extends PUsagePhrase
{
    private TComp1 _comp1_;
    private TNative _native_;
    
    public AComp1UsagePhrase() {
    }
    
    public AComp1UsagePhrase(final TComp1 comp1, final TNative native1) {
        this.setComp1(comp1);
        this.setNative(native1);
    }
    
    @Override
    public Object clone() {
        return new AComp1UsagePhrase(this.cloneNode(this._comp1_), this.cloneNode(this._native_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAComp1UsagePhrase(this);
    }
    
    public TComp1 getComp1() {
        return this._comp1_;
    }
    
    public void setComp1(final TComp1 comp1_) {
        if (this._comp1_ != null) {
            this._comp1_.parent(null);
        }
        if (comp1_ != null) {
            if (comp1_.parent() != null) {
                comp1_.parent().removeChild(comp1_);
            }
            comp1_.parent(this);
        }
        this._comp1_ = comp1_;
    }
    
    public TNative getNative() {
        return this._native_;
    }
    
    public void setNative(final TNative native_) {
        if (this._native_ != null) {
            this._native_.parent(null);
        }
        if (native_ != null) {
            if (native_.parent() != null) {
                native_.parent().removeChild(native_);
            }
            native_.parent(this);
        }
        this._native_ = native_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._comp1_) + this.toString(this._native_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._comp1_ == node) {
            this._comp1_ = null;
            return;
        }
        if (this._native_ == node) {
            this._native_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._comp1_ == node) {
            this.setComp1((TComp1)node2);
            return;
        }
        if (this._native_ == node) {
            this.setNative((TNative)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
