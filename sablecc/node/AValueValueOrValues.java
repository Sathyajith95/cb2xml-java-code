// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AValueValueOrValues extends PValueOrValues
{
    private TValue _value_;
    private TIs _is_;
    
    public AValueValueOrValues() {
    }
    
    public AValueValueOrValues(final TValue value, final TIs is) {
        this.setValue(value);
        this.setIs(is);
    }
    
    @Override
    public Object clone() {
        return new AValueValueOrValues(this.cloneNode(this._value_), this.cloneNode(this._is_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAValueValueOrValues(this);
    }
    
    public TValue getValue() {
        return this._value_;
    }
    
    public void setValue(final TValue value_) {
        if (this._value_ != null) {
            this._value_.parent(null);
        }
        if (value_ != null) {
            if (value_.parent() != null) {
                value_.parent().removeChild(value_);
            }
            value_.parent(this);
        }
        this._value_ = value_;
    }
    
    public TIs getIs() {
        return this._is_;
    }
    
    public void setIs(final TIs is_) {
        if (this._is_ != null) {
            this._is_.parent(null);
        }
        if (is_ != null) {
            if (is_.parent() != null) {
                is_.parent().removeChild(is_);
            }
            is_.parent(this);
        }
        this._is_ = is_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._value_) + this.toString(this._is_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._value_ == node) {
            this._value_ = null;
            return;
        }
        if (this._is_ == node) {
            this._is_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._value_ == node) {
            this.setValue((TValue)node2);
            return;
        }
        if (this._is_ == node) {
            this.setIs((TIs)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
