// Targeted by JavaCPP version 1.1-SNAPSHOT

package org.bytedeco.javacpp;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_imgproc.*;
import static org.bytedeco.javacpp.opencv_imgcodecs.*;
import static org.bytedeco.javacpp.opencv_videoio.*;
import static org.bytedeco.javacpp.opencv_highgui.*;
import static org.bytedeco.javacpp.opencv_flann.*;
import static org.bytedeco.javacpp.opencv_ml.*;
import static org.bytedeco.javacpp.opencv_features2d.*;

public class opencv_calib3d extends org.bytedeco.javacpp.helper.opencv_calib3d {
    static { Loader.load(); }

// Parsed from <opencv2/calib3d/calib3d_c.h>

/*M///////////////////////////////////////////////////////////////////////////////////////
//
//  IMPORTANT: READ BEFORE DOWNLOADING, COPYING, INSTALLING OR USING.
//
//  By downloading, copying, installing or using the software you agree to this license.
//  If you do not agree to this license, do not download, install,
//  copy or use the software.
//
//
//                          License Agreement
//                For Open Source Computer Vision Library
//
// Copyright (C) 2000-2008, Intel Corporation, all rights reserved.
// Copyright (C) 2009, Willow Garage Inc., all rights reserved.
// Copyright (C) 2013, OpenCV Foundation, all rights reserved.
// Third party copyrights are property of their respective owners.
//
// Redistribution and use in source and binary forms, with or without modification,
// are permitted provided that the following conditions are met:
//
//   * Redistribution's of source code must retain the above copyright notice,
//     this list of conditions and the following disclaimer.
//
//   * Redistribution's in binary form must reproduce the above copyright notice,
//     this list of conditions and the following disclaimer in the documentation
//     and/or other materials provided with the distribution.
//
//   * The name of the copyright holders may not be used to endorse or promote products
//     derived from this software without specific prior written permission.
//
// This software is provided by the copyright holders and contributors "as is" and
// any express or implied warranties, including, but not limited to, the implied
// warranties of merchantability and fitness for a particular purpose are disclaimed.
// In no event shall the Intel Corporation or contributors be liable for any direct,
// indirect, incidental, special, exemplary, or consequential damages
// (including, but not limited to, procurement of substitute goods or services;
// loss of use, data, or profits; or business interruption) however caused
// and on any theory of liability, whether in contract, strict liability,
// or tort (including negligence or otherwise) arising in any way out of
// the use of this software, even if advised of the possibility of such damage.
//
//M*/

// #ifndef __OPENCV_CALIB3D_C_H__
// #define __OPENCV_CALIB3D_C_H__

// #include "opencv2/core/core_c.h"

// #ifdef __cplusplus
// #endif

/** @addtogroup calib3d_c
  @{
  */

/****************************************************************************************\
*                      Camera Calibration, Pose Estimation and Stereo                    *
\****************************************************************************************/

@Opaque public static class CvPOSITObject extends AbstractCvPOSITObject {
    /** Empty constructor. */
    public CvPOSITObject() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public CvPOSITObject(Pointer p) { super(p); }
}

/* Allocates and initializes CvPOSITObject structure before doing cvPOSIT */
public static native CvPOSITObject cvCreatePOSITObject( CvPoint3D32f points, int point_count );
public static native CvPOSITObject cvCreatePOSITObject( @Cast("CvPoint3D32f*") FloatBuffer points, int point_count );
public static native CvPOSITObject cvCreatePOSITObject( @Cast("CvPoint3D32f*") float[] points, int point_count );


/* Runs POSIT (POSe from ITeration) algorithm for determining 3d position of
   an object given its model and projection in a weak-perspective case */
public static native void cvPOSIT(  CvPOSITObject posit_object, CvPoint2D32f image_points,
                       double focal_length, @ByVal CvTermCriteria criteria,
                       FloatPointer rotation_matrix, FloatPointer translation_vector);
public static native void cvPOSIT(  CvPOSITObject posit_object, @Cast("CvPoint2D32f*") FloatBuffer image_points,
                       double focal_length, @ByVal CvTermCriteria criteria,
                       FloatBuffer rotation_matrix, FloatBuffer translation_vector);
public static native void cvPOSIT(  CvPOSITObject posit_object, @Cast("CvPoint2D32f*") float[] image_points,
                       double focal_length, @ByVal CvTermCriteria criteria,
                       float[] rotation_matrix, float[] translation_vector);

/* Releases CvPOSITObject structure */
public static native void cvReleasePOSITObject( @Cast("CvPOSITObject**") PointerPointer posit_object );
public static native void cvReleasePOSITObject( @ByPtrPtr CvPOSITObject posit_object );

/* updates the number of RANSAC iterations */
public static native int cvRANSACUpdateNumIters( double p, double err_prob,
                                   int model_points, int max_iters );

public static native void cvConvertPointsHomogeneous( @Const CvMat src, CvMat dst );

/* Calculates fundamental matrix given a set of corresponding points */
public static final int CV_FM_7POINT = 1;
public static final int CV_FM_8POINT = 2;

public static final int CV_LMEDS = 4;
public static final int CV_RANSAC = 8;

public static final int CV_FM_LMEDS_ONLY =  CV_LMEDS;
public static final int CV_FM_RANSAC_ONLY = CV_RANSAC;
public static final int CV_FM_LMEDS = CV_LMEDS;
public static final int CV_FM_RANSAC = CV_RANSAC;

/** enum  */
public static final int
    CV_ITERATIVE = 0,
    CV_EPNP = 1, // F.Moreno-Noguer, V.Lepetit and P.Fua "EPnP: Efficient Perspective-n-Point Camera Pose Estimation"
    CV_P3P = 2, // X.S. Gao, X.-R. Hou, J. Tang, H.-F. Chang; "Complete Solution Classification for the Perspective-Three-Point Problem"
    CV_DLS = 3; // Joel A. Hesch and Stergios I. Roumeliotis. "A Direct Least-Squares (DLS) Method for PnP"

public static native int cvFindFundamentalMat( @Const CvMat points1, @Const CvMat points2,
                                 CvMat fundamental_matrix,
                                 int method/*=CV_FM_RANSAC*/,
                                 double param1/*=3.*/, double param2/*=0.99*/,
                                 CvMat status/*=NULL*/ );
public static native int cvFindFundamentalMat( @Const CvMat points1, @Const CvMat points2,
                                 CvMat fundamental_matrix );

/* For each input point on one of images
   computes parameters of the corresponding
   epipolar line on the other image */
public static native void cvComputeCorrespondEpilines( @Const CvMat points,
                                         int which_image,
                                         @Const CvMat fundamental_matrix,
                                         CvMat correspondent_lines );

/* Triangulation functions */

public static native void cvTriangulatePoints(CvMat projMatr1, CvMat projMatr2,
                                CvMat projPoints1, CvMat projPoints2,
                                CvMat points4D);

public static native void cvCorrectMatches(CvMat F, CvMat points1, CvMat points2,
                             CvMat new_points1, CvMat new_points2);


/* Computes the optimal new camera matrix according to the free scaling parameter alpha:
   alpha=0 - only valid pixels will be retained in the undistorted image
   alpha=1 - all the source image pixels will be retained in the undistorted image
*/
public static native void cvGetOptimalNewCameraMatrix( @Const CvMat camera_matrix,
                                         @Const CvMat dist_coeffs,
                                         @ByVal CvSize image_size, double alpha,
                                         CvMat new_camera_matrix,
                                         @ByVal(nullValue = "cvSize(0,0)") CvSize new_imag_size/*=cvSize(0,0)*/,
                                         CvRect valid_pixel_ROI/*=0*/,
                                         int center_principal_point/*=0*/);
public static native void cvGetOptimalNewCameraMatrix( @Const CvMat camera_matrix,
                                         @Const CvMat dist_coeffs,
                                         @ByVal CvSize image_size, double alpha,
                                         CvMat new_camera_matrix);

/* Converts rotation vector to rotation matrix or vice versa */
public static native int cvRodrigues2( @Const CvMat src, CvMat dst,
                         CvMat jacobian/*=0*/ );
public static native int cvRodrigues2( @Const CvMat src, CvMat dst );

/* Finds perspective transformation between the object plane and image (view) plane */
public static native int cvFindHomography( @Const CvMat src_points,
                             @Const CvMat dst_points,
                             CvMat homography,
                             int method/*=0*/,
                             double ransacReprojThreshold/*=3*/,
                             CvMat mask/*=0*/,
                             int maxIters/*=2000*/,
                             double confidence/*=0.995*/);
public static native int cvFindHomography( @Const CvMat src_points,
                             @Const CvMat dst_points,
                             CvMat homography);

/* Computes RQ decomposition for 3x3 matrices */
public static native void cvRQDecomp3x3( @Const CvMat matrixM, CvMat matrixR, CvMat matrixQ,
                           CvMat matrixQx/*=NULL*/,
                           CvMat matrixQy/*=NULL*/,
                           CvMat matrixQz/*=NULL*/,
                           CvPoint3D64f eulerAngles/*=NULL*/);
public static native void cvRQDecomp3x3( @Const CvMat matrixM, CvMat matrixR, CvMat matrixQ);
public static native void cvRQDecomp3x3( @Const CvMat matrixM, CvMat matrixR, CvMat matrixQ,
                           CvMat matrixQx/*=NULL*/,
                           CvMat matrixQy/*=NULL*/,
                           CvMat matrixQz/*=NULL*/,
                           @Cast("CvPoint3D64f*") DoubleBuffer eulerAngles/*=NULL*/);
public static native void cvRQDecomp3x3( @Const CvMat matrixM, CvMat matrixR, CvMat matrixQ,
                           CvMat matrixQx/*=NULL*/,
                           CvMat matrixQy/*=NULL*/,
                           CvMat matrixQz/*=NULL*/,
                           @Cast("CvPoint3D64f*") double[] eulerAngles/*=NULL*/);

/* Computes projection matrix decomposition */
public static native void cvDecomposeProjectionMatrix( @Const CvMat projMatr, CvMat calibMatr,
                                         CvMat rotMatr, CvMat posVect,
                                         CvMat rotMatrX/*=NULL*/,
                                         CvMat rotMatrY/*=NULL*/,
                                         CvMat rotMatrZ/*=NULL*/,
                                         CvPoint3D64f eulerAngles/*=NULL*/);
public static native void cvDecomposeProjectionMatrix( @Const CvMat projMatr, CvMat calibMatr,
                                         CvMat rotMatr, CvMat posVect);
public static native void cvDecomposeProjectionMatrix( @Const CvMat projMatr, CvMat calibMatr,
                                         CvMat rotMatr, CvMat posVect,
                                         CvMat rotMatrX/*=NULL*/,
                                         CvMat rotMatrY/*=NULL*/,
                                         CvMat rotMatrZ/*=NULL*/,
                                         @Cast("CvPoint3D64f*") DoubleBuffer eulerAngles/*=NULL*/);
public static native void cvDecomposeProjectionMatrix( @Const CvMat projMatr, CvMat calibMatr,
                                         CvMat rotMatr, CvMat posVect,
                                         CvMat rotMatrX/*=NULL*/,
                                         CvMat rotMatrY/*=NULL*/,
                                         CvMat rotMatrZ/*=NULL*/,
                                         @Cast("CvPoint3D64f*") double[] eulerAngles/*=NULL*/);

/* Computes d(AB)/dA and d(AB)/dB */
public static native void cvCalcMatMulDeriv( @Const CvMat A, @Const CvMat B, CvMat dABdA, CvMat dABdB );

/* Computes r3 = rodrigues(rodrigues(r2)*rodrigues(r1)),
   t3 = rodrigues(r2)*t1 + t2 and the respective derivatives */
public static native void cvComposeRT( @Const CvMat _rvec1, @Const CvMat _tvec1,
                         @Const CvMat _rvec2, @Const CvMat _tvec2,
                         CvMat _rvec3, CvMat _tvec3,
                         CvMat dr3dr1/*=0*/, CvMat dr3dt1/*=0*/,
                         CvMat dr3dr2/*=0*/, CvMat dr3dt2/*=0*/,
                         CvMat dt3dr1/*=0*/, CvMat dt3dt1/*=0*/,
                         CvMat dt3dr2/*=0*/, CvMat dt3dt2/*=0*/ );
public static native void cvComposeRT( @Const CvMat _rvec1, @Const CvMat _tvec1,
                         @Const CvMat _rvec2, @Const CvMat _tvec2,
                         CvMat _rvec3, CvMat _tvec3 );

/* Projects object points to the view plane using
   the specified extrinsic and intrinsic camera parameters */
public static native void cvProjectPoints2( @Const CvMat object_points, @Const CvMat rotation_vector,
                              @Const CvMat translation_vector, @Const CvMat camera_matrix,
                              @Const CvMat distortion_coeffs, CvMat image_points,
                              CvMat dpdrot/*=NULL*/, CvMat dpdt/*=NULL*/,
                              CvMat dpdf/*=NULL*/, CvMat dpdc/*=NULL*/,
                              CvMat dpddist/*=NULL*/,
                              double aspect_ratio/*=0*/);
public static native void cvProjectPoints2( @Const CvMat object_points, @Const CvMat rotation_vector,
                              @Const CvMat translation_vector, @Const CvMat camera_matrix,
                              @Const CvMat distortion_coeffs, CvMat image_points);

/* Finds extrinsic camera parameters from
   a few known corresponding point pairs and intrinsic parameters */
public static native void cvFindExtrinsicCameraParams2( @Const CvMat object_points,
                                          @Const CvMat image_points,
                                          @Const CvMat camera_matrix,
                                          @Const CvMat distortion_coeffs,
                                          CvMat rotation_vector,
                                          CvMat translation_vector,
                                          int use_extrinsic_guess/*=0*/ );
public static native void cvFindExtrinsicCameraParams2( @Const CvMat object_points,
                                          @Const CvMat image_points,
                                          @Const CvMat camera_matrix,
                                          @Const CvMat distortion_coeffs,
                                          CvMat rotation_vector,
                                          CvMat translation_vector );

/* Computes initial estimate of the intrinsic camera parameters
   in case of planar calibration target (e.g. chessboard) */
public static native void cvInitIntrinsicParams2D( @Const CvMat object_points,
                                     @Const CvMat image_points,
                                     @Const CvMat npoints, @ByVal CvSize image_size,
                                     CvMat camera_matrix,
                                     double aspect_ratio/*=1.*/ );
public static native void cvInitIntrinsicParams2D( @Const CvMat object_points,
                                     @Const CvMat image_points,
                                     @Const CvMat npoints, @ByVal CvSize image_size,
                                     CvMat camera_matrix );

public static final int CV_CALIB_CB_ADAPTIVE_THRESH =  1;
public static final int CV_CALIB_CB_NORMALIZE_IMAGE =  2;
public static final int CV_CALIB_CB_FILTER_QUADS =     4;
public static final int CV_CALIB_CB_FAST_CHECK =       8;

// Performs a fast check if a chessboard is in the input image. This is a workaround to
// a problem of cvFindChessboardCorners being slow on images with no chessboard
// - src: input image
// - size: chessboard size
// Returns 1 if a chessboard can be in this image and findChessboardCorners should be called,
// 0 if there is no chessboard, -1 in case of error
public static native int cvCheckChessboard(IplImage src, @ByVal CvSize size);

