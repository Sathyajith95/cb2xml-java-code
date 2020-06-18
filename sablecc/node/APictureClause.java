// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class APictureClause extends PPictureClause
{
    private TPicture _picture_;
    private TIs _is_;
    private PCharacterString _characterString_;
    
    public APictureClause() {
    }
    
    public APictureClause(final TPicture picture, final TIs is, final PCharacterString characterString) {
        this.setPicture(picture);
        this.setIs(is);
        this.setCharacterString(characterString);
    }
    
    @Override
    public Object clone() {
        return new APictureClause(this.cloneNode(this._picture_), this.cloneNode(this._is_), this.cloneNode(this._characterString_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAPictureClause(this);
    }
    
    public TPicture getPicture() {
        return this._picture_;
    }
    
    public void setPicture(final TPicture picture_) {
        if (this._picture_ != null) {
            this._picture_.parent(null);
        }
        if (picture_ != null) {
            if (picture_.parent() != null) {
                picture_.parent().removeChild(picture_);
            }
            picture_.parent(this);
        }
        this._picture_ = picture_;
    }
    
    public TIs getIs() {
        return this._is_;
    }
    
    public void setIs(final TIs is_) {
        if (this._is_ != null) {
            this._is_.parent(null);
        }
        if (is_ != null) {
            if (is_.parent() != null) {
                is_.parent().removeChild(is_);
            }
            is_.parent(this);
        }
        this._is_ = is_;
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
    
    @Override
    public String toString() {
        return "" + this.toString(this._picture_) + this.toString(this._is_) + this.toString(this._characterString_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._picture_ == node) {
            this._picture_ = null;
            return;
        }
        if (this._is_ == node) {
            this._is_ = null;
            return;
        }
        if (this._characterString_ == node) {
            this._characterString_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._picture_ == node) {
            this.setPicture((TPicture)node2);
            return;
        }
        if (this._is_ == node) {
            this.setIs((TIs)node2);
            return;
        }
        if (this._characterString_ == node) {
            this.setCharacterString((PCharacterString)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
