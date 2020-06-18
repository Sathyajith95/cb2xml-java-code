// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ASeparateCharacter extends PSeparateCharacter
{
    private TSeparate _separate_;
    private TCharacter _character_;
    
    public ASeparateCharacter() {
    }
    
    public ASeparateCharacter(final TSeparate separate, final TCharacter character) {
        this.setSeparate(separate);
        this.setCharacter(character);
    }
    
    @Override
    public Object clone() {
        return new ASeparateCharacter(this.cloneNode(this._separate_), this.cloneNode(this._character_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseASeparateCharacter(this);
    }
    
    public TSeparate getSeparate() {
        return this._separate_;
    }
    
    public void setSeparate(final TSeparate separate_) {
        if (this._separate_ != null) {
            this._separate_.parent(null);
        }
        if (separate_ != null) {
            if (separate_.parent() != null) {
                separate_.parent().removeChild(separate_);
            }
            separate_.parent(this);
        }
        this._separate_ = separate_;
    }
    
    public TCharacter getCharacter() {
        return this._character_;
    }
    
    public void setCharacter(final TCharacter character_) {
        if (this._character_ != null) {
            this._character_.parent(null);
        }
        if (character_ != null) {
            if (character_.parent() != null) {
                character_.parent().removeChild(character_);
            }
            character_.parent(this);
        }
        this._character_ = character_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._separate_) + this.toString(this._character_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._separate_ == node) {
            this._separate_ = null;
            return;
        }
        if (this._character_ == node) {
            this._character_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._separate_ == node) {
            this.setSeparate((TSeparate)node2);
            return;
        }
        if (this._character_ == node) {
            this.setCharacter((TCharacter)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
