// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ARightLeftOrRight extends PLeftOrRight
{
    private TRight _right_;
    
    public ARightLeftOrRight() {
    }
    
    public ARightLeftOrRight(final TRight right) {
        this.setRight(right);
    }
    
    @Override
    public Object clone() {
        return new ARightLeftOrRight(this.cloneNode(this._right_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseARightLeftOrRight(this);
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
        return "" + this.toString(this._right_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._right_ == node) {
            this._right_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._right_ == node) {
            this.setRight((TRight)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
