// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ACommaCharacterSubstring extends PCharacterSubstring
{
    private TComma _comma_;
    
    public ACommaCharacterSubstring() {
    }
    
    public ACommaCharacterSubstring(final TComma comma) {
        this.setComma(comma);
    }
    
    @Override
    public Object clone() {
        return new ACommaCharacterSubstring(this.cloneNode(this._comma_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseACommaCharacterSubstring(this);
    }
    
    public TComma getComma() {
        return this._comma_;
    }
    
    public void setComma(final TComma comma_) {
        if (this._comma_ != null) {
            this._comma_.parent(null);
        }
        if (comma_ != null) {
            if (comma_.parent() != null) {
                comma_.parent().removeChild(comma_);
            }
            comma_.parent(this);
        }
        this._comma_ = comma_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._comma_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._comma_ == node) {
            this._comma_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._comma_ == node) {
            this.setComma((TComma)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
