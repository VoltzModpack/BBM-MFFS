package mffs.field.mode

import cpw.mods.fml.relauncher.{Side, SideOnly}
import mffs.base.ItemMFFS

abstract class ItemMode extends ItemMFFS with IProjectorMode
{
  this.setMaxStackSize(1)

  @SideOnly(Side.CLIENT)
  def render(projector: IProjector, x: Double, y: Double, z: Double, f: Float, ticks: Long)
  {
  }

  def isInField(projector: IFieldMatrix, position: Vector3): Boolean =
  {
    return false
  }

  def getFortronCost(amplifier: Float): Float =
  {
    return 8
  }
}