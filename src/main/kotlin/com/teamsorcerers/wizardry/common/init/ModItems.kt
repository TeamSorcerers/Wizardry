package com.teamsorcerers.wizardry.common.init

import com.teamsorcerers.wizardry.Wizardry
import com.teamsorcerers.wizardry.common.item.ItemStaff
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import net.minecraft.util.Rarity

object ModItems {
    private val items = mutableListOf<Item>()

    val staff = registerItem("staff", ItemStaff(FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON)))

    fun init() {
        createInvTab(Wizardry.getID("itemgroup"), staff, items)
    }

    private fun createInvTab(id: Identifier, icon: Item, entries: MutableList<Item>) {
        val group = FabricItemGroup
            .builder()
            .icon { ItemStack(icon) }
            .displayName(Text.translatable(id.toString()))
            .entries {_, groupEntries ->
                run {
                    for (item in entries) {
                        groupEntries.add(item)
                    }
                }
            }
            .build()

        Registry.register(Registries.ITEM_GROUP, id, group)
    }

    private fun registerItem(name: String, item: Item): Item {
        val item = Registry.register(Registries.ITEM, Wizardry.getID(name), item)
        items.add(item)
        return item
    }
}