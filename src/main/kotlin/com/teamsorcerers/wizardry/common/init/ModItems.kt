package com.teamsorcerers.wizardry.common.init

import com.teamsorcerers.wizardry.Wizardry
import com.teamsorcerers.wizardry.common.item.ItemBook
import com.teamsorcerers.wizardry.common.item.ItemCape
import com.teamsorcerers.wizardry.common.item.ItemPearlBelt
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
    val items = mutableListOf<Item>()

    val staff = ItemStaff(
        FabricItemSettings()
            .maxCount(1)
            .rarity(Rarity.UNCOMMON)
    )

    val book = ItemBook(
        FabricItemSettings()
            .maxCount(1)
            .rarity(Rarity.UNCOMMON)
    )
    val pearlBelt = ItemPearlBelt(
        FabricItemSettings()
            .maxCount(1)
            .rarity(Rarity.UNCOMMON)
    )
    val cape = ItemCape(
        FabricItemSettings()
            .maxCount(1)
            .rarity(Rarity.UNCOMMON)
    )

    fun init() {
        registerItem("staff", staff)
        registerItem("book", book)
        registerItem("pearl_belt", pearlBelt)
        registerItem("cape", cape)
    }

    fun registerItem(name: String, item: Item): Item {
        val registeredItem = Registry.register(Registries.ITEM, Wizardry.getID(name), item)
        items.add(registeredItem)
        return registeredItem
    }
}