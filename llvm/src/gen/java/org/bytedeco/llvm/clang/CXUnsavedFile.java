// Targeted by JavaCPP version 1.5.2-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.llvm.clang;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import org.bytedeco.llvm.LLVM.*;
import static org.bytedeco.llvm.global.LLVM.*;

import static org.bytedeco.llvm.global.clang.*;


/**
 * Provides the contents of a file that has not yet been saved to disk.
 *
 * Each CXUnsavedFile instance provides the name of a file on the
 * system along with the current contents of that file that have not
 * yet been saved to disk.
 */
@Properties(inherit = org.bytedeco.llvm.presets.clang.class)
public class CXUnsavedFile extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public CXUnsavedFile() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public CXUnsavedFile(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public CXUnsavedFile(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public CXUnsavedFile position(long position) {
        return (CXUnsavedFile)super.position(position);
    }

  /**
   * The file whose contents have not yet been saved.
   *
   * This file must already exist in the file system.
   */
  public native @Cast("const char*") BytePointer Filename(); public native CXUnsavedFile Filename(BytePointer setter);

  /**
   * A buffer containing the unsaved contents of this file.
   */
  public native @Cast("const char*") BytePointer Contents(); public native CXUnsavedFile Contents(BytePointer setter);

  /**
   * The length of the unsaved contents of this buffer.
   */
  public native @Cast("unsigned long") long Length(); public native CXUnsavedFile Length(long setter);
}
