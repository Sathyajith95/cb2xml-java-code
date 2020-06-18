// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AComp2UsagePhrase extends PUsagePhrase
{
    private TComp2 _comp2_;
    private TNative _native_;
    
    public AComp2UsagePhrase() {
    }
    
    public AComp2UsagePhrase(final TComp2 comp2, final TNative native1) {
        this.setComp2(comp2);
        this.setNative(native1);
    }
    
    @Override
    public Object clone() {
        return new AComp2UsagePhrase(this.cloneNode(this._comp2_), this.cloneNode(this._native_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAComp2UsagePhrase(this);
    }
    
    public TComp2 getComp2() {
        return this._comp2_;
    }
    
    public void setComp2(final TComp2 comp2_) {
        if (this._comp2_ != null) {
            this._comp2_.parent(null);
        }
        if (comp2_ != null) {
            if (comp2_.parent() != null) {
                comp2_.parent().removeChild(comp2_);
            }
            comp2_.parent(this);
        }
        this._comp2_ = comp2_;
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
        return "" + this.toString(this._comp2_) + this.toString(this._native_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._comp2_ == node) {
            this._comp2_ = null;
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
        if (this._comp2_ == node) {
            this.setComp2((TComp2)node2);
            return;
        }
        if (this._native_ == node) {
            this.setNative((TNative)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
