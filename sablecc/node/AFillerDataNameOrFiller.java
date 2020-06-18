// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AFillerDataNameOrFiller extends PDataNameOrFiller
{
    private TFiller _filler_;
    
    public AFillerDataNameOrFiller() {
    }
    
    public AFillerDataNameOrFiller(final TFiller filler) {
        this.setFiller(filler);
    }
    
    @Override
    public Object clone() {
        return new AFillerDataNameOrFiller(this.cloneNode(this._filler_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAFillerDataNameOrFiller(this);
    }
    
    public TFiller getFiller() {
        return this._filler_;
    }
    
    public void setFiller(final TFiller filler_) {
        if (this._filler_ != null) {
            this._filler_.parent(null);
        }
        if (filler_ != null) {
            if (filler_.parent() != null) {
                filler_.parent().removeChild(filler_);
            }
            filler_.parent(this);
        }
        this._filler_ = filler_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._filler_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._filler_ == node) {
            this._filler_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._filler_ == node) {
            this.setFiller((TFiller)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
