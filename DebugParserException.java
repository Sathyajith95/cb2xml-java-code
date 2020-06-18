// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml;

import net.sf.cb2xml.sablecc.parser.ParserException;

public class DebugParserException extends ParserException
{
    public final String buffer;
    
    DebugParserException(final ParserException ex, final String buffer) {
        super(ex.getToken(), ex.getMessage());
        this.buffer = buffer;
        super.setStackTrace(ex.getStackTrace());
    }
}
