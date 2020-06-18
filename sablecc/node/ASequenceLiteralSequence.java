// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ASequenceLiteralSequence extends PLiteralSequence
{
    private PLiteralSequence _literalSequence_;
    private TComma _comma_;
    private PLiteral _literal_;
    
    public ASequenceLiteralSequence() {
    }
    
    public ASequenceLiteralSequence(final PLiteralSequence literalSequence, final TComma comma, final PLiteral literal) {
        this.setLiteralSequence(literalSequence);
        this.setComma(comma);
        this.setLiteral(literal);
    }
    
    @Override
    public Object clone() {
        return new ASequenceLiteralSequence(this.cloneNode(this._literalSequence_), this.cloneNode(this._comma_), this.cloneNode(this._literal_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseASequenceLiteralSequence(this);
    }
    
    public PLiteralSequence getLiteralSequence() {
        return this._literalSequence_;
    }
    
    public void setLiteralSequence(final PLiteralSequence literalSequence_) {
        if (this._literalSequence_ != null) {
            this._literalSequence_.parent(null);
        }
        if (literalSequence_ != null) {
            if (literalSequence_.parent() != null) {
                literalSequence_.parent().removeChild(literalSequence_);
            }
            literalSequence_.parent(this);
        }
        this._literalSequence_ = literalSequence_;
    }
    
    public TComma getComma() {
        return this._comma_;
    }
    
    public void setComma(final TComma comma_) {
        if (this._comma_ != null) {
            this._comma_.parent(null);
        }
        if (comma_ != null) {
            if (comma_.parent() != null) {
                comma_.parent().removeChild(comma_);
            }
            comma_.parent(this);
        }
        this._comma_ = comma_;
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
        return "" + this.toString(this._literalSequence_) + this.toString(this._comma_) + this.toString(this._literal_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._literalSequence_ == node) {
            this._literalSequence_ = null;
            return;
        }
        if (this._comma_ == node) {
            this._comma_ = null;
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
        if (this._literalSequence_ == node) {
            this.setLiteralSequence((PLiteralSequence)node2);
            return;
        }
        if (this._comma_ == node) {
            this.setComma((TComma)node2);
            return;
        }
        if (this._literal_ == node) {
            this.setLiteral((PLiteral)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
