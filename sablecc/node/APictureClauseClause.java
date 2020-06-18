// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class APictureClauseClause extends PClause
{
    private PPictureClause _pictureClause_;
    
    public APictureClauseClause() {
    }
    
    public APictureClauseClause(final PPictureClause pictureClause) {
        this.setPictureClause(pictureClause);
    }
    
    @Override
    public Object clone() {
        return new APictureClauseClause(this.cloneNode(this._pictureClause_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAPictureClauseClause(this);
    }
    
    public PPictureClause getPictureClause() {
        return this._pictureClause_;
    }
    
    public void setPictureClause(final PPictureClause pictureClause_) {
        if (this._pictureClause_ != null) {
            this._pictureClause_.parent(null);
        }
        if (pictureClause_ != null) {
            if (pictureClause_.parent() != null) {
                pictureClause_.parent().removeChild(pictureClause_);
            }
            pictureClause_.parent(this);
        }
        this._pictureClause_ = pictureClause_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._pictureClause_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._pictureClause_ == node) {
            this._pictureClause_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._pictureClause_ == node) {
            this.setPictureClause((PPictureClause)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
