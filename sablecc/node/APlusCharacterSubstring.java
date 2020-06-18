// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class APlusCharacterSubstring extends PCharacterSubstring
{
    private TPlus _plus_;
    
    public APlusCharacterSubstring() {
    }
    
    public APlusCharacterSubstring(final TPlus plus) {
        this.setPlus(plus);
    }
    
    @Override
    public Object clone() {
        return new APlusCharacterSubstring(this.cloneNode(this._plus_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAPlusCharacterSubstring(this);
    }
    
    public TPlus getPlus() {
        return this._plus_;
    }
    
    public void setPlus(final TPlus plus_) {
        if (this._plus_ != null) {
            this._plus_.parent(null);
        }
        if (plus_ != null) {
            if (plus_.parent() != null) {
                plus_.parent().removeChild(plus_);
            }
            plus_.parent(this);
        }
        this._plus_ = plus_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._plus_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._plus_ == node) {
            this._plus_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._plus_ == node) {
            this.setPlus((TPlus)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
