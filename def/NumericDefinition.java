// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.def;

public interface NumericDefinition
{
    String getName();
    
    int getBinarySize(final String p0, final int p1, final boolean p2, final boolean p3);
    
    int chkStorageLength(final int p0, final String p1);
    
    int getSyncAt(final String p0, final int p1);
}
