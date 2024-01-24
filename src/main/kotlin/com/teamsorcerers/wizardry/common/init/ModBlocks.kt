package com.teamsorcerers.wizardry.common.init

import com.teamsorcerers.wizardry.Wizardry
import com.teamsorcerers.wizardry.common.block.BlockNacre
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.item.BlockItem
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
        ModItems.registerItem("nacre_block", BlockItem(nacre, FabricItemSettings()))
    }

    private fun registerBlock(name: String, block: Block): Block {
        val registeredBlock = Registry.register(Registries.BLOCK, Wizardry.getID(name), block)
        blocks.add(registeredBlock)
        return registeredBlock
    }
}