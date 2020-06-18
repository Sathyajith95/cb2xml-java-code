// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ASpacesLiteral extends PLiteral
{
    private TSpaces _spaces_;
    
    public ASpacesLiteral() {
    }
    
    public ASpacesLiteral(final TSpaces spaces) {
        this.setSpaces(spaces);
    }
    
    @Override
    public Object clone() {
        return new ASpacesLiteral(this.cloneNode(this._spaces_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseASpacesLiteral(this);
    }
    
    public TSpaces getSpaces() {
        return this._spaces_;
    }
    
    public void setSpaces(final TSpaces spaces_) {
        if (this._spaces_ != null) {
            this._spaces_.parent(null);
        }
        if (spaces_ != null) {
            if (spaces_.parent() != null) {
                spaces_.parent().removeChild(spaces_);
            }
            spaces_.parent(this);
        }
        this._spaces_ = spaces_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._spaces_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._spaces_ == node) {
            this._spaces_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._spaces_ == node) {
            this.setSpaces((TSpaces)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
