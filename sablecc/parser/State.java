// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.parser;

import java.util.ArrayList;

final class State
{
    int state;
    ArrayList<Object> nodes;
    
    State(final int state, final ArrayList<Object> nodes) {
        this.state = state;
        this.nodes = nodes;
    }
}
