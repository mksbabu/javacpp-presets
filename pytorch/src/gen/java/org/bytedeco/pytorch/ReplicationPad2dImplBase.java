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

@Name("torch::nn::ReplicationPadImpl<2,torch::nn::ReplicationPad2dImpl>") @NoOffset @Properties(inherit = org.bytedeco.pytorch.presets.torch.class)
public class ReplicationPad2dImplBase extends ReplicationPad2dImplCloneable {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ReplicationPad2dImplBase(Pointer p) { super(p); }
    /** Downcast constructor. */
    public ReplicationPad2dImplBase(Module pointer) { super((Pointer)null); allocate(pointer); }
    @Namespace private native @SharedPtr @Name("SHARED_PTR_NAMESPACE::dynamic_pointer_cast<torch::nn::ReplicationPadImpl<2,torch::nn::ReplicationPad2dImpl>, torch::nn::Module>") void allocate(@SharedPtr Module pointer);

  public ReplicationPad2dImplBase(@ByVal @Cast("torch::ExpandingArray<2*2>*") LongPointer padding) { super((Pointer)null); allocate(padding); }
  private native void allocate(@ByVal @Cast("torch::ExpandingArray<2*2>*") LongPointer padding);
  public ReplicationPad2dImplBase(@Const @ByRef ReplicationPad2dOptions options_) { super((Pointer)null); allocate(options_); }
  private native void allocate(@Const @ByRef ReplicationPad2dOptions options_);

  public native void reset();

  public native @ByVal Tensor forward(@Const @ByRef Tensor input);

  /** Pretty prints the {@code ReplicationPad{1,2}d} module into the given {@code stream}. */
  public native void pretty_print(@Cast("std::ostream*") @ByRef Pointer stream);

  /** The options with which this {@code Module} was constructed. */
  public native @ByRef ReplicationPad2dOptions options(); public native ReplicationPad2dImplBase options(ReplicationPad2dOptions setter);
}
