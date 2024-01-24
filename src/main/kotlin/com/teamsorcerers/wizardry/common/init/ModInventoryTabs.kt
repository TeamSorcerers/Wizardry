package com.teamsorcerers.wizardry.common.init

import com.teamsorcerers.wizardry.Wizardry
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.text.Text

object ModInventoryTabs {
    val general = FabricItemGroup
        .builder()
        .icon { ItemStack(ModItems.staff) }
        .displayName(Text.translatable(Wizardry.getID("itemgroup.general").toString()))
        .entries {_, groupEntries ->
            run {
                for (item in ModItems.items) {
                    groupEntries.add(item)
                }
            }
        }
        .build()
    fun init() {
        Registry.register(Registries.ITEM_GROUP, Wizardry.getID("itemgroup.general"), general)
    }
}