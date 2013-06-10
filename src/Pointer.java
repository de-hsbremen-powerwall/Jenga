import com.jme3.asset.AssetManager;
import com.jme3.bullet.PhysicsSpace;
import com.jme3.bullet.collision.PhysicsCollisionEvent;
import com.jme3.bullet.collision.PhysicsCollisionListener;
import com.jme3.bullet.collision.PhysicsCollisionObject;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.objects.PhysicsRigidBody;
import com.jme3.material.Material;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Sphere;


public class Pointer extends Geometry implements PhysicsCollisionListener {

	public RigidBodyControl control;
	
  public Pointer(AssetManager assetManager, PhysicsSpace space) {
		//super("Pointer", new Sphere(16, 16, 0.04f));
		super("Pointer", new Box(0.06f, 0.06f, 0.06f));
		this.setMaterial(new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md"));
		control = new RigidBodyControl(10f);
		this.addControl(control);
		control.setKinematic(true);
		control.setPhysicsSpace(space);
		space.add(control);
		space.addCollisionListener(this);
	}

	@Override
	public void collision(PhysicsCollisionEvent e) {
		
		if (e.getNodeB().getName().equals("Pointer") && e.getNodeA().getName().equals("Block")) {
			
			PhysicsCollisionObject physicsCollisionObject = e.getObjectB();
			
			/*
			if (physicsCollisionObject instanceof PhysicsRigidBody) {
				
                PhysicsRigidBody body = (PhysicsRigidBody) physicsCollisionObject;
                
                body.setFriction(0.1f);
                body.setMass(1f);
			}*/
		}
		
		
	}
	
}