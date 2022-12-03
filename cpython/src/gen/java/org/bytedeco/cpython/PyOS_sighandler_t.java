// Targeted by JavaCPP version 1.5.9-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cpython;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.cpython.global.python.*;


/* Signals */
@Properties(inherit = org.bytedeco.cpython.presets.python.class)
public class PyOS_sighandler_t extends FunctionPointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public    PyOS_sighandler_t(Pointer p) { super(p); }
    protected PyOS_sighandler_t() { allocate(); }
    private native void allocate();
    public native void call(int arg0);
}
