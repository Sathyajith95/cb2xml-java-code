// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.def;

import java.util.HashMap;

public class Cb2xmlConstants
{
    public static final int USE_DEFAULT_THREADSIZE = 0;
    public static final int CALCULATE_THREAD_SIZE = -1;
    public static final String STANDARD_FONT = "UTF-8";
    public static final int USE_STANDARD_COLUMNS = 1;
    public static final int USE_SUPPLIED_COLUMNS = 2;
    public static final int USE_COLS_6_TO_80 = 3;
    public static final int USE_LONG_LINE = 4;
    public static final int USE_PROPERTIES_FILE = 8;
    public static final int FREE_FORMAT = 9;
    public static final String ITEM = "item";
    public static final String COPYBOOK = "copybook";
    public static final String NAME = "name";
    public static final String PICTURE = "picture";
    public static final String NUMERIC = "numeric";
    public static final String EDITTED_NUMERIC = "editted-numeric";
    public static final String REDEFINED = "redefined";
    public static final String REDEFINES = "redefines";
    public static final String POSITION = "position";
    public static final String LEVEL = "level";
    public static final String OCCURS = "occurs";
    public static final String USAGE = "usage";
    public static final String JUSTIFIED = "justified";
    public static final String INHERITED_USAGE = "inherited-usage";
    public static final String DISPLAY_LENGTH = "display-length";
    public static final String DISPLAY_POSITION = "display-position";
    public static final String STORAGE_LENGTH = "storage-length";
    public static final String DOUBLE_BYTE_CHARS = "double-byte-chars";
    public static final String ASSUMED_DIGITS = "assumed-digits";
    public static final String SIGN_SEPARATE = "sign-separate";
    public static final String SIGN_POSITION = "sign-position";
    public static final String SIGN_CLAUSE = "sign-clause";
    public static final String SIGNED = "signed";
    public static final String SCALE = "scale";
    public static final String BLANK_WHEN_ZERO = "blank-when-zero";
    public static final String VALUE = "value";
    public static final String ALL = "all";
    public static final String THROUGH = "through";
    public static final String FILENAME = "filename";
    public static final String DIALECT = "dialect";
    public static final String CB2XML_FORMAT = "cb2xml-format";
    public static final String DEPENDING_ON = "depending-on";
    public static final String OCCURS_MIN = "occurs-min";
    public static final String SYNC = "sync";
    public static final String INSERT_DECIMAL_POINT = "insert-decimal-point";
    public static final String CONDITION = "condition";
    public static final String TRUE = "true";
    public static final String LEADING = "leading";
    public static final String TRAILING = "trailing";
    public static final String RIGHT = "right";
    public static final String PACKED_DECIMAL = "packed-decimal";
    public static final String BINARY = "binary";
    public static final String COMP = "computational";
    public static final String COMP_1 = "computational-1";
    public static final String COMP_2 = "computational-2";
    public static final String COMP_3 = "computational-3";
    public static final String COMP_4 = "computational-4";
    public static final String COMP_5 = "computational-5";
    public static final String COMP_6 = "computational-6";
    public static final String DISPLAY = "display";
    public static final String DISPLAY_1 = "display-1";
    public static final String INDEX = "index";
    public static final String NATIONAL = "national";
    public static final String POINTER = "pointer";
    public static final String PROCEDURAL_POINTER = "procedure-pointer";
    public static final String FUNCTION_POINTER = "function-pointer";
    private static HashMap<String, Usage> usageMap;
    private static HashMap<String, SignClause> signMap;
    
    public static Usage toUsage(final String s) {
        Usage usage = null;
        if (s != null) {
            usage = Cb2xmlConstants.usageMap.get(s.toLowerCase());
        }
        return (usage == null) ? Usage.NONE : usage;
    }
    
    public static SignClause toSignClause(final String s) {
        SignClause signClause = null;
        if (s != null && s.length() > 0) {
            signClause = Cb2xmlConstants.signMap.get(s.toLowerCase());
        }
        return (signClause == null) ? SignClause.NO_SIGN_CLAUSE : signClause;
    }
    
    public static Justified toJustified(final String s) {
        Justified justified = Justified.NOT_JUSTIFIED;
        if (Justified.JUSTIFIED.getName().equals(s)) {
            justified = Justified.JUSTIFIED;
        }
        else if (Justified.RIGHT.getName().equals(s)) {
            justified = Justified.RIGHT;
        }
        return justified;
    }
    
