// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ADollarCharacterSubstring extends PCharacterSubstring
{
    private TDollar _dollar_;
    
    public ADollarCharacterSubstring() {
    }
    
    public ADollarCharacterSubstring(final TDollar dollar) {
        this.setDollar(dollar);
    }
    
    @Override
    public Object clone() {
        return new ADollarCharacterSubstring(this.cloneNode(this._dollar_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseADollarCharacterSubstring(this);
    }
    
    public TDollar getDollar() {
        return this._dollar_;
    }
    
    public void setDollar(final TDollar dollar_) {
        if (this._dollar_ != null) {
            this._dollar_.parent(null);
        }
        if (dollar_ != null) {
            if (dollar_.parent() != null) {
                dollar_.parent().removeChild(dollar_);
            }
            dollar_.parent(this);
        }
        this._dollar_ = dollar_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._dollar_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._dollar_ == node) {
            this._dollar_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._dollar_ == node) {
            this.setDollar((TDollar)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
