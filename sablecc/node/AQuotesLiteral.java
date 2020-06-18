// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AQuotesLiteral extends PLiteral
{
    private TQuotes _quotes_;
    
    public AQuotesLiteral() {
    }
    
    public AQuotesLiteral(final TQuotes quotes) {
        this.setQuotes(quotes);
    }
    
    @Override
    public Object clone() {
        return new AQuotesLiteral(this.cloneNode(this._quotes_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAQuotesLiteral(this);
    }
    
    public TQuotes getQuotes() {
        return this._quotes_;
    }
    
    public void setQuotes(final TQuotes quotes_) {
        if (this._quotes_ != null) {
            this._quotes_.parent(null);
        }
        if (quotes_ != null) {
            if (quotes_.parent() != null) {
                quotes_.parent().removeChild(quotes_);
            }
            quotes_.parent(this);
        }
        this._quotes_ = quotes_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._quotes_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._quotes_ == node) {
            this._quotes_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._quotes_ == node) {
            this.setQuotes((TQuotes)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
