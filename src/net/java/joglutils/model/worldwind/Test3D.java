package net.java.joglutils.model.worldwind;

import gov.nasa.worldwind.examples.ApplicationTemplate;
import gov.nasa.worldwind.geom.Angle;
import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.layers.RenderableLayer;
import java.util.Random;

public class Test3D extends ApplicationTemplate {

    public static class AppFrame extends ApplicationTemplate.AppFrame {

        public AppFrame() {
            super(true, true, false);
            try {
                RenderableLayer layer = new RenderableLayer();
                layer.setName("movable 3D object");
                Random generator = new Random();
                for (int i = 0; i < 100; i++) {
                    layer.addRenderable(
                            new Movable3DModel(
                            "net/java/joglutils/model/examples/models/max3ds/spaceship.3ds",
                            new Position(Angle.fromDegrees(generator.nextInt() % 90),
                            Angle.fromDegrees(generator.nextInt() % 180), 200000),
                            300000));
                }
                
                for (int i = 0; i < 100; i++) {
                    layer.addRenderable(
                            new Movable3DModel(
                            "net/java/joglutils/model/examples/models/obj/penguin.obj",
                            new Position(Angle.fromDegrees(generator.nextInt() % 90),
                            Angle.fromDegrees(generator.nextInt() % 180), 200000),
                            300000));
                }
                
                this.getWwd().addSelectListener(new GenericDraggerAdjuster(this.getWwd()));
                insertBeforeCompass(this.getWwd(), layer);
                this.getLayerPanel().update(this.getWwd());                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ApplicationTemplate.start("Movable 3D Model Layer Test", AppFrame.class);
    }
}