    public static NumericClass toNumeric(final String s) {
        NumericClass numericClass = NumericClass.NON_NUMERIC;
        if (NumericClass.NUMERIC_IN_COBOL.getName().equals(s)) {
            numericClass = NumericClass.NUMERIC_IN_COBOL;
        }
        else if (NumericClass.NUMERIC_EDITED.getName().equals(s)) {
            numericClass = NumericClass.NUMERIC_EDITED;
        }
        return numericClass;
    }
    
    static {
        Cb2xmlConstants.usageMap = new HashMap<String, Usage>(30);
        Cb2xmlConstants.signMap = new HashMap<String, SignClause>(15);
        for (final Usage value : Usage.values()) {
            if (value.name != null) {
                Cb2xmlConstants.usageMap.put(value.name.toLowerCase(), value);
            }
        }
        for (final SignClause value2 : SignClause.values()) {
            if (value2.name != null) {
                Cb2xmlConstants.signMap.put(value2.name.toLowerCase(), value2);
            }
        }
    }
    
    public enum Usage implements IGetName
    {
        NONE((String)null), 
        PACKED_DECIMAL("packed-decimal"), 
        BINARY("binary"), 
        COMP("computational"), 
        COMP_1("computational-1"), 
        COMP_2("computational-2"), 
        COMP_3("computational-3"), 
        COMP_4("computational-4"), 
        COMP_5("computational-5"), 
        COMP_6("computational-6"), 
        DISPLAY("display"), 
        DISPLAY_1("display-1"), 
        INDEX("index"), 
        NATIONAL("national"), 
        POINTER("pointer"), 
        PROCEDURAL_POINTER("procedure-pointer"), 
        FUNCTION_POINTER("function-pointer"), 
        OBJECT_REFERENCE("object-reference");
        
        private final String name;
        
        private Usage(final String name2) {
            this.name = name2;
        }
        
        @Override
        public String getName() {
            return this.name;
        }
    }
    
    public interface IGetName
    {
        String getName();
    }
    
    public enum Justified implements IGetName
    {
        NOT_JUSTIFIED((String)null), 
        JUSTIFIED("true"), 
        RIGHT("right");
        
        private final String name;
        public final boolean isJustified;
        
        private Justified(final String name2) {
            this.name = name2;
            this.isJustified = (this.name != null);
        }
        
        @Override
        public String getName() {
            return this.name;
        }
    }
    
    public enum NumericClass implements IGetName
    {
        NON_NUMERIC((String)null, false, false), 
        NUMERIC_EDITED("Numeric_Edited", true, false), 
        NUMERIC_IN_COBOL("COBOL_NUMERIC", true, true);
        
        public final boolean numeric;
        public final boolean numericInCobol;
        public final boolean editNumeric;
        public final String name;
        
        private NumericClass(final String name2, final boolean numeric, final boolean numericInCobol) {
            this.name = name2;
            this.numeric = numeric;
            this.numericInCobol = numericInCobol;
            this.editNumeric = (numeric && !numericInCobol);
        }
        
        @Override
        public String getName() {
            return this.name;
        }
    }
    
    public enum Cb2xmlXmlFormat
    {
        CLASSIC, 
        FORMAT_2017;
    }
    
    public enum SignClause implements IGetName
    {
        NO_SIGN_CLAUSE(SignPosition.NOT_SPECIFIED, false), 
        SIGN_SEPARATE(SignPosition.NOT_SPECIFIED, true), 
        SIGN_LEADING(SignPosition.LEADING_SIGN, false), 
        SIGN_TRAILING(SignPosition.TRAILING_SIGN, false), 
        SIGN_LEADING_SEPARATE(SignPosition.LEADING_SIGN, true), 
        SIGN_TRAILING_SEPARATE(SignPosition.TRAILING_SIGN, true);
        
        public final SignPosition signPosition;
        public final boolean signSeparate;
        public final String name;
        
        private SignClause(final SignPosition signPosition, final boolean signSeparate) {
            this.signPosition = signPosition;
            this.signSeparate = signSeparate;
            final StringBuilder sb = new StringBuilder(20);
            if (signPosition.name != null) {
                sb.append(signPosition.name);
            }
            if (signSeparate) {
                if (sb.length() > 0) {
                    sb.append('_');
                }
                sb.append("separate");
            }
            this.name = ((sb.length() == 0) ? null : sb.toString());
        }
        
        @Override
        public String getName() {
            return this.name;
        }
    }
    
    public enum SignPosition implements IGetName
    {
        NOT_SPECIFIED((String)null), 
        LEADING_SIGN("leading"), 
        TRAILING_SIGN("trailing");
        
        public final String name;
        
        private SignPosition(final String name2) {
            this.name = name2;
        }
        
        @Override
        public String getName() {
            return this.name;
        }
    }
}
