// Targeted by JavaCPP version 1.5.7-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.systems.macosx;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.systems.global.macosx.*;
 /* __darwin_size_t */

@Name("__darwin_sigaltstack") @Properties(inherit = org.bytedeco.systems.presets.macosx.class)
public class stack_t extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public stack_t() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public stack_t(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public stack_t(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public stack_t position(long position) {
        return (stack_t)super.position(position);
    }
    @Override public stack_t getPointer(long i) {
        return new stack_t((Pointer)this).offsetAddress(i);
    }

	public native Pointer ss_sp(); public native stack_t ss_sp(Pointer setter);         /* signal stack base */
	public native @Cast("__darwin_size_t") long ss_size(); public native stack_t ss_size(long setter);        /* signal stack length */
	public native int ss_flags(); public native stack_t ss_flags(int setter);       /* SA_DISABLE and/or SA_ONSTACK */
}
