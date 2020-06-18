// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AObjectReferencePhrase extends PObjectReferencePhrase
{
    private TObject _object_;
    private TReference _reference_;
    private TDataName _dataName_;
    
    public AObjectReferencePhrase() {
    }
    
    public AObjectReferencePhrase(final TObject object, final TReference reference, final TDataName dataName) {
        this.setObject(object);
        this.setReference(reference);
        this.setDataName(dataName);
    }
    
    @Override
    public Object clone() {
        return new AObjectReferencePhrase(this.cloneNode(this._object_), this.cloneNode(this._reference_), this.cloneNode(this._dataName_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAObjectReferencePhrase(this);
    }
    
    public TObject getObject() {
        return this._object_;
    }
    
    public void setObject(final TObject object_) {
        if (this._object_ != null) {
            this._object_.parent(null);
        }
        if (object_ != null) {
            if (object_.parent() != null) {
                object_.parent().removeChild(object_);
            }
            object_.parent(this);
        }
        this._object_ = object_;
    }
    
    public TReference getReference() {
        return this._reference_;
    }
    
    public void setReference(final TReference reference_) {
        if (this._reference_ != null) {
            this._reference_.parent(null);
        }
        if (reference_ != null) {
            if (reference_.parent() != null) {
                reference_.parent().removeChild(reference_);
            }
            reference_.parent(this);
        }
        this._reference_ = reference_;
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
        return "" + this.toString(this._object_) + this.toString(this._reference_) + this.toString(this._dataName_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._object_ == node) {
            this._object_ = null;
            return;
        }
        if (this._reference_ == node) {
            this._reference_ = null;
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
        if (this._object_ == node) {
            this.setObject((TObject)node2);
            return;
        }
        if (this._reference_ == node) {
            this.setReference((TReference)node2);
            return;
        }
        if (this._dataName_ == node) {
            this.setDataName((TDataName)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
