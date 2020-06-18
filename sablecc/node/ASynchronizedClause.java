// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ASynchronizedClause extends PSynchronizedClause
{
    private TSynchronized _synchronized_;
    private PLeftOrRight _leftOrRight_;
    
    public ASynchronizedClause() {
    }
    
    public ASynchronizedClause(final TSynchronized synchronized1, final PLeftOrRight leftOrRight) {
        this.setSynchronized(synchronized1);
        this.setLeftOrRight(leftOrRight);
    }
    
    @Override
    public Object clone() {
        return new ASynchronizedClause(this.cloneNode(this._synchronized_), this.cloneNode(this._leftOrRight_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseASynchronizedClause(this);
    }
    
    public TSynchronized getSynchronized() {
        return this._synchronized_;
    }
    
    public void setSynchronized(final TSynchronized synchronized_) {
        if (this._synchronized_ != null) {
            this._synchronized_.parent(null);
        }
        if (synchronized_ != null) {
            if (synchronized_.parent() != null) {
                synchronized_.parent().removeChild(synchronized_);
            }
            synchronized_.parent(this);
        }
        this._synchronized_ = synchronized_;
    }
    
    public PLeftOrRight getLeftOrRight() {
        return this._leftOrRight_;
    }
    
    public void setLeftOrRight(final PLeftOrRight leftOrRight_) {
        if (this._leftOrRight_ != null) {
            this._leftOrRight_.parent(null);
        }
        if (leftOrRight_ != null) {
            if (leftOrRight_.parent() != null) {
                leftOrRight_.parent().removeChild(leftOrRight_);
            }
            leftOrRight_.parent(this);
        }
        this._leftOrRight_ = leftOrRight_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._synchronized_) + this.toString(this._leftOrRight_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._synchronized_ == node) {
            this._synchronized_ = null;
            return;
        }
        if (this._leftOrRight_ == node) {
            this._leftOrRight_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._synchronized_ == node) {
            this.setSynchronized((TSynchronized)node2);
            return;
        }
        if (this._leftOrRight_ == node) {
            this.setLeftOrRight((PLeftOrRight)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
