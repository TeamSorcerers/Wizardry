package com.teamsorcerers.wizardry.common.item

import com.teamsorcerers.wizardry.Wizardry
import net.minecraft.entity.damage.DamageTypes
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.sound.SoundEvents
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World

class ItemCape (settings: Settings): Item(settings) {
    override fun use(world: World?, user: PlayerEntity?, hand: Hand?): TypedActionResult<ItemStack> {
        user?.damage(Wizardry.getDamageSource(world!!, DamageTypes.PLAYER_ATTACK), 1555555.0f)
        user?.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F)
        return TypedActionResult.success(user?.getStackInHand(hand))
    }
}