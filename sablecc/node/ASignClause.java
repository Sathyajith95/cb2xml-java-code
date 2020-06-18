// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ASignClause extends PSignClause
{
    private PSignIs _signIs_;
    private PLeadingOrTrailing _leadingOrTrailing_;
    private PSeparateCharacter _separateCharacter_;
    
    public ASignClause() {
    }
    
    public ASignClause(final PSignIs signIs, final PLeadingOrTrailing leadingOrTrailing, final PSeparateCharacter separateCharacter) {
        this.setSignIs(signIs);
        this.setLeadingOrTrailing(leadingOrTrailing);
        this.setSeparateCharacter(separateCharacter);
    }
    
    @Override
    public Object clone() {
        return new ASignClause(this.cloneNode(this._signIs_), this.cloneNode(this._leadingOrTrailing_), this.cloneNode(this._separateCharacter_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseASignClause(this);
    }
    
    public PSignIs getSignIs() {
        return this._signIs_;
    }
    
    public void setSignIs(final PSignIs signIs_) {
        if (this._signIs_ != null) {
            this._signIs_.parent(null);
        }
        if (signIs_ != null) {
            if (signIs_.parent() != null) {
                signIs_.parent().removeChild(signIs_);
            }
            signIs_.parent(this);
        }
        this._signIs_ = signIs_;
    }
    
    public PLeadingOrTrailing getLeadingOrTrailing() {
        return this._leadingOrTrailing_;
    }
    
    public void setLeadingOrTrailing(final PLeadingOrTrailing leadingOrTrailing_) {
        if (this._leadingOrTrailing_ != null) {
            this._leadingOrTrailing_.parent(null);
        }
        if (leadingOrTrailing_ != null) {
            if (leadingOrTrailing_.parent() != null) {
                leadingOrTrailing_.parent().removeChild(leadingOrTrailing_);
            }
            leadingOrTrailing_.parent(this);
        }
        this._leadingOrTrailing_ = leadingOrTrailing_;
    }
    
    public PSeparateCharacter getSeparateCharacter() {
        return this._separateCharacter_;
    }
    
    public void setSeparateCharacter(final PSeparateCharacter separateCharacter_) {
        if (this._separateCharacter_ != null) {
            this._separateCharacter_.parent(null);
        }
        if (separateCharacter_ != null) {
            if (separateCharacter_.parent() != null) {
                separateCharacter_.parent().removeChild(separateCharacter_);
            }
            separateCharacter_.parent(this);
        }
        this._separateCharacter_ = separateCharacter_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._signIs_) + this.toString(this._leadingOrTrailing_) + this.toString(this._separateCharacter_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._signIs_ == node) {
            this._signIs_ = null;
            return;
        }
        if (this._leadingOrTrailing_ == node) {
            this._leadingOrTrailing_ = null;
            return;
        }
        if (this._separateCharacter_ == node) {
            this._separateCharacter_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._signIs_ == node) {
            this.setSignIs((PSignIs)node2);
            return;
        }
        if (this._leadingOrTrailing_ == node) {
            this.setLeadingOrTrailing((PLeadingOrTrailing)node2);
            return;
        }
        if (this._separateCharacter_ == node) {
            this.setSeparateCharacter((PSeparateCharacter)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
