// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AZerosLiteral extends PLiteral
{
    private TZeros _zeros_;
    
    public AZerosLiteral() {
    }
    
    public AZerosLiteral(final TZeros zeros) {
        this.setZeros(zeros);
    }
    
    @Override
    public Object clone() {
        return new AZerosLiteral(this.cloneNode(this._zeros_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAZerosLiteral(this);
    }
    
    public TZeros getZeros() {
        return this._zeros_;
    }
    
    public void setZeros(final TZeros zeros_) {
        if (this._zeros_ != null) {
            this._zeros_.parent(null);
        }
        if (zeros_ != null) {
            if (zeros_.parent() != null) {
                zeros_.parent().removeChild(zeros_);
            }
            zeros_.parent(this);
        }
        this._zeros_ = zeros_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._zeros_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._zeros_ == node) {
            this._zeros_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._zeros_ == node) {
            this.setZeros((TZeros)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
