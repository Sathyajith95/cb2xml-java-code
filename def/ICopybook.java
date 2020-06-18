// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.def;

import java.util.List;

public interface ICopybook extends IItemBase
{
    List<? extends IItem> getChildItems();
    
    String getFilename();
    
    String getDialect();
}
