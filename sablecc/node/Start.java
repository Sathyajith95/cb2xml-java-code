// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class Start extends Node
{
    private PRecordDescription _pRecordDescription_;
    private EOF _eof_;
    
    public Start() {
    }
    
    public Start(final PRecordDescription pRecordDescription, final EOF eof) {
        this.setPRecordDescription(pRecordDescription);
        this.setEOF(eof);
    }
    
    @Override
    public Object clone() {
        return new Start(this.cloneNode(this._pRecordDescription_), this.cloneNode(this._eof_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseStart(this);
    }
    
    public PRecordDescription getPRecordDescription() {
        return this._pRecordDescription_;
    }
    
    public void setPRecordDescription(final PRecordDescription pRecordDescription_) {
        if (this._pRecordDescription_ != null) {
            this._pRecordDescription_.parent(null);
        }
        if (pRecordDescription_ != null) {
            if (pRecordDescription_.parent() != null) {
                pRecordDescription_.parent().removeChild(pRecordDescription_);
            }
            pRecordDescription_.parent(this);
        }
        this._pRecordDescription_ = pRecordDescription_;
    }
    
    public EOF getEOF() {
        return this._eof_;
    }
    
    public void setEOF(final EOF eof_) {
        if (this._eof_ != null) {
            this._eof_.parent(null);
        }
        if (eof_ != null) {
            if (eof_.parent() != null) {
                eof_.parent().removeChild(eof_);
            }
            eof_.parent(this);
        }
        this._eof_ = eof_;
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._pRecordDescription_ == node) {
            this._pRecordDescription_ = null;
            return;
        }
        if (this._eof_ == node) {
            this._eof_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._pRecordDescription_ == node) {
            this.setPRecordDescription((PRecordDescription)node2);
            return;
        }
        if (this._eof_ == node) {
            this.setEOF((EOF)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._pRecordDescription_) + this.toString(this._eof_);
    }
}
