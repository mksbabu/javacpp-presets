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


// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Linear ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

/** Applies a linear transformation with optional bias.
 *  See https://pytorch.org/docs/master/generated/torch.nn.Linear.html to learn
 *  about the exact behavior of this module.
 * 
 *  See the documentation for {@code torch::nn::LinearOptions} class to learn what
 *  constructor arguments are supported for this module.
 * 
 *  Example:
 *  <pre>{@code
 *  Linear model(LinearOptions(5, 2).bias(false));
 *  }</pre> */
@Namespace("torch::nn") @NoOffset @Properties(inherit = org.bytedeco.pytorch.presets.torch.class)
public class LinearImpl extends LinearImplCloneable {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LinearImpl(Pointer p) { super(p); }
    /** Downcast constructor. */
    public LinearImpl(Module pointer) { super((Pointer)null); allocate(pointer); }
    @Namespace private native @SharedPtr @Name("SHARED_PTR_NAMESPACE::dynamic_pointer_cast<torch::nn::LinearImpl, torch::nn::Module>") void allocate(@SharedPtr Module pointer);

  public LinearImpl(@Cast("int64_t") long in_features, @Cast("int64_t") long out_features) { super((Pointer)null); allocate(in_features, out_features); }
  @SharedPtr @Name("std::make_shared<torch::nn::LinearImpl>") private native void allocate(@Cast("int64_t") long in_features, @Cast("int64_t") long out_features);
  public LinearImpl(@Const @ByRef LinearOptions options_) { super((Pointer)null); allocate(options_); }
  @SharedPtr @Name("std::make_shared<torch::nn::LinearImpl>") private native void allocate(@Const @ByRef LinearOptions options_);

  public native void reset();

  public native void reset_parameters();

  /** Pretty prints the {@code Linear} module into the given {@code stream}. */
  public native void pretty_print(@Cast("std::ostream*") @ByRef Pointer stream);

  /** Transforms the {@code input} tensor by multiplying with the {@code weight} and
   *  optionally adding the {@code bias}, if {@code with_bias} is true in the options. */
  public native @ByVal Tensor forward(@Const @ByRef Tensor input);

  /** The options used to configure this module. */
  public native @ByRef LinearOptions options(); public native LinearImpl options(LinearOptions setter);

  /** The learned weight. */
  public native @ByRef Tensor weight(); public native LinearImpl weight(Tensor setter);

  /** The learned bias. If {@code bias} is false in the {@code options}, this tensor is
   *  undefined. */
  public native @ByRef Tensor bias(); public native LinearImpl bias(Tensor setter);
}
