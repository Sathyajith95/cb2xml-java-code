// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.def;

import java.util.List;

public interface IItemJrUpd extends IItemJr
{
    void updatePosition(final int p0);
    
    void setType(final int p0);
    
    List<? extends IItemJrUpd> getChildItems();
}
