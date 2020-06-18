// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AThroughSequenceLiteralSequence extends PLiteralSequence
{
    private PLiteralSequence _literalSequence_;
    private TComma _comma_;
    private PLiteral _from_;
    private TThrough _through_;
    private PLiteral _to_;
    
    public AThroughSequenceLiteralSequence() {
    }
    
    public AThroughSequenceLiteralSequence(final PLiteralSequence literalSequence, final TComma comma, final PLiteral from, final TThrough through, final PLiteral to) {
        this.setLiteralSequence(literalSequence);
        this.setComma(comma);
        this.setFrom(from);
        this.setThrough(through);
        this.setTo(to);
    }
    
    @Override
    public Object clone() {
        return new AThroughSequenceLiteralSequence(this.cloneNode(this._literalSequence_), this.cloneNode(this._comma_), this.cloneNode(this._from_), this.cloneNode(this._through_), this.cloneNode(this._to_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAThroughSequenceLiteralSequence(this);
    }
    
    public PLiteralSequence getLiteralSequence() {
        return this._literalSequence_;
    }
    
    public void setLiteralSequence(final PLiteralSequence literalSequence_) {
        if (this._literalSequence_ != null) {
            this._literalSequence_.parent(null);
        }
        if (literalSequence_ != null) {
            if (literalSequence_.parent() != null) {
                literalSequence_.parent().removeChild(literalSequence_);
            }
            literalSequence_.parent(this);
        }
        this._literalSequence_ = literalSequence_;
    }
    
    public TComma getComma() {
        return this._comma_;
    }
    
    public void setComma(final TComma comma_) {
        if (this._comma_ != null) {
            this._comma_.parent(null);
        }
        if (comma_ != null) {
            if (comma_.parent() != null) {
                comma_.parent().removeChild(comma_);
            }
            comma_.parent(this);
        }
        this._comma_ = comma_;
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
        return "" + this.toString(this._literalSequence_) + this.toString(this._comma_) + this.toString(this._from_) + this.toString(this._through_) + this.toString(this._to_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._literalSequence_ == node) {
            this._literalSequence_ = null;
            return;
        }
        if (this._comma_ == node) {
            this._comma_ = null;
            return;
        }
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
        if (this._literalSequence_ == node) {
            this.setLiteralSequence((PLiteralSequence)node2);
            return;
        }
        if (this._comma_ == node) {
            this.setComma((TComma)node2);
            return;
        }
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
