// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml;

import net.sf.cb2xml.sablecc.node.Start;
import net.sf.cb2xml.sablecc.lexer.Lexer;
import net.sf.cb2xml.sablecc.parser.Parser;
import java.io.StringReader;
import java.io.Reader;
import net.sf.cb2xml.sablecc.parser.ParserException;
import java.io.IOException;
import net.sf.cb2xml.sablecc.lexer.LexerException;
import java.io.PushbackReader;

public abstract class DoCobolAnalyse implements Runnable
{
    static final int ONE_MEG = 1048576;
    static final int DEFAULT_THREAD_SIZE = 4194304;
    private static final Object SYNC_PARSE_COBOL;
    private static final int FIRST_COBOL_COLUMN = 6;
    private static final int LAST_COBOL_COLUMN = 72;
    private static int[] END_COLS;
    private final String name;
    private boolean debug;
    private int initialColumn;
    private PushbackReader pbr;
    private DebugParserException debugException;
    private LexerException lexerException;
    private IOException ioException;
    private ParserException parseException;
    
    public DoCobolAnalyse(final String name) {
        this.name = name;
    }
    
    public void doAnalysis(final boolean debug, final int n, int initialColumn, final int n2, final Reader reader, long b) throws LexerException, IOException, ParserException {
        this.debug = debug;
        long n3 = b;
        String s = null;
        initialColumn = 6;
        Reader in = null;
        switch (n) {
            case 9: {
                in = reader;
                this.initialColumn = 0;
                if (b < 0L) {
                    n3 = 4194304L;
                    b = 4194304L;
                    break;
                }
                break;
            }
            case 1:
            case 3:
            case 4: {
                s = CobolPreprocessor.preProcess(reader, 6, DoCobolAnalyse.END_COLS[n]);
                in = new StringReader(s);
                break;
            }
            case 2: {
                this.initialColumn = initialColumn;
                s = CobolPreprocessor.preProcess(reader, initialColumn, n2);
                in = new StringReader(s);
                break;
            }
            default: {
                s = CobolPreprocessor.preProcess(reader);
                in = new StringReader(s);
                break;
            }
        }
        if (s != null && n3 < 0L) {
            n3 = s.length() * 7;
            b = n3 + 1048576L;
        }
        else if (n3 > 0L) {
            b = n3;
        }
        this.pbr = new PushbackReader(in, 4000);
        if (n3 < 1048576L) {
            this.run();
        }
        else {
            final Thread thread = new Thread(null, this, this.name, Math.max(4194304L, b));
            thread.start();
            try {
                thread.join();
            }
            catch (InterruptedException cause) {
                throw new RuntimeException(cause);
            }
        }
        this.checkExceptions();
    }
    
    @Override
    public final void run() {
        try {
            synchronized (DoCobolAnalyse.SYNC_PARSE_COBOL) {
                Parser parser;
                Start start;
                if (this.debug) {
                    System.err.println("*** debug mode ***");
                    final DebugLexer debugLexer = new DebugLexer(this.pbr);
                    parser = new Parser(debugLexer);
                    try {
                        start = parser.parse(this.initialColumn);
                    }
                    catch (ParserException ex) {
                        final StringBuffer buffer = debugLexer.getBuffer();
                        String string = "";
                        if (buffer != null) {
                            string = buffer.toString();
                        }
                        throw new DebugParserException(ex, string);
                    }
                }
                else {
                    parser = new Parser(new Lexer(this.pbr));
                    start = parser.parse(this.initialColumn);
                }
                this.analyseCobolCopybook(parser, start);
            }
        }
        catch (DebugParserException debugException) {
            this.debugException = debugException;
        }
        catch (LexerException lexerException) {
            this.lexerException = lexerException;
        }
        catch (IOException ioException) {
            this.ioException = ioException;
        }
        catch (ParserException parseException) {
            this.parseException = parseException;
        }
    }
    
    public final void checkExceptions() throws LexerException, IOException, ParserException {
        if (this.debugException != null) {
            throw this.debugException;
        }
        if (this.lexerException != null) {
            throw this.lexerException;
        }
        if (this.ioException != null) {
            throw this.ioException;
        }
        if (this.parseException != null) {
            throw this.parseException;
        }
    }
    
    protected abstract void analyseCobolCopybook(final Parser p0, final Start p1);
    
    static {
        SYNC_PARSE_COBOL = new Object();
        (DoCobolAnalyse.END_COLS = new int[9])[1] = 72;
        DoCobolAnalyse.END_COLS[3] = 80;
        DoCobolAnalyse.END_COLS[4] = 16000;
    }
}
