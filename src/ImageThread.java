import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

class ImageThread implements Runnable {

    private int start, end;

    ImageThread(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for(int i = start; i <= end; i++){
            String name = PeriodicTable.getElements()[i].getName().toLowerCase();
            Image img = null;
            try{
                URL url = new URL("http://images-of-elements.com/s/" + name + ".jpg");
                img = ImageIO.read(url);
            } catch (IOException e) {
                try {

                    //Put URL together, taking special cases into account
                    if(i < 104){
                        name = i == 13 ? "aluminium" : "caesium";
                    }else{
                        name = "transactinoid";
                    }
                    URL url = new URL("http://images-of-elements.com/s/" + name +
                            (!name.equals("transactinoid") ? ".jpg" : ".png"));
                    img = ImageIO.read(url);
                } catch (IOException e1) {
                    System.err.println("Unable to download image for element number " + i + ". " +
                            "Make sure you have an active internet connection.");
                    e1.printStackTrace();
                }
            }
            ElementInfoLayer.setPicture((BufferedImage)img, i);
        }
    }
}
