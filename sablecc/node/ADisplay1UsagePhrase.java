// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ADisplay1UsagePhrase extends PUsagePhrase
{
    private TDisplay1 _display1_;
    private TNative _native_;
    
    public ADisplay1UsagePhrase() {
    }
    
    public ADisplay1UsagePhrase(final TDisplay1 display1, final TNative native1) {
        this.setDisplay1(display1);
        this.setNative(native1);
    }
    
    @Override
    public Object clone() {
        return new ADisplay1UsagePhrase(this.cloneNode(this._display1_), this.cloneNode(this._native_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseADisplay1UsagePhrase(this);
    }
    
    public TDisplay1 getDisplay1() {
        return this._display1_;
    }
    
    public void setDisplay1(final TDisplay1 display1_) {
        if (this._display1_ != null) {
            this._display1_.parent(null);
        }
        if (display1_ != null) {
            if (display1_.parent() != null) {
                display1_.parent().removeChild(display1_);
            }
            display1_.parent(this);
        }
        this._display1_ = display1_;
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
        return "" + this.toString(this._display1_) + this.toString(this._native_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._display1_ == node) {
            this._display1_ = null;
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
        if (this._display1_ == node) {
            this.setDisplay1((TDisplay1)node2);
            return;
        }
        if (this._native_ == node) {
            this.setNative((TNative)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