    /* Detects corners on a chessboard calibration pattern */
public static native int cvFindChessboardCorners( @Const Pointer image, @ByVal CvSize pattern_size,
                                    CvPoint2D32f corners,
                                    IntPointer corner_count/*=NULL*/,
                                    int flags/*=CV_CALIB_CB_ADAPTIVE_THRESH+CV_CALIB_CB_NORMALIZE_IMAGE*/ );
public static native int cvFindChessboardCorners( @Const Pointer image, @ByVal CvSize pattern_size,
                                    CvPoint2D32f corners );
public static native int cvFindChessboardCorners( @Const Pointer image, @ByVal CvSize pattern_size,
                                    @Cast("CvPoint2D32f*") FloatBuffer corners,
                                    IntBuffer corner_count/*=NULL*/,
                                    int flags/*=CV_CALIB_CB_ADAPTIVE_THRESH+CV_CALIB_CB_NORMALIZE_IMAGE*/ );
public static native int cvFindChessboardCorners( @Const Pointer image, @ByVal CvSize pattern_size,
                                    @Cast("CvPoint2D32f*") FloatBuffer corners );
public static native int cvFindChessboardCorners( @Const Pointer image, @ByVal CvSize pattern_size,
                                    @Cast("CvPoint2D32f*") float[] corners,
                                    int[] corner_count/*=NULL*/,
                                    int flags/*=CV_CALIB_CB_ADAPTIVE_THRESH+CV_CALIB_CB_NORMALIZE_IMAGE*/ );
public static native int cvFindChessboardCorners( @Const Pointer image, @ByVal CvSize pattern_size,
                                    @Cast("CvPoint2D32f*") float[] corners );

/* Draws individual chessboard corners or the whole chessboard detected */
public static native void cvDrawChessboardCorners( CvArr image, @ByVal CvSize pattern_size,
                                     CvPoint2D32f corners,
                                     int count, int pattern_was_found );
public static native void cvDrawChessboardCorners( CvArr image, @ByVal CvSize pattern_size,
                                     @Cast("CvPoint2D32f*") FloatBuffer corners,
                                     int count, int pattern_was_found );
public static native void cvDrawChessboardCorners( CvArr image, @ByVal CvSize pattern_size,
                                     @Cast("CvPoint2D32f*") float[] corners,
                                     int count, int pattern_was_found );

public static final int CV_CALIB_USE_INTRINSIC_GUESS =  1;
public static final int CV_CALIB_FIX_ASPECT_RATIO =     2;
public static final int CV_CALIB_FIX_PRINCIPAL_POINT =  4;
public static final int CV_CALIB_ZERO_TANGENT_DIST =    8;
public static final int CV_CALIB_FIX_FOCAL_LENGTH = 16;
public static final int CV_CALIB_FIX_K1 =  32;
public static final int CV_CALIB_FIX_K2 =  64;
public static final int CV_CALIB_FIX_K3 =  128;
public static final int CV_CALIB_FIX_K4 =  2048;
public static final int CV_CALIB_FIX_K5 =  4096;
public static final int CV_CALIB_FIX_K6 =  8192;
public static final int CV_CALIB_RATIONAL_MODEL = 16384;
public static final int CV_CALIB_THIN_PRISM_MODEL = 32768;
public static final int CV_CALIB_FIX_S1_S2_S3_S4 =  65536;


/* Finds intrinsic and extrinsic camera parameters
   from a few views of known calibration pattern */
public static native double cvCalibrateCamera2( @Const CvMat object_points,
                                @Const CvMat image_points,
                                @Const CvMat point_counts,
                                @ByVal CvSize image_size,
                                CvMat camera_matrix,
                                CvMat distortion_coeffs,
                                CvMat rotation_vectors/*=NULL*/,
                                CvMat translation_vectors/*=NULL*/,
                                int flags/*=0*/,
                                @ByVal(nullValue = "cvTermCriteria("
                                     + "CV_TERMCRIT_ITER+CV_TERMCRIT_EPS,30,DBL_EPSILON)") CvTermCriteria term_crit/*=cvTermCriteria(
                                    CV_TERMCRIT_ITER+CV_TERMCRIT_EPS,30,DBL_EPSILON)*/ );
public static native double cvCalibrateCamera2( @Const CvMat object_points,
                                @Const CvMat image_points,
                                @Const CvMat point_counts,
                                @ByVal CvSize image_size,
                                CvMat camera_matrix,
                                CvMat distortion_coeffs );

/* Computes various useful characteristics of the camera from the data computed by
   cvCalibrateCamera2 */
public static native void cvCalibrationMatrixValues( @Const CvMat camera_matrix,
                                @ByVal CvSize image_size,
                                double aperture_width/*=0*/,
                                double aperture_height/*=0*/,
                                DoublePointer fovx/*=NULL*/,
                                DoublePointer fovy/*=NULL*/,
                                DoublePointer focal_length/*=NULL*/,
                                CvPoint2D64f principal_point/*=NULL*/,
                                DoublePointer pixel_aspect_ratio/*=NULL*/);
public static native void cvCalibrationMatrixValues( @Const CvMat camera_matrix,
                                @ByVal CvSize image_size);
public static native void cvCalibrationMatrixValues( @Const CvMat camera_matrix,
                                @ByVal CvSize image_size,
                                double aperture_width/*=0*/,
                                double aperture_height/*=0*/,
                                DoubleBuffer fovx/*=NULL*/,
                                DoubleBuffer fovy/*=NULL*/,
                                DoubleBuffer focal_length/*=NULL*/,
                                @Cast("CvPoint2D64f*") DoubleBuffer principal_point/*=NULL*/,
                                DoubleBuffer pixel_aspect_ratio/*=NULL*/);
public static native void cvCalibrationMatrixValues( @Const CvMat camera_matrix,
                                @ByVal CvSize image_size,
                                double aperture_width/*=0*/,
                                double aperture_height/*=0*/,
                                double[] fovx/*=NULL*/,
                                double[] fovy/*=NULL*/,
                                double[] focal_length/*=NULL*/,
                                @Cast("CvPoint2D64f*") double[] principal_point/*=NULL*/,
                                double[] pixel_aspect_ratio/*=NULL*/);

public static final int CV_CALIB_FIX_INTRINSIC =  256;
public static final int CV_CALIB_SAME_FOCAL_LENGTH = 512;

/* Computes the transformation from one camera coordinate system to another one
   from a few correspondent views of the same calibration target. Optionally, calibrates
   both cameras */
public static native double cvStereoCalibrate( @Const CvMat object_points, @Const CvMat image_points1,
                               @Const CvMat image_points2, @Const CvMat npoints,
                               CvMat camera_matrix1, CvMat dist_coeffs1,
                               CvMat camera_matrix2, CvMat dist_coeffs2,
                               @ByVal CvSize image_size, CvMat R, CvMat T,
                               CvMat E/*=0*/, CvMat F/*=0*/,
                               int flags/*=CV_CALIB_FIX_INTRINSIC*/,
                               @ByVal(nullValue = "cvTermCriteria("
                                    + "CV_TERMCRIT_ITER+CV_TERMCRIT_EPS,30,1e-6)") CvTermCriteria term_crit/*=cvTermCriteria(
                                   CV_TERMCRIT_ITER+CV_TERMCRIT_EPS,30,1e-6)*/ );
public static native double cvStereoCalibrate( @Const CvMat object_points, @Const CvMat image_points1,
                               @Const CvMat image_points2, @Const CvMat npoints,
                               CvMat camera_matrix1, CvMat dist_coeffs1,
                               CvMat camera_matrix2, CvMat dist_coeffs2,
                               @ByVal CvSize image_size, CvMat R, CvMat T );

public static final int CV_CALIB_ZERO_DISPARITY = 1024;

/* Computes 3D rotations (+ optional shift) for each camera coordinate system to make both
   views parallel (=> to make all the epipolar lines horizontal or vertical) */
public static native void cvStereoRectify( @Const CvMat camera_matrix1, @Const CvMat camera_matrix2,
                             @Const CvMat dist_coeffs1, @Const CvMat dist_coeffs2,
                             @ByVal CvSize image_size, @Const CvMat R, @Const CvMat T,
                             CvMat R1, CvMat R2, CvMat P1, CvMat P2,
                             CvMat Q/*=0*/,
                             int flags/*=CV_CALIB_ZERO_DISPARITY*/,
                             double alpha/*=-1*/,
                             @ByVal(nullValue = "cvSize(0,0)") CvSize new_image_size/*=cvSize(0,0)*/,
                             CvRect valid_pix_ROI1/*=0*/,
                             CvRect valid_pix_ROI2/*=0*/);
public static native void cvStereoRectify( @Const CvMat camera_matrix1, @Const CvMat camera_matrix2,
                             @Const CvMat dist_coeffs1, @Const CvMat dist_coeffs2,
                             @ByVal CvSize image_size, @Const CvMat R, @Const CvMat T,
                             CvMat R1, CvMat R2, CvMat P1, CvMat P2);

/* Computes rectification transformations for uncalibrated pair of images using a set
   of point correspondences */
public static native int cvStereoRectifyUncalibrated( @Const CvMat points1, @Const CvMat points2,
                                        @Const CvMat F, @ByVal CvSize img_size,
                                        CvMat H1, CvMat H2,
                                        double threshold/*=5*/);
public static native int cvStereoRectifyUncalibrated( @Const CvMat points1, @Const CvMat points2,
                                        @Const CvMat F, @ByVal CvSize img_size,
                                        CvMat H1, CvMat H2);



/* stereo correspondence parameters and functions */

public static final int CV_STEREO_BM_NORMALIZED_RESPONSE =  0;
public static final int CV_STEREO_BM_XSOBEL =               1;

/* Block matching algorithm structure */
public static class CvStereoBMState extends AbstractCvStereoBMState {
    static { Loader.load(); }
    /** Default native constructor. */
    public CvStereoBMState() { allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(int)}. */
    public CvStereoBMState(int size) { allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public CvStereoBMState(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(int size);
    @Override public CvStereoBMState position(int position) {
        return (CvStereoBMState)super.position(position);
    }

    // pre-filtering (normalization of input images)
    public native int preFilterType(); public native CvStereoBMState preFilterType(int preFilterType); // =CV_STEREO_BM_NORMALIZED_RESPONSE now
    public native int preFilterSize(); public native CvStereoBMState preFilterSize(int preFilterSize); // averaging window size: ~5x5..21x21
    public native int preFilterCap(); public native CvStereoBMState preFilterCap(int preFilterCap); // the output of pre-filtering is clipped by [-preFilterCap,preFilterCap]

    // correspondence using Sum of Absolute Difference (SAD)
    public native int SADWindowSize(); public native CvStereoBMState SADWindowSize(int SADWindowSize); // ~5x5..21x21
    public native int minDisparity(); public native CvStereoBMState minDisparity(int minDisparity);  // minimum disparity (can be negative)
    public native int numberOfDisparities(); public native CvStereoBMState numberOfDisparities(int numberOfDisparities); // maximum disparity - minimum disparity (> 0)

    // post-filtering
    public native int textureThreshold(); public native CvStereoBMState textureThreshold(int textureThreshold);  // the disparity is only computed for pixels
                           // with textured enough neighborhood
    public native int uniquenessRatio(); public native CvStereoBMState uniquenessRatio(int uniquenessRatio);   // accept the computed disparity d* only if
                           // SAD(d) >= SAD(d*)*(1 + uniquenessRatio/100.)
                           // for any d != d*+/-1 within the search range.
    public native int speckleWindowSize(); public native CvStereoBMState speckleWindowSize(int speckleWindowSize); // disparity variation window
    public native int speckleRange(); public native CvStereoBMState speckleRange(int speckleRange); // acceptable range of variation in window

    public native int trySmallerWindows(); public native CvStereoBMState trySmallerWindows(int trySmallerWindows); // if 1, the results may be more accurate,
                           // at the expense of slower processing
    public native @ByRef CvRect roi1(); public native CvStereoBMState roi1(CvRect roi1);
    public native @ByRef CvRect roi2(); public native CvStereoBMState roi2(CvRect roi2);
    public native int disp12MaxDiff(); public native CvStereoBMState disp12MaxDiff(int disp12MaxDiff);

    // temporary buffers
    public native CvMat preFilteredImg0(); public native CvStereoBMState preFilteredImg0(CvMat preFilteredImg0);
    public native CvMat preFilteredImg1(); public native CvStereoBMState preFilteredImg1(CvMat preFilteredImg1);
    public native CvMat slidingSumBuf(); public native CvStereoBMState slidingSumBuf(CvMat slidingSumBuf);
    public native CvMat cost(); public native CvStereoBMState cost(CvMat cost);
    public native CvMat disp(); public native CvStereoBMState disp(CvMat disp);
}

public static final int CV_STEREO_BM_BASIC = 0;
public static final int CV_STEREO_BM_FISH_EYE = 1;
public static final int CV_STEREO_BM_NARROW = 2;

public static native CvStereoBMState cvCreateStereoBMState(int preset/*=CV_STEREO_BM_BASIC*/,
                                              int numberOfDisparities/*=0*/);
public static native CvStereoBMState cvCreateStereoBMState();

public static native void cvReleaseStereoBMState( @Cast("CvStereoBMState**") PointerPointer state );
public static native void cvReleaseStereoBMState( @ByPtrPtr CvStereoBMState state );

public static native void cvFindStereoCorrespondenceBM( @Const CvArr left, @Const CvArr right,
                                          CvArr disparity, CvStereoBMState state );

public static native @ByVal CvRect cvGetValidDisparityROI( @ByVal CvRect roi1, @ByVal CvRect roi2, int minDisparity,
                                      int numberOfDisparities, int SADWindowSize );

public static native void cvValidateDisparity( CvArr disparity, @Const CvArr cost,
                                 int minDisparity, int numberOfDisparities,
                                 int disp12MaxDiff/*=1*/ );
public static native void cvValidateDisparity( CvArr disparity, @Const CvArr cost,
                                 int minDisparity, int numberOfDisparities );

/* Reprojects the computed disparity image to the 3D space using the specified 4x4 matrix */
public static native void cvReprojectImageTo3D( @Const CvArr disparityImage,
                                   CvArr _3dImage, @Const CvMat Q,
                                   int handleMissingValues/*=0*/ );
public static native void cvReprojectImageTo3D( @Const CvArr disparityImage,
                                   CvArr _3dImage, @Const CvMat Q );

/** @} calib3d_c */

// #ifdef __cplusplus // extern "C"

//////////////////////////////////////////////////////////////////////////////////////////
@NoOffset public static class CvLevMarq extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public CvLevMarq(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(int)}. */
    public CvLevMarq(int size) { allocateArray(size); }
    private native void allocateArray(int size);
    @Override public CvLevMarq position(int position) {
        return (CvLevMarq)super.position(position);
    }

    public CvLevMarq() { allocate(); }
    private native void allocate();
    public CvLevMarq( int nparams, int nerrs, @ByVal(nullValue = "cvTermCriteria(CV_TERMCRIT_EPS+CV_TERMCRIT_ITER,30,DBL_EPSILON)") CvTermCriteria criteria/*=cvTermCriteria(CV_TERMCRIT_EPS+CV_TERMCRIT_ITER,30,DBL_EPSILON)*/,
                  @Cast("bool") boolean completeSymmFlag/*=false*/ ) { allocate(nparams, nerrs, criteria, completeSymmFlag); }
    private native void allocate( int nparams, int nerrs, @ByVal(nullValue = "cvTermCriteria(CV_TERMCRIT_EPS+CV_TERMCRIT_ITER,30,DBL_EPSILON)") CvTermCriteria criteria/*=cvTermCriteria(CV_TERMCRIT_EPS+CV_TERMCRIT_ITER,30,DBL_EPSILON)*/,
                  @Cast("bool") boolean completeSymmFlag/*=false*/ );
    public CvLevMarq( int nparams, int nerrs ) { allocate(nparams, nerrs); }
    private native void allocate( int nparams, int nerrs );
    public native void init( int nparams, int nerrs, @ByVal(nullValue = "cvTermCriteria(CV_TERMCRIT_EPS+CV_TERMCRIT_ITER,30,DBL_EPSILON)") CvTermCriteria criteria/*=cvTermCriteria(CV_TERMCRIT_EPS+CV_TERMCRIT_ITER,30,DBL_EPSILON)*/,
                  @Cast("bool") boolean completeSymmFlag/*=false*/ );
    public native void init( int nparams, int nerrs );
    public native @Cast("bool") boolean update( @Const @ByPtrRef CvMat param, @ByPtrRef CvMat J, @ByPtrRef CvMat err );
    public native @Cast("bool") boolean updateAlt( @Const @ByPtrRef CvMat param, @ByPtrRef CvMat JtJ, @ByPtrRef CvMat JtErr, @ByPtrRef DoublePointer errNorm );
    public native @Cast("bool") boolean updateAlt( @Const @ByPtrRef CvMat param, @ByPtrRef CvMat JtJ, @ByPtrRef CvMat JtErr, @ByPtrRef DoubleBuffer errNorm );
    public native @Cast("bool") boolean updateAlt( @Const @ByPtrRef CvMat param, @ByPtrRef CvMat JtJ, @ByPtrRef CvMat JtErr, @ByPtrRef double[] errNorm );

    public native void clear();
    public native void step();
    /** enum CvLevMarq:: */
    public static final int DONE= 0, STARTED= 1, CALC_J= 2, CHECK_ERR= 3;

    public native @Ptr CvMat mask(); public native CvLevMarq mask(CvMat mask);
    public native @Ptr CvMat prevParam(); public native CvLevMarq prevParam(CvMat prevParam);
    public native @Ptr CvMat param(); public native CvLevMarq param(CvMat param);
    public native @Ptr CvMat J(); public native CvLevMarq J(CvMat J);
    public native @Ptr CvMat err(); public native CvLevMarq err(CvMat err);
    public native @Ptr CvMat JtJ(); public native CvLevMarq JtJ(CvMat JtJ);
    public native @Ptr CvMat JtJN(); public native CvLevMarq JtJN(CvMat JtJN);
    public native @Ptr CvMat JtErr(); public native CvLevMarq JtErr(CvMat JtErr);
    public native @Ptr CvMat JtJV(); public native CvLevMarq JtJV(CvMat JtJV);
    public native @Ptr CvMat JtJW(); public native CvLevMarq JtJW(CvMat JtJW);
    public native double prevErrNorm(); public native CvLevMarq prevErrNorm(double prevErrNorm);
    public native double errNorm(); public native CvLevMarq errNorm(double errNorm);
    public native int lambdaLg10(); public native CvLevMarq lambdaLg10(int lambdaLg10);
    public native @ByRef CvTermCriteria criteria(); public native CvLevMarq criteria(CvTermCriteria criteria);
    public native int state(); public native CvLevMarq state(int state);
    public native int iters(); public native CvLevMarq iters(int iters);
    public native @Cast("bool") boolean completeSymmFlag(); public native CvLevMarq completeSymmFlag(boolean completeSymmFlag);
}

// #endif

// #endif /* __OPENCV_CALIB3D_C_H__ */


// Parsed from <opencv2/calib3d.hpp>

/*M///////////////////////////////////////////////////////////////////////////////////////
//
//  IMPORTANT: READ BEFORE DOWNLOADING, COPYING, INSTALLING OR USING.
//
//  By downloading, copying, installing or using the software you agree to this license.
//  If you do not agree to this license, do not download, install,
//  copy or use the software.
//
//
//                          License Agreement
//                For Open Source Computer Vision Library
//
// Copyright (C) 2000-2008, Intel Corporation, all rights reserved.
// Copyright (C) 2009, Willow Garage Inc., all rights reserved.
// Copyright (C) 2013, OpenCV Foundation, all rights reserved.
// Third party copyrights are property of their respective owners.
//
// Redistribution and use in source and binary forms, with or without modification,
// are permitted provided that the following conditions are met:
//
//   * Redistribution's of source code must retain the above copyright notice,
//     this list of conditions and the following disclaimer.
//
//   * Redistribution's in binary form must reproduce the above copyright notice,
//     this list of conditions and the following disclaimer in the documentation
//     and/or other materials provided with the distribution.
//
//   * The name of the copyright holders may not be used to endorse or promote products
//     derived from this software without specific prior written permission.
//
// This software is provided by the copyright holders and contributors "as is" and
// any express or implied warranties, including, but not limited to, the implied
// warranties of merchantability and fitness for a particular purpose are disclaimed.
// In no event shall the Intel Corporation or contributors be liable for any direct,
// indirect, incidental, special, exemplary, or consequential damages
// (including, but not limited to, procurement of substitute goods or services;
// loss of use, data, or profits; or business interruption) however caused
// and on any theory of liability, whether in contract, strict liability,
// or tort (including negligence or otherwise) arising in any way out of
// the use of this software, even if advised of the possibility of such damage.
//
//M*/

// #ifndef __OPENCV_CALIB3D_HPP__
// #define __OPENCV_CALIB3D_HPP__

// #include "opencv2/core.hpp"
// #include "opencv2/features2d.hpp"
// #include "opencv2/core/affine.hpp"

/**
  @defgroup calib3d Camera Calibration and 3D Reconstruction

The functions in this section use a so-called pinhole camera model. In this model, a scene view is
formed by projecting 3D points into the image plane using a perspective transformation.

\f[s  \; m' = A [R|t] M'\f]

or

\f[s  \vecthree{u}{v}{1} = \vecthreethree{f_x}{0}{c_x}{0}{f_y}{c_y}{0}{0}{1}
\begin{bmatrix}
r_{11} & r_{12} & r_{13} & t_1  \\
r_{21} & r_{22} & r_{23} & t_2  \\
r_{31} & r_{32} & r_{33} & t_3
\end{bmatrix}
\begin{bmatrix}
X \\
Y \\
Z \\
1
\end{bmatrix}\f]

where:

-   \f$(X, Y, Z)\f$ are the coordinates of a 3D point in the world coordinate space
-   \f$(u, v)\f$ are the coordinates of the projection point in pixels
-   \f$A\f$ is a camera matrix, or a matrix of intrinsic parameters
-   \f$(cx, cy)\f$ is a principal point that is usually at the image center
-   \f$fx, fy\f$ are the focal lengths expressed in pixel units.

Thus, if an image from the camera is scaled by a factor, all of these parameters should be scaled
(multiplied/divided, respectively) by the same factor. The matrix of intrinsic parameters does not
depend on the scene viewed. So, once estimated, it can be re-used as long as the focal length is
fixed (in case of zoom lens). The joint rotation-translation matrix \f$[R|t]\f$ is called a matrix of
extrinsic parameters. It is used to describe the camera motion around a static scene, or vice versa,
rigid motion of an object in front of a still camera. That is, \f$[R|t]\f$ translates coordinates of a
point \f$(X, Y, Z)\f$ to a coordinate system, fixed with respect to the camera. The transformation above
is equivalent to the following (when \f$z \ne 0\f$ ):

\f[\begin{array}{l}
\vecthree{x}{y}{z} = R  \vecthree{X}{Y}{Z} + t \\
x' = x/z \\
y' = y/z \\
u = f_x*x' + c_x \\
v = f_y*y' + c_y
\end{array}\f]

Real lenses usually have some distortion, mostly radial distortion and slight tangential distortion.
So, the above model is extended as:

\f[\begin{array}{l} \vecthree{x}{y}{z} = R  \vecthree{X}{Y}{Z} + t \\ x' = x/z \\ y' = y/z \\ x'' = x'  \frac{1 + k_1 r^2 + k_2 r^4 + k_3 r^6}{1 + k_4 r^2 + k_5 r^4 + k_6 r^6} + 2 p_1 x' y' + p_2(r^2 + 2 x'^2) + s_1 r^2 + s_2 r^4 \\ y'' = y'  \frac{1 + k_1 r^2 + k_2 r^4 + k_3 r^6}{1 + k_4 r^2 + k_5 r^4 + k_6 r^6} + p_1 (r^2 + 2 y'^2) + 2 p_2 x' y' + s_1 r^2 + s_2 r^4 \\ \text{where} \quad r^2 = x'^2 + y'^2  \\ u = f_x*x'' + c_x \\ v = f_y*y'' + c_y \end{array}\f]

\f$k_1\f$, \f$k_2\f$, \f$k_3\f$, \f$k_4\f$, \f$k_5\f$, and \f$k_6\f$ are radial distortion coefficients. \f$p_1\f$ and \f$p_2\f$ are
tangential distortion coefficients. \f$s_1\f$, \f$s_2\f$, \f$s_3\f$, and \f$s_4\f$, are the thin prism distortion
coefficients. Higher-order coefficients are not considered in OpenCV. In the functions below the
coefficients are passed or returned as

\f[(k_1, k_2, p_1, p_2[, k_3[, k_4, k_5, k_6],[s_1, s_2, s_3, s_4]])\f]

vector. That is, if the vector contains four elements, it means that \f$k_3=0\f$ . The distortion
coefficients do not depend on the scene viewed. Thus, they also belong to the intrinsic camera
parameters. And they remain the same regardless of the captured image resolution. If, for example, a
camera has been calibrated on images of 320 x 240 resolution, absolutely the same distortion
coefficients can be used for 640 x 480 images from the same camera while \f$f_x\f$, \f$f_y\f$, \f$c_x\f$, and
\f$c_y\f$ need to be scaled appropriately.

The functions below use the above model to do the following:

-   Project 3D points to the image plane given intrinsic and extrinsic parameters.
-   Compute extrinsic parameters given intrinsic parameters, a few 3D points, and their
projections.
-   Estimate intrinsic and extrinsic camera parameters from several views of a known calibration
pattern (every view is described by several 3D-2D point correspondences).
-   Estimate the relative position and orientation of the stereo camera "heads" and compute the
*rectification* transformation that makes the camera optical axes parallel.

@note
   -   A calibration sample for 3 cameras in horizontal position can be found at
        opencv_source_code/samples/cpp/3calibration.cpp
    -   A calibration sample based on a sequence of images can be found at
        opencv_source_code/samples/cpp/calibration.cpp
    -   A calibration sample in order to do 3D reconstruction can be found at
        opencv_source_code/samples/cpp/build3dmodel.cpp
    -   A calibration sample of an artificially generated camera and chessboard patterns can be
        found at opencv_source_code/samples/cpp/calibration_artificial.cpp
    -   A calibration example on stereo calibration can be found at
        opencv_source_code/samples/cpp/stereo_calib.cpp
    -   A calibration example on stereo matching can be found at
        opencv_source_code/samples/cpp/stereo_match.cpp
    -   (Python) A camera calibration sample can be found at
        opencv_source_code/samples/python2/calibrate.py

  @{
    @defgroup calib3d_fisheye Fisheye camera model

    Definitions: Let P be a point in 3D of coordinates X in the world reference frame (stored in the
    matrix X) The coordinate vector of P in the camera reference frame is:

    \f[Xc = R X + T\f]

    where R is the rotation matrix corresponding to the rotation vector om: R = rodrigues(om); call x, y
    and z the 3 coordinates of Xc:

    \f[x = Xc_1 \\ y = Xc_2 \\ z = Xc_3\f]

    The pinehole projection coordinates of P is [a; b] where

    \f[a = x / z \ and \ b = y / z \\ r^2 = a^2 + b^2 \\ \theta = atan(r)\f]

    Fisheye distortion:

    \f[\theta_d = \theta (1 + k_1 \theta^2 + k_2 \theta^4 + k_3 \theta^6 + k_4 \theta^8)\f]

    The distorted point coordinates are [x'; y'] where

    \f[x' = (\theta_d / r) x \\ y' = (\theta_d / r) y \f]

    Finally, conversion into pixel coordinates: The final pixel coordinates vector [u; v] where:

    \f[u = f_x (x' + \alpha y') + c_x \\
    v = f_y yy + c_y\f]

    @defgroup calib3d_c C API

  @}
 */

/** @addtogroup calib3d
 *  @{

 *  type of the robust estimation algorithm */
/** enum cv:: */
public static final int /** least-median algorithm */
 LMEDS  = 4,
       /** RANSAC algorithm */
       RANSAC = 8,
       /** RHO algorithm */
       RHO    = 16;

/** enum cv:: */
public static final int SOLVEPNP_ITERATIVE = 0,
       SOLVEPNP_EPNP      = 1, // F.Moreno-Noguer, V.Lepetit and P.Fua "EPnP: Efficient Perspective-n-Point Camera Pose Estimation"
       SOLVEPNP_P3P       = 2, // X.S. Gao, X.-R. Hou, J. Tang, H.-F. Chang; "Complete Solution Classification for the Perspective-Three-Point Problem"
       SOLVEPNP_DLS       = 3, // Joel A. Hesch and Stergios I. Roumeliotis. "A Direct Least-Squares (DLS) Method for PnP"
       SOLVEPNP_UPNP      = 4;  // A.Penate-Sanchez, J.Andrade-Cetto, F.Moreno-Noguer. "Exhaustive Linearization for Robust Camera Pose and Focal Length Estimation"

/** enum cv:: */
public static final int CALIB_CB_ADAPTIVE_THRESH = 1,
       CALIB_CB_NORMALIZE_IMAGE = 2,
       CALIB_CB_FILTER_QUADS    = 4,
       CALIB_CB_FAST_CHECK      = 8;

/** enum cv:: */
public static final int CALIB_CB_SYMMETRIC_GRID  = 1,
       CALIB_CB_ASYMMETRIC_GRID = 2,
       CALIB_CB_CLUSTERING      = 4;

/** enum cv:: */
public static final int CALIB_USE_INTRINSIC_GUESS =  0x00001,
       CALIB_FIX_ASPECT_RATIO    =  0x00002,
       CALIB_FIX_PRINCIPAL_POINT =  0x00004,
       CALIB_ZERO_TANGENT_DIST   =  0x00008,
       CALIB_FIX_FOCAL_LENGTH    =  0x00010,
       CALIB_FIX_K1              =  0x00020,
       CALIB_FIX_K2              =  0x00040,
       CALIB_FIX_K3              =  0x00080,
       CALIB_FIX_K4              =  0x00800,
       CALIB_FIX_K5              =  0x01000,
       CALIB_FIX_K6              =  0x02000,
       CALIB_RATIONAL_MODEL      =  0x04000,
       CALIB_THIN_PRISM_MODEL    =  0x08000,
       CALIB_FIX_S1_S2_S3_S4     =  0x10000,
       // only for stereo
       CALIB_FIX_INTRINSIC       =  0x00100,
       CALIB_SAME_FOCAL_LENGTH   =  0x00200,
       // for stereo rectification
       CALIB_ZERO_DISPARITY      =  0x00400;

/** the algorithm for finding fundamental matrix */
/** enum cv:: */
public static final int /** 7-point algorithm */
 FM_7POINT = 1,
       /** 8-point algorithm */
       FM_8POINT = 2,
       /** least-median algorithm */
       FM_LMEDS  = 4,
       /** RANSAC algorithm */
       FM_RANSAC = 8;



/** @brief Converts a rotation matrix to a rotation vector or vice versa.

@param src Input rotation vector (3x1 or 1x3) or rotation matrix (3x3).
@param dst Output rotation matrix (3x3) or rotation vector (3x1 or 1x3), respectively.
@param jacobian Optional output Jacobian matrix, 3x9 or 9x3, which is a matrix of partial
derivatives of the output array components with respect to the input array components.

\f[\begin{array}{l} \theta \leftarrow norm(r) \\ r  \leftarrow r/ \theta \\ R =  \cos{\theta} I + (1- \cos{\theta} ) r r^T +  \sin{\theta} \vecthreethree{0}{-r_z}{r_y}{r_z}{0}{-r_x}{-r_y}{r_x}{0} \end{array}\f]

Inverse transformation can be also done easily, since

\f[\sin ( \theta ) \vecthreethree{0}{-r_z}{r_y}{r_z}{0}{-r_x}{-r_y}{r_x}{0} = \frac{R - R^T}{2}\f]

A rotation vector is a convenient and most compact representation of a rotation matrix (since any
rotation matrix has just 3 degrees of freedom). The representation is used in the global 3D geometry
optimization procedures like calibrateCamera, stereoCalibrate, or solvePnP .
 */
@Namespace("cv") public static native void Rodrigues( @ByVal Mat src, @ByVal Mat dst, @ByVal(nullValue = "cv::noArray()") Mat jacobian/*=cv::noArray()*/ );
@Namespace("cv") public static native void Rodrigues( @ByVal Mat src, @ByVal Mat dst );

/** @brief Finds a perspective transformation between two planes.

@param srcPoints Coordinates of the points in the original plane, a matrix of the type CV_32FC2
or vector\<Point2f\> .
@param dstPoints Coordinates of the points in the target plane, a matrix of the type CV_32FC2 or
a vector\<Point2f\> .
@param method Method used to computed a homography matrix. The following methods are possible:
-   **0** - a regular method using all the points
-   **RANSAC** - RANSAC-based robust method
-   **LMEDS** - Least-Median robust method
-   **RHO**    - PROSAC-based robust method
@param ransacReprojThreshold Maximum allowed reprojection error to treat a point pair as an inlier
(used in the RANSAC and RHO methods only). That is, if
\f[\| \texttt{dstPoints} _i -  \texttt{convertPointsHomogeneous} ( \texttt{H} * \texttt{srcPoints} _i) \|  >  \texttt{ransacReprojThreshold}\f]
then the point \f$i\f$ is considered an outlier. If srcPoints and dstPoints are measured in pixels,
it usually makes sense to set this parameter somewhere in the range of 1 to 10.
@param mask Optional output mask set by a robust method ( RANSAC or LMEDS ). Note that the input
mask values are ignored.
@param maxIters The maximum number of RANSAC iterations, 2000 is the maximum it can be.
@param confidence Confidence level, between 0 and 1.

The functions find and return the perspective transformation \f$H\f$ between the source and the
destination planes:

\f[s_i  \vecthree{x'_i}{y'_i}{1} \sim H  \vecthree{x_i}{y_i}{1}\f]

so that the back-projection error

\f[\sum _i \left ( x'_i- \frac{h_{11} x_i + h_{12} y_i + h_{13}}{h_{31} x_i + h_{32} y_i + h_{33}} \right )^2+ \left ( y'_i- \frac{h_{21} x_i + h_{22} y_i + h_{23}}{h_{31} x_i + h_{32} y_i + h_{33}} \right )^2\f]

is minimized. If the parameter method is set to the default value 0, the function uses all the point
pairs to compute an initial homography estimate with a simple least-squares scheme.

However, if not all of the point pairs ( \f$srcPoints_i\f$, \f$dstPoints_i\f$ ) fit the rigid perspective
transformation (that is, there are some outliers), this initial estimate will be poor. In this case,
you can use one of the three robust methods. The methods RANSAC, LMeDS and RHO try many different
random subsets of the corresponding point pairs (of four pairs each), estimate the homography matrix
using this subset and a simple least-square algorithm, and then compute the quality/goodness of the
computed homography (which is the number of inliers for RANSAC or the median re-projection error for
LMeDs). The best subset is then used to produce the initial estimate of the homography matrix and
the mask of inliers/outliers.

Regardless of the method, robust or not, the computed homography matrix is refined further (using
inliers only in case of a robust method) with the Levenberg-Marquardt method to reduce the
re-projection error even more.

The methods RANSAC and RHO can handle practically any ratio of outliers but need a threshold to
distinguish inliers from outliers. The method LMeDS does not need any threshold but it works
correctly only when there are more than 50% of inliers. Finally, if there are no outliers and the
noise is rather small, use the default method (method=0).

The function is used to find initial intrinsic and extrinsic matrices. Homography matrix is
determined up to a scale. Thus, it is normalized so that \f$h_{33}=1\f$. Note that whenever an H matrix
cannot be estimated, an empty one will be returned.

@sa
   getAffineTransform, getPerspectiveTransform, estimateRigidTransform, warpPerspective,
    perspectiveTransform

@note
   -   A example on calculating a homography for image matching can be found at
        opencv_source_code/samples/cpp/video_homography.cpp

 */
@Namespace("cv") public static native @ByVal Mat findHomography( @ByVal Mat srcPoints, @ByVal Mat dstPoints,
                                 int method/*=0*/, double ransacReprojThreshold/*=3*/,
                                 @ByVal(nullValue = "cv::noArray()") Mat mask/*=cv::noArray()*/, int maxIters/*=2000*/,
                                 double confidence/*=0.995*/);
@Namespace("cv") public static native @ByVal Mat findHomography( @ByVal Mat srcPoints, @ByVal Mat dstPoints);

/** @overload */
@Namespace("cv") public static native @ByVal Mat findHomography( @ByVal Mat srcPoints, @ByVal Mat dstPoints,
                               @ByVal Mat mask, int method/*=0*/, double ransacReprojThreshold/*=3*/ );
@Namespace("cv") public static native @ByVal Mat findHomography( @ByVal Mat srcPoints, @ByVal Mat dstPoints,
                               @ByVal Mat mask );

/** @brief Computes an RQ decomposition of 3x3 matrices.

@param src 3x3 input matrix.
@param mtxR Output 3x3 upper-triangular matrix.
@param mtxQ Output 3x3 orthogonal matrix.
@param Qx Optional output 3x3 rotation matrix around x-axis.
@param Qy Optional output 3x3 rotation matrix around y-axis.
@param Qz Optional output 3x3 rotation matrix around z-axis.

The function computes a RQ decomposition using the given rotations. This function is used in
decomposeProjectionMatrix to decompose the left 3x3 submatrix of a projection matrix into a camera
and a rotation matrix.

It optionally returns three rotation matrices, one for each axis, and the three Euler angles in
degrees (as the return value) that could be used in OpenGL. Note, there is always more than one
sequence of rotations about the three principle axes that results in the same orientation of an
object, eg. see @cite Slabaugh . Returned tree rotation matrices and corresponding three Euler angules
are only one of the possible solutions.
 */
@Namespace("cv") public static native @ByVal Point3d RQDecomp3x3( @ByVal Mat src, @ByVal Mat mtxR, @ByVal Mat mtxQ,
                                @ByVal(nullValue = "cv::noArray()") Mat Qx/*=cv::noArray()*/,
                                @ByVal(nullValue = "cv::noArray()") Mat Qy/*=cv::noArray()*/,
                                @ByVal(nullValue = "cv::noArray()") Mat Qz/*=cv::noArray()*/);
@Namespace("cv") public static native @ByVal Point3d RQDecomp3x3( @ByVal Mat src, @ByVal Mat mtxR, @ByVal Mat mtxQ);

/** @brief Decomposes a projection matrix into a rotation matrix and a camera matrix.

@param projMatrix 3x4 input projection matrix P.
@param cameraMatrix Output 3x3 camera matrix K.
@param rotMatrix Output 3x3 external rotation matrix R.
@param transVect Output 4x1 translation vector T.
@param rotMatrixX Optional 3x3 rotation matrix around x-axis.
@param rotMatrixY Optional 3x3 rotation matrix around y-axis.
@param rotMatrixZ Optional 3x3 rotation matrix around z-axis.
@param eulerAngles Optional three-element vector containing three Euler angles of rotation in
degrees.

The function computes a decomposition of a projection matrix into a calibration and a rotation
matrix and the position of a camera.

It optionally returns three rotation matrices, one for each axis, and three Euler angles that could
be used in OpenGL. Note, there is always more than one sequence of rotations about the three
principle axes that results in the same orientation of an object, eg. see @cite Slabaugh . Returned
tree rotation matrices and corresponding three Euler angules are only one of the possible solutions.

The function is based on RQDecomp3x3 .
 */
@Namespace("cv") public static native void decomposeProjectionMatrix( @ByVal Mat projMatrix, @ByVal Mat cameraMatrix,
                                             @ByVal Mat rotMatrix, @ByVal Mat transVect,
                                             @ByVal(nullValue = "cv::noArray()") Mat rotMatrixX/*=cv::noArray()*/,
                                             @ByVal(nullValue = "cv::noArray()") Mat rotMatrixY/*=cv::noArray()*/,
                                             @ByVal(nullValue = "cv::noArray()") Mat rotMatrixZ/*=cv::noArray()*/,
                                             @ByVal(nullValue = "cv::noArray()") Mat eulerAngles/*=cv::noArray()*/ );
@Namespace("cv") public static native void decomposeProjectionMatrix( @ByVal Mat projMatrix, @ByVal Mat cameraMatrix,
                                             @ByVal Mat rotMatrix, @ByVal Mat transVect );

/** @brief Computes partial derivatives of the matrix product for each multiplied matrix.

@param A First multiplied matrix.
@param B Second multiplied matrix.
@param dABdA First output derivative matrix d(A\*B)/dA of size
\f$\texttt{A.rows*B.cols} \times {A.rows*A.cols}\f$ .
@param dABdB Second output derivative matrix d(A\*B)/dB of size
\f$\texttt{A.rows*B.cols} \times {B.rows*B.cols}\f$ .

The function computes partial derivatives of the elements of the matrix product \f$A*B\f$ with regard to
the elements of each of the two input matrices. The function is used to compute the Jacobian
matrices in stereoCalibrate but can also be used in any other similar optimization function.
 */
@Namespace("cv") public static native void matMulDeriv( @ByVal Mat A, @ByVal Mat B, @ByVal Mat dABdA, @ByVal Mat dABdB );

/** @brief Combines two rotation-and-shift transformations.

@param rvec1 First rotation vector.
@param tvec1 First translation vector.
@param rvec2 Second rotation vector.
@param tvec2 Second translation vector.
@param rvec3 Output rotation vector of the superposition.
@param tvec3 Output translation vector of the superposition.
@param dr3dr1
@param dr3dt1
@param dr3dr2
@param dr3dt2
@param dt3dr1
@param dt3dt1
@param dt3dr2
@param dt3dt2 Optional output derivatives of rvec3 or tvec3 with regard to rvec1, rvec2, tvec1 and
tvec2, respectively.

The functions compute:

\f[\begin{array}{l} \texttt{rvec3} =  \mathrm{rodrigues} ^{-1} \left ( \mathrm{rodrigues} ( \texttt{rvec2} )  \cdot \mathrm{rodrigues} ( \texttt{rvec1} ) \right )  \\ \texttt{tvec3} =  \mathrm{rodrigues} ( \texttt{rvec2} )  \cdot \texttt{tvec1} +  \texttt{tvec2} \end{array} ,\f]

where \f$\mathrm{rodrigues}\f$ denotes a rotation vector to a rotation matrix transformation, and
\f$\mathrm{rodrigues}^{-1}\f$ denotes the inverse transformation. See Rodrigues for details.

Also, the functions can compute the derivatives of the output vectors with regards to the input
vectors (see matMulDeriv ). The functions are used inside stereoCalibrate but can also be used in
your own code where Levenberg-Marquardt or another gradient-based solver is used to optimize a
function that contains a matrix multiplication.
 */
@Namespace("cv") public static native void composeRT( @ByVal Mat rvec1, @ByVal Mat tvec1,
                             @ByVal Mat rvec2, @ByVal Mat tvec2,
                             @ByVal Mat rvec3, @ByVal Mat tvec3,
                             @ByVal(nullValue = "cv::noArray()") Mat dr3dr1/*=cv::noArray()*/, @ByVal(nullValue = "cv::noArray()") Mat dr3dt1/*=cv::noArray()*/,
                             @ByVal(nullValue = "cv::noArray()") Mat dr3dr2/*=cv::noArray()*/, @ByVal(nullValue = "cv::noArray()") Mat dr3dt2/*=cv::noArray()*/,
                             @ByVal(nullValue = "cv::noArray()") Mat dt3dr1/*=cv::noArray()*/, @ByVal(nullValue = "cv::noArray()") Mat dt3dt1/*=cv::noArray()*/,
                             @ByVal(nullValue = "cv::noArray()") Mat dt3dr2/*=cv::noArray()*/, @ByVal(nullValue = "cv::noArray()") Mat dt3dt2/*=cv::noArray()*/ );
@Namespace("cv") public static native void composeRT( @ByVal Mat rvec1, @ByVal Mat tvec1,
                             @ByVal Mat rvec2, @ByVal Mat tvec2,
                             @ByVal Mat rvec3, @ByVal Mat tvec3 );

/** @brief Projects 3D points to an image plane.

@param objectPoints Array of object points, 3xN/Nx3 1-channel or 1xN/Nx1 3-channel (or
vector\<Point3f\> ), where N is the number of points in the view.
@param rvec Rotation vector. See Rodrigues for details.
@param tvec Translation vector.
@param cameraMatrix Camera matrix \f$A = \vecthreethree{f_x}{0}{c_x}{0}{f_y}{c_y}{0}{0}{_1}\f$ .
@param distCoeffs Input vector of distortion coefficients
\f$(k_1, k_2, p_1, p_2[, k_3[, k_4, k_5, k_6],[s_1, s_2, s_3, s_4]])\f$ of 4, 5, 8 or 12 elements. If
the vector is NULL/empty, the zero distortion coefficients are assumed.
@param imagePoints Output array of image points, 2xN/Nx2 1-channel or 1xN/Nx1 2-channel, or
vector\<Point2f\> .
@param jacobian Optional output 2Nx(10+\<numDistCoeffs\>) jacobian matrix of derivatives of image
points with respect to components of the rotation vector, translation vector, focal lengths,
coordinates of the principal point and the distortion coefficients. In the old interface different
components of the jacobian are returned via different output parameters.
@param aspectRatio Optional "fixed aspect ratio" parameter. If the parameter is not 0, the
function assumes that the aspect ratio (*fx/fy*) is fixed and correspondingly adjusts the jacobian
matrix.

The function computes projections of 3D points to the image plane given intrinsic and extrinsic
camera parameters. Optionally, the function computes Jacobians - matrices of partial derivatives of
image points coordinates (as functions of all the input parameters) with respect to the particular
parameters, intrinsic and/or extrinsic. The Jacobians are used during the global optimization in
calibrateCamera, solvePnP, and stereoCalibrate . The function itself can also be used to compute a
re-projection error given the current intrinsic and extrinsic parameters.

@note By setting rvec=tvec=(0,0,0) or by setting cameraMatrix to a 3x3 identity matrix, or by
passing zero distortion coefficients, you can get various useful partial cases of the function. This
means that you can compute the distorted coordinates for a sparse set of points or apply a
perspective transformation (and also compute the derivatives) in the ideal zero-distortion setup.
 */
@Namespace("cv") public static native void projectPoints( @ByVal Mat objectPoints,
                                 @ByVal Mat rvec, @ByVal Mat tvec,
                                 @ByVal Mat cameraMatrix, @ByVal Mat distCoeffs,
                                 @ByVal Mat imagePoints,
                                 @ByVal(nullValue = "cv::noArray()") Mat jacobian/*=cv::noArray()*/,
                                 double aspectRatio/*=0*/ );
@Namespace("cv") public static native void projectPoints( @ByVal Mat objectPoints,
                                 @ByVal Mat rvec, @ByVal Mat tvec,
                                 @ByVal Mat cameraMatrix, @ByVal Mat distCoeffs,
                                 @ByVal Mat imagePoints );

/** @brief Finds an object pose from 3D-2D point correspondences.

@param objectPoints Array of object points in the object coordinate space, 3xN/Nx3 1-channel or
1xN/Nx1 3-channel, where N is the number of points. vector\<Point3f\> can be also passed here.
@param imagePoints Array of corresponding image points, 2xN/Nx2 1-channel or 1xN/Nx1 2-channel,
where N is the number of points. vector\<Point2f\> can be also passed here.
@param cameraMatrix Input camera matrix \f$A = \vecthreethree{fx}{0}{cx}{0}{fy}{cy}{0}{0}{1}\f$ .
@param distCoeffs Input vector of distortion coefficients
\f$(k_1, k_2, p_1, p_2[, k_3[, k_4, k_5, k_6],[s_1, s_2, s_3, s_4]])\f$ of 4, 5, 8 or 12 elements. If
the vector is NULL/empty, the zero distortion coefficients are assumed.
@param rvec Output rotation vector (see Rodrigues ) that, together with tvec , brings points from
the model coordinate system to the camera coordinate system.
@param tvec Output translation vector.
@param useExtrinsicGuess Parameter used for SOLVEPNP_ITERATIVE. If true (1), the function uses
the provided rvec and tvec values as initial approximations of the rotation and translation
vectors, respectively, and further optimizes them.
@param flags Method for solving a PnP problem:
-   **SOLVEPNP_ITERATIVE** Iterative method is based on Levenberg-Marquardt optimization. In
this case the function finds such a pose that minimizes reprojection error, that is the sum
of squared distances between the observed projections imagePoints and the projected (using
projectPoints ) objectPoints .
-   **SOLVEPNP_P3P** Method is based on the paper of X.S. Gao, X.-R. Hou, J. Tang, H.-F. Chang
"Complete Solution Classification for the Perspective-Three-Point Problem". In this case the
function requires exactly four object and image points.
-   **SOLVEPNP_EPNP** Method has been introduced by F.Moreno-Noguer, V.Lepetit and P.Fua in the
paper "EPnP: Efficient Perspective-n-Point Camera Pose Estimation".
-   **SOLVEPNP_DLS** Method is based on the paper of Joel A. Hesch and Stergios I. Roumeliotis.
"A Direct Least-Squares (DLS) Method for PnP".
-   **SOLVEPNP_UPNP** Method is based on the paper of A.Penate-Sanchez, J.Andrade-Cetto,
F.Moreno-Noguer. "Exhaustive Linearization for Robust Camera Pose and Focal Length
Estimation". In this case the function also estimates the parameters \f$f_x\f$ and \f$f_y\f$
assuming that both have the same value. Then the cameraMatrix is updated with the estimated
focal length.

The function estimates the object pose given a set of object points, their corresponding image
projections, as well as the camera matrix and the distortion coefficients.

@note
   -   An example of how to use solvePnP for planar augmented reality can be found at
        opencv_source_code/samples/python2/plane_ar.py
   -   If you are using Python:
        - Numpy array slices won't work as input because solvePnP requires contiguous
        arrays (enforced by the assertion using cv::Mat::checkVector() around line 55 of
        modules/calib3d/src/solvepnp.cpp version 2.4.9)
        - The P3P algorithm requires image points to be in an array of shape (N,1,2) due
        to its calling of cv::undistortPoints (around line 75 of modules/calib3d/src/solvepnp.cpp version 2.4.9)
        which requires 2-channel information.
        - Thus, given some data D = np.array(...) where D.shape = (N,M), in order to use a subset of
        it as, e.g., imagePoints, one must effectively copy it into a new array: imagePoints =
        np.ascontiguousarray(D[:,:2]).reshape((N,1,2))
 */
@Namespace("cv") public static native @Cast("bool") boolean solvePnP( @ByVal Mat objectPoints, @ByVal Mat imagePoints,
                            @ByVal Mat cameraMatrix, @ByVal Mat distCoeffs,
                            @ByVal Mat rvec, @ByVal Mat tvec,
                            @Cast("bool") boolean useExtrinsicGuess/*=false*/, int flags/*=cv::SOLVEPNP_ITERATIVE*/ );
@Namespace("cv") public static native @Cast("bool") boolean solvePnP( @ByVal Mat objectPoints, @ByVal Mat imagePoints,
                            @ByVal Mat cameraMatrix, @ByVal Mat distCoeffs,
                            @ByVal Mat rvec, @ByVal Mat tvec );

/** @brief Finds an object pose from 3D-2D point correspondences using the RANSAC scheme.

@param objectPoints Array of object points in the object coordinate space, 3xN/Nx3 1-channel or
1xN/Nx1 3-channel, where N is the number of points. vector\<Point3f\> can be also passed here.
@param imagePoints Array of corresponding image points, 2xN/Nx2 1-channel or 1xN/Nx1 2-channel,
where N is the number of points. vector\<Point2f\> can be also passed here.
@param cameraMatrix Input camera matrix \f$A = \vecthreethree{fx}{0}{cx}{0}{fy}{cy}{0}{0}{1}\f$ .
@param distCoeffs Input vector of distortion coefficients
\f$(k_1, k_2, p_1, p_2[, k_3[, k_4, k_5, k_6],[s_1, s_2, s_3, s_4]])\f$ of 4, 5, 8 or 12 elements. If
the vector is NULL/empty, the zero distortion coefficients are assumed.
@param rvec Output rotation vector (see Rodrigues ) that, together with tvec , brings points from
the model coordinate system to the camera coordinate system.
@param tvec Output translation vector.
@param useExtrinsicGuess Parameter used for SOLVEPNP_ITERATIVE. If true (1), the function uses
the provided rvec and tvec values as initial approximations of the rotation and translation
vectors, respectively, and further optimizes them.
@param iterationsCount Number of iterations.
@param reprojectionError Inlier threshold value used by the RANSAC procedure. The parameter value
is the maximum allowed distance between the observed and computed point projections to consider it
an inlier.
@param confidence The probability that the algorithm produces a useful result.
@param inliers Output vector that contains indices of inliers in objectPoints and imagePoints .
@param flags Method for solving a PnP problem (see solvePnP ).

The function estimates an object pose given a set of object points, their corresponding image
projections, as well as the camera matrix and the distortion coefficients. This function finds such
a pose that minimizes reprojection error, that is, the sum of squared distances between the observed
projections imagePoints and the projected (using projectPoints ) objectPoints. The use of RANSAC
makes the function resistant to outliers.

@note
   -   An example of how to use solvePNPRansac for object detection can be found at
        opencv_source_code/samples/cpp/tutorial_code/calib3d/real_time_pose_estimation/
 */
@Namespace("cv") public static native @Cast("bool") boolean solvePnPRansac( @ByVal Mat objectPoints, @ByVal Mat imagePoints,
                                  @ByVal Mat cameraMatrix, @ByVal Mat distCoeffs,
                                  @ByVal Mat rvec, @ByVal Mat tvec,
                                  @Cast("bool") boolean useExtrinsicGuess/*=false*/, int iterationsCount/*=100*/,
                                  float reprojectionError/*=8.0*/, double confidence/*=0.99*/,
                                  @ByVal(nullValue = "cv::noArray()") Mat inliers/*=cv::noArray()*/, int flags/*=cv::SOLVEPNP_ITERATIVE*/ );
@Namespace("cv") public static native @Cast("bool") boolean solvePnPRansac( @ByVal Mat objectPoints, @ByVal Mat imagePoints,
                                  @ByVal Mat cameraMatrix, @ByVal Mat distCoeffs,
                                  @ByVal Mat rvec, @ByVal Mat tvec );

/** @brief Finds an initial camera matrix from 3D-2D point correspondences.

@param objectPoints Vector of vectors of the calibration pattern points in the calibration pattern
coordinate space. In the old interface all the per-view vectors are concatenated. See
calibrateCamera for details.
@param imagePoints Vector of vectors of the projections of the calibration pattern points. In the
old interface all the per-view vectors are concatenated.
@param imageSize Image size in pixels used to initialize the principal point.
@param aspectRatio If it is zero or negative, both \f$f_x\f$ and \f$f_y\f$ are estimated independently.
Otherwise, \f$f_x = f_y * \texttt{aspectRatio}\f$ .

The function estimates and returns an initial camera matrix for the camera calibration process.
Currently, the function only supports planar calibration patterns, which are patterns where each
object point has z-coordinate =0.
 */
@Namespace("cv") public static native @ByVal Mat initCameraMatrix2D( @ByVal MatVector objectPoints,
                                     @ByVal MatVector imagePoints,
                                     @ByVal Size imageSize, double aspectRatio/*=1.0*/ );
@Namespace("cv") public static native @ByVal Mat initCameraMatrix2D( @ByVal MatVector objectPoints,
                                     @ByVal MatVector imagePoints,
                                     @ByVal Size imageSize );

/** @brief Finds the positions of internal corners of the chessboard.

@param image Source chessboard view. It must be an 8-bit grayscale or color image.
@param patternSize Number of inner corners per a chessboard row and column
( patternSize = cvSize(points_per_row,points_per_colum) = cvSize(columns,rows) ).
@param corners Output array of detected corners.
@param flags Various operation flags that can be zero or a combination of the following values:
-   **CV_CALIB_CB_ADAPTIVE_THRESH** Use adaptive thresholding to convert the image to black
and white, rather than a fixed threshold level (computed from the average image brightness).
-   **CV_CALIB_CB_NORMALIZE_IMAGE** Normalize the image gamma with equalizeHist before
applying fixed or adaptive thresholding.
-   **CV_CALIB_CB_FILTER_QUADS** Use additional criteria (like contour area, perimeter,
square-like shape) to filter out false quads extracted at the contour retrieval stage.
-   **CALIB_CB_FAST_CHECK** Run a fast check on the image that looks for chessboard corners,
and shortcut the call if none is found. This can drastically speed up the call in the
degenerate condition when no chessboard is observed.

The function attempts to determine whether the input image is a view of the chessboard pattern and
locate the internal chessboard corners. The function returns a non-zero value if all of the corners
are found and they are placed in a certain order (row by row, left to right in every row).
Otherwise, if the function fails to find all the corners or reorder them, it returns 0. For example,
a regular chessboard has 8 x 8 squares and 7 x 7 internal corners, that is, points where the black
squares touch each other. The detected coordinates are approximate, and to determine their positions
more accurately, the function calls cornerSubPix. You also may use the function cornerSubPix with
different parameters if returned coordinates are not accurate enough.

Sample usage of detecting and drawing chessboard corners: :
@code
    Size patternsize(8,6); //interior number of corners
    Mat gray = ....; //source image
    vector<Point2f> corners; //this will be filled by the detected corners

    //CALIB_CB_FAST_CHECK saves a lot of time on images
    //that do not contain any chessboard corners
    bool patternfound = findChessboardCorners(gray, patternsize, corners,
            CALIB_CB_ADAPTIVE_THRESH + CALIB_CB_NORMALIZE_IMAGE
            + CALIB_CB_FAST_CHECK);

    if(patternfound)
      cornerSubPix(gray, corners, Size(11, 11), Size(-1, -1),
        TermCriteria(CV_TERMCRIT_EPS + CV_TERMCRIT_ITER, 30, 0.1));

    drawChessboardCorners(img, patternsize, Mat(corners), patternfound);
@endcode
@note The function requires white space (like a square-thick border, the wider the better) around
the board to make the detection more robust in various environments. Otherwise, if there is no
border and the background is dark, the outer black squares cannot be segmented properly and so the
square grouping and ordering algorithm fails.
 */
@Namespace("cv") public static native @Cast("bool") boolean findChessboardCorners( @ByVal Mat image, @ByVal Size patternSize, @ByVal Mat corners,
                                         int flags/*=cv::CALIB_CB_ADAPTIVE_THRESH + cv::CALIB_CB_NORMALIZE_IMAGE*/ );
@Namespace("cv") public static native @Cast("bool") boolean findChessboardCorners( @ByVal Mat image, @ByVal Size patternSize, @ByVal Mat corners );

/** finds subpixel-accurate positions of the chessboard corners */
@Namespace("cv") public static native @Cast("bool") boolean find4QuadCornerSubpix( @ByVal Mat img, @ByVal Mat corners, @ByVal Size region_size );

/** @brief Renders the detected chessboard corners.

@param image Destination image. It must be an 8-bit color image.
@param patternSize Number of inner corners per a chessboard row and column
(patternSize = cv::Size(points_per_row,points_per_column)).
@param corners Array of detected corners, the output of findChessboardCorners.
@param patternWasFound Parameter indicating whether the complete board was found or not. The
return value of findChessboardCorners should be passed here.

The function draws individual chessboard corners detected either as red circles if the board was not
found, or as colored corners connected with lines if the board was found.
 */
@Namespace("cv") public static native void drawChessboardCorners( @ByVal Mat image, @ByVal Size patternSize,
                                         @ByVal Mat corners, @Cast("bool") boolean patternWasFound );

/** @brief Finds centers in the grid of circles.

@param image grid view of input circles; it must be an 8-bit grayscale or color image.
@param patternSize number of circles per row and column
( patternSize = Size(points_per_row, points_per_colum) ).
@param centers output array of detected centers.
@param flags various operation flags that can be one of the following values:
-   **CALIB_CB_SYMMETRIC_GRID** uses symmetric pattern of circles.
-   **CALIB_CB_ASYMMETRIC_GRID** uses asymmetric pattern of circles.
-   **CALIB_CB_CLUSTERING** uses a special algorithm for grid detection. It is more robust to
perspective distortions but much more sensitive to background clutter.
@param blobDetector feature detector that finds blobs like dark circles on light background.

The function attempts to determine whether the input image contains a grid of circles. If it is, the
function locates centers of the circles. The function returns a non-zero value if all of the centers
have been found and they have been placed in a certain order (row by row, left to right in every
row). Otherwise, if the function fails to find all the corners or reorder them, it returns 0.

Sample usage of detecting and drawing the centers of circles: :
@code
    Size patternsize(7,7); //number of centers
    Mat gray = ....; //source image
    vector<Point2f> centers; //this will be filled by the detected centers

    bool patternfound = findCirclesGrid(gray, patternsize, centers);

    drawChessboardCorners(img, patternsize, Mat(centers), patternfound);
@endcode
@note The function requires white space (like a square-thick border, the wider the better) around
the board to make the detection more robust in various environments.
 */
@Namespace("cv") public static native @Cast("bool") boolean findCirclesGrid( @ByVal Mat image, @ByVal Size patternSize,
                                   @ByVal Mat centers, int flags/*=cv::CALIB_CB_SYMMETRIC_GRID*/,
                                   @Cast("cv::FeatureDetector*") @Ptr Feature2D blobDetector/*=cv::SimpleBlobDetector::create()*/);
@Namespace("cv") public static native @Cast("bool") boolean findCirclesGrid( @ByVal Mat image, @ByVal Size patternSize,
                                   @ByVal Mat centers);

/** @brief Finds the camera intrinsic and extrinsic parameters from several views of a calibration pattern.

@param objectPoints In the new interface it is a vector of vectors of calibration pattern points in
the calibration pattern coordinate space (e.g. std::vector<std::vector<cv::Vec3f>>). The outer
vector contains as many elements as the number of the pattern views. If the same calibration pattern
is shown in each view and it is fully visible, all the vectors will be the same. Although, it is
possible to use partially occluded patterns, or even different patterns in different views. Then,
the vectors will be different. The points are 3D, but since they are in a pattern coordinate system,
then, if the rig is planar, it may make sense to put the model to a XY coordinate plane so that
Z-coordinate of each input object point is 0.
In the old interface all the vectors of object points from different views are concatenated
together.
@param imagePoints In the new interface it is a vector of vectors of the projections of calibration
pattern points (e.g. std::vector<std::vector<cv::Vec2f>>). imagePoints.size() and
objectPoints.size() and imagePoints[i].size() must be equal to objectPoints[i].size() for each i.
In the old interface all the vectors of object points from different views are concatenated
together.
@param imageSize Size of the image used only to initialize the intrinsic camera matrix.
@param cameraMatrix Output 3x3 floating-point camera matrix
\f$A = \vecthreethree{f_x}{0}{c_x}{0}{f_y}{c_y}{0}{0}{1}\f$ . If CV\_CALIB\_USE\_INTRINSIC\_GUESS
and/or CV_CALIB_FIX_ASPECT_RATIO are specified, some or all of fx, fy, cx, cy must be
initialized before calling the function.
@param distCoeffs Output vector of distortion coefficients
\f$(k_1, k_2, p_1, p_2[, k_3[, k_4, k_5, k_6],[s_1, s_2, s_3, s_4]])\f$ of 4, 5, 8 or 12 elements.
@param rvecs Output vector of rotation vectors (see Rodrigues ) estimated for each pattern view
(e.g. std::vector<cv::Mat>>). That is, each k-th rotation vector together with the corresponding
k-th translation vector (see the next output parameter description) brings the calibration pattern
from the model coordinate space (in which object points are specified) to the world coordinate
space, that is, a real position of the calibration pattern in the k-th pattern view (k=0.. *M* -1).
@param tvecs Output vector of translation vectors estimated for each pattern view.
@param flags Different flags that may be zero or a combination of the following values:
-   **CV_CALIB_USE_INTRINSIC_GUESS** cameraMatrix contains valid initial values of
fx, fy, cx, cy that are optimized further. Otherwise, (cx, cy) is initially set to the image
center ( imageSize is used), and focal distances are computed in a least-squares fashion.
Note, that if intrinsic parameters are known, there is no need to use this function just to
estimate extrinsic parameters. Use solvePnP instead.
-   **CV_CALIB_FIX_PRINCIPAL_POINT** The principal point is not changed during the global
optimization. It stays at the center or at a different location specified when
CV_CALIB_USE_INTRINSIC_GUESS is set too.
-   **CV_CALIB_FIX_ASPECT_RATIO** The functions considers only fy as a free parameter. The
ratio fx/fy stays the same as in the input cameraMatrix . When
CV_CALIB_USE_INTRINSIC_GUESS is not set, the actual input values of fx and fy are
ignored, only their ratio is computed and used further.
-   **CV_CALIB_ZERO_TANGENT_DIST** Tangential distortion coefficients \f$(p_1, p_2)\f$ are set
to zeros and stay zero.
-   **CV_CALIB_FIX_K1,...,CV_CALIB_FIX_K6** The corresponding radial distortion
coefficient is not changed during the optimization. If CV_CALIB_USE_INTRINSIC_GUESS is
set, the coefficient from the supplied distCoeffs matrix is used. Otherwise, it is set to 0.
-   **CV_CALIB_RATIONAL_MODEL** Coefficients k4, k5, and k6 are enabled. To provide the
backward compatibility, this extra flag should be explicitly specified to make the
calibration function use the rational model and return 8 coefficients. If the flag is not
set, the function computes and returns only 5 distortion coefficients.
-   **CALIB_THIN_PRISM_MODEL** Coefficients s1, s2, s3 and s4 are enabled. To provide the
backward compatibility, this extra flag should be explicitly specified to make the
calibration function use the thin prism model and return 12 coefficients. If the flag is not
set, the function computes and returns only 5 distortion coefficients.
-   **CALIB_FIX_S1_S2_S3_S4** The thin prism distortion coefficients are not changed during
the optimization. If CV_CALIB_USE_INTRINSIC_GUESS is set, the coefficient from the
supplied distCoeffs matrix is used. Otherwise, it is set to 0.
@param criteria Termination criteria for the iterative optimization algorithm.

The function estimates the intrinsic camera parameters and extrinsic parameters for each of the
views. The algorithm is based on @cite Zhang2000 and @cite BouguetMCT . The coordinates of 3D object
points and their corresponding 2D projections in each view must be specified. That may be achieved
by using an object with a known geometry and easily detectable feature points. Such an object is
called a calibration rig or calibration pattern, and OpenCV has built-in support for a chessboard as
a calibration rig (see findChessboardCorners ). Currently, initialization of intrinsic parameters
(when CV_CALIB_USE_INTRINSIC_GUESS is not set) is only implemented for planar calibration
patterns (where Z-coordinates of the object points must be all zeros). 3D calibration rigs can also
be used as long as initial cameraMatrix is provided.

The algorithm performs the following steps:

-   Compute the initial intrinsic parameters (the option only available for planar calibration
    patterns) or read them from the input parameters. The distortion coefficients are all set to
    zeros initially unless some of CV_CALIB_FIX_K? are specified.

-   Estimate the initial camera pose as if the intrinsic parameters have been already known. This is
    done using solvePnP .

-   Run the global Levenberg-Marquardt optimization algorithm to minimize the reprojection error,
    that is, the total sum of squared distances between the observed feature points imagePoints and
    the projected (using the current estimates for camera parameters and the poses) object points
    objectPoints. See projectPoints for details.

The function returns the final re-projection error.

@note
   If you use a non-square (=non-NxN) grid and findChessboardCorners for calibration, and
    calibrateCamera returns bad values (zero distortion coefficients, an image center very far from
    (w/2-0.5,h/2-0.5), and/or large differences between \f$f_x\f$ and \f$f_y\f$ (ratios of 10:1 or more)),
    then you have probably used patternSize=cvSize(rows,cols) instead of using
    patternSize=cvSize(cols,rows) in findChessboardCorners .

@sa
   findChessboardCorners, solvePnP, initCameraMatrix2D, stereoCalibrate, undistort
 */
@Namespace("cv") public static native double calibrateCamera( @ByVal MatVector objectPoints,
                                     @ByVal MatVector imagePoints, @ByVal Size imageSize,
                                     @ByVal Mat cameraMatrix, @ByVal Mat distCoeffs,
                                     @ByVal MatVector rvecs, @ByVal MatVector tvecs,
                                     int flags/*=0*/, @ByVal(nullValue = "cv::TermCriteria("
                                         + "cv::TermCriteria::COUNT + cv::TermCriteria::EPS, 30, DBL_EPSILON)") TermCriteria criteria/*=cv::TermCriteria(
                                        cv::TermCriteria::COUNT + cv::TermCriteria::EPS, 30, DBL_EPSILON)*/ );
@Namespace("cv") public static native double calibrateCamera( @ByVal MatVector objectPoints,
                                     @ByVal MatVector imagePoints, @ByVal Size imageSize,
                                     @ByVal Mat cameraMatrix, @ByVal Mat distCoeffs,
                                     @ByVal MatVector rvecs, @ByVal MatVector tvecs );

/** @brief Computes useful camera characteristics from the camera matrix.

@param cameraMatrix Input camera matrix that can be estimated by calibrateCamera or
stereoCalibrate .
@param imageSize Input image size in pixels.
@param apertureWidth Physical width in mm of the sensor.
@param apertureHeight Physical height in mm of the sensor.
@param fovx Output field of view in degrees along the horizontal sensor axis.
@param fovy Output field of view in degrees along the vertical sensor axis.
@param focalLength Focal length of the lens in mm.
@param principalPoint Principal point in mm.
@param aspectRatio \f$f_y/f_x\f$

The function computes various useful camera characteristics from the previously estimated camera
matrix.

@note
   Do keep in mind that the unity measure 'mm' stands for whatever unit of measure one chooses for
    the chessboard pitch (it can thus be any value).
 */
@Namespace("cv") public static native void calibrationMatrixValues( @ByVal Mat cameraMatrix, @ByVal Size imageSize,
                                           double apertureWidth, double apertureHeight,
                                           @ByRef DoublePointer fovx, @ByRef DoublePointer fovy,
                                           @ByRef DoublePointer focalLength, @ByRef Point2d principalPoint,
                                           @ByRef DoublePointer aspectRatio );
@Namespace("cv") public static native void calibrationMatrixValues( @ByVal Mat cameraMatrix, @ByVal Size imageSize,
                                           double apertureWidth, double apertureHeight,
                                           @ByRef DoubleBuffer fovx, @ByRef DoubleBuffer fovy,
                                           @ByRef DoubleBuffer focalLength, @ByRef Point2d principalPoint,
                                           @ByRef DoubleBuffer aspectRatio );
@Namespace("cv") public static native void calibrationMatrixValues( @ByVal Mat cameraMatrix, @ByVal Size imageSize,
                                           double apertureWidth, double apertureHeight,
                                           @ByRef double[] fovx, @ByRef double[] fovy,
                                           @ByRef double[] focalLength, @ByRef Point2d principalPoint,
                                           @ByRef double[] aspectRatio );

/** @brief Calibrates the stereo camera.

@param objectPoints Vector of vectors of the calibration pattern points.
@param imagePoints1 Vector of vectors of the projections of the calibration pattern points,
observed by the first camera.
@param imagePoints2 Vector of vectors of the projections of the calibration pattern points,
observed by the second camera.
@param cameraMatrix1 Input/output first camera matrix:
\f$\vecthreethree{f_x^{(j)}}{0}{c_x^{(j)}}{0}{f_y^{(j)}}{c_y^{(j)}}{0}{0}{1}\f$ , \f$j = 0,\, 1\f$ . If
any of CV_CALIB_USE_INTRINSIC_GUESS , CV_CALIB_FIX_ASPECT_RATIO ,
CV_CALIB_FIX_INTRINSIC , or CV_CALIB_FIX_FOCAL_LENGTH are specified, some or all of the
matrix components must be initialized. See the flags description for details.
@param distCoeffs1 Input/output vector of distortion coefficients
\f$(k_1, k_2, p_1, p_2[, k_3[, k_4, k_5, k_6],[s_1, s_2, s_3, s_4]])\f$ of 4, 5, 8 ot 12 elements. The
output vector length depends on the flags.
@param cameraMatrix2 Input/output second camera matrix. The parameter is similar to cameraMatrix1
@param distCoeffs2 Input/output lens distortion coefficients for the second camera. The parameter
is similar to distCoeffs1 .
@param imageSize Size of the image used only to initialize intrinsic camera matrix.
@param R Output rotation matrix between the 1st and the 2nd camera coordinate systems.
@param T Output translation vector between the coordinate systems of the cameras.
@param E Output essential matrix.
@param F Output fundamental matrix.
@param flags Different flags that may be zero or a combination of the following values:
-   **CV_CALIB_FIX_INTRINSIC** Fix cameraMatrix? and distCoeffs? so that only R, T, E , and F
matrices are estimated.
-   **CV_CALIB_USE_INTRINSIC_GUESS** Optimize some or all of the intrinsic parameters
according to the specified flags. Initial values are provided by the user.
-   **CV_CALIB_FIX_PRINCIPAL_POINT** Fix the principal points during the optimization.
-   **CV_CALIB_FIX_FOCAL_LENGTH** Fix \f$f^{(j)}_x\f$ and \f$f^{(j)}_y\f$ .
-   **CV_CALIB_FIX_ASPECT_RATIO** Optimize \f$f^{(j)}_y\f$ . Fix the ratio \f$f^{(j)}_x/f^{(j)}_y\f$
.
-   **CV_CALIB_SAME_FOCAL_LENGTH** Enforce \f$f^{(0)}_x=f^{(1)}_x\f$ and \f$f^{(0)}_y=f^{(1)}_y\f$ .
-   **CV_CALIB_ZERO_TANGENT_DIST** Set tangential distortion coefficients for each camera to
zeros and fix there.
-   **CV_CALIB_FIX_K1,...,CV_CALIB_FIX_K6** Do not change the corresponding radial
distortion coefficient during the optimization. If CV_CALIB_USE_INTRINSIC_GUESS is set,
the coefficient from the supplied distCoeffs matrix is used. Otherwise, it is set to 0.
-   **CV_CALIB_RATIONAL_MODEL** Enable coefficients k4, k5, and k6. To provide the backward
compatibility, this extra flag should be explicitly specified to make the calibration
function use the rational model and return 8 coefficients. If the flag is not set, the
function computes and returns only 5 distortion coefficients.
-   **CALIB_THIN_PRISM_MODEL** Coefficients s1, s2, s3 and s4 are enabled. To provide the
backward compatibility, this extra flag should be explicitly specified to make the
calibration function use the thin prism model and return 12 coefficients. If the flag is not
set, the function computes and returns only 5 distortion coefficients.
-   **CALIB_FIX_S1_S2_S3_S4** The thin prism distortion coefficients are not changed during
the optimization. If CV_CALIB_USE_INTRINSIC_GUESS is set, the coefficient from the
supplied distCoeffs matrix is used. Otherwise, it is set to 0.
@param criteria Termination criteria for the iterative optimization algorithm.

The function estimates transformation between two cameras making a stereo pair. If you have a stereo
camera where the relative position and orientation of two cameras is fixed, and if you computed
poses of an object relative to the first camera and to the second camera, (R1, T1) and (R2, T2),
respectively (this can be done with solvePnP ), then those poses definitely relate to each other.
This means that, given ( \f$R_1\f$,\f$T_1\f$ ), it should be possible to compute ( \f$R_2\f$,\f$T_2\f$ ). You only
need to know the position and orientation of the second camera relative to the first camera. This is
what the described function does. It computes ( \f$R\f$,\f$T\f$ ) so that:

\f[R_2=R*R_1
T_2=R*T_1 + T,\f]

Optionally, it computes the essential matrix E:

\f[E= \vecthreethree{0}{-T_2}{T_1}{T_2}{0}{-T_0}{-T_1}{T_0}{0} *R\f]

where \f$T_i\f$ are components of the translation vector \f$T\f$ : \f$T=[T_0, T_1, T_2]^T\f$ . And the function
can also compute the fundamental matrix F:

\f[F = cameraMatrix2^{-T} E cameraMatrix1^{-1}\f]

Besides the stereo-related information, the function can also perform a full calibration of each of
two cameras. However, due to the high dimensionality of the parameter space and noise in the input
data, the function can diverge from the correct solution. If the intrinsic parameters can be
estimated with high accuracy for each of the cameras individually (for example, using
calibrateCamera ), you are recommended to do so and then pass CV_CALIB_FIX_INTRINSIC flag to the
function along with the computed intrinsic parameters. Otherwise, if all the parameters are
estimated at once, it makes sense to restrict some parameters, for example, pass
CV_CALIB_SAME_FOCAL_LENGTH and CV_CALIB_ZERO_TANGENT_DIST flags, which is usually a
reasonable assumption.

Similarly to calibrateCamera , the function minimizes the total re-projection error for all the
points in all the available views from both cameras. The function returns the final value of the
re-projection error.
 */
@Namespace("cv") public static native double stereoCalibrate( @ByVal MatVector objectPoints,
                                     @ByVal MatVector imagePoints1, @ByVal MatVector imagePoints2,
                                     @ByVal Mat cameraMatrix1, @ByVal Mat distCoeffs1,
                                     @ByVal Mat cameraMatrix2, @ByVal Mat distCoeffs2,
                                     @ByVal Size imageSize, @ByVal Mat R,@ByVal Mat T, @ByVal Mat E, @ByVal Mat F,
                                     int flags/*=cv::CALIB_FIX_INTRINSIC*/,
                                     @ByVal(nullValue = "cv::TermCriteria(cv::TermCriteria::COUNT+cv::TermCriteria::EPS, 30, 1e-6)") TermCriteria criteria/*=cv::TermCriteria(cv::TermCriteria::COUNT+cv::TermCriteria::EPS, 30, 1e-6)*/ );
@Namespace("cv") public static native double stereoCalibrate( @ByVal MatVector objectPoints,
                                     @ByVal MatVector imagePoints1, @ByVal MatVector imagePoints2,
                                     @ByVal Mat cameraMatrix1, @ByVal Mat distCoeffs1,
                                     @ByVal Mat cameraMatrix2, @ByVal Mat distCoeffs2,
                                     @ByVal Size imageSize, @ByVal Mat R,@ByVal Mat T, @ByVal Mat E, @ByVal Mat F );


/** @brief Computes rectification transforms for each head of a calibrated stereo camera.

@param cameraMatrix1 First camera matrix.
@param cameraMatrix2 Second camera matrix.
@param distCoeffs1 First camera distortion parameters.
@param distCoeffs2 Second camera distortion parameters.
@param imageSize Size of the image used for stereo calibration.
@param R Rotation matrix between the coordinate systems of the first and the second cameras.
@param T Translation vector between coordinate systems of the cameras.
@param R1 Output 3x3 rectification transform (rotation matrix) for the first camera.
@param R2 Output 3x3 rectification transform (rotation matrix) for the second camera.
@param P1 Output 3x4 projection matrix in the new (rectified) coordinate systems for the first
camera.
@param P2 Output 3x4 projection matrix in the new (rectified) coordinate systems for the second
camera.
@param Q Output \f$4 \times 4\f$ disparity-to-depth mapping matrix (see reprojectImageTo3D ).
@param flags Operation flags that may be zero or CV_CALIB_ZERO_DISPARITY . If the flag is set,
the function makes the principal points of each camera have the same pixel coordinates in the
rectified views. And if the flag is not set, the function may still shift the images in the
horizontal or vertical direction (depending on the orientation of epipolar lines) to maximize the
useful image area.
@param alpha Free scaling parameter. If it is -1 or absent, the function performs the default
scaling. Otherwise, the parameter should be between 0 and 1. alpha=0 means that the rectified
images are zoomed and shifted so that only valid pixels are visible (no black areas after
rectification). alpha=1 means that the rectified image is decimated and shifted so that all the
pixels from the original images from the cameras are retained in the rectified images (no source
image pixels are lost). Obviously, any intermediate value yields an intermediate result between
those two extreme cases.
@param newImageSize New image resolution after rectification. The same size should be passed to
initUndistortRectifyMap (see the stereo_calib.cpp sample in OpenCV samples directory). When (0,0)
is passed (default), it is set to the original imageSize . Setting it to larger value can help you
preserve details in the original image, especially when there is a big radial distortion.
@param validPixROI1 Optional output rectangles inside the rectified images where all the pixels
are valid. If alpha=0 , the ROIs cover the whole images. Otherwise, they are likely to be smaller
(see the picture below).
@param validPixROI2 Optional output rectangles inside the rectified images where all the pixels
are valid. If alpha=0 , the ROIs cover the whole images. Otherwise, they are likely to be smaller
(see the picture below).

The function computes the rotation matrices for each camera that (virtually) make both camera image
planes the same plane. Consequently, this makes all the epipolar lines parallel and thus simplifies
the dense stereo correspondence problem. The function takes the matrices computed by stereoCalibrate
as input. As output, it provides two rotation matrices and also two projection matrices in the new
coordinates. The function distinguishes the following two cases:

-   **Horizontal stereo**: the first and the second camera views are shifted relative to each other
    mainly along the x axis (with possible small vertical shift). In the rectified images, the
    corresponding epipolar lines in the left and right cameras are horizontal and have the same
    y-coordinate. P1 and P2 look like:

    \f[\texttt{P1} = \begin{bmatrix} f & 0 & cx_1 & 0 \\ 0 & f & cy & 0 \\ 0 & 0 & 1 & 0 \end{bmatrix}\f]

    \f[\texttt{P2} = \begin{bmatrix} f & 0 & cx_2 & T_x*f \\ 0 & f & cy & 0 \\ 0 & 0 & 1 & 0 \end{bmatrix} ,\f]

    where \f$T_x\f$ is a horizontal shift between the cameras and \f$cx_1=cx_2\f$ if
    CV_CALIB_ZERO_DISPARITY is set.

-   **Vertical stereo**: the first and the second camera views are shifted relative to each other
    mainly in vertical direction (and probably a bit in the horizontal direction too). The epipolar
    lines in the rectified images are vertical and have the same x-coordinate. P1 and P2 look like:

    \f[\texttt{P1} = \begin{bmatrix} f & 0 & cx & 0 \\ 0 & f & cy_1 & 0 \\ 0 & 0 & 1 & 0 \end{bmatrix}\f]

    \f[\texttt{P2} = \begin{bmatrix} f & 0 & cx & 0 \\ 0 & f & cy_2 & T_y*f \\ 0 & 0 & 1 & 0 \end{bmatrix} ,\f]

    where \f$T_y\f$ is a vertical shift between the cameras and \f$cy_1=cy_2\f$ if CALIB_ZERO_DISPARITY is
    set.

As you can see, the first three columns of P1 and P2 will effectively be the new "rectified" camera
matrices. The matrices, together with R1 and R2 , can then be passed to initUndistortRectifyMap to
initialize the rectification map for each camera.

See below the screenshot from the stereo_calib.cpp sample. Some red horizontal lines pass through
the corresponding image regions. This means that the images are well rectified, which is what most
stereo correspondence algorithms rely on. The green rectangles are roi1 and roi2 . You see that
their interiors are all valid pixels.

![image](pics/stereo_undistort.jpg)
 */
@Namespace("cv") public static native void stereoRectify( @ByVal Mat cameraMatrix1, @ByVal Mat distCoeffs1,
                                 @ByVal Mat cameraMatrix2, @ByVal Mat distCoeffs2,
                                 @ByVal Size imageSize, @ByVal Mat R, @ByVal Mat T,
                                 @ByVal Mat R1, @ByVal Mat R2,
                                 @ByVal Mat P1, @ByVal Mat P2,
                                 @ByVal Mat Q, int flags/*=cv::CALIB_ZERO_DISPARITY*/,
                                 double alpha/*=-1*/, @ByVal(nullValue = "cv::Size()") Size newImageSize/*=cv::Size()*/,
                                 Rect validPixROI1/*=0*/, Rect validPixROI2/*=0*/ );
@Namespace("cv") public static native void stereoRectify( @ByVal Mat cameraMatrix1, @ByVal Mat distCoeffs1,
                                 @ByVal Mat cameraMatrix2, @ByVal Mat distCoeffs2,
                                 @ByVal Size imageSize, @ByVal Mat R, @ByVal Mat T,
                                 @ByVal Mat R1, @ByVal Mat R2,
                                 @ByVal Mat P1, @ByVal Mat P2,
                                 @ByVal Mat Q );

/** @brief Computes a rectification transform for an uncalibrated stereo camera.

@param points1 Array of feature points in the first image.
@param points2 The corresponding points in the second image. The same formats as in
findFundamentalMat are supported.
@param F Input fundamental matrix. It can be computed from the same set of point pairs using
findFundamentalMat .
@param imgSize Size of the image.
@param H1 Output rectification homography matrix for the first image.
@param H2 Output rectification homography matrix for the second image.
@param threshold Optional threshold used to filter out the outliers. If the parameter is greater
than zero, all the point pairs that do not comply with the epipolar geometry (that is, the points
for which \f$|\texttt{points2[i]}^T*\texttt{F}*\texttt{points1[i]}|>\texttt{threshold}\f$ ) are
rejected prior to computing the homographies. Otherwise,all the points are considered inliers.

The function computes the rectification transformations without knowing intrinsic parameters of the
cameras and their relative position in the space, which explains the suffix "uncalibrated". Another
related difference from stereoRectify is that the function outputs not the rectification
transformations in the object (3D) space, but the planar perspective transformations encoded by the
homography matrices H1 and H2 . The function implements the algorithm @cite Hartley99 .

@note
   While the algorithm does not need to know the intrinsic parameters of the cameras, it heavily
    depends on the epipolar geometry. Therefore, if the camera lenses have a significant distortion,
    it would be better to correct it before computing the fundamental matrix and calling this
    function. For example, distortion coefficients can be estimated for each head of stereo camera
    separately by using calibrateCamera . Then, the images can be corrected using undistort , or
    just the point coordinates can be corrected with undistortPoints .
 */
@Namespace("cv") public static native @Cast("bool") boolean stereoRectifyUncalibrated( @ByVal Mat points1, @ByVal Mat points2,
                                             @ByVal Mat F, @ByVal Size imgSize,
                                             @ByVal Mat H1, @ByVal Mat H2,
                                             double threshold/*=5*/ );
@Namespace("cv") public static native @Cast("bool") boolean stereoRectifyUncalibrated( @ByVal Mat points1, @ByVal Mat points2,
                                             @ByVal Mat F, @ByVal Size imgSize,
                                             @ByVal Mat H1, @ByVal Mat H2 );

/** computes the rectification transformations for 3-head camera, where all the heads are on the same line. */
@Namespace("cv") public static native float rectify3Collinear( @ByVal Mat cameraMatrix1, @ByVal Mat distCoeffs1,
                                      @ByVal Mat cameraMatrix2, @ByVal Mat distCoeffs2,
                                      @ByVal Mat cameraMatrix3, @ByVal Mat distCoeffs3,
                                      @ByVal MatVector imgpt1, @ByVal MatVector imgpt3,
                                      @ByVal Size imageSize, @ByVal Mat R12, @ByVal Mat T12,
                                      @ByVal Mat R13, @ByVal Mat T13,
                                      @ByVal Mat R1, @ByVal Mat R2, @ByVal Mat R3,
                                      @ByVal Mat P1, @ByVal Mat P2, @ByVal Mat P3,
                                      @ByVal Mat Q, double alpha, @ByVal Size newImgSize,
                                      Rect roi1, Rect roi2, int flags );

/** @brief Returns the new camera matrix based on the free scaling parameter.

@param cameraMatrix Input camera matrix.
@param distCoeffs Input vector of distortion coefficients
\f$(k_1, k_2, p_1, p_2[, k_3[, k_4, k_5, k_6],[s_1, s_2, s_3, s_4]])\f$ of 4, 5, 8 or 12 elements. If
the vector is NULL/empty, the zero distortion coefficients are assumed.
@param imageSize Original image size.
@param alpha Free scaling parameter between 0 (when all the pixels in the undistorted image are
valid) and 1 (when all the source image pixels are retained in the undistorted image). See
stereoRectify for details.
@param newImgSize Image size after rectification. By default,it is set to imageSize .
@param validPixROI Optional output rectangle that outlines all-good-pixels region in the
undistorted image. See roi1, roi2 description in stereoRectify .
@param centerPrincipalPoint Optional flag that indicates whether in the new camera matrix the
principal point should be at the image center or not. By default, the principal point is chosen to
best fit a subset of the source image (determined by alpha) to the corrected image.
@return new_camera_matrix Output new camera matrix.

The function computes and returns the optimal new camera matrix based on the free scaling parameter.
By varying this parameter, you may retrieve only sensible pixels alpha=0 , keep all the original
image pixels if there is valuable information in the corners alpha=1 , or get something in between.
When alpha\>0 , the undistortion result is likely to have some black pixels corresponding to
"virtual" pixels outside of the captured distorted image. The original camera matrix, distortion
coefficients, the computed new camera matrix, and newImageSize should be passed to
initUndistortRectifyMap to produce the maps for remap .
 */
@Namespace("cv") public static native @ByVal Mat getOptimalNewCameraMatrix( @ByVal Mat cameraMatrix, @ByVal Mat distCoeffs,
                                            @ByVal Size imageSize, double alpha, @ByVal(nullValue = "cv::Size()") Size newImgSize/*=cv::Size()*/,
                                            Rect validPixROI/*=0*/,
                                            @Cast("bool") boolean centerPrincipalPoint/*=false*/);
@Namespace("cv") public static native @ByVal Mat getOptimalNewCameraMatrix( @ByVal Mat cameraMatrix, @ByVal Mat distCoeffs,
                                            @ByVal Size imageSize, double alpha);

/** @brief Converts points from Euclidean to homogeneous space.

@param src Input vector of N-dimensional points.
@param dst Output vector of N+1-dimensional points.

The function converts points from Euclidean to homogeneous space by appending 1's to the tuple of
point coordinates. That is, each point (x1, x2, ..., xn) is converted to (x1, x2, ..., xn, 1).
 */
@Namespace("cv") public static native void convertPointsToHomogeneous( @ByVal Mat src, @ByVal Mat dst );

/** @brief Converts points from homogeneous to Euclidean space.

@param src Input vector of N-dimensional points.
@param dst Output vector of N-1-dimensional points.

The function converts points homogeneous to Euclidean space using perspective projection. That is,
each point (x1, x2, ... x(n-1), xn) is converted to (x1/xn, x2/xn, ..., x(n-1)/xn). When xn=0, the
output point coordinates will be (0,0,0,...).
 */
@Namespace("cv") public static native void convertPointsFromHomogeneous( @ByVal Mat src, @ByVal Mat dst );

/** @brief Converts points to/from homogeneous coordinates.

@param src Input array or vector of 2D, 3D, or 4D points.
@param dst Output vector of 2D, 3D, or 4D points.

The function converts 2D or 3D points from/to homogeneous coordinates by calling either
convertPointsToHomogeneous or convertPointsFromHomogeneous.

@note The function is obsolete. Use one of the previous two functions instead.
 */
@Namespace("cv") public static native void convertPointsHomogeneous( @ByVal Mat src, @ByVal Mat dst );

/** @brief Calculates a fundamental matrix from the corresponding points in two images.

@param points1 Array of N points from the first image. The point coordinates should be
floating-point (single or double precision).
@param points2 Array of the second image points of the same size and format as points1 .
@param method Method for computing a fundamental matrix.
-   **CV_FM_7POINT** for a 7-point algorithm. \f$N = 7\f$
-   **CV_FM_8POINT** for an 8-point algorithm. \f$N \ge 8\f$
-   **CV_FM_RANSAC** for the RANSAC algorithm. \f$N \ge 8\f$
-   **CV_FM_LMEDS** for the LMedS algorithm. \f$N \ge 8\f$
@param param1 Parameter used for RANSAC. It is the maximum distance from a point to an epipolar
line in pixels, beyond which the point is considered an outlier and is not used for computing the
final fundamental matrix. It can be set to something like 1-3, depending on the accuracy of the
point localization, image resolution, and the image noise.
@param param2 Parameter used for the RANSAC or LMedS methods only. It specifies a desirable level
of confidence (probability) that the estimated matrix is correct.
@param mask

The epipolar geometry is described by the following equation:

\f[[p_2; 1]^T F [p_1; 1] = 0\f]

where \f$F\f$ is a fundamental matrix, \f$p_1\f$ and \f$p_2\f$ are corresponding points in the first and the
second images, respectively.

The function calculates the fundamental matrix using one of four methods listed above and returns
the found fundamental matrix. Normally just one matrix is found. But in case of the 7-point
algorithm, the function may return up to 3 solutions ( \f$9 \times 3\f$ matrix that stores all 3
matrices sequentially).

The calculated fundamental matrix may be passed further to computeCorrespondEpilines that finds the
epipolar lines corresponding to the specified points. It can also be passed to
stereoRectifyUncalibrated to compute the rectification transformation. :
@code
    // Example. Estimation of fundamental matrix using the RANSAC algorithm
    int point_count = 100;
    vector<Point2f> points1(point_count);
    vector<Point2f> points2(point_count);

    // initialize the points here ...
    for( int i = 0; i < point_count; i++ )
    {
        points1[i] = ...;
        points2[i] = ...;
    }

    Mat fundamental_matrix =
     findFundamentalMat(points1, points2, FM_RANSAC, 3, 0.99);
@endcode
 */
@Namespace("cv") public static native @ByVal Mat findFundamentalMat( @ByVal Mat points1, @ByVal Mat points2,
                                     int method/*=cv::FM_RANSAC*/,
                                     double param1/*=3.*/, double param2/*=0.99*/,
                                     @ByVal(nullValue = "cv::noArray()") Mat mask/*=cv::noArray()*/ );
@Namespace("cv") public static native @ByVal Mat findFundamentalMat( @ByVal Mat points1, @ByVal Mat points2 );

/** @overload */
@Namespace("cv") public static native @ByVal Mat findFundamentalMat( @ByVal Mat points1, @ByVal Mat points2,
                                   @ByVal Mat mask, int method/*=cv::FM_RANSAC*/,
                                   double param1/*=3.*/, double param2/*=0.99*/ );
@Namespace("cv") public static native @ByVal Mat findFundamentalMat( @ByVal Mat points1, @ByVal Mat points2,
                                   @ByVal Mat mask );

/** @brief Calculates an essential matrix from the corresponding points in two images.

@param points1 Array of N (N \>= 5) 2D points from the first image. The point coordinates should
be floating-point (single or double precision).
@param points2 Array of the second image points of the same size and format as points1 .
@param focal focal length of the camera. Note that this function assumes that points1 and points2
are feature points from cameras with same focal length and principle point.
@param pp principle point of the camera.
@param method Method for computing a fundamental matrix.
-   **RANSAC** for the RANSAC algorithm.
-   **MEDS** for the LMedS algorithm.
@param threshold Parameter used for RANSAC. It is the maximum distance from a point to an epipolar
line in pixels, beyond which the point is considered an outlier and is not used for computing the
final fundamental matrix. It can be set to something like 1-3, depending on the accuracy of the
point localization, image resolution, and the image noise.
@param prob Parameter used for the RANSAC or LMedS methods only. It specifies a desirable level of
confidence (probability) that the estimated matrix is correct.
@param mask Output array of N elements, every element of which is set to 0 for outliers and to 1
for the other points. The array is computed only in the RANSAC and LMedS methods.

This function estimates essential matrix based on the five-point algorithm solver in @cite Nister03 .
@cite SteweniusCFS is also a related. The epipolar geometry is described by the following equation:

\f[[p_2; 1]^T K^{-T} E K^{-1} [p_1; 1] = 0 \\\f]\f[K =
\begin{bmatrix}
f & 0 & x_{pp}  \\
0 & f & y_{pp}  \\
0 & 0 & 1
\end{bmatrix}\f]

where \f$E\f$ is an essential matrix, \f$p_1\f$ and \f$p_2\f$ are corresponding points in the first and the
second images, respectively. The result of this function may be passed further to
decomposeEssentialMat or recoverPose to recover the relative pose between cameras.
 */
@Namespace("cv") public static native @ByVal Mat findEssentialMat( @ByVal Mat points1, @ByVal Mat points2,
                                 double focal/*=1.0*/, @ByVal(nullValue = "cv::Point2d(0, 0)") Point2d pp/*=cv::Point2d(0, 0)*/,
                                 int method/*=cv::RANSAC*/, double prob/*=0.999*/,
                                 double threshold/*=1.0*/, @ByVal(nullValue = "cv::noArray()") Mat mask/*=cv::noArray()*/ );
@Namespace("cv") public static native @ByVal Mat findEssentialMat( @ByVal Mat points1, @ByVal Mat points2 );

/** @brief Decompose an essential matrix to possible rotations and translation.

@param E The input essential matrix.
@param R1 One possible rotation matrix.
@param R2 Another possible rotation matrix.
@param t One possible translation.

This function decompose an essential matrix E using svd decomposition @cite HartleyZ00 . Generally 4
possible poses exists for a given E. They are \f$[R_1, t]\f$, \f$[R_1, -t]\f$, \f$[R_2, t]\f$, \f$[R_2, -t]\f$. By
decomposing E, you can only get the direction of the translation, so the function returns unit t.
 */
@Namespace("cv") public static native void decomposeEssentialMat( @ByVal Mat E, @ByVal Mat R1, @ByVal Mat R2, @ByVal Mat t );

/** @brief Recover relative camera rotation and translation from an estimated essential matrix and the
corresponding points in two images, using cheirality check. Returns the number of inliers which pass
the check.

@param E The input essential matrix.
@param points1 Array of N 2D points from the first image. The point coordinates should be
floating-point (single or double precision).
@param points2 Array of the second image points of the same size and format as points1 .
@param R Recovered relative rotation.
@param t Recoverd relative translation.
@param focal Focal length of the camera. Note that this function assumes that points1 and points2
are feature points from cameras with same focal length and principle point.
@param pp Principle point of the camera.
@param mask Input/output mask for inliers in points1 and points2.
:   If it is not empty, then it marks inliers in points1 and points2 for then given essential
matrix E. Only these inliers will be used to recover pose. In the output mask only inliers
which pass the cheirality check.
This function decomposes an essential matrix using decomposeEssentialMat and then verifies possible
pose hypotheses by doing cheirality check. The cheirality check basically means that the
triangulated 3D points should have positive depth. Some details can be found in @cite Nister03 .

This function can be used to process output E and mask from findEssentialMat. In this scenario,
points1 and points2 are the same input for findEssentialMat. :
@code
    // Example. Estimation of fundamental matrix using the RANSAC algorithm
    int point_count = 100;
    vector<Point2f> points1(point_count);
    vector<Point2f> points2(point_count);

    // initialize the points here ...
    for( int i = 0; i < point_count; i++ )
    {
        points1[i] = ...;
        points2[i] = ...;
    }

    double focal = 1.0;
    cv::Point2d pp(0.0, 0.0);
    Mat E, R, t, mask;

    E = findEssentialMat(points1, points2, focal, pp, RANSAC, 0.999, 1.0, mask);
    recoverPose(E, points1, points2, R, t, focal, pp, mask);
@endcode
 */
@Namespace("cv") public static native int recoverPose( @ByVal Mat E, @ByVal Mat points1, @ByVal Mat points2,
                            @ByVal Mat R, @ByVal Mat t,
                            double focal/*=1.0*/, @ByVal(nullValue = "cv::Point2d(0, 0)") Point2d pp/*=cv::Point2d(0, 0)*/,
                            @ByVal(nullValue = "cv::noArray()") Mat mask/*=cv::noArray()*/ );
@Namespace("cv") public static native int recoverPose( @ByVal Mat E, @ByVal Mat points1, @ByVal Mat points2,
                            @ByVal Mat R, @ByVal Mat t );


/** @brief For points in an image of a stereo pair, computes the corresponding epilines in the other image.

@param points Input points. \f$N \times 1\f$ or \f$1 \times N\f$ matrix of type CV_32FC2 or
vector\<Point2f\> .
@param whichImage Index of the image (1 or 2) that contains the points .
@param F Fundamental matrix that can be estimated using findFundamentalMat or stereoRectify .
@param lines Output vector of the epipolar lines corresponding to the points in the other image.
Each line \f$ax + by + c=0\f$ is encoded by 3 numbers \f$(a, b, c)\f$ .

For every point in one of the two images of a stereo pair, the function finds the equation of the
corresponding epipolar line in the other image.

From the fundamental matrix definition (see findFundamentalMat ), line \f$l^{(2)}_i\f$ in the second
image for the point \f$p^{(1)}_i\f$ in the first image (when whichImage=1 ) is computed as:

\f[l^{(2)}_i = F p^{(1)}_i\f]

And vice versa, when whichImage=2, \f$l^{(1)}_i\f$ is computed from \f$p^{(2)}_i\f$ as:

\f[l^{(1)}_i = F^T p^{(2)}_i\f]

Line coefficients are defined up to a scale. They are normalized so that \f$a_i^2+b_i^2=1\f$ .
 */
@Namespace("cv") public static native void computeCorrespondEpilines( @ByVal Mat points, int whichImage,
                                             @ByVal Mat F, @ByVal Mat lines );

/** @brief Reconstructs points by triangulation.

@param projMatr1 3x4 projection matrix of the first camera.
@param projMatr2 3x4 projection matrix of the second camera.
@param projPoints1 2xN array of feature points in the first image. In case of c++ version it can
be also a vector of feature points or two-channel matrix of size 1xN or Nx1.
@param projPoints2 2xN array of corresponding points in the second image. In case of c++ version
it can be also a vector of feature points or two-channel matrix of size 1xN or Nx1.
@param points4D 4xN array of reconstructed points in homogeneous coordinates.

The function reconstructs 3-dimensional points (in homogeneous coordinates) by using their
observations with a stereo camera. Projections matrices can be obtained from stereoRectify.

@note
   Keep in mind that all input data should be of float type in order for this function to work.

@sa
   reprojectImageTo3D
 */
@Namespace("cv") public static native void triangulatePoints( @ByVal Mat projMatr1, @ByVal Mat projMatr2,
                                     @ByVal Mat projPoints1, @ByVal Mat projPoints2,
                                     @ByVal Mat points4D );

/** @brief Refines coordinates of corresponding points.

@param F 3x3 fundamental matrix.
@param points1 1xN array containing the first set of points.
@param points2 1xN array containing the second set of points.
@param newPoints1 The optimized points1.
@param newPoints2 The optimized points2.

The function implements the Optimal Triangulation Method (see Multiple View Geometry for details).
For each given point correspondence points1[i] \<-\> points2[i], and a fundamental matrix F, it
computes the corrected correspondences newPoints1[i] \<-\> newPoints2[i] that minimize the geometric
error \f$d(points1[i], newPoints1[i])^2 + d(points2[i],newPoints2[i])^2\f$ (where \f$d(a,b)\f$ is the
geometric distance between points \f$a\f$ and \f$b\f$ ) subject to the epipolar constraint
\f$newPoints2^T * F * newPoints1 = 0\f$ .
 */
@Namespace("cv") public static native void correctMatches( @ByVal Mat F, @ByVal Mat points1, @ByVal Mat points2,
                                  @ByVal Mat newPoints1, @ByVal Mat newPoints2 );

/** @brief Filters off small noise blobs (speckles) in the disparity map

@param img The input 16-bit signed disparity image
@param newVal The disparity value used to paint-off the speckles
@param maxSpeckleSize The maximum speckle size to consider it a speckle. Larger blobs are not
affected by the algorithm
@param maxDiff Maximum difference between neighbor disparity pixels to put them into the same
blob. Note that since StereoBM, StereoSGBM and may be other algorithms return a fixed-point
disparity map, where disparity values are multiplied by 16, this scale factor should be taken into
account when specifying this parameter value.
@param buf The optional temporary buffer to avoid memory allocation within the function.
 */
@Namespace("cv") public static native void filterSpeckles( @ByVal Mat img, double newVal,
                                  int maxSpeckleSize, double maxDiff,
                                  @ByVal(nullValue = "cv::noArray()") Mat buf/*=cv::noArray()*/ );
@Namespace("cv") public static native void filterSpeckles( @ByVal Mat img, double newVal,
                                  int maxSpeckleSize, double maxDiff );

/** computes valid disparity ROI from the valid ROIs of the rectified images (that are returned by cv::stereoRectify()) */
@Namespace("cv") public static native @ByVal Rect getValidDisparityROI( @ByVal Rect roi1, @ByVal Rect roi2,
                                        int minDisparity, int numberOfDisparities,
                                        int SADWindowSize );

/** validates disparity using the left-right check. The matrix "cost" should be computed by the stereo correspondence algorithm */
@Namespace("cv") public static native void validateDisparity( @ByVal Mat disparity, @ByVal Mat cost,
                                     int minDisparity, int numberOfDisparities,
                                     int disp12MaxDisp/*=1*/ );
@Namespace("cv") public static native void validateDisparity( @ByVal Mat disparity, @ByVal Mat cost,
                                     int minDisparity, int numberOfDisparities );

/** @brief Reprojects a disparity image to 3D space.

@param disparity Input single-channel 8-bit unsigned, 16-bit signed, 32-bit signed or 32-bit
floating-point disparity image.
@param _3dImage Output 3-channel floating-point image of the same size as disparity . Each
element of _3dImage(x,y) contains 3D coordinates of the point (x,y) computed from the disparity
map.
@param Q \f$4 \times 4\f$ perspective transformation matrix that can be obtained with stereoRectify.
@param handleMissingValues Indicates, whether the function should handle missing values (i.e.
points where the disparity was not computed). If handleMissingValues=true, then pixels with the
minimal disparity that corresponds to the outliers (see StereoMatcher::compute ) are transformed
to 3D points with a very large Z value (currently set to 10000).
@param ddepth The optional output array depth. If it is -1, the output image will have CV_32F
depth. ddepth can also be set to CV_16S, CV_32S or CV_32F.

The function transforms a single-channel disparity map to a 3-channel image representing a 3D
surface. That is, for each pixel (x,y) andthe corresponding disparity d=disparity(x,y) , it
computes:

\f[\begin{array}{l} [X \; Y \; Z \; W]^T =  \texttt{Q} *[x \; y \; \texttt{disparity} (x,y) \; 1]^T  \\ \texttt{\_3dImage} (x,y) = (X/W, \; Y/W, \; Z/W) \end{array}\f]

The matrix Q can be an arbitrary \f$4 \times 4\f$ matrix (for example, the one computed by
stereoRectify). To reproject a sparse set of points {(x,y,d),...} to 3D space, use
perspectiveTransform .
 */
@Namespace("cv") public static native void reprojectImageTo3D( @ByVal Mat disparity,
                                      @ByVal Mat _3dImage, @ByVal Mat Q,
                                      @Cast("bool") boolean handleMissingValues/*=false*/,
                                      int ddepth/*=-1*/ );
@Namespace("cv") public static native void reprojectImageTo3D( @ByVal Mat disparity,
                                      @ByVal Mat _3dImage, @ByVal Mat Q );

/** @brief Computes an optimal affine transformation between two 3D point sets.

@param src First input 3D point set.
@param dst Second input 3D point set.
@param out Output 3D affine transformation matrix \f$3 \times 4\f$ .
@param inliers Output vector indicating which points are inliers.
@param ransacThreshold Maximum reprojection error in the RANSAC algorithm to consider a point as
an inlier.
@param confidence Confidence level, between 0 and 1, for the estimated transformation. Anything
between 0.95 and 0.99 is usually good enough. Values too close to 1 can slow down the estimation
significantly. Values lower than 0.8-0.9 can result in an incorrectly estimated transformation.

The function estimates an optimal 3D affine transformation between two 3D point sets using the
RANSAC algorithm.
 */
@Namespace("cv") public static native int estimateAffine3D(@ByVal Mat src, @ByVal Mat dst,
                                   @ByVal Mat out, @ByVal Mat inliers,
                                   double ransacThreshold/*=3*/, double confidence/*=0.99*/);
@Namespace("cv") public static native int estimateAffine3D(@ByVal Mat src, @ByVal Mat dst,
                                   @ByVal Mat out, @ByVal Mat inliers);

/** @brief Decompose a homography matrix to rotation(s), translation(s) and plane normal(s).

@param H The input homography matrix between two images.
@param K The input intrinsic camera calibration matrix.
@param rotations Array of rotation matrices.
@param translations Array of translation matrices.
@param normals Array of plane normal matrices.

This function extracts relative camera motion between two views observing a planar object from the
homography H induced by the plane. The intrinsic camera matrix K must also be provided. The function
may return up to four mathematical solution sets. At least two of the solutions may further be
invalidated if point correspondences are available by applying positive depth constraint (all points
must be in front of the camera). The decomposition method is described in detail in @cite Malis .
 */
@Namespace("cv") public static native int decomposeHomographyMat(@ByVal Mat H,
                                        @ByVal Mat K,
                                        @ByVal MatVector rotations,
                                        @ByVal MatVector translations,
                                        @ByVal MatVector normals);

/** @brief The base class for stereo correspondence algorithms.
 */
@Namespace("cv") public static class StereoMatcher extends Algorithm {
    static { Loader.load(); }
    /** Empty constructor. */
    public StereoMatcher() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public StereoMatcher(Pointer p) { super(p); }

