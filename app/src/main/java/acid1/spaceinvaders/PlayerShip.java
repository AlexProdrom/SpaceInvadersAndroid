package acid1.spaceinvaders;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;

/**
 * Created by prodromalex on 4/19/2017.
 */

public class PlayerShip {

    //RectF holds four float coordinates for a rectangle. The rectangle is
    // represented by the coordinates of its 4 edges (left, top, right bottom).
    RectF rect;

    // The player ship will be represented by a Bitmap
    private Bitmap bitmap;

    // How long and high our ship will be
    private float length;
    private float height;

    // X is the far left of the rectangle which forms our ship
    private float x;

    // Y is the top coordinate
    private float y;

    // This will hold the pixels per second speed that the ship will move
    private float shipSpeed;

    // Which ways can the ship move
    public final int STOPPED = 0;
    public final int LEFT = 1;
    public final int RIGHT = 2;

    // Is the ship moving and in which direction
    private int shipMoving = STOPPED;

    // This the the constructor method
    // When we create an object from this class we will pass
    // in the screen width and height
    public PlayerShip(Context context, int screenX, int screenY){

        // Initialize a blank RectF
        rect = new RectF();

        length = screenX/10;
        height = screenY/10;

        // Start ship in roughly the screen centre
        x = screenX / 2;
        y = screenY - 20;

        // Initialize the bitmap
        //Creates Bitmap objects from various sources, including files, streams, and byte-arrays.
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.playership);

        // stretch the bitmap to a size appropriate for the screen resolution
        //Creates a new bitmap, scaled from an existing bitmap, when possible.
        // If the specified width and height are the same as the current
        // width and height of the source bitmap, the source bitmap is returned and no new bitmap is created
        bitmap = Bitmap.createScaledBitmap(bitmap,
                (int) (length),
                (int) (height),
                false);

        // How fast is the spaceship in pixels per second
        shipSpeed = 350;
    }

    public RectF getRect(){
        return rect;
    }

    // This is a getter method to make the rectangle that
    // defines our ship available in SpaceInvadersView class
    public Bitmap getBitmap(){
        return bitmap;
    }

    //x and length for firing bullets dead-centre from the ship
    public float getX(){
        return x;
    }

    public float getLength(){
        return length;
    }

    // This method will be used to change/set if the ship is going left, right or nowhere
    public void setMovementState(int state){
        shipMoving = state;
    }
}
