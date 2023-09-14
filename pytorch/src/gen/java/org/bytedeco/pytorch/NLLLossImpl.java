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


// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ NLLLoss ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

/** The negative log likelihood loss. It is useful to train a classification
 *  problem with {@code C} classes.
 *  See https://pytorch.org/docs/master/nn.html#torch.nn.NLLLoss to learn
 *  about the exact behavior of this module.
 * 
 *  See the documentation for {@code torch::nn::NLLLossOptions} class to learn what
 *  constructor arguments are supported for this module.
 * 
 *  Example:
 *  <pre>{@code
 *  NLLLoss model(NLLLossOptions().ignore_index(-100).reduction(torch::kMean));
 *  }</pre> */
@Namespace("torch::nn") @NoOffset @Properties(inherit = org.bytedeco.pytorch.presets.torch.class)
public class NLLLossImpl extends NLLLossImplCloneable {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public NLLLossImpl(Pointer p) { super(p); }
    /** Downcast constructor. */
    public NLLLossImpl(Module pointer) { super((Pointer)null); allocate(pointer); }
    @Namespace private native @SharedPtr @Name("SHARED_PTR_NAMESPACE::dynamic_pointer_cast<torch::nn::NLLLossImpl, torch::nn::Module>") void allocate(@SharedPtr Module pointer);

  public NLLLossImpl(@ByVal(nullValue = "torch::nn::NLLLossOptions{}") NLLLossOptions options_) { super((Pointer)null); allocate(options_); }
  @SharedPtr @Name("std::make_shared<torch::nn::NLLLossImpl>") private native void allocate(@ByVal(nullValue = "torch::nn::NLLLossOptions{}") NLLLossOptions options_);
  public NLLLossImpl() { super((Pointer)null); allocate(); }
  @SharedPtr @Name("std::make_shared<torch::nn::NLLLossImpl>") private native void allocate();

  /** Pretty prints the {@code NLLLoss} module into the given {@code stream}. */
  public native void pretty_print(@Cast("std::ostream*") @ByRef Pointer stream);

  public native void reset();

  public native @ByVal Tensor forward(@Const @ByRef Tensor input, @Const @ByRef Tensor target);

  /** The options with which this {@code Module} was constructed. */
  public native @ByRef NLLLossOptions options(); public native NLLLossImpl options(NLLLossOptions setter);

  /** A manual rescaling weight given to to each class. */
  public native @ByRef Tensor weight(); public native NLLLossImpl weight(Tensor setter);
}
