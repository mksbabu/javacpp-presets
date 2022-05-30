// Targeted by JavaCPP version 1.5.8-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.libffi;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.libffi.global.ffi.*;

// #endif

@Properties(inherit = org.bytedeco.libffi.presets.ffi.class)
public class Fun_ffi_cif_Pointer_PointerPointer_Pointer extends FunctionPointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public    Fun_ffi_cif_Pointer_PointerPointer_Pointer(Pointer p) { super(p); }
    protected Fun_ffi_cif_Pointer_PointerPointer_Pointer() { allocate(); }
    private native void allocate();
    public native void call(ffi_cif arg0,Pointer arg1,@Cast("void**") PointerPointer arg2,Pointer arg3);
}
