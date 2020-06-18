// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AOccursTo extends POccursTo
{
    private PNumber _number_;
    private TTo _to_;
    
    public AOccursTo() {
    }
    
    public AOccursTo(final PNumber number, final TTo to) {
        this.setNumber(number);
        this.setTo(to);
    }
    
    @Override
    public Object clone() {
        return new AOccursTo(this.cloneNode(this._number_), this.cloneNode(this._to_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAOccursTo(this);
    }
    
    public PNumber getNumber() {
        return this._number_;
    }
    
    public void setNumber(final PNumber number_) {
        if (this._number_ != null) {
            this._number_.parent(null);
        }
        if (number_ != null) {
            if (number_.parent() != null) {
                number_.parent().removeChild(number_);
            }
            number_.parent(this);
        }
        this._number_ = number_;
    }
    
    public TTo getTo() {
        return this._to_;
    }
    
    public void setTo(final TTo to_) {
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
        return "" + this.toString(this._number_) + this.toString(this._to_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._number_ == node) {
            this._number_ = null;
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
        if (this._number_ == node) {
            this.setNumber((PNumber)node2);
            return;
        }
        if (this._to_ == node) {
            this.setTo((TTo)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
