// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AAlphanumericLiteralLiteral extends PLiteral
{
    private TAlphanumericLiteral _alphanumericLiteral_;
    
    public AAlphanumericLiteralLiteral() {
    }
    
    public AAlphanumericLiteralLiteral(final TAlphanumericLiteral alphanumericLiteral) {
        this.setAlphanumericLiteral(alphanumericLiteral);
    }
    
    @Override
    public Object clone() {
        return new AAlphanumericLiteralLiteral(this.cloneNode(this._alphanumericLiteral_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAAlphanumericLiteralLiteral(this);
    }
    
    public TAlphanumericLiteral getAlphanumericLiteral() {
        return this._alphanumericLiteral_;
    }
    
    public void setAlphanumericLiteral(final TAlphanumericLiteral alphanumericLiteral_) {
        if (this._alphanumericLiteral_ != null) {
            this._alphanumericLiteral_.parent(null);
        }
        if (alphanumericLiteral_ != null) {
            if (alphanumericLiteral_.parent() != null) {
                alphanumericLiteral_.parent().removeChild(alphanumericLiteral_);
            }
            alphanumericLiteral_.parent(this);
        }
        this._alphanumericLiteral_ = alphanumericLiteral_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._alphanumericLiteral_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._alphanumericLiteral_ == node) {
            this._alphanumericLiteral_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._alphanumericLiteral_ == node) {
            this.setAlphanumericLiteral((TAlphanumericLiteral)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
