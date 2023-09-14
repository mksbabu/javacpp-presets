// Targeted by JavaCPP version 1.5.10-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.pytorch;

import org.bytedeco.pytorch.Allocator;
import org.bytedeco.pytorch.Function;
import org.bytedeco.pytorch.functions.*;
import org.bytedeco.pytorch.Module;
import org.bytedeco.javacpp.annotation.Cast;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;

import static org.bytedeco.pytorch.global.torch.*;


// A Function is a pure Graph with no implicit `self` object bound.
// It contains schema information and the executor that manages the
// execution of the function. Method is a wrapper around an
// underlying Function that also provides a `self` object.
@Namespace("torch::jit") @Properties(inherit = org.bytedeco.pytorch.presets.torch.class)
public class Function extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Function(Pointer p) { super(p); }

  public native @StringView BytePointer doc_string();

  public native @Cast("bool") boolean isGraphFunction();

  public native void run(@ByRef IValueVector stack);

  public native @ByVal FuturePtr runAsync(
        @ByRef IValueVector arg0,
        @ByVal(nullValue = "torch::jit::TaskLauncher(at::launch)") @Cast("torch::jit::TaskLauncher*") Pointer taskLauncher);
  public native @ByVal FuturePtr runAsync(
        @ByRef IValueVector arg0);

  public native @ByVal @Name("operator ()") IValue apply(
      @ByVal IValueVector stack,
      @Cast("const torch::jit::Kwargs*") @ByRef(nullValue = "torch::jit::Kwargs()") StringIValueMap kwargs);
  public native @ByVal @Name("operator ()") IValue apply(
      @ByVal IValueVector stack);

  public native @Const @ByRef QualifiedName qualname();

  public native @StdString BytePointer name();

  // if this isn't yet defined, run its method_creator function
  public native void ensure_defined();

  public native @Const @ByRef FunctionSchema getSchema();

  public native @Cast("size_t") long num_inputs();

  public native @ByRef Function setSchema(@ByVal FunctionSchema schema);

  // call() defines how different interpreter implementations interacts with
  // Function objects. Basically interpreters need to provide a callback to
  // communicate to Functions what to do if provided a Code object.
  // Alternatively we could design the signature to return an optional Code
  // object, but that requires special handling the null case in interpreter
  // and the fallback behavior is not well defined by interpreter but rather
  // Function themselves, so a callback approach is more reasonable than
  // returning values.
  // If call() returns true, then callback completes successfully, otherwise
  // call() returns false.

  // Overload for server interpreter, a bailout size is needed for graph executor.
  

  // Overload for mobile interpreter.
  
}
