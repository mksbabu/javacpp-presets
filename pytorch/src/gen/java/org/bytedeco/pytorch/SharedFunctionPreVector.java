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

@Name("std::vector<std::shared_ptr<torch::autograd::FunctionPreHook> >") @Properties(inherit = org.bytedeco.pytorch.presets.torch.class)
public class SharedFunctionPreVector extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SharedFunctionPreVector(Pointer p) { super(p); }
    public SharedFunctionPreVector(FunctionPreHook value) { this(1); put(0, value); }
    public SharedFunctionPreVector(FunctionPreHook ... array) { this(array.length); put(array); }
    public SharedFunctionPreVector()       { allocate();  }
    public SharedFunctionPreVector(long n) { allocate(n); }
    private native void allocate();
    private native void allocate(@Cast("size_t") long n);
    public native @Name("operator =") @ByRef SharedFunctionPreVector put(@ByRef SharedFunctionPreVector x);

    public boolean empty() { return size() == 0; }
    public native long size();
    public void clear() { resize(0); }
    public native void resize(@Cast("size_t") long n);

    public FunctionPreHook front() { return get(0); }
    public FunctionPreHook back() { return get(size() - 1); }
    @Index(function = "at") public native @SharedPtr("torch::autograd::FunctionPreHook") FunctionPreHook get(@Cast("size_t") long i);
    public native SharedFunctionPreVector put(@Cast("size_t") long i, FunctionPreHook value);

    public native @ByVal Iterator insert(@ByVal Iterator pos, @SharedPtr("torch::autograd::FunctionPreHook") FunctionPreHook value);
    public native @ByVal Iterator erase(@ByVal Iterator pos);
    public native @ByVal Iterator begin();
    public native @ByVal Iterator end();
    @NoOffset @Name("iterator") public static class Iterator extends Pointer {
        public Iterator(Pointer p) { super(p); }
        public Iterator() { }

        public native @Name("operator ++") @ByRef Iterator increment();
        public native @Name("operator ==") boolean equals(@ByRef Iterator it);
        public native @Name("operator *") @SharedPtr("torch::autograd::FunctionPreHook") @Const FunctionPreHook get();
    }

    public FunctionPreHook[] get() {
        FunctionPreHook[] array = new FunctionPreHook[size() < Integer.MAX_VALUE ? (int)size() : Integer.MAX_VALUE];
        for (int i = 0; i < array.length; i++) {
            array[i] = get(i);
        }
        return array;
    }
    @Override public String toString() {
        return java.util.Arrays.toString(get());
    }

    public FunctionPreHook pop_back() {
        long size = size();
        FunctionPreHook value = get(size - 1);
        resize(size - 1);
        return value;
    }
    public SharedFunctionPreVector push_back(FunctionPreHook value) {
        long size = size();
        resize(size + 1);
        return put(size, value);
    }
    public SharedFunctionPreVector put(FunctionPreHook value) {
        if (size() != 1) { resize(1); }
        return put(0, value);
    }
    public SharedFunctionPreVector put(FunctionPreHook ... array) {
        if (size() != array.length) { resize(array.length); }
        for (int i = 0; i < array.length; i++) {
            put(i, array[i]);
        }
        return this;
    }
}

