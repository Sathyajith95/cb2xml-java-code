// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ASequenceCharacterString extends PCharacterString
{
    private PCharacterString _characterString_;
    private PCharacterSubstring _characterSubstring_;
    
    public ASequenceCharacterString() {
    }
    
    public ASequenceCharacterString(final PCharacterString characterString, final PCharacterSubstring characterSubstring) {
        this.setCharacterString(characterString);
        this.setCharacterSubstring(characterSubstring);
    }
    
    @Override
    public Object clone() {
        return new ASequenceCharacterString(this.cloneNode(this._characterString_), this.cloneNode(this._characterSubstring_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseASequenceCharacterString(this);
    }
    
    public PCharacterString getCharacterString() {
        return this._characterString_;
    }
    
    public void setCharacterString(final PCharacterString characterString_) {
        if (this._characterString_ != null) {
            this._characterString_.parent(null);
        }
        if (characterString_ != null) {
            if (characterString_.parent() != null) {
                characterString_.parent().removeChild(characterString_);
            }
            characterString_.parent(this);
        }
        this._characterString_ = characterString_;
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
        return "" + this.toString(this._characterString_) + this.toString(this._characterSubstring_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._characterString_ == node) {
            this._characterString_ = null;
            return;
        }
        if (this._characterSubstring_ == node) {
            this._characterSubstring_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._characterString_ == node) {
            this.setCharacterString((PCharacterString)node2);
            return;
        }
        if (this._characterSubstring_ == node) {
            this.setCharacterSubstring((PCharacterSubstring)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
