// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AFixedOccursFixedOrVariable extends POccursFixedOrVariable
{
    private TOccurs _occurs_;
    private PNumber _number_;
    private TTimes _times_;
    
    public AFixedOccursFixedOrVariable() {
    }
    
    public AFixedOccursFixedOrVariable(final TOccurs occurs, final PNumber number, final TTimes times) {
        this.setOccurs(occurs);
        this.setNumber(number);
        this.setTimes(times);
    }
    
    @Override
    public Object clone() {
        return new AFixedOccursFixedOrVariable(this.cloneNode(this._occurs_), this.cloneNode(this._number_), this.cloneNode(this._times_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAFixedOccursFixedOrVariable(this);
    }
    
    public TOccurs getOccurs() {
        return this._occurs_;
    }
    
    public void setOccurs(final TOccurs occurs_) {
        if (this._occurs_ != null) {
            this._occurs_.parent(null);
        }
        if (occurs_ != null) {
            if (occurs_.parent() != null) {
                occurs_.parent().removeChild(occurs_);
            }
            occurs_.parent(this);
        }
        this._occurs_ = occurs_;
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
    
    public TTimes getTimes() {
        return this._times_;
    }
    
    public void setTimes(final TTimes times_) {
        if (this._times_ != null) {
            this._times_.parent(null);
        }
        if (times_ != null) {
            if (times_.parent() != null) {
                times_.parent().removeChild(times_);
            }
            times_.parent(this);
        }
        this._times_ = times_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._occurs_) + this.toString(this._number_) + this.toString(this._times_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._occurs_ == node) {
            this._occurs_ = null;
            return;
        }
        if (this._number_ == node) {
            this._number_ = null;
            return;
        }
        if (this._times_ == node) {
            this._times_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._occurs_ == node) {
            this.setOccurs((TOccurs)node2);
            return;
        }
        if (this._number_ == node) {
            this.setNumber((PNumber)node2);
            return;
        }
        if (this._times_ == node) {
            this.setTimes((TTimes)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
