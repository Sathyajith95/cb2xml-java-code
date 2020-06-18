// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AMinusCharacterSubstring extends PCharacterSubstring
{
    private TMinus _minus_;
    
    public AMinusCharacterSubstring() {
    }
    
    public AMinusCharacterSubstring(final TMinus minus) {
        this.setMinus(minus);
    }
    
    @Override
    public Object clone() {
        return new AMinusCharacterSubstring(this.cloneNode(this._minus_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAMinusCharacterSubstring(this);
    }
    
    public TMinus getMinus() {
        return this._minus_;
    }
    
    public void setMinus(final TMinus minus_) {
        if (this._minus_ != null) {
            this._minus_.parent(null);
        }
        if (minus_ != null) {
            if (minus_.parent() != null) {
                minus_.parent().removeChild(minus_);
            }
            minus_.parent(this);
        }
        this._minus_ = minus_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._minus_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._minus_ == node) {
            this._minus_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._minus_ == node) {
            this.setMinus((TMinus)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
