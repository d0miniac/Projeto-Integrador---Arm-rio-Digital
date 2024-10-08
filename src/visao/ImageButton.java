package visao;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class ImageButton extends JButton {
private BufferedImage image;

public ImageButton(String imagePath) {
try {
image = ImageIO.read(new File(imagePath));
} catch (IOException e) {
e.printStackTrace();
}
setContentAreaFilled(false); // Make the button transparent
setFocusPainted(false);
//setBorderPainted(false);
}

@Override
protected void paintComponent(Graphics g) {
// Draw rounded border
Graphics2D g2d = (Graphics2D) g;
int width = getWidth();
int height = getHeight();
int borderRadius = 20; // Adjust the radius as needed

// Create rounded rectangle shape
Shape roundedRectangle = new RoundRectangle2D.Float(0, 0, width, height, borderRadius, borderRadius);
g2d.setColor(getBackground());
g2d.fill(roundedRectangle); // Fill the rounded rectangle

// Draw the image on top
if (image != null) {
Image resizedImage = image.getScaledInstance(width-3, height-3, Image.SCALE_SMOOTH);
g2d.drawImage(resizedImage, 0, 0, this);
}

// Draw the rounded border
g2d.setColor(Color.BLACK); // Border color
g2d.draw(roundedRectangle); // Draw the border
}
}