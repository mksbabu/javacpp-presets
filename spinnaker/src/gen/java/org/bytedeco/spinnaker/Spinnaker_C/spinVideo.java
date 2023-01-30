// Targeted by JavaCPP version 1.5.9-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.spinnaker.Spinnaker_C;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.spinnaker.global.Spinnaker_C.*;


/**
 * Handle for video recording functionality. Created by calling
 * spinVideoOpenUncompressed(), spinVideoOpenMJPG(), and
 * spinVideoOpenH264(), which require a call to
 * spinVideoClose() to destroy.
 */
@Namespace @Name("void") @Opaque @Properties(inherit = org.bytedeco.spinnaker.presets.Spinnaker_C.class)
public class spinVideo extends Pointer {
    /** Empty constructor. Calls {@code super((Pointer)null)}. */
    public spinVideo() { super((Pointer)null); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public spinVideo(Pointer p) { super(p); }
}
