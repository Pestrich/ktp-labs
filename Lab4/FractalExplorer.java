package com.company;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.Rectangle2D;
import java.awt.event.*;

public class FractalExplorer {
    private int displaySize;

    private JImageDisplay display;

    private FractalGenerator fractal;

    private Rectangle2D.Double range;

    public FractalExplorer(int size) {
        this.displaySize = size;
        this.fractal = new Mandelbrot();
        this.range = new Rectangle2D.Double();
        this.fractal.getInitialRange(this.range);
        this.display = new JImageDisplay(this.displaySize, this.displaySize);
    }

    public void createAndShowGUI() {
        this.display.setLayout(new BorderLayout());
        JFrame myframe = new JFrame("Fractal Explorer");

        myframe.add(this.display, BorderLayout.CENTER);

        JButton resetButton = new JButton("Reset Display");

        ResetHandler handler = new ResetHandler();
        resetButton.addActionListener(handler);

        myframe.add(resetButton, BorderLayout.SOUTH);

        MouseHandler click = new MouseHandler();
        this.display.addMouseListener(click);

        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myframe.pack();
        myframe.setVisible(true);
        myframe.setResizable(false);
    }

    private void drawFractal() {
        for (int x = 0; x < this.displaySize; x++) {
            for (int y = 0; y < this.displaySize; y++) {
                double xCoord = this.fractal.getCoord(this.range.x,
                        this.range.x + this.range.width, this.displaySize, x);
                double yCoord = this.fractal.getCoord(this.range.y,
                        this.range.y + this.range.height, this.displaySize, y);

                int iteration = this.fractal.numIterations(xCoord, yCoord);

                if (iteration == -1) {
                    this.display.drawPixel(x, y, 0);
                } else {
                    float hue = 0.7f + (float) iteration / 200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);

                    this.display.drawPixel(x, y, rgbColor);
                }
            }
        }

        this.display.repaint();
    }

    private class ResetHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            fractal.getInitialRange(range);
            drawFractal();
        }
    }

    private class MouseHandler extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            int x = e.getX();
            double xCoord = fractal.getCoord(range.x,
                    range.x + range.width, displaySize, x);
            int y = e.getY();
            double yCoord = fractal.getCoord(range.y,
                    range.y + range.height, displaySize, y);

            fractal.recenterAndZoomRange(range, xCoord, yCoord, 0.5);

            drawFractal();
        }
    }

    public static void main(String[] args) {
        FractalExplorer displayExplorer = new FractalExplorer(600);
        displayExplorer.createAndShowGUI();
        displayExplorer.drawFractal();
    }
}
