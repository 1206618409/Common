package com.xzit.zhj;


import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageUtil {
    public static BufferedImage rotateImage (final BufferedImage bufferedImage,final int degree){
        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        int type = bufferedImage.getColorModel().getTransferType();
        BufferedImage img;
        Graphics2D graphics2d;
        (graphics2d = (img = new BufferedImage(w,h,type))
                .createGraphics()).setRenderingHint(
                RenderingHints.KEY_ALPHA_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2d.rotate(Math.toRadians(degree),w /2,h /2);
        graphics2d.drawImage(bufferedImage,0,0,null);
        graphics2d.dispose();
        return img;
    }
}
