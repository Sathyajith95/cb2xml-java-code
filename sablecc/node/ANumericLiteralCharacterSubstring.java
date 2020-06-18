// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ANumericLiteralCharacterSubstring extends PCharacterSubstring
{
    private TNumericLiteral _numericLiteral_;
    
    public ANumericLiteralCharacterSubstring() {
    }
    
    public ANumericLiteralCharacterSubstring(final TNumericLiteral numericLiteral) {
        this.setNumericLiteral(numericLiteral);
    }
    
    @Override
    public Object clone() {
        return new ANumericLiteralCharacterSubstring(this.cloneNode(this._numericLiteral_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseANumericLiteralCharacterSubstring(this);
    }
    
    public TNumericLiteral getNumericLiteral() {
        return this._numericLiteral_;
    }
    
    public void setNumericLiteral(final TNumericLiteral numericLiteral_) {
        if (this._numericLiteral_ != null) {
            this._numericLiteral_.parent(null);
        }
        if (numericLiteral_ != null) {
            if (numericLiteral_.parent() != null) {
                numericLiteral_.parent().removeChild(numericLiteral_);
            }
            numericLiteral_.parent(this);
        }
        this._numericLiteral_ = numericLiteral_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._numericLiteral_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._numericLiteral_ == node) {
            this._numericLiteral_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._numericLiteral_ == node) {
            this.setNumericLiteral((TNumericLiteral)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
