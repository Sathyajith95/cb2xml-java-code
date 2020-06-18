// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml;

import java.io.PushbackReader;
import net.sf.cb2xml.sablecc.lexer.Lexer;

public class DebugLexer extends Lexer
{
    private StringBuffer buffer;
    
    public StringBuffer getBuffer() {
        return this.buffer;
    }
    
    public DebugLexer(final PushbackReader pushbackReader) {
        super(pushbackReader);
        this.buffer = new StringBuffer();
    }
    
    @Override
    protected void filter() {
        this.buffer.append(this.token.getText());
        System.out.println(this.token.getClass() + ", state : " + this.state.id() + ", text : [" + this.token.getText() + "]");
    }
}
