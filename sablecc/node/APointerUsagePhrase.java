// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class APointerUsagePhrase extends PUsagePhrase
{
    private TPointer _pointer_;
    
    public APointerUsagePhrase() {
    }
    
    public APointerUsagePhrase(final TPointer pointer) {
        this.setPointer(pointer);
    }
    
    @Override
    public Object clone() {
        return new APointerUsagePhrase(this.cloneNode(this._pointer_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAPointerUsagePhrase(this);
    }
    
    public TPointer getPointer() {
        return this._pointer_;
    }
    
    public void setPointer(final TPointer pointer_) {
        if (this._pointer_ != null) {
            this._pointer_.parent(null);
        }
        if (pointer_ != null) {
            if (pointer_.parent() != null) {
                pointer_.parent().removeChild(pointer_);
            }
            pointer_.parent(this);
        }
        this._pointer_ = pointer_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._pointer_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._pointer_ == node) {
            this._pointer_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._pointer_ == node) {
            this.setPointer((TPointer)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
