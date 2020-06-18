// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ALeftLeftOrRight extends PLeftOrRight
{
    private TLeft _left_;
    
    public ALeftLeftOrRight() {
    }
    
    public ALeftLeftOrRight(final TLeft left) {
        this.setLeft(left);
    }
    
    @Override
    public Object clone() {
        return new ALeftLeftOrRight(this.cloneNode(this._left_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseALeftLeftOrRight(this);
    }
    
    public TLeft getLeft() {
        return this._left_;
    }
    
    public void setLeft(final TLeft left_) {
        if (this._left_ != null) {
            this._left_.parent(null);
        }
        if (left_ != null) {
            if (left_.parent() != null) {
                left_.parent().removeChild(left_);
            }
            left_.parent(this);
        }
        this._left_ = left_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._left_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._left_ == node) {
            this._left_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._left_ == node) {
            this.setLeft((TLeft)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
