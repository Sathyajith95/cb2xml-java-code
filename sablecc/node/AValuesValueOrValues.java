// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AValuesValueOrValues extends PValueOrValues
{
    private TValues _values_;
    private TAre _are_;
    
    public AValuesValueOrValues() {
    }
    
    public AValuesValueOrValues(final TValues values, final TAre are) {
        this.setValues(values);
        this.setAre(are);
    }
    
    @Override
    public Object clone() {
        return new AValuesValueOrValues(this.cloneNode(this._values_), this.cloneNode(this._are_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAValuesValueOrValues(this);
    }
    
    public TValues getValues() {
        return this._values_;
    }
    
    public void setValues(final TValues values_) {
        if (this._values_ != null) {
            this._values_.parent(null);
        }
        if (values_ != null) {
            if (values_.parent() != null) {
                values_.parent().removeChild(values_);
            }
            values_.parent(this);
        }
        this._values_ = values_;
    }
    
    public TAre getAre() {
        return this._are_;
    }
    
    public void setAre(final TAre are_) {
        if (this._are_ != null) {
            this._are_.parent(null);
        }
        if (are_ != null) {
            if (are_.parent() != null) {
                are_.parent().removeChild(are_);
            }
            are_.parent(this);
        }
        this._are_ = are_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._values_) + this.toString(this._are_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._values_ == node) {
            this._values_ = null;
            return;
        }
        if (this._are_ == node) {
            this._are_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._values_ == node) {
            this.setValues((TValues)node2);
            return;
        }
        if (this._are_ == node) {
            this.setAre((TAre)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
