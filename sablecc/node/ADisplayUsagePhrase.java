// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ADisplayUsagePhrase extends PUsagePhrase
{
    private TDisplay _display_;
    private TNative _native_;
    
    public ADisplayUsagePhrase() {
    }
    
    public ADisplayUsagePhrase(final TDisplay display, final TNative native1) {
        this.setDisplay(display);
        this.setNative(native1);
    }
    
    @Override
    public Object clone() {
        return new ADisplayUsagePhrase(this.cloneNode(this._display_), this.cloneNode(this._native_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseADisplayUsagePhrase(this);
    }
    
    public TDisplay getDisplay() {
        return this._display_;
    }
    
    public void setDisplay(final TDisplay display_) {
        if (this._display_ != null) {
            this._display_.parent(null);
        }
        if (display_ != null) {
            if (display_.parent() != null) {
                display_.parent().removeChild(display_);
            }
            display_.parent(this);
        }
        this._display_ = display_;
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
        return "" + this.toString(this._display_) + this.toString(this._native_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._display_ == node) {
            this._display_ = null;
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
        if (this._display_ == node) {
            this.setDisplay((TDisplay)node2);
            return;
        }
        if (this._native_ == node) {
            this.setNative((TNative)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
