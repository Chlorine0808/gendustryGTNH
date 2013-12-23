/*
 * Copyright (c) bdew, 2013
 * https://github.com/bdew/gendustry
 *
 * This mod is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://raw.github.com/bdew/gendustry/master/MMPL-1.0.txt
 */

package net.bdew.gendustry.config

import net.minecraftforge.common.Configuration
import java.io.File
import net.bdew.lib.config.IdManager
import net.bdew.lib.gui.GuiHandler

object Config {
  var neiAddSamples = false
  var IDs: IdManager = null
  val guiHandler = new GuiHandler

  def load(cfg: File) {
    val c = new Configuration(cfg)
    c.load()

    try {
      neiAddSamples = c.get("NEI", "Add samples", true).getBoolean(false)
      IDs = new IdManager(c, 15000, 3500)
      Fluids.load()
      Blocks.load()
      Items.load()
      Machines.load()
    } finally {
      c.save()
    }

  }
}