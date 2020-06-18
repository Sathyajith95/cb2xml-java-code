// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.lexer;

import net.sf.cb2xml.sablecc.node.InvalidToken;

public class LexerException extends Exception
{
    private InvalidToken invalidToken;
    
    public LexerException(final InvalidToken invalidToken, final String message) {
        super(message);
        this.invalidToken = invalidToken;
    }
    
    public InvalidToken getToken() {
        return this.invalidToken;
    }
}
