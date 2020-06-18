// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ADotPlusCharacterSubstring extends PCharacterSubstring
{
    private TDotPlus _dotPlus_;
    
    public ADotPlusCharacterSubstring() {
    }
    
    public ADotPlusCharacterSubstring(final TDotPlus dotPlus) {
        this.setDotPlus(dotPlus);
    }
    
    @Override
    public Object clone() {
        return new ADotPlusCharacterSubstring(this.cloneNode(this._dotPlus_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseADotPlusCharacterSubstring(this);
    }
    
    public TDotPlus getDotPlus() {
        return this._dotPlus_;
    }
    
    public void setDotPlus(final TDotPlus dotPlus_) {
        if (this._dotPlus_ != null) {
            this._dotPlus_.parent(null);
        }
        if (dotPlus_ != null) {
            if (dotPlus_.parent() != null) {
                dotPlus_.parent().removeChild(dotPlus_);
            }
            dotPlus_.parent(this);
        }
        this._dotPlus_ = dotPlus_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._dotPlus_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._dotPlus_ == node) {
            this._dotPlus_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._dotPlus_ == node) {
            this.setDotPlus((TDotPlus)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
