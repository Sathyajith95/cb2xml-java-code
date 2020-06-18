// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.analysis;

import net.sf.cb2xml.def.IItemBase;
import net.sf.cb2xml.def.ICopybook;

public class Copybook extends BaseItem implements ICopybook
{
    final String filename;
    final String dialect;
    
    public Copybook(final String filename, final String dialect) {
        super(200);
        this.filename = filename;
        this.dialect = dialect;
    }
    
    @Override
    public String getFilename() {
        return this.filename;
    }
    
    @Override
    public String getDialect() {
        return this.dialect;
    }
    
    @Override
    public IItemBase getParent() {
        return null;
    }
}
