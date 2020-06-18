// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ABracketedNumber extends PBracketedNumber
{
    private TLparen _lparen_;
    private PNumber _number_;
    private TRparen _rparen_;
    
    public ABracketedNumber() {
    }
    
    public ABracketedNumber(final TLparen lparen, final PNumber number, final TRparen rparen) {
        this.setLparen(lparen);
        this.setNumber(number);
        this.setRparen(rparen);
    }
    
    @Override
    public Object clone() {
        return new ABracketedNumber(this.cloneNode(this._lparen_), this.cloneNode(this._number_), this.cloneNode(this._rparen_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseABracketedNumber(this);
    }
    
    public TLparen getLparen() {
        return this._lparen_;
    }
    
    public void setLparen(final TLparen lparen_) {
        if (this._lparen_ != null) {
            this._lparen_.parent(null);
        }
        if (lparen_ != null) {
            if (lparen_.parent() != null) {
                lparen_.parent().removeChild(lparen_);
            }
            lparen_.parent(this);
        }
        this._lparen_ = lparen_;
    }
    
    public PNumber getNumber() {
        return this._number_;
    }
    
    public void setNumber(final PNumber number_) {
        if (this._number_ != null) {
            this._number_.parent(null);
        }
        if (number_ != null) {
            if (number_.parent() != null) {
                number_.parent().removeChild(number_);
            }
            number_.parent(this);
        }
        this._number_ = number_;
    }
    
    public TRparen getRparen() {
        return this._rparen_;
    }
    
    public void setRparen(final TRparen rparen_) {
        if (this._rparen_ != null) {
            this._rparen_.parent(null);
        }
        if (rparen_ != null) {
            if (rparen_.parent() != null) {
                rparen_.parent().removeChild(rparen_);
            }
            rparen_.parent(this);
        }
        this._rparen_ = rparen_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._lparen_) + this.toString(this._number_) + this.toString(this._rparen_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._lparen_ == node) {
            this._lparen_ = null;
            return;
        }
        if (this._number_ == node) {
            this._number_ = null;
            return;
        }
        if (this._rparen_ == node) {
            this._rparen_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._lparen_ == node) {
            this.setLparen((TLparen)node2);
            return;
        }
        if (this._number_ == node) {
            this.setNumber((PNumber)node2);
            return;
        }
        if (this._rparen_ == node) {
            this.setRparen((TRparen)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
