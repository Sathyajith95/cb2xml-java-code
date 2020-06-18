// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml;

import net.sf.cb2xml.sablecc.node.Switch;
import net.sf.cb2xml.analysis.CopyBookAnalyzer;
import net.sf.cb2xml.sablecc.node.Start;
import net.sf.cb2xml.sablecc.parser.Parser;
import net.sf.cb2xml.def.ICopybook;
import javax.xml.transform.Result;
import net.sf.cb2xml.util.WriteXml;
import java.io.OutputStreamWriter;
import java.io.OutputStream;
import java.io.FileOutputStream;
import net.sf.cb2xml.sablecc.parser.ParserException;
import java.io.IOException;
import net.sf.cb2xml.sablecc.lexer.LexerException;
import javax.xml.stream.XMLStreamException;
import java.io.Writer;
import java.io.StringWriter;
import net.sf.cb2xml.def.IBasicDialect;
import net.sf.cb2xml.def.Cb2xmlConstants;
import net.sf.cb2xml.def.DialectManager;
import net.sf.cb2xml.analysis.Copybook;
import net.sf.cb2xml.def.NumericDefinition;
import java.io.Reader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.File;

public class Cb2Xml3
{
    public static final int USE_DEFAULT_THREADSIZE = 0;
    public static final int CALCULATE_THREAD_SIZE = -1;
    static final int ONE_MEG = 1048576;
    static final int DEFAULT_THREAD_SIZE = 4194304;
    private static final int FIRST_COBOL_COLUMN = 6;
    private static final int LAST_COBOL_COLUMN = 72;
    
    public static ICb2XmlBuilder newBuilder(final String pathname) throws FileNotFoundException {
        return newBuilder(new File(pathname));
    }
    
    public static ICb2XmlBuilder newBuilder(final File file) throws FileNotFoundException {
        return newBuilder(new FileReader(file), file.getName());
    }
    
    public static ICb2XmlBuilder newBuilder(final Reader reader, final String s) {
        return new BldrImp(reader, s);
    }
    
    public static BldrImp newBuilderJRec(final Reader reader, final String s) {
        return new BldrImp(reader, s);
    }
    
    public static class BldrImp implements ICb2XmlBuilder
    {
        private final Reader reader;
        private final String copybookName;
        private String encoding;
        private boolean debug;
        private boolean indent;
        private boolean newXmlFormat;
        private boolean loadComments;
        private int cblLineFormat;
        private int startingColumn;
        private int lastColumn;
        private long stackSize;
        private NumericDefinition dialect;
        private Copybook copybook;
        
        public BldrImp(final Reader reader, final String copybookName) {
            this.encoding = "UTF-8";
            this.debug = false;
            this.indent = false;
            this.newXmlFormat = true;
            this.loadComments = true;
            this.cblLineFormat = 1;
            this.startingColumn = 6;
            this.lastColumn = 72;
            this.stackSize = -1L;
            this.dialect = DialectManager.MAINFRAME_COBOL.getNumericDefinition();
            this.reader = reader;
            this.copybookName = copybookName;
        }
        
        @Override
        public BldrImp setDebug(final boolean debug) {
            this.debug = debug;
            return this;
        }
        
        @Override
        public BldrImp setCobolLineFormat(final int cblLineFormat) {
            this.cblLineFormat = cblLineFormat;
            this.clear();
            return this;
        }
        
        @Override
        public BldrImp setCobolColumns(final int startingColumn, final int lastColumn) {
            this.cblLineFormat = 2;
            this.startingColumn = startingColumn;
            this.lastColumn = lastColumn;
            this.clear();
            return this;
        }
        
        @Override
        public final BldrImp setStackSize(final long stackSize) {
            this.stackSize = stackSize;
            return this;
        }
        
        @Override
        public BldrImp setIndent(final boolean indent) {
            this.indent = indent;
            return this;
        }
        
        @Override
        public final BldrImp setXmlFormat(final Cb2xmlConstants.Cb2xmlXmlFormat cb2xmlXmlFormat) {
            this.newXmlFormat = (cb2xmlXmlFormat == Cb2xmlConstants.Cb2xmlXmlFormat.FORMAT_2017);
            this.clear();
            return this;
        }
        
        @Override
        public final BldrImp setDialect(final IBasicDialect basicDialect) {
            this.dialect = basicDialect.getNumericDefinition();
            return this;
        }
        
        @Override
        public final BldrImp setXmlEncoding(final String encoding) {
            this.encoding = encoding;
            return this;
        }
        
        @Override
        public final BldrImp setLoadComments(final boolean loadComments) {
            this.loadComments = loadComments;
            return this;
        }
        
        private void clear() {
            this.copybook = null;
        }
        
        @Override
        public String asXmlString() throws XMLStreamException, LexerException, IOException, ParserException {
            final StringWriter stringWriter = new StringWriter();
            this.writeXml(stringWriter);
            return stringWriter.toString();
        }
        
        @Override
        public Copybook asCobolItemTree() {
            try {
                return this.getCopybook();
            }
            catch (LexerException cause) {
                throw new RuntimeException(cause);
            }
            catch (IOException cause2) {
                throw new RuntimeException(cause2);
            }
            catch (ParserException cause3) {
                throw new RuntimeException(cause3);
            }
        }
        
        private Copybook getCopybook() throws LexerException, IOException, ParserException {
            if (this.copybook == null) {
                final DoCblAnalyse doCblAnalyse = new DoCblAnalyse(this.copybookName, this.dialect, this.loadComments);
                doCblAnalyse.doAnalysis(this.debug, this.cblLineFormat, this.startingColumn, this.lastColumn, this.reader, this.stackSize);
                this.copybook = doCblAnalyse.copybook;
            }
            return this.copybook;
        }
        
        @Override
        public void writeXml(final String name) throws XMLStreamException, LexerException, IOException, ParserException {
            this.writeXml(new FileOutputStream(name));
        }
        
        @Override
        public void writeXml(final OutputStream out) throws XMLStreamException, LexerException, IOException, ParserException {
            final String charsetName = (this.encoding == null || this.encoding.length() == 0) ? "UTF-8" : this.encoding;
            final OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out, charsetName);
            new WriteXml(this.newXmlFormat, true, charsetName).writeCopybook(outputStreamWriter, this.getCopybook(), this.indent);
            outputStreamWriter.close();
        }
        
        @Override
        public void writeXml(final Writer writer) throws XMLStreamException, LexerException, IOException, ParserException {
            new WriteXml(this.newXmlFormat, true, this.encoding).writeCopybook(writer, this.getCopybook(), this.indent);
        }
        
        @Override
        public void writeXml(final Result result) throws XMLStreamException, LexerException, IOException, ParserException {
            new WriteXml(this.newXmlFormat, false, this.encoding).writeCopybook(result, this.getCopybook());
        }
        
        private static final class DoCblAnalyse extends DoCobolAnalyse
        {
            private final String name;
            private final NumericDefinition dialect;
            private final boolean loadComments;
            Copybook copybook;
            
            public DoCblAnalyse(final String name, final NumericDefinition dialect, final boolean loadComments) {
                super(name);
                this.name = name;
                this.dialect = dialect;
                this.loadComments = loadComments;
            }
            
            @Override
            protected void analyseCobolCopybook(final Parser parser, final Start start) {
                final CopyBookAnalyzer copyBookAnalyzer = new CopyBookAnalyzer(this.name, parser, this.dialect, this.loadComments);
                start.apply(copyBookAnalyzer);
                this.copybook = copyBookAnalyzer.getCopybook();
            }
        }
    }
}
