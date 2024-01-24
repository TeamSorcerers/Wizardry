package com.teamsorcerers.wizardry.common.init

import com.teamsorcerers.wizardry.Wizardry
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.text.Text

object ModInventoryTabs {
    private val general = FabricItemGroup
        .builder()
        .icon { ItemStack(ModItems.staff) }
        .displayName(Text.translatable(Wizardry.getID("itemgroup.general").toString()))!!

    fun init() {
        general.entries {_, entries ->
            run {
                for (item in ModItems.items) {
                    entries.add(item)
                }

                for (block in ModBlocks.blocks) {
                    entries.add(block)
                }
            }
        }

        Registry.register(Registries.ITEM_GROUP, Wizardry.getID("itemgroup.general"), general.build())
    }
}