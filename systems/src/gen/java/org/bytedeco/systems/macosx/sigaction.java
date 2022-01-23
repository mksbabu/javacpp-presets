// Targeted by JavaCPP version 1.5.7-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.systems.macosx;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.systems.global.macosx.*;


/*
 * Signal vector "template" used in sigaction call.
 */
@Name("struct sigaction") @Properties(inherit = org.bytedeco.systems.presets.macosx.class)
public class sigaction extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public sigaction() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public sigaction(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public sigaction(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public sigaction position(long position) {
        return (sigaction)super.position(position);
    }
    @Override public sigaction getPointer(long i) {
        return new sigaction((Pointer)this).offsetAddress(i);
    }

	public native @ByRef __sigaction_u __sigaction_u(); public native sigaction __sigaction_u(__sigaction_u setter);  /* signal handler */
	public native @Cast("sigset_t") int sa_mask(); public native sigaction sa_mask(int setter);               /* signal mask to apply */
	public native int sa_flags(); public native sigaction sa_flags(int setter);               /* see signal options below */
}
