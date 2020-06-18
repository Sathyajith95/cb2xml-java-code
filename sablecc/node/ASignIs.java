// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ASignIs extends PSignIs
{
    private TSign _sign_;
    private TIs _is_;
    
    public ASignIs() {
    }
    
    public ASignIs(final TSign sign, final TIs is) {
        this.setSign(sign);
        this.setIs(is);
    }
    
    @Override
    public Object clone() {
        return new ASignIs(this.cloneNode(this._sign_), this.cloneNode(this._is_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseASignIs(this);
    }
    
    public TSign getSign() {
        return this._sign_;
    }
    
    public void setSign(final TSign sign_) {
        if (this._sign_ != null) {
            this._sign_.parent(null);
        }
        if (sign_ != null) {
            if (sign_.parent() != null) {
                sign_.parent().removeChild(sign_);
            }
            sign_.parent(this);
        }
        this._sign_ = sign_;
    }
    
    public TIs getIs() {
        return this._is_;
    }
    
    public void setIs(final TIs is_) {
        if (this._is_ != null) {
            this._is_.parent(null);
        }
        if (is_ != null) {
            if (is_.parent() != null) {
                is_.parent().removeChild(is_);
            }
            is_.parent(this);
        }
        this._is_ = is_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._sign_) + this.toString(this._is_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._sign_ == node) {
            this._sign_ = null;
            return;
        }
        if (this._is_ == node) {
            this._is_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._sign_ == node) {
            this.setSign((TSign)node2);
            return;
        }
        if (this._is_ == node) {
            this.setIs((TIs)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
