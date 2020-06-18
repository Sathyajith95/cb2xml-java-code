// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AValueClause extends PValueClause
{
    private TValue _value_;
    private TIs _is_;
    private TAll _all_;
    private PLiteral _literal_;
    
    public AValueClause() {
    }
    
    public AValueClause(final TValue value, final TIs is, final TAll all, final PLiteral literal) {
        this.setValue(value);
        this.setIs(is);
        this.setAll(all);
        this.setLiteral(literal);
    }
    
    @Override
    public Object clone() {
        return new AValueClause(this.cloneNode(this._value_), this.cloneNode(this._is_), this.cloneNode(this._all_), this.cloneNode(this._literal_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAValueClause(this);
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
    
    public TAll getAll() {
        return this._all_;
    }
    
    public void setAll(final TAll all_) {
        if (this._all_ != null) {
            this._all_.parent(null);
        }
        if (all_ != null) {
            if (all_.parent() != null) {
                all_.parent().removeChild(all_);
            }
            all_.parent(this);
        }
        this._all_ = all_;
    }
    
    public PLiteral getLiteral() {
        return this._literal_;
    }
    
    public void setLiteral(final PLiteral literal_) {
        if (this._literal_ != null) {
            this._literal_.parent(null);
        }
        if (literal_ != null) {
            if (literal_.parent() != null) {
                literal_.parent().removeChild(literal_);
            }
            literal_.parent(this);
        }
        this._literal_ = literal_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._value_) + this.toString(this._is_) + this.toString(this._all_) + this.toString(this._literal_);
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
        if (this._all_ == node) {
            this._all_ = null;
            return;
        }
        if (this._literal_ == node) {
            this._literal_ = null;
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
        if (this._all_ == node) {
            this.setAll((TAll)node2);
            return;
        }
        if (this._literal_ == node) {
            this.setLiteral((PLiteral)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
