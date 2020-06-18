// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ADotMinusCharacterSubstring extends PCharacterSubstring
{
    private TDotMinus _dotMinus_;
    
    public ADotMinusCharacterSubstring() {
    }
    
    public ADotMinusCharacterSubstring(final TDotMinus dotMinus) {
        this.setDotMinus(dotMinus);
    }
    
    @Override
    public Object clone() {
        return new ADotMinusCharacterSubstring(this.cloneNode(this._dotMinus_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseADotMinusCharacterSubstring(this);
    }
    
    public TDotMinus getDotMinus() {
        return this._dotMinus_;
    }
    
    public void setDotMinus(final TDotMinus dotMinus_) {
        if (this._dotMinus_ != null) {
            this._dotMinus_.parent(null);
        }
        if (dotMinus_ != null) {
            if (dotMinus_.parent() != null) {
                dotMinus_.parent().removeChild(dotMinus_);
            }
            dotMinus_.parent(this);
        }
        this._dotMinus_ = dotMinus_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._dotMinus_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._dotMinus_ == node) {
            this._dotMinus_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._dotMinus_ == node) {
            this.setDotMinus((TDotMinus)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
