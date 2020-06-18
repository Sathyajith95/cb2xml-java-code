// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ANationalUsagePhrase extends PUsagePhrase
{
    private TNational _national_;
    
    public ANationalUsagePhrase() {
    }
    
    public ANationalUsagePhrase(final TNational national) {
        this.setNational(national);
    }
    
    @Override
    public Object clone() {
        return new ANationalUsagePhrase(this.cloneNode(this._national_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseANationalUsagePhrase(this);
    }
    
    public TNational getNational() {
        return this._national_;
    }
    
    public void setNational(final TNational national_) {
        if (this._national_ != null) {
            this._national_.parent(null);
        }
        if (national_ != null) {
            if (national_.parent() != null) {
                national_.parent().removeChild(national_);
            }
            national_.parent(this);
        }
        this._national_ = national_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._national_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._national_ == node) {
            this._national_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._national_ == node) {
            this.setNational((TNational)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
