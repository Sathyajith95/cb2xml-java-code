// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ANumber88Number extends PNumber
{
    private TNumber88 _number88_;
    
    public ANumber88Number() {
    }
    
    public ANumber88Number(final TNumber88 number88) {
        this.setNumber88(number88);
    }
    
    @Override
    public Object clone() {
        return new ANumber88Number(this.cloneNode(this._number88_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseANumber88Number(this);
    }
    
    public TNumber88 getNumber88() {
        return this._number88_;
    }
    
    public void setNumber88(final TNumber88 number88_) {
        if (this._number88_ != null) {
            this._number88_.parent(null);
        }
        if (number88_ != null) {
            if (number88_.parent() != null) {
                number88_.parent().removeChild(number88_);
            }
            number88_.parent(this);
        }
        this._number88_ = number88_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._number88_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._number88_ == node) {
            this._number88_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._number88_ == node) {
            this.setNumber88((TNumber88)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
