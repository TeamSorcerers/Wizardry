package com.teamsorcerers.wizardry.common.init

import com.teamsorcerers.wizardry.Wizardry
import com.teamsorcerers.wizardry.common.block.BlockNacre
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry

object ModBlocks {
    val blocks = mutableListOf<Block>()

    val nacre = BlockNacre(
        FabricBlockSettings
            .create()
            .strength(4.0f)
    )

    fun init() {
        registerBlock("nacre_block", nacre)
        registerBlock("cloud_block", cloud)
    }

    private fun registerBlock(name: String, block: Block, blockItem: Boolean = true): Block {
        var id = Wizardry.getID(name)
        val registeredBlock = Registry.register(Registries.BLOCK, id, block)

        if (blockItem) {
            Registry.register(Registries.ITEM, id, BlockItem(block, Item.Settings()))
        }

        blocks.add(registeredBlock)

        return registeredBlock
    }
}