// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AProcedurePointerUsagePhrase extends PUsagePhrase
{
    private TProcedurePointer _procedurePointer_;
    
    public AProcedurePointerUsagePhrase() {
    }
    
    public AProcedurePointerUsagePhrase(final TProcedurePointer procedurePointer) {
        this.setProcedurePointer(procedurePointer);
    }
    
    @Override
    public Object clone() {
        return new AProcedurePointerUsagePhrase(this.cloneNode(this._procedurePointer_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAProcedurePointerUsagePhrase(this);
    }
    
    public TProcedurePointer getProcedurePointer() {
        return this._procedurePointer_;
    }
    
    public void setProcedurePointer(final TProcedurePointer procedurePointer_) {
        if (this._procedurePointer_ != null) {
            this._procedurePointer_.parent(null);
        }
        if (procedurePointer_ != null) {
            if (procedurePointer_.parent() != null) {
                procedurePointer_.parent().removeChild(procedurePointer_);
            }
            procedurePointer_.parent(this);
        }
        this._procedurePointer_ = procedurePointer_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._procedurePointer_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._procedurePointer_ == node) {
            this._procedurePointer_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._procedurePointer_ == node) {
            this.setProcedurePointer((TProcedurePointer)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