    /** enum cv::StereoMatcher:: */
    public static final int DISP_SHIFT = 4,
           DISP_SCALE =  (1 << DISP_SHIFT);

    /** @brief Computes disparity map for the specified stereo pair

    @param left Left 8-bit single-channel image.
    @param right Right image of the same size and the same type as the left one.
    @param disparity Output disparity map. It has the same size as the input images. Some algorithms,
    like StereoBM or StereoSGBM compute 16-bit fixed-point disparity map (where each disparity value
    has 4 fractional bits), whereas other algorithms output 32-bit floating-point disparity map.
     */
    public native void compute( @ByVal Mat left, @ByVal Mat right,
                                      @ByVal Mat disparity );

    public native int getMinDisparity();
    public native void setMinDisparity(int minDisparity);

    public native int getNumDisparities();
    public native void setNumDisparities(int numDisparities);

    public native int getBlockSize();
    public native void setBlockSize(int blockSize);

    public native int getSpeckleWindowSize();
    public native void setSpeckleWindowSize(int speckleWindowSize);

    public native int getSpeckleRange();
    public native void setSpeckleRange(int speckleRange);

    public native int getDisp12MaxDiff();
    public native void setDisp12MaxDiff(int disp12MaxDiff);
}


/** @brief Class for computing stereo correspondence using the block matching algorithm, introduced and
contributed to OpenCV by K. Konolige.
 */
@Namespace("cv") public static class StereoBM extends StereoMatcher {
    static { Loader.load(); }
    /** Empty constructor. */
    public StereoBM() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public StereoBM(Pointer p) { super(p); }

