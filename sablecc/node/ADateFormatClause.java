// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ADateFormatClause extends PDateFormatClause
{
    private TDate _date_;
    private TFormat _format_;
    private TIs _is_;
    private TDataName _dataName_;
    
    public ADateFormatClause() {
    }
    
    public ADateFormatClause(final TDate date, final TFormat format, final TIs is, final TDataName dataName) {
        this.setDate(date);
        this.setFormat(format);
        this.setIs(is);
        this.setDataName(dataName);
    }
    
    @Override
    public Object clone() {
        return new ADateFormatClause(this.cloneNode(this._date_), this.cloneNode(this._format_), this.cloneNode(this._is_), this.cloneNode(this._dataName_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseADateFormatClause(this);
    }
    
    public TDate getDate() {
        return this._date_;
    }
    
    public void setDate(final TDate date_) {
        if (this._date_ != null) {
            this._date_.parent(null);
        }
        if (date_ != null) {
            if (date_.parent() != null) {
                date_.parent().removeChild(date_);
            }
            date_.parent(this);
        }
        this._date_ = date_;
    }
    
    public TFormat getFormat() {
        return this._format_;
    }
    
    public void setFormat(final TFormat format_) {
        if (this._format_ != null) {
            this._format_.parent(null);
        }
        if (format_ != null) {
            if (format_.parent() != null) {
                format_.parent().removeChild(format_);
            }
            format_.parent(this);
        }
        this._format_ = format_;
    }
    
    public TIs getIs() {
        return this._is_;
    }
    
    public void setIs(final TIs is_) {
        if (this._is_ != null) {
            this._is_.parent(null);
        }
        if (is_ != null) {
            if (is_.parent() != null) {
                is_.parent().removeChild(is_);
            }
            is_.parent(this);
        }
        this._is_ = is_;
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
        return "" + this.toString(this._date_) + this.toString(this._format_) + this.toString(this._is_) + this.toString(this._dataName_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._date_ == node) {
            this._date_ = null;
            return;
        }
        if (this._format_ == node) {
            this._format_ = null;
            return;
        }
        if (this._is_ == node) {
            this._is_ = null;
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
        if (this._date_ == node) {
            this.setDate((TDate)node2);
            return;
        }
        if (this._format_ == node) {
            this.setFormat((TFormat)node2);
            return;
        }
        if (this._is_ == node) {
            this.setIs((TIs)node2);
            return;
        }
        if (this._dataName_ == node) {
            this.setDataName((TDataName)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
