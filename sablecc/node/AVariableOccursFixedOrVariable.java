// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AVariableOccursFixedOrVariable extends POccursFixedOrVariable
{
    private TOccurs _occurs_;
    private POccursTo _occursTo_;
    private PNumber _number_;
    private TTimes _times_;
    private TDepending _depending_;
    private TOn _on_;
    private TDataName _dataName_;
    
    public AVariableOccursFixedOrVariable() {
    }
    
    public AVariableOccursFixedOrVariable(final TOccurs occurs, final POccursTo occursTo, final PNumber number, final TTimes times, final TDepending depending, final TOn on, final TDataName dataName) {
        this.setOccurs(occurs);
        this.setOccursTo(occursTo);
        this.setNumber(number);
        this.setTimes(times);
        this.setDepending(depending);
        this.setOn(on);
        this.setDataName(dataName);
    }
    
    @Override
    public Object clone() {
        return new AVariableOccursFixedOrVariable(this.cloneNode(this._occurs_), this.cloneNode(this._occursTo_), this.cloneNode(this._number_), this.cloneNode(this._times_), this.cloneNode(this._depending_), this.cloneNode(this._on_), this.cloneNode(this._dataName_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAVariableOccursFixedOrVariable(this);
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
    
    public POccursTo getOccursTo() {
        return this._occursTo_;
    }
    
    public void setOccursTo(final POccursTo occursTo_) {
        if (this._occursTo_ != null) {
            this._occursTo_.parent(null);
        }
        if (occursTo_ != null) {
            if (occursTo_.parent() != null) {
                occursTo_.parent().removeChild(occursTo_);
            }
            occursTo_.parent(this);
        }
        this._occursTo_ = occursTo_;
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
    
    public TDepending getDepending() {
        return this._depending_;
    }
    
    public void setDepending(final TDepending depending_) {
        if (this._depending_ != null) {
            this._depending_.parent(null);
        }
        if (depending_ != null) {
            if (depending_.parent() != null) {
                depending_.parent().removeChild(depending_);
            }
            depending_.parent(this);
        }
        this._depending_ = depending_;
    }
    
    public TOn getOn() {
        return this._on_;
    }
    
    public void setOn(final TOn on_) {
        if (this._on_ != null) {
            this._on_.parent(null);
        }
        if (on_ != null) {
            if (on_.parent() != null) {
                on_.parent().removeChild(on_);
            }
            on_.parent(this);
        }
        this._on_ = on_;
    }
    
    public TDataName getDataName() {
        return this._dataName_;
    }
    
    public void setDataName(final TDataName dataName_) {
        if (this._dataName_ != null) {
            this._dataName_.parent(null);
        }
        if (dataName_ != null) {
            if (dataName_.parent() != null) {
                dataName_.parent().removeChild(dataName_);
            }
            dataName_.parent(this);
        }
        this._dataName_ = dataName_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._occurs_) + this.toString(this._occursTo_) + this.toString(this._number_) + this.toString(this._times_) + this.toString(this._depending_) + this.toString(this._on_) + this.toString(this._dataName_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._occurs_ == node) {
            this._occurs_ = null;
            return;
        }
        if (this._occursTo_ == node) {
            this._occursTo_ = null;
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
        if (this._depending_ == node) {
            this._depending_ = null;
            return;
        }
        if (this._on_ == node) {
            this._on_ = null;
            return;
        }
        if (this._dataName_ == node) {
            this._dataName_ = null;
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
        if (this._occursTo_ == node) {
            this.setOccursTo((POccursTo)node2);
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
        if (this._depending_ == node) {
            this.setDepending((TDepending)node2);
            return;
        }
        if (this._on_ == node) {
            this.setOn((TOn)node2);
            return;
        }
        if (this._dataName_ == node) {
            this.setDataName((TDataName)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