    /** enum cv::StereoBM:: */
    public static final int PREFILTER_NORMALIZED_RESPONSE = 0,
           PREFILTER_XSOBEL              = 1;

    public native int getPreFilterType();
    public native void setPreFilterType(int preFilterType);

    public native int getPreFilterSize();
    public native void setPreFilterSize(int preFilterSize);

    public native int getPreFilterCap();
    public native void setPreFilterCap(int preFilterCap);

    public native int getTextureThreshold();
    public native void setTextureThreshold(int textureThreshold);

    public native int getUniquenessRatio();
    public native void setUniquenessRatio(int uniquenessRatio);

    public native int getSmallerBlockSize();
    public native void setSmallerBlockSize(int blockSize);

    public native @ByVal Rect getROI1();
    public native void setROI1(@ByVal Rect roi1);

    public native @ByVal Rect getROI2();
    public native void setROI2(@ByVal Rect roi2);

    /** @brief Creates StereoBM object

    @param numDisparities the disparity search range. For each pixel algorithm will find the best
    disparity from 0 (default minimum disparity) to numDisparities. The search range can then be
    shifted by changing the minimum disparity.
    @param blockSize the linear size of the blocks compared by the algorithm. The size should be odd
    (as the block is centered at the current pixel). Larger block size implies smoother, though less
    accurate disparity map. Smaller block size gives more detailed disparity map, but there is higher
    chance for algorithm to find a wrong correspondence.

    The function create StereoBM object. You can then call StereoBM::compute() to compute disparity for
    a specific stereo pair.
     */
    public static native @Ptr StereoBM create(int numDisparities/*=0*/, int blockSize/*=21*/);
    public static native @Ptr StereoBM create();
}

/** @brief The class implements the modified H. Hirschmuller algorithm @cite HH08 that differs from the original
one as follows:

-   By default, the algorithm is single-pass, which means that you consider only 5 directions
instead of 8. Set mode=StereoSGBM::MODE_HH in createStereoSGBM to run the full variant of the
algorithm but beware that it may consume a lot of memory.
-   The algorithm matches blocks, not individual pixels. Though, setting blockSize=1 reduces the
blocks to single pixels.
-   Mutual information cost function is not implemented. Instead, a simpler Birchfield-Tomasi
sub-pixel metric from @cite BT98 is used. Though, the color images are supported as well.
-   Some pre- and post- processing steps from K. Konolige algorithm StereoBM are included, for
example: pre-filtering (StereoBM::PREFILTER_XSOBEL type) and post-filtering (uniqueness
check, quadratic interpolation and speckle filtering).

@note
   -   (Python) An example illustrating the use of the StereoSGBM matching algorithm can be found
        at opencv_source_code/samples/python2/stereo_match.py
 */
@Namespace("cv") public static class StereoSGBM extends StereoMatcher {
    static { Loader.load(); }
    /** Empty constructor. */
    public StereoSGBM() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public StereoSGBM(Pointer p) { super(p); }

