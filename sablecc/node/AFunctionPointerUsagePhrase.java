// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AFunctionPointerUsagePhrase extends PUsagePhrase
{
    private TFunctionPointer _functionPointer_;
    
    public AFunctionPointerUsagePhrase() {
    }
    
    public AFunctionPointerUsagePhrase(final TFunctionPointer functionPointer) {
        this.setFunctionPointer(functionPointer);
    }
    
    @Override
    public Object clone() {
        return new AFunctionPointerUsagePhrase(this.cloneNode(this._functionPointer_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAFunctionPointerUsagePhrase(this);
    }
    
    public TFunctionPointer getFunctionPointer() {
        return this._functionPointer_;
    }
    
    public void setFunctionPointer(final TFunctionPointer functionPointer_) {
        if (this._functionPointer_ != null) {
            this._functionPointer_.parent(null);
        }
        if (functionPointer_ != null) {
            if (functionPointer_.parent() != null) {
                functionPointer_.parent().removeChild(functionPointer_);
            }
            functionPointer_.parent(this);
        }
        this._functionPointer_ = functionPointer_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._functionPointer_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._functionPointer_ == node) {
            this._functionPointer_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._functionPointer_ == node) {
            this.setFunctionPointer((TFunctionPointer)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
