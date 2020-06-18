// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AHighValuesLiteral extends PLiteral
{
    private THighValues _highValues_;
    
    public AHighValuesLiteral() {
    }
    
    public AHighValuesLiteral(final THighValues highValues) {
        this.setHighValues(highValues);
    }
    
    @Override
    public Object clone() {
        return new AHighValuesLiteral(this.cloneNode(this._highValues_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAHighValuesLiteral(this);
    }
    
    public THighValues getHighValues() {
        return this._highValues_;
    }
    
    public void setHighValues(final THighValues highValues_) {
        if (this._highValues_ != null) {
            this._highValues_.parent(null);
        }
        if (highValues_ != null) {
            if (highValues_.parent() != null) {
                highValues_.parent().removeChild(highValues_);
            }
            highValues_.parent(this);
        }
        this._highValues_ = highValues_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._highValues_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._highValues_ == node) {
            this._highValues_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._highValues_ == node) {
            this.setHighValues((THighValues)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
