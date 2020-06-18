// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AThroughSingleLiteralSequence extends PLiteralSequence
{
    private PLiteral _from_;
    private TThrough _through_;
    private PLiteral _to_;
    
    public AThroughSingleLiteralSequence() {
    }
    
    public AThroughSingleLiteralSequence(final PLiteral from, final TThrough through, final PLiteral to) {
        this.setFrom(from);
        this.setThrough(through);
        this.setTo(to);
    }
    
    @Override
    public Object clone() {
        return new AThroughSingleLiteralSequence(this.cloneNode(this._from_), this.cloneNode(this._through_), this.cloneNode(this._to_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAThroughSingleLiteralSequence(this);
    }
    
    public PLiteral getFrom() {
        return this._from_;
    }
    
    public void setFrom(final PLiteral from_) {
        if (this._from_ != null) {
            this._from_.parent(null);
        }
        if (from_ != null) {
            if (from_.parent() != null) {
                from_.parent().removeChild(from_);
            }
            from_.parent(this);
        }
        this._from_ = from_;
    }
    
    public TThrough getThrough() {
        return this._through_;
    }
    
    public void setThrough(final TThrough through_) {
        if (this._through_ != null) {
            this._through_.parent(null);
        }
        if (through_ != null) {
            if (through_.parent() != null) {
                through_.parent().removeChild(through_);
            }
            through_.parent(this);
        }
        this._through_ = through_;
    }
    
    public PLiteral getTo() {
        return this._to_;
    }
    
    public void setTo(final PLiteral to_) {
        if (this._to_ != null) {
            this._to_.parent(null);
        }
        if (to_ != null) {
            if (to_.parent() != null) {
                to_.parent().removeChild(to_);
            }
            to_.parent(this);
        }
        this._to_ = to_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._from_) + this.toString(this._through_) + this.toString(this._to_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._from_ == node) {
            this._from_ = null;
            return;
        }
        if (this._through_ == node) {
            this._through_ = null;
            return;
        }
        if (this._to_ == node) {
            this._to_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._from_ == node) {
            this.setFrom((PLiteral)node2);
            return;
        }
        if (this._through_ == node) {
            this.setThrough((TThrough)node2);
            return;
        }
        if (this._to_ == node) {
            this.setTo((PLiteral)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
