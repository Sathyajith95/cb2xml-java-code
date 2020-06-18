// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class APackedDecimalUsagePhrase extends PUsagePhrase
{
    private TPackedDecimal _packedDecimal_;
    
    public APackedDecimalUsagePhrase() {
    }
    
    public APackedDecimalUsagePhrase(final TPackedDecimal packedDecimal) {
        this.setPackedDecimal(packedDecimal);
    }
    
    @Override
    public Object clone() {
        return new APackedDecimalUsagePhrase(this.cloneNode(this._packedDecimal_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAPackedDecimalUsagePhrase(this);
    }
    
    public TPackedDecimal getPackedDecimal() {
        return this._packedDecimal_;
    }
    
    public void setPackedDecimal(final TPackedDecimal packedDecimal_) {
        if (this._packedDecimal_ != null) {
            this._packedDecimal_.parent(null);
        }
        if (packedDecimal_ != null) {
            if (packedDecimal_.parent() != null) {
                packedDecimal_.parent().removeChild(packedDecimal_);
            }
            packedDecimal_.parent(this);
        }
        this._packedDecimal_ = packedDecimal_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._packedDecimal_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._packedDecimal_ == node) {
            this._packedDecimal_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._packedDecimal_ == node) {
            this.setPackedDecimal((TPackedDecimal)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
