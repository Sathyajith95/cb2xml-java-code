// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.parser;

import net.sf.cb2xml.sablecc.node.Token;

public class ParserException extends Exception
{
    private Token token;
    
    public ParserException(final Token token, final String message) {
        super(message);
        this.token = token;
    }
    
    public Token getToken() {
        return this.token;
    }
}