    /** enum cv::StereoSGBM:: */
    public static final int
        MODE_SGBM = 0,
        MODE_HH   = 1;

    public native int getPreFilterCap();
    public native void setPreFilterCap(int preFilterCap);

    public native int getUniquenessRatio();
    public native void setUniquenessRatio(int uniquenessRatio);

    public native int getP1();
    public native void setP1(int P1);

    public native int getP2();
    public native void setP2(int P2);

    public native int getMode();
    public native void setMode(int mode);

    /** @brief Creates StereoSGBM object

    @param minDisparity Minimum possible disparity value. Normally, it is zero but sometimes
    rectification algorithms can shift images, so this parameter needs to be adjusted accordingly.
    @param numDisparities Maximum disparity minus minimum disparity. The value is always greater than
    zero. In the current implementation, this parameter must be divisible by 16.
    @param blockSize Matched block size. It must be an odd number \>=1 . Normally, it should be
    somewhere in the 3..11 range.
    @param P1 The first parameter controlling the disparity smoothness. See below.
    @param P2 The second parameter controlling the disparity smoothness. The larger the values are,
    the smoother the disparity is. P1 is the penalty on the disparity change by plus or minus 1
    between neighbor pixels. P2 is the penalty on the disparity change by more than 1 between neighbor
    pixels. The algorithm requires P2 \> P1 . See stereo_match.cpp sample where some reasonably good
    P1 and P2 values are shown (like 8\*number_of_image_channels\*SADWindowSize\*SADWindowSize and
    32\*number_of_image_channels\*SADWindowSize\*SADWindowSize , respectively).
    @param disp12MaxDiff Maximum allowed difference (in integer pixel units) in the left-right
    disparity check. Set it to a non-positive value to disable the check.
    @param preFilterCap Truncation value for the prefiltered image pixels. The algorithm first
    computes x-derivative at each pixel and clips its value by [-preFilterCap, preFilterCap] interval.
    The result values are passed to the Birchfield-Tomasi pixel cost function.
    @param uniquenessRatio Margin in percentage by which the best (minimum) computed cost function
    value should "win" the second best value to consider the found match correct. Normally, a value
    within the 5-15 range is good enough.
    @param speckleWindowSize Maximum size of smooth disparity regions to consider their noise speckles
    and invalidate. Set it to 0 to disable speckle filtering. Otherwise, set it somewhere in the
    50-200 range.
    @param speckleRange Maximum disparity variation within each connected component. If you do speckle
    filtering, set the parameter to a positive value, it will be implicitly multiplied by 16.
    Normally, 1 or 2 is good enough.
    @param mode Set it to StereoSGBM::MODE_HH to run the full-scale two-pass dynamic programming
    algorithm. It will consume O(W\*H\*numDisparities) bytes, which is large for 640x480 stereo and
    huge for HD-size pictures. By default, it is set to false .

    The first constructor initializes StereoSGBM with all the default parameters. So, you only have to
    set StereoSGBM::numDisparities at minimum. The second constructor enables you to set each parameter
    to a custom value.
     */
    public static native @Ptr StereoSGBM create(int minDisparity, int numDisparities, int blockSize,
                                              int P1/*=0*/, int P2/*=0*/, int disp12MaxDiff/*=0*/,
                                              int preFilterCap/*=0*/, int uniquenessRatio/*=0*/,
                                              int speckleWindowSize/*=0*/, int speckleRange/*=0*/,
                                              int mode/*=cv::StereoSGBM::MODE_SGBM*/);
    public static native @Ptr StereoSGBM create(int minDisparity, int numDisparities, int blockSize);
}

/** @} calib3d

/** @brief The methods in this namespace use a so-called fisheye camera model.
  @ingroup calib3d_fisheye
*/
/** @addtogroup calib3d_fisheye
 *  @{ */

