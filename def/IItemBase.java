// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.def;

import java.util.List;

public interface IItemBase
{
    IItemBase getParent();
    
    List<? extends IItem> getChildItems();
}
