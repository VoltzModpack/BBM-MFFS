// Date: 12/30/2013 5:50:34 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package resonantinduction.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelOpenTrough extends ModelBase
{
	// fields
	ModelRenderer base;
	ModelRenderer leftBase;
	ModelRenderer leftBaseB;
	ModelRenderer rightBaseB;
	ModelRenderer rightBase;
	ModelRenderer frontBase;
	ModelRenderer frontBaseB;
	ModelRenderer backBase;
	ModelRenderer backBaseB;
	ModelRenderer frontA;
	ModelRenderer frontB;
	ModelRenderer backA;
	ModelRenderer backB;
	ModelRenderer rightA;
	ModelRenderer rightB;
	ModelRenderer leftB;
	ModelRenderer leftA;
	ModelRenderer centerA;
	ModelRenderer centerB;
	ModelRenderer centerC;
	ModelRenderer centerD;
	ModelRenderer frontDoorA;
	ModelRenderer frontDoorB;
	ModelRenderer frontDoorC;
	ModelRenderer backDoorA;
	ModelRenderer backDoorB;
	ModelRenderer backDoorC;
	ModelRenderer leftDoorA;
	ModelRenderer leftDoorB;
	ModelRenderer leftDoorC;
	ModelRenderer rightDoorA;
	ModelRenderer rightDoorB;
	ModelRenderer rightDoorC;
	ModelRenderer cornerBackLeft;
	ModelRenderer cornerBackRight;
	ModelRenderer cornerFrontLeft;
	ModelRenderer cornerFrontRight;

	public ModelOpenTrough()
	{
		textureWidth = 128;
		textureHeight = 128;

		base = new ModelRenderer(this, 0, 0);
		base.addBox(-4F, 0F, -4F, 8, 2, 8);
		base.setRotationPoint(0F, 22F, 0F);
		base.setTextureSize(64, 32);
		base.mirror = true;
		setRotation(base, 0F, 0F, 0F);
		leftBase = new ModelRenderer(this, 32, 0);
		leftBase.addBox(-4F, 0F, -4F, 4, 1, 8);
		leftBase.setRotationPoint(8F, 22F, 0F);
		leftBase.setTextureSize(64, 32);
		leftBase.mirror = true;
		setRotation(leftBase, 0F, 0F, 0F);
		leftBaseB = new ModelRenderer(this, 36, 10);
		leftBaseB.addBox(-4F, 0F, -3F, 4, 1, 6);
		leftBaseB.setRotationPoint(8F, 23F, 0F);
		leftBaseB.setTextureSize(64, 32);
		leftBaseB.mirror = true;
		setRotation(leftBaseB, 0F, 0F, 0F);
		rightBaseB = new ModelRenderer(this, 36, 10);
		rightBaseB.addBox(-4F, 0F, -3F, 4, 1, 6);
		rightBaseB.setRotationPoint(-4F, 23F, 0F);
		rightBaseB.setTextureSize(64, 32);
		rightBaseB.mirror = true;
		setRotation(rightBaseB, 0F, 0F, 0F);
		rightBase = new ModelRenderer(this, 32, 0);
		rightBase.addBox(-4F, 0F, -4F, 4, 1, 8);
		rightBase.setRotationPoint(-4F, 22F, 0F);
		rightBase.setTextureSize(64, 32);
		rightBase.mirror = true;
		setRotation(rightBase, 0F, 0F, 0F);
		frontBase = new ModelRenderer(this, 60, 6);
		frontBase.addBox(-3F, 0F, -4F, 6, 1, 4);
		frontBase.setRotationPoint(0F, 23F, -4F);
		frontBase.setTextureSize(64, 32);
		frontBase.mirror = true;
		setRotation(frontBase, 0F, 0F, 0F);
		frontBaseB = new ModelRenderer(this, 58, 0);
		frontBaseB.addBox(-4F, 0F, -4F, 8, 1, 4);
		frontBaseB.setRotationPoint(0F, 22F, -4F);
		frontBaseB.setTextureSize(64, 32);
		frontBaseB.mirror = true;
		setRotation(frontBaseB, 0F, 0F, 0F);
		backBase = new ModelRenderer(this, 58, 0);
		backBase.addBox(-4F, 0F, -4F, 8, 1, 4);
		backBase.setRotationPoint(0F, 22F, 8F);
		backBase.setTextureSize(64, 32);
		backBase.mirror = true;
		setRotation(backBase, 0F, 0F, 0F);
		backBaseB = new ModelRenderer(this, 60, 6);
		backBaseB.addBox(-3F, 0F, -4F, 6, 1, 4);
		backBaseB.setRotationPoint(0F, 23F, 8F);
		backBaseB.setTextureSize(64, 32);
		backBaseB.mirror = true;
		setRotation(backBaseB, 0F, 0F, 0F);
		frontA = new ModelRenderer(this, 0, 12);
		frontA.addBox(-4F, 0F, -4F, 2, 7, 4);
		frontA.setRotationPoint(0F, 15F, -4F);
		frontA.setTextureSize(64, 32);
		frontA.mirror = true;
		setRotation(frontA, 0F, 0F, 0F);
		frontB = new ModelRenderer(this, 0, 12);
		frontB.addBox(-4F, 0F, -4F, 2, 7, 4);
		frontB.setRotationPoint(6F, 15F, -4F);
		frontB.setTextureSize(64, 32);
		frontB.mirror = true;
		setRotation(frontB, 0F, 0F, 0F);
		backA = new ModelRenderer(this, 0, 12);
		backA.addBox(-4F, 0F, -4F, 2, 7, 4);
		backA.setRotationPoint(0F, 15F, 8F);
		backA.setTextureSize(64, 32);
		backA.mirror = true;
		setRotation(backA, 0F, 0F, 0F);
		backB = new ModelRenderer(this, 0, 12);
		backB.addBox(-4F, 0F, -4F, 2, 7, 4);
		backB.setRotationPoint(6F, 15F, 8F);
		backB.setTextureSize(64, 32);
		backB.mirror = true;
		setRotation(backB, 0F, 0F, 0F);
		rightA = new ModelRenderer(this, 13, 12);
		rightA.addBox(-8F, 0F, 0F, 4, 7, 2);
		rightA.setRotationPoint(0F, 15F, -4F);
		rightA.setTextureSize(64, 32);
		rightA.mirror = true;
		setRotation(rightA, 0F, 0F, 0F);
		rightB = new ModelRenderer(this, 13, 12);
		rightB.addBox(-8F, 0F, 6F, 4, 7, 2);
		rightB.setRotationPoint(0F, 15F, -4F);
		rightB.setTextureSize(64, 32);
		rightB.mirror = true;
		setRotation(rightB, 0F, 0F, 0F);
		leftB = new ModelRenderer(this, 13, 12);
		leftB.addBox(4F, 0F, 6F, 4, 7, 2);
		leftB.setRotationPoint(0F, 15F, -4F);
		leftB.setTextureSize(64, 32);
		leftB.mirror = true;
		setRotation(leftB, 0F, 0F, 0F);
		leftA = new ModelRenderer(this, 13, 12);
		leftA.addBox(4F, 0F, 0F, 4, 7, 2);
		leftA.setRotationPoint(0F, 15F, -4F);
		leftA.setTextureSize(64, 32);
		leftA.mirror = true;
		setRotation(leftA, 0F, 0F, 0F);
		centerA = new ModelRenderer(this, 27, 12);
		centerA.addBox(-4F, 0F, -4F, 2, 7, 2);
		centerA.setRotationPoint(6F, 15F, 6F);
		centerA.setTextureSize(64, 32);
		centerA.mirror = true;
		setRotation(centerA, 0F, 0F, 0F);
		centerB = new ModelRenderer(this, 27, 12);
		centerB.addBox(-4F, 0F, -4F, 2, 7, 2);
		centerB.setRotationPoint(6F, 15F, 0F);
		centerB.setTextureSize(64, 32);
		centerB.mirror = true;
		setRotation(centerB, 0F, 0F, 0F);
		centerC = new ModelRenderer(this, 27, 12);
		centerC.addBox(-4F, 0F, -4F, 2, 7, 2);
		centerC.setRotationPoint(0F, 15F, 0F);
		centerC.setTextureSize(64, 32);
		centerC.mirror = true;
		setRotation(centerC, 0F, 0F, 0F);
		centerD = new ModelRenderer(this, 27, 12);
		centerD.addBox(-4F, 0F, -4F, 2, 7, 2);
		centerD.setRotationPoint(0F, 15F, 6F);
		centerD.setTextureSize(64, 32);
		centerD.mirror = true;
		setRotation(centerD, 0F, 0F, 0F);
		frontDoorA = new ModelRenderer(this, 0, 25);
		frontDoorA.addBox(-4F, 0F, -4F, 4, 7, 2);
		frontDoorA.setRotationPoint(2F, 15F, -4F);
		frontDoorA.setTextureSize(64, 32);
		frontDoorA.mirror = true;
		setRotation(frontDoorA, 0F, 0F, 0F);
		frontDoorB = new ModelRenderer(this, 0, 25);
		frontDoorB.addBox(-4F, 0F, -4F, 4, 7, 2);
		frontDoorB.setRotationPoint(2F, 15F, -2F);
		frontDoorB.setTextureSize(64, 32);
		frontDoorB.mirror = true;
		setRotation(frontDoorB, 0F, 0F, 0F);
		frontDoorC = new ModelRenderer(this, 0, 25);
		frontDoorC.addBox(-4F, 0F, -4F, 4, 7, 2);
		frontDoorC.setRotationPoint(2F, 15F, 0F);
		frontDoorC.setTextureSize(64, 32);
		frontDoorC.mirror = true;
		setRotation(frontDoorC, 0F, 0F, 0F);
		backDoorA = new ModelRenderer(this, 0, 25);
		backDoorA.addBox(-4F, 0F, -4F, 4, 7, 2);
		backDoorA.setRotationPoint(2F, 15F, 10F);
		backDoorA.setTextureSize(64, 32);
		backDoorA.mirror = true;
		setRotation(backDoorA, 0F, 0F, 0F);
		backDoorB = new ModelRenderer(this, 0, 25);
		backDoorB.addBox(-4F, 0F, -4F, 4, 7, 2);
		backDoorB.setRotationPoint(2F, 15F, 8F);
		backDoorB.setTextureSize(64, 32);
		backDoorB.mirror = true;
		setRotation(backDoorB, 0F, 0F, 0F);
		backDoorC = new ModelRenderer(this, 0, 25);
		backDoorC.addBox(-4F, 0F, -4F, 4, 7, 2);
		backDoorC.setRotationPoint(2F, 15F, 6F);
		backDoorC.setTextureSize(64, 32);
		backDoorC.mirror = true;
		setRotation(backDoorC, 0F, 0F, 0F);
		leftDoorA = new ModelRenderer(this, 16, 24);
		leftDoorA.addBox(4F, 0F, 6F, 2, 7, 4);
		leftDoorA.setRotationPoint(2F, 15F, -8F);
		leftDoorA.setTextureSize(64, 32);
		leftDoorA.mirror = true;
		setRotation(leftDoorA, 0F, 0F, 0F);
		leftDoorB = new ModelRenderer(this, 16, 24);
		leftDoorB.addBox(4F, 0F, 6F, 2, 7, 4);
		leftDoorB.setRotationPoint(0F, 15F, -8F);
		leftDoorB.setTextureSize(64, 32);
		leftDoorB.mirror = true;
		setRotation(leftDoorB, 0F, 0F, 0F);
		leftDoorC = new ModelRenderer(this, 16, 24);
		leftDoorC.addBox(4F, 0F, 6F, 2, 7, 4);
		leftDoorC.setRotationPoint(-2F, 15F, -8F);
		leftDoorC.setTextureSize(64, 32);
		leftDoorC.mirror = true;
		setRotation(leftDoorC, 0F, 0F, 0F);
		rightDoorA = new ModelRenderer(this, 16, 24);
		rightDoorA.addBox(4F, 0F, 6F, 2, 7, 4);
		rightDoorA.setRotationPoint(-12F, 15F, -8F);
		rightDoorA.setTextureSize(64, 32);
		rightDoorA.mirror = true;
		setRotation(rightDoorA, 0F, 0F, 0F);
		rightDoorB = new ModelRenderer(this, 16, 24);
		rightDoorB.addBox(4F, 0F, 6F, 2, 7, 4);
		rightDoorB.setRotationPoint(-10F, 15F, -8F);
		rightDoorB.setTextureSize(64, 32);
		rightDoorB.mirror = true;
		setRotation(rightDoorB, 0F, 0F, 0F);
		rightDoorC = new ModelRenderer(this, 16, 24);
		rightDoorC.addBox(4F, 0F, 6F, 2, 7, 4);
		rightDoorC.setRotationPoint(-8F, 15F, -8F);
		rightDoorC.setTextureSize(64, 32);
		rightDoorC.mirror = true;
		setRotation(rightDoorC, 0F, 0F, 0F);
		cornerBackLeft = new ModelRenderer(this, 0, 37);
		cornerBackLeft.addBox(-4F, 0F, -4F, 4, 10, 4);
		cornerBackLeft.setRotationPoint(8F, 14F, 8F);
		cornerBackLeft.setTextureSize(64, 32);
		cornerBackLeft.mirror = true;
		setRotation(cornerBackLeft, 0F, 0F, 0F);
		cornerBackRight = new ModelRenderer(this, 0, 37);
		cornerBackRight.addBox(-4F, 0F, -4F, 4, 10, 4);
		cornerBackRight.setRotationPoint(-4F, 14F, 8F);
		cornerBackRight.setTextureSize(64, 32);
		cornerBackRight.mirror = true;
		setRotation(cornerBackRight, 0F, 0F, 0F);
		cornerFrontLeft = new ModelRenderer(this, 0, 37);
		cornerFrontLeft.addBox(-4F, 0F, -4F, 4, 10, 4);
		cornerFrontLeft.setRotationPoint(8F, 14F, -4F);
		cornerFrontLeft.setTextureSize(64, 32);
		cornerFrontLeft.mirror = true;
		setRotation(cornerFrontLeft, 0F, 0F, 0F);
		cornerFrontRight = new ModelRenderer(this, 0, 37);
		cornerFrontRight.addBox(-4F, 0F, -4F, 4, 10, 4);
		cornerFrontRight.setRotationPoint(-4F, 14F, -4F);
		cornerFrontRight.setTextureSize(64, 32);
		cornerFrontRight.mirror = true;
		setRotation(cornerFrontRight, 0F, 0F, 0F);
	}

	public void render(boolean[] side, boolean stone)
	{
		if (side != null)
		{
			renderMiddle(!side[0], stone);
			renderBack(side[2] ? PipeType.NORMAL : stone ? PipeType.SOLID : PipeType.MID_CAP);
			renderFront(side[3] ? PipeType.NORMAL : stone ? PipeType.SOLID : PipeType.MID_CAP);
			renderRight(side[4] ? PipeType.NORMAL : stone ? PipeType.SOLID : PipeType.MID_CAP);
			renderLeft(side[5] ? PipeType.NORMAL : stone ? PipeType.SOLID : PipeType.MID_CAP);
		}
	}

	public void renderMiddle(boolean bottom, boolean corners)
	{
		if (bottom)
			base.render(0.0625F);
		centerA.render(0.0625F);
		centerB.render(0.0625F);
		centerC.render(0.0625F);
		centerD.render(0.0625F);
		if (corners)
		{
			cornerBackLeft.render(0.0625F);
			cornerBackRight.render(0.0625F);
			cornerFrontLeft.render(0.0625F);
			cornerFrontRight.render(0.0625F);
		}
	}

	public void renderLeft(PipeType type)
	{
		if (type != PipeType.MID_CAP)
		{
			leftBase.render(0.0625F);
			leftBaseB.render(0.0625F);
			leftB.render(0.0625F);
			leftA.render(0.0625F);
			if (type == PipeType.CAP || type == PipeType.SOLID)
			{
				leftDoorA.render(0.0625F);
				if (type == PipeType.SOLID)
				{
					leftDoorB.render(0.0625F);
					leftDoorC.render(0.0625F);
				}
			}
		}
		else
		{
			leftDoorC.render(0.0625F);
		}
	}

	public void renderRight(PipeType type)
	{
		if (type != PipeType.MID_CAP)
		{
			rightBaseB.render(0.0625F);
			rightBase.render(0.0625F);
			rightA.render(0.0625F);
			rightB.render(0.0625F);
			if (type == PipeType.CAP || type == PipeType.SOLID)
			{
				rightDoorA.render(0.0625F);
				if (type == PipeType.SOLID)
				{
					rightDoorB.render(0.0625F);
					rightDoorC.render(0.0625F);
				}
			}
		}
		else
		{
			rightDoorC.render(0.0625F);
		}
	}

	public void renderBack(PipeType type)
	{
		if (type != PipeType.MID_CAP)
		{
			backBase.render(0.0625F);
			backBaseB.render(0.0625F);
			backA.render(0.0625F);
			backB.render(0.0625F);
			if (type == PipeType.CAP || type == PipeType.SOLID)
			{
				backDoorA.render(0.0625F);
				if (type == PipeType.SOLID)
				{
					backDoorB.render(0.0625F);
					backDoorC.render(0.0625F);
				}
			}
		}
		else
		{
			backDoorC.render(0.0625F);
		}
	}

	public void renderFront(PipeType type)
	{
		if (type != PipeType.MID_CAP)
		{
			frontBase.render(0.0625F);
			frontBaseB.render(0.0625F);
			frontA.render(0.0625F);
			frontB.render(0.0625F);
			if (type == PipeType.CAP || type == PipeType.SOLID)
			{
				frontDoorA.render(0.0625F);
				if (type == PipeType.SOLID)
				{
					frontDoorB.render(0.0625F);
					frontDoorC.render(0.0625F);
				}
			}
		}
		else
		{
			frontDoorC.render(0.0625F);
		}
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public static enum PipeType
	{
		/** When there is no connection */
		MID_CAP,
		/** Pipe to pipe connection */
		NORMAL,
		/** Pipe to wall */
		CAP,
		/** No pipe, used only by stone through */
		SOLID;
	}
}