    /** enum cv::fisheye:: */
    public static final int
        FISHEYE_CALIB_USE_INTRINSIC_GUESS   = 1,
        FISHEYE_CALIB_RECOMPUTE_EXTRINSIC   = 2,
        FISHEYE_CALIB_CHECK_COND            = 4,
        FISHEYE_CALIB_FIX_SKEW              = 8,
        FISHEYE_CALIB_FIX_K1                = 16,
        FISHEYE_CALIB_FIX_K2                = 32,
        FISHEYE_CALIB_FIX_K3                = 64,
        FISHEYE_CALIB_FIX_K4                = 128,
        FISHEYE_CALIB_FIX_INTRINSIC         = 256;

    /** @brief Projects points using fisheye model

    @param objectPoints Array of object points, 1xN/Nx1 3-channel (or vector\<Point3f\> ), where N is
    the number of points in the view.
    @param imagePoints Output array of image points, 2xN/Nx2 1-channel or 1xN/Nx1 2-channel, or
    vector\<Point2f\>.
    @param affine
    @param K Camera matrix \f$K = \vecthreethree{f_x}{0}{c_x}{0}{f_y}{c_y}{0}{0}{_1}\f$.
    @param D Input vector of distortion coefficients \f$(k_1, k_2, k_3, k_4)\f$.
    @param alpha The skew coefficient.
    @param jacobian Optional output 2Nx15 jacobian matrix of derivatives of image points with respect
    to components of the focal lengths, coordinates of the principal point, distortion coefficients,
    rotation vector, translation vector, and the skew. In the old interface different components of
    the jacobian are returned via different output parameters.

    The function computes projections of 3D points to the image plane given intrinsic and extrinsic
    camera parameters. Optionally, the function computes Jacobians - matrices of partial derivatives of
    image points coordinates (as functions of all the input parameters) with respect to the particular
    parameters, intrinsic and/or extrinsic.
     */
    @Namespace("cv::fisheye") public static native void projectPoints(@ByVal Mat objectPoints, @ByVal Mat imagePoints, @Const @ByRef Mat affine,
            @ByVal Mat K, @ByVal Mat D, double alpha/*=0*/, @ByVal(nullValue = "cv::noArray()") Mat jacobian/*=cv::noArray()*/);
    @Namespace("cv::fisheye") public static native void projectPoints(@ByVal Mat objectPoints, @ByVal Mat imagePoints, @Const @ByRef Mat affine,
            @ByVal Mat K, @ByVal Mat D);

