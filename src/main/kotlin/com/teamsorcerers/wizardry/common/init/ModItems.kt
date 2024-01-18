package com.teamsorcerers.wizardry.common.init

import com.teamsorcerers.wizardry.Wizardry
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Rarity

object ModItems {
    //val staff = Item(FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON))
    fun init() {
        Wizardry.logger.info("Registering " + Wizardry.MOD_ID + " items")

        //register("staff", staff)
    }

    private fun register(name: String, item: Item): Item {
        return Registry.register(Registries.ITEM, Wizardry.getID(name), item)
    }
}