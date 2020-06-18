// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ASingleCharacterString extends PCharacterString
{
    private PCharacterSubstring _characterSubstring_;
    
    public ASingleCharacterString() {
    }
    
    public ASingleCharacterString(final PCharacterSubstring characterSubstring) {
        this.setCharacterSubstring(characterSubstring);
    }
    
    @Override
    public Object clone() {
        return new ASingleCharacterString(this.cloneNode(this._characterSubstring_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseASingleCharacterString(this);
    }
    
    public PCharacterSubstring getCharacterSubstring() {
        return this._characterSubstring_;
    }
    
    public void setCharacterSubstring(final PCharacterSubstring characterSubstring_) {
        if (this._characterSubstring_ != null) {
            this._characterSubstring_.parent(null);
        }
        if (characterSubstring_ != null) {
            if (characterSubstring_.parent() != null) {
                characterSubstring_.parent().removeChild(characterSubstring_);
            }
            characterSubstring_.parent(this);
        }
        this._characterSubstring_ = characterSubstring_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._characterSubstring_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._characterSubstring_ == node) {
            this._characterSubstring_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._characterSubstring_ == node) {
            this.setCharacterSubstring((PCharacterSubstring)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
