package com.company;

import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

class JImageDisplay extends JComponent {
    private BufferedImage displayImage;

    public JImageDisplay(int width, int height) {
        this.displayImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Dimension imageDimension = new Dimension(width, height);

        super.setPreferredSize(imageDimension);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(this.displayImage, 0, 0, this.displayImage.getWidth(),
                this.displayImage.getHeight(), null);
    }

    public void clearImage() {
        int[] blankArray = new int[getWidth() * getHeight()];

        this.displayImage.setRGB(0, 0, getWidth(), getHeight(), blankArray, 0, 1);
    }

    public void drawPixel(int x, int y, int rgbColor) {
        this.displayImage.setRGB(x, y, rgbColor);
    }
}