    /** @overload */
    @Namespace("cv::fisheye") public static native void projectPoints(@ByVal Mat objectPoints, @ByVal Mat imagePoints, @ByVal Mat rvec, @ByVal Mat tvec,
            @ByVal Mat K, @ByVal Mat D, double alpha/*=0*/, @ByVal(nullValue = "cv::noArray()") Mat jacobian/*=cv::noArray()*/);

    /** @brief Distorts 2D points using fisheye model.

    @param undistorted Array of object points, 1xN/Nx1 2-channel (or vector\<Point2f\> ), where N is
    the number of points in the view.
    @param K Camera matrix \f$K = \vecthreethree{f_x}{0}{c_x}{0}{f_y}{c_y}{0}{0}{_1}\f$.
    @param D Input vector of distortion coefficients \f$(k_1, k_2, k_3, k_4)\f$.
    @param alpha The skew coefficient.
    @param distorted Output array of image points, 1xN/Nx1 2-channel, or vector\<Point2f\> .
     */
    @Namespace("cv::fisheye") public static native void distortPoints(@ByVal Mat undistorted, @ByVal Mat distorted, @ByVal Mat K, @ByVal Mat D, double alpha/*=0*/);
    @Namespace("cv::fisheye") public static native void distortPoints(@ByVal Mat undistorted, @ByVal Mat distorted, @ByVal Mat K, @ByVal Mat D);

