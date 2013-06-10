import com.jme3.asset.AssetManager;
import com.jme3.bullet.PhysicsSpace;
import com.jme3.bullet.collision.PhysicsCollisionEvent;
import com.jme3.bullet.collision.PhysicsCollisionListener;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.material.Material;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Sphere;


public class Pointer extends Geometry implements PhysicsCollisionListener {

  public Pointer(AssetManager assetManager, PhysicsSpace space) {
		super("Pointer", new Sphere(16, 16, 0.2f));
		this.setMaterial(new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md"));
		RigidBodyControl control = new RigidBodyControl(0f);
		this.addControl(control);
		control.setKinematic(true);
		control.setPhysicsSpace(space);
		space.add(control);
		space.addCollisionListener(this);
	}

	@Override
	public void collision(PhysicsCollisionEvent e) {
		if(e.getNodeA().getName().equals("Pointer")) {
			System.out.println("LOG: " + e.getNodeA().getName() + " + " + e.getNodeB().getName());
		}
	}
	
}