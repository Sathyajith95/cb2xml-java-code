// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ANumberCharacterSubstring extends PCharacterSubstring
{
    private TNumberNot88 _numberNot88_;
    
    public ANumberCharacterSubstring() {
    }
    
    public ANumberCharacterSubstring(final TNumberNot88 numberNot88) {
        this.setNumberNot88(numberNot88);
    }
    
    @Override
    public Object clone() {
        return new ANumberCharacterSubstring(this.cloneNode(this._numberNot88_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseANumberCharacterSubstring(this);
    }
    
    public TNumberNot88 getNumberNot88() {
        return this._numberNot88_;
    }
    
    public void setNumberNot88(final TNumberNot88 numberNot88_) {
        if (this._numberNot88_ != null) {
            this._numberNot88_.parent(null);
        }
        if (numberNot88_ != null) {
            if (numberNot88_.parent() != null) {
                numberNot88_.parent().removeChild(numberNot88_);
            }
            numberNot88_.parent(this);
        }
        this._numberNot88_ = numberNot88_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._numberNot88_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._numberNot88_ == node) {
            this._numberNot88_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._numberNot88_ == node) {
            this.setNumberNot88((TNumberNot88)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
