// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ANumberLiteral extends PLiteral
{
    private PNumber _number_;
    
    public ANumberLiteral() {
    }
    
    public ANumberLiteral(final PNumber number) {
        this.setNumber(number);
    }
    
    @Override
    public Object clone() {
        return new ANumberLiteral(this.cloneNode(this._number_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseANumberLiteral(this);
    }
    
    public PNumber getNumber() {
        return this._number_;
    }
    
    public void setNumber(final PNumber number_) {
        if (this._number_ != null) {
            this._number_.parent(null);
        }
        if (number_ != null) {
            if (number_.parent() != null) {
                number_.parent().removeChild(number_);
            }
            number_.parent(this);
        }
        this._number_ = number_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._number_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._number_ == node) {
            this._number_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._number_ == node) {
            this.setNumber((PNumber)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