    /** @brief Undistorts 2D points using fisheye model

    @param distorted Array of object points, 1xN/Nx1 2-channel (or vector\<Point2f\> ), where N is the
    number of points in the view.
    @param K Camera matrix \f$K = \vecthreethree{f_x}{0}{c_x}{0}{f_y}{c_y}{0}{0}{_1}\f$.
    @param D Input vector of distortion coefficients \f$(k_1, k_2, k_3, k_4)\f$.
    @param R Rectification transformation in the object space: 3x3 1-channel, or vector: 3x1/1x3
    1-channel or 1x1 3-channel
    @param P New camera matrix (3x3) or new projection matrix (3x4)
    @param undistorted Output array of image points, 1xN/Nx1 2-channel, or vector\<Point2f\> .
     */
    @Namespace("cv::fisheye") public static native void undistortPoints(@ByVal Mat distorted, @ByVal Mat undistorted,
            @ByVal Mat K, @ByVal Mat D, @ByVal(nullValue = "cv::noArray()") Mat R/*=cv::noArray()*/, @ByVal(nullValue = "cv::noArray()") Mat P/*=cv::noArray()*/);
    @Namespace("cv::fisheye") public static native void undistortPoints(@ByVal Mat distorted, @ByVal Mat undistorted,
            @ByVal Mat K, @ByVal Mat D);

    /** @brief Computes undistortion and rectification maps for image transform by cv::remap(). If D is empty zero
    distortion is used, if R or P is empty identity matrixes are used.

    @param K Camera matrix \f$K = \vecthreethree{f_x}{0}{c_x}{0}{f_y}{c_y}{0}{0}{_1}\f$.
    @param D Input vector of distortion coefficients \f$(k_1, k_2, k_3, k_4)\f$.
    @param R Rectification transformation in the object space: 3x3 1-channel, or vector: 3x1/1x3
    1-channel or 1x1 3-channel
    @param P New camera matrix (3x3) or new projection matrix (3x4)
    @param size Undistorted image size.
    @param m1type Type of the first output map that can be CV_32FC1 or CV_16SC2 . See convertMaps()
    for details.
    @param map1 The first output map.
    @param map2 The second output map.
     */
    @Namespace("cv::fisheye") public static native void initUndistortRectifyMap(@ByVal Mat K, @ByVal Mat D, @ByVal Mat R, @ByVal Mat P,
            @Const @ByRef Size size, int m1type, @ByVal Mat map1, @ByVal Mat map2);

    /** @brief Transforms an image to compensate for fisheye lens distortion.

    @param distorted image with fisheye lens distortion.
    @param undistorted Output image with compensated fisheye lens distortion.
    @param K Camera matrix \f$K = \vecthreethree{f_x}{0}{c_x}{0}{f_y}{c_y}{0}{0}{_1}\f$.
    @param D Input vector of distortion coefficients \f$(k_1, k_2, k_3, k_4)\f$.
    @param Knew Camera matrix of the distorted image. By default, it is the identity matrix but you
    may additionally scale and shift the result by using a different matrix.
    @param new_size

    The function transforms an image to compensate radial and tangential lens distortion.

    The function is simply a combination of fisheye::initUndistortRectifyMap (with unity R ) and remap
    (with bilinear interpolation). See the former function for details of the transformation being
    performed.

    See below the results of undistortImage.
       -   a\) result of undistort of perspective camera model (all possible coefficients (k_1, k_2, k_3,
            k_4, k_5, k_6) of distortion were optimized under calibration)
        -   b\) result of fisheye::undistortImage of fisheye camera model (all possible coefficients (k_1, k_2,
            k_3, k_4) of fisheye distortion were optimized under calibration)
        -   c\) original image was captured with fisheye lens

    Pictures a) and b) almost the same. But if we consider points of image located far from the center
    of image, we can notice that on image a) these points are distorted.

    ![image](pics/fisheye_undistorted.jpg)
     */
    @Namespace("cv::fisheye") public static native void undistortImage(@ByVal Mat distorted, @ByVal Mat undistorted,
            @ByVal Mat K, @ByVal Mat D, @ByVal(nullValue = "cv::noArray()") Mat Knew/*=cv::noArray()*/, @Const @ByRef(nullValue = "cv::Size()") Size new_size/*=cv::Size()*/);
    @Namespace("cv::fisheye") public static native void undistortImage(@ByVal Mat distorted, @ByVal Mat undistorted,
            @ByVal Mat K, @ByVal Mat D);

    /** @brief Estimates new camera matrix for undistortion or rectification.

    @param K Camera matrix \f$K = \vecthreethree{f_x}{0}{c_x}{0}{f_y}{c_y}{0}{0}{_1}\f$.
    @param image_size
    @param D Input vector of distortion coefficients \f$(k_1, k_2, k_3, k_4)\f$.
    @param R Rectification transformation in the object space: 3x3 1-channel, or vector: 3x1/1x3
    1-channel or 1x1 3-channel
    @param P New camera matrix (3x3) or new projection matrix (3x4)
    @param balance Sets the new focal length in range between the min focal length and the max focal
    length. Balance is in range of [0, 1].
    @param new_size
    @param fov_scale Divisor for new focal length.
     */
    @Namespace("cv::fisheye") public static native void estimateNewCameraMatrixForUndistortRectify(@ByVal Mat K, @ByVal Mat D, @Const @ByRef Size image_size, @ByVal Mat R,
            @ByVal Mat P, double balance/*=0.0*/, @Const @ByRef(nullValue = "cv::Size()") Size new_size/*=cv::Size()*/, double fov_scale/*=1.0*/);
    @Namespace("cv::fisheye") public static native void estimateNewCameraMatrixForUndistortRectify(@ByVal Mat K, @ByVal Mat D, @Const @ByRef Size image_size, @ByVal Mat R,
            @ByVal Mat P);

    /** @brief Performs camera calibaration

    @param objectPoints vector of vectors of calibration pattern points in the calibration pattern
    coordinate space.
    @param imagePoints vector of vectors of the projections of calibration pattern points.
    imagePoints.size() and objectPoints.size() and imagePoints[i].size() must be equal to
    objectPoints[i].size() for each i.
    @param image_size Size of the image used only to initialize the intrinsic camera matrix.
    @param K Output 3x3 floating-point camera matrix
    \f$A = \vecthreethree{f_x}{0}{c_x}{0}{f_y}{c_y}{0}{0}{1}\f$ . If
    fisheye::CALIB_USE_INTRINSIC_GUESS/ is specified, some or all of fx, fy, cx, cy must be
    initialized before calling the function.
    @param D Output vector of distortion coefficients \f$(k_1, k_2, k_3, k_4)\f$.
    @param rvecs Output vector of rotation vectors (see Rodrigues ) estimated for each pattern view.
    That is, each k-th rotation vector together with the corresponding k-th translation vector (see
    the next output parameter description) brings the calibration pattern from the model coordinate
    space (in which object points are specified) to the world coordinate space, that is, a real
    position of the calibration pattern in the k-th pattern view (k=0.. *M* -1).
    @param tvecs Output vector of translation vectors estimated for each pattern view.
    @param flags Different flags that may be zero or a combination of the following values:
    -   **fisheye::CALIB_USE_INTRINSIC_GUESS** cameraMatrix contains valid initial values of
    fx, fy, cx, cy that are optimized further. Otherwise, (cx, cy) is initially set to the image
    center ( imageSize is used), and focal distances are computed in a least-squares fashion.
    -   **fisheye::CALIB_RECOMPUTE_EXTRINSIC** Extrinsic will be recomputed after each iteration
    of intrinsic optimization.
    -   **fisheye::CALIB_CHECK_COND** The functions will check validity of condition number.
    -   **fisheye::CALIB_FIX_SKEW** Skew coefficient (alpha) is set to zero and stay zero.
    -   **fisheye::CALIB_FIX_K1..4** Selected distortion coefficients are set to zeros and stay
    zero.
    @param criteria Termination criteria for the iterative optimization algorithm.
     */
    @Namespace("cv::fisheye") public static native double calibrate(@ByVal MatVector objectPoints, @ByVal MatVector imagePoints, @Const @ByRef Size image_size,
            @ByVal Mat K, @ByVal Mat D, @ByVal MatVector rvecs, @ByVal MatVector tvecs, int flags/*=0*/,
                @ByVal(nullValue = "cv::TermCriteria(cv::TermCriteria::COUNT + cv::TermCriteria::EPS, 100, DBL_EPSILON)") TermCriteria criteria/*=cv::TermCriteria(cv::TermCriteria::COUNT + cv::TermCriteria::EPS, 100, DBL_EPSILON)*/);
    @Namespace("cv::fisheye") public static native double calibrate(@ByVal MatVector objectPoints, @ByVal MatVector imagePoints, @Const @ByRef Size image_size,
            @ByVal Mat K, @ByVal Mat D, @ByVal MatVector rvecs, @ByVal MatVector tvecs);

    /** @brief Stereo rectification for fisheye camera model

    @param K1 First camera matrix.
    @param D1 First camera distortion parameters.
    @param K2 Second camera matrix.
    @param D2 Second camera distortion parameters.
    @param imageSize Size of the image used for stereo calibration.
    @param R Rotation matrix between the coordinate systems of the first and the second
    cameras.
    @param tvec Translation vector between coordinate systems of the cameras.
    @param R1 Output 3x3 rectification transform (rotation matrix) for the first camera.
    @param R2 Output 3x3 rectification transform (rotation matrix) for the second camera.
    @param P1 Output 3x4 projection matrix in the new (rectified) coordinate systems for the first
    camera.
    @param P2 Output 3x4 projection matrix in the new (rectified) coordinate systems for the second
    camera.
    @param Q Output \f$4 \times 4\f$ disparity-to-depth mapping matrix (see reprojectImageTo3D ).
    @param flags Operation flags that may be zero or CV_CALIB_ZERO_DISPARITY . If the flag is set,
    the function makes the principal points of each camera have the same pixel coordinates in the
    rectified views. And if the flag is not set, the function may still shift the images in the
    horizontal or vertical direction (depending on the orientation of epipolar lines) to maximize the
    useful image area.
    @param newImageSize New image resolution after rectification. The same size should be passed to
    initUndistortRectifyMap (see the stereo_calib.cpp sample in OpenCV samples directory). When (0,0)
    is passed (default), it is set to the original imageSize . Setting it to larger value can help you
    preserve details in the original image, especially when there is a big radial distortion.
    @param balance Sets the new focal length in range between the min focal length and the max focal
    length. Balance is in range of [0, 1].
    @param fov_scale Divisor for new focal length.
     */
    @Namespace("cv::fisheye") public static native void stereoRectify(@ByVal Mat K1, @ByVal Mat D1, @ByVal Mat K2, @ByVal Mat D2, @Const @ByRef Size imageSize, @ByVal Mat R, @ByVal Mat tvec,
            @ByVal Mat R1, @ByVal Mat R2, @ByVal Mat P1, @ByVal Mat P2, @ByVal Mat Q, int flags, @Const @ByRef(nullValue = "cv::Size()") Size newImageSize/*=cv::Size()*/,
            double balance/*=0.0*/, double fov_scale/*=1.0*/);
    @Namespace("cv::fisheye") public static native void stereoRectify(@ByVal Mat K1, @ByVal Mat D1, @ByVal Mat K2, @ByVal Mat D2, @Const @ByRef Size imageSize, @ByVal Mat R, @ByVal Mat tvec,
            @ByVal Mat R1, @ByVal Mat R2, @ByVal Mat P1, @ByVal Mat P2, @ByVal Mat Q, int flags);

    /** @brief Performs stereo calibration

    @param objectPoints Vector of vectors of the calibration pattern points.
    @param imagePoints1 Vector of vectors of the projections of the calibration pattern points,
    observed by the first camera.
    @param imagePoints2 Vector of vectors of the projections of the calibration pattern points,
    observed by the second camera.
    @param K1 Input/output first camera matrix:
    \f$\vecthreethree{f_x^{(j)}}{0}{c_x^{(j)}}{0}{f_y^{(j)}}{c_y^{(j)}}{0}{0}{1}\f$ , \f$j = 0,\, 1\f$ . If
    any of fisheye::CALIB_USE_INTRINSIC_GUESS , fisheye::CV_CALIB_FIX_INTRINSIC are specified,
    some or all of the matrix components must be initialized.
    @param D1 Input/output vector of distortion coefficients \f$(k_1, k_2, k_3, k_4)\f$ of 4 elements.
    @param K2 Input/output second camera matrix. The parameter is similar to K1 .
    @param D2 Input/output lens distortion coefficients for the second camera. The parameter is
    similar to D1 .
    @param imageSize Size of the image used only to initialize intrinsic camera matrix.
    @param R Output rotation matrix between the 1st and the 2nd camera coordinate systems.
    @param T Output translation vector between the coordinate systems of the cameras.
    @param flags Different flags that may be zero or a combination of the following values:
    -   **fisheye::CV_CALIB_FIX_INTRINSIC** Fix K1, K2? and D1, D2? so that only R, T matrices
    are estimated.
    -   **fisheye::CALIB_USE_INTRINSIC_GUESS** K1, K2 contains valid initial values of
    fx, fy, cx, cy that are optimized further. Otherwise, (cx, cy) is initially set to the image
    center (imageSize is used), and focal distances are computed in a least-squares fashion.
    -   **fisheye::CALIB_RECOMPUTE_EXTRINSIC** Extrinsic will be recomputed after each iteration
    of intrinsic optimization.
    -   **fisheye::CALIB_CHECK_COND** The functions will check validity of condition number.
    -   **fisheye::CALIB_FIX_SKEW** Skew coefficient (alpha) is set to zero and stay zero.
    -   **fisheye::CALIB_FIX_K1..4** Selected distortion coefficients are set to zeros and stay
    zero.
    @param criteria Termination criteria for the iterative optimization algorithm.
     */
    @Namespace("cv::fisheye") public static native double stereoCalibrate(@ByVal MatVector objectPoints, @ByVal MatVector imagePoints1, @ByVal MatVector imagePoints2,
                                      @ByVal Mat K1, @ByVal Mat D1, @ByVal Mat K2, @ByVal Mat D2, @ByVal Size imageSize,
                                      @ByVal Mat R, @ByVal Mat T, int flags/*=cv::fisheye::CALIB_FIX_INTRINSIC*/,
                                      @ByVal(nullValue = "cv::TermCriteria(cv::TermCriteria::COUNT + cv::TermCriteria::EPS, 100, DBL_EPSILON)") TermCriteria criteria/*=cv::TermCriteria(cv::TermCriteria::COUNT + cv::TermCriteria::EPS, 100, DBL_EPSILON)*/);
    @Namespace("cv::fisheye") public static native double stereoCalibrate(@ByVal MatVector objectPoints, @ByVal MatVector imagePoints1, @ByVal MatVector imagePoints2,
                                      @ByVal Mat K1, @ByVal Mat D1, @ByVal Mat K2, @ByVal Mat D2, @ByVal Size imageSize,
                                      @ByVal Mat R, @ByVal Mat T);

/** @} calib3d_fisheye */


 // cv

// #ifndef DISABLE_OPENCV_24_COMPATIBILITY
// #include "opencv2/calib3d/calib3d_c.h"
// #endif

// #endif


}