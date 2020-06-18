// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.lexer;

import java.io.IOException;

public interface IPushbackReader
{
    int read() throws IOException;
    
    void unread(final int p0) throws IOException;
}
