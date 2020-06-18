// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AObjectReferencePhraseUsagePhrase extends PUsagePhrase
{
    private PObjectReferencePhrase _objectReferencePhrase_;
    
    public AObjectReferencePhraseUsagePhrase() {
    }
    
    public AObjectReferencePhraseUsagePhrase(final PObjectReferencePhrase objectReferencePhrase) {
        this.setObjectReferencePhrase(objectReferencePhrase);
    }
    
    @Override
    public Object clone() {
        return new AObjectReferencePhraseUsagePhrase(this.cloneNode(this._objectReferencePhrase_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAObjectReferencePhraseUsagePhrase(this);
    }
    
    public PObjectReferencePhrase getObjectReferencePhrase() {
        return this._objectReferencePhrase_;
    }
    
    public void setObjectReferencePhrase(final PObjectReferencePhrase objectReferencePhrase_) {
        if (this._objectReferencePhrase_ != null) {
            this._objectReferencePhrase_.parent(null);
        }
        if (objectReferencePhrase_ != null) {
            if (objectReferencePhrase_.parent() != null) {
                objectReferencePhrase_.parent().removeChild(objectReferencePhrase_);
            }
            objectReferencePhrase_.parent(this);
        }
        this._objectReferencePhrase_ = objectReferencePhrase_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._objectReferencePhrase_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._objectReferencePhrase_ == node) {
            this._objectReferencePhrase_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._objectReferencePhrase_ == node) {
            this.setObjectReferencePhrase((PObjectReferencePhrase)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
