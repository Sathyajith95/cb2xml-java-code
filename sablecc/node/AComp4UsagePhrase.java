// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AComp4UsagePhrase extends PUsagePhrase
{
    private TComp4 _comp4_;
    private TNative _native_;
    
    public AComp4UsagePhrase() {
    }
    
    public AComp4UsagePhrase(final TComp4 comp4, final TNative native1) {
        this.setComp4(comp4);
        this.setNative(native1);
    }
    
    @Override
    public Object clone() {
        return new AComp4UsagePhrase(this.cloneNode(this._comp4_), this.cloneNode(this._native_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAComp4UsagePhrase(this);
    }
    
    public TComp4 getComp4() {
        return this._comp4_;
    }
    
    public void setComp4(final TComp4 comp4_) {
        if (this._comp4_ != null) {
            this._comp4_.parent(null);
        }
        if (comp4_ != null) {
            if (comp4_.parent() != null) {
                comp4_.parent().removeChild(comp4_);
            }
            comp4_.parent(this);
        }
        this._comp4_ = comp4_;
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
        return "" + this.toString(this._comp4_) + this.toString(this._native_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._comp4_ == node) {
            this._comp4_ = null;
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
        if (this._comp4_ == node) {
            this.setComp4((TComp4)node2);
            return;
        }
        if (this._native_ == node) {
            this.setNative((TNative)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
