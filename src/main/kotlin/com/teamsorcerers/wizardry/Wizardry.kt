package com.teamsorcerers.wizardry

import com.teamsorcerers.wizardry.common.init.ModItems
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.api.ModInitializer
import net.minecraft.util.Identifier
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Wizardry {
	companion object {
		const val MOD_ID = "wizardry"
		val logger: Logger = LoggerFactory.getLogger(MOD_ID)

		fun getID(path: String): Identifier {
			return Identifier(MOD_ID, path)
		}
	}

	object CommonInitializer : ModInitializer {
		override fun onInitialize() {
			logger.info("IT'S LEVI-OH-SA, NOT LEVIOSAA")

			ModItems.init()
		}
	}

	object ClientInitializer : ClientModInitializer {
		override fun onInitializeClient() {
			//TODO("Not yet implemented")
		}

	}
}