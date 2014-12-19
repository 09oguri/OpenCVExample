import static org.bytedeco.javacpp.opencv_core.cvReleaseImage;
import static org.bytedeco.javacpp.opencv_highgui.cvLoadImage;

import org.bytedeco.javacpp.opencv_core.CvMat;
import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacv.CanvasFrame;


public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("START");
        showImage();
        System.out.println("END");
    }
    
    private static void showImage() {
        IplImage img;
        String imgfile = "./image/lena.jpg";
        
        img = cvLoadImage(imgfile);
        
        CanvasFrame canvas = cvNamedWindow("lena");
        
        cvShowImage(canvas, img);
        
        cvReleaseImage(img);
    }
    
    private static void cvShowImage(CanvasFrame canvas, IplImage image) {
        CvMat mat = image.asCvMat();
        int width = mat.cols();
        if (width < 1)
            width = 1;
        int height = mat.rows();
        if (height < 1)
            height = 1;
        
        canvas.setCanvasSize(width, height);
        canvas.showImage(image);
    }
    
    private static CanvasFrame cvNamedWindow(String caption) {
        CanvasFrame canvas = new CanvasFrame(caption, 1); // gamma=1
        canvas.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        
        return canvas;
    }

}
