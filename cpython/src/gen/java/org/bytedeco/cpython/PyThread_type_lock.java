// Targeted by JavaCPP version 1.5.9-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cpython;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.cpython.global.python.*;


@Namespace @Name("void") @Opaque @Properties(inherit = org.bytedeco.cpython.presets.python.class)
public class PyThread_type_lock extends Pointer {
    /** Empty constructor. Calls {@code super((Pointer)null)}. */
    public PyThread_type_lock() { super((Pointer)null); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public PyThread_type_lock(Pointer p) { super(p); }
}
