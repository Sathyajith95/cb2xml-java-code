// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ABinaryUsagePhrase extends PUsagePhrase
{
    private TBinary _binary_;
    private TNative _native_;
    
    public ABinaryUsagePhrase() {
    }
    
    public ABinaryUsagePhrase(final TBinary binary, final TNative native1) {
        this.setBinary(binary);
        this.setNative(native1);
    }
    
    @Override
    public Object clone() {
        return new ABinaryUsagePhrase(this.cloneNode(this._binary_), this.cloneNode(this._native_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseABinaryUsagePhrase(this);
    }
    
    public TBinary getBinary() {
        return this._binary_;
    }
    
    public void setBinary(final TBinary binary_) {
        if (this._binary_ != null) {
            this._binary_.parent(null);
        }
        if (binary_ != null) {
            if (binary_.parent() != null) {
                binary_.parent().removeChild(binary_);
            }
            binary_.parent(this);
        }
        this._binary_ = binary_;
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
        return "" + this.toString(this._binary_) + this.toString(this._native_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._binary_ == node) {
            this._binary_ = null;
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
        if (this._binary_ == node) {
            this.setBinary((TBinary)node2);
            return;
        }
        if (this._native_ == node) {
            this.setNative((TNative)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
