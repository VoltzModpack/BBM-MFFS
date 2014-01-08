// Date: 10/1/2012 12:32:21 AM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package resonantinduction.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGearPiston extends ModelBase
{
	// fields
	ModelRenderer PistonCover;
	ModelRenderer RSpiston;
	ModelRenderer LSpiston;
	ModelRenderer RodPiston;
	ModelRenderer Base;
	ModelRenderer Front;
	ModelRenderer BackCC;
	ModelRenderer RightPipe;
	ModelRenderer FrontCC;
	ModelRenderer LeftCC;
	ModelRenderer FrontPipe;
	ModelRenderer Right;
	ModelRenderer RightCC;
	ModelRenderer Back;
	ModelRenderer BackPipe;
	ModelRenderer Left;
	ModelRenderer LeftPipe;
	ModelRenderer RigthF4;
	ModelRenderer LeftF4;
	ModelRenderer LeftF3;
	ModelRenderer LeftF2;
	ModelRenderer LeftF1;
	ModelRenderer RigthF3;
	ModelRenderer RigthF2;
	ModelRenderer RigthF1;
	ModelRenderer RigthGCC;
	ModelRenderer RightSlide;
	ModelRenderer midRod;
	ModelRenderer RightRod2;
	ModelRenderer LeftGCC;
	ModelRenderer LeftRod2;
	ModelRenderer LeftSlide2;

	public ModelGearPiston()
	{
		textureWidth = 128;
		textureHeight = 128;

		PistonCover = new ModelRenderer(this, 13, 31);
		PistonCover.addBox(0F, -9F, -3F, 6, 10, 6);
		PistonCover.setRotationPoint(-3F, 20F, 0F);
		PistonCover.setTextureSize(128, 128);
		PistonCover.mirror = true;
		setRotation(PistonCover, 0F, 0F, 0F);
		RSpiston = new ModelRenderer(this, 0, 32);
		RSpiston.addBox(-3F, -2F, -2F, 1, 7, 4);
		RSpiston.setRotationPoint(1F, 3F, 0F);
		RSpiston.setTextureSize(128, 128);
		RSpiston.mirror = true;
		setRotation(RSpiston, 0F, 0F, 0F);
		LSpiston = new ModelRenderer(this, 0, 32);
		LSpiston.addBox(-1F, -2F, -2F, 1, 7, 4);
		LSpiston.setRotationPoint(2F, 3F, 0F);
		LSpiston.setTextureSize(128, 128);
		LSpiston.mirror = true;
		setRotation(LSpiston, 0F, 0F, 0F);
		RodPiston = new ModelRenderer(this, 0, 59);
		RodPiston.addBox(-1F, -2F, -1.5F, 2, 13, 3);
		RodPiston.setRotationPoint(0F, 8F, 0F);
		RodPiston.setTextureSize(128, 128);
		RodPiston.mirror = true;
		setRotation(RodPiston, 0F, 0F, 0F);
		Base = new ModelRenderer(this, 12, 49);
		Base.addBox(0F, 0F, 0F, 10, 5, 10);
		Base.setRotationPoint(-5F, 19F, -5F);
		Base.setTextureSize(128, 128);
		Base.mirror = true;
		setRotation(Base, 0F, 0F, 0F);
		Front = new ModelRenderer(this, 28, 68);
		Front.addBox(-3F, 0F, 0F, 6, 12, 1);
		Front.setRotationPoint(0F, 12F, -7F);
		Front.setTextureSize(128, 128);
		Front.mirror = true;
		setRotation(Front, 0F, 0F, 0F);
		BackCC = new ModelRenderer(this, 43, 68);
		BackCC.addBox(-2F, -2F, 1F, 4, 4, 1);
		BackCC.setRotationPoint(0F, 16F, 6F);
		BackCC.setTextureSize(128, 128);
		BackCC.mirror = true;
		setRotation(BackCC, 0F, 0F, 0F);
		RightPipe = new ModelRenderer(this, 12, 87);
		RightPipe.addBox(0F, 0F, -2F, 2, 10, 4);
		RightPipe.setRotationPoint(-6F, 14F, 0F);
		RightPipe.setTextureSize(128, 128);
		RightPipe.mirror = true;
		setRotation(RightPipe, 0F, 0F, 0F);
		FrontCC = new ModelRenderer(this, 43, 68);
		FrontCC.addBox(-2F, -2F, -1F, 4, 4, 1);
		FrontCC.setRotationPoint(0F, 16F, -7F);
		FrontCC.setTextureSize(128, 128);
		FrontCC.mirror = true;
		setRotation(FrontCC, 0F, 0F, 0F);
		LeftCC = new ModelRenderer(this, 43, 74);
		LeftCC.addBox(0F, -2F, -2F, 1, 4, 4);
		LeftCC.setRotationPoint(7F, 16F, 0F);
		LeftCC.setTextureSize(128, 128);
		LeftCC.mirror = true;
		setRotation(LeftCC, 0F, 0F, 0F);
		FrontPipe = new ModelRenderer(this, 28, 82);
		FrontPipe.addBox(-2F, 0F, 0F, 4, 10, 2);
		FrontPipe.setRotationPoint(0F, 14F, -6F);
		FrontPipe.setTextureSize(128, 128);
		FrontPipe.mirror = true;
		setRotation(FrontPipe, 0F, 0F, 0F);
		Right = new ModelRenderer(this, 12, 68);
		Right.addBox(0F, 0F, -3F, 1, 12, 6);
		Right.setRotationPoint(-7F, 12F, 0F);
		Right.setTextureSize(128, 128);
		Right.mirror = true;
		setRotation(Right, 0F, 0F, 0F);
		RightCC = new ModelRenderer(this, 43, 74);
		RightCC.addBox(-1F, -2F, -2F, 1, 4, 4);
		RightCC.setRotationPoint(-7F, 16F, 0F);
		RightCC.setTextureSize(128, 128);
		RightCC.mirror = true;
		setRotation(RightCC, 0F, 0F, 0F);
		Back = new ModelRenderer(this, 28, 68);
		Back.addBox(-3F, 0F, 0F, 6, 12, 1);
		Back.setRotationPoint(0F, 12F, 6F);
		Back.setTextureSize(128, 128);
		Back.mirror = true;
		setRotation(Back, 0F, 0F, 0F);
		BackPipe = new ModelRenderer(this, 28, 82);
		BackPipe.addBox(-2F, 0F, -2F, 4, 10, 2);
		BackPipe.setRotationPoint(0F, 14F, 6F);
		BackPipe.setTextureSize(128, 128);
		BackPipe.mirror = true;
		setRotation(BackPipe, 0F, 0F, 0F);
		Left = new ModelRenderer(this, 12, 68);
		Left.addBox(0F, 0F, -3F, 1, 12, 6);
		Left.setRotationPoint(6F, 12F, 0F);
		Left.setTextureSize(128, 128);
		Left.mirror = true;
		setRotation(Left, 0F, 0F, 0F);
		LeftPipe = new ModelRenderer(this, 12, 87);
		LeftPipe.addBox(-2F, 0F, -2F, 2, 10, 4);
		LeftPipe.setRotationPoint(6F, 14F, 0F);
		LeftPipe.setTextureSize(128, 128);
		LeftPipe.mirror = true;
		setRotation(LeftPipe, 0F, 0F, 0F);
		RigthF4 = new ModelRenderer(this, 0, 56);
		RigthF4.addBox(-2F, 1F, 1F, 2, 1, 1);
		RigthF4.setRotationPoint(-8F, 0F, 0F);
		RigthF4.setTextureSize(128, 128);
		RigthF4.mirror = true;
		setRotation(RigthF4, 0F, 0F, 0F);
		LeftF4 = new ModelRenderer(this, 0, 56);
		LeftF4.addBox(0F, 1F, 1F, 2, 1, 1);
		LeftF4.setRotationPoint(8F, 0F, 0F);
		LeftF4.setTextureSize(128, 128);
		LeftF4.mirror = true;
		setRotation(LeftF4, 0.7853982F, 0F, 0F);
		LeftF3 = new ModelRenderer(this, 0, 56);
		LeftF3.addBox(0F, 1F, -2F, 2, 1, 1);
		LeftF3.setRotationPoint(8F, 0F, 0F);
		LeftF3.setTextureSize(128, 128);
		LeftF3.mirror = true;
		setRotation(LeftF3, 0.7853982F, 0F, 0F);
		LeftF2 = new ModelRenderer(this, 0, 56);
		LeftF2.addBox(0F, -2F, -2F, 2, 1, 1);
		LeftF2.setRotationPoint(8F, 0F, 0F);
		LeftF2.setTextureSize(128, 128);
		LeftF2.mirror = true;
		setRotation(LeftF2, 0.7853982F, 0F, 0F);
		LeftF1 = new ModelRenderer(this, 0, 56);
		LeftF1.addBox(0F, -2F, 1F, 2, 1, 1);
		LeftF1.setRotationPoint(8F, 0F, 0F);
		LeftF1.setTextureSize(128, 128);
		LeftF1.mirror = true;
		setRotation(LeftF1, 0.7853982F, 0F, 0F);
		RigthF3 = new ModelRenderer(this, 0, 56);
		RigthF3.addBox(-2F, 1F, -2F, 2, 1, 1);
		RigthF3.setRotationPoint(-8F, 0F, 0F);
		RigthF3.setTextureSize(128, 128);
		RigthF3.mirror = true;
		setRotation(RigthF3, 0F, 0F, 0F);
		RigthF2 = new ModelRenderer(this, 0, 56);
		RigthF2.addBox(-2F, -2F, 1F, 2, 1, 1);
		RigthF2.setRotationPoint(-8F, 0F, 0F);
		RigthF2.setTextureSize(128, 128);
		RigthF2.mirror = true;
		setRotation(RigthF2, 0F, 0F, 0F);
		RigthF1 = new ModelRenderer(this, 0, 56);
		RigthF1.addBox(-2F, -2F, -2F, 2, 1, 1);
		RigthF1.setRotationPoint(-8F, 0F, 0F);
		RigthF1.setTextureSize(128, 128);
		RigthF1.mirror = true;
		setRotation(RigthF1, 0F, 0F, 0F);
		RigthGCC = new ModelRenderer(this, 12, 18);
		RigthGCC.addBox(-2F, -2F, -2F, 2, 4, 4);
		RigthGCC.setRotationPoint(-6F, 0F, 0F);
		RigthGCC.setTextureSize(128, 128);
		RigthGCC.mirror = true;
		setRotation(RigthGCC, 0F, 0F, 0F);
		RightSlide = new ModelRenderer(this, 0, 44);
		RightSlide.addBox(0F, -2F, -2F, 1, 7, 4);
		RightSlide.setRotationPoint(-4F, 0F, 0F);
		RightSlide.setTextureSize(128, 128);
		RightSlide.mirror = true;
		setRotation(RightSlide, 0F, 0F, 0F);
		LeftSlide2 = new ModelRenderer(this, 0, 27);
		LeftSlide2.addBox(0F, 2F, -1F, 6, 2, 2);
		LeftSlide2.setRotationPoint(-3F, 0F, 0F);
		LeftSlide2.setTextureSize(128, 128);
		LeftSlide2.mirror = true;
		setRotation(LeftSlide2, 0F, 0F, 0F);
		RightRod2 = new ModelRenderer(this, 0, 20);
		RightRod2.addBox(0F, -1.5F, -1.5F, 2, 3, 3);
		RightRod2.setRotationPoint(-6F, 0F, 0F);
		RightRod2.setTextureSize(128, 128);
		RightRod2.mirror = true;
		setRotation(RightRod2, 0F, 0F, 0F);
		LeftGCC = new ModelRenderer(this, 24, 18);
		LeftGCC.addBox(-1F, -2F, -2F, 2, 4, 4);
		LeftGCC.setRotationPoint(7F, 0F, 0F);
		LeftGCC.setTextureSize(128, 128);
		LeftGCC.mirror = true;
		setRotation(LeftGCC, 0.7853982F, 0F, 0F);
		LeftRod2 = new ModelRenderer(this, 0, 20);
		LeftRod2.addBox(-3F, -1.5F, -1.5F, 2, 3, 3);
		LeftRod2.setRotationPoint(7F, 0F, 0F);
		LeftRod2.setTextureSize(128, 128);
		LeftRod2.mirror = true;
		setRotation(LeftRod2, 0F, 0F, 0F);
		midRod = new ModelRenderer(this, 0, 32);
		midRod.addBox(-1F, -2F, -2F, 1, 7, 4);
		midRod.setRotationPoint(4F, 0F, 0F);
		midRod.setTextureSize(128, 128);
		midRod.mirror = true;
		setRotation(midRod, 0F, 0F, 0F);
	}

	public void renderBody(float f5)
	{
		Base.render(f5);
		PistonCover.render(f5);

	}

	public void renderGear(float f5)
	{
		// Rod connectors
		LeftF4.render(f5);
		LeftF3.render(f5);
		LeftF2.render(f5);
		LeftF1.render(f5);
		RigthF4.render(f5);
		RigthF3.render(f5);
		RigthF2.render(f5);
		RigthF1.render(f5);
		RigthGCC.render(f5);
		LeftGCC.render(f5);
	}

	public void renderR(float f5, int pos)
	{
		switch (pos)
		{
			case 0:
				RSpiston.setRotationPoint(1F, 3F, 0F);
				LSpiston.setRotationPoint(2F, 3F, 0F);
				RodPiston.setRotationPoint(0F, 8F, 0F);
				setRotation(RSpiston, 0F, 0F, 0F);
				setRotation(LSpiston, 0F, 0F, 0F);
				break;
			case 1:
				RodPiston.setRotationPoint(0F, 6F, 0F);
				LSpiston.setRotationPoint(2F, 2F, 2F);
				RSpiston.setRotationPoint(1F, 2F, 2F);
				setRotation(LSpiston, -0.5235988F, 0F, 0F);
				setRotation(RSpiston, -0.5235988F, 0F, 0F);
				break;
			case 2:
				LSpiston.setRotationPoint(2F, 0F, 3F);
				RSpiston.setRotationPoint(1F, 0F, 3F);
				RodPiston.setRotationPoint(0F, 3F, 0F);
				setRotation(RSpiston, -1.047198F, 0F, 0F);
				setRotation(LSpiston, -1.047198F, 0F, 0F);
				break;
			case 3:
				LSpiston.setRotationPoint(2F, -2F, 2F);
				RSpiston.setRotationPoint(1F, -2F, 2F);
				RodPiston.setRotationPoint(0F, 1F, 0F);
				setRotation(LSpiston, -0.7853982F, 0F, 0F);
				setRotation(RSpiston, -0.7853982F, 0F, 0F);
				break;
			case 4:
				LSpiston.setRotationPoint(2F, -3F, 0F);
				RSpiston.setRotationPoint(1F, -3F, 0F);
				RodPiston.setRotationPoint(0F, 1F, 0F);
				setRotation(LSpiston, 0F, 0F, 0F);
				setRotation(RSpiston, 0F, 0F, 0F);
				break;
			case 5:
				LSpiston.setRotationPoint(2F, -2F, -2F);
				RSpiston.setRotationPoint(1F, -2F, -2F);
				RodPiston.setRotationPoint(0F, 1F, 0F);
				setRotation(LSpiston, 0.7853982F, 0F, 0F);
				setRotation(RSpiston, 0.7853982F, 0F, 0F);
				break;
			case 6:
				RSpiston.setRotationPoint(1F, 0F, -3F);
				LSpiston.setRotationPoint(2F, 0F, -3F);
				RodPiston.setRotationPoint(0F, 2F, 0F);
				setRotation(RSpiston, 1.047198F, 0F, 0F);
				setRotation(LSpiston, 1.047198F, 0F, 0F);
				break;
			case 7:
				RodPiston.setRotationPoint(0F, 6F, 0F);
				LSpiston.setRotationPoint(2F, 2F, -2F);
				RSpiston.setRotationPoint(1F, 2F, -2F);
				setRotation(LSpiston, 0.5235988F, 0F, 0F);
				setRotation(RSpiston, 0.5235988F, 0F, 0F);
				break;
		}
		// Piston Arm
		RSpiston.render(f5);
		LSpiston.render(f5);
		RodPiston.render(f5);
		// GearShaft
		RightSlide.rotateAngleX = 0.7853982F * pos;
		midRod.rotateAngleX = 0.7853982F * pos;
		midRod.rotateAngleX = 0.7853982F * pos;
		RightRod2.rotateAngleX = 0.7853982F * pos;
		LeftRod2.rotateAngleX = 0.7853982F * pos;
		LeftSlide2.rotateAngleX = 0.7853982F * pos;
		RightSlide.render(f5);
		midRod.render(f5);
		RightRod2.render(f5);
		LeftRod2.render(f5);
		LeftSlide2.render(f5);
	}

	public void renderLeft(float f5)
	{
		Left.render(f5);
		LeftPipe.render(f5);
		LeftCC.render(f5);
	}

	public void renderRight(float f5)
	{
		Right.render(f5);
		RightCC.render(f5);
		RightPipe.render(f5);
	}

	public void renderFront(float f5)
	{
		Front.render(f5);
		FrontCC.render(f5);
		FrontPipe.render(f5);
	}

	public void renderBack(float f5)
	{
		Back.render(f5);
		BackPipe.render(f5);
		BackCC.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

}