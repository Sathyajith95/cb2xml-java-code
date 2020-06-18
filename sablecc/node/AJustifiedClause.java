// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AJustifiedClause extends PJustifiedClause
{
    private TJustified _justified_;
    private TRight _right_;
    
    public AJustifiedClause() {
    }
    
    public AJustifiedClause(final TJustified justified, final TRight right) {
        this.setJustified(justified);
        this.setRight(right);
    }
    
    @Override
    public Object clone() {
        return new AJustifiedClause(this.cloneNode(this._justified_), this.cloneNode(this._right_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAJustifiedClause(this);
    }
    
    public TJustified getJustified() {
        return this._justified_;
    }
    
    public void setJustified(final TJustified justified_) {
        if (this._justified_ != null) {
            this._justified_.parent(null);
        }
        if (justified_ != null) {
            if (justified_.parent() != null) {
                justified_.parent().removeChild(justified_);
            }
            justified_.parent(this);
        }
        this._justified_ = justified_;
    }
    
    public TRight getRight() {
        return this._right_;
    }
    
    public void setRight(final TRight right_) {
        if (this._right_ != null) {
            this._right_.parent(null);
        }
        if (right_ != null) {
            if (right_.parent() != null) {
                right_.parent().removeChild(right_);
            }
            right_.parent(this);
        }
        this._right_ = right_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._justified_) + this.toString(this._right_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._justified_ == node) {
            this._justified_ = null;
            return;
        }
        if (this._right_ == node) {
            this._right_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._justified_ == node) {
            this.setJustified((TJustified)node2);
            return;
        }
        if (this._right_ == node) {
            this.setRight((TRight)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
