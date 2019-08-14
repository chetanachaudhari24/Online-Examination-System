
import java.awt.Color;
import java.awt.Paint;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aditiambadkar
 */
public class CustomRenderer extends BarRenderer{
    
    private Paint[] paint;
    
    public CustomRenderer(final Paint[] paint) {
        this.paint = paint;
    }
    
    public Paint getItemPaint(final int row, final int column) {
        if(column == 0)
            return new Color(51,153,255);
        else if(column == 1)
            return new Color(0,102,204);
        else
            return new Color(0,76,153);
    }
    
}
