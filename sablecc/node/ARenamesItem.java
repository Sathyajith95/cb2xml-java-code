// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ARenamesItem extends PRenamesItem
{
    private TNumberNot88 _numberNot88_;
    private TDataName _renameTo_;
    private TRenames _renames_;
    private TDataName _renameFrom_;
    private PThroughPhrase _throughPhrase_;
    
    public ARenamesItem() {
    }
    
    public ARenamesItem(final TNumberNot88 numberNot88, final TDataName renameTo, final TRenames renames, final TDataName renameFrom, final PThroughPhrase throughPhrase) {
        this.setNumberNot88(numberNot88);
        this.setRenameTo(renameTo);
        this.setRenames(renames);
        this.setRenameFrom(renameFrom);
        this.setThroughPhrase(throughPhrase);
    }
    
    @Override
    public Object clone() {
        return new ARenamesItem(this.cloneNode(this._numberNot88_), this.cloneNode(this._renameTo_), this.cloneNode(this._renames_), this.cloneNode(this._renameFrom_), this.cloneNode(this._throughPhrase_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseARenamesItem(this);
    }
    
    public TNumberNot88 getNumberNot88() {
        return this._numberNot88_;
    }
    
    public void setNumberNot88(final TNumberNot88 numberNot88_) {
        if (this._numberNot88_ != null) {
            this._numberNot88_.parent(null);
        }
        if (numberNot88_ != null) {
            if (numberNot88_.parent() != null) {
                numberNot88_.parent().removeChild(numberNot88_);
            }
            numberNot88_.parent(this);
        }
        this._numberNot88_ = numberNot88_;
    }
    
    public TDataName getRenameTo() {
        return this._renameTo_;
    }
    
    public void setRenameTo(final TDataName renameTo_) {
        if (this._renameTo_ != null) {
            this._renameTo_.parent(null);
        }
        if (renameTo_ != null) {
            if (renameTo_.parent() != null) {
                renameTo_.parent().removeChild(renameTo_);
            }
            renameTo_.parent(this);
        }
        this._renameTo_ = renameTo_;
    }
    
    public TRenames getRenames() {
        return this._renames_;
    }
    
    public void setRenames(final TRenames renames_) {
        if (this._renames_ != null) {
            this._renames_.parent(null);
        }
        if (renames_ != null) {
            if (renames_.parent() != null) {
                renames_.parent().removeChild(renames_);
            }
            renames_.parent(this);
        }
        this._renames_ = renames_;
    }
    
    public TDataName getRenameFrom() {
        return this._renameFrom_;
    }
    
    public void setRenameFrom(final TDataName renameFrom_) {
        if (this._renameFrom_ != null) {
            this._renameFrom_.parent(null);
        }
        if (renameFrom_ != null) {
            if (renameFrom_.parent() != null) {
                renameFrom_.parent().removeChild(renameFrom_);
            }
            renameFrom_.parent(this);
        }
        this._renameFrom_ = renameFrom_;
    }
    
    public PThroughPhrase getThroughPhrase() {
        return this._throughPhrase_;
    }
    
    public void setThroughPhrase(final PThroughPhrase throughPhrase_) {
        if (this._throughPhrase_ != null) {
            this._throughPhrase_.parent(null);
        }
        if (throughPhrase_ != null) {
            if (throughPhrase_.parent() != null) {
                throughPhrase_.parent().removeChild(throughPhrase_);
            }
            throughPhrase_.parent(this);
        }
        this._throughPhrase_ = throughPhrase_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._numberNot88_) + this.toString(this._renameTo_) + this.toString(this._renames_) + this.toString(this._renameFrom_) + this.toString(this._throughPhrase_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._numberNot88_ == node) {
            this._numberNot88_ = null;
            return;
        }
        if (this._renameTo_ == node) {
            this._renameTo_ = null;
            return;
        }
        if (this._renames_ == node) {
            this._renames_ = null;
            return;
        }
        if (this._renameFrom_ == node) {
            this._renameFrom_ = null;
            return;
        }
        if (this._throughPhrase_ == node) {
            this._throughPhrase_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._numberNot88_ == node) {
            this.setNumberNot88((TNumberNot88)node2);
            return;
        }
        if (this._renameTo_ == node) {
            this.setRenameTo((TDataName)node2);
            return;
        }
        if (this._renames_ == node) {
            this.setRenames((TRenames)node2);
            return;
        }
        if (this._renameFrom_ == node) {
            this.setRenameFrom((TDataName)node2);
            return;
        }
        if (this._throughPhrase_ == node) {
            this.setThroughPhrase((PThroughPhrase)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
