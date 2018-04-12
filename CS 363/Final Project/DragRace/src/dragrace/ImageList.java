package dragrace;

import java.util.ArrayList;
import javax.swing.ImageIcon;

/* - Store actual car images.
 *  - Draw images once user decides to race.
 */
public class ImageList extends ArrayList<ImageIcon> {

    public void addCarImage(ImageIcon image) {
        add(image);
    }
}
