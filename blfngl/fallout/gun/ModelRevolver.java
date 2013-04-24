package blfngl.fallout.gun;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelRevolver extends ModelBase
{
  //fields
    ModelRenderer Barrel;
    ModelRenderer IronSight;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
  
  public ModelRevolver()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Barrel = new ModelRenderer(this, 18, 0);
      Barrel.addBox(0F, 0F, 0F, 1, 1, 3);
      Barrel.setRotationPoint(2F, 0F, -3F);
      Barrel.setTextureSize(64, 32);
      Barrel.mirror = true;
      setRotation(Barrel, 1.570796F, 0F, -3.141593F);
      IronSight = new ModelRenderer(this, 26, 0);
      IronSight.addBox(0F, 0F, 0F, 0, 1, 1);
      IronSight.setRotationPoint(1.5F, 3.5F, -2.5F);
      IronSight.setTextureSize(64, 32);
      IronSight.mirror = true;
      setRotation(IronSight, 0F, 1.570796F, -3.141593F);
      Shape1 = new ModelRenderer(this, 8, 0);
      Shape1.addBox(0F, 0F, 0F, 2, 2, 3);
      Shape1.setRotationPoint(2F, 0F, -1.5F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, -1.570796F, 0F, -3.150887F);
      Shape2 = new ModelRenderer(this, 4, 0);
      Shape2.addBox(0F, 0F, 0F, 1, 3, 1);
      Shape2.setRotationPoint(1.7F, -3F, -3F);
      Shape2.setTextureSize(64, 32);
      Shape2.mirror = true;
      setRotation(Shape2, -0.0371786F, 0F, -3.885165F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Barrel.render(f5);
    IronSight.render(f5);
    Shape1.render(f5);
    Shape2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
  }

}